package android.wxapp.service.elec.model.bean.table;

public class TB_SYS_Role_person {
	String person_id;
	String Role_id;
	
	
	
	public TB_SYS_Role_person(String person_id, String role_id) {
		super();
		this.person_id = person_id;
		Role_id = role_id;
	}
	
	
	public TB_SYS_Role_person() {
		super();
	}


	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getRole_id() {
		return Role_id;
	}
	public void setRole_id(String role_id) {
		Role_id = role_id;
	}
	
	
	
}
