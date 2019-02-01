package com.bureaueye.genesys.model.onhire.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;




public final class UnitSearchDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public UnitSearchDTO(Unit dao) throws ApplicationException {
		initialize(dao);		
	}
	public UnitSearchDTO(Unit dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Unit dao) throws ApplicationException {		
		this.unitId = dao.getUnitId();
		this.onhireId = dao.getOnhireId();
		this.offhireId = dao.getOffhireId();
		
		this.unitkey = dao.getUnitkey();

		this.setMovelocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getMovelocationkey()));
		this.movests = dao.getMovests();
		this.setMoveproductkey(new ProductBD(this.getSessionFactoryClusterMap()).read(dao.getMoveproductkey()));
		
		this.returnParams = this.unitkey+"|"+this.unitId+"|"+this.offhireId;			
	}
	
	
	
	
    /**
     * The unique id.
     */
    private String id;

	// fields
	private java.lang.Integer unitId;
	private String unitkey;	
	
	
	private String movests;
	private Product moveproductkey;	
	private Location movelocationkey;
	
	private Integer onhireId;
	private Integer offhireId;
	
	private String returnParams;
	
    private boolean checked;




    // ----------------------------------------------------------- Properties


    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
    /**
     */
    public String getReturnParams() {
    	return (this.returnParams);
    }
    /**
     */
    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
    }
    


    /**
     */
    public String getId() {
    	return (this.id);
    }
    /**
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     */
    public Integer getOnhireId() {
    	return (this.onhireId);
    }
    /**
     */
    public void setOnhireId(Integer onhireId) {
        this.onhireId = onhireId;
    }
    


    /**
     */
    public Integer getOffhireId() {
    	return (this.offhireId);
    }
    /**
     */
    public void setOffhireId(Integer offhireId) {
        this.offhireId = offhireId;
    }
    
    

    /**
     */
    public Integer getUnitId() {
    	return (this.unitId);
    }
    /**
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
    
    
    /**
     */
    public String getUnitkey() {
    	return (this.unitkey);
    }
    /**
     */
    public void setUnitkey(String unitkey) {
        this.unitkey = unitkey;
    }

 
    
	/**
	 * Return the value associated with the column: _movelocationkey
	 */
	public Location getMovelocationkey () {
		return movelocationkey;
	}

	/**
	 * Set the value related to the column: _movelocationkey
	 * @param __movelocationkey the _movelocationkey value
	 */
	public void setMovelocationkey (Location movelocationkey) {
		this.movelocationkey = movelocationkey;
	}
	
	
	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return movests;
	}

	/**
	 * Set the value related to the column: movests
	 * @param _movests the movests value
	 */
	public void setMovests (java.lang.String movests) {
		this.movests = movests;
	}	

	
	/**
	 * Return the value associated with the column: moveproductkey
	 */
	public Product getMoveproductkey () {
		return moveproductkey;
	}

	/**
	 * Set the value related to the column: moveproductkey
	 * @param _moveproductkey the moveproductkey value
	 */
	public void setMoveproductkey (Product moveproductkey) {
		this.moveproductkey = moveproductkey;
	}

}