package com.nuriapp.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ToggleButtonGroupTableLayout extends TableLayout implements
		OnClickListener {

	@SuppressWarnings("unused")
	private static final String TAG = "ToggleButtonGroupTableLayout";
	public static RadioButton activeRadioButton;

	public ToggleButtonGroupTableLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public ToggleButtonGroupTableLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void onClick(View v) {
		final RadioButton radioBtn = (RadioButton) v;
		if (activeRadioButton != null) {
			activeRadioButton.setChecked(false);
			Log.i(activeRadioButton.getText().toString(), "activeRadioButton");
		}
		radioBtn.setChecked(true);
		activeRadioButton = radioBtn;
	}

	public void addView(View child, android.view.ViewGroup.LayoutParams params) {
		super.addView(child, params);
		setChildrenOnClickListener((TableRow) child);
	}

	private void setChildrenOnClickListener(TableRow tr) {
		final int c = tr.getChildCount();
		for (int i = 0; i < c; i++) {
			final View v = tr.getChildAt(i);
			if (v instanceof RadioButton) {
				v.setOnClickListener(this);
			}
		}
	}

	public int getCheckedRadioButtonId() {
		if (activeRadioButton != null) {
			return activeRadioButton.getId();
		}

		return -1;
	}

	public String getCurrentRadioButton() {
		if (activeRadioButton != null) {
			return activeRadioButton.getText().toString();
		}
		return "";
	}
}
