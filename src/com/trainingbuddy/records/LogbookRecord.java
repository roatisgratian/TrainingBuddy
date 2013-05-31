package com.trainingbuddy.records;


import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="logbook")
public class LogbookRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3759075067226042080L;

	@DatabaseField(columnName="id", generatedId=true)
	private int id;

	@DatabaseField(columnName="exercise_type")
	private String exerciseType;

	@DatabaseField(columnName="weight")
	private Double weight;

	@DatabaseField(columnName="rep_count")
	private int repCount;

	@DatabaseField(columnName="date")
	private String date;
	
	@DatabaseField(columnName="sets")
	private String sets;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public int getRepCount() {
		return repCount;
	}

	public void setRepCount(int repCount) {
		this.repCount = repCount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSets() {
		return sets;
	}

	public void setSets(String sets) {
		this.sets = sets;
	}
	
}
