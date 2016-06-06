package android.wxapp.service.elec.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.conn.BasicEofSensorWatcher;

import com.imooc.treeview.utils.Node;

import android.R.array;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.Contacts.Data;
import android.text.TextUtils;
import android.util.Log;
import android.wxapp.service.elec.model.StartTaskRequest;
import android.wxapp.service.elec.model.UploadTaskAttachmentResponse;
import android.wxapp.service.elec.model.bean.table.tb_gps_history;
import android.wxapp.service.elec.model.bean.table.tb_task_attachment;
import android.wxapp.service.elec.model.bean.table.tb_task_info;
import android.wxapp.service.util.Utils;

public class PlanTaskDao extends BaseDAO {

	public int getLastDixian(String tid) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from " + DatabaseHelper.TB_TASK_ATTACHMENT + " where "
				+ DatabaseHelper.FIELD_TASK_ATTCHMENT_TASK_ID + " = " + tid + " and "
				+ DatabaseHelper.FIELD_TASK_ATTACHMENT_DIXIAN + "is not null order by "
				+ DatabaseHelper.FIELD_TASK_ATTACHMENT_DIXIAN + " desc", null);
		if (c.moveToFirst())
			return c.getInt(c.getColumnIndex(DatabaseHelper.FIELD_TASK_ATTACHMENT_DIXIAN));
		else
			return 0;
	}

	public String taskLeibieInt2String(int i) {
		return "category0" + i;
	}

	public int taskLeibieString2Int(String s) {
		return Integer.parseInt(s.substring(s.length() - 1));
	}

	public PlanTaskDao(Context context) {
		super(context);
	}

	public boolean deleteTask(String tid) {
		db = dbHelper.getWritableDatabase();
		try {
			return db.delete(DatabaseHelper.TB_TASK, DatabaseHelper.FIELD_TASKINFO_ID + " = ?",
					new String[] { tid }) > 0;
		} finally {
			// db.close();
		}
	}

	public boolean changeTaskTime(boolean isStart, String tid, String time) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		if (isStart) {
			values.put(DatabaseHelper.FIELD_TASKINFO_START_TIME, time);
		} else {
			values.put(DatabaseHelper.FIELD_TASKINFO_END_TIME, time);
		}
		try {
			return db.update(DatabaseHelper.TB_TASK, values,
					DatabaseHelper.FIELD_TASKINFO_ID + " = ?", new String[] { tid }) > 0;
		} finally {
			// db.close();
		}
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
		try {
			return db.update(DatabaseHelper.TB_TASK, values,
					DatabaseHelper.FIELD_TASKINFO_ID + " = ?", new String[] { id }) > 0;
		} finally {
			// db.close();
		}
	}

	public boolean savePlanTask(String id, String weather, String name, String power_cut_range,
			String effect_eara, String content, List<Node> responsibility_user,
			String plan_start_time, String plan_end_time, String start_time, String end_time,
			String category, String is_publish, String special, List<Node> leader, String measures,
			String domain, String is_power_cut, String cut_type, String implement_org,
			String number, String remark, String plan_type, String creator_id, String creator_time,
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
		OrgDao orgDao = new OrgDao(c);
		// 暂时只存第一个
		values.put(DatabaseHelper.FIELD_TASKINFO_RESPONSIBILITY_USER,
				responsibility_user.get(0).getId().substring(1));
		values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_START_TIME, (plan_start_time));
		values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_END_TIME, (plan_end_time));
		if (!TextUtils.isEmpty(start_time))
			values.put(DatabaseHelper.FIELD_TASKINFO_START_TIME, start_time);
		if (!TextUtils.isEmpty(end_time))
			values.put(DatabaseHelper.FIELD_TASKINFO_END_TIME, end_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_CATEGORY, category);
		if (is_publish.equals("false"))
			values.put(DatabaseHelper.FIELD_TASKINFO_IS_PUBLISH, "0");
		else
			values.put(DatabaseHelper.FIELD_TASKINFO_IS_PUBLISH, "1");
		if (special.equals("有"))
			values.put(DatabaseHelper.FIELD_TASKINFO_SPECIAL, "1");
		else
			values.put(DatabaseHelper.FIELD_TASKINFO_SPECIAL, "0");
		// 暂时只存第一个
		if (leader != null && leader.size() > 0)
			values.put(DatabaseHelper.FIELD_TASKINFO_LEADER, leader.get(0).getId().substring(1));
		else
			values.put(DatabaseHelper.FIELD_TASKINFO_LEADER, "");
		values.put(DatabaseHelper.FIELD_TASKINFO_MEASURES, measures);
		values.put(DatabaseHelper.FIELD_TASKINFO_DOMAIN, domain);
		if (is_power_cut.equals("false"))
			values.put(DatabaseHelper.FIELD_TASKINFO_IS_POWER_CUT, "0");
		else
			values.put(DatabaseHelper.FIELD_TASKINFO_IS_POWER_CUT, "1");
		values.put(DatabaseHelper.FIELD_TASKINFO_CUT_TYPE, cut_type);
		values.put(DatabaseHelper.FIELD_TASKINFO_IMPLEMENT_ORG, implement_org);
		values.put(DatabaseHelper.FIELD_TASKINFO_NUMBER, number);
		values.put(DatabaseHelper.FIELD_TASKINFO_REMARK, remark);
		values.put(DatabaseHelper.FIELD_TASKINFO_PLAN_TYPE, "3");
		values.put(DatabaseHelper.FIELD_TASKINFO_CREATOR_ID, creator_id);
		values.put(DatabaseHelper.FIELD_TASKINFO_CREATOR_TIME, (creator_time));
		values.put(DatabaseHelper.FIELD_TASKINFO_UPDATE_ID, update_id);
		values.put(DatabaseHelper.FIELD_TASKINFO_UPDATE_TIME, update_time);
		values.put(DatabaseHelper.FIELD_TASKINFO_IS_KEEP, is_keep);
		values.put(DatabaseHelper.FIELD_TASKINFO_STATUS, status);
		values.put(DatabaseHelper.FIELD_TASKINFO_EXAMINE_ID, examine_id);
		values.put(DatabaseHelper.FIELD_TASKINFO_STATUS, "0");
		values.put(DatabaseHelper.FIELD_TASKINFO_APPROVE_ID, approve_id);
		try {
			return db.insert(DatabaseHelper.TB_TASK, null, values) > 0;
		} finally {
			// db.close();
		}
	}

	/**
	 * 查询下的所有任务
	 * 
	 * @param renwuleibie
	 *            1作业现场 2操作现场 3故障抢修现场 4不查询该字段
	 * @param planType
	 *            1,月计划；2,周计划;3.日计划。 默认传3
	 * @param uid
	 *            查询所有，传入null
	 * @param status
	 *            0,新的任务；1,执行中；2,延误；3,完成；4,取消任务。 null则不查询此字段
	 * @return
	 */
	public List<tb_task_info> getPlanTasks(int renwuleibie, int planType, String uid,
			String status) {
		return getPlanTasks(renwuleibie, planType, uid, status, null, null);
	}

	/**
	 * 
	 * 查询下的所有任务
	 * 
	 * @param renwuleibie
	 *            1作业现场 2操作现场 3故障抢修现场 4不查询该字段
	 * @param planType
	 *            1,月计划；2,周计划;3.日计划。 默认传3
	 * @param uid
	 *            查询所有，传入null
	 * @param status
	 *            0,新的任务；1,执行中；2,延误；3,完成；4,取消任务。 null则不查询此字段
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<tb_task_info> getPlanTasks(int renwuleibie, int planType, String uid, String status,
			String startTime, String endTime) {
		db = dbHelper.getReadableDatabase();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from " + DatabaseHelper.TB_TASK);
		sql.append(" where ");
		if (renwuleibie > 0 || !TextUtils.isEmpty(uid)) {
			if (renwuleibie < 4) {
				sql.append(DatabaseHelper.FIELD_TASKINFO_CATEGORY + " = '"
						+ taskLeibieInt2String(renwuleibie) + "'");
				if (!TextUtils.isEmpty(uid)) {
					sql.append(" and " + DatabaseHelper.FIELD_TASKINFO_RESPONSIBILITY_USER + " = '"
							+ uid + "'");
				}
			} else if (renwuleibie == 4) {
				if (!TextUtils.isEmpty(uid)) {
					if (!sql.toString().endsWith("where "))
						sql.append(" and ");
					sql.append(
							DatabaseHelper.FIELD_TASKINFO_RESPONSIBILITY_USER + " = '" + uid + "'");
				}
			}
		}

		if (!sql.toString().endsWith(" where "))
			sql.append(" and ");
		sql.append(DatabaseHelper.FIELD_TASKINFO_PLAN_TYPE + " = " + planType);

		if (!TextUtils.isEmpty(status)) {
			// 新任务
			if (status.equals("0")) {
				sql.append(" and (" + DatabaseHelper.FIELD_TASKINFO_START_TIME + " is null) and "
						+ DatabaseHelper.FIELD_TASKINFO_PLAN_END_TIME + " > "
						+ System.currentTimeMillis());
			}
			// 执行中
			else if (status.equals("1")) {
				sql.append(" and (" + DatabaseHelper.FIELD_TASKINFO_START_TIME
						+ " is not null ) and (" + DatabaseHelper.FIELD_TASKINFO_END_TIME
						+ " is null ) " + "and " + DatabaseHelper.FIELD_TASKINFO_PLAN_END_TIME
						+ " > " + System.currentTimeMillis());
			}
			// 延误的
			else if (status.equals("2")) {
				sql.append(" and (" + DatabaseHelper.FIELD_TASKINFO_END_TIME + " is null) and "
						+ DatabaseHelper.FIELD_TASKINFO_PLAN_END_TIME + " < "
						+ System.currentTimeMillis());
			}
			// 完成
			else if (status.equals("3")) {
				sql.append(
						" and (" + DatabaseHelper.FIELD_TASKINFO_START_TIME + " is not null) and ("
								+ DatabaseHelper.FIELD_TASKINFO_END_TIME + " is not null)");
			}
			// 取消
			else if (status.equals("4")) {
				sql.append(" and " + DatabaseHelper.FIELD_TASKINFO_STATUS + " = 4");
			}
		}

		if (!TextUtils.isEmpty(startTime))
			// sql.append(" and " + DatabaseHelper.FIELD_TASKINFO_CREATOR_TIME +
			// " > " + startTime);
			sql.append(" and " + DatabaseHelper.FIELD_TASKINFO_PLAN_START_TIME + " > " + startTime);
		if (!TextUtils.isEmpty(endTime))
			// sql.append(" and " + DatabaseHelper.FIELD_TASKINFO_CREATOR_TIME +
			// " < " + endTime);
			sql.append(" and " + DatabaseHelper.FIELD_TASKINFO_PLAN_START_TIME + " < " + endTime);

		// sql.append(" order by " + DatabaseHelper.FIELD_TASKINFO_CREATOR_TIME
		// + " desc");
		// 按照计划开始时间进行排序
		sql.append(" order by " + DatabaseHelper.FIELD_TASKINFO_PLAN_START_TIME + " desc");

//		Log.v(getClass().getSimpleName() + ">>>>>>>", sql.toString());
		Cursor c = db.rawQuery(sql.toString(), null);
		List<tb_task_info> result = new ArrayList<tb_task_info>();
		while (c.moveToNext()) {
			tb_task_info info = new tb_task_info(getData(c, DatabaseHelper.FIELD_TASKINFO_ID),
					getData(c, DatabaseHelper.FIELD_TASKINFO_WEATHER),
					getData(c, DatabaseHelper.FIELD_TASKINFO_NAME),
					getData(c, DatabaseHelper.FIELD_TASKINFO_TASK_CODE),
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
					getData(c, DatabaseHelper.FIELD_TASKINFO_APPROVE_ID),
					getData(c, DatabaseHelper.FIELD_TASKINFO_HISTORY_ID));
			result.add(info);
		}
		c.close();
		// db.close();
		return result;
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
					getData(c, DatabaseHelper.FIELD_TASKINFO_TASK_CODE),
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
					getData(c, DatabaseHelper.FIELD_TASKINFO_APPROVE_ID),
					getData(c, DatabaseHelper.FIELD_TASKINFO_HISTORY_ID));
		}
		c.close();
		// db.close();
		return info;
	}

	public boolean savePlanTaskAtt(String id, String task_id, String historygps, String standard,
			String type, String url, String upload_time, String md5, String status) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_ID, id);
		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_MD5, md5);
		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_HISTORYGPS, historygps);
		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_STANDARD, standard);
		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_TASK_ID, task_id);
		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_TYPE, type);
		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_UPLOAD_TIME, upload_time);
		values.put(DatabaseHelper.FIELD_TASK_ATTCHMENT_URL, url);
		values.put(DatabaseHelper.FIELD_TASK_ATTACHMENT_STATUS, status);
		// 获取地线数值
		String[] tmp = url.split("_");
		if (tmp.length > 1) {
			values.put(DatabaseHelper.FIELD_TASK_ATTACHMENT_DIXIAN,
					Integer.parseInt(url.split("_")[0].substring(1)));
		}

		try {
			return db.insert(DatabaseHelper.TB_TASK_ATTACHMENT, null, values) > 0;
		} finally {
			// db.close();
		}
	}

	public List<tb_task_attachment> getPlanTaskAtts(String tid) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK_ATTACHMENT, null,
				DatabaseHelper.FIELD_TASK_ATTCHMENT_TASK_ID + " = ?", new String[] { tid }, null,
				null, null);
		for (String tmp : c.getColumnNames()) {
			Log.v("login", tmp);
		}
		List<tb_task_attachment> result = new ArrayList<tb_task_attachment>();
		while (c.moveToNext()) {
			result.add(new tb_task_attachment(getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_ID),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_TASK_ID),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_HISTORYGPS),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_STANDARD),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_TYPE),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_URL),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_UPLOAD_TIME),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_MD5),
					getData(c, DatabaseHelper.FIELD_TASK_ATTACHMENT_STATUS),
					c.getInt(c.getColumnIndex(DatabaseHelper.FIELD_TASK_ATTACHMENT_DIXIAN))));
		}
		c.close();
		// db.close();
		return result;
	}

	/**
	 * 
	 * @param startTime
	 *            可为null
	 * @param endTime
	 *            可为null
	 * @param status
	 * @return
	 */
	public List<tb_task_attachment> getPlanTaskAtts(String startTime, String endTime,
			String status) {
		db = dbHelper.getReadableDatabase();
		StringBuilder builder = new StringBuilder();
		builder.append("select * from " + DatabaseHelper.TB_TASK_ATTACHMENT + " where ");
		if (!TextUtils.isEmpty(startTime)) {
			builder.append(
					DatabaseHelper.FIELD_TASK_ATTCHMENT_UPLOAD_TIME + " > " + startTime + " and ");
		}
		if (!TextUtils.isEmpty(endTime)) {
			builder.append(
					DatabaseHelper.FIELD_TASK_ATTCHMENT_UPLOAD_TIME + " < " + endTime + " and ");
		}
		builder.append(DatabaseHelper.FIELD_TASK_ATTACHMENT_STATUS + " = '" + status + "'");
		Log.v(PlanTaskDao.class.getSimpleName(), builder.toString());
		Cursor c = db.rawQuery(builder.toString(), null);
		List<tb_task_attachment> result = new ArrayList<tb_task_attachment>();
		while (c.moveToNext()) {
			result.add(new tb_task_attachment(getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_ID),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_TASK_ID),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_HISTORYGPS),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_STANDARD),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_TYPE),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_URL),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_UPLOAD_TIME),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_MD5),
					getData(c, DatabaseHelper.FIELD_TASK_ATTACHMENT_STATUS),
					c.getInt(c.getColumnIndex(DatabaseHelper.FIELD_TASK_ATTACHMENT_DIXIAN))));
		}
		c.close();
		// db.close();
		return result;
	}

	public tb_task_attachment getPlanTaskAtt(String planTaskAttId) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK_ATTACHMENT, null,
				DatabaseHelper.FIELD_TASK_ATTCHMENT_ID + " = ?", new String[] { planTaskAttId },
				null, null, null);
		tb_task_attachment result = null;
		if (c.moveToFirst()) {
			result = new tb_task_attachment(getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_ID),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_TASK_ID),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_HISTORYGPS),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_STANDARD),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_TYPE),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_URL),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_UPLOAD_TIME),
					getData(c, DatabaseHelper.FIELD_TASK_ATTCHMENT_MD5),
					getData(c, DatabaseHelper.FIELD_TASK_ATTACHMENT_STATUS),
					c.getInt(c.getColumnIndex(DatabaseHelper.FIELD_TASK_ATTACHMENT_DIXIAN)));
		}
		c.close();
		// db.close();
		return result;
	}

	/**
	 * 更改附件上传状态
	 * 
	 * @param taskAttId
	 * @param status
	 *            0或者是null或者是空:未上传 1:正在上传 2：已上传
	 * @return
	 */
	public boolean changeTaskAttachmentStatus(String taskAttId, String status) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.FIELD_TASK_ATTACHMENT_STATUS, status);
		try {
			return db.update(DatabaseHelper.TB_TASK_ATTACHMENT, values,
					DatabaseHelper.FIELD_TASK_ATTCHMENT_ID + " = ?",
					new String[] { taskAttId }) > 0;
		} finally {
			// db.close();
		}
	}

	public boolean changeTaskAttachmentsStatus(List<tb_task_attachment> attachments,
			List<String> statuses) {
		for (int i = 0; i < attachments.size(); i++) {
			if (changeTaskAttachmentStatus(attachments.get(i).getId(), statuses.get(i)))
				continue;
			else
				return false;
		}
		return true;
	}

	public boolean savePlanTaskAtt(UploadTaskAttachmentResponse r) {
		for (tb_task_attachment att : r.getAttachments()) {
			if (savePlanTaskAtt(att.getId(), att.getTask_id(), att.getHistorygps(),
					att.getStandard(), att.getType(), att.getUrl(), att.getUpload_time(),
					att.getMd5(), att.getStatus())) {
				continue;
			} else
				return false;
		}
		GpsDao dao = new GpsDao(c);
		for (tb_gps_history gps : r.getGpss()) {
			if (dao.saveHistory(gps.getId(), gps.getPerson_id(), gps.getOllectionTime(),
					gps.getLongitude(), gps.getLatitude(), gps.getGps_type(), gps.getAccuracy(),
					gps.getHeight(), gps.getSpeed(), gps.getUpdate_time(), gps.getCoordinate(),
					gps.getRemark()) > 0)
				continue;
			else
				return false;
		}
		return true;
	}
}
