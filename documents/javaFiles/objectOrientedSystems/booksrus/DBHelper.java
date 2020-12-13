package com.oos.booksrus.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.*;
import android.util.Log;

/*
 * Provides access to the database 
 */
public class DBHelper extends SQLiteOpenHelper {
	private static DBHelper sInstance;

	/*
	 * User table
	 * email is the primary key
	 */
	public static final String TABLE_USER = "users";
	public static final String TABLE_EMPLOYEE = "employee";
	public static final String EMAIL = "email";
	public static final String USER_NAME = "name";
	public static final String PASSWORD = "password";
	public static final String DATE_JOINED = "date";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";

	// database constants
	private static final String DATABASE_NAME = "booksrus.db";
	private static final int DATABASE_VERSION = 1;

	// user table indices
	private static final int USER_NAME_INDEX = 0;
	private static final int USER_EMAIL_INDEX = 1;
	private static final int USER_PASSWORD_INDEX = 2;
	private static final int USER_DATE_JOINED_INDEX = 3;
	private static final int USER_ADDRESS_INDEX = 4;

	private static final String DATABASE_CREATE = "create table " + TABLE_USER
			+ "(" + USER_NAME + " text not null, "
			+ EMAIL + " text not null primary key unique, "
			+ PASSWORD + " text not null, "
			+ DATE_JOINED + " date, "
			+ ADDRESS + " text);";
	
//  Orders
	public static final String ORDER_NUMBER = "ordernum";
	public static final String TABLE_ORDERS = "orders";
	public static final String BOOK_ORDERED = "book";
	public static final String DATE_ORDERED = "date";
	private static final String PURCHASE_AMOUNT = "amount";
	private static final String CREDIT_CARD = "creditcard";
	private static final String ORDER_KEY = "key";
	
	//  Order indices
	private static final int ORDER_NUMBER_INDEX = 0;
	private static final int EMAIL_ORDER_INDEX = 1;
	private static final int BOOK_ORDERED_INDEX = 2;
	private static final int PURCHASE_AMOUNT_INDEX = 3;
	private static final int CREDIT_CARD_INDEX = 4;
	private static final int DATE_ORDERED_INDEX = 5;	
	private static final int ORDER_KEY_INDEX = 6;

	
	
	
	/* uncomment in case of foobar
	private static final String ORDERS_CREATE = "create table " + TABLE_ORDERS
			+ "(" + USER_NAME + " text not null, "
			+ BOOK_ORDERED + " text not null, "
			+ DATE_ORDERED + " date);";
	*/
	
	private static final String ORDERS_CREATE = "create table " + TABLE_ORDERS
			+ "(" + ORDER_NUMBER + " integer primary key autoincrement, "
			+ EMAIL + " text not null, "
			+ BOOK_ORDERED + " text not null, "
			+ PURCHASE_AMOUNT + " text not null, "
			+ CREDIT_CARD + " text not null, "
			+ DATE_ORDERED + " date);";
			//+ ORDER_KEY + " integer autoincrement);";

	
	// user table indices
		private static final int EMPLOYEE_NAME_INDEX = 0;
		private static final int EMPLOYEE_EMAIL_INDEX = 1;
		private static final int EMPLOYEE_PASSWORD_INDEX = 2;
		private static final int EMPLOYEE_DATE_JOINED_INDEX = 3;
		private static final int EMPLOYEE_PHONE_INDEX = 4;
	
	
	private static final String EMPLOYEE_CREATE = "create table " + TABLE_EMPLOYEE
			+ "(" + USER_NAME + " text not null, "
			+ EMAIL + " text not null primary key unique, "
			+ PASSWORD + " text not null, "
			+ DATE_JOINED + " date, "
			+ PHONE + " text);";
	

	public static DBHelper getInstance(Context context) {
		// This method follows the singleton pattern. Ripped off from here:
		// http://www.androiddesignpatterns.com/2012/05/correctly-managing-your-sqlite-database.html
		// to access it: DBHelper.getInstance()
		if (sInstance == null) {
			sInstance = new DBHelper(context.getApplicationContext());
		}

		return sInstance;
	}

