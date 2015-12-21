package android.wxapp.service.elec.model;

public class CreatePlanTaskResponse extends BaseResponseModel {
	String tid;

	public CreatePlanTaskResponse(String s, String tid) {
		super(s);
		this.tid = tid;
	}

	public CreatePlanTaskResponse() {
		super();
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
}
