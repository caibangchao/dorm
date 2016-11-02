package cbc.model;

public class Dorm {
	private String id;
	private String name;
	private int bedsum;
	private int usedbed;
	private String houseparent;
	private String remarks;
	private String update_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBedsum() {
		return bedsum;
	}
	public void setBedsum(int bedsum) {
		this.bedsum = bedsum;
	}
	public int getUsedbed() {
		return usedbed;
	}
	public void setUsedbed(int usedbed) {
		this.usedbed = usedbed;
	}
	public String getHouseparent() {
		return houseparent;
	}
	public void setHouseparent(String houseparent) {
		this.houseparent = houseparent;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
}