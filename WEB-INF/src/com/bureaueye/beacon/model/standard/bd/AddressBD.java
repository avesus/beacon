package com.bureaueye.beacon.model.standard.bd;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Addresscontact;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.dto.AddressDTO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

import org.hibernate.criterion.Expression;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-06 WSI-201311-0003 BEACON LAKER (WSI LINER) - add 'External System
 * Address Id' to Address maintenance
 * 
 */
public final class AddressBD extends BaseBD {

	// constructors
	public AddressBD() {
	}

	public AddressBD(SessionFactory _factory) {
		super(_factory);
	}

	public AddressBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Address.class.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Address read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Address dto = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			log.debug(e.getMessage());
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dto = (Address) session.get(Address.class, (String) key);

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

		return dto;

	}

	public void createOrUpdate(Object dto, User user)
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
			Address _dto = (Address) dto;

			Transaction tx = session.beginTransaction();

			if (read(_dto.getAddrkey()) != null) {
				session.update(_dto);
				new SystemlogBD(this.getSessionFactoryClusterMap())
						.createSystemlog(_dto, user, "update");
			} else {
				Calendar c = Calendar.getInstance();
				_dto.setCreatedate(c.getTime());
				_dto.setCreatetime(com.bureaueye.beacon.util.Util.toTime(c));
				_dto.setCreateuserid(user.getUserid());
				session.save(_dto);
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

	public void delete(Object dto, User user) throws ApplicationException {

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}

		try {
			Address _dto = (Address) dto;

			Transaction tx = session.beginTransaction();
			session.delete(_dto);
			tx.commit();

			new SystemlogBD(this.getSessionFactoryClusterMap())
					.createSystemlog(_dto, user, "delete");
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
		Address dto = null;

		try {
			dto = read(id);
			if (dto != null) {
				List set = getAddresscontacts(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new AddresscontactBD().delete((Addresscontact) it.next(),
							user);
				}
				delete(dto, user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}

	// -----------------------------------------------
	// FIND METHODS
	// -----------------------------------------------
	public List findAddressesByType(String type, String order)
			throws ApplicationException {

		List queryResult = null;
		List<AddressDTO> queryResultDTO = new LinkedList<AddressDTO>();

		// if (type == null || type.equals("")) {
		// type = "%";
		// }

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

			queryResult = session.createCriteria(Address.class)
			// .add(Expression.like("Typekey", type))
					.addOrder(Order.asc(order)).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// iterate results to initialise DTO list
		// change required to use Typekey List
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Address _dao = (Address) it.next();
			AddressDTO _dto = new AddressDTO(_dao,
					this.getSessionFactoryClusterMap());
			if (type == null || type.equals("")) {
				queryResultDTO.add(_dto);
			} else {
				if (_dto.getTypekeylist().contains(type))
					queryResultDTO.add(_dto);// include selected type
			}
		}

		return queryResultDTO;
	}

	public List findAddressesByNameType(String searchString1,
			String searchString2, int gotoPage, int maxResults, String order)
			throws ApplicationException {

		List queryResult = null;
		List<AddressDTO> queryResultDTO = new LinkedList<AddressDTO>();

		if (searchString1 == null) {
			searchString1 = "";
		}
		if (searchString2 == null) {
			searchString2 = "";
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

			queryResult = session.createCriteria(Address.class)
					.add(Expression.like("Name", searchString1))
					.addOrder(Order.asc(order)).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// iterate results to initialise DTO list
		// change required to use Typekey List
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Address _dao = (Address) it.next();
			AddressDTO _dto = new AddressDTO(_dao,
					this.getSessionFactoryClusterMap());
			if (searchString2.equals("")) {
				queryResultDTO.add(_dto);
			} else {
				if (_dto.getTypekeylist().contains(searchString2))
					queryResultDTO.add(_dto);// include selected type
			}

		}

		return queryResultDTO;
	}

	// find using passed list of AddressDTO objects
	public List findAddresslistByType(List list, String typelist, String order)
			throws ApplicationException {

		List<AddressDTO> queryResultDTO = new LinkedList<AddressDTO>();

		if (list != null) {

			// change required to use Typekey List
			for (Iterator it = list.iterator(); it.hasNext();) {
				AddressDTO _dto = (AddressDTO) it.next();
				StringTokenizer st = new StringTokenizer(typelist, "|");
				// many types selection with type list
				search: while (st.hasMoreTokens()) {
					if (_dto.getTypekeylist().contains(st.nextToken())) {
						queryResultDTO.add(_dto);
						break search;// break from this loop and continue main
					}
				}
			}

		}// check passed list is not null

		return queryResultDTO;
	}

	public List findAddressesAll(String order) throws ApplicationException {

		List queryResult = null;
		List<AddressDTO> queryResultDTO = new LinkedList<AddressDTO>();

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

			queryResult = session.createCriteria(Address.class)
					.addOrder(Order.asc(order)).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// iterate results to initialise DTO list
		// change required to use Typekey List
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Address _dao = (Address) it.next();
			AddressDTO _dto = new AddressDTO(_dao,
					this.getSessionFactoryClusterMap());
			queryResultDTO.add(_dto);
		}

		return queryResultDTO;
	}

	public List findAddresssForSearch(String searchString1,
			String searchString2, String searchString3, String searchString4,
			String searchString5, String searchString6, String searchString7,
			String searchString8, String searchString9, String searchString10,
			String searchString11, String searchString12,
			String searchString13, String searchString14, String g1codekey,
			String g2codekey, String g3codekey, String g4codekey, String order,
			String headerInfo1) throws ApplicationException {

		List queryResult = null;
		List<AddressDTO> queryResultDTO = new LinkedList<AddressDTO>();

		// Name
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}

		// Shortname
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}

		// Addr1
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}

		// Addr2
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}

		// Addr3
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}

		// Addr4
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}

		// Postalcode
		if (searchString7 == null || searchString7.equals("")) {
			searchString7 = "%";
		}

		// City
		if (searchString8 == null || searchString8.equals("")) {
			searchString8 = "%";
		}

		// State
		if (searchString9 == null || searchString9.equals("")) {
			searchString9 = "%";
		}

		// Country
		if (searchString10 == null || searchString10.equals("")) {
			searchString10 = "%";
		}

		// Telno1
		if (searchString11 == null || searchString11.equals("")) {
			searchString11 = "%";
		}

		// Faxno1
		if (searchString12 == null || searchString12.equals("")) {
			searchString12 = "%";
		}

		// Emailno
		if (searchString13 == null || searchString13.equals("")) {
			searchString13 = "%";
		}

		// Addresskey
		if (searchString14 == null || searchString14.equals("")) {
			searchString14 = "%";
		}

		// g-codes
		if (g1codekey == null || g1codekey.equals("")) {
			g1codekey = "%";
		}
		if (g2codekey == null || g2codekey.equals("")) {
			g2codekey = "%";
		}
		if (g3codekey == null || g3codekey.equals("")) {
			g3codekey = "%";
		}
		if (g4codekey == null || g4codekey.equals("")) {
			g4codekey = "%";
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
					.createCriteria(Address.class)
					// .add(Expression.in("Typekey",
					// Arrays.asList(headerInfo1.split(","))))
					.add(Expression.like("Name", searchString1))
					.add(Expression.like("Shortname", searchString2))
					.add(Expression.like("Addr1", searchString3))
					.add(Expression.like("Addr2", searchString4))
					.add(Expression.like("Addr3", searchString5))
					.add(Expression.like("Addr4", searchString6))
					.add(Expression.like("Postalcode", searchString7))
					.add(Expression.like("City", searchString8))
					.add(Expression.like("State", searchString9))
					.add(Expression.like("Country", searchString10))
					.add(Expression.like("G1codekey", g1codekey))
					.add(Expression.like("G2codekey", g2codekey))
					.add(Expression.like("G3codekey", g3codekey))
					.add(Expression.like("G4codekey", g4codekey))
					.addOrder(Order.asc(order)).list();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// iterate results to initialise DTO list
		// change required to use Typekey List
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Address _dao = (Address) it.next();
			AddressDTO _dto = new AddressDTO(_dao,
					this.getSessionFactoryClusterMap());
			StringTokenizer st = new StringTokenizer(headerInfo1, "|");
			// many types selection with type list
			search: while (st.hasMoreTokens()) {
				if (_dto.getTypekeylist().contains(st.nextToken())) {
					queryResultDTO.add(_dto);
					break search;// break from this loop and continue main
				}
			}

		}

		return queryResultDTO;

	}

	public List getAddresscontacts(String id) throws ApplicationException {

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
					.createQuery("from Addresscontact addresscontact where addresscontact.id.Addrkey = :id");
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

//WSI-201311-0003	
	public Address findAddressByExtsysaddressid(String id)
			throws ApplicationException {

		Address queryResult = null;

		if (id == null) {
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

			queryResult = (Address) session.createCriteria(Address.class)
					.add(Expression.eq("Extsysaddressid", id)).setMaxResults(1)
					.uniqueResult();

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
