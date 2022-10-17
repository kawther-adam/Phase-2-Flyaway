package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
	
@Id
	private int fid;
    private String flightName;
	private float price;
	private LocalDate dof;
	private int seats;
	private int pid;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getDof() {
		return dof;
	}
	public void setDof(LocalDate dof) {
		this.dof = dof;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", flightName=" + flightName + ", price=" + price + ", dof=" + dof + ", seats="
				+ seats + ", pid=" + pid + "]";
	}

}
