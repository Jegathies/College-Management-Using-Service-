package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.CollegeDB;
import college.Staff;
import college.Student;

/**
 * Servlet implementation class addStaff
 */
@WebServlet("/addStaff")
public class addStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");

       
		PrintWriter out = response.getWriter();
		Staff staff = new Staff();
		staff.setStaffName(request.getParameter("name"));
		staff.setDeparment(request.getParameter("department"));
		staff.setEmail(request.getParameter("email"));
		staff.setPassword(request.getParameter("password"));
		staff.setClg_id(Integer.parseInt(request.getParameter("clg_id")));
		if(CollegeDB.insertStaff(staff))
		{
			out.print("Staff added Successfully");
		}
		else {
			out.print("not added");
		}
	}

}
