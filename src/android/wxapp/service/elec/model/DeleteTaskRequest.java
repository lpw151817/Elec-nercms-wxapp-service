package android.wxapp.service.elec.model;

public class DeleteTaskRequest extends BaseRequestModel {
	String tid;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public DeleteTaskRequest(String uid, String ic, String tid) {
		super(uid, ic);
		this.tid = tid;
	}

	public DeleteTaskRequest() {
		super();
	}

}
