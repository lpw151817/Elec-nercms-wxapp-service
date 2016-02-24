package android.wxapp.service.dao;

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

	public static final String TB_ORG = "org";
	public static final String FIELD_ORG_ID = "id";
	public static final String FIELD_ORG_ORG_CODE = "org_code";
	public static final String FIELD_ORG_ORG_NAME = "org_name";
	public static final String FIELD_ORG_REMARK = "remark";
	public static final String FIELD_ORG_UPDATE_TIME = "update_time";
	public static final String SQL_ORGE_CREATE_TABLE = "create table " + TB_ORG + " ("
			+ FIELD_ORG_ID + " integer primary key autoincrement, " + FIELD_ORG_ORG_CODE + " text,"
			+ FIELD_ORG_ORG_NAME + " text," + FIELD_ORG_REMARK + " text," + FIELD_ORG_UPDATE_TIME
			+ " text)";

	public static final String TB_PERSON = "person";
	public static final String FIELD_PERSON_ID = "id";
	public static final String FIELD_PERSON_ALIAS = "alias";
	public static final String FIELD_PERSON_ORG_CODE = "Org_code";
	public static final String FIELD_PERSON_NAME = "name";
	
	public static final String FIELD_PERSON_IDENTIFY_CODE = "identify_code";
	public static final String FIELD_PERSON_REMARK = "remark";
	public static final String FIELD_PERSON_IMSI = "imsi";
	public static final String FIELD_PERSON_FORCE_OFFLINE = "force_offline";
	public static final String FIELD_PERSON_SEQUENCE = "sequence";
	public static final String FIELD_PERSON_UPDATE_TIME = "update_time";
	public static final String SQL_PERSON_CREATE_TABLE = "create table " + TB_PERSON + " ("
			+ FIELD_PERSON_ID + " integer primary key autoincrement, " + FIELD_PERSON_ALIAS
			+ " text," + FIELD_PERSON_ORG_CODE + " text," + FIELD_PERSON_NAME + " text," 
			+ FIELD_PERSON_IDENTIFY_CODE + " text," + FIELD_PERSON_REMARK + " text,"
			+ FIELD_PERSON_IMSI + " text," + FIELD_PERSON_FORCE_OFFLINE + " text,"
			+ FIELD_PERSON_SEQUENCE + " text," + FIELD_PERSON_UPDATE_TIME + " text)";

	public static final String TB_ROLE = "role";
	public static final String FIELD_ROLE_ID = "id";
	public static final String FIELD_ROLE_NAME = "role_name";
	public static final String FIELD_ROLE_REMARK = "remark";
	public static final String FIELD_ROLE_UPDATE_TIME = "update_time";
	public static final String SQL_ROLE_CREATE_TABLE = "create table " + TB_ROLE + " ("
			+ FIELD_ROLE_ID + " integer primary key autoincrement, " + FIELD_ROLE_NAME + " text,"
			+ FIELD_ROLE_REMARK + " text," + FIELD_ROLE_UPDATE_TIME + " text)";

	public static final String TB_ROLE_PERSON = "role_person";
	public static final String FIELD_ROLE_PERSON_ID = "id";
	public static final String FIELD_ROLE_PERSON_PID = "person_id";
	public static final String FIELD_ROLE_PERSON_RID = "role_id";
	public static final String SQL_ROLE_PERSON_CREATE_TABLE = "create table " + TB_ROLE_PERSON
			+ " (" + FIELD_ROLE_PERSON_ID + " integer primary key autoincrement, "
			+ FIELD_ROLE_PERSON_PID + " text," + FIELD_ROLE_PERSON_RID + " text)";

	public static final String TB_PERMISSION = "permission";
	public static final String FIELD_PERMISSION_ID = "id";
	public static final String FIELD_PERMISSION_MENU_CODE = "Menu_code";
	public static final String FIELD_PERMISSION_CODE = "code";
	public static final String FIELD_PERMISSION_NAME = "name";
	public static final String FIELD_PERMISSION_ROLE_ID = "Role_id";
	public static final String SQL_PERMISSION_CREATE_TABLE = "create table " + TB_PERMISSION + " ("
			+ FIELD_PERMISSION_ID + " integer primary key autoincrement, "
			+ FIELD_PERMISSION_MENU_CODE + " text," + FIELD_PERMISSION_CODE + " text,"
			+ FIELD_PERMISSION_NAME + " text," + FIELD_PERMISSION_ROLE_ID + " text)";

	public static final String TB_LOG = "tb_log";
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

	public static final String TB_DICTIONARY = "dictionary";
	public static final String FIELD_DIC_ID = "id";
	public static final String FIELD_DIC_CODE = "code";
	public static final String FIELD_DIC_NAME = "name";
	public static final String SQL_DIC_CREATE_TABLE = "create table " + TB_DICTIONARY + " ("
			+ FIELD_DIC_ID + " integer primary key autoincrement, " + FIELD_DIC_CODE + " text,"
			+ FIELD_DIC_NAME + " text)";

	public static final String TB_DIC_DATA = "dic_data";
	public static final String FIELD_DICDATA_ID = "Id";
	public static final String FIELD_DICDATA_DATA_CODE = "data_code";
	public static final String FIELD_DICDATA_DATA_VALUE = "data_value";
	public static final String FIELD_DICDATA_DICTIONARY_CODE = "dictionary_code";
	public static final String SQL_DIC_DATA_CREATE_TABLE = "create table " + TB_DIC_DATA + " ("
			+ FIELD_DICDATA_ID + " integer primary key autoincrement, " + FIELD_DICDATA_DATA_CODE
			+ " text," + FIELD_DICDATA_DATA_VALUE + " text," + FIELD_DICDATA_DICTIONARY_CODE
			+ " text)";

	public static final String TB_TASK = "task_info";
	public static final String FIELD_TASKINFO_ID = "id";
	public static final String FIELD_TASKINFO_WEATHER = "weather";
	public static final String FIELD_TASKINFO_NAME = "name";

	public static final String FIELD_TASKINFO_POWER_CUT_RANGE = "power_cut_range";
	public static final String FIELD_TASKINFO_EFFECT_EARA = "effect_eara";
	public static final String FIELD_TASKINFO_CONTENT = "content";
	public static final String FIELD_TASKINFO_RESPONSIBILITY_USER = "responsibility_user";

	public static final String FIELD_TASKINFO_PLAN_START_TIME = "plan_start_time";
	public static final String FIELD_TASKINFO_PLAN_END_TIME = "plan_end_time";
	public static final String FIELD_TASKINFO_START_TIME = "start_time";
	public static final String FIELD_TASKINFO_END_TIME = "end_time";
	public static final String FIELD_TASKINFO_CATEGORY = "category";
	public static final String FIELD_TASKINFO_IS_PUBLISH = "is_publish";
	public static final String FIELD_TASKINFO_SPECIAL = "special";
	public static final String FIELD_TASKINFO_LEADER = "leader";

	public static final String FIELD_TASKINFO_MEASURES = "measures";
	public static final String FIELD_TASKINFO_DOMAIN = "domain";
	public static final String FIELD_TASKINFO_IS_POWER_CUT = "is_power_cut";
	public static final String FIELD_TASKINFO_CUT_TYPE = "cut_type";
	public static final String FIELD_TASKINFO_IMPLEMENT_ORG = "implement_org";

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
	public static final String FIELD_TASKINFO_HISTORY_ID = "history_id";
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
			+ FIELD_TASKINFO_PLAN_TYPE + " text," + FIELD_TASKINFO_CREATOR_ID + " text,"
			+ FIELD_TASKINFO_CREATOR_TIME + " text," + FIELD_TASKINFO_IS_KEEP + " text,"
			+ FIELD_TASKINFO_STATUS + " text," + FIELD_TASKINFO_EXAMINE_ID + " text," 
			+ FIELD_TASKINFO_APPROVE_ID + " text," + FIELD_TASKINFO_UPDATE_ID + " text," + FIELD_TASKINFO_HISTORY_ID + " text,"
			+ FIELD_TASKINFO_UPDATE_TIME + " text)";

	public static final String TB_TASK_STANDARD = "task_standard";
	public static final String FIELD_TASK_STANDARD_ID = "id";
	public static final String FIELD_TASK_STANDARD_STANDARD = "standard";
	public static final String FIELD_TASK_STANDARD_TOTAL_SCORE = "total_score";
	public static final String FIELD_TASK_STANDARD_CAREGORE = "category";
	public static final String SQL_TASK_STANDARD_CREATE_TABLE = "create table " + TB_TASK_STANDARD
			+ " (" + FIELD_TASK_STANDARD_ID + " integer primary key autoincrement, "
			+ FIELD_TASK_STANDARD_STANDARD + " text," + FIELD_TASK_STANDARD_TOTAL_SCORE + " text,"
			+ FIELD_TASK_STANDARD_CAREGORE + " text)";

	public static final String TB_TASK_EVALUATE = "task_evaluate";
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

	public static final String TB_TASK_ATTACHMENT = "task_attachment";
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

	public static final String TB_TASK_INSTRUCTIONS = "task_instructions";
	public static final String FIELD_TASK_INSTRUCTIONS_ID = "id";
	public static final String FIELD_TASK_INSTRUCTIONS_TASK_ID = "task_id";
	public static final String FIELD_TASK_INSTRUCTIONS_CONTENT = "content";
	public static final String FIELD_TASK_INSTRUCTIONS_SEND_ID = "send_id";
	public static final String FIELD_TASK_INSTRUCTIONS_SEND_TIME = "send_time";
	
	public static final String SQL_TASK_INSTRUCTIONS_CREATE_TABLE = "create table "
			+ TB_TASK_INSTRUCTIONS + " (" + FIELD_TASK_INSTRUCTIONS_ID
			+ " integer primary key autoincrement, " + FIELD_TASK_INSTRUCTIONS_TASK_ID + " text,"
			+ FIELD_TASK_INSTRUCTIONS_CONTENT + " text," + FIELD_TASK_INSTRUCTIONS_SEND_ID
			+ " text," + FIELD_TASK_INSTRUCTIONS_SEND_TIME + " text)";

	public static final String TB_TASK_INSTRUCTIONS_RECEIVE = "receive";
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

	public static final String TB_TASK_INSTRUCTIONS_ATTACHMENT = "ins_att";
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

	// ====================================================================================
	// ====================================================================================
	// ====================================================================================
	// ====================================================================================
	// ==============================弃用 start
	// 表名 org_code
	public static final String TABLE_ORG_CODE = "org_code";
	// 字段
	public static final String FIELD_ORG_CODE_ID = "id";
	public static final String FIELD_ORG_CODE_ORG_CODE = "org_code";
	public static final String FIELD_ORG_CODE_DESCRIPTION = "description";
	// 创建表的SQL
	public static final String SQL_ORG_CODE_CREATE_TABLE = "create table " + TABLE_ORG_CODE + " ("
			+ FIELD_ORG_CODE_ID + " integer primary key autoincrement, " + FIELD_ORG_CODE_ORG_CODE
			+ " text," + FIELD_ORG_CODE_DESCRIPTION + " text)";

	// 表名 org_code_person
	public static final String TABLE_ORG_PERSON = "org_code_person";
	// 字段
	public static final String FIELD_ORG_PERSON_ID = "id";
	public static final String FIELD_ORG_PERSON_ORG_CODE = "org_code";
	public static final String FIELD_ORG_PERSON_USER_ID = "user_id";
	public static final String FIELD_ORG_PERSON_USER_NAME = "user_name";
	public static final String FIELD_ORG_PERSON_REMARK = "remark";
	public static final String FIELD_ORG_PERSON_CONTACTS = "contacts";
	public static final String FIELD_ORG_PERSON_NAME = "name";
	public static final String SQL_ORG_PERSON_CREATE_TABLE = "create table " + TABLE_ORG_PERSON
			+ " (" + FIELD_ORG_PERSON_ID + " integer primary key autoincrement, "
			+ FIELD_ORG_PERSON_USER_ID + " text," + FIELD_ORG_PERSON_ORG_CODE + " text,"
			+ FIELD_ORG_PERSON_REMARK + " text," + FIELD_ORG_PERSON_CONTACTS + " text,"
			+ FIELD_ORG_PERSON_USER_NAME + " text, " + FIELD_ORG_PERSON_NAME + " text)";
	// 表名 myinfo
	public static final String TABLE_MY_INFO = "myinfo";
	// 字段
	public static final String FIELD_MY_INFO_ID = "id";
	public static final String FIELD_MY_INFO_USERNAME = "user_name";
	public static final String FIELD_MY_INFO_NAME = "name";
	public static final String FIELD_MY_INFO_DES = "description";
	public static final String FIELD_MY_INFO_REMARK = "remark";
	public static final String FIELD_MY_INFO_CONTACTS = "contacts";
	// 创建表的SQL
	public static final String SQL_MY_INFO_CREATE_TABLE = "create table " + TABLE_MY_INFO + " ("
			+ FIELD_MY_INFO_ID + " integer primary key autoincrement, " + FIELD_MY_INFO_USERNAME
			+ " text," + FIELD_MY_INFO_NAME + " text," + FIELD_MY_INFO_DES + " text,"
			+ FIELD_MY_INFO_REMARK + " text," + FIELD_MY_INFO_CONTACTS + " text)";

	// 表名 affiar
	public static final String TABLE_AFFIARINFO = "affair_info";
	// 字段
	public static final String FIELD_AFFIARINFO_ID = "id";
	public static final String FIELD_AFFIARINFO_AFFAIR_ID = "affiarid";
	// （1：任务 2：请示 3：通知）
	public static final String FIELD_AFFIARINFO_TYPE = "type";
	public static final String FIELD_AFFIARINFO_SENDERID = "senderid";
	public static final String FIELD_AFFIARINFO_DES = "description";
	public static final String FIELD_AFFIARINFO_TOPIC = "topic";
	public static final String FIELD_AFFIARINFO_CREATETIME = "createtime";
	public static final String FIELD_AFFIARINFO_ENDTIME = "endtime";
	public static final String FIELD_AFFIARINFO_COMPLETETIME = "completetime";
	public static final String FIELD_AFFIARINFO_READTIME = "readtime";
	// （1-新建，2-置完成（手动），3-置延误（自动） ，4-修改截止日期）
	public static final String FIELD_AFFIARINFO_LAST_OPERATE_TYPE = "lastoperatetype";
	public static final String FIELD_AFFIARINFO_LAST_OPERATE_TIME = "lastoperatetime";
	public static final String FIELD_AFFIARINFO_UPDATETIME = "updatetime";
	/**
	 * [ { "at":"XXXXXXXX", //附件类型（1：文本 2：图片3：录像4：录音5 ：GPS） "u":"XXXXXXXX"
	 * //附件链接 },… ] )
	 */
	public static final String FIELD_AFFIARINFO_ATTACHMENT = "attachment";
	// 创建表的SQL
	public static final String SQL_AFFAIRINFO_CREATE_TABLE = "create table " + TABLE_AFFIARINFO
			+ " (" + FIELD_AFFIARINFO_ID + " integer primary key autoincrement, "
			+ FIELD_AFFIARINFO_AFFAIR_ID + " text," + FIELD_AFFIARINFO_TYPE + " text,"
			+ FIELD_AFFIARINFO_SENDERID + " text," + FIELD_AFFIARINFO_DES + " text,"
			+ FIELD_AFFIARINFO_TOPIC + " text," + FIELD_AFFIARINFO_CREATETIME + " text,"
			+ FIELD_AFFIARINFO_ENDTIME + " text," + FIELD_AFFIARINFO_COMPLETETIME + " text,"
			+ FIELD_AFFIARINFO_READTIME + " text," + FIELD_AFFIARINFO_LAST_OPERATE_TYPE + " text,"
			+ FIELD_AFFIARINFO_LAST_OPERATE_TIME + " text," + FIELD_AFFIARINFO_UPDATETIME + " text,"
			+ FIELD_AFFIARINFO_ATTACHMENT + " text)";

	// 表名 personOnDuty
	public static final String TABLE_PERSON_ON_DUTY = "person_on_duty";
	// 字段
	public static final String FIELD_POD_ID = "id";
	public static final String FIELD_POD_AID = "affair_id";
	public static final String FIELD_POD_PID = "person_id";
	// (1:责任人，2:抄送人)
	public static final String FIELD_POD_TYPE = "type";
	public static final String FIELD_POD_UT = "update_time";
	// 创建表的SQL
	public static final String SQL_POD_CREATE_TABLE = "create table " + TABLE_PERSON_ON_DUTY + " ("
			+ FIELD_POD_ID + " integer primary key autoincrement, " + FIELD_POD_AID + " text,"
			+ FIELD_POD_PID + " text," + FIELD_POD_TYPE + " text," + FIELD_POD_UT + " text)";

	// 表名 attachment
	public static final String TABLE_ATTACHMENT = "attachment";
	// 字段
	public static final String FIELD_ATTACHMENT_ID = "id";
	public static final String FIELD_ATTACHMENT_ATTACHMENT_ID = "attachment_id";
	// (1：文本 2：图片3：录像4：录音5：GPS)
	public static final String FIELD_ATTACHMENT_TYPE = "type";
	public static final String FIELD_ATTACHMENT_URL = "url";
	// 创建表的SQL
	public static final String SQL_ATTACHMENT_CREATE_TABLE = "create table " + TABLE_ATTACHMENT
			+ " (" + FIELD_ATTACHMENT_ID + " integer primary key autoincrement, "
			+ FIELD_ATTACHMENT_ATTACHMENT_ID + " text," + FIELD_ATTACHMENT_TYPE + " text,"
			+ FIELD_ATTACHMENT_URL + " text)";

	// 表名 Message
	public static final String TABLE_MESSAGE = "message";
	// 字段
	public static final String FIELD_MESSAGE_ID = "id";
	public static final String FIELD_MESSAGE_MESSAGE_ID = "mid";
	// 消息类型0.普通个人聊天消息1.基本群组消息 2.非基本群组消息3.会议记录消息 4.事务反馈消息
	public static final String FIELD_MESSAGE_TYPE = "type";
	public static final String FIELD_MESSAGE_SENDER_ID = "sender_id";
	public static final String FIELD_MESSAGE_RELATION_ID = "relation_id";
	public static final String FIELD_MESSAGE_SEND_TIME = "send_time";
	public static final String FIELD_MESSAGE_CONTENT = "content";
	// (1：文本 2：图片3：录像4：录音5：GPS)
	public static final String FIELD_MESSAGE_ATTACHMENT_TYPE = "attachment_type";
	public static final String FIELD_MESSAGE_ATTACHMENT_URL = "attachment_url";
	public static final String FIELD_MESSAGE_UPDATE_TIME = "update_time";
	public static final String FIELD_MESSAGE_READTIME = "readtime";
	// 创建表的SQL
	public static final String SQL_MESSAGE_CREATE_TABLE = "create table " + TABLE_MESSAGE + " ("
			+ FIELD_MESSAGE_ID + " integer primary key autoincrement, " + FIELD_MESSAGE_MESSAGE_ID
			+ " text," + FIELD_MESSAGE_TYPE + " text," + FIELD_MESSAGE_SENDER_ID + " text,"
			+ FIELD_MESSAGE_RELATION_ID + " text," + FIELD_MESSAGE_SEND_TIME + " text,"
			+ FIELD_MESSAGE_CONTENT + " text," + FIELD_MESSAGE_ATTACHMENT_TYPE + " text,"
			+ FIELD_MESSAGE_ATTACHMENT_URL + " text," + FIELD_MESSAGE_UPDATE_TIME + " text,"
			+ FIELD_MESSAGE_READTIME + " text)";

	// 表名 conference
	public static final String TABLE_CONFERENCE = "conference";
	// 字段
	public static final String FIELD_CONFERENCE_ID = "id";
	public static final String FIELD_CONFERENCE_CONFERENCE_ID = "cid";
	public static final String FIELD_CONFERENCE_NAME = "name";
	public static final String FIELD_CONFERENCE_SPONSORID = "sponsor_id";
	public static final String FIELD_CONFERENCE_CONVENE_TIME = "convene_time";
	// （1：通过手机，2：通过Web（PC或移动终端），3 ：通过PC客户端，4：系统自动处置，5：其他）
	public static final String FIELD_CONFERENCE_FROM = "type";
	public static final String FIELD_CONFERENCE_START_TIME = "start_time";
	public static final String FIELD_CONFERENCE_ENDTIME = "end_time";
	public static final String FIELD_CONFERENCE_REMARK = "remark";
	// 创建表的SQL
	public static final String SQL_CONFERENCE_CREATE_TABLE = "create table " + TABLE_CONFERENCE
			+ " (" + FIELD_CONFERENCE_ID + " integer primary key autoincrement, "
			+ FIELD_CONFERENCE_CONFERENCE_ID + " text," + FIELD_CONFERENCE_NAME + " text,"
			+ FIELD_CONFERENCE_SPONSORID + " text," + FIELD_CONFERENCE_CONVENE_TIME + " text,"
			+ FIELD_CONFERENCE_FROM + " text," + FIELD_CONFERENCE_START_TIME + " text,"
			+ FIELD_CONFERENCE_ENDTIME + " text," + FIELD_CONFERENCE_REMARK + " text)";

	// ConferencePerson(id,cid,uid,type//成员角色（1：发言人，2：收听人，3：视频源，4：发言+视频源）,
	// response_time,remark)
	public static final String TABLE_CONFERENCE_PERSON = "ConferencePerson";
	public static final String FIELD_CONFERENCE_PERSON_ID = "id";
	public static final String FIELD_CONFERENCE_PERSON_CID = "cid";
	public static final String FIELD_CONFERENCE_PERSON_UID = "uid";
	public static final String FIELD_CONFERENCE_PERSON_TYPE = "type";
	public static final String FIELD_CONFERENCE_PERSON_RESPONSE_TIME = "response_time";
	public static final String FIELD_CONFERENCE_PERSON_REMARK = "remark";
	public static final String SQL_CONFERENCE_PERSON_CREATE_TABLE = "create table "
			+ TABLE_CONFERENCE_PERSON + " (" + FIELD_CONFERENCE_PERSON_ID
			+ " integer primary key autoincrement, " + FIELD_CONFERENCE_PERSON_CID + " text,"
			+ FIELD_CONFERENCE_PERSON_UID + " text," + FIELD_CONFERENCE_PERSON_TYPE + " text,"
			+ FIELD_CONFERENCE_PERSON_RESPONSE_TIME + " text," + FIELD_CONFERENCE_PERSON_REMARK
			+ " text)";

	// 表名 Group
	public static final String TABLE_GROUP = "group_table";
	// 字段
	public static final String FIELD_GROUP_ID = "id";
	public static final String FIELD_GROUP_GROUP_ID = "cid";
	public static final String FIELD_GROUP_TYPE = "type";
	public static final String FIELD_GROUP_NAME = "name";
	public static final String FIELD_GROUP_CREATE_TIME = "create_time";
	public static final String FIELD_GROUP_UPDATE_TIME = "update_time";
	public static final String FIELD_GROUP_RIDS = "rids";
	// 创建表的SQL
	public static final String SQL_GROUP_CREATE_TABLE = "create table " + TABLE_GROUP + " ("
			+ FIELD_GROUP_ID + " integer primary key autoincrement, " + FIELD_GROUP_GROUP_ID
			+ " text," + FIELD_GROUP_TYPE + " text," + FIELD_GROUP_NAME + " text,"
			+ FIELD_GROUP_CREATE_TIME + " text," + FIELD_GROUP_UPDATE_TIME + " text,"
			+ FIELD_GROUP_RIDS + " text)";

	// 表名 GPS
	public static final String TABLE_GPS = "gps_table";
	// 字段
	public static final String FIELD_GPS_ID = "id";
	public static final String FIELD_GPS_GPS_ID = "gid";
	public static final String FIELD_GPS_PERSON_ID = "person_id";
	public static final String FIELD_GPS_TIME = "time";
	public static final String FIELD_GPS_LONG = "longitude";
	public static final String FIELD_GPS_LAT = "latitude";
	public static final String FIELD_GPS_TYPE = "type";
	public static final String FIELD_GPS_ACCURACY = "accuracy";
	public static final String FIELD_GPS_HEIGHT = "height";
	public static final String FIELD_GPS_SPEED = "speed";
	public static final String FIELD_GPS_UPDATE_TIME = "update_time";
	// 创建表的SQL
	public static final String SQL_GPS_CREATE_TABLE = "create table " + TABLE_GPS + " ("
			+ FIELD_GPS_ID + " integer primary key autoincrement, " + FIELD_GPS_GPS_ID + " text,"
			+ FIELD_GPS_PERSON_ID + " text," + FIELD_GPS_TIME + " text," + FIELD_GPS_LONG + " text,"
			+ FIELD_GPS_LAT + " text," + FIELD_GPS_TYPE + " text," + FIELD_GPS_ACCURACY + " text,"
			+ FIELD_GPS_HEIGHT + " text," + FIELD_GPS_SPEED + " text," + FIELD_GPS_UPDATE_TIME
			+ " text)";
	

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
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.v(LOG_TAG, "SQLite: onUpgrade");
	}

}
