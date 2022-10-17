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
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class BookFlight
 */
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		int fid = Integer.parseInt(request.getParameter("fid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int seats = Integer.parseInt(request.getParameter("seats"));
		RequestDispatcher rd = request.getRequestDispatcher("bookFlight.jsp");
			
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		TypedQuery qry = session.createQuery("select f.flightName,f.price,f.fid,p.pid,p.source, p.destination from Flight f, Places p "
				+ "where p.pid = :pid and f.fid = :fid");
		qry.setParameter("pid", pid);
		qry.setParameter("fid", fid);
		List<Object[]> bookingDetails = qry.getResultList();
		request.setAttribute("bookingDetails", bookingDetails);
		request.setAttribute("seats", seats);
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}