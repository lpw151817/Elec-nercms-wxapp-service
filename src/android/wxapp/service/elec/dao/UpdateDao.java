package android.wxapp.service.elec.dao;

import java.lang.reflect.Field;

import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract.Contacts.Data;
import android.renderscript.BaseObj;
import android.wxapp.service.elec.model.UpdateResponse;
import android.wxapp.service.elec.model.bean.UpdateData;
import android.wxapp.service.elec.model.bean.table.TB_SYS_ORG;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Person;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Role;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Role_person;
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

public class UpdateDao extends BaseDAO {

	protected UpdateDao(Context context) {
		super(context);
	}

	public boolean saveUpdate(String js) {
		UpdateResponse bean = gson.fromJson(js, UpdateResponse.class);
		for (UpdateData item : bean.getD()) {
			if (item.getTable().equals(TB_SYS_ORG.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveOrg(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(TB_SYS_Person.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveOrgPerson(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(TB_SYS_Role.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveRole(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(TB_SYS_Role_person.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveRolePerson(iterable_element))
						return false;
				}
			}

			if (item.getTable().equals(tb_sys_permission.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!savePerssion(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_sys_Log.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveLog(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_sys_dictionary.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveDic(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_sys_dictionary_data.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveDicData(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_task_info.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveTask(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_task_standard.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveStandard(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_task_evaluate.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveStandard(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_task_attachment.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveAtt(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_task_instructions.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveIns(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_task_instructions_receive.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveInsRec(iterable_element))
						return false;
				}
			}
			if (item.getTable().equals(tb_task_instructions_attachment.class.getSimpleName())) {
				for (Object iterable_element : item.getData()) {
					if (!saveInsAtt(iterable_element))
						return false;
				}
			}
		}
		return true;
	}

	public boolean saveOrg(Object bean) {
		if (!(bean instanceof TB_SYS_ORG))
			return false;
		// db = dbHelper.getWritableDatabase();
		// ContentValues values = new ContentValues();
		// values.put(DatabaseHelper.FIELD_ORG_ID, ((TB_SYS_ORG) bean).getId());
		// values.put(DatabaseHelper.FIELD_ORG_ORG_CODE, ((TB_SYS_ORG)
		// bean).getOrg_code());
		// values.put(DatabaseHelper.FIELD_ORG_ORG_NAME, ((TB_SYS_ORG)
		// bean).getOrg_name());
		// values.put(DatabaseHelper.FIELD_ORG_REMARK, ((TB_SYS_ORG)
		// bean).getRemark());
		// values.put(DatabaseHelper.FIELD_ORG_UPDATE_TIME, ((TB_SYS_ORG)
		// bean).getUpdate_time());
		// return db.insert(DatabaseHelper.TB_ORG, null, values) > 0;
		return saveBean(DatabaseHelper.TB_ORG, bean);
	}

	public boolean saveOrgPerson(Object bean) {
		if (!(bean instanceof TB_SYS_Person))
			return false;
		return saveBean(DatabaseHelper.TB_PERSON, bean);
	}

	public boolean saveRole(Object bean) {
		if (!(bean instanceof TB_SYS_Role))
			return false;
		return saveBean(DatabaseHelper.TB_ROLE, bean);
	}

	public boolean saveRolePerson(Object bean) {
		if (!(bean instanceof TB_SYS_Role_person))
			return false;
		return saveBean(DatabaseHelper.TB_ROLE_PERSON, bean);
	}

	public boolean savePerssion(Object bean) {
		if (!(bean instanceof tb_sys_permission))
			return false;
		return saveBean(DatabaseHelper.TB_PERMISSION, bean);
	}

	public boolean saveLog(Object bean) {
		if (!(bean instanceof tb_sys_Log))
			return false;
		return saveBean(DatabaseHelper.TB_LOG, bean);
	}

	public boolean saveDic(Object bean) {
		if (!(bean instanceof tb_sys_dictionary))
			return false;
		return saveBean(DatabaseHelper.TB_DICTIONARY, bean);
	}

	public boolean saveDicData(Object bean) {
		if (!(bean instanceof tb_sys_dictionary_data))
			return false;
		return saveBean(DatabaseHelper.TB_DIC_DATA, bean);
	}

	public boolean saveTask(Object bean) {
		if (!(bean instanceof tb_task_info))
			return false;
		return saveBean(DatabaseHelper.TB_TASK, bean);
	}

	public boolean saveStandard(Object bean) {
		if (!(bean instanceof tb_task_standard))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_STANDARD, bean);
	}

	public boolean saveEvaluate(Object bean) {
		if (!(bean instanceof tb_task_evaluate))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_EVALUATE, bean);
	}

	public boolean saveAtt(Object bean) {
		if (!(bean instanceof tb_task_attachment))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_ATTACHMENT, bean);
	}

	public boolean saveIns(Object bean) {
		if (!(bean instanceof tb_task_instructions))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_INSTRUCTIONS, bean);
	}

	public boolean saveInsRec(Object bean) {
		if (!(bean instanceof tb_task_instructions_receive))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_INSTRUCTIONS_RECEIVE, bean);
	}

	public boolean saveInsAtt(Object bean) {
		if (!(bean instanceof tb_task_instructions_attachment))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_INSTRUCTIONS_ATTACHMENT, bean);
	}

	private boolean saveBean(Object bean) {
		return saveBean(bean.getClass().getSimpleName(), bean);
	}

	/**
	 * 保存实体类
	 * 
	 * @param tableName
	 *            表名
	 * @param bean
	 *            bean中的属性名称需要与数据库中保持一致
	 * @return
	 */
	private boolean saveBean(String tableName, Object bean) {
		try {
			db = dbHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			Field[] fs = bean.getClass().getDeclaredFields();
			for (Field field : fs) {
				values.put(field.getName(), field.get(bean).toString());
			}
			return db.insert(tableName, null, values) > 0;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return false;
		}

	}

}
