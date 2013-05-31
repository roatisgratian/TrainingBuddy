package com.trainingbuddy.records;


import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="workout")
public class WorkoutRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3759075067226042080L;

	@DatabaseField(columnName="id", generatedId=true)
	private int id;

	@DatabaseField(columnName="workout_name")
	private String workoutName;

	@DatabaseField(columnName="exercise_name")
	private String exerciseName;

	@DatabaseField(columnName="rep_count")
	private String repCount;
	
	@DatabaseField(columnName="sets_count")
	private String setsCount;
	
	@DatabaseField(columnName="workout_exercise_icon")
	private String workoutExerciseIcon;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getRepCount() {
		return repCount;
	}

	public void setRepCount(String repCount) {
		this.repCount = repCount;
	}

	public String getWorkoutExerciseIcon() {
		return workoutExerciseIcon;
	}

	public void setWorkoutExerciseIcon(String workoutExerciseIcon) {
		this.workoutExerciseIcon = workoutExerciseIcon;
	}

	public String getSetsCount() {
		return setsCount;
	}

	public void setSetsCount(String setsCount) {
		this.setsCount = setsCount;
	}

}
