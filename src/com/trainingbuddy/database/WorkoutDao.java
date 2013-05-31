package com.trainingbuddy.database;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.trainingbuddy.records.ExerciseRecord;
import com.trainingbuddy.records.WorkoutRecord;

public class WorkoutDao {

	protected Dao<WorkoutRecord, Integer> dao = null;

	private static WorkoutDao instance = null;
//  Getting the instance of this class so we can use this class
	public static WorkoutDao getInstance() {
		if (instance == null)
				if (instance == null) {
					instance = new WorkoutDao();
				}
		return instance;
	}
//	Mapping the class record on the table record from the database
	private WorkoutDao() {
		if (dao == null) {
			try {
				dao = DatabaseHelper.getInstance().getDao(WorkoutRecord.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<WorkoutRecord> getWorkouts() throws SQLException
	{
		return dao.queryForAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<WorkoutRecord> queryForAllDistinctWorkouts() {
		try {
			List<WorkoutRecord> list =  (List<WorkoutRecord>) dao.queryBuilder().distinct().selectColumns("workout_name").query();
			return (List<WorkoutRecord>) list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<WorkoutRecord> queryForDemonstrationByWorkoutName(String workoutName)
	{	
		try {
			List<WorkoutRecord> list =  (List<WorkoutRecord>) dao.queryBuilder().where().eq("workout_name", workoutName).query();
			return (List<WorkoutRecord>) list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public void saveWorkout(WorkoutRecord workout) throws SQLException
	{
		dao.createOrUpdate(workout);
	}

	public void deleteWorkoutById(int workoutId) throws SQLException 
	{
		dao.deleteBuilder().where().eq("id", workoutId);
	}

	public void deleteWorkout(WorkoutRecord rec) throws SQLException 
	{
		dao.delete(rec);
	}
}
