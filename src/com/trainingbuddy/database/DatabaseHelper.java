package com.trainingbuddy.database;


import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.trainingbuddy.context.ApplicationContext;
import com.trainingbuddy.records.BMIRecord;
import com.trainingbuddy.records.ExerciseRecord;
import com.trainingbuddy.records.LogbookRecord;
import com.trainingbuddy.records.SupplementsRecord;
import com.trainingbuddy.records.WorkoutRecord;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "trainingbuddy.db";

	private static final int DATABASE_VERSION = 4;

	private static DatabaseHelper _helperInstance; 

	public static DatabaseHelper getInstance()
	{
		if(_helperInstance==null)
		{
			_helperInstance=new DatabaseHelper(ApplicationContext.getContext());
		}
		return _helperInstance;
	}

	public DatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");

			TableUtils.createTable(connectionSource, BMIRecord.class);
			TableUtils.createTable(connectionSource, ExerciseRecord.class);
			TableUtils.createTable(connectionSource, LogbookRecord.class);
			TableUtils.createTable(connectionSource, SupplementsRecord.class);
			TableUtils.createTable(connectionSource, WorkoutRecord.class);

		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Unable to create databases", e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");

			TableUtils.dropTable(connectionSource, BMIRecord.class, true);
			TableUtils.dropTable(connectionSource, ExerciseRecord.class, true);
			TableUtils.dropTable(connectionSource, LogbookRecord.class, true);
			TableUtils.dropTable(connectionSource, SupplementsRecord.class, true);
			TableUtils.dropTable(connectionSource, WorkoutRecord.class, true);

			onCreate(sqliteDatabase, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVer + " to new "
					+ newVer, e);
		}
	}

	@Override
	public void close() {
		super.close();
		_helperInstance = null;
	}

}
