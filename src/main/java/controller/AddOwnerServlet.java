package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddOwnerServlet
 */
@WebServlet("/addOwnerServlet")
public class AddOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddOwnerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportsCarHelper sch = new SportsCarHelper();
		request.setAttribute("allCars", sch.showAllCars());
		if(sch.showAllCars().isEmpty()) {
			request.setAttribute("allCars", " ");
		}
		getServletContext().getRequestDispatcher("/new-owner.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
