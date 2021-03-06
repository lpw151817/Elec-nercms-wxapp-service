package android.wxapp.service.request;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.wxapp.service.dao.GpsDao;
import android.wxapp.service.handler.MessageHandlerManager;
import android.wxapp.service.jerry.model.gps.GpsInfo;
import android.wxapp.service.jerry.model.gps.GpsUpdateQueryRequest;
import android.wxapp.service.jerry.model.gps.GpsUpdateQueryResponse;
import android.wxapp.service.jerry.model.gps.GpsUploadRequest;
import android.wxapp.service.jerry.model.gps.GpsUploadResponse;
import android.wxapp.service.jerry.model.gps.QueryGpssRequest;
import android.wxapp.service.jerry.model.gps.QueryGpssRequestIds;
import android.wxapp.service.jerry.model.gps.QueryGpssResponse;
import android.wxapp.service.jerry.model.gps.QueryLastGpssRequestIds;
import android.wxapp.service.jerry.model.gps.QueryLastGpssRequest;
import android.wxapp.service.jerry.model.gps.QueryLastGpssResponse;
import android.wxapp.service.jerry.model.gps.QueryLastPersonalGpsRequest;
import android.wxapp.service.jerry.model.gps.QueryLastPersonalGpsResponse;
import android.wxapp.service.jerry.model.gps.QueryPersonalGpssReponse;
import android.wxapp.service.jerry.model.gps.QueryPersonalGpssRequest;
import android.wxapp.service.jerry.model.normal.NormalServerResponse;
import android.wxapp.service.jerry.model.person.ModifyCustomerRequest;
import android.wxapp.service.jerry.model.person.ModifyCustomerResponse;
import android.wxapp.service.thread.SaveGpsUpdateThread;
import android.wxapp.service.thread.SaveGroupThread;
import android.wxapp.service.util.Constant;

import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * 完成文档中GPS模块的全部接口请求 待测试
 * 
 * @author JerryLiu
 *
 */
public class GpsRequest extends BaseRequest {
	// ======================================================
	//
	// JerryLiu 2015.5.22 Complete
	//
	// 1.gpsUpload
	// 2.queryLastPersonalGPS
	// 3.queryLastGPSs
	// 4.queryPersonalGPSs
	// 5.queryGpss
	//
	// ======================================================

