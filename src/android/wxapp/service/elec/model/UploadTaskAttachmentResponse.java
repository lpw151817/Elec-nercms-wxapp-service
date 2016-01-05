package android.wxapp.service.elec.model;

import java.util.List;

import android.wxapp.service.elec.model.bean.TaskAttachmentIds;
import android.wxapp.service.elec.model.bean.table.tb_gps_history;
import android.wxapp.service.elec.model.bean.table.tb_task_attachment;

public class UploadTaskAttachmentResponse extends BaseResponseModel {
	List<tb_task_attachment> attachments;
	List<tb_gps_history> gpss;

	public List<tb_task_attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<tb_task_attachment> attachments) {
		this.attachments = attachments;
	}

	public List<tb_gps_history> getGpss() {
		return gpss;
	}

	public void setGpss(List<tb_gps_history> gpss) {
		this.gpss = gpss;
	}

	public UploadTaskAttachmentResponse(String s, List<tb_task_attachment> attachments,
			List<tb_gps_history> gpss) {
		super(s);
		this.attachments = attachments;
		this.gpss = gpss;
	}

	public UploadTaskAttachmentResponse() {
		super();
	}

}
