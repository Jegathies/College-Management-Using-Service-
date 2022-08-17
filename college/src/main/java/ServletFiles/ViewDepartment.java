package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import Database.CollegeDB;

/**
 * Servlet implementation class ViewDepartment
 */
@WebServlet("/ViewDepartment")
public class ViewDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		int id=Integer.parseInt(request.getParameter("clg_id"));
		HashMap<String, String> hashMap=CollegeDB.viewDept(id);
		JSONArray jsonArray = new JSONArray();
		
		Iterator iterator = hashMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)iterator.next();
			JSONObject obj= new JSONObject();
			obj.put("department",mapElement.getKey());
			obj.put("count", mapElement.getValue());
			jsonArray.put(obj);
		}
		
		
		
		out.print(jsonArray);
		System.out.print(jsonArray);
	}

}
