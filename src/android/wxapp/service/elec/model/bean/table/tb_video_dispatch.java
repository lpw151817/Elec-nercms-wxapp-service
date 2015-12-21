package android.wxapp.service.elec.model.bean.table;

public class tb_video_dispatch {
	String id;
	String launch_user_id;
	String launch_time;
	String dispatch_id;
	String url;
	String md5;
	String launch_ip;
	String dispatch_ip;
	public tb_video_dispatch(String id, String launch_user_id,
			String launch_time, String dispatch_id, String url, String md5,
			String launch_ip, String dispatch_ip) {
		super();
		this.id = id;
		this.launch_user_id = launch_user_id;
		this.launch_time = launch_time;
		this.dispatch_id = dispatch_id;
		this.url = url;
		this.md5 = md5;
		this.launch_ip = launch_ip;
		this.dispatch_ip = dispatch_ip;
	}
	public tb_video_dispatch() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLaunch_user_id() {
		return launch_user_id;
	}
	public void setLaunch_user_id(String launch_user_id) {
		this.launch_user_id = launch_user_id;
	}
	public String getLaunch_time() {
		return launch_time;
	}
	public void setLaunch_time(String launch_time) {
		this.launch_time = launch_time;
	}
	public String getDispatch_id() {
		return dispatch_id;
	}
	public void setDispatch_id(String dispatch_id) {
		this.dispatch_id = dispatch_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getLaunch_ip() {
		return launch_ip;
	}
	public void setLaunch_ip(String launch_ip) {
		this.launch_ip = launch_ip;
	}
	public String getDispatch_ip() {
		return dispatch_ip;
	}
	public void setDispatch_ip(String dispatch_ip) {
		this.dispatch_ip = dispatch_ip;
	}
	
	
	
}
