package android.wxapp.service.elec.model;

public class LoginResponse extends BaseResponseModel {
	String uid;

	public LoginResponse(String s, String uid) {
		super(s);
		this.uid = uid;
	}

	public LoginResponse() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
}
