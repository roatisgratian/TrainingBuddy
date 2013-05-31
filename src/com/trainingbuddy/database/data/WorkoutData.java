package com.trainingbuddy.database.data;

import java.sql.SQLException;

import com.trainingbuddy.database.WorkoutDao;
import com.trainingbuddy.records.WorkoutRecord;

public class WorkoutData {

	public static void insertWorkoutsInDatabase() throws SQLException
	{
//		Workout records to be put in the database
		WorkoutRecord work1 = new WorkoutRecord();
		work1.setWorkoutName("Abs");
		work1.setExerciseName("The plank");
		work1.setWorkoutExerciseIcon("the_plank_step1");
		work1.setRepCount("2");
		work1.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work1);

		WorkoutRecord work2 = new WorkoutRecord();
		work2.setWorkoutName("Abs");
		work2.setExerciseName("Side plank");
		work2.setWorkoutExerciseIcon("side_plank_step2");
		work2.setRepCount("2");
		work2.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work2);

		WorkoutRecord work3 = new WorkoutRecord();
		work3.setWorkoutName("Abs");
		work3.setExerciseName("Penguins");
		work3.setWorkoutExerciseIcon("penguins_step2");
		work3.setRepCount("16");
		work3.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work3);

		WorkoutRecord work4 = new WorkoutRecord();
		work4.setWorkoutName("Abs");
		work4.setExerciseName("Sits ups");
		work4.setWorkoutExerciseIcon("sit_ups_step2");
		work4.setRepCount("16");
		work4.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work4);

		WorkoutRecord work5 = new WorkoutRecord();
		work5.setWorkoutName("Abs");
		work5.setExerciseName("Russian twists");
		work5.setWorkoutExerciseIcon("russian_twists_step2");
		work5.setRepCount("8");
		work5.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work5);

		WorkoutRecord work6 = new WorkoutRecord();
		work6.setWorkoutName("Abs");
		work6.setExerciseName("Dish");
		work6.setWorkoutExerciseIcon("dish_step2");
		work6.setRepCount("3");
		work6.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work6);

		WorkoutRecord work7 = new WorkoutRecord();
		work7.setWorkoutName("Abs");
		work7.setExerciseName("Crunches");
		work7.setWorkoutExerciseIcon("crunch_step3");
		work7.setRepCount("12");
		work7.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work7);

		WorkoutRecord work8 = new WorkoutRecord();
		work8.setWorkoutName("Abs");
		work8.setExerciseName("Alternating crunches");
		work8.setWorkoutExerciseIcon("alternating_crunches_step3");
		work8.setRepCount("12");
		work8.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work8);

		WorkoutRecord work9 = new WorkoutRecord();
		work9.setWorkoutName("Abs");
		work9.setExerciseName("Mason twist");
		work9.setWorkoutExerciseIcon("mason_twist_step3");
		work9.setRepCount("8");
		work9.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work9);

		WorkoutRecord work10 = new WorkoutRecord();
		work10.setWorkoutName("Back and shoulders");
		work10.setExerciseName("Shoulder press with bar");
		work10.setWorkoutExerciseIcon("shoulder_press_with_bar_step2");
		work10.setRepCount("6");
		work10.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work10);

		WorkoutRecord work11 = new WorkoutRecord();
		work11.setWorkoutName("Back and shoulders");
		work11.setExerciseName("Wide arm pull ups");
		work11.setWorkoutExerciseIcon("wide_arm_pull_ups_step3");
		work11.setRepCount("6");
		work11.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work11);

		WorkoutRecord work12 = new WorkoutRecord();
		work12.setWorkoutName("Back and shoulders");
		work12.setExerciseName("Under arm chin ups");
		work12.setWorkoutExerciseIcon("under_arm_chin_up_step3");
		work12.setRepCount("6");
		work12.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work12);

		WorkoutRecord work13 = new WorkoutRecord();
		work13.setWorkoutName("Back and shoulders");
		work13.setExerciseName("Diamond push ups");
		work13.setWorkoutExerciseIcon("diamond_push_ups_step2");
		work13.setRepCount("12");
		work13.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work13);

		WorkoutRecord work14 = new WorkoutRecord();
		work14.setWorkoutName("Back and shoulders");
		work14.setExerciseName("Wide arm push ups");
		work14.setWorkoutExerciseIcon("wide_arm_push_ups_step2");
		work14.setRepCount("12");
		work14.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work14);

		WorkoutRecord work15 = new WorkoutRecord();
		work15.setWorkoutName("Back and shoulders");
		work15.setExerciseName("Shoulder twists");
		work15.setWorkoutExerciseIcon("shoulder_twists_step3");
		work15.setRepCount("10");
		work15.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work15);

		WorkoutRecord work16 = new WorkoutRecord();
		work16.setWorkoutName("Back and shoulders");
		work16.setExerciseName("Squat");
		work16.setWorkoutExerciseIcon("squat_step3");
		work16.setRepCount("6");
		work16.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work16);

		WorkoutRecord work17 = new WorkoutRecord();
		work17.setWorkoutName("Back and shoulders");
		work17.setExerciseName("Shoulder press");
		work17.setWorkoutExerciseIcon("shoulder_press_step2");
		work17.setRepCount("8");
		work17.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work17);

		WorkoutRecord work18 = new WorkoutRecord();
		work18.setWorkoutName("Back and shoulders");
		work18.setExerciseName("Behind the neck shoulder press");
		work18.setWorkoutExerciseIcon("behind_the_neck_shoulder_press_step3");
		work18.setRepCount("6");
		work18.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work18);

		WorkoutRecord work19 = new WorkoutRecord();
		work19.setWorkoutName("Back and shoulders");
		work19.setExerciseName("Shrugs");
		work19.setWorkoutExerciseIcon("shrugs_step2");
		work19.setRepCount("8");
		work19.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work19);

		WorkoutRecord work20 = new WorkoutRecord();
		work20.setWorkoutName("Chest and biceps");
		work20.setExerciseName("Bench press");
		work20.setWorkoutExerciseIcon("bench_press_step4");
		work20.setRepCount("8");
		work20.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work20);

		WorkoutRecord work21 = new WorkoutRecord();
		work21.setWorkoutName("Chest and biceps");
		work21.setExerciseName("Fly's");
		work21.setWorkoutExerciseIcon("flys_step5");
		work21.setRepCount("10");
		work21.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work21);

		WorkoutRecord work22 = new WorkoutRecord();
		work22.setWorkoutName("Chest and biceps");
		work22.setExerciseName("Chest press");
		work22.setWorkoutExerciseIcon("chest_press_step2");
		work22.setRepCount("8");
		work22.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work22);

		WorkoutRecord work23 = new WorkoutRecord();
		work23.setWorkoutName("Chest and biceps");
		work23.setExerciseName("Diamond push ups");
		work23.setWorkoutExerciseIcon("diamond_push_ups_step2");
		work23.setRepCount("8");
		work23.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work23);

		WorkoutRecord work24 = new WorkoutRecord();
		work24.setWorkoutName("Chest and biceps");
		work24.setExerciseName("Wide arm push ups");
		work24.setWorkoutExerciseIcon("wide_arm_push_ups_step2");
		work24.setRepCount("8");
		work24.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work24);

		WorkoutRecord work25 = new WorkoutRecord();
		work25.setWorkoutName("Chest and biceps");
		work25.setExerciseName("Hammer curls");
		work25.setWorkoutExerciseIcon("hammer_curls_step2");
		work25.setRepCount("8");
		work25.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work25);

		WorkoutRecord work26 = new WorkoutRecord();
		work26.setWorkoutName("Chest and biceps");
		work26.setExerciseName("Zottman curls");
		work26.setWorkoutExerciseIcon("zottman_curls_step3");
		work26.setRepCount("8");
		work26.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work26);

		WorkoutRecord work27 = new WorkoutRecord();
		work27.setWorkoutName("Chest and biceps");
		work27.setExerciseName("Bar curl");
		work27.setWorkoutExerciseIcon("bar_curl_step2");
		work27.setRepCount("8");
		work27.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work27);

		WorkoutRecord work28 = new WorkoutRecord();
		work28.setWorkoutName("Legs");
		work28.setExerciseName("Deadlift");
		work28.setWorkoutExerciseIcon("deadlift_step2");
		work28.setRepCount("8");
		work28.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work28);

		WorkoutRecord work29 = new WorkoutRecord();
		work29.setWorkoutName("Legs");
		work29.setExerciseName("Squat");
		work29.setWorkoutExerciseIcon("squat_step3");
		work29.setRepCount("10");
		work29.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work29);

		WorkoutRecord work30 = new WorkoutRecord();
		work30.setWorkoutName("Legs");
		work30.setExerciseName("Bulgarian split squat");
		work30.setWorkoutExerciseIcon("bulgarian_split_squat_step2");
		work30.setRepCount("8");
		work30.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work30);

		WorkoutRecord work31 = new WorkoutRecord();
		work31.setWorkoutName("Legs");
		work31.setExerciseName("Front squat");
		work31.setWorkoutExerciseIcon("front_squat_step2");
		work31.setRepCount("8");
		work31.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work31);

		WorkoutRecord work32 = new WorkoutRecord();
		work32.setWorkoutName("Legs");
		work32.setExerciseName("Romanian deadlift");
		work32.setWorkoutExerciseIcon("romanian_deadlift_straight_leg_step3");
		work32.setRepCount("8");
		work32.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work32);

		WorkoutRecord work33 = new WorkoutRecord();
		work33.setWorkoutName("Triceps");
		work33.setExerciseName("Wide arm pull ups");
		work33.setWorkoutExerciseIcon("widearmpullups");
		work33.setRepCount("16");
		work33.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work33);

		WorkoutRecord work34 = new WorkoutRecord();
		work34.setWorkoutName("Triceps");
		work34.setExerciseName("Skull crush");
		work34.setWorkoutExerciseIcon("skullcrush");
		work34.setRepCount("12");
		work34.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work34);

		WorkoutRecord work35 = new WorkoutRecord();
		work35.setWorkoutName("Triceps");
		work35.setExerciseName("Tricep extensions");
		work35.setWorkoutExerciseIcon("tricepextensions");
		work35.setRepCount("8");
		work35.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work35);

		WorkoutRecord work36 = new WorkoutRecord();
		work36.setWorkoutName("Triceps");
		work36.setExerciseName("Tricep pull downs");
		work36.setWorkoutExerciseIcon("triceppulldowns");
		work36.setRepCount("8");
		work36.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work36);

		WorkoutRecord work37 = new WorkoutRecord();
		work37.setWorkoutName("Triceps");
		work37.setExerciseName("One arm tricep pull downs");
		work37.setWorkoutExerciseIcon("onearmtriceppulldowns");
		work37.setRepCount("8");
		work37.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work37);

		WorkoutRecord work38 = new WorkoutRecord();
		work38.setWorkoutName("Triceps");
		work38.setExerciseName("Wide arm push ups");
		work38.setWorkoutExerciseIcon("widearmpushups");
		work38.setRepCount("16");
		work38.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work38);

		WorkoutRecord work39 = new WorkoutRecord();
		work39.setWorkoutName("Triceps");
		work39.setExerciseName("Zottman cruls");
		work39.setWorkoutExerciseIcon("zottmancurls");
		work39.setRepCount("8");
		work39.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work39);

		WorkoutRecord work40 = new WorkoutRecord();
		work40.setWorkoutName("Triceps");
		work40.setExerciseName("Shoulder press");
		work40.setWorkoutExerciseIcon("shoulder_press_step2");
		work40.setRepCount("8");
		work40.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work40);

		WorkoutRecord work41 = new WorkoutRecord();
		work41.setWorkoutName("Triceps");
		work41.setExerciseName("Diamond push ups");
		work41.setWorkoutExerciseIcon("diamond_push_ups_step2");
		work41.setRepCount("16");
		work41.setSetsCount("3");
		WorkoutDao.getInstance().saveWorkout(work41);

	}
}
