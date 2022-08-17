package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.json.JSONArray;
import org.json.JSONObject;

import Database.CollegeDB;
import college.Staff;
import college.college;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost (HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");


		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		try {
			
			
			PrintWriter out=response.getWriter();
			HashMap<String, Object> hashMap=CollegeDB.login(email, password);
			response.setContentType("application/json");
			JSONArray jsonArray = new JSONArray();
			if(hashMap!=null)
			{
			  Iterator iterator = hashMap.entrySet().iterator();
			  while(iterator.hasNext()) 
			  {
			  	Map.Entry mapElement = (Map.Entry)iterator.next();
			  	
			  	if(mapElement.getKey().equals("college"))
			  	{
			  		college college=(college)mapElement.getValue();
			  		
			  		//
			  		HttpSession session=req.getSession();
			  		System.out.println(session.getId());
			  		session.setAttribute("collegeobj", college);
			  		System.out.println(college);
			  		//
			  		JSONObject obj= new JSONObject();
			  		JSONObject obj1= new JSONObject();
			  		JSONObject obj2= new JSONObject();
			  		System.out.println(college.getId());
			  		obj.put("id",college.getId());
			  		obj1.put("role","admin");
			  		jsonArray.put(obj);
			  		jsonArray.put(obj1);
			  		jsonArray.put(obj2);
			  		out.print(jsonArray);
			  	}
			  	else if(mapElement.getKey().equals("staff")){
			  		
			  		Staff staff=(Staff)mapElement.getValue();
			  		JSONObject obj= new JSONObject();
			  		JSONObject obj1= new JSONObject();
			  		JSONObject obj2= new JSONObject();
			  		System.out.println(staff.getId());
			  		obj.put("id",staff.getId());
			  		obj1.put("role","staff");
			  		obj2.put("clg_id",staff.getClg_id());
			  		jsonArray.put(obj);
			  		jsonArray.put(obj1);
			  		jsonArray.put(obj2);
			  		out.print(jsonArray);
			  	}
			  }
			}
			else {
			  		JSONObject obj= new JSONObject();
			  		obj.put("value","nothing");
			  		jsonArray.put(obj);
			  		out.print(jsonArray);
			  		System.out.println(jsonArray);
				}

		} 
		catch (SQLException e) {
			
			System.out.print("Error in login dopost");
		}
		
	}

}


//HttpSession session = req.getSession();
//session.setAttribute("collegeobj", clg);
//if (req.getParameter("JSESSIONID") != null) {
//    Cookie userCookie = new Cookie("JSESSIONID", req.getParameter("JSESSIONID"));
//    response.addCookie(userCookie);
//    out.print("exists");
//	System.out.print(clg);
//} else {
//    String sessionId = session.getId();
//    Cookie userCookie = new Cookie("JSESSIONID", sessionId);
//    response.addCookie(userCookie);
//    
//}


//	HttpSession session=req.getSession();//
//	System.out.println(session.getId());
//	session.setAttribute("collegeobj", (college)mapElement.getValue());//

//	HttpSession session=req.getSession();//
//	System.out.println(session.getId());
//	session.setAttribute("collegeobj", (college)mapElement.getValue());//			  		
//	college clg=(college)session.getAttribute("collegeobj");
//	System.out.print(clg.getMobile());


//
//HttpSession session=req.getSession();
//System.out.println(session.getId());
//session.setAttribute("collegeobj", clg);
