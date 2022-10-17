package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

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
 * Servlet implementation class AddFlightDetails
 */
public class AddFlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlightDetails() {
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
		int fid = Integer.parseInt(request.getParameter("fid"));
		String flightname = request.getParameter("flightname");
		float price = Float.parseFloat(request.getParameter("price"));
		LocalDate dof = LocalDate.parse(request.getParameter("dof"));
		int seats = Integer.parseInt(request.getParameter("seats"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		RequestDispatcher rd = request.getRequestDispatcher("addFlight.jsp");
		Flight ff = new Flight();
		ff.setFid(fid);
		ff.setFlightName(flightname);
		ff.setPrice(price);
		ff.setDof(dof);
		ff.setSeats(seats);
		ff.setPid(pid);
		
		try {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(ff);
		tran.commit();
		pw.println("Flight details stored successfully");
		}catch(Exception e) {
			System.out.println(e);
			pw.println("Flight Details didn't store");
		}
		rd.include(request, response);
	}

}
