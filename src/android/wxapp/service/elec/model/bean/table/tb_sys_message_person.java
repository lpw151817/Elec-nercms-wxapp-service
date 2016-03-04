package android.wxapp.service.elec.model.bean.table;

public class tb_sys_message_person {
	private String id;
	private String message_id;
	private String relator_id;
	private String is_read;
	private String type;
	private String update_time;
	public tb_sys_message_person(String id, String message_id,
			String relator_id, String is_read, String type, String update_time) {
		super();
		this.id = id;
		this.message_id = message_id;
		this.relator_id = relator_id;
		this.is_read = is_read;
		this.type = type;
		this.update_time = update_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getRelator_id() {
		return relator_id;
	}
	public void setRelator_id(String relator_id) {
		this.relator_id = relator_id;
	}
	public String getIs_read() {
		return is_read;
	}
	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	
	
}
