package android.wxapp.service.elec.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.reflect.TypeToken;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.wxapp.service.elec.model.bean.table.TB_SYS_ORG;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Person;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Role;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Role_person;
import android.wxapp.service.elec.model.bean.table.tb_gps_history;
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

	public UpdateDao(Context context) {
		super(context);
	}

	public boolean saveUpdate(JSONObject js) {

		try {
			JSONArray d = js.getJSONArray("d");
			for (int i = 0; i < d.length(); i++) {
				JSONObject subJs = (JSONObject) d.get(i);
				String tableName = subJs.getString("table");
				Log.v("update>>>>>>>>>", tableName);
				if (tableName.toLowerCase()
						.equals(TB_SYS_ORG.class.getSimpleName().toLowerCase())) {
					List<TB_SYS_ORG> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<TB_SYS_ORG>>() {
							}.getType());
					for (TB_SYS_ORG item : r) {
						if (!saveOrg(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(TB_SYS_Person.class.getSimpleName().toLowerCase())) {
					List<TB_SYS_Person> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<TB_SYS_Person>>() {
							}.getType());
					for (TB_SYS_Person item : r) {
						if (!saveOrgPerson(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(TB_SYS_Role.class.getSimpleName().toLowerCase())) {
					List<TB_SYS_Role> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<TB_SYS_Role>>() {
							}.getType());
					for (TB_SYS_Role item : r) {
						if (!saveRole(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(TB_SYS_Role_person.class.getSimpleName().toLowerCase())) {
					List<TB_SYS_Role_person> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<TB_SYS_Role_person>>() {
							}.getType());
					for (TB_SYS_Role_person item : r) {
						if (!saveRolePerson(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_sys_permission.class.getSimpleName().toLowerCase())) {
					List<tb_sys_permission> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_sys_permission>>() {
							}.getType());
					for (tb_sys_permission item : r) {
						if (!savePerssion(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_sys_Log.class.getSimpleName().toLowerCase())) {
					List<tb_sys_Log> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_sys_Log>>() {
							}.getType());
					for (tb_sys_Log item : r) {
						if (!saveLog(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_sys_dictionary.class.getSimpleName().toLowerCase())) {
					List<tb_sys_dictionary> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_sys_dictionary>>() {
							}.getType());
					for (tb_sys_dictionary item : r) {
						if (!saveDic(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_sys_dictionary_data.class.getSimpleName().toLowerCase())) {
					List<tb_sys_dictionary_data> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_sys_dictionary_data>>() {
							}.getType());
					for (tb_sys_dictionary_data item : r) {
						if (!saveDicData(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_task_info.class.getSimpleName().toLowerCase())) {
					List<tb_task_info> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_task_info>>() {
							}.getType());
					for (tb_task_info item : r) {
						if (!saveTask(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_task_standard.class.getSimpleName().toLowerCase())) {
					List<tb_task_standard> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_task_standard>>() {
							}.getType());
					for (tb_task_standard item : r) {
						if (!saveStandard(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_task_evaluate.class.getSimpleName().toLowerCase())) {
					List<tb_task_evaluate> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_task_evaluate>>() {
							}.getType());
					for (tb_task_evaluate item : r) {
						if (!saveEvaluate(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_task_attachment.class.getSimpleName().toLowerCase())) {
					List<tb_task_attachment> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_task_attachment>>() {
							}.getType());
					for (tb_task_attachment item : r) {
						if (!saveAtt(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_task_instructions.class.getSimpleName().toLowerCase())) {
					List<tb_task_instructions> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_task_instructions>>() {
							}.getType());
					for (tb_task_instructions item : r) {
						if (!saveIns(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_task_instructions_receive.class.getSimpleName().toLowerCase())) {
					List<tb_task_instructions_receive> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_task_instructions_receive>>() {
							}.getType());
					for (tb_task_instructions_receive item : r) {
						if (!saveInsRec(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase().equals(
						tb_task_instructions_attachment.class.getSimpleName().toLowerCase())) {
					List<tb_task_instructions_attachment> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_task_instructions_attachment>>() {
							}.getType());
					for (tb_task_instructions_attachment item : r) {
						if (!saveInsAtt(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				} else if (tableName.toLowerCase()
						.equals(tb_gps_history.class.getSimpleName().toLowerCase())) {
					List<tb_gps_history> r = gson.fromJson(subJs.getString("data"),
							new TypeToken<List<tb_gps_history>>() {
							}.getType());
					for (tb_gps_history item : r) {
						if (!saveGpsHistory(item)) {
							Log.e("update>>>>>>>>>", "error>>>>>>" + item);
							return false;
						}
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
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

	public boolean saveGpsHistory(Object bean) {
		if (!(bean instanceof tb_gps_history))
			return false;
		return saveBean(DatabaseHelper.TB_GPS_HISTORY, bean);
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
				values.put(field.getName(), getFieldValueByName(field.getName(), bean));
			}
			return db.insert(tableName, null, values) > 0;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 根据属性名获取属性值
	 */
	private String getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
