package command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import dao.ProductDao;
import vo.ProductVo;

public class ProductAddActionCmd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductVo vo = new ProductVo();
		vo.setCategory1CodeFk(request.getParameter("category1CodeFk"));
		vo.setProductName(request.getParameter("productName"));
		vo.setProductCode(request.getParameter("productCode"));
		vo.setProductCompany(request.getParameter("productCompany"));
		vo.setPriceRetail(Integer.parseInt(request.getParameter("priceRetail")));
		vo.setPriceSale(Integer.parseInt(request.getParameter("priceSale")));
		vo.setProductQnty(Integer.parseInt(request.getParameter("productQnty")));
		vo.setProductImage1(request.getParameter("productImages1"));
		vo.setProductImage2(request.getParameter("productImages2"));
		vo.setProductMessage(request.getParameter("productMessage"));
		ProductDao dao = new ProductDao();
		
		int result = dao.productWrite(vo);
		
		return "/product/product_add.jsp";
	}//end execute method
}//end class
