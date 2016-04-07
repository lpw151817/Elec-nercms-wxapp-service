package android.wxapp.service.elec.model;

public class HeartBeatRequest extends BaseRequestModel{
String imei;

public String getImei() {
	return imei;
}

public void setImei(String imei) {
	this.imei = imei;
}

public HeartBeatRequest() {
	super();
}

public HeartBeatRequest(String uid, String ic, String imei) {
	super(uid, ic);
	this.imei = imei;
}

}
