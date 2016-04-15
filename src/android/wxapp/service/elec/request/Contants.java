package android.wxapp.service.elec.request;

import java.io.File;

/**
 * 接口url定义类
 * 
 * @author JerryLiu
 *
 */
public class Contants {

	// TIP：所有的url结尾均带
	public static String PORT = "8080";
	public static String SERVER = "58.50.28.139";

	public static String HFS_SERVER = SERVER;
	public static String HFS_PORT = "9898";
	public static String HFS_URL = "http://" + HFS_SERVER + ":" + HFS_PORT + "/ScheduleFileServer";

	public static String MQTT_SERVER = SERVER;
	public static String MQTT_PORT = "1883";

	public static String SCHEDULE_SERVER_WAN = SERVER;
	public static String SCHEDULE_SERVER_LAN = "192.168.0.208";
	public static int SCHEDULE_PORT = 5060;

	// http://120.26.78.7:88/supervise 阿里 http://58.50.28.139:8080/supervise荆州
	// http://120.26.78.7:8088/supervise
	/////////////////////////////////////////////////////////

	// public static String SERVER = "120.26.78.7";
	// public static String PORT = "8088";
	//
	// public static String HFS_SERVER = SERVER;
	// public static String HFS_PORT = "3000";
	// public static String HFS_URL = "http://" + HFS_SERVER + ":" + HFS_PORT +
	// "/ScheduleFileServer";
	//
	// public static String MQTT_SERVER = SERVER;
	// public static String MQTT_PORT = "1883";
	// // public static String MQTT_SERVER = "120.26.78.7";
	// // public static String MQTT_PORT = "1883";
	//
	// public static String SCHEDULE_SERVER_WAN = SERVER;
	// // public static String SCHEDULE_SERVER_LAN = "192.168.0.208";
	// public static String SCHEDULE_SERVER_LAN = SERVER;
	// public static int SCHEDULE_PORT = 5060;

	///////////////////////////////////////////////////////
	public static String SERVER_URL = "http://" + Contants.SERVER + ":" + Contants.PORT + File.separator;
	// 模块名称
	public static final String MODEL_NAME = "supervise/mobile" + File.separator;

	public static final String LOGIN_METHOD = "mlogin.do?";
	public static final String LOGIN_PARAM = "loginParameter=";
	public static final String UPDATE_METHOD = "mupdate.do?";
	public static final String UPDATE_PARAM = "updateParameter=";
	public static final String CREATEPLANTASK_METHOD = "mcreateplantask.do?";
	public static final String CREATEPLANTASK_PARAM = "planTaskParameter=";
	public static final String CREATETASKINS_METHOD = "mcreateins.do?";
	public static final String CREATETASKINS_PARAM = "insParameter=";
	public static final String UPLOAD_TASK_ATTACHMENT_METHOD = "mupload.do?";
	public static final String UPLOAD_TASK_ATTACHMENT_PARAM = "uploadParameter=";
	public static final String START_TASK_METHOD = "mtaskstart.do?";
	public static final String START_TASK_PARAM = "taskParameter=";
	public static final String END_TASK_METHOD = "mtaskend.do?";
	public static final String END_TASK_PARAM = "taskParameter=";
	public static final String DELETE_TASK_METHOD = "mtaskdel.do?";
	public static final String DELETE_TASK_PARAM = "taskParameter=";
	public static final String HEART_BEAT_METHOD = "mstatus.do?";
	public static final String HEART_BEAT_PARAM = "statusParameter=";

	// 服务器是否返回成功标志
	public static final String RESULT_SUCCESS = "0";
	public static final String RESULT_MORE = "-1";
}
