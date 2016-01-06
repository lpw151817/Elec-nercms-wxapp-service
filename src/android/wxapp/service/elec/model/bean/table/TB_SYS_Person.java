package android.wxapp.service.elec.model.bean.table;

public class TB_SYS_Person {
	String id;
	String alias;
	String orgcode;
	String name;
	String identify_code;
	String remark;
	String imsi;
	String force_offline;
	String sequence;
	String update_time;

	@Override
	public String toString() {
		return "TB_SYS_Person [id=" + id + ", Org_code=" + orgcode + ", name=" + name + "]";
	}

	public TB_SYS_Person(String id, String alias, String orgcode, String name, String identify_code,
			String remark, String imsi, String force_offline, String sequence, String update_time) {
		super();
		this.id = id;
		this.alias = alias;
		this.orgcode = orgcode;
		this.name = name;
		this.identify_code = identify_code;
		this.remark = remark;
		this.imsi = imsi;
		this.force_offline = force_offline;
		this.sequence = sequence;
		this.update_time = update_time;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public TB_SYS_Person() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentify_code() {
		return identify_code;
	}

	public void setIdentify_code(String identify_code) {
		this.identify_code = identify_code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getForce_offline() {
		return force_offline;
	}

	public void setForce_offline(String force_offline) {
		this.force_offline = force_offline;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

}
