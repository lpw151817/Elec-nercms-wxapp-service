package android.wxapp.service.elec.model;

import java.util.List;

import android.wxapp.service.elec.model.bean.Attachment_Ids;

public class CreateInsResponse extends BaseResponseModel {
	String ins_id;

	List<Attachment_Ids> attachment_ids;

	public CreateInsResponse() {
		super();
	}

	public CreateInsResponse(String s, String ins_id,
			List<Attachment_Ids> attachment_ids) {
		super(s);
		this.ins_id = ins_id;
		this.attachment_ids = attachment_ids;
	}

	public String getIns_id() {
		return ins_id;
	}

	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}

	public List<Attachment_Ids> getAttachment_ids() {
		return attachment_ids;
	}

	public void setAttachment_ids(List<Attachment_Ids> attachment_ids) {
		this.attachment_ids = attachment_ids;
	}

}
