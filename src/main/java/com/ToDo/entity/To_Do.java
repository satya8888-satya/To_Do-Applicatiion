package com.ToDo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class To_Do {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String title;
	private Date date;
	private String status;
	public To_Do() {
		super();
	}
	public To_Do(long Id, String title, Date date, String status) {
		super();
		this.Id = Id;
		this.title = title;
		this.date = date;
		this.status = status;
	}
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "To_Do [id=" + Id + ", title=" + title + ", date=" + date + ", status=" + status + "]";
	}
	

}
