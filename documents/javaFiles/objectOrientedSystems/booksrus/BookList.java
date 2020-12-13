package com.oos.booksrus.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oos.booksrus.Catalog;
import com.oos.booksrus.R;

public class BookList extends ListActivity {

	Catalog bookCatalog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		bookCatalog = new Catalog();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booklist);

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.rowlayout, R.id.label, bookCatalog.getProductStrings());
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

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, BookDetail.class).putExtra("title", l
				.getItemAtPosition(position).toString());
		;
		startActivity(intent);
	}
}