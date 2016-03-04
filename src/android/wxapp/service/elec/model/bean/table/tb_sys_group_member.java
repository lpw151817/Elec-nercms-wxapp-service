package android.wxapp.service.elec.model.bean.table;

public class tb_sys_group_member {
	private String id;
	private String group_id;
	private String person_id;
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getGroup_id() {
		return group_id;
	}



	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}



	public String getPerson_id() {
		return person_id;
	}



	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}



	public tb_sys_group_member(String id, String group_id, String person_id) {
		super();
		this.id = id;
		this.group_id = group_id;
		this.person_id = person_id;
	}



	public tb_sys_group_member() {
	}

}
