package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsCar;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NavigationServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportsCarHelper dao = new SportsCarHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllCarsServlet";
		if(act.equals("delete")){
			try{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SportsCar carToDelete = dao.searchForCarById(tempId);
				dao.deleteCar(carToDelete);
			}
			catch(NumberFormatException e){
				System.out.println("Forgot to select a car");
			}
		}
		else if(act.equals("edit")){
			try{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SportsCar carToEdit = dao.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/edit-car.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		}
		else if(act.equals("add")){
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
