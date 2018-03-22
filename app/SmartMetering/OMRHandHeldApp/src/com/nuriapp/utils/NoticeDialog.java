package com.nuriapp.utils;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.omrhandheldapp.ReadListFragment;
import com.nuriapp.omrhandheldapp.ReadStorageFragment;

public class NoticeDialog extends Dialog implements android.view.View.OnClickListener {

	public ReadListFragment fragment;
	public ReadStorageFragment Storage_fragment;
	public Button btn_Confirm, btn_Cancel;
	public TextView tv_Title, tv_Message;
	public String current_fragment;
	public String readStoragefr_select;
	
	
	
	private String title;
	private String content;
	private boolean is_Out_Touchable;
	private boolean is_cancel_btn_visible;
	
	public NoticeDialog(ReadListFragment fr, String title, String content, boolean is_Out_Touchable, boolean is_cancel_btn_visible) {
		super(fr.getActivity());
		// TODO Auto-generated constructor stub
		this.fragment = fr;
		
		this.title = title;
		this.content = content;
		this.is_Out_Touchable = is_Out_Touchable;
		this.is_cancel_btn_visible = is_cancel_btn_visible;
		current_fragment = "ReadListFragment";
	}

	public NoticeDialog(ReadStorageFragment readStorageFragment, String title,String content, boolean is_Out_Touchable, boolean is_cancel_btn_visible, String select) {
		// TODO Auto-generated constructor stub
		super(readStorageFragment.getActivity());
		this.Storage_fragment = readStorageFragment;
		
		this.title = title;
		this.content = content;
		this.is_Out_Touchable = is_Out_Touchable;
		this.is_cancel_btn_visible = is_cancel_btn_visible;
		current_fragment = "ReadStorageFragment";
		readStoragefr_select = select;
		
	}
	public NoticeDialog(ReadStorageFragment readStorageFragment, String title,String content, boolean is_Out_Touchable, boolean is_cancel_btn_visible) {
		// TODO Auto-generated constructor stub
		super(readStorageFragment.getActivity());
		this.Storage_fragment = readStorageFragment;
		
		this.title = title;
		this.content = content;
		this.is_Out_Touchable = is_Out_Touchable;
		this.is_cancel_btn_visible = is_cancel_btn_visible;
		
	}




	private void setLayout()
	{
		Typeface typeFaceBody = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/sangsang_font/SangSangBodyM.ttf");
		this.setCanceledOnTouchOutside(false);
		btn_Confirm = (Button) findViewById(R.id.btn_yes);
		btn_Cancel = (Button) findViewById(R.id.btn_no);
		btn_Confirm.setOnClickListener(this);
		btn_Cancel.setOnClickListener(this);
		tv_Title = (TextView) findViewById(R.id.txt_Title);
		tv_Message = (TextView) findViewById(R.id.txt_Message);

		btn_Confirm.setTypeface(typeFaceBody);
		btn_Cancel.setTypeface(typeFaceBody);
		tv_Title.setTypeface(typeFaceBody);
		tv_Message.setTypeface(typeFaceBody);

		this.tv_Title.setText(title);
		this.tv_Message.setText(content);
		this.setCancelable(is_Out_Touchable);

		if(is_cancel_btn_visible == true)
			this.btn_Cancel.setVisibility(View.VISIBLE);
		else
			this.btn_Cancel.setVisibility(View.GONE);

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.notice_dialog);

		setLayout();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_yes:
			if(btn_Cancel != null)
				if(current_fragment.equals("ReadListFragment")){
					fragment.checkListDelete();
					Log.i("fragement",current_fragment);
				}else if(current_fragment.equals("ReadStorageFragment")){
					if(readStoragefr_select.equals("USB")){
						Storage_fragment.USB();
						Log.i("ReadStorageFragment",readStoragefr_select);
					}else if(readStoragefr_select.equals("DELETE")){
						Storage_fragment.checkListDelete();
						Log.i("ReadStorageFragment",readStoragefr_select);
					}
				}else
					break;
		case R.id.btn_no:
			break;
		default:
			break;
		}
		dismiss();
	}
}
