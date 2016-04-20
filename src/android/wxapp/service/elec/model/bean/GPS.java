package android.wxapp.service.elec.model.bean;

import android.text.TextUtils;

public class GPS {

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

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getOllectionTime() {
		return TextUtils.isEmpty(ollectionTime) ? "" : ollectionTime;
	}

	public void setOllectionTime(String ollectionTime) {
		this.ollectionTime = ollectionTime;
	}

	public String getLongitude() {
		return TextUtils.isEmpty(longitude) ? "" : longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return TextUtils.isEmpty(latitude) ? "" : latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getGps_type() {
		return TextUtils.isEmpty(gps_type) ? "" : gps_type;
	}

	public void setGps_type(String gps_type) {
		this.gps_type = gps_type;
	}

	public String getAccuracy() {
		return TextUtils.isEmpty(accuracy) ? "" : accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getHeight() {
		return TextUtils.isEmpty(height) ? "" : height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getSpeed() {
		return TextUtils.isEmpty(speed) ? "" : speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getUpdate_time() {
		return TextUtils.isEmpty(update_time) ? "" : update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getCoordinate() {
		return TextUtils.isEmpty(coordinate) ? "" : coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getRemark() {
		return TextUtils.isEmpty(remark) ? "" : remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public GPS(String person_id, String ollectionTime, String longitude, String latitude,
			String gps_type, String accuracy, String height, String speed, String update_time,
			String coordinate, String remark) {
		super();
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

	public GPS() {
		super();
	}

}
