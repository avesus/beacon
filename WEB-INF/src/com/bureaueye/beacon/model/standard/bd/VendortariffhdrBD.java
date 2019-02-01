package com.bureaueye.beacon.model.standard.bd;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.quotation.VendortariffLineItem;
import com.bureaueye.beacon.form.standard.ListVendortariffhdrForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Vendortariffdtl;
import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Vendortarifflumpsum;
import com.bureaueye.beacon.model.standard.dao.VendortariffhdrDAO;
import com.bureaueye.beacon.model.standard.dto.VendortariffSearchLineItem;
import com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2009-06-16 ITT-200906-0004 Vendor Tariff Lump Sum Sub-totals
 * 
 * NT 2009-09-14 200900037 Add 'Valid From' Date
 * 
 * NT 2009-10-20 200900049 Add 'From Location', 'To Location' and
 * 'ActiveExpired' Search Criteria (changes not marked)
 * 
 * NT 2014-02-01 BESL-201402-0001 QUOTE MOVE AND COST TEMPLATE WORK
 * 
 * NT 2014-02-01 BESL-201402-0001 REMOVE PRODUCTKEY FROM VENDOR TARIFF PROCESS
 * AND PRODUCT TYPE (HAZ/NON-HAZ) INSTEAD -IT DOESN'T SEEM TO BE USED AND IS
 * GETTING IN THE WAY
 * 
 */
public final class VendortariffhdrBD extends BaseBD {

	// constructors
	public VendortariffhdrBD() {
	}

	public VendortariffhdrBD(SessionFactory _factory) {
		super(_factory);
	}

