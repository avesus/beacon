package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bureaueye.beacon.model.standard.dto.CustomertariffdtlDTO;

public class ListCustomertariffdtlForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private List list;

	private int[] selectedObjects;

	private String id;

	private Object header;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Object getHeader() {
		return header;
	}

	public void setHeader(Object header) {
		this.header = header;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSelectedObjects(int[] selectedObjects) {
		this.selectedObjects = selectedObjects;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int[] getSelectedObjects() {
		return selectedObjects;
	}

	public CustomertariffdtlDTO getCustomertariffdtlDTO(int i) {
		if (getList() == null) {
			setList(new ArrayList());
		}

		while (getList().size() <= i) {
			getList().add(new CustomertariffdtlDTO());
		}

		return (CustomertariffdtlDTO) getList().get(i);
	}

}
