package com.bureaueye.beacon.model.system.bd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.Systemlog;
import com.bureaueye.beacon.model.system.Systemlogconfig;


public final class SystemlogBD extends BaseBD {
	
	
	SessionFactory _factory;
	
	// constructors
	public SystemlogBD() {
	}
	public SystemlogBD(SessionFactory _factory) {
		this.setSessionFactory1(_factory);		
	}
	public SystemlogBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	

    private static final String DEFAULT_CLASS_NAME = Systemlog.class.getName();

        
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	@Override
	public Systemlog read(Object key)
	throws ApplicationException {
		return null;
	}
	
	
	@Override
	public void createOrUpdate(Object dto, User user)
	throws ApplicationException {
	}
	
	
	@Override
	public void delete(Object dto, User user) throws ApplicationException {
	}


	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public void createSystemlog(Object obj, User user, String action)
	throws ApplicationException {
		
		
		String _systemlog = "no";
		try {
			PropertyResourceBundle props = 
				(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
			_systemlog=props.getString ("systemlog");
		} catch (Exception e) {}			
		if (_systemlog.equals("no")) return;

		
		try {
			
			// check logging required
			Systemlogconfig _systemlogconfig = new SystemlogconfigBD()
			.findSystemlogconfigByKey2(
					obj.getClass().getName(),
					action
			);
			
			if (_systemlogconfig != null && _systemlogconfig.isFlag()) {
				
				// get Session 
				Session session = null;
				try {
					session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
				} catch (HibernateException e) {
					throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);			
				}
				
				
				Systemlog systemlog = new Systemlog();
				// init variables
				systemlog.setRecordobjectclass(obj.getClass().getName());
				systemlog.setUserid(user.getUserid());
				systemlog.setLogtimestamp(Calendar.getInstance().getTime());
				systemlog.setAction(action);
				
				Object data = obj;
				// create an output stream
				ByteArrayOutputStream b = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(b);
				// write the object to it
				out.writeObject(data);
				// convert it to a byte array
				systemlog.setRecordobjectdata(b.toByteArray());
				
				
				try {
					Transaction tx = session.beginTransaction();
					
						session.save(systemlog);

					tx.commit();			
				} catch (HibernateException e) {	
					throw new ApplicationException(
							ApplicationException.ROW_NOT_CREATED_UPDATED);
				}
				
				
				
				// close Session 	
				try {
					session.close();
				}	
				catch (HibernateException e) {
					throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);
				}
				
			}
			
		} catch (IOException ioe) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		} catch (HibernateException e) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}
	
		
	}
}
