package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import util.db.JdbcUtil;
import vo.OrderVo;

public class OrderDao {
	
	public ArrayList<OrderVo> orderOrderCheckView(String userIdPk){

		ArrayList<OrderVo> list = new ArrayList<OrderVo>();

		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		System.out.println("orderDao.orderOrderCheckView.strat");
		System.out.println(userIdPk);
		
		try{
			String sql = "select product_code_pk, product_image1, product_name, product_message, price_sale, order_amount, order_state "
					+ "from orders o, products p where o.product_code_pk = p.product_code and o.user_id_fk =?";	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userIdPk);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				OrderVo vo = new OrderVo(
					rs.getString("product_code_pk"),
					rs.getInt("order_amount"),
					rs.getInt("order_state"),
					rs.getString("product_image1"),
					rs.getString("product_name"),
					rs.getString("product_message"),
					rs.getInt("price_sale")
				);
				
				list.add(vo);	
				System.out.println("orderorderCheckView.work");
			}		
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		System.out.println("orderDao.orderOrderCheckView.end");
		return list;
	}
	
	
	//주문조회
	public ArrayList<HashMap<String, String>> getOrderViewList(String userId){
		ArrayList<HashMap<String, String>> list= new ArrayList<>();
		
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String SQL= "SELECT product_image1, product_name, order_code, order_count, order_amount, order_date, order_state"
				+ " FROM products p, orders o"
				+ " where user_id_fk=? and o.product_code_pk=p.product_code";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				HashMap<String, String> map= new HashMap<>();
				
				map.put("productImage1", rs.getString("product_image1"));
				map.put("productName", rs.getString("product_name"));
				map.put("orderCode", rs.getString("order_code"));
				map.put("orderCount", Integer.toString(rs.getInt("order_code")));
				map.put("orderAmount", Integer.toString(rs.getInt("order_amount")));
				map.put("orderDate", rs.getString("order_date"));
				map.put("orderState", Integer.toString(rs.getInt("order_state")));
				
				list.add(map);
			}
			return list;
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
			return null;
	}

	
	
	
	//주문하기
	public int order(OrderVo vo, int priceSale){
		System.out.println("OrderDao.orderAdd.start");
		
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
	
		int result =0;
		try{
			
			String sql= "INSERT INTO orders"
					+ " (order_code, user_id_fk, product_code_pk, order_count, buyer_name, buyer_address1, buyer_address2, buyer_phone,"
					+ " buyer_email, rcpt_name, rcpt_address1, rcpt_address2, rcpt_phone, ship_message, order_amount, order_state, order_date)"
					+ " VALUES"
					+ " (order_code_seq.nextval,    ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    0, sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, vo.getOrderCode());
			pstmt.setString(1, vo.getUserIdFk());
			pstmt.setString(2, vo.getProductCodePk());
			pstmt.setInt(3, vo.getOrderCount());
			pstmt.setString(4, vo.getBuyerName());
			
			pstmt.setString(5, vo.getBuyerAddress1());
			pstmt.setString(6, vo.getBuyerAddress2());
			pstmt.setInt(7, vo.getBuyerPhone());
			pstmt.setString(8, vo.getBuyerEmail());
			pstmt.setString(9, vo.getRcptName());
			
			pstmt.setString(10, vo.getRcptAddress1());
			pstmt.setString(11, vo.getRcptAddress2());
			pstmt.setInt(12, vo.getRcptPhone());
			pstmt.setString(13, vo.getShipMessage());
			pstmt.setInt(14, vo.getOrderAmount());
		
			result = pstmt.executeUpdate();
			System.out.println("result : " + result);
			System.out.println("OrderDao.orderAdd.end");
			
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
