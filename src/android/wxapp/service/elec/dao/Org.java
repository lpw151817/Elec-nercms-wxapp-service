package android.wxapp.service.elec.dao;

import java.io.Serializable;

import com.imooc.treeview.utils.annotation.TreeNodeId;
import com.imooc.treeview.utils.annotation.TreeNodeLabel;
import com.imooc.treeview.utils.annotation.TreeNodePid;

public class Org implements Serializable {
	@TreeNodeId
	String id;
	@TreeNodePid
	String pid;
	@TreeNodeLabel
	String Title;

	@Override
	public String toString() {
		return "Org [id=" + id + ", pid=" + pid + ", Title=" + Title + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Org(String id, String pid, String title) {
		this.id = id;
		this.pid = pid;
		Title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Org other = (Org) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
