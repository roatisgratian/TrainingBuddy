package com.trainingbuddy.database;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.trainingbuddy.records.LogbookRecord;

public class LogbookDao {

	protected Dao<LogbookRecord, Integer> dao = null;

	private static LogbookDao instance = null;
//  Getting the instance of this class so we can use this class
	public static LogbookDao getInstance() {
		if (instance == null)
				if (instance == null) {
					instance = new LogbookDao();
				}
		return instance;
	}
//	Mapping the class record on the table record from the database
	private LogbookDao() {
		if (dao == null) {
			try {
				dao = DatabaseHelper.getInstance().getDao(LogbookRecord.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<LogbookRecord> getLogbooks() throws SQLException
	{
		return dao.queryForAll();
	}
	
	public List<LogbookRecord> queryForLogbookByExerciseType(String exerciseType)
	{	
		try {
			List<LogbookRecord> list =  (List<LogbookRecord>) dao.queryBuilder().where().eq("exercise_type", exerciseType).query();
			return (List<LogbookRecord>) list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void saveLogbook(LogbookRecord logbook) throws SQLException
	{
		dao.createOrUpdate(logbook);
	}

	public void deleteLogbookById(int logbookId) throws SQLException 
	{
		dao.deleteBuilder().where().eq("id", logbookId);
	}

	public void deleteLogbook(LogbookRecord rec) throws SQLException 
	{
		dao.delete(rec);
	}
}
