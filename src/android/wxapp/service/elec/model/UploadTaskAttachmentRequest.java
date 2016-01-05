package android.wxapp.service.elec.model;

import java.util.List;

import android.wxapp.service.elec.model.bean.TaskAttachment;

public class UploadTaskAttachmentRequest extends BaseRequestModel {
	String tid, type;
	List<TaskAttachment> attachments;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TaskAttachment> getAttachment() {
		return attachments;
	}

	public void setAttachment(List<TaskAttachment> attachment) {
		this.attachments = attachment;
	}

	public UploadTaskAttachmentRequest(String uid, String ic, String tid, String type,
			List<TaskAttachment> attachment) {
		super(uid, ic);
		this.tid = tid;
		this.type = type;
		this.attachments = attachment;
	}

	public UploadTaskAttachmentRequest() {
		super();
	}

}
