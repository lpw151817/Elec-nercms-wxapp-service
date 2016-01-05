package android.wxapp.service.elec.model.bean.table;

public class tb_task_instructions_receive {
	String id;
	String instrucions_id;
	String receive_id;
	String receive_time;
	@Override
	public String toString() {
		return "tb_task_instructions_receive [id=" + id + ", instrucions_id=" + instrucions_id
				+ ", receive_id=" + receive_id + ", receive_time=" + receive_time + ", is_read="
				+ is_read + "]";
	}

	String is_read;

	public tb_task_instructions_receive(String id, String instrucions_id, String receive_id,
			String receive_time, String is_read) {
		super();
		this.id = id;
		this.instrucions_id = instrucions_id;
		this.receive_id = receive_id;
		this.receive_time = receive_time;
		this.is_read = is_read;
	}

	public tb_task_instructions_receive() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstrucions_id() {
		return instrucions_id;
	}

	public void setInstrucions_id(String instrucions_id) {
		this.instrucions_id = instrucions_id;
	}

	public String getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}

	public String getReceive_time() {
		return receive_time;
	}

	public void setReceive_time(String receive_time) {
		this.receive_time = receive_time;
	}

	public String getIs_read() {
		return is_read;
	}

	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}

}
