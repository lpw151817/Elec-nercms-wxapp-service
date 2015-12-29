package android.wxapp.service.elec.request;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.provider.MediaStore.Video;
import android.wxapp.service.AppApplication;
import android.wxapp.service.elec.model.bean.Leader;
import android.wxapp.service.elec.model.bean.User;
import android.wxapp.service.jerry.model.affair.CreateTaskRequestAttachment;
import android.wxapp.service.jerry.model.affair.CreateTaskRequestIds;
import android.wxapp.service.jerry.model.conference.ConferenceUpdateQueryResponseRids;
import android.wxapp.service.jerry.model.feedback.TaskFeedbackRequestIds;
import android.wxapp.service.jerry.model.group.GroupUpdateQueryRequestIds;
import android.wxapp.service.jerry.model.person.GetPersonInfoRequest;
import android.wxapp.service.model.AffairModel;
import android.wxapp.service.model.CustomerContactModel;
import android.wxapp.service.model.CustomerModel;
import android.wxapp.service.model.FeedbackModel;
import android.wxapp.service.model.MessageModel;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * �������������
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
			String effect_eara, String content, String responsibility_user, String plan_start_time,
			String plan_end_time, String category, boolean is_publish, String special,
			String leader, String measures, String domain, boolean is_power_cut, String cut_type,
			String implement_org, String number, String remark) {
		queue.add(httpRequest.getCreatePlanTaskRequest(c, weather, name, power_cut_range,
				effect_eara, content, responsibility_user, plan_start_time, plan_end_time, category,
				is_publish, special, leader, measures, domain, is_power_cut, cut_type,
				implement_org, number, remark));
	}

}