	/**
	 * GPS信息上传
	 * 
	 * @param c
	 * @param identifyCode
	 *            密码
	 * @param g
	 *            GPS信息对象
	 * @return
	 */
	public JsonObjectRequest gpsUpload(final Context c, final GpsInfo g) {
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		// 将gps信息直接打包成json传输，之后需要将gps信息进行压缩处理
		GpsUploadRequest params = new GpsUploadRequest(getUserId(c), getUserIc(c), gson.toJson(g));
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.METHOD_GPS_UPLOAD
				+ Contants.PARAM_NAME + parase2Json(params);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						GpsUploadResponse r = gson.fromJson(arg0.toString(), GpsUploadResponse.class);
						// db insert
						new GpsDao(c).saveGpsUpdate(getUserId(c), r.getGid(), g, "1", "");
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.GPS_UPLOAD_REQUEST_SECCESS, r, Contants.METHOD_GPS_UPLOAD);
					} else {
						NormalServerResponse r = gson.fromJson(arg0.toString(),
								NormalServerResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.GPS_UPLOAD_REQUEST_FAIL, r, Contants.METHOD_GPS_UPLOAD);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				arg0.printStackTrace();
			}
		});
	}

	/**
	 * 查询个人实时GPS信息
	 * 
	 * @param c
	 * @param identifyCode
	 * @param id
	 *            待查人员的id
	 * @return
	 */
	public JsonObjectRequest queryLastPersonalGPS(Context c, String id) {
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		QueryLastPersonalGpsRequest params = new QueryLastPersonalGpsRequest(getUserId(c), getUserIc(c),
				id);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME
				+ Contants.METHOD_GPS_QUERY_LAST_PERSONAL_GPS + Contants.PARAM_NAME
				+ parase2Json(params);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						QueryLastPersonalGpsResponse r = gson.fromJson(arg0.toString(),
								QueryLastPersonalGpsResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_PERSONAL_LAST_GPS_REQUEST_SECCESS, r,
								Contants.METHOD_GPS_QUERY_LAST_PERSONAL_GPS);
					} else {
						NormalServerResponse r = gson.fromJson(arg0.toString(),
								NormalServerResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_PERSONAL_LAST_GPS_REQUEST_FAIL, r,
								Contants.METHOD_GPS_QUERY_LAST_PERSONAL_GPS);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				arg0.printStackTrace();
			}
		});
	}

	/**
	 * 查询相关用户最新的gps信息
	 * 
	 * @param c
	 * @param identifyCode
	 * @param ids
	 *            待查询的用户id数组
	 * @return
	 */
	public JsonObjectRequest queryLastGPSs(Context c, String[] ids) {
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		List<QueryLastGpssRequestIds> idList = new ArrayList<QueryLastGpssRequestIds>();
		for (int i = 0; i < ids.length; i++) {
			idList.add(new QueryLastGpssRequestIds(ids[i]));
		}
		QueryLastGpssRequest params = new QueryLastGpssRequest(getUserId(c), getUserIc(c), idList);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.METHOD_GPS_QUERY_LAST_GPSS
				+ Contants.PARAM_NAME + parase2Json(params);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						QueryLastGpssResponse r = gson.fromJson(arg0.toString(),
								QueryLastGpssResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_LAST_GPSS_REQUEST_SECCESS, r,
								Contants.METHOD_GPS_QUERY_LAST_GPSS);
					} else {
						NormalServerResponse r = gson.fromJson(arg0.toString(),
								NormalServerResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_LAST_GPSS_REQUEST_FAIL, r,
								Contants.METHOD_GPS_QUERY_LAST_GPSS);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				arg0.printStackTrace();
			}
		});
	}

	/**
	 * 查询个人轨迹
	 * 
	 * @param c
	 * @param identifyCode
	 * @param cid
	 *            需要查询的人员id
	 * @return
	 */
	public JsonObjectRequest queryPersonalGPSs(Context c, String cid) {
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		QueryPersonalGpssRequest params = new QueryPersonalGpssRequest(getUserId(c), getUserIc(c), cid);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.METHOD_GPS_QUERY_PERSONAL_GPSS
				+ Contants.PARAM_NAME + parase2Json(params);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						QueryPersonalGpssReponse r = gson.fromJson(arg0.toString(),
								QueryPersonalGpssReponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_PERSONAL_GPSS_REQUEST_SECCESS, r,
								Contants.METHOD_GPS_QUERY_PERSONAL_GPSS);
					} else {
						NormalServerResponse r = gson.fromJson(arg0.toString(),
								NormalServerResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_PERSONAL_GPSS_REQUEST_FAIL, r,
								Contants.METHOD_GPS_QUERY_PERSONAL_GPSS);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				arg0.printStackTrace();
			}
		});
	}

	/**
	 * 查询多人轨迹
	 * 
	 * @param c
	 * @param identifyCode
	 * @param cids
	 *            待查询的用户id数组
	 * @return
	 */
	public JsonObjectRequest queryGpss(Context c, String[] cids) {
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		List<QueryGpssRequestIds> l = new ArrayList<QueryGpssRequestIds>();
		for (int i = 0; i < cids.length; i++) {
			l.add(new QueryGpssRequestIds(cids[i]));
		}
		QueryGpssRequest params = new QueryGpssRequest(getUserId(c), getUserIc(c), l);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.METHOD_GPS_QUERY_GPSS
				+ Contants.PARAM_NAME + parase2Json(params);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						QueryGpssResponse r = gson.fromJson(arg0.toString(), QueryGpssResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_GPSS_REQUEST_SECCESS, r, Contants.METHOD_GPS_QUERY_GPSS);
					} else {
						NormalServerResponse r = gson.fromJson(arg0.toString(),
								NormalServerResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_GPSS_REQUEST_FAIL, r, Contants.METHOD_GPS_QUERY_GPSS);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				arg0.printStackTrace();
			}
		});
	}

	public JsonObjectRequest getGroupUpdate(final Context c, String count) {
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		String lastUpdateTime = getLastGpsUpdateTime(c);
		if (lastUpdateTime == null)
			lastUpdateTime = System.currentTimeMillis() + "";
		GpsUpdateQueryRequest params = new GpsUpdateQueryRequest(getUserId(c), getUserIc(c),
				lastUpdateTime, count);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.METHOD_GPS_UPDAET
				+ Contants.PARAM_NAME + parase2Json(params);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						GpsUpdateQueryResponse r = gson.fromJson(arg0.toString(),
								GpsUpdateQueryResponse.class);
						// db insert
						new SaveGpsUpdateThread(c, r).run();
					} else {
						NormalServerResponse r = gson.fromJson(arg0.toString(),
								NormalServerResponse.class);
						// 将返回结果返回给handler进行ui处理
						MessageHandlerManager.getInstance().sendMessage(
								Constant.QUERY_GPSS_REQUEST_FAIL, r, Contants.METHOD_GPS_UPDAET);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				arg0.printStackTrace();
			}
		});
	}
}
