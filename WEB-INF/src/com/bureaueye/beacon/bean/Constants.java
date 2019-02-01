package com.bureaueye.beacon.bean;

 
/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 * NT	2010-10-28		201000045			Add Max Results No Limit Option 
 *
 */
public final class Constants {


    /**
     * The package name for this application.
     */
    public static final String PACKAGE = "com.bureaueye.beacon";


    /**
     * The valid input character list
     */
    public static final String VALID_INPUT_CHARS = "-*><";
    
    
    /**
     * The application resources location
     */
    public static final String APPLICATION_RESOURCES = "com.bureaueye.beacon.ApplicationResources";
 
    
    
    /**
     * The logo location
     */
    public static final String WATERMARK = "c:/bureaueye/logo/invoice_test_print.jpg";
    public static final String TEST_PRINT = "TEST PRINT";
    
    
    
    /**
     * The token representing "failure" for this application.
     */
    public static final String FAILURE = "failure";


    /**
     * The token representing "success" for this application.
     */
    public static final String SUCCESS = "success";

    
    /**
     * The session scope attribute under which the default
     * for the 
     */
    public static final int MAX_RESULTS = 10;
    
    public static final int MIN_TOTAL_RESULTS = 0;
    public static final int MAX_TOTAL_RESULTS = 999;
    
    public static final int MAX_RESULTS_NOLIMIT = 99999;
    
    public static final int MAX_RESULTS_DEFAULT = 10;
    
    

    /**
     * A static message in case database resource is not loaded.
     */
    public static final String ERROR_DATABASE_NOT_LOADED =
        "ERROR:  User database not loaded -- check servlet container logs for error messages.";


    /**
     * A static message in case message resource is not loaded.
     */
    public static final String ERROR_MESSAGES_NOT_LOADED =
        "ERROR:  Message resources not loaded -- check servlet container logs for error messages.";


    /**
     * The request attributes key under the WelcomeAction stores an ArrayList
     * of error messages, if required resources are missing.
     */
    public static final String ERROR_KEY = "ERROR";


    /**
     * 
     */
    public static final String DATA_POOL_KEY = "datapool";    

    /**
     * 
     */
    public static final String ANALYSIS_POOL_KEY = "analysispool";
    

    /**
     * 
     */
    public static final String DASHBOARD_POOL_KEY = "dashboardpool";
    

	/**
	 * The number of milliseconds in a day
	 */
	public static final long MILLISECONDS_PER_DAY = 86400000;
	
	
    public static final String USER_KEY = "user";


    public static final String BREADCRUMB_KEY = "breadcrumb";
    
    

    	public static final String LIST = "list";

    	
        /**
         * standard status.
         */
        public static final String AVAILABLE_STATUS = "AVAILABLE";
        public static final String ONHIRE_STATUS = "ONHIRE";
        public static final String OFFHIRE_STATUS = "OFFHIRE";        
        public static final String RESERVED_STATUS = "RESERVED";
        public static final String OPERATOR_STATUS = "OPERATOR";        
        
        public static final String LESSEE = "LESSEE";   
        public static final String LESSOR = "LESSOR";
        public static final String CUSTOMER = "CUSTOMER"; 
        public static final String CONSIGNEE = "CONSIGNEE"; 
        public static final String VENDOR = "VENDOR"; 
        public static final String BROKER = "BROKER"; 
        public static final String FWDAGENT = "FWDAGENT";
        public static final String AGENT = "AGENT";  
        public static final String SHIPPER = "SHIPPER"; 

        
        public static final String PENDING_STATUS = "PENDING";
        public static final String APPROVED_STATUS = "APPROVED";
        public static final String REJECTED_STATUS = "REJECTED";
        public static final String DISPUTED_STATUS = "DISPUTED";
        
        public static final String AR_ACTUAL = "AR_ACTUAL";
        public static final String AP_ACCRUAL = "AP_ACCRUAL";
        public static final String AP_ACTUAL = "AP_ACTUAL";
        
        public static final String NOT_INVOICED_STATUS = "NOT INVOICED";
        public static final String PART_INVOICED_STATUS = "PART INVOICED"; 
        public static final String FULLY_INVOICED_STATUS = "FULLY INVOICED";
        
        public static final String READY_STATUS = "READY";
        public static final String PRINTED_STATUS = "PRINTED";
        public static final String POSTED_STATUS = "POSTED";
        
        public static final String MANUAL = "MANUAL";
        
        public static final String VIEW_ACTION = "View";
        public static final String CREATE_ACTION = "Create";
        public static final String DELETE_ACTION = "Delete";
        public static final String COPY_ACTION = "Copy";
        public static final String EDIT_ACTION = "Edit";
  
        
    	public static final String RESERVED_MOVSTS = "RESERVED";
    	public static final String AVAILABLE_MOVSTS = "AVAILABLE";
    	public static final String RETURNED_MOVSTS = "RETURNED";
    	public static final String TRANSIT_MOVSTS = "TRANSIT";
    	public static final String ARRIVED_MOVSTS = "ARRIVED";
    	public static final String SHIPPED_MOVSTS = "SHIPPED";
    	
    	public static final String AVAILABLE_INVSTS = "AV";
    	public static final String RESERVED_INVSTS = "RS";
    	
    	
    	public static final String FONT_NAME="c:\\windows\\fonts\\calibri.ttf";
    	public static final float FONT_SIZE=10f;
    	public static final Integer FONT_STYLE=0;
    	

        public static final String RUNNING_STATUS = "RUNNING";
        public static final String STOPPED_STATUS = "STOPPED";
        
        
        public static final String STORE = "STORE";
        public static final String GENERATE = "GENERATE";        
        
        public static final String CHECK_OUT = "CHECK_OUT";
        public static final String UNDO_CHECK_OUT = "UNDO_CHECK_OUT";
        public static final String CHECK_IN = "CHECK_IN";
        

        public static final String BASE_CURRENCY = "USD";
  
        
        
    	public static final String AI_DIRECTORY = "c:\\AI\\";
    	public static final String AI_OUTBOUND_DIRECTORY = "c:\\AI\\outbound\\";
    	public static final String AI_INBOUND_DIRECTORY = "c:\\AI\\inbound\\";
    	public static final String AI_RECIPIENT_ID = "MAS500";
    	
    	public static final String DELETED_STATUS = "DELETED";
    	public static final String ON_HOLD_STATUS = "ON_HOLD";
    	public static final String SENT_STATUS = "SENT";
    	public static final String IN_ERROR_STATUS = "IN_ERROR";
    	public static final String PROCESSED_STATUS = "PROCESSED";
    	
    	public static final String AR= "AR";	
    	public static final String AP= "AP";	
        
}
