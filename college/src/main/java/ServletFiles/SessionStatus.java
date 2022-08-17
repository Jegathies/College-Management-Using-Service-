package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;  
import javax.servlet.http.*;  
import college.college;

@WebServlet("/SessionStatus")
public class SessionStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
		try {
			PrintWriter out = response.getWriter();
			
//			
			
			
			HttpSession session=request.getSession();
			college clg = (college) session.getAttribute("collegeobj");
			System.out.println(clg);
			if(clg!=null)
			{
				out.print("exists");
				System.out.print(clg);
			}
			else
			{
				out.print("logout");
			}
//			Cookie ck[]=request.getCookies();  
//			for(int i=0;i<ck.length;i++){
//				if(ck[i].equals("email"))
//				{
//					System.out.println(ck[i].getValue());
//					out.print("nothing");
//				}
//			}                                               
		} 
		catch (Exception ee) {
			ee.printStackTrace();
			System.out.println(ee.getMessage());
			
		}
		
		
	}

}
