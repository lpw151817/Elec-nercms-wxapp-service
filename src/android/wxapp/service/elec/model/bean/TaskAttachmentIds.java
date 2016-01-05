package android.wxapp.service.elec.model.bean;

import java.util.List;

public class TaskAttachmentIds {
	String standard;
	List<Attachment_Ids> sublist;

	public String getPosition() {
		return standard;
	}

	public void setPosition(String standard) {
		this.standard = standard;
	}

	public List<Attachment_Ids> getSublist() {
		return sublist;
	}

	public void setSublist(List<Attachment_Ids> sublist) {
		this.sublist = sublist;
	}

	public TaskAttachmentIds(String standard, List<Attachment_Ids> sublist) {
		super();
		this.standard = standard;
		this.sublist = sublist;
	}

	public TaskAttachmentIds() {
		super();
	}

}
