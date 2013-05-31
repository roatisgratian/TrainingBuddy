package com.trainingbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.trainingbuddy.R;

public class StartUpActivity extends Activity {

	private Button exercisesButton;
	private Button bmiButton;
	private Button workoutButton;
	private Button logbookButton;
	private Button supplementsButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_up_layout);
//		Getting the items from the layout 		
		exercisesButton = (Button) findViewById(R.id.exercises_button);
		bmiButton = (Button) findViewById(R.id.bmi_button);
		logbookButton = (Button) findViewById(R.id.logbook_button);
		workoutButton = (Button) findViewById(R.id.workout_button);
		supplementsButton = (Button) findViewById(R.id.supplements_button);
		
//		Setting on click listeners on buttons 
		exercisesButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent tabsIntent = new Intent(StartUpActivity.this, TabsActivity.class);
				tabsIntent.putExtra("clickedButton", "Exercises");
				startActivity(tabsIntent);
			}
		});
		
		bmiButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent tabsIntent = new Intent(StartUpActivity.this, TabsActivity.class);
				tabsIntent.putExtra("clickedButton", "BMI");
				startActivity(tabsIntent);				
			}
		});
		
		logbookButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent tabsIntent = new Intent(StartUpActivity.this, TabsActivity.class);
				tabsIntent.putExtra("clickedButton", "Logbook");
				startActivity(tabsIntent);				
			}
		});
		
		workoutButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent tabsIntent = new Intent(StartUpActivity.this, TabsActivity.class);
				tabsIntent.putExtra("clickedButton", "Workout");
				startActivity(tabsIntent);				
			}
		});
		
		supplementsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent tabsIntent = new Intent(StartUpActivity.this, TabsActivity.class);
				tabsIntent.putExtra("clickedButton", "Supplements");
				startActivity(tabsIntent);				
			}
		});
	}
}
