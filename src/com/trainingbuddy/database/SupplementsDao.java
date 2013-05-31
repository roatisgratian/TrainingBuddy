package com.trainingbuddy.database;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.trainingbuddy.records.SupplementsRecord;

public class SupplementsDao {

	protected Dao<SupplementsRecord, Integer> dao = null;

	private static SupplementsDao instance = null;
//  Getting the instance of this class so we can use this class
	public static SupplementsDao getInstance() {
		if (instance == null)
				if (instance == null) {
					instance = new SupplementsDao();
				}
		return instance;
	}
//	Mapping the class record on the table record from the database
	private SupplementsDao() {
		if (dao == null) {
			try {
				dao = DatabaseHelper.getInstance().getDao(SupplementsRecord.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<SupplementsRecord> getSupplements() throws SQLException
	{
		return dao.queryForAll();
	}

	public void saveSupplement(SupplementsRecord supplements) throws SQLException
	{
		dao.createOrUpdate(supplements);
	}

	public void deleteSupplementsById(int supplementsId) throws SQLException 
	{
		dao.deleteBuilder().where().eq("id", supplementsId);
	}

	public void deleteSupplements(SupplementsRecord rec) throws SQLException 
	{
		dao.delete(rec);
	}
}
