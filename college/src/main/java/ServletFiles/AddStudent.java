package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.CollegeDB;
import college.Student;
import college.college;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");

       
		PrintWriter out = response.getWriter();
		Student student=new Student();
		student.setName(request.getParameter("name") );
		student.setGender(request.getParameter("gender") );
		System.out.print(request.getParameter("gender"));
		student.setAge(request.getParameter("age"));
		student.setDepartment(request.getParameter("department"));
		student.setAddress(request.getParameter("address")); 
		student.setPincode(request.getParameter("pincode"));
		student.setMobile(request.getParameter("mobile"));
		student.setEmail(request.getParameter("email"));
		student.setClg_id(Integer.parseInt(request.getParameter("clg_id")));
		student.setStatus(request.getParameter("status"));
		student.setYearOfJoining(request.getParameter("year"));
		
		if(CollegeDB.insertStudent(student))
		{
			out.print("Student added Successfully");
		}
		else {
			out.print("not added");
		}
        out.flush(); 
	}

}