	private DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
		database.execSQL(ORDERS_CREATE);
		database.execSQL(EMPLOYEE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

	public boolean insertEmployee(String username, String email,
			  String password, String phone) {
// very helpful:
// http://www.tutorialspoint.com/android/android_sqlite_database.htm
Calendar calendar = Calendar.getInstance();
SQLiteDatabase db = this.getWritableDatabase();
ContentValues values = new ContentValues();
values.put(USER_NAME, username);
values.put(EMAIL, email);
values.put(PASSWORD, password);
values.put(DATE_JOINED, new Date(calendar.getTime().
						 getTime()).toString());
values.put(PHONE, phone);

return (db.insert(TABLE_EMPLOYEE, null, values) != -1);
}

public Employee getEmployee(String email) {
SQLiteDatabase db = this.getReadableDatabase();
Cursor res = db.rawQuery("select * from " + TABLE_EMPLOYEE + " where "
+ EMAIL + " =?;", new String[] { email });

// cursors are lazy loaded, so this loads the cursor into memory
if (!res.moveToFirst()) {
return null;
}
return cursorToEmployee(res);
}

/*
* Extracts the actual data from the cursor
*/
private Employee cursorToEmployee(Cursor cursor) {
Employee employee = new Employee();
employee.setName(cursor.getString(EMPLOYEE_NAME_INDEX));
employee.setEmail(cursor.getString(EMPLOYEE_EMAIL_INDEX));
employee.setPassword(cursor.getString(EMPLOYEE_PASSWORD_INDEX));
employee.setPhone(cursor.getString(EMPLOYEE_PHONE_INDEX));

return employee;
}
	
	
	
	public boolean insertUser(String username, String email,
							  String password, String address) {
		// very helpful:
		// http://www.tutorialspoint.com/android/android_sqlite_database.htm
		Calendar calendar = Calendar.getInstance();
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(USER_NAME, username);
		values.put(EMAIL, email);
		values.put(PASSWORD, password);
		values.put(DATE_JOINED, new Date(calendar.getTime().
										 getTime()).toString());
		values.put(ADDRESS, address);

		return (db.insert(TABLE_USER, null, values) != -1);
	}

	public User getUser(String email) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select * from " + TABLE_USER + " where "
				+ EMAIL + " =?;", new String[] { email });

