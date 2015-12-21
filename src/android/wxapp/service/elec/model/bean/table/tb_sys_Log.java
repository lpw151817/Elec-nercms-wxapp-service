package android.wxapp.service.elec.model.bean.table;

public class tb_sys_Log {
	String id;
	String User_name;
	String Type;
	String content;
	String time;
	String longitude;
	String latitude;
	String client;
	String ip;
	public tb_sys_Log(String id, String user_name, String type, String content,
			String time, String longitude, String latitude, String client,
			String ip) {
		super();
		this.id = id;
		User_name = user_name;
		Type = type;
		this.content = content;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
		this.client = client;
		this.ip = ip;
	}
	public tb_sys_Log() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
