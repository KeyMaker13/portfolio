package com.oos.booksrus.activity;

import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;
import com.oos.booksrus.R.id;
import com.oos.booksrus.R.layout;
import com.oos.booksrus.R.menu;
import com.oos.booksrus.db.DBHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeSignup extends Activity {

	Button signup;
	EditText emailText;
	EditText nameText;
	EditText passwordText;
	EditText retypePasswordText;
	EditText phoneText;

	DBHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_employee_signup);
		
		db = DBHelper.getInstance(this);

		signup = (Button) findViewById(R.id.employee_signup_button);
		emailText = (EditText) findViewById(R.id.email);
		nameText = (EditText) findViewById(R.id.name);
		passwordText = (EditText) findViewById(R.id.password);
		retypePasswordText = (EditText) findViewById(R.id.retype_password);
		phoneText = (EditText) findViewById(R.id.phone);

		signup.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				String email = emailText.getText().toString();
				String name = nameText.getText().toString();
				String password = passwordText.getText().toString();
				String rePassword = retypePasswordText.getText().toString();
				String phone = phoneText.getText().toString();
				
				if (!password.equals(rePassword)) {
					Toast.makeText(getApplicationContext(),
						"passwords do not match", Toast.LENGTH_LONG).show();
				}

				if (db.insertEmployee(name, email, password, phone)) {
					Intent intent = new Intent(view.getContext(),
							EmployeeSMenu.class);
					SessionInfo.getInstance().loginEmployee(db.getEmployee(email));
					Toast.makeText(getApplicationContext(),
							"you have been logged in", Toast.LENGTH_LONG)
							.show();
					startActivity(intent);
				} else {
					Toast.makeText(view.getContext(), "email already exists",
							Toast.LENGTH_LONG).show();
					emailText.setText("");
				}
			}
		});
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.employee_signup, menu);
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
