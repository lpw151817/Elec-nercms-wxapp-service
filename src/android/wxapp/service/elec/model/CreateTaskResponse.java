package android.wxapp.service.elec.model;

public class CreateTaskResponse extends BaseResponseModel {
	String tid;

	public CreateTaskResponse(String s, String tid) {
		super(s);
		this.tid = tid;
	}

	public CreateTaskResponse() {
		super();
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
}
