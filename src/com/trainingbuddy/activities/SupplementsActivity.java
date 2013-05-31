package com.trainingbuddy.activities;

import java.sql.SQLException;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.trainingbuddy.R;
import com.trainingbuddy.database.SupplementsDao;
import com.trainingbuddy.fragments.SupplementsFragment;
import com.trainingbuddy.records.SupplementsRecord;

public class SupplementsActivity extends FragmentActivity {

	private SupplementsRecord[] supplements;
	private SupplementsRecord selectedSuppliment;
	private List<SupplementsRecord> supplementsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here you select the layout you will use for this activity
		setContentView(R.layout.supplements_container);
//		Getting the list of exercises from db and converting them to array so we can put the in the adapter
		try {
			supplementsList = SupplementsDao.getInstance().getSupplements();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		supplements = supplementsList.toArray(new SupplementsRecord[supplementsList.size()]);
//		The activity acts like a container and on this container I put the fragment
//		I use fragments because they are faster
		Fragment createSupplementsFragment = (Fragment)this.getSupportFragmentManager().findFragmentByTag("supplementsFragment");
//		Verifying if the bmifragment was already created if not i add it
		if(createSupplementsFragment==null)
		{
//			Here i add the fragment to a layout container (bmi_container)
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.add(R.id.supplements_container, new SupplementsFragment(), "supplementsFragment");
				transaction.commit();
		}
	}

	public SupplementsRecord[] getSupplements() {
		return supplements;
	}

	public void setSupplements(SupplementsRecord[] supplements) {
		this.supplements = supplements;
	}

	public SupplementsRecord getSelectedSuppliment() {
		return selectedSuppliment;
	}

	public void setSelectedSuppliment(SupplementsRecord selectedSuppliment) {
		this.selectedSuppliment = selectedSuppliment;
	}
}
