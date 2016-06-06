package android.wxapp.service.elec.model.bean.table;

public class tb_task_instructions_attachment {
	String id;
	String instructions_id;
	String type;
	String url;
	String update_time;
	String md5;
	String dixian;

	@Override
	public String toString() {
		return "tb_task_instructions_attachment [id=" + id + ", instructions_id=" + instructions_id
				+ ", type=" + type + ", url=" + url + ", update_time=" + update_time + ", dixian="
				+ dixian + ", md5=" + md5 + "]";
	}

	public tb_task_instructions_attachment(String id, String instructions_id, String type,
			String url, String update_time, String md5, String dixian) {
		super();
		this.id = id;
		this.instructions_id = instructions_id;
		this.type = type;
		this.url = url;
		this.update_time = update_time;
		this.dixian = dixian;
		this.md5 = md5;
	}

	public String getDixian() {
		return dixian;
	}

	public void setDixian(String dixian) {
		this.dixian = dixian;
	}

	public tb_task_instructions_attachment() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstructions_id() {
		return instructions_id;
	}

	public void setInstructions_id(String instructions_id) {
		this.instructions_id = instructions_id;
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

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}
