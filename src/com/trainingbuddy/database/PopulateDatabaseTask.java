package com.trainingbuddy.database;

import java.sql.SQLException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.trainingbuddy.activities.StartUpActivity;
import com.trainingbuddy.database.data.ExerciseData;
import com.trainingbuddy.database.data.SupplimentData;
import com.trainingbuddy.database.data.WorkoutData;

public class PopulateDatabaseTask  extends AsyncTask<Object, Void, Boolean> {

	private Activity _activity;
	private ProgressDialog progDailog;

	public PopulateDatabaseTask(Context activity) {
//		making a progress dialog to let the user know were populating the daatabase.
		progDailog = new ProgressDialog(activity);
		progDailog.setMessage("Populating the database. Please wait...");
		progDailog.setIndeterminate(false);
		progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progDailog.setCancelable(true);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
//		Making the progress dialog visible
		this.progDailog.show();
	}

	@Override
	protected Boolean doInBackground(Object... params) {

		_activity = (Activity)params[0];
//		Insert the datas into the database
	    try {
			SupplimentData.insertSupplimentsInDatabase();
			ExerciseData.insertExercisesInDatabase();
			WorkoutData.insertWorkoutsInDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
//		progress dialog closed
		progDailog.dismiss();
//		Changing to the startup screen
		Intent mainIntent = new Intent(_activity, StartUpActivity.class);
		_activity.startActivity(mainIntent);
		_activity.finish();

	}
}

