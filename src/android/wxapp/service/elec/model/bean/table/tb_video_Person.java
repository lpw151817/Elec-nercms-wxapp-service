package android.wxapp.service.elec.model.bean.table;

public class tb_video_Person {
	String id;
	String dispatch_id;
	String user_id;
	String user_ip;
	String type;
	public tb_video_Person(String id, String dispatch_id, String user_id,
			String user_ip, String type) {
		super();
		this.id = id;
		this.dispatch_id = dispatch_id;
		this.user_id = user_id;
		this.user_ip = user_ip;
		this.type = type;
	}
	public tb_video_Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDispatch_id() {
		return dispatch_id;
	}
	public void setDispatch_id(String dispatch_id) {
		this.dispatch_id = dispatch_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
