package android.wxapp.service.elec.model.bean;

import java.util.List;

public class UpdateData {
		String table;
		List<Object> data;
		
		public UpdateData(String table, List<Object> data) {
			super();
			this.table = table;
			this.data = data;
		}
		
		public UpdateData() {
			super();
		}



		
}
