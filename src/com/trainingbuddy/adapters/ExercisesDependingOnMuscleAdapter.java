package com.trainingbuddy.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.records.ExerciseRecord;

public class ExercisesDependingOnMuscleAdapter extends ArrayAdapter<ExerciseRecord>
{
	private final Activity _context;
	private final ExerciseRecord[] _exercises;

	//	Giving the adapter the array of exercises and the context of the activity
	public ExercisesDependingOnMuscleAdapter(Activity context, ExerciseRecord[] exercises) {
		super(context, R.layout.exercise_row, exercises);
		this._exercises = exercises;
		this._context = context;
	}

	static class ViewHolder 
	{
		public TextView exerciseName;
	}
//	For each record we have in the array this method will be called and set a row in the listview
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{

		ViewHolder holder;
		View rowView = convertView;
		Log.i("Listview", "getView " + position + " " + convertView);
		//If the rowview didn`t get his layout and items from it he is null and he must get them
		if (rowView == null) 
		{
			LayoutInflater inflater = _context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.exercise_row, null, false);
			holder = new ViewHolder();

			holder.exerciseName = (TextView) rowView.findViewById(R.id.row_exercise_name);
			rowView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		ExerciseRecord exerciseRecord = _exercises[position];
		if(exerciseRecord!=null)
		{
			//			For each exercise we set the text and image from the database
			holder.exerciseName.setText(_exercises[position].getExerciseName());
		}

		return rowView;
	}
}

