/*
 * $Id: Constants.java  $ 
 */


package com.bureaueye.beacon.bean.edi.itt;


/**
 * Manifest constants for the EDI ITT Application.
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */

public final class Constants {


    /**
     * The EDI_ID for ITT.
     */
    public static final String EDI_ID = "179305537";

    /**
     * The Sender address key for ITT.
     */    
    public static final String SENDERADDRKEY = "319569";

    /**
     * The control id file.
     */    
    public static final String CONTROL_ID_FILE = "c:/data/nextAvailableControlId.dat";

    public static final String FTP_LOG_FILE = "c:/tomcat 5.5/logs/FtpLog.log";
    
    public static final String EDI_DIRECTORY = "c:/EDI";

    public static final String EDI_OUTBOUND_DIRECTORY = "c:/EDI/outbound/";

    public static final String EDI_INBOUND_DIRECTORY = "c:/EDI/inbound/";
    
    public static final String EDI_FTP_DIRECTORY = "/tovan/";

    public static final String EDI_FTP_FROM_DIRECTORY = "/fromvan/";
    
    public static final String EDI_FTP_SERVERNAME = "ftp.ya.com";
    
    public static final String EDI_FTP_USERNAME = "bureaueye@ya.com";
    
    public static final String EDI_FTP_PASSWORD = "w00lw1ch";
    
}
