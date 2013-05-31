package com.trainingbuddy.database;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.trainingbuddy.records.BMIRecord;

public class BMIDao {

	protected Dao<BMIRecord, Integer> dao = null;

	private static BMIDao instance = null;
//  Getting the instance of this class so we can use this class
	public static BMIDao getInstance() {
		if (instance == null)
				if (instance == null) {
					instance = new BMIDao();
				}
		return instance;
	}
//	Mapping the class record on the table record from the database
	private BMIDao() {
		if (dao == null) {
			try {
				dao = DatabaseHelper.getInstance().getDao(BMIRecord.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<BMIRecord> getBMI() throws SQLException
	{
		return dao.queryForAll();
	}

	public void saveBMI(BMIRecord bmi) throws SQLException
	{
		dao.createOrUpdate(bmi);
	}

	public void deleteBMIById(int bmiId) throws SQLException 
	{
		dao.deleteBuilder().where().eq("id", bmiId);
	}

	public void deleteBMI(BMIRecord rec) throws SQLException 
	{
		dao.delete(rec);
	}
}
