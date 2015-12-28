package android.wxapp.service.elec.model;

import java.util.List;

import android.wxapp.service.elec.model.bean.Attachments;
import android.wxapp.service.elec.model.bean.Uid;

public class CreateInsRequest extends BaseRequestModel {

	List<Uid> uids;

	String tid;

	String text;

	List<Attachments> attachments;

	


	public CreateInsRequest(String uid, String ic, List<Uid> uids, String tid,
			String text, List<Attachments> attachments) {
		super(uid, ic);
		this.uids = uids;
		this.tid = tid;
		this.text = text;
		this.attachments = attachments;
	}
	
	

	public String getTid() {
		return tid;
	}



	public void setTid(String tid) {
		this.tid = tid;
	}



	public CreateInsRequest() {
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
