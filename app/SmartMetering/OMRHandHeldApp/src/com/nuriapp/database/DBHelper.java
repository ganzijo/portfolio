package com.nuriapp.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	private static DBHelper db_instance;
	
	private static String DB_PATH = "/data/data/com.nuriapp.omrhandheldapp/databases";
	private static String DB_NAME = "nurismartmeteringdb.db";

	public static DBHelper getInstance(Context context) {
		//DB가 생성되어 있지 않으면 DBHelper()를 통해 DB CONNECTED
		if(db_instance == null) {
			db_instance = new DBHelper(context);
		}
		return db_instance;
	}
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
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
