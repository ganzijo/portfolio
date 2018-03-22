package com.nuriapp.omrhandheldapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener{
	

	public Activity c;
	public Button yes;
	public TextView title, message;

	public CustomDialog(Activity a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.c = a;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.custom_dialog);
		yes = (Button) findViewById(R.id.btn_yes);
		yes.setOnClickListener(this);
		
		title = (TextView)findViewById(R.id.txt_Title);
		title.setOnClickListener(this);
		message = (TextView)findViewById(R.id.txt_Message);
		message.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_yes:
			break;
		default:
			break;
		}
		dismiss();
	}
}
