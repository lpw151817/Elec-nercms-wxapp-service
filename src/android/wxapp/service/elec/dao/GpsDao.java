package android.wxapp.service.elec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.renderscript.Type.CubemapFace;
import android.text.TextUtils;
import android.wxapp.service.elec.model.bean.GPS;
import android.wxapp.service.elec.model.bean.table.tb_gps_history;

public class GpsDao extends BaseDAO {

	public GpsDao(Context context) {
		super(context);
	}

	/**
	 * 
	 * @param id
	 * @param person_id
	 * @param ollectionTime
	 * @param longitude
	 * @param latitude
	 * @param gps_type
	 * @param accuracy
	 * @param height
	 * @param speed
	 * @param update_time
	 * @param coordinate
	 * @param remark
	 * @return ·µ»Øid
	 */
	public long saveHistory(String id, String person_id, String ollectionTime, String longitude,
			String latitude, String gps_type, String accuracy, String height, String speed,
			String update_time, String coordinate, String remark) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		if (!TextUtils.isEmpty(id))
			values.put(DatabaseHelper.FIELD_GPS_HISTORY_ID, id);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_PERSON_ID, person_id);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_OLLECTIONTIME, ollectionTime);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_LONGITUDE, longitude);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_LATITUDE, latitude);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_GPS_TYPE, gps_type);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_ACCURACY, accuracy);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_HEIGHT, height);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_SPEED, speed);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_UPDATE_TIME, update_time);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_COORDINATE, coordinate);
		values.put(DatabaseHelper.FIELD_GPS_HISTORY_REMARK, remark);
		return db.insert(DatabaseHelper.TB_GPS_HISTORY, null, values);
	}

	public GPS getHistory(String id) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_GPS_HISTORY, null,
				DatabaseHelper.FIELD_GPS_HISTORY_ID + " = ?", new String[] { id }, null, null,
				null);
		GPS gps = null;
		if (c.moveToFirst()) {
			gps = new GPS(getData(c, DatabaseHelper.FIELD_GPS_HISTORY_PERSON_ID),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_OLLECTIONTIME),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_LONGITUDE),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_LATITUDE),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_GPS_TYPE),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_ACCURACY),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_HEIGHT),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_SPEED),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_UPDATE_TIME),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_COORDINATE),
					getData(c, DatabaseHelper.FIELD_GPS_HISTORY_REMARK));
		}
		c.close();
		return gps;
	}
}
