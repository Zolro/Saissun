package com.sais.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="WxUser",uniqueConstraints = {@UniqueConstraint(columnNames="openid")})
public class WeChatUser implements Serializable{
	private int pkey;
	private int subscribe;
	private String openid;
	private String nickname;
	private int sex;
	private String city;
	private String country;
	private String province;
	private String language;
	private String headimgurl;
	private Date subscribe_time;
	private String creatTime;
	private String remark;
	private int groupid;
	private int[] tagid_list;
	public WeChatUser() {
		super();
	}
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getPkey() {
		return pkey;
	}
	public void setPkey(int pkey) {
		this.pkey = pkey;
	}
	@Column
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	@Column
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column
	public String getNickname() {
		return nickname;
	}
	@Column
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	@Column
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Column
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	@Column
	public Date getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	@Column
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	@Column
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	@Column
	public int[] getTagid_list() {
		return tagid_list;
	}
	public void setTagid_list(int[] tagid_list) {
		this.tagid_list = tagid_list;
	}
	
	
	
	
		
	
}
