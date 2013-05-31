package com.trainingbuddy.records;


import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="bmi")
public class BMIRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3759075067226042080L;

	@DatabaseField(columnName="id", generatedId=true)
	private int id;

	@DatabaseField(columnName="weight")
	private Double weight;

	@DatabaseField(columnName="height")
	private Double height;

	@DatabaseField(columnName="bmi")
	private Double bmi;

	@DatabaseField(columnName="date")
	private String date;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getBmi() {
		return bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}
