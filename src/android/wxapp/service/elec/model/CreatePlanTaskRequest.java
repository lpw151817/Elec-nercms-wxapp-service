package android.wxapp.service.elec.model;

import java.util.ArrayList;
import java.util.List;

import android.wxapp.service.elec.model.bean.Leader;
import android.wxapp.service.elec.model.bean.User;

public class CreatePlanTaskRequest extends BaseRequestModel {

	String weather;
	String name;
	String power_cut_range;
	String effect_eara;
	String content;

	List<User> responsibility_user;



	String plan_start_time;
	String plan_end_time;
	String category;
	String is_publish;
	String special;

	ArrayList<Leader> leader;



	String measures;
	String domain;
	String is_power_cut;
	String cut_type;
	String implement_org;
	String number;
	String remark;

	public CreatePlanTaskRequest(String uid, String ic, String weather,
			String name, String power_cut_range, String effect_eara,
			String content, ArrayList<User> responsibility_user,
			String plan_start_time, String plan_end_time, String category,
			String is_publish, String special, ArrayList<Leader> leader,
			String measures, String domain, String is_power_cut,
			String cut_type, String implement_org, String number, String remark) {
		super(uid, ic);
		this.weather = weather;
		this.name = name;
		this.power_cut_range = power_cut_range;
		this.effect_eara = effect_eara;
		this.content = content;
		this.responsibility_user = responsibility_user;
		this.plan_start_time = plan_start_time;
		this.plan_end_time = plan_end_time;
		this.category = category;
		this.is_publish = is_publish;
		this.special = special;
		this.leader = leader;
		this.measures = measures;
		this.domain = domain;
		this.is_power_cut = is_power_cut;
		this.cut_type = cut_type;
		this.implement_org = implement_org;
		this.number = number;
		this.remark = remark;
	}

	public CreatePlanTaskRequest() {
		super();
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPower_cut_range() {
		return power_cut_range;
	}

	public void setPower_cut_range(String power_cut_range) {
		this.power_cut_range = power_cut_range;
	}

	public String getEffect_eara() {
		return effect_eara;
	}

	public void setEffect_eara(String effect_eara) {
		this.effect_eara = effect_eara;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<User> getResponsibility_user() {
		return responsibility_user;
	}

	public void setResponsibility_user(List<User> responsibility_user) {
		this.responsibility_user = responsibility_user;
	}

	public String getPlan_start_time() {
		return plan_start_time;
	}

	public void setPlan_start_time(String plan_start_time) {
		this.plan_start_time = plan_start_time;
	}

	public String getPlan_end_time() {
		return plan_end_time;
	}

	public void setPlan_end_time(String plan_end_time) {
		this.plan_end_time = plan_end_time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIs_publish() {
		return is_publish;
	}

	public void setIs_publish(String is_publish) {
		this.is_publish = is_publish;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public ArrayList<Leader> getLeader() {
		return leader;
	}

	public void setLeader(ArrayList<Leader> leader) {
		this.leader = leader;
	}

	public String getMeasures() {
		return measures;
	}

	public void setMeasures(String measures) {
		this.measures = measures;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIs_power_cut() {
		return is_power_cut;
	}

	public void setIs_power_cut(String is_power_cut) {
		this.is_power_cut = is_power_cut;
	}

	public String getCut_type() {
		return cut_type;
	}

	public void setCut_type(String cut_type) {
		this.cut_type = cut_type;
	}

	public String getImplement_org() {
		return implement_org;
	}

	public void setImplement_org(String implement_org) {
		this.implement_org = implement_org;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
