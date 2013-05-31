package com.trainingbuddy.fragments;

import java.util.List;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.WorkoutActivity;
import com.trainingbuddy.database.WorkoutDao;
import com.trainingbuddy.records.WorkoutRecord;

public class WorkoutDemonstrationFragment extends Fragment{
	
	private ImageView workoutExercisePicture;
	private Button nextButton;
	private TextView workoutTitle;
	private TextView workoutStep;
	private TextView repsNumber;
	private List<WorkoutRecord> workoutExerciseDemonstrationList;
	private int numberOfDemonstrations;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.workout_demonstration_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		This is a variable for me to know how much steps i showed already
		numberOfDemonstrations = 0;
//		Here we get the items from the layout so we can use them
		nextButton = (Button) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_demonstration_next_exercise_button);
		workoutExercisePicture = (ImageView) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_demonstration_exercise_image);
		workoutTitle = (TextView) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_title);
		workoutStep = (TextView) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_demonstation_exercise_step);
		repsNumber = (TextView) ((WorkoutActivity)getActivity()).findViewById(R.id.workout_exercise_reps);
		
		workoutTitle.setText(((WorkoutActivity)getActivity()).getSelectedWorkout().getWorkoutName());
		workoutExerciseDemonstrationList = WorkoutDao.getInstance().queryForDemonstrationByWorkoutName(((WorkoutActivity)getActivity()).getSelectedWorkout().getWorkoutName());
//		Setting the first demonstration on the screen
		if(numberOfDemonstrations == 0)
		{
			Drawable pic = getResources().getDrawable(getPicture(workoutExerciseDemonstrationList.get(numberOfDemonstrations).getWorkoutExerciseIcon()));
			workoutExercisePicture.setImageDrawable(pic);
			workoutStep.setText("Step " + String.valueOf(numberOfDemonstrations+1) + " - " + workoutExerciseDemonstrationList.get(numberOfDemonstrations).getExerciseName());
			repsNumber.setText("Complete " + workoutExerciseDemonstrationList.get(numberOfDemonstrations).getRepCount() + " reps for " + workoutExerciseDemonstrationList.get(numberOfDemonstrations).getSetsCount() + " sets.");
		}
		
		nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Checking if there are more workouts and 
//				If there are more workouts you go to the next workout demonstration
				if(numberOfDemonstrations < workoutExerciseDemonstrationList.size())
				{
					numberOfDemonstrations++;
					if(numberOfDemonstrations == workoutExerciseDemonstrationList.size())
					{
						Toast.makeText((WorkoutActivity)getActivity(), "There are no next steps.", Toast.LENGTH_LONG).show();
						numberOfDemonstrations--;
					}
					else
					{
					Drawable pic = getResources().getDrawable(getPicture(workoutExerciseDemonstrationList.get(numberOfDemonstrations).getWorkoutExerciseIcon()));
					workoutExercisePicture.setImageDrawable(pic);
					workoutStep.setText("Step " + String.valueOf(numberOfDemonstrations+1) + " - " + workoutExerciseDemonstrationList.get(numberOfDemonstrations).getExerciseName());
					repsNumber.setText("Complete " + workoutExerciseDemonstrationList.get(numberOfDemonstrations).getRepCount() + " reps for " + workoutExerciseDemonstrationList.get(numberOfDemonstrations).getSetsCount() + " sets.");
					}
				}
				else
				{
					Toast.makeText((WorkoutActivity)getActivity(), "There are no next steps.", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	//Method to get the picture dinamically knowing it`s name
	public int getPicture(String picName)
	{
		picName = picName.replace(".png", "");

		Resources r = getResources();
		int picId = r.getIdentifier(picName, "drawable", "com.trainingbuddy"); //aici poate trebe sa pun si .activities

		return picId;
	}
	
	//Method to make the first letter small
	public String smallFirstLetter(String original){
	    if(original.length() == 0)
	        return original;
	    return original.substring(0, 1).toLowerCase() + original.substring(1);
	}

}
