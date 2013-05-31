package com.trainingbuddy.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.context.ApplicationContext;
import com.trainingbuddy.records.SupplementsRecord;

public class SupplementsAdapter extends ArrayAdapter<SupplementsRecord>
{
	private final Activity _context;
	private final SupplementsRecord[] _supplements;

	//	Giving the adapter the array of exercises and the context of the activity
	public SupplementsAdapter(Activity context, SupplementsRecord[] supplements) {
		super(context, R.layout.supplements_row, supplements);
		this._context = context;
		this._supplements = supplements;
	}

	static class ViewHolder 
	{
		public TextView supplementsName;
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
			rowView = inflater.inflate(R.layout.supplements_row, null, false);
			holder = new ViewHolder();

			holder.supplementsName = (TextView) rowView.findViewById(R.id.row_supplements_name);
			rowView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		SupplementsRecord supplementsRecord = _supplements[position];

		if(supplementsRecord !=null)
		{
			//			For each supplement we set the text and image from the database
			holder.supplementsName.setText(getStringResourceByName(_supplements[position].getName()));
		}

		return rowView;
	}
	
	private String getStringResourceByName(String aString) {
	      String packageName = ApplicationContext.getContext().getPackageName();
	      int resId = ApplicationContext.getContext().getResources().getIdentifier(aString, "string", packageName);
	      String resource = ApplicationContext.getContext().getResources().getString(resId);
	      return resource;
	    }
}