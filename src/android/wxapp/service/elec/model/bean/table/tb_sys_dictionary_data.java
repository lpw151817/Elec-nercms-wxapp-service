package android.wxapp.service.elec.model.bean.table;

public class tb_sys_dictionary_data {
	String id;
	String data_code;
	String data_value;
	String dictionary_code;
	public tb_sys_dictionary_data(String id, String data_code,
			String data_value, String dictionary_code) {
		super();
		this.id = id;
		this.data_code = data_code;
		this.data_value = data_value;
		this.dictionary_code = dictionary_code;
	}
	public tb_sys_dictionary_data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData_code() {
		return data_code;
	}
	public void setData_code(String data_code) {
		this.data_code = data_code;
	}
	public String getData_value() {
		return data_value;
	}
	public void setData_value(String data_value) {
		this.data_value = data_value;
	}
	public String getDictionary_code() {
		return dictionary_code;
	}
	public void setDictionary_code(String dictionary_code) {
		this.dictionary_code = dictionary_code;
	}
	
	
}
