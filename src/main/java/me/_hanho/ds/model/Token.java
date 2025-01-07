package me._hanho.ds.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int token_num;
	private String refresh_token;
	private String agent;
	private String connect_ip;
	private Date created_at;
	private String login_id;
	
	public Token() {}

	public Token(String refresh_token, String agent, String connect_ip) {
		super();
		this.refresh_token = refresh_token;
		this.agent = agent;
		this.connect_ip = connect_ip;
	}

	public Token(String refresh_token, String agent, String connect_ip, String login_id) {
		super();
		this.refresh_token = refresh_token;
		this.agent = agent;
		this.connect_ip = connect_ip;
		this.login_id = login_id;
	}

	public Token(int token_num, String refresh_token, String agent, String connect_ip,
			Date created_at, String login_id) {
		super();
		this.token_num = token_num;
		this.refresh_token = refresh_token;
		this.agent = agent;
		this.connect_ip = connect_ip;
		this.created_at = created_at;
		this.login_id = login_id;
	}

	public int getToken_num() {
		return token_num;
	}

	public void setToken_num(int token_num) {
		this.token_num = token_num;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getConnect_ip() {
		return connect_ip;
	}

	public void setConnect_ip(String connect_ip) {
		this.connect_ip = connect_ip;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "Token [token_num=" + token_num + ", refresh_token=" + refresh_token
				+ ", agent=" + agent + ", connect_ip=" + connect_ip + ", created_at=" + created_at + ", login_id="
				+ login_id + "]";
	}
	
}
