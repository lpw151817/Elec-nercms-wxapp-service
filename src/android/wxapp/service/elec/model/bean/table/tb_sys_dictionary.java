package android.wxapp.service.elec.model.bean.table;

public class tb_sys_dictionary {
	String id;
	String dictionary_code;
	String dictionary_name;
	@Override
	public String toString() {
		return "tb_sys_dictionary [id=" + id + ", dictionary_code=" + dictionary_code
				+ ", dictionary_name=" + dictionary_name + "]";
	}
	public tb_sys_dictionary(String id, String dictionary_code,
			String dictionary_name) {
		super();
		this.id = id;
		this.dictionary_code = dictionary_code;
		this.dictionary_name = dictionary_name;
	}
	public tb_sys_dictionary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDictionary_code() {
		return dictionary_code;
	}
	public void setDictionary_code(String dictionary_code) {
		this.dictionary_code = dictionary_code;
	}
	public String getDictionary_name() {
		return dictionary_name;
	}
	public void setDictionary_name(String dictionary_name) {
		this.dictionary_name = dictionary_name;
	}
	
	
}
