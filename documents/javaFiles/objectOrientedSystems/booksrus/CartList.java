package com.oos.booksrus.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;

public class CartList extends ListActivity {

	TextView total;
	Button checkout;

	@Override
	protected void onCreate(Bundle savedInstanceData) {
		super.onCreate(savedInstanceData);
		setContentView(R.layout.activity_cart);

		checkout = (Button) findViewById(R.id.checkoutButton);
		checkout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if (SessionInfo.getInstance().getCartProducts().length > 0) {
					Intent intent = new Intent(view.getContext(),
							CheckoutActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(view.getContext(),
							"Please add items to your cart",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		total = (TextView) findViewById(R.id.cartTotal);
		total.setText("Total: $" + SessionInfo.getInstance().getTotal());

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.rowlayout, R.id.label, SessionInfo.getInstance()
						.getCartProducts());
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
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
			case R.id.browse:
				intent = new Intent(this, BookList.class);
				startActivity(intent);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
