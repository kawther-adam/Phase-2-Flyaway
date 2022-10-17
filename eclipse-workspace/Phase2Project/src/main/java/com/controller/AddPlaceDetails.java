package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Places;

/**
 * Servlet implementation class AddPlaceDetails
 */
public class AddPlaceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlaceDetails() {
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
	//	doGet(request, response);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		RequestDispatcher rd = request.getRequestDispatcher("addPlaces.jsp");

		Places pp = new Places();
		pp.setPid(pid);
		pp.setSource(source);
		pp.setDestination(destination);
		
		try {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(pp);
		tran.commit();
		pw.println("Place details stored successfully");
		}catch(Exception e) {
			System.out.println(e);
			pw.println("Place Details didn't store");
		}
		rd.include(request, response);
	}

}
