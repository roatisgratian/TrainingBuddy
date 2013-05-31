package com.trainingbuddy.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.records.WorkoutRecord;

public class WorkoutAdapter extends ArrayAdapter<WorkoutRecord>
{
	private final Activity _context;
	private final WorkoutRecord[] _workoutRecords;

	//	Giving the adapter the array of exercises and the context of the activity
	public WorkoutAdapter(Activity context, WorkoutRecord[] workoutRecords) {
		super(context, R.layout.workout_row, workoutRecords);
		this._context = context;
		this._workoutRecords = workoutRecords;
	}

	static class ViewHolder 
	{
		public TextView workoutName;
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
			rowView = inflater.inflate(R.layout.workout_row, null, false);
			holder = new ViewHolder();

			holder.workoutName = (TextView) rowView.findViewById(R.id.row_workout_name);
			rowView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		WorkoutRecord workoutRecord = _workoutRecords[position];
		if(workoutRecord!=null)
		{
			//			For each workout we set the text and image from the database
			holder.workoutName.setText(_workoutRecords[position].getWorkoutName());
		}

		return rowView;
	}
}