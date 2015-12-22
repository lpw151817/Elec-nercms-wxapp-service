package android.wxapp.service.elec.model.bean;

public class Attachments {
		String type;
		String url;
		public Attachments(String type, String url) {
			super();
			this.type = type;
			this.url = url;
		}
		public Attachments() {
			super();
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}

		
}
