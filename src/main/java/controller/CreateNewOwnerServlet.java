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
 * Servlet implementation class CreateNewOwnerServlet
 */
@WebServlet("/createNewOwnerServlet")
public class CreateNewOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateNewOwnerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportsCarHelper sch = new SportsCarHelper();
		String ownerName = request.getParameter("ownerName");
		String dlNumber = request.getParameter("dlNumber");
		String[] selectedCars = request.getParameterValues("allCarsToAdd");
		List<SportsCar> selectedCarsInList = new ArrayList<SportsCar>();
		if(selectedCars != null && selectedCars.length > 0) {
			for(int i = 0;i < selectedCars.length; i++) {
				SportsCar c = sch.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInList.add(c);
			}
		}
		Owner owner = new Owner(ownerName);
		OwnerDetails cod = new OwnerDetails(dlNumber, owner);
		cod.setListOfCars(selectedCarsInList);
		OwnerDetailsHelper coh = new OwnerDetailsHelper();
		coh.insertNewOwnerDetails(cod);
		getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
