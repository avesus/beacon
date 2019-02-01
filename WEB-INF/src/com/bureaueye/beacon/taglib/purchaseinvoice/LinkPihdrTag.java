/*
 */


package com.bureaueye.beacon.taglib.purchaseinvoice;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.config.ModuleConfig;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.MessageResources;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.form.purchaseinvoice.PihdrForm;





/**
 * Generate a URL-encoded hyperlink to the specified URI, with
 * associated query parameters selecting a specified Subscription.
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */

public class LinkPihdrTag extends TagSupport {
	private static final long serialVersionUID = 1L;


	/**
     * The context-relative URI.
     */
    protected String page = null;


    /**
     * The message resources for this package.
     */
    protected static MessageResources messages =
	MessageResources.getMessageResources
	(Constants.APPLICATION_RESOURCES);


    /**
     * The attribute name.
     */
    private String name = "PihdrForm";


    // ------------------------------------------------------------- Properties


    /**
     * Return the context-relative URI.
     */
    public String getPage() {

	return (this.page);

    }


    /**
     * Set the context-relative URI.
     *
     * @param page Set the context-relative URI
     */
    public void setPage(String page) {

	this.page = page;

    }


    /**
     * Return the attribute name.
     */
    public String getName() {

	return (this.name);

    }


    /**
     * Set the attribute name.
     *
     * @param name The new attribute name
     */
    public void setName(String name) {

	this.name = name;

    }


    // --------------------------------------------------------- Public Methods


    /**
     * Render the beginning of the hyperlink.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doStartTag() throws JspException {

	// Generate the URL to be encoded
        ModuleConfig config = (ModuleConfig) pageContext.getRequest()
            .getAttribute(org.apache.struts.Globals.MODULE_KEY);
        HttpServletRequest request =
          (HttpServletRequest) pageContext.getRequest();
        StringBuffer url = new StringBuffer(request.getContextPath());
	url.append(config.getPrefix());
        url.append(page);
 
        PihdrForm form = null;
        try {
        	form = (PihdrForm) pageContext.findAttribute(name);
        } catch (ClassCastException e) {
        	form = null;
        }     
	if (form == null)
	    throw new JspException
	        (messages.getMessage("form.noPihdr", name));
	if (page.indexOf("?") < 0)
	    url.append("?");
	else
	    url.append("&");
	url.append("id=");
	url.append(TagUtils.getInstance().filter(form.getId()));		

	// Generate the hyperlink start element
	HttpServletResponse response =
	  (HttpServletResponse) pageContext.getResponse();
	StringBuffer results = new StringBuffer("<a href=\"");
	results.append(response.encodeURL(url.toString()));
	results.append("\">");

	// Print this element to our output writer
	JspWriter writer = pageContext.getOut();
	try {
	    writer.print(results.toString());
	} catch (IOException e) {
	    throw new JspException
		(messages.getMessage("form.io", e.toString()));
	}

	// Evaluate the body of this tag
	return (EVAL_BODY_INCLUDE);

    }



    /**
     * Render the end of the hyperlink.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException {


	// Print the ending element to our output writer
	JspWriter writer = pageContext.getOut();
	try {
	    writer.print("</a>");
	} catch (IOException e) {
	    throw new JspException
	        (messages.getMessage("link.io", e.toString()));
	}

	return (EVAL_PAGE);

    }


    /**
     * Release any acquired resources.
     */
    public void release() {

        super.release();
        this.page = null;
        this.name = "QuohdrForm";

    }


}
