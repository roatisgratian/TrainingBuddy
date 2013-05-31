package com.trainingbuddy.fragments;

import java.sql.SQLException;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.WorkoutActivity;
import com.trainingbuddy.database.WorkoutDao;
import com.trainingbuddy.records.WorkoutRecord;

public class AddWorkoutFragment extends Fragment{

	//I modified the dish from dish position to dish
	//	Here we declare the elements from the dropdowns
	String[] EXERCISES = {"", "alternating crunches", "bar curl", "behind the neck shoulder press", "bench press", "bulgarian split squat",	"chest press", "crunches", "deadlift",
			"diamond push ups", "dish", "dumbell curls", "fly s", "front squat", "hammer curls", "mason twist",	"one arm tricep pull downs", "penguins",
			"romanian deadlift", "russian twists", "shoulder press", "shoulder press with bar", "should twists", "sits ups", "skull crush", "squat", "the plank", "the side plank", 
			"tricep extensions", "tricep pull downs", "under arm chin ups", "wide arm pull ups","wide arm push ups","zottman curls"};
	String SPINNER_EXERCISES [] = getResources().getStringArray(R.array.spinner_exercises);
	String[] REP = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16"};
	String[] SETS = {"1", "2", "3", "4", "5", "6", "7", "8"};
	
	private EditText workoutNameEditText;
	private Button saveWorkoutButton;
	private Spinner exerciseSpinner1;
	private Spinner repsSpinner1;
	private Spinner exerciseSpinner2;
	private Spinner repsSpinner2;
	private Spinner exerciseSpinner3;
	private Spinner repsSpinner3;
	private Spinner exerciseSpinner4;
	private Spinner repsSpinner4;
	private Spinner exerciseSpinner5;
	private Spinner repsSpinner5;
	private Spinner exerciseSpinner6;
	private Spinner repsSpinner6;
	private Spinner exerciseSpinner7;
	private Spinner repsSpinner7;
	private Spinner exerciseSpinner8;
	private Spinner repsSpinner8;
	private Spinner exerciseSpinner9;
	private Spinner repsSpinner9;
	private Spinner exerciseSpinner10;
	private Spinner repsSpinner10;
	private Spinner setsSpinner1;
	private Spinner setsSpinner2;
	private Spinner setsSpinner3;
	private Spinner setsSpinner4;
	private Spinner setsSpinner5;
	private Spinner setsSpinner6;
	private Spinner setsSpinner7;
	private Spinner setsSpinner8;
	private Spinner setsSpinner9;
	private Spinner setsSpinner10;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//		Here you`re selecting the layout you use
		return inflater.inflate(R.layout.workout_add_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//		Here we get the items from the layout so we can use them
		saveWorkoutButton =(Button) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_save_button);
		workoutNameEditText = (EditText) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_name_edittext);
		exerciseSpinner1 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner1);
		repsSpinner1 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner1);
		exerciseSpinner2 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner2);
		repsSpinner2 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner2);
		exerciseSpinner3 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner3);
		repsSpinner3 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner3);
		exerciseSpinner4 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner4);
		repsSpinner4 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner4);
		exerciseSpinner5 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner5);
		repsSpinner5 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner5);
		exerciseSpinner6 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner6);
		repsSpinner6 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner6);
		exerciseSpinner7 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner7);
		repsSpinner7 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner7);
		exerciseSpinner8 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner8);
		repsSpinner8 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner8);
		exerciseSpinner9 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner9);
		repsSpinner9 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner9);
		exerciseSpinner10 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_spinner10);
		repsSpinner10 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps_spinner10);
		setsSpinner1 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner1);
		setsSpinner2 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner2);
		setsSpinner3 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner3);
		setsSpinner4 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner4);
		setsSpinner5 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner5);
		setsSpinner6 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner6);
		setsSpinner7 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner7);
		setsSpinner8 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner8);
		setsSpinner9 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner9);
		setsSpinner10 = (Spinner) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_sets_spinner10);

		//		Here I populate the spinners(dropdowns)
		ArrayAdapter<String> exerciseArrayAdapter = new ArrayAdapter<String>((WorkoutActivity)getActivity(),  R.layout.spinner_item, SPINNER_EXERCISES);
		exerciseArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		exerciseSpinner1.setAdapter(exerciseArrayAdapter);
		exerciseSpinner2.setAdapter(exerciseArrayAdapter);
		exerciseSpinner3.setAdapter(exerciseArrayAdapter);
		exerciseSpinner4.setAdapter(exerciseArrayAdapter);
		exerciseSpinner5.setAdapter(exerciseArrayAdapter);
		exerciseSpinner6.setAdapter(exerciseArrayAdapter);
		exerciseSpinner7.setAdapter(exerciseArrayAdapter);
		exerciseSpinner8.setAdapter(exerciseArrayAdapter);
		exerciseSpinner9.setAdapter(exerciseArrayAdapter);
		exerciseSpinner10.setAdapter(exerciseArrayAdapter);
		ArrayAdapter<String> repArrayAdapter = new ArrayAdapter<String>((WorkoutActivity)getActivity(), R.layout.spinner_item, REP);
		repArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		repsSpinner1.setAdapter(repArrayAdapter);
		repsSpinner2.setAdapter(repArrayAdapter);
		repsSpinner3.setAdapter(repArrayAdapter);
		repsSpinner4.setAdapter(repArrayAdapter);
		repsSpinner5.setAdapter(repArrayAdapter);
		repsSpinner6.setAdapter(repArrayAdapter);
		repsSpinner7.setAdapter(repArrayAdapter);
		repsSpinner8.setAdapter(repArrayAdapter);
		repsSpinner9.setAdapter(repArrayAdapter);
		repsSpinner10.setAdapter(repArrayAdapter);
		ArrayAdapter<String> setsArrayAdapter = new ArrayAdapter<String>((WorkoutActivity)getActivity(), R.layout.spinner_item, SETS);
		repArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		setsSpinner1.setAdapter(setsArrayAdapter);
		setsSpinner2.setAdapter(setsArrayAdapter);
		setsSpinner3.setAdapter(setsArrayAdapter);
		setsSpinner4.setAdapter(setsArrayAdapter);
		setsSpinner5.setAdapter(setsArrayAdapter);
		setsSpinner6.setAdapter(setsArrayAdapter);
		setsSpinner7.setAdapter(setsArrayAdapter);
		setsSpinner8.setAdapter(setsArrayAdapter);
		setsSpinner9.setAdapter(setsArrayAdapter);
		setsSpinner10.setAdapter(setsArrayAdapter);
		
		saveWorkoutButton.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
