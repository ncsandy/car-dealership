package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dealership.Car;
import com.dealership.FileWriters;
import com.dealership.Inventory;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		
		Car car = new Car();
		FileWriters filewriter = new FileWriters();
		//Parameters to parse
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		int residence = Integer.parseInt(request.getParameter("residence"));
		boolean condition = Boolean.parseBoolean(request.getParameter("condition"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		//Setting attributes of the car object
		
		car.setMake(request.getParameter("make"));
		car.setModel(request.getParameter("model"));
		car.setYear(request.getParameter("year"));
		car.setDateOfPurchase(request.getParameter("dateOfPurchase"));
		car.setMileage(mileage);
		car.setResidence(residence);
		car.setImage(request.getParameter("image"));
		car.setDescription(request.getParameter("description"));
		car.setUsed(condition);
		car.setPrice(price);
		car.setPurchased(false);
		car.setVin(request.getParameter("vin"));
		
		Inventory inventory = (Inventory)session.getAttribute("inventory");
		
		inventory.getCarList().add(car); //add the current constructed car to the current inventory session
		inventory.special(inventory.getCarList()); //apply the special discounts to the arraylist
		filewriter.addCar(car, inventory); //we add the car the cars.txt
		
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/dealerportal.jsp"); //redirects us back to the dealer page
		rs.forward(request,response);
		
		
	}

}
