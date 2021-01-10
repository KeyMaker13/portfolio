package com.oos.booksrus.activity;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.oos.booksrus.Book;
import com.oos.booksrus.Catalog;
import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;
import com.oos.booksrus.db.DBHelper;
import com.oos.booksrus.db.Order;

public class OrderDetail extends ListActivity {
	
	Button delete;
	String email;
	DBHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_detail);
		
		Intent intent = getIntent();
		final int pos = intent.getIntExtra("position", 0);
		
		db = DBHelper.getInstance(this);
		email = SessionInfo.getInstance().getUser().getEmail();
		delete = (Button) findViewById(R.id.deleteButton);
		
		delete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//  need to delete entry from database
				db.removeOrder(email, pos);
				
				Intent intent = new Intent(view.getContext(), OrderHistory.class);
				Toast.makeText(view.getContext(),
						"Order deleted",
						Toast.LENGTH_LONG).show();
				startActivity(intent);;
			}
		});

		ArrayList<Order> order = db.getOrder(email);
		ArrayList<String> order2 = new ArrayList<String>();
		
		String[] temp = order.get(pos).getBook();
		for (int a=0; a<order.get(pos).getBook().length; a++) {
			order2.add(temp[a]);
		}
				
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.label, order2);		
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		if (!SessionInfo.getInstance().isLoggedIn()) {
			getMenuInflater().inflate(R.menu.other, menu);
			return true;
		} else {
			getMenuInflater().inflate(R.menu.other_login, menu);
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
			case R.id.action_settings:
				return true;
			case R.id.home:
				intent = new Intent(this, MainActivity.class);
				startActivity(intent);
				return true;
			case R.id.sign_in:
				intent = new Intent(this, SignIn.class);
				startActivity(intent);
				return true;
			case R.id.sign_up:
				intent = new Intent(this, SignUp.class);
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
		}

		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, BookDetail.class).putExtra("title", l
				.getItemAtPosition(position).toString());
		;
		startActivity(intent);
	}

}
