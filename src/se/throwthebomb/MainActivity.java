package se.throwthebomb;

import se.throwthebomb.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements DialogInterface.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		return super.onOptionsItemSelected(item);
//	}
	
	public void go_to_register (View view) {
		setContentView(R.layout.activity_register);
	}
	
	public void do_registration(View view) {
		TextView txtView;
		String user, pwd, pwd2;
		
		txtView=(TextView)findViewById(R.id.editText_Register_User);
		user = txtView.getText().toString();
		txtView=(TextView)findViewById(R.id.editText_Register_Pwd);
		pwd = txtView.getText().toString();
		txtView=(TextView)findViewById(R.id.editText_Register_PwdRepeat);
		pwd2 = txtView.getText().toString();
		
		if(!pwd.equals(pwd2)) {				
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("error msg");
			alertDialog.setNegativeButton("OK", this);
			alertDialog.setMessage("the entered passwords do not match!");
			alertDialog.show();
		}
		else if(user.matches("max")) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("error msg");
			alertDialog.setNegativeButton("OK", this);
			alertDialog.setMessage("the user already exists!");
			alertDialog.show();
		}
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
	
}
