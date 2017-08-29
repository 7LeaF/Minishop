package vo;

public class OrderVo {
	
	private String orderCode;
	private String userIdFk;
	private String productCodePk;
	private int orderCount;
	private String buyerName;
	private String buyerAddress1;
	private String buyerAddress2;
	private int buyerPhone;
	private String buyerEmail;
	private String rcptName;
	private String rcptAddress1;
	private String rcptAddress2;
	private int rcptPhone;
	private String shipMessage;
	private int orderAmount;
	private int orderState;
	private String orderDate;
	
	
	//지워야함
	private String productImage1;
	private String productName;
	private String productMessage;
	private int productSale;
	

	public OrderVo(String productCodePk, int orderAmount, int orderState, String productImage1, String productName,
			String productMessage, int productSale) {
		super();
		this.productCodePk = productCodePk;
		this.orderAmount = orderAmount;
		this.orderState = orderState;
		this.productImage1 = productImage1;
		this.productName = productName;
		this.productMessage = productMessage;
		this.productSale = productSale;
	}


	public OrderVo(String userIdFk, int orderAmount) {
		super();
		this.userIdFk = userIdFk;
		this.orderAmount = orderAmount;
	}
	public OrderVo(String userIdFk, String productCodePk, int orderCount, String buyerName, String buyerAddress1,
			String buyerAddress2, int buyerPhone, String buyerEmail, String rcptName, String rcptAddress1,
			String rcptAddress2, int rcptPhone, String shipMessage) {
		super();
		this.userIdFk = userIdFk;
		this.productCodePk = productCodePk;
		this.orderCount = orderCount;
		this.buyerName = buyerName;
		this.buyerAddress1 = buyerAddress1;
		this.buyerAddress2 = buyerAddress2;
		this.buyerPhone = buyerPhone;
		this.buyerEmail = buyerEmail;
		this.rcptName = rcptName;
		this.rcptAddress1 = rcptAddress1;
		this.rcptAddress2 = rcptAddress2;
		this.rcptPhone = rcptPhone;
		this.shipMessage = shipMessage;
	}
	public OrderVo(){}
	
	
	public String getProductImage1() {
		return productImage1;
	}


	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductMessage() {
		return productMessage;
	}


	public void setProductMessage(String productMessage) {
		this.productMessage = productMessage;
	}


	public int getProductSale() {
		return productSale;
	}


	public void setProductSale(int productSale) {
		this.productSale = productSale;
	}


	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getUserIdFk() {
		return userIdFk;
	}
	public void setUserIdFk(String userIdFk) {
		this.userIdFk = userIdFk;
	}
	public String getProductCodePk() {
		return productCodePk;
	}
	public void setProductCodePk(String productCodePk) {
		this.productCodePk = productCodePk;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerAddress1() {
		return buyerAddress1;
	}
	public void setBuyerAddress1(String buyerAddress1) {
		this.buyerAddress1 = buyerAddress1;
	}
	public String getBuyerAddress2() {
		return buyerAddress2;
	}
	public void setBuyerAddress2(String buyerAddress2) {
		this.buyerAddress2 = buyerAddress2;
	}
	public int getBuyerPhone() {
		return buyerPhone;
	}
	public void setBuyerPhone(int buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getRcptName() {
		return rcptName;
	}
	public void setRcptName(String rcptName) {
		this.rcptName = rcptName;
	}
	public String getRcptAddress1() {
		return rcptAddress1;
	}
	public void setRcptAddress1(String rcptAddress1) {
		this.rcptAddress1 = rcptAddress1;
	}
	public String getRcptAddress2() {
		return rcptAddress2;
	}
	public void setRcptAddress2(String rcptAddress2) {
		this.rcptAddress2 = rcptAddress2;
	}
	public int getRcptPhone() {
		return rcptPhone;
	}
	public void setRcptPhone(int rcptPhone) {
		this.rcptPhone = rcptPhone;
	}
	public String getShipMessage() {
		return shipMessage;
	}
	public void setShipMessage(String shipMessage) {
		this.shipMessage = shipMessage;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
}

/*CREATE TABLE ORDERS(
		 ORDER_CODE VARCHAR2(20),
		 USER_ID_FK VARCHAR2(20),
		 PRODUCT_CODE_PK VARCHAR2(20),
		 ORDER_COUNT NUMBER(6),
		 BUYER_NAME VARCHAR2(20),
		 BUYER_ADDRESS VARCHAR2(200),
		 BUYER_PHONE NUMBER(15),
		 BUYER_EMAIL VARCHAR2(30),
		 RCPT_NAME VARCHAR2(20),
		 RCPT_ADDRESS VARCHAR2(200),
		 RCPT_PHONE NUMBER(15),
		 SHIP_MESSAGE VARCHAR2(100),
		 ORDER_AMOUNT NUMBER(10),
		 ORDER_STATE NUMBER(2),
		 ORDER_DATE DATE,
		 CONSTRAINT ORDERS_ORDER_ID_PK PRIMARY KEY (ORDER_CODE)
		)*/