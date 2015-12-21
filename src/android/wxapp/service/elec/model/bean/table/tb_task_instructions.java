package android.wxapp.service.elec.model.bean.table;

public class tb_task_instructions {
	String id;
	String task_id;
	String content;
	String send_id;
	String send_time;
	public tb_task_instructions(String id, String task_id, String content,
			String send_id, String send_time) {
		super();
		this.id = id;
		this.task_id = task_id;
		this.content = content;
		this.send_id = send_id;
		this.send_time = send_time;
	}
	public tb_task_instructions() {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	
	
}