	public VendortariffhdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Vendortariffhdr.class
			.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Vendortariffhdr read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Vendortariffhdr dao = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dao = (Vendortariffhdr) session.get(Vendortariffhdr.class,
					(String) key);

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
			Vendortariffhdr _dao = (Vendortariffhdr) dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getVendtarfhdrId()) != null) {
				session.update(_dao);
				new SystemlogBD(this.getSessionFactoryClusterMap())
						.createSystemlog(_dao, user, "update");
			} else {
				Calendar c = Calendar.getInstance();
				_dao.setCreatedate(c.getTime());
				_dao.setCreatetime(com.bureaueye.beacon.util.Util.toTime(c));
				_dao.setCreateuserid(user.getUserid());
				session.save(_dao);
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
			Vendortariffhdr _dao = (Vendortariffhdr) dao;

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

	public void deleteAll(String id, User user) throws ApplicationException {

		if (id == null) {
			return;
		}
		Vendortariffhdr dto = null;

		try {
			dto = read(id);
			if (dto != null) {
				List set = getVendortariffdtls(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new VendortariffdtlBD().delete((Vendortariffdtl) it.next(),
							user);
				}

				// sITT-200906-0004
				set = getVendortarifflumpsums(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new VendortarifflumpsumBD().delete(
							(Vendortarifflumpsum) it.next(), user);
				}
				// eITT-200906-0004

				delete(dto, user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}

	// -----------------------------------------------
	// FIND METHODS
	// -----------------------------------------------
	public int findVendortariffhdrsTotalResults(ListForm listForm)
			throws ApplicationException {

		int queryTotal = 0;

		String vendoraddrkey = listForm.getSearchString1();
		if (vendoraddrkey == null || vendoraddrkey.equals("")) {
			vendoraddrkey = "%";
		}
		String costkey = listForm.getSearchString2();
		if (costkey == null || costkey.equals("")) {
			costkey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
		}

		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session
					.getNamedQuery(VendortariffhdrDAO.QUERY_FIND_VENDORTARIFFHDRS_TOTAL_RESULTS);
			q.setParameter("id1", custtarfhdrid);
			q.setParameter("id2", vendoraddrkey);
			q.setParameter("id3", costkey);
			q.setParameter("id4", searchString5);
			q.setParameter("id5", searchString6);
			queryTotal = ((Long) q.uniqueResult()).intValue();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryTotal;
	}

	public int findVendortariffhdrsTotalResultsActive(ListForm listForm)
			throws ApplicationException {

		int queryTotal = 0;

		String vendoraddrkey = listForm.getSearchString1();
		if (vendoraddrkey == null || vendoraddrkey.equals("")) {
			vendoraddrkey = "%";
		}
		String costkey = listForm.getSearchString2();
		if (costkey == null || costkey.equals("")) {
			costkey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
		}

		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session
					.getNamedQuery(VendortariffhdrDAO.QUERY_FIND_VENDORTARIFFHDRS_TOTAL_RESULTS_ACTIVE);
			q.setParameter("id1", custtarfhdrid);
			q.setParameter("id2", vendoraddrkey);
			q.setParameter("id3", costkey);
			q.setParameter("id4", searchString5);
			q.setParameter("id5", searchString6);
			q.setParameter("date1", listForm.getSearchDate1());
			queryTotal = ((Long) q.uniqueResult()).intValue();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryTotal;
	}

	public int findVendortariffhdrsTotalResultsExpired(ListForm listForm)
			throws ApplicationException {

		int queryTotal = 0;

		String vendoraddrkey = listForm.getSearchString1();
		if (vendoraddrkey == null || vendoraddrkey.equals("")) {
			vendoraddrkey = "%";
		}
		String costkey = listForm.getSearchString2();
		if (costkey == null || costkey.equals("")) {
			costkey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
		}

		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session
					.getNamedQuery(VendortariffhdrDAO.QUERY_FIND_VENDORTARIFFHDRS_TOTAL_RESULTS_EXPIRED);
			q.setParameter("id1", custtarfhdrid);
			q.setParameter("id2", vendoraddrkey);
			q.setParameter("id3", costkey);
			q.setParameter("id4", searchString4);
			q.setParameter("id5", searchString5);
			q.setParameter("date1", listForm.getSearchDate1());
			queryTotal = ((Long) q.uniqueResult()).intValue();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryTotal;
	}

	public List findVendortariffhdrsForSearchActive(
			ListVendortariffhdrForm listForm) throws ApplicationException {

		List queryResult = null;
		List<VendortariffhdrDTO> queryResultDTO = new LinkedList<VendortariffhdrDTO>();
		DateFormatter dateFormatter = new DateFormatter();

		String vendoraddrkey = listForm.getSearchString1();
		if (vendoraddrkey == null || vendoraddrkey.equals("")) {
			vendoraddrkey = "%";
		}
		String costkey = listForm.getSearchString2();
		if (costkey == null || costkey.equals("")) {
			costkey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
		}

		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}

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
			queryString = "select vendortariffhdr"
					+ " from Vendortariffhdr vendortariffhdr" + " where "
					+ " vendortariffhdr.VendtarfhdrId LIKE '" + custtarfhdrid
					+ "'" + " and vendortariffhdr.Vendoraddrkey LIKE '"
					+ vendoraddrkey + "'"
					+ " and vendortariffhdr.Costkey LIKE '" + costkey + "'"
					+ " and vendortariffhdr.Fromlocationkey LIKE '"
					+ searchString5 + "'"
					+ " and vendortariffhdr.Tolocationkey LIKE '"
					+ searchString6 + "'" + " and vendortariffhdr.Validto >= '"
					+ dateFormatter.format(listForm.getSearchDate1()) + "'"
					+ " order by " + listForm.getOrderBy() + " "
					+ listForm.getOrderByDesc();
			queryResult = session.createQuery(queryString).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Vendortariffhdr _dao = (Vendortariffhdr) it.next();
				VendortariffhdrDTO _dto = new VendortariffhdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

	public List findVendortariffhdrsForSearchExpired(
			ListVendortariffhdrForm listForm) throws ApplicationException {

		List queryResult = null;
		List<VendortariffhdrDTO> queryResultDTO = new LinkedList<VendortariffhdrDTO>();
		DateFormatter dateFormatter = new DateFormatter();

		String vendoraddrkey = listForm.getSearchString1();
		if (vendoraddrkey == null || vendoraddrkey.equals("")) {
			vendoraddrkey = "%";
		}
		String costkey = listForm.getSearchString2();
		if (costkey == null || costkey.equals("")) {
			costkey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
		}

		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}

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
			queryString = "select vendortariffhdr"
					+ " from Vendortariffhdr vendortariffhdr" + " where "
					+ " vendortariffhdr.VendtarfhdrId LIKE '" + custtarfhdrid
					+ "'" + " and vendortariffhdr.Vendoraddrkey LIKE '"
					+ vendoraddrkey + "'"
					+ " and vendortariffhdr.Costkey LIKE '" + costkey + "'"
					+ " and vendortariffhdr.Fromlocationkey LIKE '"
					+ searchString5 + "'"
					+ " and vendortariffhdr.Tolocationkey LIKE '"
					+ searchString6 + "'" + " and vendortariffhdr.Validto < '"
					+ dateFormatter.format(listForm.getSearchDate1()) + "'"
					+ " order by " + listForm.getOrderBy() + " "
					+ listForm.getOrderByDesc();
			queryResult = session.createQuery(queryString).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Vendortariffhdr _dao = (Vendortariffhdr) it.next();
				VendortariffhdrDTO _dto = new VendortariffhdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

	public List findVendortariffhdrsForSearch(ListVendortariffhdrForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<VendortariffhdrDTO> queryResultDTO = new LinkedList<VendortariffhdrDTO>();

		String vendoraddrkey = listForm.getSearchString1();
		if (vendoraddrkey == null || vendoraddrkey.equals("")) {
			vendoraddrkey = "%";
		}
		String costkey = listForm.getSearchString2();
		if (costkey == null || costkey.equals("")) {
			costkey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
		}

		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}

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
			queryString = "select vendortariffhdr"
					+ " from Vendortariffhdr vendortariffhdr" + " where "
					+ " vendortariffhdr.VendtarfhdrId LIKE '" + custtarfhdrid
					+ "'" + " and vendortariffhdr.Vendoraddrkey LIKE '"
					+ vendoraddrkey + "'"
					+ " and vendortariffhdr.Costkey LIKE '" + costkey + "'"
					+ " and vendortariffhdr.Fromlocationkey LIKE '"
					+ searchString5 + "'"
					+ " and vendortariffhdr.Tolocationkey LIKE '"
					+ searchString6 + "'" + " order by "
					+ listForm.getOrderBy() + " " + listForm.getOrderByDesc();
			queryResult = session.createQuery(queryString).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Vendortariffhdr _dao = (Vendortariffhdr) it.next();
				VendortariffhdrDTO _dto = new VendortariffhdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

	public List findVendortariffhdrsByAddrkey(String addrkey)
			throws ApplicationException {

		List queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			queryResult = session.createCriteria(Vendortariffhdr.class)
					.add(Expression.eq("Vendoraddrkey", addrkey)).list();

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

	/*
	 * public List findVendortariffhdrsByKey1( String vendoraddrkey, String
	 * costkey, String ccykey, Date validto, String fromlocationkey, String
	 * tolocationkey, String productkey ) throws ApplicationException {
	 * 
	 * List queryResult = null;
	 * 
	 * // get Session Session session = null; try { session =
	 * this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession(); }
	 * catch (HibernateException e) { throw new
	 * ApplicationException(ApplicationException.LIST_FAILED); }
	 * 
	 * try {
	 * 
	 * queryResult = session .createCriteria(Vendortariffhdr.class)
	 * .add(Expression.eq("Vendoraddrkey", vendoraddrkey))
	 * .add(Expression.eq("Costkey", costkey)) .add(Expression.eq("Ccykey",
	 * ccykey)) .add(Expression.ge("Validto", validto))
	 * .add(Expression.eq("Fromlocationkey", fromlocationkey))
	 * .add(Expression.eq("Tolocationkey", tolocationkey))
	 * .add(Expression.eq("Productkey", productkey)) .list(); if
	 * (queryResult.size() == 0) { queryResult = session
	 * .createCriteria(Vendortariffhdr.class)
	 * .add(Expression.eq("Vendoraddrkey", vendoraddrkey))
	 * .add(Expression.eq("Costkey", costkey)) .add(Expression.eq("Ccykey",
	 * ccykey)) .add(Expression.ge("Validto", validto))
	 * .add(Expression.eq("Fromlocationkey", fromlocationkey))
	 * .add(Expression.eq("Tolocationkey", tolocationkey)) .list(); } if
	 * (queryResult.size() == 0) { queryResult = session
	 * .createCriteria(Vendortariffhdr.class)
	 * .add(Expression.eq("Vendoraddrkey", vendoraddrkey))
	 * .add(Expression.eq("Costkey", costkey)) .add(Expression.eq("Ccykey",
	 * ccykey)) .add(Expression.ge("Validto", validto))
	 * .add(Expression.eq("Productkey", productkey)) .list(); } if
	 * (queryResult.size() == 0) { queryResult = session
	 * .createCriteria(Vendortariffhdr.class)
	 * .add(Expression.eq("Vendoraddrkey", vendoraddrkey))
	 * .add(Expression.eq("Costkey", costkey)) .add(Expression.eq("Ccykey",
	 * ccykey)) .add(Expression.ge("Validto", validto)) .list(); }
	 * 
	 * } catch (HibernateException e) { throw new
	 * ApplicationException(ApplicationException.LIST_FAILED); }
	 * 
	 * // close Session try { session.close(); } catch (HibernateException e) {
	 * throw new ApplicationException(ApplicationException.LIST_FAILED); }
	 * 
	 * return queryResult;
	 * 
	 * }
	 */
	/*
	 * public QuocostForm setTariffDetails( String id, QuocostForm quocostForm )
	 * throws ApplicationException {
	 * 
	 * Vendortariffdtl vendortariffdtl = null;
	 * 
	 * try { if ( quocostForm.getCosttype().equals("UNIT") ||
	 * quocostForm.getCosttype().equals("DISTANCE") ) { vendortariffdtl = new
	 * VendortariffdtlBD(this.getSessionFactoryClusterMap())
	 * .findVendortariffdtlByKey1( id, quocostForm.getUnits() ); try { if
	 * (vendortariffdtl != null) { quocostForm.setRate(new
	 * CurrencyFormatter().format(vendortariffdtl.getUnitrate())); // calculate
	 * cost amount float rate = new Float(quocostForm.getRate()).floatValue();
	 * float units = new Float(quocostForm.getUnits()).floatValue(); float
	 * costAmount = rate * units; quocostForm.setCstamt(new
	 * CurrencyFormatter().format(new BigDecimal(costAmount))); } } catch
	 * (FormattingException fe) {}
	 * 
	 * 
	 * } else { vendortariffdtl = new
	 * VendortariffdtlBD(this.getSessionFactoryClusterMap())
	 * .findVendortariffdtlById(id); try { if (vendortariffdtl != null) {
	 * quocostForm.setRate(new
	 * CurrencyFormatter().format(vendortariffdtl.getLumpsum()));
	 * quocostForm.setUnits("1.00"); // calculate cost amount
	 * quocostForm.setCstamt(new
	 * CurrencyFormatter().format(vendortariffdtl.getLumpsum())); } } catch
	 * (FormattingException fe) {} }
	 * 
	 * } catch (ApplicationException e) { throw new
	 * ApplicationException(ApplicationException.LIST_FAILED); }
	 * 
	 * return (quocostForm);
	 * 
	 * }
	 */

	public List vendortariffSearch(String vendoraddrkey, String costkey,
			String fromlocationkey, String tolocationkey, String tslocationkey,
			String productkey, String ccykey, String unittype, String units,
			String producthazardous, int gotoPage, int maxResults, String order)
			throws ApplicationException {

		List queryResult = null;
		List<VendortariffhdrDTO> queryResultDTO = new LinkedList<VendortariffhdrDTO>();
		List<VendortariffSearchLineItem> lineitems = new LinkedList<VendortariffSearchLineItem>();

		if (vendoraddrkey == null || vendoraddrkey.equals("")) {
			vendoraddrkey = "%";
		}

		if (costkey == null || costkey.equals("")) {
			costkey = "%";
		}

		if (fromlocationkey == null || fromlocationkey.equals("")) {
			fromlocationkey = "%";
		}

		if (tolocationkey == null || tolocationkey.equals("")) {
			tolocationkey = "%";
		}

		if (tslocationkey == null || tslocationkey.equals("")) {
			tslocationkey = "%";
		}

		if (productkey == null || productkey.equals("")) {
			productkey = "%";
		}

		if (producthazardous == null || producthazardous.equals("")) {
			producthazardous = "%";
		}

		if (ccykey == null || ccykey.equals("")) {
			ccykey = "%";
		}

		if (order == null || order.equals("")) {
			return null;
		}

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			queryResult = session
					.createCriteria(Vendortariffhdr.class)
					.add(Expression.like("Vendoraddrkey", vendoraddrkey))
					.add(Expression.like("Costkey", costkey))
					.add(Expression.ge("Validto", new Date()))
					.add(Expression.le("Validfrom", new Date()))
					.add(Expression.like("Fromlocationkey", fromlocationkey))
					.add(Expression.like("Tolocationkey", tolocationkey))
					// .add(Expression.like("Tslocationkey", tslocationkey))
					// .add(Expression.like("Productkey", productkey))
					.add(Expression.like("Producthazardous", producthazardous))
					.add(Expression.like("Ccykey", ccykey))
					// 200900037
					.addOrder(Order.asc(order))
					.setFirstResult(gotoPage * maxResults)
					.setMaxResults(maxResults).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Vendortariffhdr _dao = (Vendortariffhdr) it.next();
				VendortariffhdrDTO _dto = new VendortariffhdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

		try {
			if (queryResultDTO != null) {
				for (Iterator it = queryResultDTO.iterator(); it.hasNext();) {
					VendortariffhdrDTO hdr = (VendortariffhdrDTO) it.next();
					Vendortariffdtl dtl = null;
					// find tariff detail if rate type
					if (unittype.equals("UNIT") || unittype.equals("DISTANCE")) {
						dtl = new VendortariffdtlBD(
								this.getSessionFactoryClusterMap())
								.findVendortariffdtlByKey1(
										hdr.getVendtarfhdrId(), units);
						// try {
						// if (dtl != null) dtl.setLumpsum(new
						// BigDecimal(units).multiply(dtl.getUnitrate()));
						// } catch (Exception e) {}
					}
					// else {
					// dtl = new
					// VendortariffdtlBD().findVendortariffdtlById(hdr.getVendtarfhdrId());
					// if (dtl != null) dtl.setUnitrate(new BigDecimal(1));
					// }

					VendortariffSearchLineItem lineitem = new VendortariffSearchLineItem(
							hdr, dtl, unittype, units);
					lineitems.add(lineitem);
				}
			}
		} catch (ApplicationException ae) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return lineitems;

	}

	public List getVendortariffdtls(String id) throws ApplicationException {

		List queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session
					.createQuery("from Vendortariffdtl vendortariffdtl where vendortariffdtl.VendtarfhdrId = :id");
			q.setParameter("id", id);

			queryResult = q.list();
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

	// sITT-200906-0004
	public List getVendortarifflumpsums(String id) throws ApplicationException {

		List queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session
					.createQuery("from Vendortarifflumpsum vendortarifflumpsum where vendortarifflumpsum.VendtarfhdrId = :id");
			q.setParameter("id", id);

			queryResult = q.list();
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

	// eITT-200906-0004

	public List findVendortariffhdrsForDashboard(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<VendortariffhdrDTO> queryResultDTO = new LinkedList<VendortariffhdrDTO>();
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

			String queryString = "";
			queryString = "select vendortariffhdr"
					+ " from Vendortariffhdr vendortariffhdr" + " where "
					+ " vendortariffhdr.Createuserid LIKE '"
					+ listForm.getSearchString1() + "'"
					+ " and vendortariffhdr.Validto >= '"
					+ dateFormatter.format(listForm.getSearchDate1()) + "'"
					+ " and vendortariffhdr.Validto <= '"
					+ dateFormatter.format(listForm.getSearchDate2()) + "'"
					+ " order by " + listForm.getOrderBy() + " "
					+ listForm.getOrderByDesc();
			queryResult = session
					.createQuery(queryString)
					.setFirstResult(
							listForm.getGotoPage() * listForm.getMaxResults())
					.setMaxResults(listForm.getMaxResults()).list();

			// TODO: iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Vendortariffhdr _dao = (Vendortariffhdr) it.next();
				VendortariffhdrDTO _dto = new VendortariffhdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

	public List vendortariffSearch2(String costkey, String fromlocationkey,
			String tolocationkey, String producthazardous, String ccykey,
			String vendoraddrkey, String unittype, String units, Date date,
			String order) throws ApplicationException {

		List queryResult = null;
		List<VendortariffhdrDTO> queryResultDTO = new LinkedList<VendortariffhdrDTO>();
		List<VendortariffLineItem> lineitems = new LinkedList<VendortariffLineItem>();
		DateFormatter dateFormatter = new DateFormatter();

		if (order == null || order.equals("")) {
			return null;
		}

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
			queryString = "select vendortariffhdr"
					+ " from Vendortariffhdr vendortariffhdr" + " where "
					+ "     vendortariffhdr.Costkey = '" + costkey + "'"
					+ " and vendortariffhdr.Fromlocationkey = '"
					+ fromlocationkey + "'"
					+ " and vendortariffhdr.Tolocationkey = '" + tolocationkey
					+ "'" + " and vendortariffhdr.Validfrom <= '"
					+ dateFormatter.format(date) + "'"
					+ " and vendortariffhdr.Validto >= '"
					+ dateFormatter.format(date) + "'";

			// add extra search critera
			if (producthazardous != null && !producthazardous.equals(""))
				queryString = queryString
						+ " and vendortariffhdr.Producthazardous = '"
						+ producthazardous + "'";
			if (vendoraddrkey != null && !vendoraddrkey.equals(""))
				queryString = queryString
						+ " and vendortariffhdr.Vendoraddrkey ='"
						+ vendoraddrkey + "'";
			if (ccykey != null && !ccykey.equals(""))
				queryString = queryString + " and vendortariffhdr.Ccykey ='"
						+ ccykey + "'";

			queryString = queryString + " order by " + order;

			queryResult = session.createQuery(queryString).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Vendortariffhdr _dao = (Vendortariffhdr) it.next();
				VendortariffhdrDTO _dto = new VendortariffhdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

		try {
			if (queryResultDTO != null) {
				for (Iterator it = queryResultDTO.iterator(); it.hasNext();) {
					VendortariffhdrDTO hdr = (VendortariffhdrDTO) it.next();
					Vendortariffdtl dtl = null;
					// find tariff detail if rate type
					if (unittype.equals("UNIT") || unittype.equals("DISTANCE")) {
						dtl = new VendortariffdtlBD(
								this.getSessionFactoryClusterMap())
								.findVendortariffdtlByKey1(
										hdr.getVendtarfhdrId(), units);
					}

					VendortariffLineItem lineitem = new VendortariffLineItem(
							hdr, dtl, unittype, units);
					lineitems.add(lineitem);
				}
			}
		} catch (ApplicationException ae) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return lineitems;

	}

	public List groupVendortariffsForLumpsumAverage(Date date)
			throws ApplicationException {

		List dtos = null;
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

			String queryString = "";
			queryString = "select "
					+ " new com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO "
					+ "	(vendortariffhdr.Costkey, vendortariffhdr.Fromlocationkey, vendortariffhdr.Tolocationkey, vendortariffhdr.Producthazardous) "
					+ " from com.bureaueye.beacon.model.standard.Vendortariffhdr vendortariffhdr "
					+ " where" + "  vendortariffhdr.Validfrom <= '"
					+ dateFormatter.format(date) + "'"
					+ " and vendortariffhdr.Validto >= '"
					+ dateFormatter.format(date) + "'"
					+ " and vendortariffhdr.Lumpsum > 0.0";

			queryString = queryString
					+ " group by vendortariffhdr.Costkey, vendortariffhdr.Fromlocationkey, vendortariffhdr.Tolocationkey, vendortariffhdr.Producthazardous";

			dtos = session.createQuery(queryString).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return dtos;
	}

	public List findVendortariffsForLumpsumAverage(String costkey,
			String fromlocationkey, String tolocationkey,
			String producthazardous, Date date) throws ApplicationException {

		List queryResult = null;
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

			String queryString = "";
			queryString = "select vendortariffhdr"
					+ " from Vendortariffhdr vendortariffhdr" + " where "
					+ "     vendortariffhdr.Costkey = '" + costkey + "'"
					+ " and vendortariffhdr.Fromlocationkey = '"
					+ fromlocationkey + "'"
					+ " and vendortariffhdr.Tolocationkey = '" + tolocationkey
					+ "'" + " and vendortariffhdr.Producthazardous = '"
					+ producthazardous + "'"
					+ " and vendortariffhdr.Validfrom <= '"
					+ dateFormatter.format(date) + "'"
					+ " and vendortariffhdr.Validto >= '"
					+ dateFormatter.format(date) + "'"
					+ " and vendortariffhdr.Lumpsum > 0.0";

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

	public List groupVendortariffsForUnitrateAverage(Date date)
			throws ApplicationException {

		List dtos = null;
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

			String queryString = "";
			queryString = "select "
					+ " new com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO "
					+ "	(vendortariffhdr.Costkey, vendortariffhdr.Fromlocationkey, "
					+ "  vendortariffhdr.Tolocationkey, vendortariffhdr.Producthazardous, vendortariffhdr.Ccykey,"
					+ "  vendortariffdtl.Fromvalue, vendortariffdtl.Tovalue) "
					+ " from com.bureaueye.beacon.model.standard.Vendortariffhdr vendortariffhdr, "
					+ " 	 com.bureaueye.beacon.model.standard.Vendortariffdtl vendortariffdtl "
					+ " where"
					+ "	 vendortariffhdr.VendtarfhdrId = vendortariffdtl.VendtarfhdrId  "
					+ " and vendortariffhdr.Validfrom <= '"
					+ dateFormatter.format(date) + "'"
					+ " and vendortariffhdr.Validto >= '"
					+ dateFormatter.format(date) + "'"
					+ " and vendortariffhdr.Lumpsum = 0.0";

			queryString = queryString
					+ " group by "
					+ " vendortariffdtl.Fromvalue, vendortariffdtl.Tovalue, "
					+ " vendortariffhdr.Costkey, vendortariffhdr.Fromlocationkey, "
					+ " vendortariffhdr.Tolocationkey, vendortariffhdr.Producthazardous ";

			dtos = session.createQuery(queryString).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return dtos;
	}

	public List findVendortariffsForUnitrateAverage(String costkey,
			String fromlocationkey, String tolocationkey,
			String producthazardous, Integer fromvalue, Integer tovalue,
			Date date) throws ApplicationException {

		List queryResult = null;
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

			String queryString = "";
			queryString = "select vendortariffdtl"
					+ " from com.bureaueye.beacon.model.standard.Vendortariffhdr vendortariffhdr, "
					+ " 	 com.bureaueye.beacon.model.standard.Vendortariffdtl vendortariffdtl "
					+ " where"
					+ "	    vendortariffhdr.VendtarfhdrId = vendortariffdtl.VendtarfhdrId  "
					+ " and vendortariffhdr.Costkey = '"
					+ costkey
					+ "'"
					+ " and vendortariffhdr.Fromlocationkey = '"
					+ fromlocationkey
					+ "'"
					+ " and vendortariffhdr.Tolocationkey = '"
					+ tolocationkey
					+ "'"
					+ " and vendortariffhdr.Producthazardous = '"
					+ producthazardous
					+ "'"
					+ " and vendortariffhdr.Validfrom <= '"
					+ dateFormatter.format(date)
					+ "'"
					+ " and vendortariffhdr.Validto >= '"
					+ dateFormatter.format(date)
					+ "'"
					+ " and vendortariffhdr.Lumpsum = 0.0"
					+ " and vendortariffdtl.Fromvalue = "
					+ fromvalue
					+ ""
					+ " and vendortariffdtl.Tovalue = " + tovalue + "";

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

}
