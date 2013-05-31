package com.trainingbuddy.activities;

import java.sql.SQLException;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.trainingbuddy.R;
import com.trainingbuddy.database.ExerciseDao;
import com.trainingbuddy.database.LogbookDao;
import com.trainingbuddy.fragments.LogbookFragment;
import com.trainingbuddy.records.ExerciseRecord;
import com.trainingbuddy.records.LogbookRecord;

public class LogbookActivity extends FragmentActivity {

	private LogbookRecord[] logbooks;
	private LogbookRecord selectedLogbook;
	private List<LogbookRecord> logbooksList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Selecting the layout for this activity
		setContentView(R.layout.logbook_container);
//		Getting the list of logbooks from database 
		try {
			logbooksList = LogbookDao.getInstance().getLogbooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logbooks = logbooksList.toArray(new LogbookRecord[logbooksList.size()]);
		
		//		The activity acts like a container and on this container I put the fragment
		//		I use fragments because they are faster
		Fragment createLogbookFragment = (Fragment)this.getSupportFragmentManager().findFragmentByTag("logbookFragment");
//		Verifying if the logbookfragment was already created if not i add it
		if(createLogbookFragment==null)
		{
//			Here i add the fragment to a layout container (bmi_container)
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.add(R.id.logbook_container, new LogbookFragment(), "logbookFragment");
			transaction.commit();
		}
	}

	public LogbookRecord[] getLogbooks() {
		return logbooks;
	}

	public void setLogbooks(LogbookRecord[] logbooks) {
		this.logbooks = logbooks;
	}

	public LogbookRecord getSelectedLogbook() {
		return selectedLogbook;
	}

	public void setSelectedLogbook(LogbookRecord selectedLogbook) {
		this.selectedLogbook = selectedLogbook;
	}

}
