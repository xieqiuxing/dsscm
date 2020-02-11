package cn.dsscm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
	private Long id;// ID
	private String name;// 商品名
	private String description;// 描述
	private Float price;// 单价
	private String placement;// 摆放位置
	private Long stock;// 数量
	private Long categoryLevel1Id;// 一级分类
	private Long categoryLevel2Id;// 二级分类
	private Long categoryLevel3Id;// 三级分类
	private String fileName;// 图片名称
	private int isDelete; // 是否删除(1：删除 0：未删除)
	private Integer createdBy; // 创建者
	private Date creationDate; // 创建时间
	private Integer modifyBy; // 更新者
	private Date modifyDate;// 更新时间
	private Float cost;
	private String p1Name;
	private String p2Name;
	private String p3Name;
	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", placement=" + placement
				+ ", stock=" + stock + ", categoryLevel1Id=" + categoryLevel1Id
				+ ", categoryLevel2Id=" + categoryLevel2Id
				+ ", categoryLevel3Id=" + categoryLevel3Id + ", fileName="
				+ fileName + ", isDelete=" + isDelete + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate + ", modifyBy="
				+ modifyBy + ", modifyDate=" + modifyDate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getCategoryLevel1Id() {
		return categoryLevel1Id;
	}

	public void setCategoryLevel1Id(Long categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}

	public Long getCategoryLevel2Id() {
		return categoryLevel2Id;
	}

	public void setCategoryLevel2Id(Long categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}

	public Long getCategoryLevel3Id() {
		return categoryLevel3Id;
	}

	public void setCategoryLevel3Id(Long categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getP1Name() {
		return p1Name;
	}

	public void setP1Name(String p1Name) {
		this.p1Name = p1Name;
	}

	public String getP2Name() {
		return p2Name;
	}

	public void setP2Name(String p2Name) {
		this.p2Name = p2Name;
	}

	public String getP3Name() {
		return p3Name;
	}

	public void setP3Name(String p3Name) {
		this.p3Name = p3Name;
	}



}
