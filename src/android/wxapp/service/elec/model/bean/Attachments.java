package android.wxapp.service.elec.model.bean;

public class Attachments {
	String type;
	String url;
	GPS gps;

	public Attachments(String type, String url, GPS gps) {
		super();
		this.type = type;
		this.url = url;
		this.gps = gps;
	}

	public Attachments() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

}
