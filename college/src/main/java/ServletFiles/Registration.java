package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.CollegeDB;
import Database.DatabaseConnection;
import college.college;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");

       
		PrintWriter out = response.getWriter();
		college clg = new college();
		clg.setCollegeName(req.getParameter("name"));
		clg.setAddress(req.getParameter("address"));
		clg.setEmail(req.getParameter("email"));
		clg.setPassword(req.getParameter("password"));
		clg.setPincode(req.getParameter("pincode"));
		clg.setMobile(req.getParameter("mobile"));
		clg.setRole(req.getParameter("role"));
		CollegeDB.insertByAdmin(clg);
        response.setCharacterEncoding("UTF-8");
        out.print("Hi Jega");
        out.flush(); 
	}

}
