package com.bureaueye.beacon.model.report.bd;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.report.Reportworktable;
import com.bureaueye.beacon.model.report.dto.ReportworktableDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-01 WSI-201312-0001 BEACON LAKER (WSI LINER) - Sales Report
 * 
 */
public final class ReportworktableBD extends BaseBD {

	// constructors
	public ReportworktableBD() {
	}

	public ReportworktableBD(SessionFactory _factory) {
		super(_factory);
	}

	public ReportworktableBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);
	}

	public ReportworktableBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Reportworktable.class
			.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Reportworktable read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Reportworktable dao = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dao = (Reportworktable) session.get(Reportworktable.class,
					(Integer) key);

		} catch (HibernateException e) {
			// Any other error should result in a SystemException
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		return dao;

	}

	public void createOrUpdate(Object dao, User user)
			throws ApplicationException {

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

		try {
			Reportworktable _dao = (Reportworktable) dao;
			Transaction tx = session.beginTransaction();

			if (read(_dao.getReportworktableId()) != null) {
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

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

	}

	public void delete(Object dao, User user) throws ApplicationException {

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}

		try {
			Reportworktable _dao = (Reportworktable) dao;

			Transaction tx = session.beginTransaction();
			session.delete(_dao);
			tx.commit();

			new SystemlogBD(this.getSessionFactoryClusterMap())
					.createSystemlog(_dao, user, "delete");
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}

	public void clearByReportkey(String key, User user)
			throws ApplicationException {

		if (key == null) {
			return;
		}

		try {
			List<Reportworktable> set = findReportworktablesByReportkey(key);
			for (Iterator<Reportworktable> it = set.iterator(); it.hasNext();) {
				new ReportworktableBD().delete((Reportworktable) it.next(),
						user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}

	// -----------------------------------------------
	// BUSINESS METHODS
	// -----------------------------------------------
	public List<Reportworktable> findReportworktablesByReportkey(String key)
			throws ApplicationException {

		List<Reportworktable> queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			String queryString = "";
			queryString = "select reportworktable"
					+ " from com.bureaueye.beacon.model.report.Reportworktable reportworktable"
					+ " where" + " reportworktable.Reportkey LIKE '%" + key
					+ "%'";

			queryResult = session.createQuery(queryString).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryResult;
	}

	public List<ReportworktableDTO> salesReportGroup(ListForm listForm) throws ApplicationException {

		List queryResult = null;
		List<ReportworktableDTO> queryResultDTO = new LinkedList<ReportworktableDTO>();
		DateFormatter dateFormatter = new DateFormatter();

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			SQLQuery query = null;
			String queryString = "select "
					+ "reportworktable.Field1, reportworktable.Field2, "
					+ "reportworktable.Field3, reportworktable.Field4, "
					+ "reportworktable.Field5, reportworktable.Field6, reportworktable.Field7, "
					+ "sum(reportworktable.Field31) as freightsum, sum(reportworktable.Field41) as teusum "
					+ " from Reportworktable reportworktable" + " where"
					+ " reportworktable.Reportkey = '"
					+ listForm.getSearchString10() + "'"
					+ " and reportworktable.Field21 between '"
					+ dateFormatter.format(listForm.getSearchDate1())
					+ "' and '"
					+ dateFormatter.format(listForm.getSearchDate2()) + "'";

			queryString = queryString
					+ " group by "
					+ "reportworktable.Field1, reportworktable.Field2, "
					+ "reportworktable.Field3, reportworktable.Field4, "
					+ "reportworktable.Field5, reportworktable.Field6, reportworktable.Field7";

			query = session.createSQLQuery(queryString);
			queryResult = query.list();

			Iterator it = queryResult.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				String field1 = "";
				String field2 = "";
				String field3 = "";
				String field4 = "";
				String field5 = "";
				String field6 = "";
				String field7 = "";					   
				String sum1 = "";
				String sum2 = "";
				try {
					field1 = (String) obj[0];
					field2 = (String) obj[1];
					field3 = (String) obj[2];
					field4 = (String) obj[3];
					field5 = (String) obj[4];
					field6 = (String) obj[5];
					field7 = (String) obj[6];		
					sum1 = obj[8].toString();
					sum2 = obj[7].toString();
				} catch (Exception e) {				
				}
				try {
					ReportworktableDTO dto = new ReportworktableDTO(field1,
							field2, field3, field4, field5, field6, field7,
							sum1, sum2);

					queryResultDTO.add(dto);
				} catch (Exception e) {
				}

			}

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryResultDTO;
	}

	public List<ReportworktableDTO> salesReportOrder(ListForm listForm) throws ApplicationException {

		List<ReportworktableDTO> queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			String queryString = "";
			queryString = "select new com.bureaueye.beacon.model.report.dto.ReportworktableDTO ("
					+ "reportworktable.Field1, reportworktable.Field2, "
					+ "reportworktable.Field3, reportworktable.Field4, "
					+ "reportworktable.Field5, reportworktable.Field6, reportworktable.Field7, "
					+ "reportworktable.Field41, reportworktable.Field31"
					+ ")"
					+ " from com.bureaueye.beacon.model.report.Reportworktable reportworktable"
					+ " where"
					+ " reportworktable.Reportkey = '"
					+ listForm.getSearchString10() + "'";

			queryString = queryString
					+ " order by "
					+ "reportworktable.Field1, reportworktable.Field2, "
					+ "reportworktable.Field3, reportworktable.Field4, "
					+ "reportworktable.Field5, reportworktable.Field6, reportworktable.Field41 DESC";

			queryResult = session.createQuery(queryString).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryResult;
	}

	public Reportworktable findSalesReportMTD(String key1, String key2,
			String key3, String key4, String key5, String key6, String key7,
			String key8) throws ApplicationException {

		Reportworktable queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			queryResult = (Reportworktable) session
					.createCriteria(Reportworktable.class)
					.add(Expression.eq("Reportkey", key1))
					.add(Expression.eq("Field1", key2))// company
					.add(Expression.eq("Field2", key3))// direction
					.add(Expression.eq("Field3", key4))// accrep
					.add(Expression.eq("Field4", key5))// customer
					.add(Expression.eq("Field5", key6))// service
					.add(Expression.eq("Field6", key7))// commission
					.add(Expression.eq("Field7", key8))// shipper
					.setMaxResults(1).uniqueResult();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryResult;
	}

}
