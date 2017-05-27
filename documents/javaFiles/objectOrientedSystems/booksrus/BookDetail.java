package com.oos.booksrus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oos.booksrus.Book;
import com.oos.booksrus.Catalog;
import com.oos.booksrus.R;
import com.oos.booksrus.SessionInfo;

public class BookDetail extends ActionBarActivity {

	Button addToCart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bookdetail);

		addToCart = (Button) findViewById(R.id.addToCart);

		Intent intent = getIntent();
		String title = intent.getStringExtra("title");

		TextView headlineTxt = (TextView) findViewById(R.id.bookTitle);
		headlineTxt.setText(title);

		// Don't instantiate catalog here
		Catalog catalog = new Catalog();

		final Book selectedBook;
		selectedBook = catalog.getProductByTitle(title);

		String author[] = selectedBook.getAuthors();
		TextView autText = (TextView) findViewById(R.id.bookAuthor);
		autText.setText(author[0]);

		String description = selectedBook.getDescription();
		TextView descrText = (TextView) findViewById(R.id.bookDesc);
		descrText.setText(description);
		descrText.setMovementMethod(new ScrollingMovementMethod());

		ImageView bookImg = (ImageView) findViewById(R.id.bookIcon);

		if (title.equals("New Moon")) {
			bookImg.setImageResource(R.drawable.newmoon);
		}
		if (title.equals("Twilight")) {
			bookImg.setImageResource(R.drawable.twilight);
		}
		if (title.equals("Eclipse")) {
			bookImg.setImageResource(R.drawable.eclipse);
		}
		if (title.equals("Breaking Dawn")) {
			bookImg.setImageResource(R.drawable.breakingdawn);
		}
		if (title.equals("The Hunger Games")) {
			bookImg.setImageResource(R.drawable.hunger);
		}
		if (title.equals("Catching Fire")) {
			bookImg.setImageResource(R.drawable.catchinfire);
		}
		if (title.equals("Mockingjay")) {
			bookImg.setImageResource(R.drawable.mockin);
		}

		TextView priceText = (TextView) findViewById(R.id.bookPrice);
		priceText.setText("Price: $" + selectedBook.getPrice());

		addToCart.setOnClickListener(new View.OnClickListener() {
			public void onClick(final View view) {
				SessionInfo.getInstance().addProduct(selectedBook);

				Toast.makeText(view.getContext(),
						selectedBook.getTitle() + " added to cart",
						Toast.LENGTH_LONG).show();
				
				//  send back to catalog
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
			case R.id.cart:
				intent = new Intent(this, CartList.class);
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
		}

		return super.onOptionsItemSelected(item);
	}

}
