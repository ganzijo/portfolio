package com.nuriapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.omrhandheldapp.ReadListFragment;
import com.nuriapp.omrhandheldapp.ReadStorageFragment;
import com.nuriapp.popup.SettingStoragePopup;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener{
	public ReadStorageFragment readStoragefragment;
	public ReadListFragment readListFragment;
	public Activity activity;
	public Button btn_Confirm, btn_Cancel;
	public TextView tv_Title, tv_Message;
	public Activity c;
	
	private String title;
	private String content;
	private boolean is_Out_Touchable;
	private boolean is_cancel_btn_visible;
	
	
	public CustomDialog(Activity a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.c = a;
	}
	
public CustomDialog(ReadStorageFragment fr, String title, String content, boolean is_Out_Touchable, boolean is_cancel_btn_visible) {
		super(fr.getActivity());
		// TODO Auto-generated constructor stub
		this.readStoragefragment = fr;
		this.title = title;
		this.content = content;
		this.is_Out_Touchable = is_Out_Touchable;
		this.is_cancel_btn_visible = is_cancel_btn_visible;
	}
	
public CustomDialog(ReadListFragment readListFragment, String title,String content, boolean is_Out_Touchable, boolean is_cancel_btn_visible) {
	super(readListFragment.getActivity());
	// TODO Auto-generated constructor stub
	this.readListFragment = readListFragment;
	this.title = title;
	this.content = content;
	this.is_Out_Touchable = is_Out_Touchable;
	this.is_cancel_btn_visible = is_cancel_btn_visible;
	}



	/*
	public CustomDialog(SettingSubmitPopup SettingSubmitPopup, String title,String content, boolean is_Out_Touchable, boolean is_cancel_btn_visible) {
		super(SettingSubmitPopup);
		// TODO Auto-generated constructor stub
		this.activity = SettingSubmitPopup;
		this.title = title;
		this.content = content;
		this.is_Out_Touchable = is_Out_Touchable;
		this.is_cancel_btn_visible = is_cancel_btn_visible;
	}
*/
	private void setLayout()
	{
		Typeface typeFaceBody = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/sangsang_font/SangSangBodyM.ttf");
		this.setCanceledOnTouchOutside(false);
		btn_Confirm = (Button) findViewById(R.id.btn_USBDialog_yes);
		btn_Confirm.setOnClickListener(this);
		tv_Title = (TextView) findViewById(R.id.tv_USBDialog_Title);
		tv_Message = (TextView) findViewById(R.id.tv_USBDialog_Message);

		btn_Confirm.setTypeface(typeFaceBody);
		tv_Title.setTypeface(typeFaceBody);
		tv_Message.setTypeface(typeFaceBody);

		this.tv_Title.setText(title);
		this.tv_Message.setText(content);
		this.setCancelable(is_Out_Touchable);
/*
		if(is_cancel_btn_visible == true)
			this.btn_Cancel.setVisibility(View.VISIBLE);
		else
			this.btn_Cancel.setVisibility(View.GONE);*/

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.custom_dialog);

		setLayout();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_yes:
			break;
		case R.id.btn_no:
			break;
		default:
			break;
		}
		dismiss();
	}

}
