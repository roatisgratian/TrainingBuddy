package com.trainingbuddy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.trainingbuddy.R;
import com.trainingbuddy.activities.SupplementsActivity;
import com.trainingbuddy.adapters.SupplementsAdapter;
import com.trainingbuddy.records.SupplementsRecord;

public class SupplementsFragment extends ListFragment{

	private ListView listView;
	private SupplementsRecord[] supplements;
	private SupplementsAdapter supplementsAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.supplements_layout, null);
	} 

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Here we get the items from the layout so we can use them
		listView = (ListView)getView().findViewById(android.R.id.list);
		supplements = ((SupplementsActivity)getActivity()).getSupplements();
		supplementsAdapter = new SupplementsAdapter(this.getActivity(), supplements);
		listView.setAdapter(supplementsAdapter);
		supplementsAdapter.notifyDataSetChanged();

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Here i set the suppliment that i chosed from the lise
				((SupplementsActivity)getActivity()).setSelectedSuppliment((SupplementsRecord)listView.getItemAtPosition(position));
//				And here you go in the Supplement information fragment
				FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.supplements_container, new SupplementInformationFragment(), "supplementInformationFragment");
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}
		
}
