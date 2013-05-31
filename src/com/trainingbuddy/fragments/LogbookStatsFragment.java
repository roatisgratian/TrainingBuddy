package com.trainingbuddy.fragments;

import java.util.List;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.LogbookActivity;
import com.trainingbuddy.database.LogbookDao;
import com.trainingbuddy.records.LogbookRecord;

public class LogbookStatsFragment extends Fragment{

	String[] EXERCISES = {"alternating crunches", "bar curl", "behind the neck shoulder press", "bench press", "bulgarian split squat",	"chest press", "crunches", "deadlift",
			"diamond push ups", "dish", "dumbell curls", "exercise number", "fly's", "front squat", "hammer curls", "mason twist",	"one arm tricep pull downs", "penguins",
			"romanian deadlift", "russian twists", "shoulder press", "shoulder press with bar", "should twists", "the side plank", "sits ups", "skull crush", "squat", "the plank",
			"tricep extensions", "tricep pull downs", "under arm chin ups", "wide arm pull ups","wide arm push ups","zottman curls"};
	String SPINNER_EXERCISES [] = getResources().getStringArray(R.array.spinner_exercises);
	private Button checkStatsButton;
	private ScrollView statsScrolView;
	private Spinner exerciseTypesSpinner;
	private List<LogbookRecord> logbookList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.logbook_stats_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here we get the items from the layout so we can use them
		exerciseTypesSpinner = (Spinner) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_stat_exercise_type_spinner);
		statsScrolView = (ScrollView) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_stats_scrolview);
		checkStatsButton = (Button) ((LogbookActivity)getActivity()).findViewById(R.id.logbook_stat_exercise_select_button);

//		Here I populate the spinner
		ArrayAdapter<String> exerciseArrayAdapter = new ArrayAdapter<String>((LogbookActivity)getActivity(), R.layout.spinner_item, SPINNER_EXERCISES);
		exerciseArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		exerciseTypesSpinner.setAdapter(exerciseArrayAdapter);
		
//		Making the text from the spinner white
//		exerciseTypesSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
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
		
//		Getting the table when you click checkstats button
		checkStatsButton.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				statsScrolView.removeAllViews();
				logbookList = LogbookDao.getInstance().queryForLogbookByExerciseType(exerciseTypesSpinner.getSelectedItem().toString());
				//Create the table layout
				TableLayout tableLayout = new TableLayout((LogbookActivity)getActivity());
				tableLayout.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
				tableLayout.setStretchAllColumns(true);

				for(int i=0; i<logbookList.size();i++)
				{
					LogbookRecord logbookRecord = logbookList.get(i);
					
					if(i==0)
					{
						TableRow row = new TableRow((LogbookActivity)getActivity());
						//Create the row and add text views
						TextView weight = new TextView((LogbookActivity)getActivity());
						weight.setText("Weight");
						weight.setTypeface(null, Typeface.BOLD);
						weight.setTextColor(Color.BLACK);
						TextView reps = new TextView((LogbookActivity)getActivity());
						reps.setText("Nr. of reps");
						reps.setTypeface(null, Typeface.BOLD);
						reps.setTextColor(Color.BLACK);
						TextView sets = new TextView((LogbookActivity)getActivity());
						sets.setText("Sets");
						sets.setTextColor(Color.BLACK);
						sets.setTypeface(null, Typeface.BOLD);
						TextView date = new TextView((LogbookActivity)getActivity());
						date.setText("Date");
						date.setTypeface(null, Typeface.BOLD);
						date.setTextColor(Color.BLACK);
						row.addView(weight);
						row.addView(reps);
						row.addView(sets);
						row.addView(date);
						tableLayout.addView(row);
					}
					TableRow row = new TableRow((LogbookActivity)getActivity());
					//Create the row and add text views of stats
					TextView weight = new TextView((LogbookActivity)getActivity());
					weight.setText(logbookRecord.getWeight().toString());
					weight.setTextColor(Color.BLACK);
					TextView reps = new TextView((LogbookActivity)getActivity());
					reps.setText(String.valueOf(logbookRecord.getRepCount()));
					reps.setTextColor(Color.BLACK);
					TextView sets = new TextView((LogbookActivity)getActivity());
					sets.setText(String.valueOf(logbookRecord.getSets()));
					sets.setTextColor(Color.BLACK);
					TextView date = new TextView((LogbookActivity)getActivity());
					date.setText(logbookRecord.getDate());
					date.setTextColor(Color.BLACK);
					row.addView(weight);
					row.addView(reps);
					row.addView(sets);
					row.addView(date);
					tableLayout.addView(row);
				}
				statsScrolView.addView(tableLayout);
			}
		});
	}
}