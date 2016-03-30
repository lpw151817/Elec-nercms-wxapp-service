package android.wxapp.service.elec.model.bean.table;

public class tb_task_attachment {
	String id;
	String task_id;
	String historygps;
	String standard;
	String type;
	String url;
	String status;
	@Override
	public String toString() {
		return "tb_task_attachment [id=" + id + ", task_id=" + task_id + ", historygps="
				+ historygps + ", standard=" + standard + ", type=" + type + ", url=" + url
				+ ", upload_time=" + upload_time + ", md5=" + md5 + "]";
	}
	String upload_time;
	String md5;
	public tb_task_attachment(String id, String task_id, String historygps,
			String standard, String type, String url, String upload_time,
			String md5,String status) {
		super();
		this.id = id;
		this.task_id = task_id;
		this.historygps = historygps;
		this.standard = standard;
		this.type = type;
		this.url = url;
		this.upload_time = upload_time;
		this.md5 = md5;
		this.status=status;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public tb_task_attachment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getHistorygps() {
		return historygps;
	}
	public void setHistorygps(String historygps) {
		this.historygps = historygps;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
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
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	
	
}
