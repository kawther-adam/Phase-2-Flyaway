package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Flight;
import com.entity.Places;

/**
 * Servlet implementation class SearchFlightDetails
 */
public class SearchFlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlightDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		LocalDate doj = LocalDate.parse(request.getParameter("doj"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int seats = Integer.parseInt(request.getParameter("seats"));
		
		RequestDispatcher rd = request.getRequestDispatcher("searchFlight.jsp");
			
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		TypedQuery qry = session.createQuery("select f.flightName,f.price,f.fid,p.pid from Flight f, Places p "
				+ "where f.dof=:doj and p.source = :source and p.destination = :destination and f.seats >= :seats and p.pid = f.pid");
		qry.setParameter("doj", doj);
		qry.setParameter("source", source);
		qry.setParameter("destination", destination);
		qry.setParameter("seats", seats);
		
		List<Object[]> flightDetails = qry.getResultList();
		request.setAttribute("flightDetails", flightDetails);
		request.setAttribute("seats", seats);
		rd.include(request, response);
	}

}