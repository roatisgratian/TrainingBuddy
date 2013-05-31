package com.trainingbuddy.fragments;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.BMIActivity;
import com.trainingbuddy.database.BMIDao;
import com.trainingbuddy.records.BMIRecord;

public class BMIFragment extends Fragment{

	private EditText weight;
	private EditText height;
	private Button calculateBMI;
	private Button viewBMIProgressGraph;
	private Button viewWeightProgressGraph;
	private TextView bmi;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.bmi_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here we get the items from the layout so we can use them
		weight = (EditText) ((BMIActivity)getActivity()).findViewById(R.id.bmi_weight_edittext);
		height = (EditText) ((BMIActivity)getActivity()).findViewById(R.id.bmi_height_edittext);
		calculateBMI = (Button) ((BMIActivity)getActivity()).findViewById(R.id.bmi_calculate_button);
		viewBMIProgressGraph = (Button) ((BMIActivity)getActivity()).findViewById(R.id.bmi_progress_graph_button);
		viewWeightProgressGraph = (Button) ((BMIActivity)getActivity()).findViewById(R.id.weight_progress_graph_button);
		bmi = (TextView) ((BMIActivity)getActivity()).findViewById(R.id.bmi_calculation_textview);

		calculateBMI.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				//			Verifying if the weight and height are blank. If not the bmi textview will be visivle
				if(weight.getText().toString().trim().equals(""))
				{
					Toast.makeText(((BMIActivity)getActivity()), "Please insert weight.", Toast.LENGTH_LONG).show();
				}else if(height.getText().toString().trim().equals(""))
				{
					Toast.makeText(((BMIActivity)getActivity()), "Please insert height.", Toast.LENGTH_LONG).show();
				}else
				{
//					Calculating the bmi and write it to the screen
					Double bmiCalculation = round(Double.parseDouble(weight.getText().toString()) / (Double.parseDouble(height.getText().toString()) * Double.parseDouble(height.getText().toString())), 2, BigDecimal.ROUND_HALF_UP);
					bmi.setText("Your BMI is " + bmiCalculation.toString());
					if(bmiCalculation < 18.5)
					{
					bmi.setTextColor(getResources().getColor(R.color.bmi_below));
					}else if(bmiCalculation >= 18.5 && bmiCalculation <= 24.9)
					{
						bmi.setTextColor(getResources().getColor(R.color.bmi_healty));
					}else if(bmiCalculation > 24.9 && bmiCalculation <=29.9)
					{
						bmi.setTextColor(getResources().getColor(R.color.bmi_overweight));
					}else if (bmiCalculation > 29.9)
					{
						bmi.setTextColor(getResources().getColor(R.color.bmi_obese));
					}
//					Saving the bmi in the database
					BMIRecord bmiRecord = new BMIRecord();
					bmiRecord.setBmi(bmiCalculation);
					bmiRecord.setDate(giveDate());
					bmiRecord.setHeight(Double.parseDouble(height.getText().toString()));
					bmiRecord.setWeight(Double.parseDouble(weight.getText().toString()));
					try {
						BMIDao.getInstance().saveBMI(bmiRecord);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		viewBMIProgressGraph.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				//			If the viewBMIProgressGraph is clicked the bmi chart appears on the screen
				FragmentTransaction transaction = ((BMIActivity)getActivity()).getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.bmi_container, new BMIProgressGraphFragment(), "bmiProgressGraphFragment");
				transaction.addToBackStack(null);
				transaction.commit();

			} 
		});

		viewWeightProgressGraph.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				//			If the viewWeightProgressGraph is clicked the weight chart appears on the screen
				FragmentTransaction transaction = ((BMIActivity)getActivity()).getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.bmi_container, new WeightProgressGraphFragment(), "weightProgressGraphFragment");
				transaction.addToBackStack(null);
				transaction.commit();
			} 
		});
	}
	
	//Function for making the result to have only 2 decimals
	public static double round(double unrounded, int precision, int roundingMode)
	{
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, roundingMode);
	    return rounded.doubleValue();
	}
	
//	Function to get the current date
	public String giveDate()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        return sdf.format(cal.getTime());
    }
}