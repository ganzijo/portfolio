package com.nuriapp.utils;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.util.Log;
import android.widget.Toast;

public class SignalState extends PhoneStateListener {
	public int singalStenths = 0;

	@Override
	public void onSignalStrengthsChanged(SignalStrength signalStrength) {
		super.onSignalStrengthsChanged(signalStrength);
		int singalStrength = signalStrength.getGsmSignalStrength();
		singalStenths = signalStrength.getGsmSignalStrength();
		System.out.println("----- gsm strength" + singalStrength);
		System.out.println("----- gsm strength" + singalStenths);

		if (singalStenths > 30) {
			Log.i("Signal Strength : ", "Good");
		} else if (singalStenths > 20 && singalStenths < 30) {
			Log.i("Signal Strength : ", "Normal");
		} else if (singalStenths < 20) {
			Log.i("Signal Strength : ", "Weak");
		}
	}
}
