package com.oos.booksrus.activity;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.oos.booksrus.AndroidDatabaseManager;
import com.oos.booksrus.Catalog;
import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;
import com.oos.booksrus.db.DBHelper;
import com.oos.booksrus.db.Order;

import android.widget.Button;
import android.widget.TextView;

public class OrderHistory extends ListActivity {
	DBHelper db;
	String email;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		
		db = DBHelper.getInstance(this);
		email = SessionInfo.getInstance().getUser().getEmail();
		ArrayList<Order> order = db.getOrder(email);
		ArrayList<String> order2 = new ArrayList<String>();
		ArrayList<String> order3 = new ArrayList<String>();
		for (int i=0; i<order.size(); i++) {
			//  An Order
			order3.add("Order #" + (i+1));
			String[] temp = order.get(i).getBook();
			for (int n=0; n<order.get(i).getBook().length; n++) {
				//  Books in an order
				order2.add(temp[n]);
			}
		}
				
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.label, order3);		
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_login, menu);
		return true;
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
				intent = new Intent(this, MainActivity.class);
				startActivity(intent);
				return true;
			case R.id.cart:
				intent = new Intent(this, CartList.class);
				startActivity(intent);
				return true;
			case R.id.history:
				intent = new Intent(this, OrderHistory.class);
				startActivity(intent);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id) {		
		Intent intent = new Intent(this, OrderDetail.class).putExtra("position", position);
		;
		startActivity(intent);
	}
}