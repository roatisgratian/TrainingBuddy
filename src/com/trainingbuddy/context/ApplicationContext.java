package com.trainingbuddy.context;


import android.app.Application;
import android.content.Context;

import com.trainingbuddy.R;

public class ApplicationContext extends Application {

//	In this class we get the context of the application. We use it for the database creation
	private static ApplicationContext _instance;
	
	public ApplicationContext()
	{
		_instance = this;
	}
	
	public static Context getContext()
	{
		return _instance;
	}
	public String getModuleName()
	{
		return this.getString(R.string.app_name);
	}
	
	public static ApplicationContext getInstance()
	{
		return _instance;
	}
}
