package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.entity.Booking;
import com.entity.Flight;
import com.entity.Places;

/**
 * Servlet implementation class BookFlightConfimation
 */
public class BookFlightConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFlightConfirmation() {
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
		//doGet(request, response);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		int fid = Integer.parseInt(request.getParameter("fid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		float totalAmount = Float.parseFloat(request.getParameter("price"));
		int numberOfSeatch = Integer.parseInt(request.getParameter("numberofseats"));
		RequestDispatcher rd = request.getRequestDispatcher("searchFlight.jsp");		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Booking bb = new Booking();
		bb.setTotalAmount(totalAmount);
		bb.setPname(pname);
		bb.setNumberOfSeats(numberOfSeatch);
		Flight ff = new Flight();
		ff.setFid(fid);
		
		Places pp = new Places();
		pp.setPid(pid);
		
		bb.setPid(pp);
		bb.setFid(ff);
		
		Flight ff1  = session.get(Flight.class, fid);
		if(ff1!=null) {
			Transaction tran = session.getTransaction();
			tran.begin();
					session.save(bb);
						ff1.setSeats(ff1.getSeats()-numberOfSeatch);
					session.update(ff1);
			tran.commit();
			pw.println("Ticket book successfully....");
		}
		
		rd.include(request, response);
	}

}