package com.trainingbuddy.database.data;

import java.sql.SQLException;

import com.trainingbuddy.database.ExerciseDao;
import com.trainingbuddy.records.ExerciseRecord;

public class ExerciseData {

	public static void insertExercisesInDatabase() throws SQLException
	{
//		Exercise records to be added in the database
		ExerciseRecord rec1 = new ExerciseRecord();
		rec1.setExerciseMuscleType("bicep");
		rec1.setExerciseName("bench_press");
		rec1.setExerciseDescription("bench_press_description");
		rec1.setExerciseMuscleIcon("bicep");
		rec1.setExerciseNameStepIcon("bench_press");
		ExerciseDao.getInstance().saveExercise(rec1);

		ExerciseRecord rec5 = new ExerciseRecord();
		rec5.setExerciseMuscleType("chest");
		rec5.setExerciseName("bench_press");
		rec5.setExerciseDescription("bench_press_description");
		rec5.setExerciseMuscleIcon("chest");
		rec5.setExerciseNameStepIcon("bench_press");
		ExerciseDao.getInstance().saveExercise(rec5);

		ExerciseRecord rec9 = new ExerciseRecord();
		rec9.setExerciseMuscleType("bicep");
		rec9.setExerciseName("fly_s");
		rec9.setExerciseDescription("fly_s_description");
		rec9.setExerciseMuscleIcon("bicep");
		rec9.setExerciseNameStepIcon("fly_s");
		ExerciseDao.getInstance().saveExercise(rec9);

		ExerciseRecord rec14 = new ExerciseRecord();
		rec14.setExerciseMuscleType("chest");
		rec14.setExerciseName("Fly`s");
		rec14.setExerciseDescription("fly_s_description");
		rec14.setExerciseMuscleIcon("chest");
		rec14.setExerciseNameStepIcon("fly_s");
		ExerciseDao.getInstance().saveExercise(rec14);

		ExerciseRecord rec19 = new ExerciseRecord();
		rec19.setExerciseMuscleType("bicep");
		rec19.setExerciseName("chest_press");
		rec19.setExerciseDescription("chest_press_description");
		rec19.setExerciseMuscleIcon("bicep");
		rec19.setExerciseNameStepIcon("chest_press");
		ExerciseDao.getInstance().saveExercise(rec19);

		ExerciseRecord rec23 = new ExerciseRecord();
		rec23.setExerciseMuscleType("chest");
		rec23.setExerciseName("chest_press");
		rec23.setExerciseDescription("chest_press_description");
		rec23.setExerciseMuscleIcon("chest");
		rec23.setExerciseNameStepIcon("chest_press");
		ExerciseDao.getInstance().saveExercise(rec23);

		ExerciseRecord rec27 = new ExerciseRecord();
		rec27.setExerciseMuscleType("bicep");
		rec27.setExerciseName("bar_curl");
		rec27.setExerciseDescription("bar_curl_description");
		rec27.setExerciseMuscleIcon("bicep");
		rec27.setExerciseNameStepIcon("bar_curl");
		ExerciseDao.getInstance().saveExercise(rec27);

		ExerciseRecord rec30 = new ExerciseRecord();
		rec30.setExerciseMuscleType("tricep");
		rec30.setExerciseName("bar_curl");
		rec30.setExerciseDescription("bar_curl_description");
		rec30.setExerciseMuscleIcon("tricep");
		rec30.setExerciseNameStepIcon("bar_curl");
		ExerciseDao.getInstance().saveExercise(rec30);

		ExerciseRecord rec33 = new ExerciseRecord();
		rec33.setExerciseMuscleType("tricep");
		rec33.setExerciseName("shoulder_press_with_bar");
		rec33.setExerciseDescription("shoulder_press_with_bar_description");
		rec33.setExerciseMuscleIcon("tricep");
		rec33.setExerciseNameStepIcon("shoulder_press_with_bar");
		ExerciseDao.getInstance().saveExercise(rec33);

		ExerciseRecord rec35 = new ExerciseRecord();
		rec35.setExerciseMuscleType("shoulders");
		rec35.setExerciseName("shoulder_press_with_bar");
		rec35.setExerciseDescription("shoulder_press_with_bar_description");
		rec35.setExerciseMuscleIcon("shoulders");
		rec35.setExerciseNameStepIcon("shoulder_press_with_bar");
		ExerciseDao.getInstance().saveExercise(rec35);

		ExerciseRecord rec37 = new ExerciseRecord();
		rec37.setExerciseMuscleType("back");
		rec37.setExerciseName("shoulder_press_with_bar");
		rec37.setExerciseDescription("shoulder_press_with_bar_description");
		rec37.setExerciseMuscleIcon("back");
		rec37.setExerciseNameStepIcon("shoulder_press_with_bar");
		ExerciseDao.getInstance().saveExercise(rec37);

		ExerciseRecord rec39 = new ExerciseRecord();
		rec39.setExerciseMuscleType("tricep");
		rec39.setExerciseName("wide_arm_pull_ups");
		rec39.setExerciseDescription("wide_arm_pull_ups_description");
		rec39.setExerciseMuscleIcon("tricep");
		rec39.setExerciseNameStepIcon("wide_arm_pull_ups_step1");
		ExerciseDao.getInstance().saveExercise(rec39);

		ExerciseRecord rec42 = new ExerciseRecord();
		rec42.setExerciseMuscleType("back");
		rec42.setExerciseName("wide_arm_pull_ups");
		rec42.setExerciseDescription("wide_arm_pull_ups_description");
		rec42.setExerciseMuscleIcon("back");
		rec42.setExerciseNameStepIcon("wide_arm_pull_ups_step1");
		ExerciseDao.getInstance().saveExercise(rec42);

		ExerciseRecord rec45 = new ExerciseRecord();
		rec45.setExerciseMuscleType("shoulders");
		rec45.setExerciseName("wide_arm_pull_ups");
		rec45.setExerciseDescription("wide_arm_pull_ups_description");
		rec45.setExerciseMuscleIcon("shoulders");
		rec45.setExerciseNameStepIcon("wide_arm_pull_ups_step1");
		ExerciseDao.getInstance().saveExercise(rec45);

		ExerciseRecord rec48 = new ExerciseRecord();
		rec48.setExerciseMuscleType("back");
		rec48.setExerciseName("under_arm_chin_ups");
		rec48.setExerciseDescription("under_arm_chin_ups_description");
		rec48.setExerciseMuscleIcon("back");
		rec48.setExerciseNameStepIcon("under_arm_chin_up_step1");
		ExerciseDao.getInstance().saveExercise(rec48);

		ExerciseRecord rec51 = new ExerciseRecord();
		rec51.setExerciseMuscleType("tricep");
		rec51.setExerciseName("under_arm_chin_ups");
		rec51.setExerciseDescription("under_arm_chin_ups_description");
		rec51.setExerciseMuscleIcon("tricep");
		rec51.setExerciseNameStepIcon("under_arm_chin_up_step1");
		ExerciseDao.getInstance().saveExercise(rec51);

		ExerciseRecord rec54 = new ExerciseRecord();
		rec54.setExerciseMuscleType("legs");
		rec54.setExerciseName("deadlift");
		rec54.setExerciseDescription("deadlift_description");
		rec54.setExerciseMuscleIcon("legs");
		rec54.setExerciseNameStepIcon("deadlift");
		ExerciseDao.getInstance().saveExercise(rec54);

		ExerciseRecord rec57 = new ExerciseRecord();
		rec57.setExerciseMuscleType("back");
		rec57.setExerciseName("deadlift");
		rec57.setExerciseDescription("deadlift_description");
		rec57.setExerciseMuscleIcon("back");
		rec57.setExerciseNameStepIcon("deadlift");
		ExerciseDao.getInstance().saveExercise(rec57);

		ExerciseRecord rec60 = new ExerciseRecord();
		rec60.setExerciseMuscleType("shoulders");
		rec60.setExerciseName("deadlift");
		rec60.setExerciseDescription("deadlift_description");
		rec60.setExerciseMuscleIcon("shoulders");
		rec60.setExerciseNameStepIcon("deadlift");
		ExerciseDao.getInstance().saveExercise(rec60);

		ExerciseRecord rec63 = new ExerciseRecord();
		rec63.setExerciseMuscleType("tricep");
		rec63.setExerciseName("skull_crush");
		rec63.setExerciseDescription("skull_crush_description");
		rec63.setExerciseMuscleIcon("tricep");
		rec63.setExerciseNameStepIcon("skull_crush_step1");
		ExerciseDao.getInstance().saveExercise(rec63);
	
		ExerciseRecord rec67 = new ExerciseRecord();
		rec67.setExerciseMuscleType("tricep");
		rec67.setExerciseName("tricep_extensions");
		rec67.setExerciseDescription("tricep_extensions_description");
		rec67.setExerciseMuscleIcon("tricep");
		rec67.setExerciseNameStepIcon("tricep_extensions_step1");
		ExerciseDao.getInstance().saveExercise(rec67);
		//aici am ramas
		ExerciseRecord rec69 = new ExerciseRecord();
		rec69.setExerciseMuscleType("tricep");
		rec69.setExerciseName("Tricep pull downs");
		rec69.setExerciseDescription("tricep_pull_downs_description");
		rec69.setExerciseMuscleIcon("tricep");
		rec69.setExerciseNameStepIcon("tricep_pull_downs_step1");
		ExerciseDao.getInstance().saveExercise(rec69);

		ExerciseRecord rec71 = new ExerciseRecord();
		rec71.setExerciseMuscleType("tricep");
		rec71.setExerciseName("one_arm_tricep_pull_downs");
		rec71.setExerciseDescription("one_arm_tricep_pull_downs_description");
		rec71.setExerciseMuscleIcon("tricep");
		rec71.setExerciseNameStepIcon("one_arm_tricep_pull_down");
		ExerciseDao.getInstance().saveExercise(rec71);

		ExerciseRecord rec73 = new ExerciseRecord();
		rec73.setExerciseMuscleType("abs");
		rec73.setExerciseName("the_plank");
		rec73.setExerciseDescription("the_plank_description");
		rec73.setExerciseMuscleIcon("abs");
		rec73.setExerciseNameStepIcon("the_plank_step1");
		ExerciseDao.getInstance().saveExercise(rec73);

		ExerciseRecord rec75 = new ExerciseRecord();
		rec75.setExerciseMuscleType("abs");
		rec75.setExerciseName("side_plank");
		rec75.setExerciseDescription("side_plank_description");
		rec75.setExerciseMuscleIcon("abs");
		rec75.setExerciseNameStepIcon("side_plank_step1");
		ExerciseDao.getInstance().saveExercise(rec75);


		ExerciseRecord rec77 = new ExerciseRecord();
		rec77.setExerciseMuscleType("abs");
		rec77.setExerciseName("penguins");
		rec77.setExerciseDescription("penguins_description");
		rec77.setExerciseMuscleIcon("abs");
		rec77.setExerciseNameStepIcon("penguins_step1");
		ExerciseDao.getInstance().saveExercise(rec77);

		ExerciseRecord rec80 = new ExerciseRecord();
		rec80.setExerciseMuscleType("bicep");
		rec80.setExerciseName("diamond_push_ups");
		rec80.setExerciseDescription("diamond_push_ups_description");
		rec80.setExerciseMuscleIcon("bicep");
		rec80.setExerciseNameStepIcon("diamond_push_ups");
		ExerciseDao.getInstance().saveExercise(rec80);

		ExerciseRecord rec83 = new ExerciseRecord();
		rec83.setExerciseMuscleType("tricep");
		rec83.setExerciseName("diamond_push_ups");
		rec83.setExerciseDescription("diamond_push_ups_description");
		rec83.setExerciseMuscleIcon("tricep");
		rec83.setExerciseNameStepIcon("diamond_push_ups");
		ExerciseDao.getInstance().saveExercise(rec83);

		ExerciseRecord rec86 = new ExerciseRecord();
		rec86.setExerciseMuscleType("back");
		rec86.setExerciseName("diamond_push_ups");
		rec86.setExerciseDescription("diamond_push_ups_description");
		rec86.setExerciseMuscleIcon("back");
		rec86.setExerciseNameStepIcon("diamond_push_ups");
		
		ExerciseDao.getInstance().saveExercise(rec86);
		ExerciseRecord rec89 = new ExerciseRecord();
		rec89.setExerciseMuscleType("abs");
		rec89.setExerciseName("sit_ups");
		rec89.setExerciseDescription("sit_ups_description");
		rec89.setExerciseMuscleIcon("abs");
		rec89.setExerciseNameStepIcon("sit_ups_step1");
		ExerciseDao.getInstance().saveExercise(rec89);

		ExerciseRecord rec92 = new ExerciseRecord();
		rec92.setExerciseMuscleType("abs");
		rec92.setExerciseName("russian_twists");
		rec92.setExerciseDescription("russian_twists_description");
		rec92.setExerciseMuscleIcon("abs");
		rec92.setExerciseNameStepIcon("russian_twists");
		ExerciseDao.getInstance().saveExercise(rec92);


		ExerciseRecord rec95 = new ExerciseRecord();
		rec95.setExerciseMuscleType("abs");
		rec95.setExerciseName("dish_position");
		rec95.setExerciseDescription("dish_position_description");
		rec95.setExerciseMuscleIcon("abs");
		rec95.setExerciseNameStepIcon("dish_step1");
		ExerciseDao.getInstance().saveExercise(rec95);

		ExerciseRecord rec98 = new ExerciseRecord();
		rec98.setExerciseMuscleType("bicep");
		rec98.setExerciseName("wide_arm_push_ups");
		rec98.setExerciseDescription("wide_arm_push_ups_description");
		rec98.setExerciseMuscleIcon("bicep");
		rec98.setExerciseNameStepIcon("wide_arm_push_ups_step2");
		ExerciseDao.getInstance().saveExercise(rec98);

		ExerciseRecord rec99 = new ExerciseRecord();
		rec99.setExerciseMuscleType("tricep");
		rec99.setExerciseName("wide_arm_push_ups");
		rec99.setExerciseDescription("wide_arm_push_ups_description");
		rec99.setExerciseMuscleIcon("tricep");
		rec99.setExerciseNameStepIcon("wide_arm_push_ups_step1");
		ExerciseDao.getInstance().saveExercise(rec99);

		ExerciseRecord rec101 = new ExerciseRecord();
		rec101.setExerciseMuscleType("back");
		rec101.setExerciseName("wide_arm_push_ups");
		rec101.setExerciseDescription("wide_arm_push_ups_description");
		rec101.setExerciseMuscleIcon("back");
		rec101.setExerciseNameStepIcon("wide_arm_push_ups_step1");
		ExerciseDao.getInstance().saveExercise(rec101);

		ExerciseRecord rec103 = new ExerciseRecord();
		rec103.setExerciseMuscleType("abs");
		rec103.setExerciseName("crunches");
		rec103.setExerciseDescription("crunches_description");
		rec103.setExerciseMuscleIcon("abs");
		rec103.setExerciseNameStepIcon("crunches");
		ExerciseDao.getInstance().saveExercise(rec103);

		ExerciseRecord rec106 = new ExerciseRecord();
		rec106.setExerciseMuscleType("abs");
		rec106.setExerciseName("alternating_crunches");
		rec106.setExerciseDescription("alternating_crunches");
		rec106.setExerciseMuscleIcon("abs");
		rec106.setExerciseNameStepIcon("alternating_crunches");
		ExerciseDao.getInstance().saveExercise(rec106);

		ExerciseRecord rec109 = new ExerciseRecord();
		rec109.setExerciseMuscleType("shoulders");
		rec109.setExerciseName("shoulder_twists");
		rec109.setExerciseDescription("shoulder_twists_description");
		rec109.setExerciseMuscleIcon("shoulders");
		rec109.setExerciseNameStepIcon("shoulder_twists_step1");
		ExerciseDao.getInstance().saveExercise(rec109);

		ExerciseRecord rec112 = new ExerciseRecord();
		rec112.setExerciseMuscleType("bicep");
		rec112.setExerciseName("hammer_curls");
		rec112.setExerciseDescription("hammer_curls_description");
		rec112.setExerciseMuscleIcon("bicep");
		rec112.setExerciseNameStepIcon("hammer_curls");
		ExerciseDao.getInstance().saveExercise(rec112);

		ExerciseRecord rec114 = new ExerciseRecord();
		rec114.setExerciseMuscleType("back");
		rec114.setExerciseName("squat");
		rec114.setExerciseDescription("squat_description");
		rec114.setExerciseMuscleIcon("back");
		rec114.setExerciseNameStepIcon("squat_step1");
		ExerciseDao.getInstance().saveExercise(rec114);

		ExerciseRecord rec117 = new ExerciseRecord();
		rec117.setExerciseMuscleType("legs");
		rec117.setExerciseName("squat");
		rec117.setExerciseDescription("squat_description");
		rec117.setExerciseMuscleIcon("legs");
		rec117.setExerciseNameStepIcon("squat_step1");
		ExerciseDao.getInstance().saveExercise(rec117);

		ExerciseRecord rec120 = new ExerciseRecord();
		rec120.setExerciseMuscleType("shoulders");
		rec120.setExerciseName("squat");
		rec120.setExerciseDescription("squat_description");
		rec120.setExerciseMuscleIcon("shoulders");
		rec120.setExerciseNameStepIcon("squat_step1");
		ExerciseDao.getInstance().saveExercise(rec120);

		ExerciseRecord rec123 = new ExerciseRecord();
		rec123.setExerciseMuscleType("bicep");
		rec123.setExerciseName("dumbell_curls");
		rec123.setExerciseDescription("dumbell_curls_description");
		rec123.setExerciseMuscleIcon("bicep");
		rec123.setExerciseNameStepIcon("dumbell_curls");
		ExerciseDao.getInstance().saveExercise(rec123);

		ExerciseRecord rec125 = new ExerciseRecord();
		rec125.setExerciseMuscleType("bicep");
		rec125.setExerciseName("zottman_curls");
		rec125.setExerciseDescription("zottman_curls_description");
		rec125.setExerciseMuscleIcon("bicep");
		rec125.setExerciseNameStepIcon("zottman_curls_step1");
		ExerciseDao.getInstance().saveExercise(rec125);

		ExerciseRecord rec128 = new ExerciseRecord();
		rec128.setExerciseMuscleType("tricep");
		rec128.setExerciseName("zottman_curls");
		rec128.setExerciseDescription("zottman_curls_description");
		rec128.setExerciseMuscleIcon("tricep");
		rec128.setExerciseNameStepIcon("zottman_curls_step1");
		ExerciseDao.getInstance().saveExercise(rec128);

		ExerciseRecord rec131 = new ExerciseRecord();
		rec131.setExerciseMuscleType("legs");
		rec131.setExerciseName("bulgarian_split_squat");
		rec131.setExerciseDescription("bulgarian_split_squat_description");
		rec131.setExerciseMuscleIcon("legs");
		rec131.setExerciseNameStepIcon("bulgarian_split_squat");
		ExerciseDao.getInstance().saveExercise(rec131);

		ExerciseRecord rec133 = new ExerciseRecord();
		rec133.setExerciseMuscleType("bicep");
		rec133.setExerciseName("shoulder_press");
		rec133.setExerciseDescription("shoulder_press_description");
		rec133.setExerciseMuscleIcon("bicep");
		rec133.setExerciseNameStepIcon("shoulder_press");
		ExerciseDao.getInstance().saveExercise(rec133);

		ExerciseRecord rec136 = new ExerciseRecord();
		rec136.setExerciseMuscleType("tricep");
		rec136.setExerciseName("shoulder_press");
		rec136.setExerciseDescription("shoulder_press_description");
		rec136.setExerciseMuscleIcon("tricep");
		rec136.setExerciseNameStepIcon("shoulder_press");
		ExerciseDao.getInstance().saveExercise(rec136);

		ExerciseRecord rec139 = new ExerciseRecord();
		rec139.setExerciseMuscleType("shoulders");
		rec139.setExerciseName("shoulder_press");
		rec139.setExerciseDescription("shoulder_press_description");
		rec139.setExerciseMuscleIcon("shoulders");
		rec139.setExerciseNameStepIcon("shoulder_press");
		ExerciseDao.getInstance().saveExercise(rec139);

		ExerciseRecord rec142 = new ExerciseRecord();
		rec142.setExerciseMuscleType("abs");
		rec142.setExerciseName("mason_twist");
		rec142.setExerciseDescription("mason_twist_description");
		rec142.setExerciseMuscleIcon("abs");
		rec142.setExerciseNameStepIcon("mason_twist");
		ExerciseDao.getInstance().saveExercise(rec142);

		ExerciseRecord rec146 = new ExerciseRecord();
		rec146.setExerciseMuscleType("back");
		rec146.setExerciseName("front_squat");
		rec146.setExerciseDescription("front_squat_description");
		rec146.setExerciseMuscleIcon("back");
		rec146.setExerciseNameStepIcon("front_squat");
		ExerciseDao.getInstance().saveExercise(rec146);

		ExerciseRecord rec148 = new ExerciseRecord();
		rec148.setExerciseMuscleType("legs");
		rec148.setExerciseName("front_squat");
		rec148.setExerciseDescription("front_squat_description");
		rec148.setExerciseMuscleIcon("legs");
		rec148.setExerciseNameStepIcon("front_squat");
		ExerciseDao.getInstance().saveExercise(rec148);

		ExerciseRecord rec150 = new ExerciseRecord();
		rec150.setExerciseMuscleType("shoulders");
		rec150.setExerciseName("front_squat");
		rec150.setExerciseDescription("front_squat_description");
		rec150.setExerciseMuscleIcon("shoulders");
		rec150.setExerciseNameStepIcon("front_squat");
		ExerciseDao.getInstance().saveExercise(rec150);

		ExerciseRecord rec152 = new ExerciseRecord();
		rec152.setExerciseMuscleType("back");
		rec152.setExerciseName("romanian_deadlift_straight_leg");
		rec152.setExerciseDescription("romanian_deadlift_straight_leg_description");
		rec152.setExerciseMuscleIcon("back");
		rec152.setExerciseNameStepIcon("romanian_deadlift");
		ExerciseDao.getInstance().saveExercise(rec152);

		ExerciseRecord rec155 = new ExerciseRecord();
		rec155.setExerciseMuscleType("legs");
		rec155.setExerciseName("romanian_deadlift_straight_leg");
		rec155.setExerciseDescription("romanian_deadlift_straight_leg_description");
		rec155.setExerciseMuscleIcon("legs");
		rec155.setExerciseNameStepIcon("romanian_deadlift");
		ExerciseDao.getInstance().saveExercise(rec155);

		ExerciseRecord rec158 = new ExerciseRecord();
		rec158.setExerciseMuscleType("tricep");
		rec158.setExerciseName("behind_the_neck_shoulder_press");
		rec158.setExerciseDescription("behind_the_neck_shoulder_press_description");
		rec158.setExerciseMuscleIcon("tricep");
		rec158.setExerciseNameStepIcon("behind_the_neck_shoulder_press");
		ExerciseDao.getInstance().saveExercise(rec158);

		ExerciseRecord rec161 = new ExerciseRecord();
		rec161.setExerciseMuscleType("back");
		rec161.setExerciseName("behind_the_neck_shoulder_press");
		rec161.setExerciseDescription("behind_the_neck_shoulder_press_description");
		rec161.setExerciseMuscleIcon("back");
		rec161.setExerciseNameStepIcon("behind_the_neck_shoulder_press");
		ExerciseDao.getInstance().saveExercise(rec161);

		ExerciseRecord rec164 = new ExerciseRecord();
		rec164.setExerciseMuscleType("shoulders");
		rec164.setExerciseName("behind_the_neck_shoulder_press");
		rec164.setExerciseDescription("behind_the_neck_shoulder_press_description");
		rec164.setExerciseMuscleIcon("shoulders");
		rec164.setExerciseNameStepIcon("behind_the_neck_shoulder_press");
		ExerciseDao.getInstance().saveExercise(rec164);

		ExerciseRecord rec167 = new ExerciseRecord();
		rec167.setExerciseMuscleType("shoulders");
		rec167.setExerciseName("shrugs");
		rec167.setExerciseDescription("");
		rec167.setExerciseMuscleIcon("shoulders");
		rec167.setExerciseNameStepIcon("shrugs_step1");
		ExerciseDao.getInstance().saveExercise(rec167);

	}
}
