package android.wxapp.service.elec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.wxapp.service.elec.model.bean.table.tb_task_info;

public class PlanTaskDao extends BaseDAO {

	protected PlanTaskDao(Context context) {
		super(context);
	}

	/**
	 * 
	 * @param id
	 *            must
	 * @param weather
	 * @param name
	 * @param power_cut_range
	 * @param effect_eara
	 * @param content
	 * @param responsibility_user
	 * @param plan_start_time
	 * @param plan_end_time
	 * @param start_time
	 * @param end_time
	 * @param category
	 * @param is_publish
	 * @param special
	 * @param leader
	 * @param measures
	 * @param domain
	 * @param is_power_cut
	 * @param cut_type
	 * @param implement_org
	 * @param number
	 * @param remark
	 * @param plan_type
	 * @param creator_id
	 * @param creator_time
	 * @param update_id
	 * @param update_time
	 * @param is_keep
	 * @param status
	 * @param examine_id
	 * @param approve_id
	 * @return
	 */
	public boolean updatePlanTask(String id, String weather, String name, String power_cut_range,
			String effect_eara, String content, String responsibility_user, String plan_start_time,
			String plan_end_time, String start_time, String end_time, String category,
			String is_publish, String special, String leader, String measures, String domain,
			String is_power_cut, String cut_type, String implement_org, String number,
			String remark, String plan_type, String creator_id, String creator_time,
			String update_id, String update_time, String is_keep, String status, String examine_id,
			String approve_id) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		if (weather != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_WEATHER, weather);
		if (name != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_NAME, name);
		if (power_cut_range != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_POWER_CUT_RANGE, power_cut_range);
		if (effect_eara != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_EFFECT_EARA, effect_eara);
		if (content != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_CONTENT, content);
		if (responsibility_user != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_RESPONSIBILITY_USER, responsibility_user);
		if (plan_start_time != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_START_TIME, plan_start_time);
		if (plan_end_time != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_END_TIME, plan_end_time);
		if (start_time != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_START_TIME, start_time);
		if (end_time != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_END_TIME, end_time);
		if (category != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_CATEGORY, category);
		if (is_publish != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_IS_PUBLISH, is_publish);
		if (special != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_SPECIAL, special);
		if (leader != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_LEADER, leader);
		if (measures != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_MEASURES, measures);
		if (domain != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_DOMAIN, domain);
		if (is_power_cut != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_IS_POWER_CUT, is_power_cut);
		if (cut_type != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_CUT_TYPE, cut_type);
		if (implement_org != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_IMPLEMENT_ORG, implement_org);
		if (number != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_NUMBER, number);
		if (remark != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_REMARK, remark);
		if (plan_type != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_TYPE, plan_type);
		if (creator_id != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_CREATOR_ID, creator_id);
		if (creator_time != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_CREATOR_TIME, creator_time);
		if (update_id != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_UPDATE_ID, update_id);
		if (update_time != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_UPDATE_TIME, update_time);
		if (is_keep != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_IS_KEEP, is_keep);
		if (status != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_STATUS, status);
		if (examine_id != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_EXAMINE_ID, examine_id);
		if (approve_id != null)
			values.put(DatabaseHelper.FIELD_TASKINFO_APPROVE_ID, approve_id);
		return db.update(DatabaseHelper.TB_TASK, values, DatabaseHelper.FIELD_TASKINFO_ID + " = ?",
				new String[] { id }) > 0;
	}

	public boolean savePlanTask(String id, String weather, String name, String power_cut_range,
			String effect_eara, String content, String responsibility_user, String plan_start_time,
			String plan_end_time, String start_time, String end_time, String category,
			String is_publish, String special, String leader, String measures, String domain,
			String is_power_cut, String cut_type, String implement_org, String number,
			String remark, String plan_type, String creator_id, String creator_time,
			String update_id, String update_time, String is_keep, String status, String examine_id,
			String approve_id) {
		db = dbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.FIELD_TASKINFO_ID, id);
		values.put(DatabaseHelper.FIELD_TASKINFO_WEATHER, weather);
		values.put(DatabaseHelper.FIELD_TASKINFO_NAME, name);
		values.put(DatabaseHelper.FIELD_TASKINFO_POWER_CUT_RANGE, power_cut_range);
		values.put(DatabaseHelper.FIELD_TASKINFO_EFFECT_EARA, effect_eara);
		values.put(DatabaseHelper.FIELD_TASKINFO_CONTENT, content);
		values.put(DatabaseHelper.FIELD_TASKINFO_RESPONSIBILITY_USER, responsibility_user);
		values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_START_TIME, plan_start_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_END_TIME, plan_end_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_START_TIME, start_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_END_TIME, end_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_CATEGORY, category);
		values.put(DatabaseHelper.FIELD_TASKINFO_IS_PUBLISH, is_publish);
		values.put(DatabaseHelper.FIELD_TASKINFO_SPECIAL, special);
		values.put(DatabaseHelper.FIELD_TASKINFO_LEADER, leader);
		values.put(DatabaseHelper.FIELD_TASKINFO_MEASURES, measures);
		values.put(DatabaseHelper.FIELD_TASKINFO_DOMAIN, domain);
		values.put(DatabaseHelper.FIELD_TASKINFO_IS_POWER_CUT, is_power_cut);
		values.put(DatabaseHelper.FIELD_TASKINFO_CUT_TYPE, cut_type);
		values.put(DatabaseHelper.FIELD_TASKINFO_IMPLEMENT_ORG, implement_org);
		values.put(DatabaseHelper.FIELD_TASKINFO_NUMBER, number);
		values.put(DatabaseHelper.FIELD_TASKINFO_REMARK, remark);
		values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_TYPE, plan_type);
		values.put(DatabaseHelper.FIELD_TASKINFO_CREATOR_ID, creator_id);
		values.put(DatabaseHelper.FIELD_TASKINFO_CREATOR_TIME, creator_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_UPDATE_ID, update_id);
		values.put(DatabaseHelper.FIELD_TASKINFO_UPDATE_TIME, update_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_IS_KEEP, is_keep);
		values.put(DatabaseHelper.FIELD_TASKINFO_STATUS, status);
		values.put(DatabaseHelper.FIELD_TASKINFO_EXAMINE_ID, examine_id);
		values.put(DatabaseHelper.FIELD_TASKINFO_APPROVE_ID, approve_id);

		return db.insert(DatabaseHelper.TB_TASK, null, values) > 0;
	}

	public tb_task_info getPlanTask(String id) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK, null, DatabaseHelper.FIELD_TASKINFO_ID + " = ?",
				new String[] { id }, null, null, null);
		tb_task_info info = null;
		if (c.moveToFirst()) {
			info = new tb_task_info(getData(c, DatabaseHelper.FIELD_TASKINFO_ID),
					getData(c, DatabaseHelper.FIELD_TASKINFO_WEATHER),
					getData(c, DatabaseHelper.FIELD_TASKINFO_NAME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_POWER_CUT_RANGE),
					getData(c, DatabaseHelper.FIELD_TASKINFO_EFFECT_EARA),
					getData(c, DatabaseHelper.FIELD_TASKINFO_CONTENT),
					getData(c, DatabaseHelper.FIELD_TASKINFO_RESPONSIBILITY_USER),
					getData(c, DatabaseHelper.FIELD_TASKINFO_PLAN_START_TIME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_PLAN_END_TIME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_START_TIME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_END_TIME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_CATEGORY),
					getData(c, DatabaseHelper.FIELD_TASKINFO_IS_PUBLISH),
					getData(c, DatabaseHelper.FIELD_TASKINFO_SPECIAL),
					getData(c, DatabaseHelper.FIELD_TASKINFO_LEADER),
					getData(c, DatabaseHelper.FIELD_TASKINFO_MEASURES),
					getData(c, DatabaseHelper.FIELD_TASKINFO_DOMAIN),
					getData(c, DatabaseHelper.FIELD_TASKINFO_IS_POWER_CUT),
					getData(c, DatabaseHelper.FIELD_TASKINFO_CUT_TYPE),
					getData(c, DatabaseHelper.FIELD_TASKINFO_IMPLEMENT_ORG),
					getData(c, DatabaseHelper.FIELD_TASKINFO_NUMBER),
					getData(c, DatabaseHelper.FIELD_TASKINFO_REMARK),
					getData(c, DatabaseHelper.FIELD_TASKINFO_PLAN_TYPE),
					getData(c, DatabaseHelper.FIELD_TASKINFO_CREATOR_ID),
					getData(c, DatabaseHelper.FIELD_TASKINFO_CREATOR_TIME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_UPDATE_ID),
					getData(c, DatabaseHelper.FIELD_TASKINFO_UPDATE_TIME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_IS_KEEP),
					getData(c, DatabaseHelper.FIELD_TASKINFO_STATUS),
					getData(c, DatabaseHelper.FIELD_TASKINFO_EXAMINE_ID),
					getData(c, DatabaseHelper.FIELD_TASKINFO_APPROVE_ID));
		}
		c.close();
		return info;
	}
}
