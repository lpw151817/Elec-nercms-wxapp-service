package android.wxapp.service.elec.request;

import java.io.File;

/**
 * 接口url定义类
 * 
 * @author JerryLiu
 *
 */
public class Contants {

	public static final String HFS_SERVER = "120.26.78.7";
	public static final String HFS_PORT = "3000";
	// private static final String HFS_SERVER = "192.168.101.244";
	// private static final String HFS_PORT = "9898";
	public static final String HFS_URL = "http://" + HFS_SERVER + ":" + HFS_PORT
			+ "/ScheduleFileServer";

	// TIP：所有的url结尾均带/
	public static final String SERVER = "121.40.145.178";
	public static final String PORT = "8080";
	// public static final String SERVER = "192.168.101.244";
	// public static final String PORT = "9003";

	public static final String SERVER_URL = "http://" + SERVER + ":" + PORT + File.separator;

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

	// 服务器是否返回成功标志
	public static final String RESULT_SUCCESS = "0";
	public static final String RESULT_MORE = "-1";
}
