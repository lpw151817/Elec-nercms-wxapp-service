package android.wxapp.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