		// cursors are lazy loaded, so this loads the cursor into memory
		if (!res.moveToFirst()) {
			return null;
		}
		return cursorToUser(res);
	}

	/*
	 * Extracts the actual data from the cursor
	 */
	private User cursorToUser(Cursor cursor) {
		User user = new User();
		user.setName(cursor.getString(USER_NAME_INDEX));
		user.setEmail(cursor.getString(USER_EMAIL_INDEX));
		user.setPassword(cursor.getString(USER_PASSWORD_INDEX));
		user.setAddress(cursor.getString(USER_ADDRESS_INDEX));

		return user;
	}
	
	// For Orders
	/*foobar
	public boolean insertOrder(String username, String books) {
		String id = UUID.randomUUID().toString();
		Calendar calendar = Calendar.getInstance();
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(USER_NAME, username);
		values.put(BOOK_ORDERED, books);
		values.put(DATE_ORDERED, new Date(calendar.getTime().getTime()).toString());
		
		return (db.insert(TABLE_ORDERS, null, values) != -1);
	}
	*/
	
	public boolean CheckIsDataAlreadyInDBorNot(String TableName,
	        String dbfield, String fieldValue) {
	    SQLiteDatabase sqldb = this.getWritableDatabase();
	    String Query = "Select * from " + TableName + " where " + dbfield + "="
	            + fieldValue;
	    Cursor cursor = sqldb.rawQuery(Query, null);
	            if(cursor.getCount()<=0){
	    return false;
	           }
	        return true;
	}
	
	
	public boolean insertOrder(String email, String books, String amount, String ccard) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		String id = UUID.randomUUID().toString();
		
		//TODO couldn't get the order number check to work
		//while(CheckIsDataAlreadyInDBorNot(TABLE_ORDERS, ORDER_NUMBER, id)){
		//	id = UUID.randomUUID().toString();
		//}
		
		Calendar calendar = Calendar.getInstance();
		ContentValues values = new ContentValues();
		//values.put(ORDER_NUMBER, id);
		values.put(EMAIL, email);
		values.put(BOOK_ORDERED, books);
		values.put(PURCHASE_AMOUNT, amount);
		values.put(CREDIT_CARD, ccard );
		values.put(DATE_ORDERED, new Date(calendar.getTime().getTime()).toString());
		
		return (db.insert(TABLE_ORDERS, null, values) != -1);
	}
	
	//remove which order? maybe search by ORDER_NUMBER?
	public void removeOrder(String email, int pos) {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor res = db.rawQuery("select * from " + TABLE_ORDERS + " where "
				+ EMAIL + " =?;", new String[] { email });
		
		// cursors are lazy loaded, so this loads the cursor into memory
		if (!res.moveToFirst()) {
			return;
		}
		
		for (int a=0; a<pos; a++) {
			res.moveToNext();
		}
		
		//Order order = new Order();
		//order.setKey(res.getInt(ORDER_KEY_INDEX));
		
		db.delete(TABLE_ORDERS, ORDER_NUMBER+"="+res.getInt(ORDER_NUMBER_INDEX), null);
		
		// db.rawQuery("delete * from " + TABLE_ORDERS + " where "
			//	+ ORDER_NUMBER + " =?;", new String[] { res.getString(ORDER_NUMBER_INDEX) });
		//db.delete(TABLE_ORDERS, ORDER_NUMBER + "=" + order.getKey(), null);
	}
	
	/* foobar
	public ArrayList<Order> getOrder(String name) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Order> orderList = new ArrayList();
		Cursor res = db.rawQuery("select * from " + TABLE_ORDERS + " where "
				+ USER_NAME + " =?;", new String[] { name });
		
		// cursors are lazy loaded, so this loads the cursor into memory
		if (!res.moveToFirst()) {
			return null;
		}
		
		Order order = new Order();
		order.setName(res.getString(ORDER_NAME_INDEX));
		order.setBook(res.getString(ORDER_BOOK_INDEX));
		order.setDate(res.getString(ORDER_DATE_INDEX));
		orderList.add(order);
		
		while (res.moveToNext()) {
			Order order2 = new Order();
			order2.setName(res.getString(ORDER_NAME_INDEX));
			order2.setBook(res.getString(ORDER_BOOK_INDEX));
			order2.setDate(res.getString(ORDER_DATE_INDEX));
			orderList.add(order2);
		}
		
		return orderList;
	}
	*/
	
	public ArrayList<Order> getOrder(String email) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Order> orderList = new ArrayList<Order>();
		Cursor res = db.rawQuery("select * from " + TABLE_ORDERS + " where "
				+ EMAIL + " =?;", new String[] { email });
		
		// cursors are lazy loaded, so this loads the cursor into memory
		if (!res.moveToFirst()) {
			return null;
		}
		
		Order order = new Order();
		order.setName(res.getString(EMAIL_ORDER_INDEX));
		order.setBook(res.getString(BOOK_ORDERED_INDEX));
		order.setDate(res.getString(DATE_ORDERED_INDEX));
		orderList.add(order);
		
		while (res.moveToNext()) {
			Order order2 = new Order();
			order2.setName(res.getString(EMAIL_ORDER_INDEX));
			order2.setBook(res.getString(BOOK_ORDERED_INDEX));
			order2.setDate(res.getString(DATE_ORDERED_INDEX));
			orderList.add(order2);
		}
		
		return orderList;
	}
		
	private Order cursorToOrder(Cursor cursor) {
		Order order = new Order();
		order.setName(cursor.getString(EMAIL_ORDER_INDEX));
		order.setBook(cursor.getString(BOOK_ORDERED_INDEX));
		order.setDate(cursor.getString(DATE_ORDERED_INDEX));

		return order;
	}

	/* TODO DEBUGGING: REMOVE */
	public ArrayList<Cursor> getData(String Query) {
		// get writable database
		SQLiteDatabase sqlDB = this.getWritableDatabase();
		String[] columns = new String[] { "mesage" };
		// an array list of cursor to save two cursors one has results from the
		// query
		// other cursor stores error message if any errors are triggered
		ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
		MatrixCursor Cursor2 = new MatrixCursor(columns);
		alc.add(null);
		alc.add(null);

		try {
			String maxQuery = Query;
			// execute the query results will be save in Cursor c
			Cursor c = sqlDB.rawQuery(maxQuery, null);

			// add value to cursor2
			Cursor2.addRow(new Object[] { "Success" });

			alc.set(1, Cursor2);
			if (null != c && c.getCount() > 0) {

				alc.set(0, c);
				c.moveToFirst();

				return alc;
			}
			return alc;
		} catch (SQLException sqlEx) {
			Log.d("printing exception", sqlEx.getMessage());
			// if any exceptions are triggered save the error message to cursor
			// an return the arraylist
			Cursor2.addRow(new Object[] { "" + sqlEx.getMessage() });
			alc.set(1, Cursor2);
			return alc;
		} catch (Exception ex) {

			Log.d("printing exception", ex.getMessage());

			// if any exceptions are triggered save the error message to cursor
			// an return the arraylist
			Cursor2.addRow(new Object[] { "" + ex.getMessage() });
			alc.set(1, Cursor2);
			return alc;
		}

	}
}


