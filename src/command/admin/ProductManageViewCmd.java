package command.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import dao.ProductDao;
import vo.ProductVo;

public class ProductManageViewCmd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("productmanagerviewcmd");
		//String ctgry_Name = request.getParameter("ctgry_Name");
		ProductDao dao = new ProductDao();
		ArrayList<ProductVo> list = dao.adminProuctList();
		request.setAttribute("list", list);
		System.out.println("productmanagerviewcmd_end");
		
		return "/admin/product_manage.jsp";
		
	}//end execute method
}//end class
