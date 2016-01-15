package android.wxapp.service.elec.model;

public class StartTaskRequest extends BaseRequestModel {
	String tid, time;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public StartTaskRequest(String uid, String ic, String tid, String time) {
		super(uid, ic);
		this.tid = tid;
		this.time = time;
	}

	public StartTaskRequest() {
		super();
	}

}
