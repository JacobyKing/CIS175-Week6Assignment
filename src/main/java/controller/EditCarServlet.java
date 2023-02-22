package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsCar;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCarServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportsCarHelper dao = new SportsCarHelper();
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = Integer.parseInt(request.getParameter("year"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		SportsCar carToUpdate = dao.searchForCarById(tempId);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		carToUpdate.setYear(year);
		dao.updateCar(carToUpdate);
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}
}
