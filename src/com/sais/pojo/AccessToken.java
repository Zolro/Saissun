package com.sais.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="accesstoken",uniqueConstraints = {@UniqueConstraint(columnNames="code")})
public class AccessToken implements Serializable{
	private int  pkey;
	private String code;
	private Date creatDate;
	public AccessToken() {
		super();
	}
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@XmlTransient
	public int getPkey() {
		return pkey;
	}
	@Column
	public String getCode() {
		return code;
	}
	@Column
	public Date getCreatDate() {
		return creatDate;
	}
	public void setPkey(int pkey) {
		this.pkey = pkey;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	
	
	
}
