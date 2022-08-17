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
import org.json.JSONObject;

import Database.CollegeDB;
import college.Staff;
import college.Student;

/**
 * Servlet implementation class ViewStaff
 */
@WebServlet("/ViewStaff")
public class ViewStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

	    PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    int clg_id=Integer.parseInt(request.getParameter("clg_id"));
	    ArrayList<Staff> arrayList=CollegeDB.viewStaff(clg_id);
	    JSONArray jsonArray= new JSONArray();
	    for(int i=0;i<arrayList.size();i++)
	    {
		    JSONObject obj=new JSONObject(arrayList.get(i));
		    jsonArray.put(obj);
	    }
	
	    System.out.print(jsonArray);
	    out.print(jsonArray);

	}
}
