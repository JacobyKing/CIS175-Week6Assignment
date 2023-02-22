package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
import model.OwnerDetails;
import model.SportsCar;

/**
 * Servlet implementation class EditOwnerDetailsServlet
 */
@WebServlet("/editOwnerDetailsServlet")
public class EditOwnerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditOwnerDetailsServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OwnerDetailsHelper dao = new OwnerDetailsHelper();
		SportsCarHelper lih = new SportsCarHelper();
		OwnerHelper sh = new OwnerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		OwnerDetails ownerToUpdate = dao.searchForOwnerDetailsById(tempId);
		String ownerName = request.getParameter("ownerName");
		String dlNumber = request.getParameter("dlNumber");
		Owner newOwner = sh.findOwner(ownerName);
		try{
			String[] selectedCars = request.getParameterValues("allCarsToAdd");
			List<SportsCar> selectedCarsInList = new ArrayList<SportsCar>();
			for(int i = 0; i < selectedCars.length; i++) {
				SportsCar c = lih.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInList.add(c);
			}
			ownerToUpdate.setListOfCars(selectedCarsInList);
		}
		catch(NullPointerException ex) {
			List<SportsCar> selectedCarsInList = new ArrayList<SportsCar>();
			ownerToUpdate.setListOfCars(selectedCarsInList);
		}
		ownerToUpdate.setOwner(newOwner);
		ownerToUpdate.setDlNumber(dlNumber);
		dao.updateOwner(ownerToUpdate);
		getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
	}
}
