package com.oos.booksrus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;
import com.oos.booksrus.db.DBHelper;

public class SignUp extends ActionBarActivity {

	Button signup;
	EditText emailText;
	EditText nameText;
	EditText passwordText;
	EditText retypePasswordText;
	EditText addressText;

	DBHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		db = DBHelper.getInstance(this);

		signup = (Button) findViewById(R.id.signup_button);
		emailText = (EditText) findViewById(R.id.email);
		nameText = (EditText) findViewById(R.id.name);
		passwordText = (EditText) findViewById(R.id.password);
		retypePasswordText = (EditText) findViewById(R.id.retype_password);
		addressText = (EditText) findViewById(R.id.address);

		signup.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				String email = emailText.getText().toString();
				String name = nameText.getText().toString();
				String password = passwordText.getText().toString();
				String rePassword = retypePasswordText.getText().toString();
				String address = addressText.getText().toString();
				
				if (!password.equals(rePassword)) {
					Toast.makeText(getApplicationContext(),
						"passwords do not match", Toast.LENGTH_LONG).show();
				}

				if (db.insertUser(name, email, password, address)) {
					Intent intent = new Intent(view.getContext(),
							MainActivity.class);
					SessionInfo.getInstance().login(db.getUser(email));
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
		getMenuInflater().inflate(R.menu.signup, menu);
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
