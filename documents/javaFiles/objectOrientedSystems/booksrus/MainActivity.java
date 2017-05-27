package com.oos.booksrus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.oos.booksrus.AndroidDatabaseManager;
import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;
import com.oos.booksrus.db.DBHelper;

public class MainActivity extends ActionBarActivity {

	DBHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = DBHelper.getInstance(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		if (!SessionInfo.getInstance().isLoggedIn()) {
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		} else {
			getMenuInflater().inflate(R.menu.main_login, menu);
			return true;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		Intent intent;
		switch (item.getItemId()) {
			case R.id.sign_up:
				intent = new Intent(this, SignUp.class);
				startActivity(intent);
				return true;
			case R.id.action_settings:
				/* TODO */
			case R.id.sign_in:
				intent = new Intent(this, SignIn.class);
				startActivity(intent);
				return true;
			case R.id.db:
				/* TODO For debugging: REMOVE */
				intent = new Intent(this, AndroidDatabaseManager.class);
				startActivity(intent);
				return true;
			case R.id.browse:
				intent = new Intent(this, BookList.class);
				startActivity(intent);
				return true;
			case R.id.log_out:
				SessionInfo.getInstance().logout();
				Toast.makeText(this, "you have been logged out",
						Toast.LENGTH_LONG).show();
				startActivity(getIntent());
				return true;
			case R.id.cart:
				intent = new Intent(this, CartList.class);
				startActivity(intent);
				return true;
			case R.id.history:
				intent = new Intent(this, OrderHistory.class);
				startActivity(intent);
				return true;
			case R.id.employee:
				intent = new Intent(this,EmployeeMenu.class);
				startActivity(intent);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}
}