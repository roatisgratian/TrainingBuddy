package com.trainingbuddy.fragments;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.BMIActivity;
import com.trainingbuddy.database.BMIDao;
import com.trainingbuddy.records.BMIRecord;

public class WeightProgressGraphFragment extends Fragment{


	private String[] dates;
	private List<Integer> xList = new ArrayList<Integer>(); 
	private List<Double> dataList = new ArrayList<Double>();

	private BMIRecord[] bmiRecords;
	private BMIRecord bmiRecord;
	private List<BMIRecord> bmiList ;
	private List<String> dateList = new ArrayList<String>();
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.graph_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Getting the bmi records from the database
		try {
			bmiList = BMIDao.getInstance().getBMI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		weightProgressChart();
	}
	
	private void weightProgressChart(){ 
		
//		Putting the dates on the x axe and the weight`s in the graph
		for(int i=0; i< bmiList.size(); i++)
		{
			dateList.add(bmiList.get(i).getDate());
			xList.add(i+1);
			dataList.add(bmiList.get(i).getWeight());
		}
		
		dates = dateList.toArray(new String[dateList.size()]);
		
		Integer[] x = xList.toArray(new Integer[xList.size()]);
		Double[] data = dataList.toArray(new Double[dataList.size()]);
		
//        int[] x = { 1,2,3,4,5,6,7,8,9,10,11,12 };
//        Double[] data = { 2000.4,2500.6,2700.5,3000.1,2800.3,3500.2,3700.1,3800.9,2500.6,2700.5,3000.1,2800.3,3500.2,3700.1,3800.9};
 
        // Creating an  XYSeries for data
        XYSeries dataSeries = new XYSeries("Weight");
        // Adding data to Series
        for(int i=0;i<x.length;i++){
            dataSeries.add(x[i], data[i]);
        }
 
        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding data Series to the dataset
        dataset.addSeries(dataSeries);
 
        // Creating XYSeriesRenderer to customize lineSeries
        XYSeriesRenderer dataRenderer = new XYSeriesRenderer();
        dataRenderer.setColor(Color.RED);
        dataRenderer.setPointStyle(PointStyle.CIRCLE);
        dataRenderer.setFillPoints(true);
        dataRenderer.setLineWidth(2);
        dataRenderer.setDisplayChartValues(true);
 
 
        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Weight Progress Graph");
        multiRenderer.setXTitle("");
        multiRenderer.setYTitle("Weight");
        multiRenderer.setAxisTitleTextSize(15);					//marimea titlurilor axelor
        multiRenderer.setChartTitleTextSize(25);					//marimea titlului de deasupra graficului
        multiRenderer.setLabelsTextSize(14);						//marimea labelurilor de pe axe
        multiRenderer.setLegendTextSize(16);	
        multiRenderer.setZoomButtonsVisible(false);
        multiRenderer.setChartValuesTextSize(14);
        
        multiRenderer.setMarginsColor(Color.parseColor("#EEEDED"));
        multiRenderer.setXLabelsColor(Color.BLACK);
        multiRenderer.setYLabelsColor(0,Color.BLACK);
    	multiRenderer.setXLabelsAngle(-60);
		multiRenderer.setXLabelsAlign(Align.RIGHT);
        multiRenderer.setYLabelsAlign(Align.RIGHT);
        multiRenderer.setAxesColor(Color.BLACK);
        multiRenderer.setLabelsColor(Color.BLACK);
        multiRenderer.setMargins(new int[]{70, 50, 100, 20});
        multiRenderer.setApplyBackgroundColor(true);
        multiRenderer.setBackgroundColor(Color.parseColor("#FBFBFC"));
		
        for(int i=0;i<x.length;i++){
            multiRenderer.addXTextLabel(i+1, dates[i]);
        }
 
        // Adding incomeRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(dataRenderer);
 
        // Getting a reference to LinearLayout of the MainActivity Layout
        LinearLayout chartContainer = (LinearLayout)((BMIActivity)getActivity()).findViewById(R.id.chart_container);
 
        // Creating a Line Chart
        GraphicalView mChart = ChartFactory.getLineChartView((BMIActivity)getActivity(), dataset, multiRenderer);
 
        // Adding the Line Chart to the LinearLayout
        chartContainer.addView(mChart);
    }
}
