package se.throwthebomb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.net.Uri;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class AddFriendsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_friends);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_friends, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Intent intent;
		if (id == R.id.action_settings) {
			intent = new Intent(this, SettingsActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); 
			startActivity(intent);
			return true;
		}
		else if (id == R.id.action_game) {
			intent = new Intent(this, FindTheBombActivity.class); //distinction between BombActivity and FindTheBombActivity needs to be made
			intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); 
			startActivity(intent);
			return true;
		}
		else if (id == R.id.action_scoring) {
			intent = new Intent(this, ScoringActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); 
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void go_to_searchResults(View view) {
		
		
	}

	/*
	see http://www.androidhive.info/2012/09/android-adding-search-functionality-to-listview/
	and maybe http://www.survivingwithandroid.com/2012/10/android-listview-custom-filter-and.html
	*/
	
//	/**
//	 * A simple {@link Fragment} subclass. Activities that contain this fragment
//	 * must implement the {@link Friends_Found.OnFragmentInteractionListener}
//	 * interface to handle interaction events. Use the
//	 * {@link Friends_Found#newInstance} factory method to create an instance of
//	 * this fragment.
//	 *
//	 */
//	public class FriendsFound extends Fragment {
//
//		/**
//		 * Use this factory method to create a new instance of this fragment using
//		 * the provided parameters.
//		 *
//		 * @param param1
//		 *            Parameter 1.
//		 * @param param2
//		 *            Parameter 2.
//		 * @return A new instance of fragment Friends_Found.
//		 */
//		// TODO: Rename and change types and number of parameters
//		public FriendsFound newInstance(String param1, String param2) {
//			FriendsFound fragment = new FriendsFound();
//			Bundle args = new Bundle();
//			args.putString(ARG_PARAM1, param1);
//			args.putString(ARG_PARAM2, param2);
//			fragment.setArguments(args);
//			return fragment;
//		}
//
//		public FriendsFound() {
//			// Required empty public constructor
//		}
//
//		@Override
//		public void onCreate(Bundle savedInstanceState) {
//			super.onCreate(savedInstanceState);
//			if (getArguments() != null) {
//				mParam1 = getArguments().getString(ARG_PARAM1);
//				mParam2 = getArguments().getString(ARG_PARAM2);
//			}
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			// Inflate the layout for this fragment
//			return inflater.inflate(R.layout.fragment_friends__found, container,
//					false);
//		}
//
//		@Override
//		public void onAttach(Activity activity) {
//			super.onAttach(activity);
//			try {
//				mListener = (OnFragmentInteractionListener) activity;
//			} catch (ClassCastException e) {
//				throw new ClassCastException(activity.toString()
//						+ " must implement OnFragmentInteractionListener");
//			}
//		}
//
//		@Override
//		public void onDetach() {
//			super.onDetach();
//			mListener = null;
//		}
//
//		/**
//		 * This interface must be implemented by activities that contain this
//		 * fragment to allow an interaction in this fragment to be communicated to
//		 * the activity and potentially other fragments contained in that activity.
//		 * <p>
//		 * See the Android Training lesson <a href=
//		 * "http://developer.android.com/training/basics/fragments/communicating.html"
//		 * >Communicating with Other Fragments</a> for more information.
//		 */
//		public interface OnFragmentInteractionListener {
//			// TODO: Update argument type and name
//			public void onFragmentInteraction(Uri uri);
//		}
//
//	}
	
}

