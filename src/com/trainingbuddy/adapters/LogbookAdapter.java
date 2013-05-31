package com.trainingbuddy.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.adapters.SupplementsAdapter.ViewHolder;
import com.trainingbuddy.records.LogbookRecord;
import com.trainingbuddy.records.SupplementsRecord;

public class LogbookAdapter extends ArrayAdapter<LogbookRecord>
{
	private final Activity _context;
	private final LogbookRecord[] _logbookRecords;

	//	Giving the adapter the array of exercises and the context of the activity
	public LogbookAdapter(Activity context, LogbookRecord[] logbookRecords) {
		super(context, R.layout.logbook_row, logbookRecords);
		this._context = context;
		this._logbookRecords = logbookRecords;
	}

	static class ViewHolder 
	{
		public TextView logbookEntry;
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
			rowView = inflater.inflate(R.layout.logbook_row, null, false);
			holder = new ViewHolder();

			holder.logbookEntry = (TextView) rowView.findViewById(R.id.row_logbook);
			rowView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		LogbookRecord logbookRecord = _logbookRecords[position];

		if(logbookRecord!=null)
		{
			//			For each logbook we set the text and image from the database
			holder.logbookEntry.setText(_logbookRecords[position].getExerciseType());
		}
		return rowView;
	}
}