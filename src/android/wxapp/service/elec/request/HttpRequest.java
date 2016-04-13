package android.wxapp.service.elec.request;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.R.raw;
import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.wxapp.service.elec.model.CreatePlanTaskRequest;
import android.wxapp.service.elec.model.CreatePlanTaskResponse;
import android.wxapp.service.elec.model.DeleteTaskRequest;
import android.wxapp.service.elec.model.DeleteTaskResponse;
import android.wxapp.service.elec.model.HeartBeatRequest;
import android.wxapp.service.elec.model.HeartBeatResponse;
import android.wxapp.service.elec.model.CreateInsRequest;
import android.wxapp.service.elec.model.CreateInsResponse;
import android.wxapp.service.elec.model.LoginRequest;
import android.wxapp.service.elec.model.LoginResponse;
import android.wxapp.service.elec.model.NormalServerResponse;
import android.wxapp.service.elec.model.StartTaskRequest;
import android.wxapp.service.elec.model.StartTaskResponse;
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
import android.wxapp.service.elec.dao.OrgDao;
import android.wxapp.service.elec.dao.PlanTaskDao;
import android.wxapp.service.elec.dao.TaskInsDao;
import android.wxapp.service.elec.dao.UpdateDao;
import android.wxapp.service.elec.model.bean.User;
import android.wxapp.service.elec.model.bean.table.tb_task_attachment;
import android.wxapp.service.handler.MessageHandlerManager;
import android.wxapp.service.jerry.model.mqtt.MqttResponse;
import android.wxapp.service.util.MySharedPreference;
import android.wxapp.service.util.Utils;
import net.tsz.afinal.FinalActivity;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.reflect.TypeToken;
import com.imooc.treeview.utils.Node;

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
		LoginRequest lr = new LoginRequest(aliasName, identifyCode, Utils.getImei());
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.LOGIN_METHOD
				+ Contants.LOGIN_PARAM + parase2Json(lr);
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

	public JsonObjectRequest mqttUpdateRequest(final Context c, final MqttResponse response) {
		return getUpdateRequest(c, new Listener<JSONObject>() {

			@Override
			public void onResponse(final JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						// 开启线程存储
						new Thread(new Runnable() {

							@Override
							public void run() {
								if (new UpdateDao(c).saveUpdate(arg0)) {
									Log.v("MQTT", "MQTT SAVE TURE");
									Map<Integer, Object> result = new HashMap<Integer, Object>();
									result.put(1, response);
									result.put(2, arg0.toString());
									MessageHandlerManager.getInstance().sendMessage(
											Constants.MQTT_UPDATE_SUCCESS, result,
											UpdateResponse.class.getName());
									saveLastUpdateTime(c);
								} else {
									Log.v("MQTT", "MQTT SAVE false1");
									MessageHandlerManager.getInstance().sendMessage(
											Constants.MQTT_UPDATE_FAIL,
											UpdateResponse.class.getName());

								}
							}
						}).run();
					} else {
						Log.v("MQTT", "MQTT SAVE false2");
						MessageHandlerManager.getInstance().sendMessage(Constants.MQTT_UPDATE_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								UpdateResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					Log.v("MQTT", "MQTT SAVE false3");
					MessageHandlerManager.getInstance().sendMessage(Constants.MQTT_UPDATE_FAIL,
							null, UpdateResponse.class.getName());
				}
			}
		});

	}

	private JsonObjectRequest getUpdateRequest(final Context c, Listener<JSONObject> listener) {

		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		UpdateRequest ur = new UpdateRequest(getUserId(c), getUserIc(c), getLastUpdateTime(c));
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.UPDATE_METHOD
				+ Contants.UPDATE_PARAM + parase2Json(ur);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, listener, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				MessageHandlerManager.getInstance().sendMessage(Constants.LOGIN_UPDATE_FAIL, null,
						UpdateResponse.class.getName());
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
		return getUpdateRequest(c, new Listener<JSONObject>() {

			@Override
			public void onResponse(final JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						// 开启线程存储
						new Thread(new Runnable() {

							@Override
							public void run() {
								if (new UpdateDao(c).saveUpdate(arg0)) {
									MessageHandlerManager.getInstance().sendMessage(
											Constants.LOGIN_UPDATE_SUCCESS,
											UpdateResponse.class.getName());
									saveLastUpdateTime(c);
								} else {

									MessageHandlerManager.getInstance().sendMessage(
											Constants.LOGIN_UPDATE_SAVE_FAIL,
											UpdateResponse.class.getName());

								}
							}
						}).start();
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
		});
	}

	/*
	 * 创建计划任务请求
	 * 
	 */
	public JsonObjectRequest getCreatePlanTaskRequest(final Context c, final String weather,
			final String name, final String power_cut_range, final String effect_eara,
			final String content, final List<Node> responsibility_user,
			final String plan_start_time, final String plan_end_time, final String category,
			final boolean is_publish, final String special, final List<Node> leader,
			final String measures, final String domain, final boolean is_power_cut,
			final String cut_type, final Node implement_org, final String number,
			final String remark) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		List<User> gzfzr = new ArrayList<User>();
		for (Node node : responsibility_user) {
			User item = new User(node.getId().substring(1));
			gzfzr.add(item);
		}

		List<Leader> ysgdwld = new ArrayList<Leader>();
		for (Node node : leader) {
			Leader item = new Leader(node.getId().substring(1));
			ysgdwld.add(item);
		}
		final String implement_org_Id = new OrgDao(c)
				.getIdFromOc(implement_org.getId().substring(1));
		CreatePlanTaskRequest cptr = new CreatePlanTaskRequest(getUserId(c), getUserIc(c), weather,
				name, power_cut_range, effect_eara, content, gzfzr, plan_start_time, plan_end_time,
				category, is_publish + "", special, ysgdwld, measures, domain, is_power_cut + "",
				cut_type, implement_org_Id, number, remark);

		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.CREATEPLANTASK_METHOD
				+ Contants.CREATEPLANTASK_PARAM + parase2Json(cptr);
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
								implement_org_Id, number, remark, "", getUserId(c),
								System.currentTimeMillis() + "", "", "", "", "", "", "")) {
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

	public JsonObjectRequest getCreateInsRequest(final Context c, List<Node> uids, String tid,
			String text, List<Attachments> attachments, String type) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		List<Uid> uidsList = new ArrayList<Uid>();
		for (Node uid : uids) {
			// 过滤掉自己
			if (type.equals("0")) {
				if (!uid.getId().substring(1).equals(getUserId(c)))
					uidsList.add(new Uid(uid.getId().substring(1)));
			} else {
				if (!uid.getId().equals(getUserId(c)))
					uidsList.add(new Uid(uid.getId()));
			}
		}
		CreateInsRequest ctr = new CreateInsRequest(getUserId(c), getUserIc(c), uidsList, tid, text,
				attachments, type);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.CREATETASKINS_METHOD
				+ Contants.CREATETASKINS_PARAM + parase2Json(ctr);
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
				+ parase2Json(ctr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						final UploadTaskAttachmentResponse r = gson.fromJson(arg0.toString(),
								UploadTaskAttachmentResponse.class);

						// // 进行数据库操作
						// if (new PlanTaskDao(c).savePlanTaskAtt(r)) {
						// MessageHandlerManager.getInstance().sendMessage(
						// Constants.UPLOAD_TASK_ATT_SUCCESS, r,
						// UploadTaskAttachmentResponse.class.getName());
						// saveLastUpdateTime(c);
						// }

						List<String> statuses = new ArrayList<String>(r.getAttachments().size());
						for (int i = 0; i < r.getAttachments().size(); i++) {
							statuses.add("2");
						}
						PlanTaskDao dao = new PlanTaskDao(c);
						boolean isChangeSuccess = dao
								.changeTaskAttachmentsStatus(r.getAttachments(), statuses);
						if (isChangeSuccess) {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.UPLOAD_TASK_ATT_SUCCESS, r,
									UploadTaskAttachmentResponse.class.getName());
							saveLastUpdateTime(c);
						}

						else {
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

	public JsonObjectRequest startTaskTime(final Context c, final String tid, final String time) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		StartTaskRequest ctr = new StartTaskRequest(getUserId(c), getUserIc(c), tid, time);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.START_TASK_METHOD
				+ Contants.START_TASK_PARAM + parase2Json(ctr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						final StartTaskResponse r = gson.fromJson(arg0.toString(),
								StartTaskResponse.class);
						// 操作数据库
						if (new PlanTaskDao(c).changeTaskTime(true, tid, time)) {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.START_TASK_SUCCESS, r,
									StartTaskResponse.class.getName());
							saveLastUpdateTime(c);
						} else {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.START_TASK_SAVE_FAIL,
									StartTaskResponse.class.getName());
						}
					} else {
						MessageHandlerManager.getInstance().sendMessage(Constants.START_TASK_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								StartTaskResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					MessageHandlerManager.getInstance().sendMessage(Constants.START_TASK_FAIL,
							StartTaskResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.START_TASK_FAIL,
						StartTaskResponse.class.getName());
			}
		});
	}

	public JsonObjectRequest endTaskTime(final Context c, final String tid, final String time) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		StartTaskRequest ctr = new StartTaskRequest(getUserId(c), getUserIc(c), tid, time);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.END_TASK_METHOD
				+ Contants.END_TASK_PARAM + parase2Json(ctr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						final StartTaskResponse r = gson.fromJson(arg0.toString(),
								StartTaskResponse.class);
						// 操作数据库
						if (new PlanTaskDao(c).changeTaskTime(false, tid, time)) {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.END_TASK_SUCCESS, r,
									StartTaskResponse.class.getName());
							saveLastUpdateTime(c);
						} else {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.END_TASK_SAVE_FAIL,
									StartTaskResponse.class.getName());
						}
					} else {
						MessageHandlerManager.getInstance().sendMessage(Constants.END_TASK_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								StartTaskResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					MessageHandlerManager.getInstance().sendMessage(Constants.END_TASK_FAIL,
							StartTaskResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.END_TASK_FAIL,
						StartTaskResponse.class.getName());
			}
		});
	}

	public JsonObjectRequest deleteTask(final Context c, final String tid) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		DeleteTaskRequest ctr = new DeleteTaskRequest(getUserId(c), getUserIc(c), tid);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.DELETE_TASK_METHOD
				+ Contants.DELETE_TASK_PARAM + parase2Json(ctr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						final DeleteTaskResponse r = gson.fromJson(arg0.toString(),
								DeleteTaskResponse.class);
						// 操作数据库
						if (new PlanTaskDao(c).deleteTask(tid)) {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.DELETE_TASK_SUCCESS, r,
									DeleteTaskResponse.class.getName());
							saveLastUpdateTime(c);
						} else {
							MessageHandlerManager.getInstance().sendMessage(
									Constants.DELETE_TASK_SAVE_FAIL,
									DeleteTaskResponse.class.getName());
						}
					} else {
						MessageHandlerManager.getInstance().sendMessage(Constants.DELETE_TASK_FAIL,
								gson.fromJson(arg0.toString(), NormalServerResponse.class),
								DeleteTaskResponse.class.getName());
					}
				} catch (JSONException e) {
					e.printStackTrace();
					MessageHandlerManager.getInstance().sendMessage(Constants.DELETE_TASK_FAIL,
							DeleteTaskResponse.class.getName());
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.DELETE_TASK_FAIL,
						DeleteTaskResponse.class.getName());
			}
		});
	}

	public StringRequest heartBeat(Context c) {
		// 如果为获取到用户的id，则直接返回
		if (getUserId(c) == null || getUserIc(c) == null)
			return null;
		HeartBeatRequest ctr = new HeartBeatRequest(getUserId(c), getUserIc(c), Utils.getImei());
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.HEART_BEAT_METHOD
				+ Contants.HEART_BEAT_PARAM + parase2Json(ctr);
		Log.e("URL", this.url);
		return new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String arg0) {
				Log.e("Response", arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.HEART_BEAT_SUCCESS,
						HeartBeatResponse.class.getName());
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				showError(arg0.toString());
				MessageHandlerManager.getInstance().sendMessage(Constants.HEART_BEAT_FAIL,
						HeartBeatResponse.class.getName());
			}
		});
	}

	// public JsonObjectRequest heartBeat(Context c) {
	// // 如果为获取到用户的id，则直接返回
	// if (getUserId(c) == null || getUserIc(c) == null)
	// return null;
	// HeartBeatRequest ctr = new HeartBeatRequest(getUserId(c), getUserIc(c),
	// Utils.getImei());
	// this.url = Contants.SERVER_URL + Contants.MODEL_NAME +
	// Contants.HEART_BEAT_METHOD
	// + Contants.HEART_BEAT_PARAM + parase2Json(ctr);
	// Log.e("URL", this.url);
	// return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {
	//
	// @Override
	// public void onResponse(JSONObject arg0) {
	// Log.e("Response", arg0.toString());
	// try {
	// if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
	// MessageHandlerManager.getInstance().sendMessage(
	// Constants.HEART_BEAT_SUCCESS,
	// gson.fromJson(arg0.toString(), HeartBeatResponse.class),
	// HeartBeatResponse.class.getName());
	// } else {
	// MessageHandlerManager.getInstance().sendMessage(Constants.HEART_BEAT_FAIL,
	// gson.fromJson(arg0.toString(), NormalServerResponse.class),
	// HeartBeatResponse.class.getName());
	// }
	// } catch (JSONException e) {
	// e.printStackTrace();
	// MessageHandlerManager.getInstance().sendMessage(Constants.HEART_BEAT_FAIL,
	// HeartBeatResponse.class.getName());
	// }
	// }
	// }, new ErrorListener() {
	//
	// @Override
	// public void onErrorResponse(VolleyError arg0) {
	// showError(arg0.toString());
	// MessageHandlerManager.getInstance().sendMessage(Constants.HEART_BEAT_FAIL,
	// HeartBeatResponse.class.getName());
	// }
	// });
	//
	// }
}
