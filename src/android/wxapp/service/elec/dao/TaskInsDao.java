package android.wxapp.service.elec.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.imooc.treeview.utils.Node;

import android.R.layout;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.Contacts.Data;
import android.wxapp.service.elec.model.CreateInsRequest;
import android.wxapp.service.elec.model.CreateInsResponse;
import android.wxapp.service.elec.model.bean.Attachments;
import android.wxapp.service.elec.model.bean.Uid;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Person;
import android.wxapp.service.elec.model.bean.table.tb_task_info;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions_attachment;
import android.wxapp.service.elec.model.bean.table.tb_task_instructions_receive;
import android.wxapp.service.util.Utils;

public class TaskInsDao extends BaseDAO {

	public TaskInsDao(Context context) {
		super(context);
	}

	public boolean saveTaskIns(String planTaskId, String taskInsId, String uids_s, String text,
			String atts_s, String sendid, String time, String type) {
		List<Uid> uids_o = gson.fromJson(uids_s, new TypeToken<List<Uid>>() {
		}.getType());
		boolean saveUid = true;
		for (Uid uid : uids_o) {
			if (!saveInsRec(null, planTaskId, uid.getRid(), time, null)) {
				saveUid = false;
				break;
			}
		}
		List<Attachments> atts_o = gson.fromJson(atts_s, new TypeToken<List<Attachments>>() {
		}.getType());
		boolean saveAtt = true;
		for (Attachments attachments : atts_o) {

			if (!saveInsAtt(null, planTaskId, attachments.getType(), attachments.getUrl(), time,
					null)) {
				saveAtt = false;
				break;
			}
		}

		return saveAtt && saveUid && saveIns(taskInsId, planTaskId, text, sendid, time, type);

	}

	public boolean saveIns(CreateInsResponse r) {
		if (r.getAttachments() != null) {
			for (tb_task_instructions_attachment att : r.getAttachments()) {
				if (saveInsAtt(att.getId(), att.getInstructions_id(), att.getType(), att.getUrl(),
						att.getUpdate_time(), att.getMd5()))
					continue;
				else
					return false;
			}

		}
		if (r.getReceivers() != null) {
			for (tb_task_instructions_receive receiver : r.getReceivers()) {
				if (saveReceiver(receiver.getId(), receiver.getInstructions_id(),
						receiver.getReceive_id(), receiver.getReceive_time(),
						receiver.getIs_read())) {
					continue;
				} else
					return false;
			}
		}
		return saveIns(r.getId(), r.getTask_id(), r.getContent(), r.getSend_id(), r.getSend_time(),
				r.getType());
	}

