package com.trainingbuddy.database.data;

import java.sql.SQLException;

import com.trainingbuddy.database.SupplementsDao;
import com.trainingbuddy.records.SupplementsRecord;

public class SupplimentData {

	public static void insertSupplimentsInDatabase() throws SQLException
	{
//		Supplements records to be put in the database
		SupplementsRecord sup1 = new SupplementsRecord();
		sup1.setName("acai_berry");
		sup1.setDescription("acai_berry_description");
		sup1.setNutritions("acai_berry_nutritions");
		sup1.setSupplementIcon("acai_berry");
		SupplementsDao.getInstance().saveSupplement(sup1);
		
		
		SupplementsRecord sup2 = new SupplementsRecord();
		sup2.setName("bcaa_s");
		sup2.setDescription("bcaa_s_description");
		sup2.setNutritions("bcaa_s_nutritions");
		sup2.setSupplementIcon("bcaas");
		SupplementsDao.getInstance().saveSupplement(sup2);
		
		SupplementsRecord sup3 = new SupplementsRecord();
		sup3.setName("bulgarian_tribulus");
		sup3.setDescription("bulgarian_tribulus_description");
		sup3.setNutritions("bulgarian_tribulus_nutritions");
		sup3.setSupplementIcon("tribulus");
		SupplementsDao.getInstance().saveSupplement(sup3);
		
		SupplementsRecord sup4 = new SupplementsRecord();
		sup4.setName("cla");
		sup4.setDescription("cla_description");
		sup4.setNutritions("cla_nutritions");
		sup4.setSupplementIcon("cla");
		SupplementsDao.getInstance().saveSupplement(sup4);
		
		SupplementsRecord sup5 = new SupplementsRecord();
		sup5.setName("creatine_monohydrate");
		sup5.setDescription("creatine_monohydrate_description");
		sup5.setNutritions("creatine_monohydrate_nutritions");
		sup5.setSupplementIcon("creatine");
		SupplementsDao.getInstance().saveSupplement(sup5);
		
		SupplementsRecord sup6 = new SupplementsRecord();
		sup6.setName("green_tea");
		sup6.setDescription("green_tea_description");
		sup6.setNutritions("green_tea_nutritions");
		sup6.setSupplementIcon("green_tea");
		SupplementsDao.getInstance().saveSupplement(sup6);
		
		SupplementsRecord sup7 = new SupplementsRecord();
		sup7.setName("mass_gainer");
		sup7.setDescription("mass_gainer_description");
		sup7.setNutritions("mass_gainer_nutritions");
		sup7.setSupplementIcon("mass_gainer");
		SupplementsDao.getInstance().saveSupplement(sup7);
		
		SupplementsRecord sup8 = new SupplementsRecord();
		sup8.setName("nitric_oxyde");
		sup8.setDescription("nitric_oxyde_description");
		sup8.setNutritions("nitric_oxyde_nutritions");
		sup8.setSupplementIcon("nitricacid");
		SupplementsDao.getInstance().saveSupplement(sup8);
		
		SupplementsRecord sup9 = new SupplementsRecord();
		sup9.setName("protein_bar");
		sup9.setDescription("protein_bar_description");
		sup9.setNutritions("protein_bar_nutritions");
		sup9.setSupplementIcon("protein_bar");
		SupplementsDao.getInstance().saveSupplement(sup9);
		
		SupplementsRecord sup10 = new SupplementsRecord();
		sup10.setName("whey_protein");
		sup10.setDescription("whey_protein_description");
		sup10.setNutritions("whey_protein_nutritions");
		sup10.setSupplementIcon("whey_protein");
		SupplementsDao.getInstance().saveSupplement(sup10);
		
		SupplementsRecord sup11 = new SupplementsRecord();
		sup11.setName("zepherine");
		sup11.setDescription("zepherine_description");
		sup11.setNutritions("zepherine_nutritions");
		sup11.setSupplementIcon("zepherine");
		SupplementsDao.getInstance().saveSupplement(sup11);
	}
}
