package android.wxapp.service.elec.request;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.wxapp.service.elec.model.CreatePlanTaskRequest;
import android.wxapp.service.elec.model.CreatePlanTaskResponse;
import android.wxapp.service.elec.model.CreateInsRequest;
import android.wxapp.service.elec.model.CreateInsResponse;
import android.wxapp.service.elec.model.LoginRequest;
import android.wxapp.service.elec.model.LoginResponse;
import android.wxapp.service.elec.model.NormalServerResponse;
import android.wxapp.service.elec.model.UpdateRequest;
import android.wxapp.service.elec.model.UpdateResponse;
import android.wxapp.service.elec.model.UploadTaskAttachmentRequest;
import android.wxapp.service.elec.model.UploadTaskAttachmentResponse;
import android.wxapp.service.elec.model.bean.Attachment_Ids;
import android.wxapp.service.elec.model.bean.Attachments;
import android.wxapp.service.elec.model.bean.Leader;
import android.wxapp.service.elec.model.bean.TaskAttachment;
import android.wxapp.service.elec.model.bean.Uid;
import android.wxapp.service.elec.dao.GpsDao;
import android.wxapp.service.elec.dao.PlanTaskDao;
import android.wxapp.service.elec.dao.TaskInsDao;
import android.wxapp.service.elec.dao.UpdateDao;
import android.wxapp.service.elec.model.bean.User;
import android.wxapp.service.handler.MessageHandlerManager;
import android.wxapp.service.util.MySharedPreference;

import com.Generate_md5;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.reflect.TypeToken;

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
		LoginRequest lr = new LoginRequest(aliasName, Generate_md5.generate_md5(identifyCode));
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.LOGIN_METHOD
				+ Contants.LOGIN_PARAM + super.gson.toJson(lr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						LoginResponse r = gson.fromJson(arg0.toString(), LoginResponse.class);
						MessageHandlerManager.getInstance().sendMessage(Constants.LOGIN_SUCCESS, r,
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
								if (new UpdateDao(c).saveUpdate(arg0.toString())) {
									MessageHandlerManager.getInstance().sendMessage(
											Constants.LOGIN_UPDATE_SUCCESS,
											UpdateResponse.class.getName());
									saveLastUpdateTime(c);
								} else
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
	public JsonObjectRequest getCreatePlanTaskRequest(final Context c, final String weather,
			final String name, final String power_cut_range, final String effect_eara,
			final String content, final String responsibility_user, final String plan_start_time,
			final String plan_end_time, final String category, final boolean is_publish,
			final String special, final String leader, final String measures, final String domain,
			final boolean is_power_cut, final String cut_type, final String implement_org,
			final String number, final String remark) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;

		CreatePlanTaskRequest cptr = new CreatePlanTaskRequest(getUserId(c), getUserIc(c), weather,
				name, power_cut_range, effect_eara, content, (ArrayList<User>) gson
						.fromJson(responsibility_user, new TypeToken<ArrayList<User>>() {
						}.getType()),
				plan_start_time, plan_end_time, category, is_publish + "", special,
				(ArrayList<Leader>) gson.fromJson(leader, new TypeToken<ArrayList<Leader>>() {
				}.getType()), measures, domain, is_power_cut + "", cut_type, implement_org, number,
				remark);

		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.CREATEPLANTASK_METHOD
				+ Contants.CREATEPLANTASK_PARAM + super.gson.toJson(cptr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						CreatePlanTaskResponse r = gson.fromJson(arg0.toString(),
								CreatePlanTaskResponse.class);

						if (new PlanTaskDao(c).savePlanTask(r.getTid(), weather, name,
								power_cut_range, effect_eara, content, responsibility_user,
								plan_start_time, plan_end_time, "", "", category, is_publish + "",
								special, leader, measures, domain, is_power_cut + "", cut_type,
								implement_org, number, remark, "", getUserId(c), "", "", "", "", "",
								"", "")) {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.CREATE_TASK_SUCCESS, r,
									CreatePlanTaskResponse.class.getName());
							saveLastUpdateTime(c);
						} else {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.CREATE_TASK_SAVE_FAIL, r,
									CreatePlanTaskResponse.class.getName());
						}

					} else {
						MessageHandlerManager.getInstance().sendMessage(Constants.CREATE_TASK_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								CreatePlanTaskResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					MessageHandlerManager.getInstance().sendMessage(Constants.CREATE_TASK_FAIL,
							CreatePlanTaskResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.CREATE_TASK_FAIL,
						CreatePlanTaskResponse.class.getName());
			}
		});
	}

	public JsonObjectRequest getCreateInsRequest(final Context c, List<Uid> uids, String tid,
			String text, List<Attachments> attachments) {
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
						CreateInsResponse r = gson.fromJson(arg0.toString(),
								CreateInsResponse.class);
						// 进行数据库操作
						if (new TaskInsDao(c).saveIns(r)) {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.CREATE_INS_SUCCESS, r,
									CreateInsResponse.class.getName());
							saveLastUpdateTime(c);
						} else
							MessageHandlerManager.getInstance().sendMessage(
									Constants.CREATE_INS_SAVE_FAIL,
									CreateInsResponse.class.getName());
					} else {
						MessageHandlerManager.getInstance().sendMessage(Constants.CREATE_INS_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								CreateInsResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					MessageHandlerManager.getInstance().sendMessage(Constants.CREATE_INS_FAIL,
							CreateInsResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.CREATE_INS_FAIL,
						CreateInsResponse.class.getName());
			}
		});
	}

	public JsonObjectRequest uploadTaskAttachment(final Context c, String tid, String type,
			final List<TaskAttachment> attachment) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		UploadTaskAttachmentRequest ctr = new UploadTaskAttachmentRequest(getUserId(c),
				getUserIc(c), tid, type, attachment);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME
				+ Contants.UPLOAD_TASK_ATTACHMENT_METHOD + Contants.UPLOAD_TASK_ATTACHMENT_PARAM
				+ super.gson.toJson(ctr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						final UploadTaskAttachmentResponse r = gson.fromJson(arg0.toString(),
								UploadTaskAttachmentResponse.class);
						// 进行数据库操作
						if (new PlanTaskDao(c).savePlanTaskAtt(r)) {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.UPLOAD_TASK_ATT_SUCCESS, r,
									UploadTaskAttachmentResponse.class.getName());
							saveLastUpdateTime(c);
						} else {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.UPLOAD_TASK_ATT_SAVE_FAIL,
									UploadTaskAttachmentResponse.class.getName());
						}
					} else {
						MessageHandlerManager.getInstance().sendMessage(
								Constants.UPLOAD_TASK_ATT_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								UploadTaskAttachmentResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					MessageHandlerManager.getInstance().sendMessage(Constants.UPLOAD_TASK_ATT_FAIL,
							UploadTaskAttachmentResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.UPLOAD_TASK_ATT_FAIL,
						UploadTaskAttachmentResponse.class.getName());
			}
		});
	}
}
