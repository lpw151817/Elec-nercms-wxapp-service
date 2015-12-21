package android.wxapp.service.elec.model.bean.table;

public class tb_task_evaluate {
	String id;
	String task_id;
	String standard_id;
	String score;
	String evaluate;
	String user_id;
	String time;
	public tb_task_evaluate(String id, String task_id, String standard_id,
			String score, String evaluate, String user_id, String time) {
		super();
		this.id = id;
		this.task_id = task_id;
		this.standard_id = standard_id;
		this.score = score;
		this.evaluate = evaluate;
		this.user_id = user_id;
		this.time = time;
	}
	public tb_task_evaluate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(String standard_id) {
		this.standard_id = standard_id;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
