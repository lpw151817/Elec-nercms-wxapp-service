package android.wxapp.service.elec.model;

public class ConfigBean {
String SERVER,PORT,HFS_PORT,MQTT_PORT,SCHEDULE_SERVER_LAN;
int SCHEDULE_PORT;
public String getSERVER() {
	return SERVER;
}
public void setSERVER(String sERVER) {
	SERVER = sERVER;
}
public String getPORT() {
	return PORT;
}
public void setPORT(String pORT) {
	PORT = pORT;
}
public String getHFS_PORT() {
	return HFS_PORT;
}
public void setHFS_PORT(String hFS_PORT) {
	HFS_PORT = hFS_PORT;
}
public String getMQTT_PORT() {
	return MQTT_PORT;
}
public void setMQTT_PORT(String mQTT_PORT) {
	MQTT_PORT = mQTT_PORT;
}
public String getSCHEDULE_SERVER_LAN() {
	return SCHEDULE_SERVER_LAN;
}
public void setSCHEDULE_SERVER_LAN(String sCHEDULE_SERVER_LAN) {
	SCHEDULE_SERVER_LAN = sCHEDULE_SERVER_LAN;
}
public int getSCHEDULE_PORT() {
	return SCHEDULE_PORT;
}
public void setSCHEDULE_PORT(int sCHEDULE_PORT) {
	SCHEDULE_PORT = sCHEDULE_PORT;
}
public ConfigBean(String sERVER, String pORT, String hFS_PORT, String mQTT_PORT,
		String sCHEDULE_SERVER_LAN, int sCHEDULE_PORT) {
	super();
	SERVER = sERVER;
	PORT = pORT;
	HFS_PORT = hFS_PORT;
	MQTT_PORT = mQTT_PORT;
	SCHEDULE_SERVER_LAN = sCHEDULE_SERVER_LAN;
	SCHEDULE_PORT = sCHEDULE_PORT;
}
public ConfigBean() {
	super();
}
@Override
public String toString() {
	return "ConfigBean [SERVER=" + SERVER + "]";
}

}