	/**
	 * 保存任务指令（不包括附件）
	 * 
	 * @param id
	 * @param planTaskId
	 * @param content
	 * @param send_id
	 * @param sendtime
	 * @param type
	 *            0,临时指令；1,通知消息
	 * @return
	 */
	public boolean saveIns(String id, String planTaskId, String content, String send_id,
			String sendtime, String type) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_ID, id);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_TASK_ID, planTaskId);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_CONTENT, content);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_ID, send_id);
		if (Utils.dateIsFormat(sendtime))
			sendtime = Utils.parseDateInFormat(sendtime);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_TIME, sendtime);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_TYPE, type);
		return db.insert(DatabaseHelper.TB_TASK_INSTRUCTIONS, null, values) > 0;
	}

	public boolean saveInsRec(String id, String instructions_id, String receie_id,
			String receive_time, String is_read) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_ID, id);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_INSTRUCTIONS_ID, instructions_id);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID, receie_id);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_TIME, receive_time);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ, is_read);
		return db.insert(DatabaseHelper.TB_TASK_INSTRUCTIONS_RECEIVE, null, values) > 0;
	}

	public boolean saveInsAtt(String id, String instructions_id, String type, String url,
			String update_time, String md5) {

		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.FIELD_TASK_INS_ATT_ID, id);
		values.put(DatabaseHelper.FIELD_TASK_INS_ATT_INSTRUCTIONS_ID, instructions_id);
		values.put(DatabaseHelper.FIELD_TASK_INS_ATT_TYPE, type);
		values.put(DatabaseHelper.FIELD_TASK_INS_ATT_URL, url);
		values.put(DatabaseHelper.FIELD_TASK_INS_ATT_UPDATE_TIME, update_time);
		values.put(DatabaseHelper.FIELD_TASK_INS_ATT_MD5, md5);
		return db.insert(DatabaseHelper.TB_TASK_INSTRUCTIONS_ATTACHMENT, null, values) > 0;
	}

	/**
	 * 
	 * @param uid
	 * @param isRead
	 *            （0-未读；1-已读）
	 * @return
	 */
	public List<tb_task_instructions_receive> getAllIns(String uid, String isRead) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK_INSTRUCTIONS_RECEIVE, null,
				DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID + " = ? and "
						+ DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ + " = ?",
				new String[] { uid, isRead }, null, null, null);
		List<tb_task_instructions_receive> result = new ArrayList<tb_task_instructions_receive>();
		while (c.moveToNext()) {
			result.add(new tb_task_instructions_receive(
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_INSTRUCTIONS_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_TIME),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ)));
		}
		c.close();
		return result;
	}

	public boolean changeInsReadStatue(String uid, String insId, String isRead) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ, isRead);
		return db.update(DatabaseHelper.TB_TASK_INSTRUCTIONS_RECEIVE, values,
				DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID + " = ? and "
						+ DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ + " = ?",
				new String[] { uid, isRead }) > 0;
	}

	/**
	 * 
	 * @param taskInsId
	 * 
	 * @return
	 */
	public tb_task_instructions getTaskIns(String taskInsId) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK_INSTRUCTIONS, null,
				DatabaseHelper.FIELD_TASK_INSTRUCTIONS_ID + " = ? and "
						+ DatabaseHelper.FIELD_TASK_INSTRUCTIONS_TYPE + " = ?",
				new String[] { taskInsId, "0" }, null, null,
				DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_TIME);
		tb_task_instructions result = null;
		if (c.moveToFirst()) {
			result = new tb_task_instructions(getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_TASK_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_CONTENT),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_TIME),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_TYPE));
		}
		c.close();
		return result;
	}

	public List<tb_task_instructions_attachment> getTaskInsAtt(String taskInsId) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK_INSTRUCTIONS_ATTACHMENT, null,
				DatabaseHelper.FIELD_TASK_INS_ATT_INSTRUCTIONS_ID + " = ?",
				new String[] { taskInsId }, null, null, null);
		List<tb_task_instructions_attachment> result = new ArrayList<tb_task_instructions_attachment>();
		while (c.moveToNext()) {
			tb_task_instructions_attachment item = new tb_task_instructions_attachment(
					getData(c, DatabaseHelper.FIELD_TASK_INS_ATT_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INS_ATT_INSTRUCTIONS_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INS_ATT_TYPE),
					getData(c, DatabaseHelper.FIELD_TASK_INS_ATT_URL),
					getData(c, DatabaseHelper.FIELD_TASK_INS_ATT_UPDATE_TIME),
					getData(c, DatabaseHelper.FIELD_TASK_INS_ATT_MD5));
			result.add(item);
		}
		c.close();
		return result;
	}

	public List<tb_task_instructions_receive> getTaskInsRec(String taskInsId) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK_INSTRUCTIONS_RECEIVE, null,
				DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_INSTRUCTIONS_ID + " = ?",
				new String[] { taskInsId }, null, null, null);
		List<tb_task_instructions_receive> result = new ArrayList<tb_task_instructions_receive>();
		while (c.moveToNext()) {
			tb_task_instructions_receive item = new tb_task_instructions_receive(
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_INSTRUCTIONS_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_TIME),
					getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ));
			result.add(item);
		}
		c.close();
		return result;
	}

	public boolean saveReceiver(String id, String instrucions_id, String receive_id,
			String receive_time, String is_read) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_ID, id);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_INSTRUCTIONS_ID, instrucions_id);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ, is_read);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID, receive_id);
		values.put(DatabaseHelper.FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_TIME, receive_time);
		return db.insert(DatabaseHelper.TB_TASK_INSTRUCTIONS_RECEIVE, null, values) > 0;
	}

	public List<tb_task_instructions> getMsg(String tid) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_TASK_INSTRUCTIONS, null,
				DatabaseHelper.FIELD_TASK_INSTRUCTIONS_TASK_ID + " = ? and "
						+ DatabaseHelper.FIELD_TASK_INSTRUCTIONS_TYPE + " = ?",
				new String[] { tid, "1" }, null, null,
				DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_TIME);
		List<tb_task_instructions> result = new ArrayList<tb_task_instructions>();
		while (c.moveToNext()) {
			result.add(
					new tb_task_instructions(getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_ID),
							tid, getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_CONTENT),
							getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_ID),
							getData(c, DatabaseHelper.FIELD_TASK_INSTRUCTIONS_SEND_TIME), "1"));
		}
		c.close();
		return result;
	}

	public List<Node> getMsgReceivers(String tid) {
		List<Node> result = new ArrayList<Node>();
		tb_task_info taskInfo = new PlanTaskDao(c).getPlanTask(tid);
		result.add(new Node(taskInfo.getResponsibility_user(), "", ""));
		List<TB_SYS_Person> ps = new OrgDao(c).getPersons("1");
		for (TB_SYS_Person tb_SYS_Person : ps) {
			result.add(new Node(tb_SYS_Person.getId(), "", ""));
		}
		return result;
	}

	// TODO
	public boolean saveMsg(String tid) {
		return false;
	}
}
