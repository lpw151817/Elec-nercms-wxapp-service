package android.wxapp.service.elec.model.bean;

import java.util.List;

import android.wxapp.service.elec.model.bean.table.TB_SYS_ORG;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Person;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Role;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Role_person;
import android.wxapp.service.elec.model.bean.table.tb_gps_history;
import android.wxapp.service.elec.model.bean.table.tb_gps_realtime;
import android.wxapp.service.elec.model.bean.table.tb_sys_Log;
import android.wxapp.service.elec.model.bean.table.tb_sys_dictionary;
import android.wxapp.service.elec.model.bean.table.tb_sys_dictionary_data;
import android.wxapp.service.elec.model.bean.table.tb_sys_permission;
import android.wxapp.service.elec.model.bean.table.tb_task_attachment;
import android.wxapp.service.elec.model.bean.table.tb_task_evaluate;
import android.wxapp.service.elec.model.bean.table.tb_task_info;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions_attachment;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions_receive;
import android.wxapp.service.elec.model.bean.table.tb_task_standard;
import android.wxapp.service.elec.model.bean.table.tb_video_Person;
import android.wxapp.service.elec.model.bean.table.tb_video_dispatch;

public class TableData {
	List<Object> obj;

	public TableData(List<Object> obj) {
		super();
		this.obj = obj;
	}

	public TableData() {
		obj.add(new tb_gps_history());
		obj.add(new tb_gps_realtime());
		obj.add(new tb_sys_dictionary());
		obj.add(new tb_sys_dictionary_data());
		obj.add(new tb_sys_Log());
		obj.add(new TB_SYS_ORG());
		obj.add(new tb_sys_permission());
		obj.add(new TB_SYS_Person());
		obj.add(new TB_SYS_Role());
		obj.add(new TB_SYS_Role_person());
		obj.add(new tb_task_attachment());
		obj.add(new tb_task_evaluate());
		obj.add(new tb_task_info());
		obj.add(new tb_task_instructions());
		obj.add(new tb_task_instructions_attachment());
		obj.add(new tb_task_instructions_receive());
		obj.add(new tb_task_standard());
		obj.add(new tb_video_dispatch());
		obj.add(new tb_video_Person());
		
		
	}
	
	
	
	
}
