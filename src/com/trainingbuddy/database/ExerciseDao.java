package com.trainingbuddy.database;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.trainingbuddy.records.ExerciseRecord;

public class ExerciseDao {

	protected Dao<ExerciseRecord, Integer> dao = null;

	private static ExerciseDao instance = null;
//  Getting the instance of this class so we can use this class
	public static ExerciseDao getInstance() {
		if (instance == null)
			if (instance == null) {
				instance = new ExerciseDao();
			}
		return instance;
	}
//	Mapping the class record on the table record from the database
	private ExerciseDao() {
		if (dao == null) {
			try {
				dao = DatabaseHelper.getInstance().getDao(ExerciseRecord.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<ExerciseRecord> getExercises() throws SQLException
	{
		return dao.queryForAll();
	}

	public List<ExerciseRecord> queryForDemonstrationByExerciseName(String exerciseName, String muscleType)
	{	
		try {
			List<ExerciseRecord> list =  (List<ExerciseRecord>) dao.queryBuilder().where().eq("exercise_name", exerciseName).and().eq("exercise_muscle_type", muscleType).query();
			return (List<ExerciseRecord>) list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<ExerciseRecord> queryForExercisesByExerciseType(String exerciseType)
	{	
		try {
			List<ExerciseRecord> list =  (List<ExerciseRecord>) dao.queryBuilder().distinct().selectColumns("exercise_name", "exercise_muscle_type").where().eq("exercise_muscle_type", exerciseType).query();
			return (List<ExerciseRecord>) list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ExerciseRecord> queryForAllDistinctExercises() {
		try {
			List<ExerciseRecord> list =  (List<ExerciseRecord>) dao.queryBuilder().distinct().selectColumns("exercise_muscle_type").query();
			return (List<ExerciseRecord>) list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void saveExercise(ExerciseRecord exercise) throws SQLException
	{
		try {
			dao.createOrUpdate(exercise);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteExerciseById(int exerciseId) throws SQLException 
	{
		dao.deleteBuilder().where().eq("id", exerciseId);
	}

	public void deleteExercise(ExerciseRecord rec) throws SQLException 
	{
		dao.delete(rec);
	}
}
