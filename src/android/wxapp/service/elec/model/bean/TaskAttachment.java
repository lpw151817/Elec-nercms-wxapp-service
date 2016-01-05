package android.wxapp.service.elec.model.bean;

import java.util.List;

public class TaskAttachment {
	String standard;
	List<Attachments> sublist;

	public String getPosition() {
		return standard;
	}

	public void setPosition(String standard) {
		this.standard = standard;
	}

	public List<Attachments> getSublist() {
		return sublist;
	}

	public void setSublist(List<Attachments> sublist) {
		this.sublist = sublist;
	}

	public TaskAttachment(String standard, List<Attachments> sublist) {
		super();
		this.standard = standard;
		this.sublist = sublist;
	}

	public TaskAttachment() {
		super();
	}

}
