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
import com.oos.booksrus.db.User;

public class SignIn extends ActionBarActivity {

	Button signin;
	EditText email_text;
	EditText password_text;
	String email;
	String password;

	DBHelper db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);
		db = DBHelper.getInstance(this);

		signin = (Button) findViewById(R.id.signin_button);
		email_text = (EditText) findViewById(R.id.email);
		password_text = (EditText) findViewById(R.id.password);

		signin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				email = email_text.getText().toString();
				password = password_text.getText().toString();
				User user = db.getUser(email);

				if (user != null) {
					if (user.getPassword().equals(password)) {
						Intent intent = new Intent(view.getContext(),
								MainActivity.class);
						SessionInfo.getInstance().login(user);
						Toast.makeText(view.getContext(),
								"you have been logged in", Toast.LENGTH_LONG)
								.show();
						startActivity(intent);
					} else {
						Toast.makeText(view.getContext(), "invalid password",
								Toast.LENGTH_LONG).show();
					}
				} else {
					Toast.makeText(view.getContext(), "invalid email",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
