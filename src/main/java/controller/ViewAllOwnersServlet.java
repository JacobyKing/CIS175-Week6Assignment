package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OwnerDetails;

/**
 * Servlet implementation class ViewAllOwnersServlet
 */
@WebServlet("/viewAllOwnersServlet")
public class ViewAllOwnersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ViewAllOwnersServlet() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/sports-car-by-owner.jsp";
		OwnerDetailsHelper odh = new OwnerDetailsHelper();
		List<OwnerDetails> allOwners = odh.getOwners();
		request.setAttribute("allOwners", allOwners);
		if(allOwners.isEmpty()) {
			path ="/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
