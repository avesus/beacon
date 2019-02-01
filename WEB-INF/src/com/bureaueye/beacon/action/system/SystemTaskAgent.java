package com.bureaueye.beacon.action.system;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.system.SystemX;
import com.bureaueye.beacon.model.system.Systemtask;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemXBD;
import com.bureaueye.beacon.model.system.bd.SystemtaskBD;




/*
 * Threaded Scheduled tasks Agent
 */

/**
 *
 * Amendments
 * ----------
 * 
 */
public class SystemTaskAgent extends Thread implements ServletContextListener {


	// ----------------------------------------------------- Instance Variables

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);

	protected boolean _done = false;
	protected ServletContext _context = null;

	private MessageResources resources = MessageResources.getMessageResources(Constants.APPLICATION_RESOURCES);

	// ------------------------------------------------------ Protected Methods

	/** */
	public SystemTaskAgent() 
	{

	}


	/** */
	public void contextDestroyed(ServletContextEvent sce)
	{	
		_done = true;
	}


	/** */
	public void contextInitialized(ServletContextEvent sce)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("["+this.getClass().getName()+"] Started at: "+cal.getTime());	
		_context = sce.getServletContext();			
		new SystemTaskAgent().start();
	}


	@SuppressWarnings("unchecked")
	public void run()
	{
		setName(this.getClass().getName());
		User user = new User();

		Map<String, SessionFactory> sessionFactoryClusterMap = new HashMap<String, SessionFactory>();		
		// build hibernate session factorys
		try {
			// build hibernate session factorys
			String hibernateConfigPath="/hibernate.cfg.xml";
			SessionFactory sessionFactoryCluster = new Configuration().configure(hibernateConfigPath).buildSessionFactory();	
			sessionFactoryClusterMap.put(hibernateConfigPath,sessionFactoryCluster);
		} catch (MappingException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster1: MappingException: "+e.getMessage());			
		} catch (HibernateException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster1: HibernateException: "+e.getMessage());    	  		
		} catch (Exception x) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster1: Exception: " + x.getMessage());				
		}
		// build hibernate session factorys
		try {
			// build hibernate session factorys
			String hibernateConfigPath="/hibernate.cfg.cluster2.xml";
			SessionFactory sessionFactoryCluster = new Configuration().configure(hibernateConfigPath).buildSessionFactory();	
			sessionFactoryClusterMap.put(hibernateConfigPath,sessionFactoryCluster);
		} catch (MappingException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster2: MappingException: "+e.getMessage());			
		} catch (HibernateException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster2: HibernateException: "+e.getMessage());    	  		
		} catch (Exception x) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster2: Exception: " + x.getMessage());				
		}
		// build hibernate session factorys
		try {
			// build hibernate session factorys
			String hibernateConfigPath="/hibernate.cfg.cluster3.xml";
			SessionFactory sessionFactoryCluster = new Configuration().configure(hibernateConfigPath).buildSessionFactory();	
			sessionFactoryClusterMap.put(hibernateConfigPath,sessionFactoryCluster);
		} catch (MappingException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster3: MappingException: "+e.getMessage());			
		} catch (HibernateException e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster3: HibernateException: "+e.getMessage());    	  		
		} catch (Exception x) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sessionFactoryCluster3: Exception: " + x.getMessage());				
		}




		// init business delegates
		SystemXBD systemxbd = new SystemXBD(sessionFactoryClusterMap);
		SystemtaskBD systemtaskbd = new SystemtaskBD(sessionFactoryClusterMap);


		//on systemtask agent startup make sure all tasks are not in RUNNING status
		try {
			List<Systemtask> systemTasks = null;
			ListForm listForm = new ListForm();
			listForm.setSearchString1("");			
			listForm.setOrderBy("Nextrun");
			listForm.setOrderByDesc("");
			systemTasks = systemtaskbd.findSystemtasksBySearch(listForm);		
			if (systemTasks != null) {
				// Define Iterator and define Start position
				Iterator<Systemtask> it = systemTasks.iterator();
				while (it.hasNext()) {
					Systemtask dao = (Systemtask)it.next();
					log.info(
							"["+this.getClass().getName()+"] "+new java.util.Date()+ 
							" CHECK "+dao.getTaskid()+
							" IS RUNNING "
					);							
					if (dao.getTaskstatus().equals(com.bureaueye.beacon.bean.Constants.RUNNING_STATUS)) {
						log.info(
								"["+this.getClass().getName()+"] "+new java.util.Date()+ 
								" "+dao.getTaskid()+
								" IS RUNNING - CLEAR STATUS"
						);						
						dao.setTaskstatus("");//clear status		
						try {
							systemtaskbd.createOrUpdate(dao,user);
						} catch (ApplicationException ae) {
							log.error(
									"["+this.getClass().getName()+"] "+new java.util.Date()+ 
									" SystemtaskBD.createOrUpdate: ApplicationException: "+
									ae.getMessage()
							);							
						}
					}
				}
			}
			listForm=null;
			systemTasks=null;
		} catch (Exception e) {}




		while(!_done) {


			// check task is scheduled
			List<Systemtask> systemTasks = null;
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());


			// check task is scheduled
			SystemX system = null;
			try {
				system = systemxbd.findSystem();
			} catch (Exception e) {}
			if (system != null) {
				if (system.getSystemtaskstop().equals("Y")) {
					_done = true;
				}
			}



			if (!_done) {	

				try {
					systemTasks = systemtaskbd.findSystemtaskByNextRunDateTime(cal.getTimeInMillis());
				} catch (Exception e) {}

				if (systemTasks != null) {
					// Define Iterator and define Start position
					Iterator<Systemtask> it = systemTasks.iterator();
					while (it.hasNext()) {
						Systemtask dao = (Systemtask)it.next();

						// check task is not running
						if (
								dao.getTaskstatus().equals(com.bureaueye.beacon.bean.Constants.RUNNING_STATUS) 
						) {
							log.info(
									"["+this.getClass().getName()+"] "+new java.util.Date()+ 
									" "+dao.getTaskid()+":"+
									" TASK IS ALREADY RUNNING"
							);
						} else {


							dao.setTaskstatus(com.bureaueye.beacon.bean.Constants.RUNNING_STATUS);
							try {
								systemtaskbd.createOrUpdate(dao,user);
							} catch (ApplicationException ae) {
								log.error(
										"["+this.getClass().getName()+"] "+new java.util.Date()+ 
										" SystemtaskBD.createOrUpdate: ApplicationException: "+
										ae.getMessage()
								);							
							}


							// start task using class
							try {							
								Class taskClass = Class.forName(dao.getTaskclass());
								Class partypes[] = new Class[1];
								partypes[0] = Map.class;
								Constructor taskConstructor = taskClass.getConstructor(partypes);
								Object arglist[] = new Object[1];
								arglist[0] = sessionFactoryClusterMap;

								// initialise method 
								Method method = taskClass.getDeclaredMethod("run");
								// invoke method
								method.invoke(taskConstructor.newInstance(arglist));	
							} catch (ClassNotFoundException x) {
								log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" task start: ClassNotFoundException: " + x.getMessage());
							} catch (NoSuchMethodException x) {
								log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" task start: NoSuchMethodException: " + x.getMessage());
							} catch (IllegalAccessException x) {
								log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" task start: IllegalAccessException: " + x.getMessage());
							} catch (InvocationTargetException x) {
								log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" task start: InvocationTargetException: " + x.getMessage());							
							} catch (Exception x) {	
								log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" task start: Exception: " + x.getMessage());
							}


							// update last and next run date/time
							Calendar cal2 = Calendar.getInstance();
							cal2.setTimeInMillis(cal.getTimeInMillis());
							Long nextRun=dao.getNextrun();
							Date nextRunDate=dao.getNextrundate();
							String nextRunTime=dao.getNextruntime();
							dao.setLastrun(nextRun);
							dao.setLastrundate(nextRunDate);
							dao.setLastruntime(nextRunTime);


							if (dao.getRunatperiod1().equals("MINUTE")) {
								cal2.setTimeInMillis(cal.getTimeInMillis());
								try{
									cal2.add(Calendar.MINUTE,new Integer(dao.getRunatperiod2()).intValue());
								} catch (Exception e) {
									log.error(
											"["+this.getClass().getName()+"] "+new java.util.Date()+ 
											" set MINUTE: Format Exception: "+
											e.getMessage()
									);								
								}
							}


							if (dao.getRunatperiod1().equals("HOUR")) {
								cal2.setTimeInMillis(cal.getTimeInMillis());
								try{
									cal2.add(Calendar.HOUR_OF_DAY,new Integer(dao.getRunatperiod2()).intValue());
								} catch (Exception e) {
									log.error(
											"["+this.getClass().getName()+"] "+new java.util.Date()+ 
											" set HOUR: Format Exception: "+
											e.getMessage()
									);								
								}
							}	

							if (dao.getRunatperiod1().equals("DAY")) {
								int count = 0;
								while (true) {
									count++;
									if (count > 7) break;
									cal2.set(
											cal2.get(Calendar.YEAR), 
											cal2.get(Calendar.MONTH), 
											cal2.get(Calendar.DAY_OF_MONTH)+1, 
											dao.getRunathour().intValue(), 
											dao.getRunatminute().intValue(),
											0
									);
									String day = new Integer(cal2.get(Calendar.DAY_OF_WEEK)).toString();
									// Runatperiod2 list - SUNDAY=1, MONDAY=2, TUESDAY=3.....SATURDAY=7
									log.debug("["+this.getClass().getName()
											+"] DAY_OF_WEEK - "
											+cal2.get(Calendar.DAY_OF_WEEK)+" "+
											"dao.getRunatperiod2().indexOf(day) - "+
											dao.getRunatperiod2().indexOf(day));							
									if (dao.getRunatperiod2().indexOf(day) > -1) break;
								}
							}

							if (dao.getRunatperiod1().equals("WEEK")) {
								cal2.set(
										cal2.get(Calendar.YEAR), 
										cal2.get(Calendar.MONTH), 
										cal2.get(Calendar.DAY_OF_MONTH)+7, 
										dao.getRunathour().intValue(), 
										dao.getRunatminute().intValue(),
										0
								);
							}

							if (dao.getRunatperiod1().equals("MONTH")) {
								cal2.set(
										cal2.get(Calendar.YEAR), 
										cal2.get(Calendar.MONTH)+1, 
										//cal2.get(Calendar.DAY_OF_MONTH),
										new Integer(dao.getRunatperiod2()).intValue(),//each month on same day i.e. 1st=01
										dao.getRunathour().intValue(), 
										dao.getRunatminute().intValue(),
										0
								);
							}	

							dao.setNextrun(new Long(cal2.getTimeInMillis()));
							dao.setNextrundate(cal2.getTime());
							dao.setNextruntime(com.bureaueye.beacon.util.Util.toTime(cal2));
							dao.setTaskstatus("");

							try {
								systemtaskbd.createOrUpdate(dao,user);
							} catch (ApplicationException ae) {
								log.error(
										"["+this.getClass().getName()+"] "+new java.util.Date()+ 
										" SystemtaskBD.createOrUpdate: ApplicationException: "+
										ae.getMessage()
								);							
							}

						} // task is running check

					} // loop system tasks

				} // systemtasks found 


				log.info(
						this.getClass().getName()+
						": Current Time: "+cal.getTime()+
						" TimeInMillis: "+cal.getTimeInMillis()+
						" alive threads[]: "+getThreadNames().length 
				);	



				int _sleep = 360*1000; // 1 sec = 1000 milli-secs
				try { 
					_sleep = system.getSystemtaskagentsleep().intValue();
				} catch (Exception e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+" sleep: Exception: "+e.getMessage());	
				}
				try { 
					log.info("["+this.getClass().getName()+"] "+new java.util.Date()+ " sleep for "+_sleep);					
					sleep(_sleep); // wait for 3600 seconds (1 hour)  
				} catch(InterruptedException e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+ " sleep: InterruptedException: "+e.getMessage());											
				} // per hour

			} // check done

		} // main process loop


		// clean-up business delegates
		systemxbd = null;
		systemtaskbd = null;


		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("["+this.getClass().getName()+"] Stopping at: "+cal.getTime());		

	}



	//	Initialize global variables
	public void init(ServletConfig config) throws ServletException {

	}



	void println(String s) { System.out.println(s); }


	public static String[] getThreadNames() {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ThreadGroup parent = null;
		while ( (parent = group.getParent()) != null ) {
			group = parent;
		}
		Thread[] threads = new Thread[group.activeCount()];
		group.enumerate(threads);
		java.util.HashSet set = new java.util.HashSet();
		for (int i=0; i < threads.length; ++i) {
			if (threads[i] != null && threads[i].isAlive()) {
				try {
					set.add(threads[i].getThreadGroup().getName()+","
							+threads[i].getName()+","
							+threads[i].getPriority());

					log.debug(
							" alive threads["+i+"]: "+
							threads[i].getThreadGroup().getName()+","+
							threads[i].getName()+","+
							threads[i].getPriority()
					);	

				} catch (Throwable e) {e.printStackTrace();}
			}
		}
		String[] result = (String[]) set.toArray(new String[0]);
		java.util.Arrays.sort(result);
		return result;
	} 



}






