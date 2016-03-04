package android.wxapp.service.elec.model.bean.table;

public class tb_sys_person_type {
	
	private String id;
	private String description;
	public tb_sys_person_type(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
