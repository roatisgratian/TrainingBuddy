package com.trainingbuddy.activities;

import java.sql.SQLException;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.trainingbuddy.R;
import com.trainingbuddy.database.ExerciseDao;
import com.trainingbuddy.database.WorkoutDao;
import com.trainingbuddy.fragments.MuscleExercisesFragment;
import com.trainingbuddy.fragments.WorkoutFragment;
import com.trainingbuddy.records.ExerciseRecord;
import com.trainingbuddy.records.WorkoutRecord;

public class WorkoutActivity extends FragmentActivity {

	private WorkoutRecord[] workouts;
	private WorkoutRecord selectedWorkout;
	private List<WorkoutRecord> workoutsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here you select the layout that will be used for this activity
		setContentView(R.layout.workout_container);
		
		Fragment workoutFragment = (Fragment)this.getSupportFragmentManager().findFragmentByTag("workoutFragment");
//		Verifying if the bmifragment was already created if not i add it
		if(workoutFragment==null)
		{
//			Here i add the fragment to a layout container (bmi_container)
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.add(R.id.workout_container, new WorkoutFragment(), "workoutFragment");
			transaction.commit();
		}
	}

	public WorkoutRecord[] getWorkouts() {
		return workouts;
	}

	public void setWorkouts(WorkoutRecord[] workouts) {
		this.workouts = workouts;
	}

	public WorkoutRecord getSelectedWorkout() {
		return selectedWorkout;
	}

	public void setSelectedWorkout(WorkoutRecord selectedWorkout) {
		this.selectedWorkout = selectedWorkout;
	}

	public List<WorkoutRecord> getWorkoutsList() {
		return workoutsList;
	}

	public void setWorkoutsList(List<WorkoutRecord> workoutsList) {
		this.workoutsList = workoutsList;
	}
	
}
