package vo;

public class ProductVo {

	private String productCode;
	private String productName;
	private String productCompany;
	private int priceRetail;
	private int priceSale;
	private int productQnty;
	private String productImage1;
	private String productImage2;
	private String productMessage;
	private String productDate;
	private String category1CodeFk;
	

	public ProductVo(){}
	
	public ProductVo(String product_Code, String product_Name, String product_Company, int price_Retail,
			int price_Sale, int product_Qnty, String product_Image1, String product_Image2, String product_Message,
			String product_Date) {
		super();
		this.productCode = product_Code;
		this.productName = product_Name;
		this.productCompany = product_Company;
		this.priceRetail = price_Retail;
		this.priceSale = price_Sale;
		this.productQnty = product_Qnty;
		this.productImage1 = product_Image1;
		this.productImage2 = product_Image2;
		this.productMessage = product_Message;
		this.productDate = product_Date;
	}
	
	public ProductVo(String product_Name, int product_Qnty, String product_Image1, String product_Message, String product_Code) {
		super();
		this.productName = product_Name;
		this.productQnty = product_Qnty;
		this.productImage1 = product_Image1;
		this.productMessage = product_Message;
		this.productCode = product_Code;
	}

	public ProductVo(String product_Name, String product_Image1, String product_Message) {
		super();
		this.productName = product_Name;
		this.productImage1 = product_Image1;
		this.productMessage = product_Message;
	}
	
	public ProductVo(String product_Code, String product_Name, String product_Company, int price_Retail,
			int price_Sale, int product_Qnty, String product_Image1, String product_Image2, String product_Message,
			String product_Date, String category1_Code_Fk) {
		super();
		this.productCode = product_Code;
		this.productName = product_Name;
		this.productCompany = product_Company;
		this.priceRetail = price_Retail;
		this.priceSale = price_Sale;
		this.productQnty = product_Qnty;
		this.productImage1 = product_Image1;
		this.productImage2 = product_Image2;
		this.productMessage = product_Message;
		this.productDate = product_Date;
		this.category1CodeFk = category1_Code_Fk;
	}


	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String product_Code) {
		this.productCode = product_Code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String product_Name) {
		this.productName = product_Name;
	}
	public String getProductCompany() {
		return productCompany;
	}
	public void setProductCompany(String product_Company) {
		this.productCompany = product_Company;
	}
	public int getPriceRetail() {
		return priceRetail;
	}
	public void setPriceRetail(int price_Retail) {
		this.priceRetail = price_Retail;
	}
	public int getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(int price_Sale) {
		this.priceSale = price_Sale;
	}
	public int getProductQnty() {
		return productQnty;
	}
	public void setProductQnty(int product_Qnty) {
		this.productQnty = product_Qnty;
	}
	public String getProductImage1() {
		return productImage1;
	}
	public void setProductImage1(String product_Image1) {
		this.productImage1 = product_Image1;
	}
	public String getProductImage2() {
		return productImage2;
	}
	public void setProductImage2(String product_Image2) {
		this.productImage2 = product_Image2;
	}
	public String getProductMessage() {
		return productMessage;
	}
	public void setProductMessage(String product_Message) {
		this.productMessage = product_Message;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String product_Date) {
		this.productDate = product_Date;
	}
	public String getCategory1CodeFk() {
		return category1CodeFk;
	}

	public void setCategory1CodeFk(String category1_Code_Fk) {
		this.category1CodeFk = category1_Code_Fk;
	}


	@Override
	public String toString() {
		return "ProductsVo [product_Code=" + productCode + ", product_Name=" + productName + ", product_Company="
				+ productCompany + ", price_Retail=" + priceRetail + ", price_Sale=" + priceSale + ", product_Qnty="
				+ productQnty + ", product_Image1=" + productImage1 + ", product_Image2=" + productImage2
				+ ", product_Message=" + productMessage + ", product_Date=" + productDate + ", category1_Code_Fk="
				+ category1CodeFk + "]";
	}

}

/*CREATE TABLE PRODUCTS(
		 PRODUCT_CODE VARCHAR2(20),
		 CATEGORY1_CODE_FK VARCHAR2(20),
		 PRODUCT_NAME VARCHAR2(60),
		 PRODUCT_COMPANY VARCHAR2(30),
		 PRICE_RETAIL NUMBER(10),
		 PRICE_SALE NUMBER(10),
		 PRODUCT_QNTY NUMBER(10),
		 PRODUCT_IMAGE1 VARCHAR2(50),
		 PRODUCT_IMAGE2 VARCHAR2(50),
		 PRODUCT_MESSAGE VARCHAR2(1000),
		 PRODUCT_DATE DATE,
		 CONSTRAINT PRODUCTS_PRODUCT_CODE_PK PRIMARY KEY (PRODUCT_CODE)
		)*/