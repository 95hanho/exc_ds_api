package me._hanho.ds.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	private String login_id;
	private String login_pwd;
	private int grant; // 90
	private String insa; // 관리자1
	private String name; // 관리자1
	private int type; // 3
	
	public User() {}
	public User(String login_id, String login_pwd, int grant, String insa, String name, int type) {
		super();
		this.login_id = login_id;
		this.login_pwd = login_pwd;
		this.grant = grant;
		this.insa = insa;
		this.name = name;
		this.type = type;
	}
	
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}
	public int getGrant() {
		return grant;
	}
	public void setGrant(int grant) {
		this.grant = grant;
	}
	public String getInsa() {
		return insa;
	}
	public void setInsa(String insa) {
		this.insa = insa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [login_id=" + login_id + ", login_pwd=" + login_pwd + ", grant=" + grant + ", insa=" + insa
				+ ", name=" + name + ", type=" + type + "]";
	}
}
