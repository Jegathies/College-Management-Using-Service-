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
import college.Student;

/**
 * Servlet implementation class getStudentDetail
 */
@WebServlet("/getStudentDetail")
public class getStudentDetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

	PrintWriter out = response.getWriter();
	response.setContentType("application/json");
	int id=Integer.parseInt(request.getParameter("id"));
	Student student=CollegeDB.getStudentDetail(id);
	JSONArray jsonArray= new JSONArray();
	if(student!=null)
	{
		
		JSONObject obj=new JSONObject(student);
		jsonArray.put(obj);
	}
	else {
		JSONObject obj= new JSONObject();
  		obj.put("value","nothing");
  		jsonArray.put(obj);
  		out.print(jsonArray);
  		System.out.println(jsonArray);
	}
	System.out.print(jsonArray);
	out.print(jsonArray);

	}


}
