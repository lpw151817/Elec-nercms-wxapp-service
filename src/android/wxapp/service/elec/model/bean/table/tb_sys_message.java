package android.wxapp.service.elec.model.bean.table;

public class tb_sys_message {
	private String id;
	private String type;
	private String sender_id;
	private String relation_id;
	private String send_time;
	private String content;
	private String update_time;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getRelation_id() {
		return relation_id;
	}

	public void setRelation_id(String relation_id) {
		this.relation_id = relation_id;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public tb_sys_message(String id, String type, String sender_id,
			String relation_id, String send_time, String content,
			String update_time) {
		super();
		this.id = id;
		this.type = type;
		this.sender_id = sender_id;
		this.relation_id = relation_id;
		this.send_time = send_time;
		this.content = content;
		this.update_time = update_time;
	}

	public tb_sys_message() {
		// TODO Auto-generated constructor stub
	}

}
