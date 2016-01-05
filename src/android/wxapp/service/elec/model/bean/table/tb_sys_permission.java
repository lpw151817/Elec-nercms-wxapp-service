package android.wxapp.service.elec.model.bean.table;

public class tb_sys_permission {
	String id;
	String Menu_code;
	String code;
	String name;
	String Role_id;
	@Override
	public String toString() {
		return "tb_sys_permission [id=" + id + ", Menu_code=" + Menu_code + ", code=" + code
				+ ", name=" + name + ", Role_id=" + Role_id + "]";
	}
	public tb_sys_permission(String id, String menu_code, String code,
			String name, String role_id) {
		super();
		this.id = id;
		Menu_code = menu_code;
		this.code = code;
		this.name = name;
		Role_id = role_id;
	}
	public tb_sys_permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenu_code() {
		return Menu_code;
	}
	public void setMenu_code(String menu_code) {
		Menu_code = menu_code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole_id() {
		return Role_id;
	}
	public void setRole_id(String role_id) {
		Role_id = role_id;
	}
	
	
	
}
