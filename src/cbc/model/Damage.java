package cbc.model;

public class Damage {

	private String id;
	private String question;  //�����
	private String st_date;   //������
	private String fi_date;   //�޸�ʱ��
	private String remarks;
	private String isok;      //�޸��Ƿ�ɹ�
	private String dorm_id;
	private String update_date; //����ʱ��
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSt_date() {
		return st_date;
	}
	public void setSt_date(String st_date) {
		this.st_date = st_date;
	}
	public String getFi_date() {
		return fi_date;
	}
	public void setFi_date(String fi_date) {
		this.fi_date = fi_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIsok() {
		return isok;
	}
	public void setIsok(String isok) {
		this.isok = isok;
	}
	public String getDorm_id() {
		return dorm_id;
	}
	public void setDorm_id(String dorm_id) {
		this.dorm_id = dorm_id;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
}
