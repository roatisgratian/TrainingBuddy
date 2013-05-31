package com.trainingbuddy.fragments;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.LogbookActivity;
import com.trainingbuddy.database.LogbookDao;
import com.trainingbuddy.records.LogbookRecord;

public class LogbookFragment extends Fragment{
	
//	Here we declare the elements from the dropdowns
	String[] EXERCISES = {"alternating crunches", "bar curl", "behind the neck shoulder press", "bench press", "bulgarian split squat",	"chest press", "crunches", "deadlift",
			"diamond push ups", "dish", "dumbell curls", "fly's", "front squat", "hammer curls", "mason twist",	"one arm tricep pull downs", "penguins",
			"romanian deadlift", "russian twists", "shoulder press", "shoulder press with bar", "should twists", "sits ups", "skull crush", "squat", "the plank", "the side plank",
			"tricep extensions", "tricep pull downs", "under arm chin ups", "wide arm pull ups","wide arm push ups","zottman curls"};
	String SPINNER_EXERCISES [] = getResources().getStringArray(R.array.spinner_exercises);
	String[] WEIGHT = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30","31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
			"41", "42", "43", "44", "45", "46", "47", "48", "49", "50","51", "52", "53", "54", "55", "56", "57", "58", "59", "50","51", "52", "53", "54", "55", "56", "57", "58", "59", "60","61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80","81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};
	String[] REP = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16"};
	String[] SETS = {"1", "2", "3", "4", "5", "6", "7", "8"};
//	
	private Spinner exerciseSpinner;
	private Spinner weightSpinner;
	private Spinner repSpinner;
	private Button addStatsButton;
	private Button checkStatsButton;
	private LinearLayout weightLayout;
	private Spinner setsSpinner;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		Here you`re selecting the layout you use
		return inflater.inflate(R.layout.logbook_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here we get the items from the layout so we can use them
		exerciseSpinner = (Spinner) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_exercise_type_spinner);
		weightSpinner = (Spinner) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_weight_spinner);
		repSpinner = (Spinner) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_rep_count_spinner);
		setsSpinner = (Spinner) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_sets_spinner);
		addStatsButton =(Button) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_add_to_stats_button);
		checkStatsButton = (Button) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_check_stats_button);
		weightLayout = (LinearLayout)((LogbookActivity)getActivity()).findViewById(R.id.logbook_weight_layout);
//		Here I populate the spinners(dropdowns)
		ArrayAdapter<String> exerciseArrayAdapter = new ArrayAdapter<String>((LogbookActivity)getActivity(), R.layout.spinner_item, SPINNER_EXERCISES);
		exerciseArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		exerciseSpinner.setAdapter(exerciseArrayAdapter);
			
		ArrayAdapter<String> weightArrayAdapter = new ArrayAdapter<String>((LogbookActivity)getActivity(), R.layout.spinner_item, WEIGHT);
		weightArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		weightSpinner.setAdapter(weightArrayAdapter);
			
		ArrayAdapter<String> repArrayAdapter = new ArrayAdapter<String>((LogbookActivity)getActivity(),  R.layout.spinner_item, REP);
		repArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		repSpinner.setAdapter(repArrayAdapter);
		
		ArrayAdapter<String> setsArrayAdapter = new ArrayAdapter<String>((LogbookActivity)getActivity(), R.layout.spinner_item, SETS);
		setsArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		setsSpinner.setAdapter(setsArrayAdapter);
		
		exerciseSpinner.setOnItemSelectedListener( new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
//				if(arg0.getChildAt(0) !=null)
//				{
//					((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
//				}
				
//				Verifying if an abs exercise is selected and showing the weight or not
				if(exerciseSpinner.getSelectedItem().equals("dish position") ||
						exerciseSpinner.getSelectedItem().equals("alternating crunches") ||
						exerciseSpinner.getSelectedItem().equals("russian twists") ||
						exerciseSpinner.getSelectedItem().equals("sits ups") ||
						exerciseSpinner.getSelectedItem().equals("crunches") ||
						exerciseSpinner.getSelectedItem().equals("penguins") ||
						exerciseSpinner.getSelectedItem().equals("the plank") ||
						exerciseSpinner.getSelectedItem().equals("the side plank") ||
						exerciseSpinner.getSelectedItem().equals("mason twist") )
				{
					weightLayout.setVisibility(View.GONE);
				}
				else
				{
					weightLayout.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
//		Making the selected item from the spinner white
//		weightSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//			@Override
//			public void onItemSelected(AdapterView<?> arg0, View arg1,
//					int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				if(arg0.getChildAt(0) !=null)
//				{
//				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
//				}
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				// TODO Auto-generated method stub
//			}
//		});
//		
//		repSpinner.setOnItemSelectedListener( new OnItemSelectedListener() {
//
//			@Override
//			public void onItemSelected(AdapterView<?> arg0, View arg1,
//					int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				if(arg0.getChildAt(0) !=null)
//				{
//				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
//				}
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				// TODO Auto-generated method stub
//			}
//		});
//		
//		setsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//			@Override
//			public void onItemSelected(AdapterView<?> arg0, View arg1,
//					int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				if(arg0.getChildAt(0) !=null)
//				{
//				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
//				}
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		addStatsButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				LogbookRecord logbookRecord = new LogbookRecord();
				logbookRecord.setExerciseType(exerciseSpinner.getSelectedItem().toString());
				logbookRecord.setRepCount(Integer.parseInt(repSpinner.getSelectedItem().toString()));
//				Verifying if an abs exercise is selected and if yes put 0 weight in the database
				if(exerciseSpinner.getSelectedItem().equals("dish position") ||
						exerciseSpinner.getSelectedItem().equals("alternating crunches") ||
						exerciseSpinner.getSelectedItem().equals("russian twists") ||
						exerciseSpinner.getSelectedItem().equals("sits ups") ||
						exerciseSpinner.getSelectedItem().equals("crunches") ||
						exerciseSpinner.getSelectedItem().equals("penguins") ||
						exerciseSpinner.getSelectedItem().equals("the plank") ||
						exerciseSpinner.getSelectedItem().equals("the side plank") ||
						exerciseSpinner.getSelectedItem().equals("mason twist") )
				{
					logbookRecord.setWeight(0.0);
				}
				else
				{
					logbookRecord.setWeight(Double.parseDouble(weightSpinner.getSelectedItem().toString()));
				}
				logbookRecord.setSets(setsSpinner.getSelectedItem().toString());
				logbookRecord.setDate(giveDate());
				try {
					LogbookDao.getInstance().saveLogbook(logbookRecord);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		checkStatsButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Changing the screen to check stats screen
				FragmentTransaction transaction = ((LogbookActivity)getActivity()).getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.logbook_container, new LogbookStatsFragment(), "logbookStatsFragment");
				transaction.addToBackStack(null);
				transaction.commit();
				
			}
		});
	}

//	Function to get the current date
	public String giveDate()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        return sdf.format(cal.getTime());
    }
}
