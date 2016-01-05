package android.wxapp.service.elec.model;

public class LoginRequest {

	String un, ic;

	public LoginRequest(String un, String ic) {
		this.un = un;
		this.ic = ic;
	}

	public LoginRequest() {
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getIc() {
		return ic;
	}

	public void setIc(String ic) {
		this.ic = ic;
	}

}
