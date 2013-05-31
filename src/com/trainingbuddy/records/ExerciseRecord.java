package com.trainingbuddy.records;


import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="exercises")
public class ExerciseRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3759075067226042080L;

	@DatabaseField(columnName="id", generatedId=true)
	private int id;

	@DatabaseField(columnName="exercise_muscle_type")
	private String exerciseMuscleType;

	@DatabaseField(columnName="exercise_name")
	private String exerciseName;

	@DatabaseField(columnName="exercise_description")
	private String exerciseDescription;
	
	@DatabaseField(columnName="exercise_muscle_icon")
	private String exerciseMuscleIcon;
	
	@DatabaseField(columnName="exercise_name_step_icon")
	private String exerciseNameStepIcon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExerciseMuscleType() {
		return exerciseMuscleType;
	}

	public void setExerciseMuscleType(String exerciseMuscleType) {
		this.exerciseMuscleType = exerciseMuscleType;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getExerciseDescription() {
		return exerciseDescription;
	}

	public void setExerciseDescription(String exerciseDescription) {
		this.exerciseDescription = exerciseDescription;
	}

	public String getExerciseMuscleIcon() {
		return exerciseMuscleIcon;
	}

	public void setExerciseMuscleIcon(String exerciseMuscleIcon) {
		this.exerciseMuscleIcon = exerciseMuscleIcon;
	}

	public String getExerciseNameStepIcon() {
		return exerciseNameStepIcon;
	}

	public void setExerciseNameStepIcon(String exerciseNameStepIcon) {
		this.exerciseNameStepIcon = exerciseNameStepIcon;
	}
	
	
}
