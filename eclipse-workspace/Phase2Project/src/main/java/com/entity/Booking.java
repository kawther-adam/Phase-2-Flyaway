package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String pname;
	private int numberOfSeats;
	private float totalAmount;
@OneToOne
	private Flight fid;
@OneToOne
	private Places pid;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Flight getFid() {
		return fid;
	}
	public void setFid(Flight fid) {
		this.fid = fid;
	}
	public Places getPid() {
		return pid;
	}
	public void setPid(Places pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", pname=" + pname + ", numberOfSeats=" + numberOfSeats + ", totalAmount="
				+ totalAmount + ", fid=" + fid + ", pid=" + pid + "]";
	}

	

}
