package cn.dsscm.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	// 订单状态
	public static int STATUS_INITIAL = 1;
	public static int STATUS_PASS = 2;
	public static int STATUS_PREPARE = 3;
	public static int STATUS_SEND = 4;
	public static int STATUS_RECEIVED = 5;

	public static int PAYTYPE_CASH = 1;
	public static int PAYTYPE_NET = 2;

	private Long id;// ID
	private String userName;// 真实姓名
	private String customerPhone; // 顾客联系电话
	private String userAddress;// 收货地址
	private int proCount;// 商品数量
	private Float cost;// 订单总计价格
	private String serialNumber;// 订单号
	private int status;// 订单状态
	private int payType;// 付款方式
	private Integer createdBy; // 创建者
	private Date creationDate; // 创建时间
	private Integer modifyBy; // 更新者
	private Date modifyDate;// 更新时间
	private List<Product> product;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, String userName, String customerPhone,
			String userAddress, int proCount, Float cost, String serialNumber,
			int status, int payType, Integer createdBy, Date creationDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.customerPhone = customerPhone;
		this.userAddress = userAddress;
		this.proCount = proCount;
		this.cost = cost;
		this.serialNumber = serialNumber;
		this.status = status;
		this.payType = payType;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getProCount() {
		return proCount;
	}

	public void setProCount(int proCount) {
		this.proCount = proCount;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	

	@Override
	public String toString() {
		return "Order [id=" + id + ", userName=" + userName
				+ ", customerPhone=" + customerPhone + ", userAddress="
				+ userAddress + ", proCount=" + proCount + ", cost=" + cost
				+ ", serialNumber=" + serialNumber + ", status=" + status
				+ ", payType=" + payType + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + ", product=" + product + "]";
	}

	public String getDisplayStatus() {
		switch (this.status) {
		case 1:
			return "待审核";
		case 2:
			return "审核通过";
		case 3:
			return "配货";
		case 4:
			return "卖家已发货";
		case 5:
			return "已收货";
		default:
			return "待审核";
		}

	}

}
