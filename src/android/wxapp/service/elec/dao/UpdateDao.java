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
import android.database.Cursor;
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
		return saveBean(DatabaseHelper.TB_ORG, bean);
	}

	public boolean deleteOrg(Object bean) {
		if (!(bean instanceof TB_SYS_ORG))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((TB_SYS_ORG) bean).getId());
		}
	}

	public boolean containsOrg(Object bean) {
		if (!(bean instanceof TB_SYS_ORG))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((TB_SYS_ORG) bean).getId());
		}
	}

	public boolean saveOrgPerson(Object bean) {
		if (!(bean instanceof TB_SYS_Person))
			return false;
		return saveBean(DatabaseHelper.TB_PERSON, bean);
	}

	public boolean deleteOrgPerson(Object bean) {
		if (!(bean instanceof TB_SYS_Person))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((TB_SYS_Person) bean).getId());
		}
	}

	public boolean containsOrgPerson(Object bean) {
		if (!(bean instanceof TB_SYS_Person))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((TB_SYS_Person) bean).getId());
		}
	}

	public boolean saveRole(Object bean) {
		if (!(bean instanceof TB_SYS_Role))
			return false;
		return saveBean(DatabaseHelper.TB_ROLE, bean);
	}

	public boolean deleteRole(Object bean) {
		if (!(bean instanceof TB_SYS_Role))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((TB_SYS_Role) bean).getId());
		}
	}

	public boolean containsRole(Object bean) {
		if (!(bean instanceof TB_SYS_Role))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((TB_SYS_Role) bean).getId());
		}
	}

	public boolean saveRolePerson(Object bean) {
		if (!(bean instanceof TB_SYS_Role_person))
			return false;
		return saveBean(DatabaseHelper.TB_ROLE_PERSON, bean);
	}

	public boolean deleteRolePerson(Object bean) {
		if (!(bean instanceof TB_SYS_Role_person))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(),
					((TB_SYS_Role_person) bean).getPerson_id());
		}
	}

	public boolean containsRolePerson(Object bean) {
		if (!(bean instanceof TB_SYS_Role_person))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((TB_SYS_Role_person) bean).getPerson_id());
		}
	}

	public boolean savePerssion(Object bean) {
		if (!(bean instanceof tb_sys_permission))
			return false;
		return saveBean(DatabaseHelper.TB_PERMISSION, bean);
	}

	public boolean deletePerssion(Object bean) {
		if (!(bean instanceof tb_sys_permission))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_sys_permission) bean).getId());
		}
	}

	public boolean containsPerssion(Object bean) {
		if (!(bean instanceof tb_sys_permission))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((tb_sys_permission) bean).getId());
		}
	}

	public boolean saveLog(Object bean) {
		if (!(bean instanceof tb_sys_Log))
			return false;
		return saveBean(DatabaseHelper.TB_LOG, bean);
	}

	public boolean deleteLog(Object bean) {
		if (!(bean instanceof tb_sys_Log))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_sys_Log) bean).getId());
		}
	}

	public boolean containsLog(Object bean) {
		if (!(bean instanceof tb_sys_Log))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((tb_sys_Log) bean).getId());
		}
	}

	public boolean saveDic(Object bean) {
		if (!(bean instanceof tb_sys_dictionary))
			return false;
		return saveBean(DatabaseHelper.TB_DICTIONARY, bean);
	}

	public boolean deleteDic(Object bean) {
		if (!(bean instanceof tb_sys_dictionary))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_sys_dictionary) bean).getId());
		}
	}

	public boolean containsDic(Object bean) {
		if (!(bean instanceof tb_sys_dictionary))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((tb_sys_dictionary) bean).getId());
		}
	}

	public boolean saveDicData(Object bean) {
		if (!(bean instanceof tb_sys_dictionary_data))
			return false;
		return saveBean(DatabaseHelper.TB_DIC_DATA, bean);
	}

	public boolean deleteDicData(Object bean) {
		if (!(bean instanceof tb_sys_dictionary_data))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(),
					((tb_sys_dictionary_data) bean).getId());
		}
	}

	public boolean containsDicData(Object bean) {
		if (!(bean instanceof tb_sys_dictionary_data))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((tb_sys_dictionary_data) bean).getId());
		}
	}

	public boolean saveTask(Object bean) {
		if (!(bean instanceof tb_task_info))
			return false;
		return saveBean(DatabaseHelper.TB_TASK, bean);
	}

	public boolean deleteTask(Object bean) {
		if (!(bean instanceof tb_task_info))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_task_info) bean).getId());
		}
	}

	public boolean containsTask(Object bean) {
		if (!(bean instanceof tb_task_info))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((tb_task_info) bean).getId());
		}
	}

	public boolean saveStandard(Object bean) {
		if (!(bean instanceof tb_task_standard))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_STANDARD, bean);
	}

	public boolean deleteStandard(Object bean) {
		if (!(bean instanceof tb_task_standard))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_task_standard) bean).getId());
		}
	}

	public boolean containsStandard(Object bean) {
		if (!(bean instanceof tb_task_standard))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((tb_task_standard) bean).getId());
		}
	}

	public boolean saveEvaluate(Object bean) {
		if (!(bean instanceof tb_task_evaluate))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_EVALUATE, bean);
	}

	public boolean deleteEvaluate(Object bean) {
		if (!(bean instanceof tb_task_evaluate))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_task_evaluate) bean).getId());
		}
	}

	public boolean containsEvaluate(Object bean) {
		if (!(bean instanceof tb_task_evaluate))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((tb_task_evaluate) bean).getId());
		}
	}

	public boolean saveAtt(Object bean) {
		if (!(bean instanceof tb_task_attachment))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_ATTACHMENT, bean);
	}

	public boolean deleteAtt(Object bean) {
		if (!(bean instanceof tb_task_attachment))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_task_attachment) bean).getId());
		}
	}

	public boolean containsAtt(Object bean) {
		if (!(bean instanceof tb_task_attachment))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((tb_task_attachment) bean).getId());
		}
	}

	public boolean saveIns(Object bean) {
		if (!(bean instanceof tb_task_instructions))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_INSTRUCTIONS, bean);
	}

	public boolean deleteIns(Object bean) {
		if (!(bean instanceof tb_task_instructions))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(),
					((tb_task_instructions) bean).getId());
		}
	}

	public boolean containsIns(Object bean) {
		if (!(bean instanceof tb_task_instructions))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((tb_task_instructions) bean).getId());
		}
	}

	public boolean saveInsRec(Object bean) {
		if (!(bean instanceof tb_task_instructions_receive))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_INSTRUCTIONS_RECEIVE, bean);
	}

	public boolean deleteInsRec(Object bean) {
		if (!(bean instanceof tb_task_instructions_receive))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(),
					((tb_task_instructions_receive) bean).getId());
		}
	}

	public boolean containsInsRec(Object bean) {
		if (!(bean instanceof tb_task_instructions_receive))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((tb_task_instructions_receive) bean).getId());
		}
	}

	public boolean saveInsAtt(Object bean) {
		if (!(bean instanceof tb_task_instructions_attachment))
			return false;
		return saveBean(DatabaseHelper.TB_TASK_INSTRUCTIONS_ATTACHMENT, bean);
	}

	public boolean deleteInsAtt(Object bean) {
		if (!(bean instanceof tb_task_instructions_attachment))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(),
					((tb_task_instructions_attachment) bean).getId());
		}
	}

	public boolean containsInsAtt(Object bean) {
		if (!(bean instanceof tb_task_instructions_attachment))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(),
					((tb_task_instructions_attachment) bean).getId());
		}
	}

	public boolean saveGpsHistory(Object bean) {
		if (!(bean instanceof tb_gps_history))
			return false;
		return saveBean(DatabaseHelper.TB_GPS_HISTORY, bean);
	}

	public boolean deleteGpsHistory(Object bean) {
		if (!(bean instanceof tb_gps_history))
			return false;
		else {
			return deleteBean(bean.getClass().getSimpleName(), ((tb_gps_history) bean).getId());
		}
	}

	public boolean containsGpsHistory(Object bean) {
		if (!(bean instanceof tb_gps_history))
			return false;
		else {
			return containsBean(bean.getClass().getSimpleName(), ((tb_gps_history) bean).getId());
		}
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
			if (bean instanceof tb_task_info) {
				if (containsTask(bean))
					deleteTask(bean);
			} else if (bean instanceof tb_task_instructions) {
				if (containsIns(bean))
					deleteIns(bean);
			} else if (bean instanceof TB_SYS_Role) {
				if (containsRole(bean))
					deleteRole(bean);
			} else if (bean instanceof TB_SYS_Person) {
				if (containsOrgPerson(bean))
					deleteOrgPerson(bean);
			} else if (bean instanceof TB_SYS_ORG) {
				if (containsOrg(bean))
					deleteOrg(bean);
			} else if (bean instanceof tb_gps_history) {
				if (containsGpsHistory(bean))
					deleteGpsHistory(bean);
			} else if (bean instanceof tb_task_attachment) {
				if (containsAtt(bean))
					deleteAtt(bean);
			} else if (bean instanceof tb_task_instructions_attachment) {
				if (containsInsAtt(bean))
					deleteInsAtt(bean);
			}

			db = dbHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			Field[] fs = bean.getClass().getDeclaredFields();
			for (Field field : fs) {
				values.put(field.getName(), getFieldValueByName(field.getName(), bean));
			}

			return db.insert(tableName, null, values) > 0;

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			// 如果报错了就删除对应项再添加进来
			if (bean instanceof TB_SYS_ORG) {
				deleteOrg(bean);
			} else if (bean instanceof TB_SYS_Person) {
				deleteOrgPerson(bean);
			} else if (bean instanceof TB_SYS_Role) {
				deleteRole(bean);
			} else if (bean instanceof TB_SYS_Role_person) {
				deleteRolePerson(bean);
			} else if (bean instanceof tb_sys_permission) {
				deletePerssion(bean);
			} else if (bean instanceof tb_sys_dictionary) {
				deleteDic(bean);
			} else if (bean instanceof tb_sys_dictionary_data) {
				deleteDicData(bean);
			} else if (bean instanceof tb_task_info) {
				deleteTask(bean);
			} else if (bean instanceof tb_task_standard) {
				deleteStandard(bean);
			} else if (bean instanceof tb_task_evaluate) {
				deleteEvaluate(bean);
			} else if (bean instanceof tb_task_attachment) {
				deleteAtt(bean);
			} else if (bean instanceof tb_task_instructions) {
				deleteIns(bean);
			} else if (bean instanceof tb_task_instructions_receive) {
				deleteInsRec(bean);
			} else if (bean instanceof tb_task_instructions_attachment) {
				deleteInsAtt(bean);
			} else if (bean instanceof tb_gps_history) {
				deleteGpsHistory(bean);
			}
			return saveOrg(bean);
		} finally {
			//db.close();
		}
	}

	private boolean deleteBean(String tableName, String id) {
		db = dbHelper.getWritableDatabase();
		try {
			return db.delete(tableName, "id = ?", new String[] { id }) > 0;
		} finally {
			//db.close();
		}
	}

	private boolean containsBean(String tableName, String id) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(tableName, null, "id = ?", new String[] { id }, null, null, null);
		try {
			return c.getCount() > 0;
		} finally {
			c.close();
			//db.close();
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
