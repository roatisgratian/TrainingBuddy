package com.trainingbuddy.activities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.trainingbuddy.R;
import com.trainingbuddy.database.PopulateDatabaseTask;

public class SplashScreenActivity extends Activity {

	CountDownTimer cdt;
	int total;
	ProgressBar bar;
	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final long ONE_DAY = 1000;//24 * 60 * 60 * 1000;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//		Removing the title from the splash screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//		Selecting the layout for the spalsh screen
		setContentView(R.layout.splash_screen_layout);
		SharedPreferences sharedPreferences = getSharedPreferences("hasRunBefore", 0); //load the preferences

		bar = (ProgressBar) findViewById(R.id.splash_progressbar);
		//		bar.setProgress(total);
		int twoSec= 1 * 2 * 1000; // 2 seconds in milli seconds

		//		Here we check if is the first time tha application run
		Boolean hasRun = sharedPreferences.getBoolean("hasRun", false); //see if it's run before, default no
		if (!hasRun) {
			SharedPreferences settings = getSharedPreferences("hasRunBefore", 0);
			SharedPreferences.Editor edit = settings.edit();
			edit.putBoolean("hasRun", true); //set to has run
			edit.commit(); //apply
			//code for if this is the first time the app has run
			//			If is the first time we populate the database
			PopulateDatabaseTask populateDatabaseTask = new PopulateDatabaseTask(this);
			populateDatabaseTask.execute(this);
		}
		else {
			//code if the app HAS run before
			cdt = new CountDownTimer(twoSec, 100) { 
				/** CountDownTimer starts with 2 seconds and every onTick is 100 miliseconds and the progressbar increase with value of 5 */
				public void onTick(long l) {

					total +=5; 
					bar.setProgress(total);
				}

				public void onFinish() {
					// DO something when 2 sec is up (Starting the startup screen)
					Intent mainIntent = new Intent(SplashScreenActivity.this, StartUpActivity.class);
					SplashScreenActivity.this.startActivity(mainIntent);
					SplashScreenActivity.this.finish();
				}
			}.start();
		}
	}
}

