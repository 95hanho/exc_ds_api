package me._hanho.ds.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "popup")
public class Popup {

	@Id
	private int popup_id;
	private int type;
	private Boolean status;
	
	private String name;
	
	public Popup() {
		// TODO Auto-generated constructor stub
	}

	public Popup(int popup_id, int type, Boolean status) {
		super();
		this.popup_id = popup_id;
		this.type = type;
		this.status = status;
	}

	public Popup(int popup_id, int type, Boolean status, String name) {
		super();
		this.popup_id = popup_id;
		this.type = type;
		this.status = status;
		this.name = name;
	}

	public int getPopup_id() {
		return popup_id;
	}

	public void setPopup_id(int popup_id) {
		this.popup_id = popup_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Popup [popup_id=" + popup_id + ", type=" + type + ", status=" + status + ", name=" + name + "]";
	}

}
