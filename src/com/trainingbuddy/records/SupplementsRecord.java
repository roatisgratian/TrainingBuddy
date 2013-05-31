package com.trainingbuddy.records;


import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="supplements")
public class SupplementsRecord implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2963901715316416102L;

	@DatabaseField(columnName="id", generatedId=true)
	private int id;

	@DatabaseField(columnName="name")
	private String name;

	@DatabaseField(columnName="description")
	private String description;

	@DatabaseField(columnName="nutritions")
	private String nutritions;
	
	@DatabaseField(columnName="supplement_icon")
	private String supplementIcon;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNutritions() {
		return nutritions;
	}

	public void setNutritions(String nutritions) {
		this.nutritions = nutritions;
	}

	public String getSupplementIcon() {
		return supplementIcon;
	}

	public void setSupplementIcon(String supplementIcon) {
		this.supplementIcon = supplementIcon;
	}

}
