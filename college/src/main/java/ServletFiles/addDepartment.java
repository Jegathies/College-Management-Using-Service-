package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.CollegeDB;
import college.college;

/**
 * Servlet implementation class addDepartment
 */
@WebServlet("/addDepartment")
public class addDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");


        PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String department=request.getParameter("department");
		if(CollegeDB.insertDep(id, department))
		{
			out.print("added");
		}
		else {
			out.print("failed");
		}
		
	}

}