//				If the workoutName editext is blank the user gest a mesage to insert one
				if(workoutNameEditText.getText().toString().trim().equals(""))
				{
					Toast.makeText((WorkoutActivity)getActivity(), "Please insert a workout name.", Toast.LENGTH_LONG).show();
				}
				else
				{
//					For each exercise that is set we insert one row in the database
					if(!exerciseSpinner1.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord = new WorkoutRecord();
						workoutRecord.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord.setWorkoutExerciseIcon(exerciseSpinner1.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord.setExerciseName(bigFirstLetter(exerciseSpinner1.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord.setRepCount(repsSpinner1.getSelectedItem().toString());
						workoutRecord.setSetsCount(setsSpinner1.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner2.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord2 = new WorkoutRecord();
						workoutRecord2.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord2.setWorkoutExerciseIcon(exerciseSpinner2.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord2.setExerciseName(bigFirstLetter(exerciseSpinner2.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord2.setRepCount(repsSpinner2.getSelectedItem().toString());
						workoutRecord2.setSetsCount(setsSpinner2.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord2);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner3.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord3 = new WorkoutRecord();
						workoutRecord3.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord3.setWorkoutExerciseIcon(exerciseSpinner3.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord3.setExerciseName(bigFirstLetter(exerciseSpinner3.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord3.setRepCount(repsSpinner3.getSelectedItem().toString());
						workoutRecord3.setSetsCount(setsSpinner3.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord3);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner4.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord4 = new WorkoutRecord();
						workoutRecord4.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord4.setWorkoutExerciseIcon(exerciseSpinner4.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord4.setExerciseName(bigFirstLetter(exerciseSpinner4.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord4.setRepCount(repsSpinner4.getSelectedItem().toString());
						workoutRecord4.setSetsCount(setsSpinner4.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord4);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner5.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord5 = new WorkoutRecord();
						workoutRecord5.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord5.setWorkoutExerciseIcon(exerciseSpinner5.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord5.setExerciseName(bigFirstLetter(exerciseSpinner5.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord5.setRepCount(repsSpinner5.getSelectedItem().toString());
						workoutRecord5.setSetsCount(setsSpinner5.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord5);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner6.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord6 = new WorkoutRecord();
						workoutRecord6.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord6.setWorkoutExerciseIcon(exerciseSpinner6.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord6.setExerciseName(bigFirstLetter(exerciseSpinner6.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord6.setRepCount(repsSpinner6.getSelectedItem().toString());
						workoutRecord6.setSetsCount(setsSpinner10.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord6);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner7.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord7 = new WorkoutRecord();
						workoutRecord7.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord7.setWorkoutExerciseIcon(exerciseSpinner7.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord7.setExerciseName(bigFirstLetter(exerciseSpinner7.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord7.setRepCount(repsSpinner7.getSelectedItem().toString());
						workoutRecord7.setSetsCount(setsSpinner7.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord7);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner8.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord8 = new WorkoutRecord();
						workoutRecord8.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord8.setWorkoutExerciseIcon(exerciseSpinner8.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord8.setExerciseName(bigFirstLetter(exerciseSpinner8.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord8.setRepCount(repsSpinner8.getSelectedItem().toString());
						workoutRecord8.setSetsCount(setsSpinner8.getSelectedItem().toString());

						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord8);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner9.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord9 = new WorkoutRecord();
						workoutRecord9.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord9.setWorkoutExerciseIcon(exerciseSpinner9.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord9.setExerciseName(bigFirstLetter(exerciseSpinner9.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord9.setRepCount(repsSpinner9.getSelectedItem().toString());
						workoutRecord9.setSetsCount(setsSpinner9.getSelectedItem().toString());
						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord9);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					if(!exerciseSpinner10.getSelectedItem().toString().equals(""))
					{
						WorkoutRecord workoutRecord10 = new WorkoutRecord();
						workoutRecord10.setWorkoutName(workoutNameEditText.getText().toString());
						workoutRecord10.setWorkoutExerciseIcon(exerciseSpinner10.getSelectedItem().toString().replaceAll("\\s", ""));
						workoutRecord10.setExerciseName(bigFirstLetter(exerciseSpinner10.getSelectedItem().toString().replaceAll("\\s", "_")));
						workoutRecord10.setRepCount(repsSpinner10.getSelectedItem().toString());
						workoutRecord10.setSetsCount(setsSpinner10.getSelectedItem().toString());
						try {
							WorkoutDao.getInstance().saveWorkout(workoutRecord10);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
//					after inserting the data in the db we go back to workout fragment
					FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
					transaction.replace(R.id.workout_container, new WorkoutFragment(), "workoutFragment");
					transaction.addToBackStack(null);
					transaction.commit();
				}
			}
		});
	}

		//Method to make the first letter small and eliminate spaces
		public String smallFirstLetterWithoutSpaces(String original){
			if(original.length() == 0)
				return original;
			return original.trim().substring(0, 1).toLowerCase() + original.substring(1);
		}
		
		//Method to make the first letter big
				public String bigFirstLetter(String original){
					if(original.length() == 0)
						return original;
					return original.trim().substring(0, 1).toUpperCase() + original.substring(1);
				}
	}