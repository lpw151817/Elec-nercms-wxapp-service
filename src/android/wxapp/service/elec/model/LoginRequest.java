package android.wxapp.service.elec.model;

public class LoginRequest {

	String un, ic;
	String imei;

	public LoginRequest(String un, String ic, String imei) {
		super();
		this.un = un;
		this.ic = ic;
		this.imei = imei;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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
