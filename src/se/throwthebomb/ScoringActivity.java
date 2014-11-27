package se.throwthebomb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.zip.Inflater;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoringActivity extends Activity implements ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v13.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scoring);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scoring, menu);
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
		else if (id == R.id.action_addFriends) {
			intent = new Intent(this, AddFriendsActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); 
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			switch(position){
			case 0:
				return new LiveScoringFragment();
			case 1:
				return new AlltimeScoringFragment();
			}
			return null;
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.tab_LiveScoring).toUpperCase(l);
			case 1:
				return getString(R.string.tab_AlltimeScoring).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public class LiveScoringFragment extends Fragment {

		public LiveScoringFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_livescoring,
					container, false);
			
			ListView lvScoringlist = (ListView) rootView.findViewById( R.id.lv_liveScoring );
		    ArrayList<Person> listPersons = new ArrayList<ScoringActivity.Person>();
		    listPersons.add(new Person("Player 1", true));
		    listPersons.add(new Person("Player 2", false));
		    listPersons.add(new Person("Player 3", false));
		    listPersons.add(new Person("Player 4", true));
		    listPersons.add(new Person("Player 5", true));
		    listPersons.add(new Person("6. Player 6", false));
  
		    FriendListAdapter listAdapter = new FriendListAdapter(inflater.getContext(), R.layout.list_scoring, listPersons);

		    lvScoringlist.setAdapter(listAdapter);
			return rootView;
		}

	}

	public class AlltimeScoringFragment extends Fragment {
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_alltimescoring, container, false);
			ListView lvScoringlist = (ListView) rootView.findViewById( R.id.lv_allTimeScoring );
		    String[] planets = new String[] { "1. Player 6", "2. Player 5", "3. Player 3", "4. Player 4",  
                    "5. Player 1", "6. Player 2"};   
		    
		    ArrayList<String> planetList = new ArrayList<String>();  
		    planetList.addAll( Arrays.asList(planets) );  

		    // Create ArrayAdapter using the planet list.  
		    ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.list_scoring, R.id.tv_rowTextView, planetList);
		    
		    lvScoringlist.setAdapter(listAdapter);
			return rootView;
		}
	}
	
	public class FriendListAdapter extends ArrayAdapter<Person>{
		
		LayoutInflater inflater;
		int resourceId;
		Context ctx;
		public FriendListAdapter(Context context, int resourceId,
				ArrayList<Person> person) {
			super(context, resourceId, person);
			inflater = LayoutInflater.from(context);
			this.resourceId = resourceId;
			this.ctx = context;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
            convertView = ( RelativeLayout ) inflater.inflate( resourceId, null );
            Person person = getItem( position );
            
            TextView name = (TextView) convertView.findViewById(R.id.tv_rowTextView);
            name.setText(person.getName());
            
            if (person.isFriend()){
	            ImageView bombImage = (ImageView) convertView.findViewById(R.id.iv_imageFriend);
	            String uri = "drawable/friend";
	            int imageResource = ctx.getResources().getIdentifier(uri, null, ctx.getPackageName());
	            Drawable image = ctx.getResources().getDrawable(imageResource);
	            bombImage.setImageDrawable(image);
            }

            return convertView;
		}
		
	}
	
	public class Person {
		
		private String name;
		private boolean isFriend;
		
		public Person(String name, boolean isFriend){
			this.name = name;
			this.isFriend = isFriend;
		}
		
		public String getName(){
			return this.name;
		}
		
		public boolean isFriend(){
			return this.isFriend;
		}
	}
}
