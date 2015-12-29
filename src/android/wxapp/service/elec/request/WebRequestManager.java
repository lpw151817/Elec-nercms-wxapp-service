package android.wxapp.service.elec.request;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.provider.MediaStore.Video;
import android.wxapp.service.AppApplication;
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
 * Õ¯¬Á«Î«Ûπ‹¿Ì∆˜
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

}
