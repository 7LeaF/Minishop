package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.db.JdbcUtil;
import vo.ProductVo;

public class ProductDao {

	public ArrayList<ProductVo> orderCheckView(String userIdPk){
		System.out.println("productDao.orderCheckView.strat");
		System.out.println(userIdPk);
		
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String sql = "select product_code_pk, product_image1, product_name, product_message, price_sale, order_amount, order_state"
					+ " from orders o, products p where o.product_code_pk = p.product_code and o.user_id_fk =?";	
			
		try{	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userIdPk);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ProductVo vo = new ProductVo(
					rs.getString("product_Code"),
					rs.getString("product_Name"),
					rs.getString("product_Company"),
					rs.getInt("price_Retail"),
					rs.getInt("price_Sale"),
					rs.getInt("product_Qnty"),
					rs.getString("product_Image1"),
					rs.getString("product_Image2"),
					rs.getString("product_Message"),
					rs.getString("product_Date"),
					rs.getString("category1_Code_Fk")	
				);
				
				list.add(vo);	
				System.out.println("orderCheckView.work");
			}		
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		System.out.println("productDao.orderCheckView.end");
		return list;
	}
	
	
	public ProductVo getProduct(String productCode){
		System.out.println("productDao.adminProductList.strat");
		System.out.println(productCode);
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String sql = "select * from products where product_code = ?";
		
		try{	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				ProductVo vo= new ProductVo();
				vo.setProductCode(rs.getString("product_code"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductCompany(rs.getString("product_company"));
				vo.setPriceRetail(rs.getInt("price_retail"));
				vo.setPriceSale(rs.getInt("price_sale"));
				vo.setProductQnty(rs.getInt("product_qnty"));
				vo.setProductImage1(rs.getString("product_image1"));
				vo.setProductImage2(rs.getString("product_image2"));
				vo.setProductMessage(rs.getString("product_message"));
				vo.setProductDate(rs.getString("product_date"));
				vo.setCategory1CodeFk(rs.getString("category1_code_fk"));
				
				System.out.println("dao.list_work");
				return vo;

			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return null;
	}
	
	
	//카테고리에 해당하는 리스트 가져오기 
	//Default 카테고리는 all
	public ArrayList<ProductVo> getProductListAll(){
		ArrayList<ProductVo> voList= new ArrayList<>();
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String SQL="SELECT * FROM products";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				ProductVo vo= new ProductVo();
				vo.setProductCode(rs.getString("product_code"));
				vo.setCategory1CodeFk(rs.getString("category1_code_fk"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductCompany(rs.getString("product_company"));
				vo.setPriceRetail(rs.getInt("price_retail"));
				vo.setPriceSale(rs.getInt("price_sale"));
				vo.setProductQnty(rs.getInt("product_qnty"));
				vo.setProductImage1(rs.getString("product_image1"));
				vo.setProductImage2(rs.getString("product_image2"));
				vo.setProductMessage(rs.getString("product_message"));
				vo.setProductDate(rs.getString("product_date"));
			
				voList.add(vo);
			}
			return voList;
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return null;
		
	}//end getProductListAll method
	
	
	public ArrayList<ProductVo> getProductListByCtgry(String category_code){
		ArrayList<ProductVo> voList = new ArrayList<ProductVo>();
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String SQL= "SELECT * FROM products WHERE category1_code_fk=?";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			pstmt.setString(1, category_code);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				ProductVo vo= new ProductVo();
				vo.setProductCode(rs.getString("product_code"));
				vo.setCategory1CodeFk(rs.getString("category1_code_fk"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductCompany(rs.getString("product_company"));
				vo.setPriceRetail(rs.getInt("price_retail"));
				vo.setPriceSale(rs.getInt("price_sale"));
				vo.setProductQnty(rs.getInt("product_qnty"));
				vo.setProductImage1(rs.getString("product_image1"));
				vo.setProductImage2(rs.getString("product_image2"));
				vo.setProductMessage(rs.getString("product_message"));
				vo.setProductDate(rs.getString("product_date"));
				
				voList.add(vo);
			}
			return voList;
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return null;
		
	}//getProductListByCtgry method end
	
	
	//카테고리 리스트 출력
	public ArrayList<ProductVo> productList(String category1_name){
		System.out.println("productDao.productList.strat");
		System.out.println(category1_name);
		
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String ctgry_code  = "";
		String sql_main = "";
		
		try{
			
			if(category1_name.equals("all")){
				System.out.println("이프문모두진입");
				sql_main = "select product_name, product_message, product_image1, product_Qnty,product_Code from products";
			
			}else if(!category1_name.equals("all")){
				sql_main = "select product_name, product_message, product_image1, product_Qnty, product_Code from products where category1_code_fk =?";
				String category_sql = "select ctgry_code from category1 where ctgry_name =?";	
				
				pstmt = conn.prepareStatement(category_sql);
				pstmt.setString(1, category1_name);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					ctgry_code = rs.getString("ctgry_code");
					System.out.println(ctgry_code);
					System.out.println("dao.productlist.cateigory.work");
				}	
			}
	
		
			pstmt = conn.prepareStatement(sql_main);
			
			if (!category1_name.equals("all")) {
				pstmt.setString(1, ctgry_code);	
			}
			
			ResultSet rs_main = pstmt.executeQuery();
			
			while(rs_main.next()){
				ProductVo vo = new ProductVo(
					rs_main.getString("product_name"),
					rs_main.getInt("product_Qnty"),
					rs_main.getString("product_image1"),
					rs_main.getString("product_message"),
					rs_main.getString("product_Code")
				);
				list.add(vo);	
				System.out.println("dao.productlist_work");
			}		
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return list;
	}
	
	
	
	
	public ArrayList<ProductVo> adminProuctList(){
		System.out.println("productDao.adminProductList.strat");
		
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		try{
			String sql = "select product_name, product_message, product_image1 from products";	
//			"select product_name, product_message, pirce_sale from products where ctgry_name = ?";	
//			상품 이름 :
//			상품 내용 :
//			상품 가격 :
			pstmt = conn.prepareStatement(sql);
			//pt.setString(1, ctgry_Name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProductVo vo = new ProductVo(
					rs.getString("product_name"), 
					rs.getString("product_image1"), 
					rs.getString("product_message")	
				);
				list.add(vo);	
				System.out.println("dao.list_work");
			}		
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return list;
	}
	
	
	public int productWrite(ProductVo vo){
		System.out.println("productDao.prodctWrite.start");
		
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		int result =0;
		try{
			String sql = "insert into products (product_code, CATEGORY1_CODE_FK, product_name, product_company,"
					+ "price_retail, price_sale, product_qnty, product_image1, product_image2, product_message, product_date)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";	
//			"select product_name, product_message, pirce_sale from products where ctgry_name = ?";	
//			상품 이름 :
//			상품 내용 :
//			상품 가격 :
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getProductCode());
			pstmt.setString(2, vo.getCategory1CodeFk());
			pstmt.setString(3, vo.getProductName());
			pstmt.setString(4, vo.getProductCompany());
			pstmt.setInt(5, vo.getPriceRetail());
			pstmt.setInt(6, vo.getPriceSale());
			pstmt.setInt(7, vo.getProductQnty());
			pstmt.setString(8, vo.getProductImage1());
			pstmt.setString(9, vo.getProductImage2());
			pstmt.setString(10, vo.getProductMessage());
			
			result = pstmt.executeUpdate();
				
			System.out.println("productwrite.end");	
				
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
			
		return result;
	}
	

}//class end
