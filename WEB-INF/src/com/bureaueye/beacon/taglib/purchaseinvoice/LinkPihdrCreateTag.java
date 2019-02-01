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
import com.bureaueye.beacon.form.ListForm;

public class LinkPihdrCreateTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String page;

	private MessageResources messages = MessageResources
			.getMessageResources(Constants.APPLICATION_RESOURCES);

	public void setPage(String page) {
		this.page = page;
	}

	public int doStartTag() throws JspException {
		// Generate the URL to be encoded
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		ModuleConfig config = (ModuleConfig) request
				.getAttribute(org.apache.struts.Globals.MODULE_KEY);
		StringBuffer url = new StringBuffer(request.getContextPath());
		url.append(config.getPrefix()).append(page);
		ListForm listform = null;
		String name = "ListPihdrForm";

		try {
			listform = (ListForm) pageContext.findAttribute(name);
		} catch (ClassCastException e) {
		}
		if (listform == null)
			throw new JspException(messages.getMessage(
					"LinkPihdrCreateTag.noListPihdrForm",
					name));
		if (page.indexOf("?") < 0)
			url.append("?");
		else
			url.append("&");
		url.append("pihdrId=");
		url.append(TagUtils.getInstance().filter(listform.getId()));

		// Generate the hyperlink start element
		StringBuffer results = new StringBuffer("<a href=\"");
		results.append(((HttpServletResponse) pageContext.getResponse())
				.encodeURL(url.toString()));
		results.append("\">");

		// Print this element to our output writer
		try {
			pageContext.getOut().print(results.toString());
		} catch (IOException e) {
			throw new JspException(messages.getMessage("link.io", e.toString()));
		}

		// Evaluate the body of this tag
		return EVAL_BODY_INCLUDE;

	}

	public int doEndTag() throws JspException {

		JspWriter writer = pageContext.getOut();
		try {
			writer.print("</a>");
		} catch (IOException e) {
			throw new JspException(messages.getMessage("link.io", e.toString()));
		}

		return EVAL_PAGE;

	}
}
