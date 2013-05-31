package com.trainingbuddy.fragments;

import java.sql.SQLException;
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
import com.trainingbuddy.activities.BMIActivity;
import com.trainingbuddy.activities.ExercisesActivity;
import com.trainingbuddy.database.ExerciseDao;
import com.trainingbuddy.records.ExerciseRecord;

public class ExerciseDemonstrationFragment extends Fragment{
	
	private ImageView exercisePicture;
	private Button previousButton;
	private Button nextButton;
	private TextView exerciseDescription;
	private TextView exerciseName;
	private List<ExerciseRecord> exerciseDemonstrationList;
	private int numberOfDemonstrations;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.exercise_demonstration_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		numberOfDemonstrations = 0;
//		Geting the layout items
		previousButton = (Button) ((ExercisesActivity)getActivity()).findViewById(R.id.demonstration_previous_exercise);
		nextButton = (Button) ((ExercisesActivity)getActivity()).findViewById(R.id.demonstration_next_exercise);
		exercisePicture = (ImageView) ((ExercisesActivity)getActivity()).findViewById(R.id.demonstration_exercise_image);
		exerciseDescription = (TextView) ((ExercisesActivity)getActivity()).findViewById(R.id.demonstration_exercise_description);
		exerciseName = (TextView) ((ExercisesActivity)getActivity()).findViewById(R.id.demonstation_exercise_name_textview);
//		Here we get the exercise steps from database
		exerciseDemonstrationList = ExerciseDao.getInstance().queryForDemonstrationByExerciseName(((ExercisesActivity)getActivity()).getSelectedExercise().getExerciseName(), ((ExercisesActivity)getActivity()).getSelectedExercise().getExerciseMuscleType());
		
		if(numberOfDemonstrations == 0)
		{
			Drawable pic = getResources().getDrawable(getPicture(exerciseDemonstrationList.get(numberOfDemonstrations).getExerciseNameStepIcon()));
			exercisePicture.setImageDrawable(pic);
			exerciseDescription.setText(exerciseDemonstrationList.get(numberOfDemonstrations).getExerciseDescription());
			exerciseName.setText(exerciseDemonstrationList.get(numberOfDemonstrations).getExerciseName());
		}
//	Trebe sa ma gandesc cum sa deosebesc diferitii pasi ai unui exercitiu	
		previousButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				checking if there is a previous step and if it is putting the previous on the screen
				if(numberOfDemonstrations>0)
				{
					numberOfDemonstrations--;
					Drawable pic = getResources().getDrawable(getPicture(exerciseDemonstrationList.get(numberOfDemonstrations).getExerciseNameStepIcon()));
					exercisePicture.setImageDrawable(pic);
					exerciseDescription.setText(exerciseDemonstrationList.get(numberOfDemonstrations).getExerciseDescription());
				}else 
				{
					Toast.makeText(((ExercisesActivity)getActivity()), "There are no previous steps.", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Verifying if there is a next step and if it is to put the next demonstration
				if(numberOfDemonstrations < exerciseDemonstrationList.size())
				{
					numberOfDemonstrations++;
					if(numberOfDemonstrations == exerciseDemonstrationList.size() )
					{
						Toast.makeText(((ExercisesActivity)getActivity()), "There are no next steps.", Toast.LENGTH_LONG).show();
						numberOfDemonstrations--;
					}
					else
					{
					Drawable pic = getResources().getDrawable(getPicture(exerciseDemonstrationList.get(numberOfDemonstrations).getExerciseNameStepIcon()));
					exercisePicture.setImageDrawable(pic);
					exerciseDescription.setText(exerciseDemonstrationList.get(numberOfDemonstrations).getExerciseDescription());
					}
					
				} 
				else
				{
					Toast.makeText(((ExercisesActivity)getActivity()), "There are no next steps.", Toast.LENGTH_LONG).show();
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
	
}
