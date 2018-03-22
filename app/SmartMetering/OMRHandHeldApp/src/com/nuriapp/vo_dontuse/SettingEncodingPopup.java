package com.nuriapp.vo_dontuse;
/*package com.nuriapp.popup;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;

import com.nuriapp.omrhandheldapp.R;

public class SettingEncodingPopup extends Activity implements OnClickListener {

	private RadioGroup encodingTypeRG;
	private Button btn_Confirm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.popup_setting_encoding);

		encodingTypeRG = (RadioGroup) findViewById(R.id.rg_EncodingType);

		btn_Confirm = (Button) findViewById(R.id.btn_Encoding_Popup_Confirm);
		btn_Confirm.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_Encoding_Popup_Confirm:
			int radioButtonID = encodingTypeRG.getCheckedRadioButtonId();
			View radioButton = encodingTypeRG.findViewById(radioButtonID);
			int idx = encodingTypeRG.indexOfChild(radioButton);
			switch (idx) {
			case 0:
				Log.i("Encoding Type is ", "UTF-8");
			case 2:
				Log.i("Encoding Type is ", "EUC-KR");
			case 4:
				Log.i("Encoding Type is ", "ISO-8859-1");
			}
			String selectType = String.valueOf(idx);
			Log.i("Selected Radio Button", selectType);
			
			break;
			
		}
	}

}*/