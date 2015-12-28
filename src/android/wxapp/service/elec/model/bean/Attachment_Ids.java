package android.wxapp.service.elec.model.bean;

public class Attachment_Ids {
	String aid;
	String gpsid;

	public Attachment_Ids(String aid, String gpsid) {
		super();
		this.aid = aid;
		this.gpsid = gpsid;
	}

	public Attachment_Ids() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getGpsid() {
		return gpsid;
	}

	public void setGpsid(String gpsid) {
		this.gpsid = gpsid;
	}

}
