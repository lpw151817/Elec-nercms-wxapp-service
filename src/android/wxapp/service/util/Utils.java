package android.wxapp.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.wxapp.service.AppApplication;

public class Utils {
	public static String formatDateMs(String ms) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(Long.parseLong(ms)));
	}

	public static String formatDateMs(long ms) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(ms);
	}

	public static String parseDateInFormat(String fotmatTime) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(fotmatTime).getTime() + "";
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean dateIsFormat(String s) {
		try {
			Long l = Long.parseLong(s);
			if (l != null && l > 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return true;
		}
	}

	public static String getImei() {
		TelephonyManager mTelephonyMgr = (TelephonyManager) AppApplication.getInstance()
				.getSystemService(Context.TELEPHONY_SERVICE);
		String imsi = mTelephonyMgr.getSubscriberId();
		String imei = mTelephonyMgr.getDeviceId();
		if (null != imsi)
			Log.i("IMSI", imsi);
		if (null != imei)
			Log.i("IMEI", imei);
		return imei;
	}
}
