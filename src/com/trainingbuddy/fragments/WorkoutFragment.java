package com.trainingbuddy.fragments;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.WorkoutActivity;
import com.trainingbuddy.adapters.WorkoutAdapter;
import com.trainingbuddy.database.WorkoutDao;
import com.trainingbuddy.records.WorkoutRecord;

public class WorkoutFragment extends Fragment{

	private ListView listView;
	private WorkoutRecord[] workouts;
	private WorkoutAdapter workoutsAdapter;
	private Button createWorkoutButton;
	private List<WorkoutRecord> workoutsList;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.workout_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here we get the items from the layout so we can use them
		listView = (ListView)getView().findViewById(android.R.id.list);
		createWorkoutButton = (Button)getView().findViewById(R.id.add_workout_button);
//		Geting the workout from database, turn in them into arrays and sending them into the adapter
		workoutsList = WorkoutDao.getInstance().queryForAllDistinctWorkouts();
		workouts = workoutsList.toArray(new WorkoutRecord[workoutsList.size()]);
		workoutsAdapter = new WorkoutAdapter(this.getActivity(), workouts);
		listView.setAdapter(workoutsAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Here i set the suppliment that i chosed from the lise
				((WorkoutActivity)getActivity()).setSelectedWorkout((WorkoutRecord)listView.getItemAtPosition(position));
//				And here you go in the Supplement information fragment
				FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.workout_container, new WorkoutDemonstrationFragment(), "workoutDemonstrationFragment");
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		
		createWorkoutButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Launching the AddWorkoutFragment
				FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.workout_container, new AddWorkoutFragment(), "addWorkoutFragment");
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}
}
