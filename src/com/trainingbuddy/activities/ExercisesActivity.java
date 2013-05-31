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
import com.trainingbuddy.database.SupplementsDao;
import com.trainingbuddy.fragments.BMIFragment;
import com.trainingbuddy.fragments.MuscleExercisesFragment;
import com.trainingbuddy.records.ExerciseRecord;
import com.trainingbuddy.records.SupplementsRecord;

public class ExercisesActivity extends FragmentActivity {

	private ExerciseRecord[] exercises;
	private ExerciseRecord selectedExerciseType;
	private ExerciseRecord selectedExercise;
	private List<ExerciseRecord> exercisesList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here you`re selecting the layout you use
		setContentView(R.layout.exercises_container);
//		Getting the list of exercises from db and converting them to array so we can put the in the adapter
		exercisesList = ExerciseDao.getInstance().queryForAllDistinctExercises();
		exercises = exercisesList.toArray(new ExerciseRecord[exercisesList.size()]);
		//		The activity acts like a container and on this container I put the fragment
		//		I use fragments because they are faster
		Fragment createExerciseFragment = (Fragment)this.getSupportFragmentManager().findFragmentByTag("exercisesFragment");
//		Verifying if the exercisefragment was already created if not i add it
		if(createExerciseFragment==null)
		{
//			Here i add the fragment to a layout container (bmi_container)
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.add(R.id.exercises_container, new MuscleExercisesFragment(), "exercisesFragment");
			transaction.commit();
		}
	}
	
	public ExerciseRecord[] getExercises() {
		return exercises;
	}

	public void setExercises(ExerciseRecord[] exercises) {
		this.exercises = exercises;
	}

	public ExerciseRecord getSelectedExerciseType() {
		return selectedExerciseType;
	}

	public void setSelectedExerciseType(ExerciseRecord selectedExerciseType) {
		this.selectedExerciseType = selectedExerciseType;
	}

	public ExerciseRecord getSelectedExercise() {
		return selectedExercise;
	}

	public void setSelectedExercise(ExerciseRecord selectedExercise) {
		this.selectedExercise = selectedExercise;
	}

}
