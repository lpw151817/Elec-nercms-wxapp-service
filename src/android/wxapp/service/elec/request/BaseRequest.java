package android.wxapp.service.elec.request;

import java.net.URLEncoder;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.wxapp.service.util.MySharedPreference;

import com.Generate_md5;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseRequest {
	protected Gson gson;
	protected String url;

	protected String parase2Json(Object o) {
		return URLEncoder.encode(gson.toJson(o));
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
		MySharedPreference.save(c, MySharedPreference.LAST_UPDATE_ORGCODE_TIMESTAMP,
				System.currentTimeMillis() + "");
	}

	protected void saveLastUpdateTime(Context c, String time) {
		MySharedPreference.save(c, MySharedPreference.LAST_UPDATE_ORGCODE_TIMESTAMP, time);
	}

	protected String getUserIc(Context context) {
		return Generate_md5
				.generate_md5(MySharedPreference.get(context, MySharedPreference.USER_IC, null));
	}

	protected String getUserName(Context c) {
		return MySharedPreference.get(c, MySharedPreference.USER_NAME, null);
	}

}
