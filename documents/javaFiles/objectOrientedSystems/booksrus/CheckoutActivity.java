package com.oos.booksrus.activity;

import java.math.BigDecimal;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;
import com.oos.booksrus.db.DBHelper;

public class CheckoutActivity extends ActionBarActivity {

	EditText user_email;
	EditText address;
	EditText name;
	EditText ccard;
	TextView totalText;
	TextView subtotalText;
	
	private BigDecimal total;
	
	Button confirm;
	DBHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkout);
		db = DBHelper.getInstance(this);
		
		user_email = (EditText) findViewById(R.id.email_checkout);
		address = (EditText) findViewById(R.id.address_checkout);
		name = (EditText) findViewById(R.id.name_checkout);
		ccard = (EditText) findViewById(R.id.credit_checkout);
		totalText = (TextView) findViewById(R.id.cartTotal_checkout);
		subtotalText = (TextView) findViewById(R.id.subtotal_checkout);

		// auto-fill the data if the user is logged in
		if (SessionInfo.getInstance().isLoggedIn()) {
			user_email.setText(SessionInfo.getInstance().getUser().getEmail());
			address.setText(SessionInfo.getInstance().getUser().getAddress());
			name.setText(SessionInfo.getInstance().getUser().getName());
		}
		
		BigDecimal subtotal = BigDecimal.valueOf(SessionInfo.getInstance().
				getTotal()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		total = BigDecimal.valueOf(SessionInfo.getInstance().
				getFinalCost()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		totalText.setText("Total: $" + total.toString());
		subtotalText.setText("Subtotal: $" + subtotal.toString());
		
		confirm = (Button) findViewById(R.id.confirm_button);		
		confirm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				String custEmail = user_email.getText().toString();
				String credCard = ccard.getText().toString();
				
				String[] bookTitles = SessionInfo.getInstance().getCartProducts();
				
				String theBookNames = TextUtils.join("SeparateTheBooks", bookTitles);
				
				db.insertOrder(custEmail, theBookNames, total.toString(), credCard);
				Intent intent = new Intent(view.getContext(), MainActivity.class);
				Toast.makeText(getApplicationContext(), "Transaction completed! Thank you for your order", Toast.LENGTH_LONG).show();
				startActivity(intent);
			}
		});
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
}
