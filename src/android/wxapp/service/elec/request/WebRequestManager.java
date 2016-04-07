package android.wxapp.service.elec.request;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.provider.MediaStore.Video;
import android.wxapp.service.AppApplication;
import android.wxapp.service.elec.model.bean.Attachments;
import android.wxapp.service.elec.model.bean.Leader;
import android.wxapp.service.elec.model.bean.TaskAttachment;
import android.wxapp.service.elec.model.bean.Uid;
import android.wxapp.service.elec.model.bean.User;
import android.wxapp.service.jerry.model.affair.CreateTaskRequestAttachment;
import android.wxapp.service.jerry.model.affair.CreateTaskRequestIds;
import android.wxapp.service.jerry.model.conference.ConferenceUpdateQueryResponseRids;
import android.wxapp.service.jerry.model.feedback.TaskFeedbackRequestIds;
import android.wxapp.service.jerry.model.group.GroupUpdateQueryRequestIds;
import android.wxapp.service.jerry.model.mqtt.MqttResponse;
import android.wxapp.service.jerry.model.person.GetPersonInfoRequest;
import android.wxapp.service.model.AffairModel;
import android.wxapp.service.model.CustomerContactModel;
import android.wxapp.service.model.CustomerModel;
import android.wxapp.service.model.FeedbackModel;
import android.wxapp.service.model.MessageModel;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.imooc.treeview.utils.Node;

/**
 * 网络请求管理器
 * 
 * @author WEIHAO
 * 
 */
public class WebRequestManager {

	private Context context;
	private AppApplication application = null;
	private RequestQueue queue = null;
	private HttpRequest httpRequest;

	public WebRequestManager(AppApplication application, Context context) {
		this.context = context;
		this.application = application;
		this.queue = this.application.myQueue;
		httpRequest = new HttpRequest();
	}

	public void login(String aliasName, String identifyCode) {
		queue.add(httpRequest.getLoginRequest(aliasName, identifyCode));
	}

	public void loginUpdate(Context c) {
		queue.add(httpRequest.getUpdateRequest(c));
	}

	public void createPlanTask(Context c, String weather, String name, String power_cut_range,
			String effect_eara, String content, List<Node> responsibility_user,
			String plan_start_time, String plan_end_time, String category, boolean is_publish,
			String special, List<Node> leader, String measures, String domain, boolean is_power_cut,
			String cut_type, Node implement_org, String number, String remark) {
		queue.add(httpRequest.getCreatePlanTaskRequest(c, weather, name, power_cut_range,
				effect_eara, content, responsibility_user, plan_start_time, plan_end_time, category,
				is_publish, special, leader, measures, domain, is_power_cut, cut_type,
				implement_org, number, remark));
	}

	/**
	 * 
	 * @param c
	 * @param uids
	 * @param tid
	 * @param text
	 * @param attachments
	 * @param type
	 *            0,临时指令；1,通知消息
	 */
	public void createInsRequest(Context c, List<Node> uids, String tid, String text,
			List<Attachments> attachments, String type) {
		queue.add(httpRequest.getCreateInsRequest(c, uids, tid, text, attachments, type));
	}

	public void uploadTaskAttachment(Context c, String tid, String type,
			List<TaskAttachment> attachment) {
		queue.add(httpRequest.uploadTaskAttachment(c, tid, type, attachment));
	}

	public void startTask(Context c, String tid, String time) {
		queue.add(httpRequest.startTaskTime(c, tid, time));
	}

	public void endTask(Context c, String tid, String time) {
		queue.add(httpRequest.endTaskTime(c, tid, time));
	}

	public void deleteTask(Context c, String tid) {
		queue.add(httpRequest.deleteTask(c, tid));
	}

	public void mqttUpdate(Context c, MqttResponse response) {
		queue.add(httpRequest.mqttUpdateRequest(c, response));
	}

	public void heartBeat(Context c) {
		queue.add(httpRequest.heartBeat(c));
	}
}
