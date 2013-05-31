package com.trainingbuddy.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.records.ExerciseRecord;

public class ExercisesAdapter extends ArrayAdapter<ExerciseRecord>
{
	private final Activity _context;
	private final ExerciseRecord[] _exercises;

	//	Giving the adapter the array of exercises and the context of the activity
	public ExercisesAdapter(Activity context, ExerciseRecord[] exercises) {
		super(context, R.layout.exercise_row, exercises);
		this._exercises = exercises;
		this._context = context;
	}

	static class ViewHolder 
	{
		public TextView exerciseName;
		public ImageView exerciseImage;
	}

//	For each record we have in the array this method will be called and set a row in the listview
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{

		ViewHolder holder;
		View rowView = convertView;
		Log.i("Listview", "getView " + position + " " + convertView);
		//      If the rowview didn`t get his layout and items from it he is null and he must get them
		if (rowView == null) 
		{
			LayoutInflater inflater = _context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.exercise_row, null, false);
			holder = new ViewHolder();

			holder.exerciseName = (TextView) rowView.findViewById(R.id.row_exercise_name);
			holder.exerciseImage = (ImageView) rowView.findViewById(R.id.row_exercise_image);
			rowView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		ExerciseRecord exerciseRecord = _exercises[position];
		if(exerciseRecord!=null)
		{
			//			For each exercise we set the text and image from the database
			holder.exerciseName.setText(capitalize(_exercises[position].getExerciseMuscleType()));
			holder.exerciseImage.setImageResource(getPicture(_exercises[position].getExerciseMuscleType()));
		}

		return rowView;
	}

	//	Method to get the picture dinamically by giving only it`s name
	public int getPicture(String picName)
	{
		picName = picName.replace(".png", "");
		Resources r = _context.getResources();
		int picId = r.getIdentifier(picName, "drawable", "com.trainingbuddy"); //aici poate trebe sa pun si .activities
		return picId;
	}
//	Method to make the first letter big (in the db is small)
	public static String capitalize(String s) {
        if (s.length() == 0) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}