package com.trainingbuddy.activities;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.trainingbuddy.R;

public class TabsActivity extends TabActivity implements OnTabChangeListener
{
	public static final String TAB_KEY = "tab";

	public static final String TAB_EXERCISES = "Exercises";
	public static final String TAB_BMI = "BMI";
	public static final String TAB_LOGBOOK = "Logbook";
	public static final String TAB_SUPPLEMENTS = "Supplements";
	public static final String TAB_WORKOUT = "Workout";


	private static final String TAG = TabsActivity.class.getSimpleName();

	private Intent _exercisesIntent;
	private Intent _bmiIntent;
	private Intent _logbookIntent;
	private Intent _supplementsIntent;
	private Intent _workoutIntent;

	private final ArrayList<View> mTabViews = new ArrayList<View>();

	private String startUpSelected;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_layout);

//		Getting a String of what button was clicked in start up screen
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			startUpSelected = extras.getString("clickedButton");
		}
		
//		initialing the intents and building the tabs
		this.initIntents();
		this.initTabs();
		this.onNewIntent(this.getIntent());
	}

//	Change the color of the tab that is selected
	@Override
	public void onTabChanged(String tabId)
	{
		this.updateTabHighlight(tabId);
	}

	@Override
	protected void onNewIntent(Intent intent) 
	{
		super.onNewIntent(intent);

		String tabId;

		//		// Pass tab ID to change tabs with a new intent.
		//		if((tabId = getTabChange(intent)) != null)
		//		{	
		//			// Check for activity group specific action.
		//			if(tabId.equals(TAB_EXERCISES))
		//			{
		//				_searchContactsIntent.setAction(intent.getAction());				
		//			} else if(tabId.equals(TAB_IBM))
		//			{
		//				_uploadIntent.putExtra("", "");//MediaUpload.CURRENT_JOB_BUNDLE_KEY, intent.getIntExtra(MediaUpload.CURRENT_JOB_BUNDLE_KEY, 0));
		//			} else if(tabId.equals(TAB_ID_GEOLINK))
		//			{
		//				super.getTabHost().setCurrentTab(5);
		//			}
		//
		//			super.getTabHost().setCurrentTab(0);
		//			super.getTabHost().setCurrentTabByTag(tabId);			
		//		} else if(intent.getAction() != null && (intent.getAction().equals(Intent.ACTION_SEND)
		//				|| intent.getAction().equals(Intent.ACTION_SEND_MULTIPLE)))
		//		{
		//			_uploadIntent.fillIn(intent, Intent.FILL_IN_ACTION | Intent.FILL_IN_DATA);
		//			_uploadIntent.replaceExtras(intent.getExtras());
		//
		//			super.getTabHost().setCurrentTab(0);
		//			super.getTabHost().setCurrentTabByTag(TAB_ID_UPLOAD);
		//		}
	}

//	Initializing the intents for when you push a tab to know what activity should open
	private void initIntents()
	{
		_exercisesIntent = new Intent(this, ExercisesActivity.class);
		_bmiIntent = new Intent(this, BMIActivity.class);
		_logbookIntent = new Intent(this, LogbookActivity.class);
		_workoutIntent = new Intent(this, WorkoutActivity.class);
		_supplementsIntent = new Intent(this, SupplementsActivity.class);
	} 

//	Building the tabs, with intents, titles and icons
	private void initTabs()
	{
		final TabHost host = getTabHost();
		host.setOnTabChangedListener(this);

		host.addTab(createTab(host, _bmiIntent, TAB_BMI,  R.drawable.bmi_tab_icon));
		host.addTab(createTab(host, _exercisesIntent, TAB_EXERCISES,  R.drawable.exercises_tab_icon));
		host.addTab(createTab(host, _workoutIntent, TAB_WORKOUT,  R.drawable.workout_tab_icon));
		host.addTab(createTab(host, _logbookIntent, TAB_LOGBOOK,  R.drawable.lognook_tab_icon));
		host.addTab(createTab(host, _supplementsIntent, TAB_SUPPLEMENTS,  R.drawable.supplements_tab_icon));

		this.setDefaultTab(0);
//		Checking what button was clicked in the start up menu and opening the following tab
		if(startUpSelected.equals(TAB_BMI))
		{
			host.setCurrentTab(0);
		}else if (startUpSelected.equals(TAB_EXERCISES))
		{
			host.setCurrentTab(1);
		}else if (startUpSelected.equals(TAB_WORKOUT))
		{
			host.setCurrentTab(2);
		}else if (startUpSelected.equals(TAB_LOGBOOK))
		{
			host.setCurrentTab(3);
		}else if (startUpSelected.equals(TAB_SUPPLEMENTS))
		{
			host.setCurrentTab(4);
		}else
		{
			host.setCurrentTab(0);
		}

		this.updateTabHighlight(host.getCurrentTabTag());
	}
// 	Creating a single tab, each tab that is created goes through here
	private TabSpec createTab(TabHost host, Intent intent, String tabID, int drawable)
	{
		final LayoutInflater li = LayoutInflater.from(this);
		final View tab = li.inflate(R.layout.tab, null);
		tab.setTag(tabID);

		final ImageView icon = (ImageView)tab.findViewById(R.id.tab_image);
		icon.setImageResource(drawable);

		final TextView text = (TextView)tab.findViewById(R.id.tab_text);
		text.setText(tabID);

		this.mTabViews.add(tab);

		return host.newTabSpec(tabID).setIndicator(tab).setContent(intent);
	}

//	Changing the title color of the tab selected
	private void updateTabHighlight(String selectedTabId)
	{
		TextView tabText;

		for(final View v : this.mTabViews)
		{
			tabText = ((TextView)v.findViewById(R.id.tab_text));

			// The selected tab gets special styling.
			if(selectedTabId.equals(v.getTag()))
			{
				v.setBackgroundResource(R.color.TabColor);
				tabText.setTextColor(Color.WHITE);
			} else
			{
				v.setBackgroundResource(R.drawable.sh_header_gradient);
				tabText.setTextColor(Color.BLACK);
			}
		}
	}

	/*
	 * Examines the passed intent to determine whether or not it
	 * is asking for a tab change. Returns the tabId if it is
	 * indeed a tab change.
	 */
	private String getTabChange(Intent i)
	{
		// Pass tabId as action
		if(TAB_EXERCISES.equals(i.getAction())
				|| TAB_BMI.equals(i.getAction())
				|| TAB_LOGBOOK.equals(i.getAction())
				|| TAB_SUPPLEMENTS.equals(i.getAction())
				|| TAB_WORKOUT.equals(i.getAction()))
		{
			return i.getAction();
		} else if(i.hasExtra(TAB_KEY))
		{
			// Pass as an extra using the bundle key.
			return i.getStringExtra(TAB_KEY);
		} else
		{
			return null;
		}
	}


}
