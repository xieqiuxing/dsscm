package cn.dsscm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class News {
	private Long id;//ID
	private String title;//标题
	private String content;//内容
	private Long createdBy;//创建人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd")
	private Date creationDate;//创建时间
	private Long modifyBy;//修改人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd")
	private Date modifyDate;//修改时间
	private String createdCode;//创建人编号
	private String modifyCode;//修改人编号
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(Long id, String title, String content, Long createdBy,
			Date creationDate, Long modifyBy, Date modifyDate,String createdCode,String modifyCode) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.createdCode=createdCode;
		this.modifyCode=modifyCode;
		
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + ",createdCode="+createdCode+",modifyCode="+modifyCode+"]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getcreationDate() {
		return creationDate;
	}
	public void setcreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getCreatedCode() {
		return createdCode;
	}
	public void setCreatedCode(String createdCode) {
		this.createdCode = createdCode;
	}
	public String getModifyCode() {
		return modifyCode;
	}
	public void setModifyCode(String modifyCode) {
		this.modifyCode = modifyCode;
	}
	
}