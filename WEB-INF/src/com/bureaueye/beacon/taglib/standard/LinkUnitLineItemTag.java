package com.bureaueye.beacon.taglib.standard;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.config.ModuleConfig;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.MessageResources;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.model.standard.dto.UnitDTO;


public class LinkUnitLineItemTag extends TagSupport {

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
		ModuleConfig config = (ModuleConfig) pageContext.getRequest()
				.getAttribute(org.apache.struts.Globals.MODULE_KEY);
		StringBuffer url = new StringBuffer(((HttpServletRequest) pageContext
				.getRequest()).getContextPath());
		url.append(config.getPrefix());
		url.append(page);
		UnitDTO lineItem = null;
		String name = "unitLineItem";

		try {
			lineItem = (UnitDTO) pageContext.findAttribute(name);
		} catch (ClassCastException e) {
		}
		if (lineItem == null)
			throw new JspException(messages.getMessage("lineItem.noUnit",
					name));

		if (page.indexOf("?") < 0)
			url.append("?");
		else
			url.append("&");
		url.append(page.indexOf("action=") < 0 ? "id=" : "unitId=").append(
				TagUtils.getInstance().filter(lineItem.getUnitId().toString()));
		//url.append("unitId=");
		//url.append(TagUtils.getInstance().filter(lineItem.getUnitId().toString()));

		// Generate the hyperlink start element
		StringBuffer results = new StringBuffer("<a href=\"");
		results.append(((HttpServletResponse) pageContext.getResponse())
				.encodeURL(url.toString()));
		results.append("\">");

		try {
			pageContext.getOut().print(results.toString());
		} catch (IOException e) {
			throw new JspException(messages.getMessage("link.io", e.toString()));
		}

		// Evaluate the body of this tag
		return EVAL_BODY_INCLUDE;

	}

	public int doEndTag() throws JspException {

		// Print the ending element to our output writer
		try {
			pageContext.getOut().print("</a>");
		} catch (IOException e) {
			throw new JspException(messages.getMessage("link.io", e.toString()));
		}

		return EVAL_PAGE;

	}
}
