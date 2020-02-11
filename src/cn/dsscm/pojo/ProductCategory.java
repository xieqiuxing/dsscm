package cn.dsscm.pojo;

import java.io.Serializable;
import java.util.List;

public class ProductCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// ID
	private String name;// 名称
	private Long parentId;// 父级ID
	private int type;// 级别(1:一级 2：二级 3：三级)',
	private String iconClass;// 图标
	private String pc1Name;
	private String pc2Name;
	private String pc3Name;
	private List<ProductCategory> productCategories;
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(Long id, String name, Long parentId, int type,
			String iconClass) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
	}

	

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", type=" + type + ", iconClass=" + iconClass
				+ ", pc1Name=" + pc1Name + ", pc2Name=" + pc2Name
				+ ", pc3Name=" + pc3Name + ", productCategories="
				+ productCategories + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	


	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getPc1Name() {
		return pc1Name;
	}

	public void setPc1Name(String pc1Name) {
		this.pc1Name = pc1Name;
	}

	public String getPc2Name() {
		return pc2Name;
	}

	public void setPc2Name(String pc2Name) {
		this.pc2Name = pc2Name;
	}

	public String getPc3Name() {
		return pc3Name;
	}

	public void setPc3Name(String pc3Name) {
		this.pc3Name = pc3Name;
	}

}
