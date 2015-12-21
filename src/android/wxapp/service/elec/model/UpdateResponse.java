package android.wxapp.service.elec.model;

import java.util.List;

import android.wxapp.service.elec.model.bean.UpdateData;

public class UpdateResponse extends BaseResponseModel {
	List<UpdateData> d;

	public UpdateResponse(String s, List<UpdateData> d) {
		super(s);
		this.d = d;
	}

	public UpdateResponse() {
		super();
	}

	public List<UpdateData> getD() {
		return d;
	}

	public void setD(List<UpdateData> d) {
		this.d = d;
	}

	
}
