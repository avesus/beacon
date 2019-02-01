package com.bureaueye.beacon.model.order.bd.laker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;

import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.standard.User;

/**
 * 
 * Amendments ----------
 * 
 * LAKER BESPOKE (COPY FROM com.bureaueye.beacon.order.model.bd.OrderhdrBD)
 * 
 * NT 2014-06-09 201400026 - Add 'Order No' Descending Sort Order to Order list
 * - Add 'Doc Id' Descending Sort Order to Sales Invoice List
 * 
 */
public final class OrderhdrBD extends BaseBD {

	// constructors
	public OrderhdrBD() {
	}

	public OrderhdrBD(SessionFactory _factory) {
		super(_factory);
	}

	public OrderhdrBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);
	}

	public OrderhdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Orderhdr.class.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Orderhdr read(Object key) throws ApplicationException {
		return null;
	}

	public void createOrUpdate(Object dto, User user)
			throws ApplicationException {
	}

	public void delete(Object dto, User user) throws ApplicationException {
	}

	// -----------------------------------------------
	// FIND METHODS
	// -----------------------------------------------
	@SuppressWarnings("rawtypes")
	public List findOrderhdrsBySearch(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO> queryResultDTO = new LinkedList<com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO>();
		DateFormatter dateFormatter = new DateFormatter();

		//
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
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
			queryString = "select orderhdr"
					+ " from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
					+ " where" + "     orderhdr.Companykey = '"
					+ listForm.getSearchString19()
					+ "'"
					+ " and orderhdr.Orderdate between '"
					+ dateFormatter.format(listForm.getSearchDate1())
					+ "' and '"
					+ dateFormatter.format(listForm.getSearchDate2())
					+ "'"
					+ " AND orderhdr.Orderno LIKE '"
					+ searchString1
					+ "'"
					+ " and orderhdr.Customeraddrkey LIKE '"
					+ listForm.getSearchString2()
					+ "'"
					+ " and orderhdr.Ldglocationkey2 LIKE '"
					+ listForm.getSearchString11()
					+ "'"
					+ " and orderhdr.Invoicestatus LIKE '"
					+ listForm.getSearchString3()
					+ "'"
					+ " and orderhdr.Completeflag LIKE '"
					+ listForm.getSearchString30() + "'";

			// ship vessel
			if (!listForm.getSearchString29().equals(""))
				queryString = queryString + " AND orderhdr.Shipvessel = '"
						+ listForm.getSearchString29() + "'";

			queryString = queryString + " order by " + listForm.getOrderBy()
					+ " " + listForm.getOrderByDesc();
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}

			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao = (Orderhdr) it.next();
				com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO _dto = new com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO(
						_dao, this.getSessionFactoryClusterMap());
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

	@SuppressWarnings("rawtypes")
	public List findOrderhdrsBySearchByOrderno(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO> queryResultDTO = new LinkedList<com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO>();

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
			queryString = "select orderhdr"
					+ " from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
					+ " where" + " orderhdr.Orderno = '"
					+ listForm.getSearchString1() + "'";

			queryString = queryString + " order by " + listForm.getOrderBy()
					+ " " + listForm.getOrderByDesc();
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}
			
			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao = (Orderhdr) it.next();
				com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO _dto = new com.bureaueye.beacon.model.order.dto.laker.OrderhdrDTO(
						_dao, this.getSessionFactoryClusterMap());
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

}
