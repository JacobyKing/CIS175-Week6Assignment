package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OwnerDetails;

/**
 * Servlet implementation class OwnerNavigationServlet
 */
@WebServlet("/ownerNavigationServlet")
public class OwnerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OwnerNavigationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OwnerDetailsHelper coh = new OwnerDetailsHelper();
		String act = request.getParameter("doThisToOwner");
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
		}
		else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				OwnerDetails ownerToDelete = coh.searchForOwnerDetailsById(tempId);
				coh.deleteOwner(ownerToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an owner");
			}
			finally {
				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
			}
		}
		else if(act.equals("edit")) {
			try{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				OwnerDetails ownerToEdit = coh.searchForOwnerDetailsById(tempId);
				request.setAttribute("ownerToEdit", ownerToEdit);
				SportsCarHelper daoForCars = new SportsCarHelper();
				request.setAttribute("allCars", daoForCars.showAllCars());
				if(daoForCars.showAllCars().isEmpty()){
					request.setAttribute("allCars", " ");
				}
				getServletContext().getRequestDispatcher("/edit-owner.jsp").forward(request, response);
			}
			catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
			}
		}
		else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/addOwnerServlet").forward(request, response);
		}
	}
}
