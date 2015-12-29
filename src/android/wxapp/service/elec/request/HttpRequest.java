package android.wxapp.service.elec.request;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.wxapp.service.elec.model.CreatePlanTaskRequest;
import android.wxapp.service.elec.model.CreateInsRequest;
import android.wxapp.service.elec.model.LoginRequest;
import android.wxapp.service.elec.model.LoginResponse;
import android.wxapp.service.elec.model.NormalServerResponse;
import android.wxapp.service.elec.model.UpdateRequest;
import android.wxapp.service.elec.model.UpdateResponse;
import android.wxapp.service.elec.model.bean.Attachments;
import android.wxapp.service.elec.model.bean.Leader;
import android.wxapp.service.elec.model.bean.Uid;
import android.wxapp.service.elec.dao.UpdateDao;
import android.wxapp.service.elec.model.bean.User;
import android.wxapp.service.handler.MessageHandlerManager;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class HttpRequest extends BaseRequest {

	private void sendNetworkError(int what, String className) {
		MessageHandlerManager.getInstance().sendMessage(what, null, className);
	}

	/**
	 * 登录请求
	 * 
	 * @param aliasName
	 * @param identifyCode
	 * @param imsi
	 * @return
	 */
	public JsonObjectRequest getLoginRequest(String aliasName, String identifyCode) {
		LoginRequest lr = new LoginRequest(aliasName, identifyCode);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.LOGIN_METHOD
				+ Contants.LOGIN_PARAM + super.gson.toJson(lr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						MessageHandlerManager.getInstance().sendMessage(Constants.LOGIN_SUCCESS,
								gson.fromJson(arg0.toString(), LoginResponse.class),
								LoginResponse.class.getName());
					} else {
						MessageHandlerManager.getInstance().sendMessage(Constants.LOGIN_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								LoginResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					sendNetworkError(Constants.LOGIN_FAIL, LoginResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				sendNetworkError(Constants.LOGIN_FAIL, LoginResponse.class.getName());
			}
		});
	}

	/**
	 * 更新本地数据库请求
	 * 
	 * @param aliasName
	 * @param identifyCode
	 * @param updateTime
	 * @return
	 */
	public JsonObjectRequest getUpdateRequest(final Context c) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		UpdateRequest ur = new UpdateRequest(getUserId(c), getUserIc(c), getLastUpdateTime(c));
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.UPDATE_METHOD
				+ Contants.UPDATE_PARAM + super.gson.toJson(ur);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(final JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						// 开启线程存储
						new Thread(new Runnable() {

							@Override
							public void run() {
								if (new UpdateDao(c).saveUpdate(arg0.toString()))
									MessageHandlerManager.getInstance().sendMessage(
											Constants.LOGIN_UPDATE_SUCCESS,
											UpdateResponse.class.getName());
								else
									MessageHandlerManager.getInstance().sendMessage(
											Constants.LOGIN_UPDATE_SAVE_FAIL,
											UpdateResponse.class.getName());
							}
						}).run();
					} else {
						MessageHandlerManager.getInstance().sendMessage(Constants.LOGIN_UPDATE_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								UpdateResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					MessageHandlerManager.getInstance().sendMessage(Constants.LOGIN_UPDATE_FAIL,
							null, UpdateResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				MessageHandlerManager.getInstance().sendMessage(Constants.LOGIN_UPDATE_FAIL, null,
						UpdateResponse.class.getName());
			}
		});
	}

	/*
	 * 创建计划任务请求
	 * 
	 */
	public JsonObjectRequest getCreatePlanTaskRequest(Context c, String weather, String name,
			String power_cut_range, String effect_eara, String content,
			ArrayList<User> responsibility_user, String plan_start_time, String plan_end_time,
			String category, String is_publish, String special, ArrayList<Leader> leader,
			String measures, String domain, String is_power_cut, String cut_type,
			String implement_org, String number, String remark) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		CreatePlanTaskRequest cptr = new CreatePlanTaskRequest(getUserId(c), getUserIc(c), weather,
				name, power_cut_range, effect_eara, content, responsibility_user, plan_start_time,
				plan_end_time, category, is_publish, special, leader, measures, domain,
				is_power_cut, cut_type, implement_org, number, remark);

		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.CREATEPLANTASK_METHOD
				+ Contants.CREATEPLANTASK_PARAM + super.gson.toJson(cptr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {

					} else {

					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {

			}
		});
	}

	/*
	 * 创建新任务请求
	 */
	public JsonObjectRequest getCreateInsRequest(Context c, List<Uid> uids, String tid, String text,
			List<Attachments> attachments) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		CreateInsRequest ctr = new CreateInsRequest(getUserId(c), getUserIc(c), uids, tid, text,
				attachments);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.CREATETASKINS_METHOD
				+ Contants.CREATETASKINS_PARAM + super.gson.toJson(ctr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {

					} else {

					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {

			}
		});
	}
}
