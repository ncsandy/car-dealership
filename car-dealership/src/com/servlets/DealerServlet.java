package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dealership.Customer;
import com.dealership.Inventory;

/**
 * Servlet implementation class DealerServlet
 */
@WebServlet("/DealerServlet")
public class DealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealerServlet() {
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
		
		Inventory inventory = (Inventory)session.getAttribute("inventory");
		if(inventory == null) {
			inventory = new Inventory(); 
		}
		
		
		session.setAttribute("inventory", inventory);
		
		
		
		session.getAttribute("customerList");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username.equals("admin") && password.equals("123")) {
			
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/dealerportal.jsp");
			rs.forward(request, response);
		
		}
		else {
			response.sendRedirect("dealerlogin.jsp");
		}
		
		
		
	}

}
