package com.trainingbuddy.activities;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.trainingbuddy.R;
import com.trainingbuddy.context.ApplicationContext;
import com.trainingbuddy.fragments.BMIFragment;
import com.trainingbuddy.fragments.BMIProgressGraphFragment;

public class BMIActivity extends FragmentActivity {

	private EditText weight;
	private EditText height;
	private Button calculateBMI;
	private Button viewProgressGraph;
	private TextView bmi;
	private LinearLayout bmiLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here you`re selecting the layout you use
		setContentView(R.layout.bmi_container);
//		The activity acts like a container and on this container I put the fragment
//		I use fragments because they are faster than activities
		
		Fragment createBMIFragment = (Fragment)this.getSupportFragmentManager().findFragmentByTag("bmiProgressGraphFragment");
//		Verifying if the bmifragment was already created if not i add it
		if(createBMIFragment==null)
		{
//			Here i add the fragment to a layout container (bmi_container)
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.add(R.id.bmi_container, new BMIFragment(), "bmiProgressGraphFragment");
				transaction.commit();
		}
	}
}
