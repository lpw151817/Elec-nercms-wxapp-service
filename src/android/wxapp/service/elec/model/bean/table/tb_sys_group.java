package android.wxapp.service.elec.model.bean.table;

public class tb_sys_group {

	private String id;
	private String type;
	private String name;
	private String create_time;
	private String update_time;
	
	
	
	public tb_sys_group(String id, String type, String name,
			String create_time, String update_time) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.create_time = create_time;
		this.update_time = update_time;
	}



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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCreate_time() {
		return create_time;
	}



	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}



	public String getUpdate_time() {
		return update_time;
	}



	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}



	public tb_sys_group() {
	}

}
