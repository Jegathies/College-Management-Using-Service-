package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import Database.CollegeDB;

/**
 * Servlet implementation class getDepartment
 */
@WebServlet("/getDepartment")
public class getDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

	PrintWriter out = response.getWriter();
	response.setContentType("application/json");
	int id=Integer.parseInt(request.getParameter("clg_id"));
	ArrayList<String> arrayList=CollegeDB.getDep(id);
	JSONArray jsonArray= new JSONArray(arrayList);
	System.out.print(jsonArray);
	out.print(jsonArray);
	}
}
