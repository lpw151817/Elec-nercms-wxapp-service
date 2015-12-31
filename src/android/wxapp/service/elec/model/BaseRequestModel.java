package android.wxapp.service.elec.model;

public class BaseRequestModel {
	String un, ic;

	public String getUid() {
		return un;
	}

	public void setUid(String uid) {
		this.un = uid;
	}

	public String getIc() {
		return ic;
	}

	public void setIc(String ic) {
		this.ic = ic;
	}

	public BaseRequestModel(String uid, String ic) {
		super();
		this.un = uid;
		this.ic = ic;
	}

	public BaseRequestModel() {
		super();
	}

}
