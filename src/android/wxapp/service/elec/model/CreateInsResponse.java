package android.wxapp.service.elec.model;

import java.util.List;

import android.wxapp.service.elec.model.bean.Attachment_Ids;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions_attachment;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions_receive;

public class CreateInsResponse extends BaseResponseModel {
	String id, task_id, content, send_id, send_time;
	List<tb_task_instructions_receive> receivers;
	List<tb_task_instructions_attachment> attachments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSend_id() {
		return send_id;
	}

	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public List<tb_task_instructions_receive> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<tb_task_instructions_receive> receivers) {
		this.receivers = receivers;
	}

	public List<tb_task_instructions_attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<tb_task_instructions_attachment> attachments) {
		this.attachments = attachments;
	}

	public CreateInsResponse(String s, String id, String task_id, String content, String send_id,
			String send_time, List<tb_task_instructions_receive> receivers,
			List<tb_task_instructions_attachment> attachments) {
		super(s);
		this.id = id;
		this.task_id = task_id;
		this.content = content;
		this.send_id = send_id;
		this.send_time = send_time;
		this.receivers = receivers;
		this.attachments = attachments;
	}

	public CreateInsResponse() {
		super();
	}

}
