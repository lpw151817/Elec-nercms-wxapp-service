package android.wxapp.service.elec.dao;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import android.content.Context;
import android.database.Cursor;
import android.wxapp.service.elec.model.bean.table.TB_SYS_Person;

public class OrgDao extends BaseDAO {

	public OrgDao(Context context) {
		super(context);
	}

	public String getIdFromOc(String oc) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_ORG, null, DatabaseHelper.FIELD_ORG_ORG_CODE + " = ?",
				new String[] { oc }, null, null, null);
		String result = null;
		if (c.moveToFirst()) {
			result = getData(c, DatabaseHelper.FIELD_ORG_ID);
		}
		c.close();
		// db.close();
		return result;
	}

	public List<Org> convert(List<TB_SYS_Person> data) {
		List<Org> result = new ArrayList<Org>();
		for (TB_SYS_Person tb_SYS_Person : data) {
			result.add(new Org("p" + tb_SYS_Person.getId(), "", tb_SYS_Person.getName()));
		}
		return result;
	}

	/**
	 * 
	 * @param type
	 *            0,现场负责人员；1,检查人员
	 * @return
	 */
	public List<TB_SYS_Person> getPersons(String type) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_PERSON, null,
				DatabaseHelper.FIELD_PERSON_TYPE + " = ?", new String[] { type }, null, null, null);
		List<TB_SYS_Person> result = new ArrayList<TB_SYS_Person>();
		while (c.moveToNext()) {
			if (getData(c, DatabaseHelper.FIELD_PERSON_NAME).contains("管理员"))
				continue;
			result.add(new TB_SYS_Person(getData(c, DatabaseHelper.FIELD_PERSON_ID),
					getData(c, DatabaseHelper.FIELD_PERSON_ALIAS),
					getData(c, DatabaseHelper.FIELD_PERSON_ORG_CODE),
					getData(c, DatabaseHelper.FIELD_PERSON_NAME),
					getData(c, DatabaseHelper.FIELD_PERSON_CONTACT),
					getData(c, DatabaseHelper.FIELD_PERSON_TYPE),
					getData(c, DatabaseHelper.FIELD_PERSON_IDENTIFY_CODE),
					getData(c, DatabaseHelper.FIELD_PERSON_REMARK),
					getData(c, DatabaseHelper.FIELD_PERSON_IMSI),
					getData(c, DatabaseHelper.FIELD_PERSON_FORCE_OFFLINE),
					getData(c, DatabaseHelper.FIELD_PERSON_SEQUENCE),
					getData(c, DatabaseHelper.FIELD_PERSON_UPDATE_TIME)));
		}
		c.close();
		// db.close();
		return result;
	}

	public TB_SYS_Person getPerson(String pid) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_PERSON, null, DatabaseHelper.FIELD_PERSON_ID + " = ?",
				new String[] { pid }, null, null, null);
		try {
			if (c.moveToFirst()) {
				return new TB_SYS_Person(getData(c, DatabaseHelper.FIELD_PERSON_ID),
						getData(c, DatabaseHelper.FIELD_PERSON_ALIAS),
						getData(c, DatabaseHelper.FIELD_PERSON_ORG_CODE),
						getData(c, DatabaseHelper.FIELD_PERSON_NAME),
						getData(c, DatabaseHelper.FIELD_PERSON_CONTACT),
						getData(c, DatabaseHelper.FIELD_PERSON_TYPE),
						getData(c, DatabaseHelper.FIELD_PERSON_IDENTIFY_CODE),
						getData(c, DatabaseHelper.FIELD_PERSON_REMARK),
						getData(c, DatabaseHelper.FIELD_PERSON_IMSI),
						getData(c, DatabaseHelper.FIELD_PERSON_FORCE_OFFLINE),
						getData(c, DatabaseHelper.FIELD_PERSON_SEQUENCE),
						getData(c, DatabaseHelper.FIELD_PERSON_UPDATE_TIME));
			} else
				return null;
		} finally {
			c.close();
			// db.close();
		}
	}

	public Org getOrg(String id) {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.query(DatabaseHelper.TB_ORG, null, DatabaseHelper.FIELD_ORG_ID + " = ?",
				new String[] { id }, null, null, null);
		try {
			if (c.moveToFirst()) {
				String name = getData(c, DatabaseHelper.FIELD_ORG_ORG_NAME);
				String org_code = getData(c, DatabaseHelper.FIELD_ORG_ORG_CODE);
				if (org_code.length() == 1)
					return new Org("o" + org_code, 0 + "", name);
				else
					return new Org("o" + org_code,
							"o" + org_code.substring(0, org_code.length() - 1), name);
			}
			return null;
		} finally {
			c.close();
			// db.close();
		}

	}

	// /////////////////以下用于组织结构树使用//////////////////////////
	public List<Org> getOrg2() {
		List<Org> result = new ArrayList<Org>();
		result.addAll(getAllOrgs());
		result.addAll(getAllPersons());
		return result;
	}

	public List<Org> getAllOrgs() {
		db = dbHelper.getReadableDatabase();
		Cursor c = db.rawQuery("SELECT * from " + DatabaseHelper.TB_ORG, null);
		List<Org> r = new ArrayList<Org>();
		while (c.moveToNext()) {
			String name = getData(c, DatabaseHelper.FIELD_ORG_ORG_NAME);
			String org_code = getData(c, DatabaseHelper.FIELD_ORG_ORG_CODE);
			if (org_code.length() == 1)
				r.add(new Org("o" + org_code, 0 + "", name));
			else
				r.add(new Org("o" + org_code, "o" + org_code.substring(0, org_code.length() - 1),
						name));
		}
		c.close();
		// db.close();
		return r;
	}

	public List<Org> getAllPersons() {
		db = dbHelper.getReadableDatabase();
		// SELECT * from OrgNode WHERE org_code LIKE '_';
		Cursor c = db.rawQuery("SELECT * from " + DatabaseHelper.TB_PERSON, null);
		List<Org> r = new ArrayList<Org>();
		while (c.moveToNext()) {
			String orgcode = getData(c, DatabaseHelper.FIELD_PERSON_ORG_CODE);
			String name = getData(c, DatabaseHelper.FIELD_PERSON_NAME);
			String uid = getData(c, DatabaseHelper.FIELD_PERSON_ID);
			r.add(new Org("p" + uid, "o" + orgcode, name));
		}
		c.close();
		// db.close();
		return r;
	}
	// /////////////////以上用于组织结构树使用//////////////////////////
}
