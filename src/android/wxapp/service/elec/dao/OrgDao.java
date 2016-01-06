package android.wxapp.service.elec.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

public class OrgDao extends BaseDAO {

	public OrgDao(Context context) {
		super(context);
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
		return r;
	}

	private List<Org> getAllPersons() {
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
		return r;
	}
	// /////////////////以上用于组织结构树使用//////////////////////////
}
