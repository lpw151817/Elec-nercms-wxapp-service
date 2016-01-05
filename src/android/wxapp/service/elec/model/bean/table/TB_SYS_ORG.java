package android.wxapp.service.elec.model.bean.table;

public class TB_SYS_ORG {
	String id;
	String org_code;
	String description;
	String remark;
	String update_time;

	@Override
	public String toString() {
		return "TB_SYS_ORG [id=" + id + ", description=" + description + "]";
	}

	public TB_SYS_ORG(String id, String org_code, String description, String remark,
			String update_time) {
		super();
		this.id = id;
		this.org_code = org_code;
		this.description = description;
		this.remark = remark;
		this.update_time = update_time;
	}

	public TB_SYS_ORG() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
