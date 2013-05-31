package com.trainingbuddy.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.SupplementsActivity;
import com.trainingbuddy.context.ApplicationContext;
import com.trainingbuddy.records.SupplementsRecord;

public class SupplementInformationFragment extends Fragment{

	private TextView supplementDescriptionTextView;
	private TextView supplementNameTextView;
	private TextView supplementNutritionalInformationTextView;
	private ImageView supplementImageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.supplement_information_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here we get the items from the layout so we can use them
		supplementNameTextView = (TextView)((SupplementsActivity)getActivity()).findViewById(R.id.supplement_name_textview);
		supplementDescriptionTextView = (TextView)((SupplementsActivity)getActivity()).findViewById(R.id.supplement_description_textview);
		supplementImageView = (ImageView)((SupplementsActivity)getActivity()).findViewById(R.id.supplement_imageview);
		supplementNutritionalInformationTextView = (TextView)((SupplementsActivity)getActivity()).findViewById(R.id.suppliment_nutritional_information);
//		Getting the supplement selected from the list
		SupplementsRecord supplement = ((SupplementsActivity)getActivity()).getSelectedSuppliment();
//		Setting the supliment data on the screen
		supplementNameTextView.setText(getStringResourceByName(supplement.getName()));
		supplementDescriptionTextView.setText(getStringResourceByName(supplement.getDescription()));
		supplementImageView.setImageResource(getPicture(supplement.getSupplementIcon()));
		supplementNutritionalInformationTextView.setText(getStringResourceByName(supplement.getNutritions()));
	}
	
	//Method to get the picture dinamically knowing it`s name
		public int getPicture(String picName)
		{
			picName = picName.replace(".png", "");
			Resources r = getResources();
			int picId = r.getIdentifier(picName, "drawable", "com.trainingbuddy"); //aici poate trebe sa pun si .activities
			return picId;
		}
//		Method to get the string resources by name
		private String getStringResourceByName(String aString) {
		      String packageName = ApplicationContext.getContext().getPackageName();
		      int resId = ApplicationContext.getContext().getResources().getIdentifier(aString, "string", packageName);
		      String resource = ApplicationContext.getContext().getResources().getString(resId);
		      return resource;
		    }
}
