package android.wxapp.service.elec.request;

import java.net.URLDecoder;
import java.net.URLEncoder;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.wxapp.service.util.MySharedPreference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseRequest {
	protected Gson gson;
	protected String url;

	protected String parase2Json(Object o) {
		String encode = URLEncoder.encode(gson.toJson(o));
		Log.e("BaseRequest", (URLDecoder.decode(encode).equals(gson.toJson(o))) + "");
		return encode;
	}

	public void showError(String s) {
		Log.e(getClass().getName(), s);
	}

	public BaseRequest() {
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}

	protected String getUserId(Context c) {
		return MySharedPreference.get(c, MySharedPreference.USER_ID, null);
	}

	protected String getLastUpdateTime(Context c) {
		return MySharedPreference.get(c, MySharedPreference.LAST_UPDATE_ORGCODE_TIMESTAMP, null);
	}

	protected void saveLastUpdateTime(Context c) {
		saveLastUpdateTime(c, (System.currentTimeMillis() + 1000) + "");
	}

	protected void saveLastUpdateTime(Context c, String time) {
		MySharedPreference.save(c, MySharedPreference.LAST_UPDATE_ORGCODE_TIMESTAMP, time);
	}

	protected String getUserIc(Context context) {
		// return Generate_md5
		// .generate_md5(MySharedPreference.get(context,
		// MySharedPreference.USER_IC,
		// null));
		return MySharedPreference.get(context, MySharedPreference.USER_IC, null);
	}

	protected String getUserName(Context c) {
		return MySharedPreference.get(c, MySharedPreference.USER_NAME, null);
	}

}
