package android.wxapp.service.elec.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	// 版本
	public static final int VERSION = 1;

	private static final String LOG_TAG = "DatabaseHelper";

	// 数据库名
	public static final String DATABASE_NAME = "App.db";

	public static final String TB_ORG = "TB_SYS_ORG";
	public static final String FIELD_ORG_ID = "id";
	public static final String FIELD_ORG_ORG_CODE = "org_code";
	public static final String FIELD_ORG_ORG_NAME = "org_name";
	public static final String FIELD_ORG_REMARK = "remark";
	public static final String FIELD_ORG_UPDATE_TIME = "update_time";
	public static final String SQL_ORGE_CREATE_TABLE = "create table " + TB_ORG + " ("
			+ FIELD_ORG_ID + " integer primary key autoincrement, " + FIELD_ORG_ORG_CODE + " text,"
			+ FIELD_ORG_ORG_NAME + " text," + FIELD_ORG_REMARK + " text," + FIELD_ORG_UPDATE_TIME
			+ " text)";

	public static final String TB_PERSON = "TB_SYS_Person";
	public static final String FIELD_PERSON_ID = "id";
	public static final String FIELD_PERSON_ALIAS = "alias";
	public static final String FIELD_PERSON_ORG_CODE = "org_code";
	public static final String FIELD_PERSON_NAME = "name";
	public static final String FIELD_PERSON_CONTACT = "contact";// 新增
	public static final String FIELD_PERSON_IDENTIFY_CODE = "identify_code";
	public static final String FIELD_PERSON_REMARK = "remark";
	public static final String FIELD_PERSON_IMSI = "imsi";
	public static final String FIELD_PERSON_FORCE_OFFLINE = "force_offline";
	public static final String FIELD_PERSON_SEQUENCE = "sequence";
	public static final String FIELD_PERSON_UPDATE_TIME = "update_time";
	public static final String SQL_PERSON_CREATE_TABLE = "create table " + TB_PERSON + " ("
			+ FIELD_PERSON_ID + " integer primary key autoincrement, " + FIELD_PERSON_ALIAS
			+ " text," + FIELD_PERSON_ORG_CODE + " text," + FIELD_PERSON_NAME + " text,"
			+ FIELD_PERSON_CONTACT + " text," + FIELD_PERSON_IDENTIFY_CODE + " text,"
			+ FIELD_PERSON_REMARK + " text," + FIELD_PERSON_IMSI + " text,"
			+ FIELD_PERSON_FORCE_OFFLINE + " text," + FIELD_PERSON_SEQUENCE + " text,"
			+ FIELD_PERSON_UPDATE_TIME + " text)";

	public static final String TB_ROLE = "TB_SYS_Role";
	public static final String FIELD_ROLE_ID = "id";
	public static final String FIELD_ROLE_NAME = "role_name";
	public static final String FIELD_ROLE_REMARK = "remark";
	public static final String FIELD_ROLE_UPDATE_TIME = "update_time";
	public static final String SQL_ROLE_CREATE_TABLE = "create table " + TB_ROLE + " ("
			+ FIELD_ROLE_ID + " integer primary key autoincrement, " + FIELD_ROLE_NAME + " text,"
			+ FIELD_ROLE_REMARK + " text," + FIELD_ROLE_UPDATE_TIME + " text)";

	public static final String TB_ROLE_PERSON = "TB_SYS_Role_person";
	public static final String FIELD_ROLE_PERSON_ID = "id";
	public static final String FIELD_ROLE_PERSON_PID = "person_id";
	public static final String FIELD_ROLE_PERSON_RID = "role_id";
	public static final String SQL_ROLE_PERSON_CREATE_TABLE = "create table " + TB_ROLE_PERSON
			+ " (" + FIELD_ROLE_PERSON_ID + " integer primary key autoincrement, "
			+ FIELD_ROLE_PERSON_PID + " text," + FIELD_ROLE_PERSON_RID + " text)";

	public static final String TB_PERMISSION = "tb_sys_permission";
	public static final String FIELD_PERMISSION_ID = "id";
	public static final String FIELD_PERMISSION_MENU_CODE = "Menu_code";
	public static final String FIELD_PERMISSION_CODE = "code";
	public static final String FIELD_PERMISSION_NAME = "name";
	public static final String FIELD_PERMISSION_ROLE_ID = "Role_id";
	public static final String SQL_PERMISSION_CREATE_TABLE = "create table " + TB_PERMISSION + " ("
			+ FIELD_PERMISSION_ID + " integer primary key autoincrement, "
			+ FIELD_PERMISSION_MENU_CODE + " text," + FIELD_PERMISSION_CODE + " text,"
			+ FIELD_PERMISSION_NAME + " text," + FIELD_PERMISSION_ROLE_ID + " text)";

	public static final String TB_LOG = "tb_sys_Log";
	public static String FIELD_LOG_ID = "id";
	public static String FIELD_LOG_USER_NAME = "User_name";
	public static String FIELD_LOG_TYPE = "Type";
	public static String FIELD_LOG_CONTENT = "content";
	public static String FIELD_LOG_TIME = "time";
	public static String FIELD_LOG_LONGITUDE = "longitude";
	public static String FIELD_LOG_LATITUDE = "latitude";
	public static String FIELD_LOG_CLIENT = "client";
	public static String FIELD_LOG_IP = "ip";
	public static final String SQL_LOG_CREATE_TABLE = "create table " + TB_LOG + " (" + FIELD_LOG_ID
			+ " integer primary key autoincrement, " + FIELD_LOG_USER_NAME + " text,"
			+ FIELD_LOG_TYPE + " text," + FIELD_LOG_CONTENT + " text," + FIELD_LOG_TIME + " text,"
			+ FIELD_LOG_LONGITUDE + " text," + FIELD_LOG_LATITUDE + " text," + FIELD_LOG_CLIENT
			+ " text," + FIELD_LOG_IP + " text)";

	public static final String TB_DICTIONARY = "tb_sys_dictionary";
	public static final String FIELD_DIC_ID = "id";
	public static final String FIELD_DIC_CODE = "code";
	public static final String FIELD_DIC_NAME = "name";
	public static final String SQL_DIC_CREATE_TABLE = "create table " + TB_DICTIONARY + " ("
			+ FIELD_DIC_ID + " integer primary key autoincrement, " + FIELD_DIC_CODE + " text,"
			+ FIELD_DIC_NAME + " text)";

	public static final String TB_DIC_DATA = "tb_sys_dictionary_data";
	public static final String FIELD_DICDATA_ID = "id";
	public static final String FIELD_DICDATA_DATA_CODE = "data_code";
	public static final String FIELD_DICDATA_DATA_VALUE = "data_value";
	public static final String FIELD_DICDATA_DICTIONARY_CODE = "dictionary_code";
	public static final String SQL_DIC_DATA_CREATE_TABLE = "create table " + TB_DIC_DATA + " ("
			+ FIELD_DICDATA_ID + " integer primary key autoincrement, " + FIELD_DICDATA_DATA_CODE
			+ " text," + FIELD_DICDATA_DATA_VALUE + " text," + FIELD_DICDATA_DICTIONARY_CODE
			+ " text)";

	public static final String TB_TASK = "tb_task_info";
	public static final String FIELD_TASKINFO_ID = "id";
	public static final String FIELD_TASKINFO_WEATHER = "weather";
	public static final String FIELD_TASKINFO_NAME = "name";
	public static final String FIELD_TASKINFO_TASK_CODE = "task_code";// 新增
	public static final String FIELD_TASKINFO_POWER_CUT_RANGE = "power_cut_range";
	public static final String FIELD_TASKINFO_EFFECT_EARA = "effect_eara";
	public static final String FIELD_TASKINFO_CONTENT = "content";
	public static final String FIELD_TASKINFO_RESPONSIBILITY_USER = "responsibility_user";
	public static final String FIELD_TASKINFO_RESPONSIBILITY_USER_ID = "responsibility_user_id";// 新增
	public static final String FIELD_TASKINFO_PLAN_START_TIME = "plan_start_time";
	public static final String FIELD_TASKINFO_PLAN_END_TIME = "plan_end_time";
	public static final String FIELD_TASKINFO_START_TIME = "start_time";
	public static final String FIELD_TASKINFO_END_TIME = "end_time";
	public static final String FIELD_TASKINFO_CATEGORY = "category";
	public static final String FIELD_TASKINFO_IS_PUBLISH = "is_publish";
	public static final String FIELD_TASKINFO_SPECIAL = "special";
	public static final String FIELD_TASKINFO_LEADER = "leader";
	public static final String FIELD_TASKINFO_LEADER_ID = "leader_id";// 新增
	public static final String FIELD_TASKINFO_MEASURES = "measures";
	public static final String FIELD_TASKINFO_DOMAIN = "domain";
	public static final String FIELD_TASKINFO_IS_POWER_CUT = "is_power_cut";
	public static final String FIELD_TASKINFO_CUT_TYPE = "cut_type";
	public static final String FIELD_TASKINFO_IMPLEMENT_ORG = "implement_org";
	public static final String FIELD_TASKINFO_IMPLEMENT_ORG_ID = "implement_org_id";// 新增
	public static final String FIELD_TASKINFO_NUMBER = "number";
	public static final String FIELD_TASKINFO_REMARK = "remark";
	public static final String FIELD_TASKINFO_PLAN_TYPE = "plan_type";
	public static final String FIELD_TASKINFO_CREATOR_ID = "creator_id";
	public static final String FIELD_TASKINFO_CREATOR_TIME = "creator_time";
	public static final String FIELD_TASKINFO_IS_KEEP = "is_keep";
	public static final String FIELD_TASKINFO_STATUS = "status";
	public static final String FIELD_TASKINFO_EXAMINE_ID = "examine_id";
	public static final String FIELD_TASKINFO_APPROVE_ID = "approve_id";
	public static final String FIELD_TASKINFO_UPDATE_ID = "update_id";
	public static final String FIELD_TASKINFO_UPDATE_TIME = "update_time";
	public static final String SQL_TASK_CREATE_TABLE = "create table " + TB_TASK + " ("
			+ FIELD_TASKINFO_ID + " integer primary key autoincrement, " + FIELD_TASKINFO_WEATHER
			+ " text," + FIELD_TASKINFO_NAME + " text," + FIELD_TASKINFO_POWER_CUT_RANGE + " text,"
			+ FIELD_TASKINFO_EFFECT_EARA + " text," + FIELD_TASKINFO_CONTENT + " text,"
			+ FIELD_TASKINFO_RESPONSIBILITY_USER + " text," + FIELD_TASKINFO_PLAN_START_TIME
			+ " text," + FIELD_TASKINFO_PLAN_END_TIME + " text," + FIELD_TASKINFO_START_TIME
			+ " text," + FIELD_TASKINFO_END_TIME + " text," + FIELD_TASKINFO_CATEGORY + " text,"
			+ FIELD_TASKINFO_IS_PUBLISH + " text," + FIELD_TASKINFO_SPECIAL + " text,"
			+ FIELD_TASKINFO_LEADER + " text," + FIELD_TASKINFO_MEASURES + " text,"
			+ FIELD_TASKINFO_DOMAIN + " text," + FIELD_TASKINFO_IS_POWER_CUT + " text,"
			+ FIELD_TASKINFO_CUT_TYPE + " text," + FIELD_TASKINFO_IMPLEMENT_ORG + " text,"
			+ FIELD_TASKINFO_NUMBER + " text," + FIELD_TASKINFO_REMARK + " text,"
			+ FIELD_TASKINFO_TASK_CODE + " text," + FIELD_TASKINFO_PLAN_TYPE + " text,"
			+ FIELD_TASKINFO_CREATOR_ID + " text," + FIELD_TASKINFO_RESPONSIBILITY_USER_ID
			+ " text," + FIELD_TASKINFO_CREATOR_TIME + " text," + FIELD_TASKINFO_IS_KEEP + " text,"
			+ FIELD_TASKINFO_LEADER_ID + " text," + FIELD_TASKINFO_STATUS + " text,"
			+ FIELD_TASKINFO_EXAMINE_ID + " text," + FIELD_TASKINFO_IMPLEMENT_ORG_ID + " text,"
			+ FIELD_TASKINFO_APPROVE_ID + " text," + FIELD_TASKINFO_UPDATE_ID + " text,"
			+ FIELD_TASKINFO_UPDATE_TIME + " text)";

	public static final String TB_TASK_STANDARD = "tb_task_standard";
	public static final String FIELD_TASK_STANDARD_ID = "id";
	public static final String FIELD_TASK_STANDARD_STANDARD = "standard";
	public static final String FIELD_TASK_STANDARD_TOTAL_SCORE = "total_score";
	public static final String FIELD_TASK_STANDARD_CAREGORE = "category";
	public static final String SQL_TASK_STANDARD_CREATE_TABLE = "create table " + TB_TASK_STANDARD
			+ " (" + FIELD_TASK_STANDARD_ID + " integer primary key autoincrement, "
			+ FIELD_TASK_STANDARD_STANDARD + " text," + FIELD_TASK_STANDARD_TOTAL_SCORE + " text,"
			+ FIELD_TASK_STANDARD_CAREGORE + " text)";

	public static final String TB_TASK_EVALUATE = "tb_task_evaluate";
	public static final String FIELD_TASK_EVALUATE_ID = "id";
	public static final String FIELD_TASK_EVALUATE_TASK_ID = "task_id";
	public static final String FIELD_TASK_EVALUATE_STANDARD_ID = "standard_id";
	public static final String FIELD_TASK_EVALUATE_SCORE = "score";
	public static final String FIELD_TASK_EVALUATE_EVALUATE = "evaluate";
	public static final String FIELD_TASK_EVALUATE_USER_ID = "user_id";
	public static final String FIELD_TASK_EVALUATE_TIME = "time";
	public static final String SQL_TASK_EVALUATE_CREATE_TABLE = "create table " + TB_TASK_EVALUATE
			+ " (" + FIELD_TASK_EVALUATE_ID + " integer primary key autoincrement, "
			+ FIELD_TASK_EVALUATE_TASK_ID + " text," + FIELD_TASK_EVALUATE_STANDARD_ID + " text,"
			+ FIELD_TASK_EVALUATE_SCORE + " text," + FIELD_TASK_EVALUATE_EVALUATE + " text,"
			+ FIELD_TASK_EVALUATE_USER_ID + " text," + FIELD_TASK_EVALUATE_TIME + " text)";

	public static final String TB_TASK_ATTACHMENT = "tb_task_attachment";
	public static final String FIELD_TASK_ATTCHMENT_ID = "id";
	public static final String FIELD_TASK_ATTCHMENT_TASK_ID = "task_id";
	public static final String FIELD_TASK_ATTCHMENT_HISTORYGPS = "historygps";
	public static final String FIELD_TASK_ATTCHMENT_STANDARD = "standard";
	public static final String FIELD_TASK_ATTCHMENT_TYPE = "type";
	public static final String FIELD_TASK_ATTCHMENT_URL = "url";
	public static final String FIELD_TASK_ATTCHMENT_UPLOAD_TIME = "upload_time";
	public static final String FIELD_TASK_ATTCHMENT_MD5 = "md5";
	public static final String SQL_TASK_ATTACHMENT_CREATE_TABLE = "create table "
			+ TB_TASK_ATTACHMENT + " (" + FIELD_TASK_ATTCHMENT_ID
			+ " integer primary key autoincrement, " + FIELD_TASK_ATTCHMENT_TASK_ID + " text,"
			+ FIELD_TASK_ATTCHMENT_HISTORYGPS + " text," + FIELD_TASK_ATTCHMENT_STANDARD + " text,"
			+ FIELD_TASK_ATTCHMENT_TYPE + " text," + FIELD_TASK_ATTCHMENT_URL + " text,"
			+ FIELD_TASK_ATTCHMENT_UPLOAD_TIME + " text," + FIELD_TASK_ATTCHMENT_MD5 + " text)";

	public static final String TB_TASK_INSTRUCTIONS = "tb_task_instructions";
	public static final String FIELD_TASK_INSTRUCTIONS_ID = "id";
	public static final String FIELD_TASK_INSTRUCTIONS_TASK_ID = "task_id";
	public static final String FIELD_TASK_INSTRUCTIONS_CONTENT = "content";
	public static final String FIELD_TASK_INSTRUCTIONS_SEND_ID = "send_id";
	public static final String FIELD_TASK_INSTRUCTIONS_SEND_TIME = "send_time";
	public static final String FIELD_TASK_INSTRUCTIONS_TYPE = "type";// 新增
	public static final String SQL_TASK_INSTRUCTIONS_CREATE_TABLE = "create table "
			+ TB_TASK_INSTRUCTIONS + " (" + FIELD_TASK_INSTRUCTIONS_ID
			+ " integer primary key autoincrement, " + FIELD_TASK_INSTRUCTIONS_TASK_ID + " text,"
			+ FIELD_TASK_INSTRUCTIONS_CONTENT + " text," + FIELD_TASK_INSTRUCTIONS_SEND_ID
			+ FIELD_TASK_INSTRUCTIONS_TYPE + " text," + " text," + FIELD_TASK_INSTRUCTIONS_SEND_TIME
			+ " text)";

	public static final String TB_TASK_INSTRUCTIONS_RECEIVE = "tb_task_instructions_receive";
	public static final String FIELD_TASK_INSTRUCTIONS_RECIEVE_ID = "id";
	public static final String FIELD_TASK_INSTRUCTIONS_RECIEVE_INSTRUCTIONS_ID = "instructions_id";
	public static final String FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID = "receive_id";
	public static final String FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_TIME = "receive_time";
	public static final String FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ = "is_read";
	public static final String SQL_TASK_INSTRUCTIONS_RECEIVE_CREATE_TABLE = "create table "
			+ TB_TASK_INSTRUCTIONS_RECEIVE + " (" + FIELD_TASK_INSTRUCTIONS_RECIEVE_ID
			+ " integer primary key autoincrement, "
			+ FIELD_TASK_INSTRUCTIONS_RECIEVE_INSTRUCTIONS_ID + " text,"
			+ FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_ID + " text,"
			+ FIELD_TASK_INSTRUCTIONS_RECIEVE_RECEIVE_TIME + " text,"
			+ FIELD_TASK_INSTRUCTIONS_RECIEVE_IS_READ + " text)";

	public static final String TB_TASK_INSTRUCTIONS_ATTACHMENT = "tb_task_instructions_attachment";
	public static final String FIELD_TASK_INS_ATT_ID = "id";
	public static final String FIELD_TASK_INS_ATT_INSTRUCTIONS_ID = "instructions_id";
	public static final String FIELD_TASK_INS_ATT_TYPE = "type";
	public static final String FIELD_TASK_INS_ATT_URL = "url";
	public static final String FIELD_TASK_INS_ATT_UPDATE_TIME = "update_time";
	public static final String FIELD_TASK_INS_ATT_MD5 = "md5";
	public static final String SQL_TASK_INS_ATT_CREATE_TABLE = "create table "
			+ TB_TASK_INSTRUCTIONS_ATTACHMENT + " (" + FIELD_TASK_INS_ATT_ID
			+ " integer primary key autoincrement, " + FIELD_TASK_INS_ATT_INSTRUCTIONS_ID + " text,"
			+ FIELD_TASK_INS_ATT_TYPE + " text," + FIELD_TASK_INS_ATT_URL + " text,"
			+ FIELD_TASK_INS_ATT_UPDATE_TIME + " text," + FIELD_TASK_INS_ATT_MD5 + " text)";

	// 群组表
	public static final String TB_SYS_GROUP = "tb_sys_group";
	public static final String FIELD_SYS_GROUP_ID = "id";
	public static final String FIELD_SYS_GROUP_TYPE = "type";
	public static final String FIELD_SYS_GROUP_NAME = "name";
	public static final String FIELD_SYS_GROUP_CREATE_TIME = "create_time";
	public static final String FIELD_SYS_GROUP_UPDATE_TIME = "update_time";
	public static final String SQL_SYS_GROUP = "create table " + TB_SYS_GROUP + " ("
			+ FIELD_SYS_GROUP_ID + " integer primary key autoincrement, " + FIELD_SYS_GROUP_TYPE
			+ " text," + FIELD_SYS_GROUP_NAME + " text," + FIELD_SYS_GROUP_CREATE_TIME + " text,"
			+ FIELD_SYS_GROUP_UPDATE_TIME + " text)";

	// 群组成员
	public static final String TB_SYS_GROUP_MEMBER = "tb_sys_group_member";
	public static final String FIELD_SYS_GROUP_MEMBER_ID = "id";
	public static final String FIELD_SYS_GROUP_MEMBER_GROUP_ID = "group_id";
	public static final String FIELD_SYS_GROUP_MEMBER_PERSON_ID = "person_id";
	public static final String SQL_SYS_GROUP_MEMBER = "create table " + TB_SYS_GROUP_MEMBER + " ("
			+ FIELD_SYS_GROUP_MEMBER_ID + " integer primary key autoincrement, "
			+ FIELD_SYS_GROUP_MEMBER_GROUP_ID + " text," + FIELD_SYS_GROUP_MEMBER_PERSON_ID
			+ " text)";

	// 消息表
	public static final String TB_SYS_MESSAGE = "tb_sys_message";
	public static final String FIELD_SYS_MESSAGE_ID = "id";
	public static final String FIELD_SYS_MESSAGE_TYPE = "type";
	public static final String FIELD_SYS_MESSAGE_SENDER_ID = "sender_id";
	public static final String FIELD_SYS_MESSAGE_RELATION_ID = "relation_id";
	public static final String FIELD_SYS_MESSAGE_SEND_TIME = "send_time";
	public static final String FIELD_SYS_MESSAGE_CONTENT = "content";
	public static final String FIELD_SYS_MESSAGE_UPDATE_TIME = "update_time";
	public static final String SQL_SYS_MESSAGE = "create table " + TB_SYS_MESSAGE + " ("
			+ FIELD_SYS_MESSAGE_ID + " integer primary key autoincrement, " + FIELD_SYS_MESSAGE_TYPE
			+ " text," + FIELD_SYS_MESSAGE_SENDER_ID + " text," + FIELD_SYS_MESSAGE_RELATION_ID
			+ " text," + FIELD_SYS_MESSAGE_SEND_TIME + " text," + FIELD_SYS_MESSAGE_CONTENT
			+ " text," + FIELD_SYS_MESSAGE_UPDATE_TIME + " text)";

	// 人员类型表
	public static final String TB_SYS_PERSON_TYPE = "tb_sys_person_type";
	public static final String FIELD_SYS_PERSON_TYPE_ID = "id";
	public static final String FIELD_SYS_PERSON_TYPE_DESCRIPTION = "description";
	public static final String SQL_SYS_PERSON_TYPE = "create table " + TB_SYS_PERSON_TYPE + " ("
			+ FIELD_SYS_PERSON_TYPE_ID + " integer primary key autoincrement, "
			+ FIELD_SYS_PERSON_TYPE_DESCRIPTION + " text)";

	// 消息相关人员表
	public static final String TB_SYS_MESSAGE_PERSON = "tb_sys_message_person";
	public static final String FIELD_SYS_MESSAGE_PERSON_ID = "id";
	public static final String FIELD_SYS_MESSAGE_PERSON_MESSAGE_ID = "message_id";
	public static final String FIELD_SYS_MESSAGE_PERSON_RELATOR_ID = "relator_id";
	public static final String FIELD_SYS_MESSAGE_PERSON_IS_READ = "is_read";
	public static final String FIELD_SYS_MESSAGE_PERSON_TYPE = "type";
	public static final String FIELD_SYS_MESSAGE_PERSON_UPDATE_TIME = "update_time";
	public static final String SQL_SYS_MESSAGE_PERSON = "create table " + TB_SYS_MESSAGE_PERSON
			+ " (" + FIELD_SYS_MESSAGE_PERSON_ID + " integer primary key autoincrement, "
			+ FIELD_SYS_MESSAGE_PERSON_MESSAGE_ID + " text," + FIELD_SYS_MESSAGE_PERSON_RELATOR_ID
			+ " text," + FIELD_SYS_MESSAGE_PERSON_IS_READ + " text," + FIELD_SYS_MESSAGE_PERSON_TYPE
			+ " text," + FIELD_SYS_MESSAGE_PERSON_UPDATE_TIME + " text)";

	public static final String TB_GPS_HISTORY = "tb_gps_history";
	public static final String FIELD_GPS_HISTORY_ID = "id";
	public static final String FIELD_GPS_HISTORY_PERSON_ID = "person_id";
	public static final String FIELD_GPS_HISTORY_OLLECTIONTIME = "ollectionTIme";
	public static final String FIELD_GPS_HISTORY_LONGITUDE = "longitude";
	public static final String FIELD_GPS_HISTORY_LATITUDE = "latitude";
	public static final String FIELD_GPS_HISTORY_GPS_TYPE = "gps_type";
	public static final String FIELD_GPS_HISTORY_ACCURACY = "accuracy";
	public static final String FIELD_GPS_HISTORY_HEIGHT = "height";
	public static final String FIELD_GPS_HISTORY_SPEED = "speed";
	public static final String FIELD_GPS_HISTORY_UPDATE_TIME = "update_time";
	public static final String FIELD_GPS_HISTORY_COORDINATE = "coordinate";
	public static final String FIELD_GPS_HISTORY_REMARK = "remark";
	public static final String SQL_GPS_HISTORY_CREATE_TABLE = "create table " + TB_GPS_HISTORY
			+ " (" + FIELD_GPS_HISTORY_ID + " integer primary key autoincrement, "
			+ FIELD_GPS_HISTORY_PERSON_ID + " text," + FIELD_GPS_HISTORY_OLLECTIONTIME + " text,"
			+ FIELD_GPS_HISTORY_LONGITUDE + " text," + FIELD_GPS_HISTORY_LATITUDE + " text,"
			+ FIELD_GPS_HISTORY_GPS_TYPE + " text," + FIELD_GPS_HISTORY_ACCURACY + " text,"
			+ FIELD_GPS_HISTORY_HEIGHT + " text," + FIELD_GPS_HISTORY_SPEED + " text,"
			+ FIELD_GPS_HISTORY_UPDATE_TIME + " text," + FIELD_GPS_HISTORY_COORDINATE + " text,"
			+ FIELD_GPS_HISTORY_REMARK + " text)";

	// 单键处理
	private volatile static DatabaseHelper _unique_instance = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	// 注意每个进程都会创建一个EvidenceDatabase实例
	// 绝对不可采用同步方法的方式，同步方法仅对类的一个实例起作用
	public static DatabaseHelper getInstance(Context context) {
		// context实际无用

		// 检查实例,如是不存在就进入同步代码区
		if (null == _unique_instance) {
			// 对其进行锁,防止两个线程同时进入同步代码区
			synchronized (DatabaseHelper.class) {
				// 必须双重检查
				if (null == _unique_instance) {
					_unique_instance = new DatabaseHelper(context);
				}
			}
		}

		return _unique_instance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		Log.v(LOG_TAG, "SQLite: onCreate");

		db.execSQL(SQL_ORGE_CREATE_TABLE);
		db.execSQL(SQL_PERSON_CREATE_TABLE);
		db.execSQL(SQL_ROLE_CREATE_TABLE);
		db.execSQL(SQL_ROLE_PERSON_CREATE_TABLE);
		db.execSQL(SQL_PERMISSION_CREATE_TABLE);
		db.execSQL(SQL_LOG_CREATE_TABLE);
		db.execSQL(SQL_DIC_CREATE_TABLE);
		db.execSQL(SQL_DIC_DATA_CREATE_TABLE);
		db.execSQL(SQL_TASK_CREATE_TABLE);
		db.execSQL(SQL_TASK_STANDARD_CREATE_TABLE);
		db.execSQL(SQL_TASK_EVALUATE_CREATE_TABLE);
		db.execSQL(SQL_TASK_ATTACHMENT_CREATE_TABLE);
		db.execSQL(SQL_TASK_INSTRUCTIONS_CREATE_TABLE);
		db.execSQL(SQL_TASK_INSTRUCTIONS_RECEIVE_CREATE_TABLE);
		db.execSQL(SQL_TASK_INS_ATT_CREATE_TABLE);
		db.execSQL(SQL_GPS_HISTORY_CREATE_TABLE);

		db.execSQL(SQL_SYS_GROUP);
		db.execSQL(SQL_SYS_GROUP_MEMBER);
		db.execSQL(SQL_SYS_MESSAGE);
		db.execSQL(SQL_SYS_PERSON_TYPE);
		db.execSQL(SQL_SYS_MESSAGE_PERSON);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.v(LOG_TAG, "SQLite: onUpgrade");
	}

}
