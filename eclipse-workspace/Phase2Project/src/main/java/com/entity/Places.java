package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Places {
@Id
private int pid;
private String source;
private String destination;
@OneToMany
@JoinColumn(name = "pid")
private List<Flight> listOfFlight;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public List<Flight> getListOfFlight() {
	return listOfFlight;
}
public void setListOfFlight(List<Flight> listOfFlight) {
	this.listOfFlight = listOfFlight;
}
@Override
public String toString() {
	return "Places [pid=" + pid + ", source=" + source + ", destination=" + destination + ", listOfFlight="
			+ listOfFlight + "]";
}

}
