package com.bureaueye.beacon.ajax.rss;

import java.io.IOException;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.dto.QuohdrDTO;

import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;

import javax.servlet.*;



/*	
Required channel elements 

Here's a list of the required channel elements, each with a brief description, an example, and where available, a pointer to a more complete description.
Element	Description	Example
title	The name of the channel. It's how people refer to your service. If you have an HTML website that contains the same information as your RSS file, the title of your channel should be the same as the title of your website. 	GoUpstate.com News Headlines
link	The URL to the HTML website corresponding to the channel.	http://www.goupstate.com/
description       	Phrase or sentence describing the channel.	The latest news from GoUpstate.com, a Spartanburg Herald-Journal Web site.


Optional channel elements 

Here's a list of optional channel elements.
Element	Description	Example
language	The language the channel is written in. This allows aggregators to group all Italian language sites, for example, on a single page. A list of allowable values for this element, as provided by Netscape, is here. You may also use values defined by the W3C.	en-us
copyright	Copyright notice for content in the channel.	Copyright 2002, Spartanburg Herald-Journal
managingEditor	Email address for person responsible for editorial content.	geo@herald.com (George Matesky)
webMaster	Email address for person responsible for technical issues relating to channel.	betty@herald.com (Betty Guernsey)
pubDate	The publication date for the content in the channel. For example, the New York Times publishes on a daily basis, the publication date flips once every 24 hours. That's when the pubDate of the channel changes. All date-times in RSS conform to the Date and Time Specification of RFC 822, with the exception that the year may be expressed with two characters or four characters (four preferred).	Sat, 07 Sep 2002 00:00:01 GMT
lastBuildDate	The last time the content of the channel changed.	Sat, 07 Sep 2002 09:42:31 GMT
category	Specify one or more categories that the channel belongs to. Follows the same rules as the <item>-level category element. More info.	<category>Newspapers</category>
generator	A string indicating the program used to generate the channel.	MightyInHouse Content System v2.3
docs	A URL that points to the documentation for the format used in the RSS file. It's probably a pointer to this page. It's for people who might stumble across an RSS file on a Web server 25 years from now and wonder what it is.	http://blogs.law.harvard.edu/tech/rss
cloud	Allows processes to register with a cloud to be notified of updates to the channel, implementing a lightweight publish-subscribe protocol for RSS feeds. More info here.	<cloud domain="rpc.sys.com" port="80" path="/RPC2" registerProcedure="pingMe" protocol="soap"/>
ttl	ttl stands for time to live. It's a number of minutes that indicates how long a channel can be cached before refreshing from the source. More info here.	<ttl>60</ttl>
image	Specifies a GIF, JPEG or PNG image that can be displayed with the channel. More info here.	
rating	The PICS rating for the channel.	
textInput	Specifies a text input box that can be displayed with the channel. More info here.	
skipHours	A hint for aggregators telling them which hours they can skip. More info here.	
skipDays	A hint for aggregators telling them which days they can skip. More info here.

Elements of <item> 

A channel may contain any number of <item>s. An item may represent a "story" -- much like a story in a newspaper or magazine; if so its description is a synopsis of the story, and the link points to the full story. An item may also be complete in itself, if so, the description contains the text (entity-encoded HTML is allowed; see examples), and the link and title may be omitted. All elements of an item are optional, however at least one of title or description must be present.
Element	Description	Example
title	The title of the item.	Venice Film Festival Tries to Quit Sinking
link	The URL of the item.	http://nytimes.com/2004/12/07FEST.html
description     	The item synopsis.	Some of the most heated chatter at the Venice Film Festival this week was about the way that the arrival of the stars at the Palazzo del Cinema was being staged.
author	Email address of the author of the item. More.	oprah\@oxygen.net
category	Includes the item in one or more categories. More.	 
comments	URL of a page for comments relating to the item. More.	http://www.myblog.org/cgi-local/mt/mt-comments.cgi?entry_id=290
enclosure	Describes a media object that is attached to the item. More.	
guid	A string that uniquely identifies the item. More.	http://inessential.com/2002/09/01.php#a2
pubDate	Indicates when the item was published. More.	Sun, 19 May 2002 15:21:36 GMT
source	The RSS channel that the item came from. More.	 
*/


public final class RefreshListServlet extends BaseAJAX {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		//String invoiceno = request.getParameter("invoiceno");
			
		StringBuffer results = new StringBuffer("");
		
		//results.append("<rss version='2.0' xmlns:dc='http://purl.org/dc/elements/1.1/'>");
		results.append("<channel>");

/*		results.append("<title>The channel's name goes here</title>"+
	    "<link>http://www.urlofthechannel.com/</link>"+
	    "<description>This channel is an example channel for an article.</description>"+
	    "<language>en-us</language>"+
	    "<image>"+
	    "<title>The image title goes here</title>"+
	    "<url>http://www.urlofthechannel.com/images/logo.gif</url>"+
	    "<link>http://www.urlofthechannel.com/</link>"+
	    "</image>");*/
	      
		// init business delegate fields
		ListForm listForm = new ListForm();
		listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
		listForm.setGotoPage(0);
		listForm.setSearchString1("%");
		listForm.setSearchString2("%");
		listForm.setSearchString9("%");
		listForm.setSearchString10("%");
		listForm.setSearchString11("%");
		listForm.setSearchString12("%");
		listForm.setSearchString13("%");
		
		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(new SystemcodeBD(this.getSessionFactoryClusterMap())
											.read(new SystemcodePK("DATERANGEDAYS","LISTQUOHDR"))
											.getDescr())
											.intValue();
		}catch(Exception e){}
		// quote date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);			
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		// quote date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus 7 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}
		listForm.setOrderBy("Quotedate");
		listForm.setOrderByDesc("Desc");
		
		List dtos = null;		
		try {
			dtos = new QuohdrBD(this.getSessionFactoryClusterMap())
						.findQuohdrsBySearch(listForm);
		} catch (ApplicationException ae) {}	
		
		for(Iterator it = dtos.iterator(); it.hasNext();) {
			QuohdrDTO dto = (QuohdrDTO)it.next();

			results.append("<item>");
			results.append("<title>"+dto.getQuotno()+"</title>");
			results.append("<link>http://www.itworld.com/nl/ecom_in_act/11122003/</link>");
			results.append("<description>"+dto.getQuotno()+"</description>");
			results.append("</item>");		    

		}
			
		
		
		results.append("</channel>");
	
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");		
		response.getWriter().write(results.toString());
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
}
