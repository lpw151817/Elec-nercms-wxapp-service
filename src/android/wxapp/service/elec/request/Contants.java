package android.wxapp.service.elec.request;

import java.io.File;

/**
 * �ӿ�url������
 * 
 * @author JerryLiu
 *
 */
public class Contants {
	// TIP�����е�url��β����/
	public static final String SERVER = "121.40.145.178";
	public static final String PORT = "8080";

	public static final String SERVER_URL = "http://" + SERVER + ":" + PORT + File.separator;

	// ģ������
	public static final String MODEL_NAME = "supervise/mobile" + File.separator;

	public static final String LOGIN_METHOD = "mlogin.do?";
	public static final String LOGIN_PARAM = "loginParameter=";
	public static final String UPDATE_METHOD = "mupdate.do?";
	public static final String UPDATE_PARAM = "updateParameter=";
	public static final String CREATEPLANTASK_METHOD = "mcreateplantask.do?";
	public static final String CREATEPLANTASK_PARAM = "planTaskParameter=";
	public static final String CREATETASKINS_METHOD = "mcreateins.do?";
	public static final String CREATETASKINS_PARAM = "insParameter=";
	public static final String UPLOAD_TASK_ATTACHMENT_METHOD = "";
	public static final String UPLOAD_TASK_ATTACHMENT_PARAM = "";

	// �������Ƿ񷵻سɹ���־
	public static final String RESULT_SUCCESS = "0";
	public static final String RESULT_MORE = "-1";
}
