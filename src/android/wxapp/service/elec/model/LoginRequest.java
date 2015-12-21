package android.wxapp.service.elec.model;

public class LoginRequest extends BaseRequestModel {
	String i;

	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

	public LoginRequest(String uid, String ic, String i) {
		super(uid, ic);
		this.i = i;
	}

	public LoginRequest() {
		super();
	}

}
