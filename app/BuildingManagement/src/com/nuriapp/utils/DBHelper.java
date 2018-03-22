package com.nuriapp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static String DB_PATH = "/data/data/com.nuriapp.activitiy/databases/";
	private static String DB_NAME = "nuri.db";

	/**
	 * Constructor Takes and keeps a reference of the passed context in order to
	 * access to the application assets and resources.
	 * 
	 * @param context
	 */
	public DBHelper(Context context) {
		super(context, DB_PATH + "/" + DB_NAME, null, 1);
		initialize(context);
	}

	public static void initialize(Context ctx) {
		File folder = new File(DB_PATH);
		folder.mkdirs();

		File outfile = new File(DB_PATH + "/" + DB_NAME);

		if (outfile.length() <= 0) {
			AssetManager assetManager = ctx.getResources().getAssets();
			try {
				InputStream is = assetManager.open(DB_NAME,
						AssetManager.ACCESS_BUFFER);
				long filesize = is.available();
				byte[] tempdata = new byte[(int) filesize];
				is.read(tempdata);
				is.close();
				outfile.createNewFile();
				FileOutputStream fo = new FileOutputStream(outfile);
				fo.write(tempdata);
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
