package android.wxapp.service.elec.model.bean.table;

public class TB_SYS_Role {

	String id;
	String role_name;
	String remark;
	String update_time;

	@Override
	public String toString() {
		return "TB_SYS_Role [id=" + id + ", role_name=" + role_name + "]";
	}

	public TB_SYS_Role(String id, String role_name, String remark, String update_time) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.remark = remark;
		this.update_time = update_time;
	}

	public TB_SYS_Role() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

}
