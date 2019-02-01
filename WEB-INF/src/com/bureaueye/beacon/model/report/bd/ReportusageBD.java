package com.bureaueye.beacon.model.report.bd;

import java.util.Calendar;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.report.Reportusage;
import com.bureaueye.beacon.model.standard.User;







/**
 *
 * Amendments
 * ----------
 *									
 */
public final class ReportusageBD  extends BaseBD {

	// constructors
	public ReportusageBD() {
	}
	public ReportusageBD(SessionFactory _factory) {
		super(_factory);		
	}
	public ReportusageBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public ReportusageBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}


	private static final String DEFAULT_CLASS_NAME = Reportusage.class.getName();
	
	

	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Reportusage read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		Reportusage dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {

			dao = (Reportusage)session.get(Reportusage.class, (Integer)key);

		} catch (HibernateException e) {
			// Any other error should result in a SystemException
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}


		// close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		return dao;

	}

	
	public void createOrUpdate(Object dao, User user)
	throws ApplicationException {

		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);			
		}


		try {
			Reportusage _dao=(Reportusage)dao;
			Transaction tx = session.beginTransaction();

			if (read(_dao.getReportusageId()) != null) {
				session.update(dao);
			} else {
				Calendar c = Calendar.getInstance();
				_dao.setCreatedate(c.getTime());
				_dao.setCreatetime(""
						+ ((c.getTimeInMillis() % (Constants.MILLISECONDS_PER_DAY)) / 1000));
				_dao.setCreateuserid(user.getUserid());
				session.save(dao);
			}

			tx.commit();			
		} catch (HibernateException e) {	
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

		//		close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

	}


	public void delete(Object dto, User user) throws ApplicationException {
	}	



	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------

	
	
}
