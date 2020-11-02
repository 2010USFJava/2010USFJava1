package com.revature.beans;

import java.io.Serializable;

import com.revature.util.Data;
import com.revature.util.LogThis;
import com.revature.util.Roster;

public class Baby implements Serializable
{
	private static final long serialVersionUID = 5482833746307693272L;
	
	private String firstName;
	private String lastName;
	private double weight;
	private double height;
	
	public Baby()
	{
		super();
		Roster.babyList.add(this);
		Data.writeBabyData(Roster.babyList);
	}
	
	public Baby(String firstName, String lastName, double weight, double height) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
		Roster.babyList.add(this);
		Data.writeBabyData(Roster.babyList);
		LogThis.logIt("info", "Welcome little... " + this.firstName + " " + this.lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Baby [firstName=" + firstName + ", lastName=" + lastName + ", weight=" + weight + ", height=" + height
				+ "]";
	}
	
	

}
