package android.wxapp.service.elec.model;

import java.util.List;

import android.wxapp.service.elec.model.bean.Attachments;
import android.wxapp.service.elec.model.bean.Uid;

public class CreateTaskRequest extends BaseRequestModel {

	List<Uid> uids;

	

	String text;

	List<Attachments> attachments;

	

	public CreateTaskRequest(String uid, String ic, List<Uid> uids,
			String text, List<Attachments> attachments) {
		super(uid, ic);
		this.uids = uids;
		this.text = text;
		this.attachments = attachments;
	}

	public CreateTaskRequest() {
		super();
	}

	public List<Uid> getUids() {
		return uids;
	}

	public void setUids(List<Uid> uids) {
		this.uids = uids;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Attachments> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}

	
}
