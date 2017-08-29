package command.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import dao.ProductDao;
import vo.ProductVo;

public class ProductOrderViewCmd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("productorderview");
		String productCode = request.getParameter("productCode");
		String productQnty = request.getParameter("productQnty");
		
		ProductDao dao = new ProductDao();
		ProductVo vo = dao.getProduct(productCode);
		
		request.setAttribute("vo", vo);
		request.setAttribute("productQnty", productQnty);
		
		System.out.println("productorderview.end");
		return "/user/product_order.jsp";
		
	}//end execute method
}//end class
