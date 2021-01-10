package com.oos.booksrus.activity;

import com.oos.booksrus.R;
import com.oos.booksrus.R.id;
import com.oos.booksrus.R.layout;
import com.oos.booksrus.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class EmployeeMenu extends Activity {
	
	Button signup;
	Button signin;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_employee_menu);
		
		signup = (Button)findViewById(R.id.signup);
		signin = (Button)findViewById(R.id.signin);
		
		signup.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) { 
				
				Intent intent = new Intent(view.getContext(), EmployeeSignup.class);
				startActivity(intent);
				
				
				
			}	
			});
		
		
		signin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) { 
				
				Intent intent = new Intent(view.getContext(), EmployeeSignin.class);
				startActivity(intent);
				
				
				
				
			}	
			});
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.employee_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
