package android.wxapp.service.elec.model.bean.table;

public class tb_gps_history {
	String id;
	String person_id;
	String ollectionTime;
	String longitude;
	String latitude;
	String gps_type;
	String accuracy;
	String height;
	String speed;
	String update_time;
	String coordinate;
	String remark;
	public tb_gps_history(String id, String person_id, String ollectionTime,
			String longitude, String latitude, String gps_type,
			String accuracy, String height, String speed, String update_time,
			String coordinate, String remark) {
		super();
		this.id = id;
		this.person_id = person_id;
		this.ollectionTime = ollectionTime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.gps_type = gps_type;
		this.accuracy = accuracy;
		this.height = height;
		this.speed = speed;
		this.update_time = update_time;
		this.coordinate = coordinate;
		this.remark = remark;
	}
	public tb_gps_history() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getOllectionTime() {
		return ollectionTime;
	}
	public void setOllectionTime(String ollectionTime) {
		this.ollectionTime = ollectionTime;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getGps_type() {
		return gps_type;
	}
	public void setGps_type(String gps_type) {
		this.gps_type = gps_type;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
