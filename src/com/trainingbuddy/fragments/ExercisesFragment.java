package com.trainingbuddy.fragments;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.ExercisesActivity;
import com.trainingbuddy.adapters.ExercisesAdapter;
import com.trainingbuddy.adapters.ExercisesDependingOnMuscleAdapter;
import com.trainingbuddy.database.ExerciseDao;
import com.trainingbuddy.records.ExerciseRecord;

public class ExercisesFragment extends Fragment{

	private ListView listView;
	private ExerciseRecord[] exercises;
	private List<ExerciseRecord> exercisesList;
	private ExercisesAdapter exercisesAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.exercises_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here we get the items from the layout so we can use them
		listView = (ListView)getView().findViewById(android.R.id.list);
		exercisesList = ExerciseDao.getInstance().queryForExercisesByExerciseType(((ExercisesActivity)getActivity()).getSelectedExerciseType().getExerciseMuscleType());
		exercises = exercisesList.toArray(new ExerciseRecord[exercisesList.size()]);
		ExercisesDependingOnMuscleAdapter exercisesAdapter = new ExercisesDependingOnMuscleAdapter(this.getActivity(), exercises);
		listView.setAdapter(exercisesAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Here i set the exercise that i chosed from the list
				((ExercisesActivity)getActivity()).setSelectedExercise((ExerciseRecord)listView.getItemAtPosition(position));
//				And here you go in the exercise demonstration fragment
				FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.exercises_container, new ExerciseDemonstrationFragment(), "exerciseDemonstrationFragment");
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}
}

