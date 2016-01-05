package android.wxapp.service.elec.model.bean.table;

public class tb_task_standard {
	String id;
	String standard;
	String total_score;
	@Override
	public String toString() {
		return "tb_task_standard [id=" + id + ", standard=" + standard + ", total_score="
				+ total_score + ", category=" + category + "]";
	}
	String category;
	public tb_task_standard(String id, String standard, String total_score,
			String category) {
		super();
		this.id = id;
		this.standard = standard;
		this.total_score = total_score;
		this.category = category;
	}
	public tb_task_standard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getTotal_score() {
		return total_score;
	}
	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
