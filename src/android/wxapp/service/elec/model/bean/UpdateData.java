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

		public String getTable() {
			return table;
		}

		public void setTable(String table) {
			this.table = table;
		}

		public List<Object> getData() {
			return data;
		}

		public void setData(List<Object> data) {
			this.data = data;
		}



		
}
