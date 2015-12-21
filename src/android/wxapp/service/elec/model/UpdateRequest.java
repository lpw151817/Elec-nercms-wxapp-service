package android.wxapp.service.elec.model;

public class UpdateRequest extends BaseRequestModel {
	String t;

	public UpdateRequest(String uid, String ic, String t) {
		super(uid, ic);
		this.t = t;
	}

	public UpdateRequest() {
		super();
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	
	
	
	
}
