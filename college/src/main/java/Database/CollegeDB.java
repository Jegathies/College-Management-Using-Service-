package Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;

import college.Staff;
import college.Student;
import college.college;
public class CollegeDB {
	private static Connection connection;
	
	//registration
	public static void insertByAdmin(college admin)
	{
		try
		{
			connection=DatabaseConnection.getConnection();
//			String query="insert into college_admin(college_name,address,pincode,mobile,email,password) values(?,?,?,?,?,?)";
			String query="insert into college(college_name,address,pincode,mobile,email,password) values(?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, admin.getCollegeName());
			System.out.print(admin.getCollegeName());
			pst.setString(2, admin.getAddress());
			pst.setString(3, admin.getPincode());
			pst.setString(4, admin.getMobile());
			pst.setString(5, admin.getEmail());
			pst.setString(6, admin.getPassword());
			pst.executeUpdate();
			System.out.print("registered successfully");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.println(ee);
		}
	}
	//login
	public static HashMap<String,Object> login(String email,String password) throws SQLException
	{
		try
		{
		   connection=DatabaseConnection.getConnection();
		 //  String query="select * from college_admin where email=? AND password=?";
		   String query="select * from college where email=? AND password=?";
		   PreparedStatement pst=connection.prepareStatement(query);
		   pst.setString(1,email);
		   pst.setString(2, password);
		   ResultSet rs=pst.executeQuery();
		   HashMap<String, Object> hashMap=new HashMap<>();
		   System.out.println(email);
		   if(rs.next())
		   {
		   	  college clg = new college();
		   	  clg.setId(rs.getInt("id"));
		   	  clg.setCollegeName(rs.getString("college_name"));
		   	  clg.setAddress(rs.getString("address"));
		   	  clg.setEmail(rs.getString("email"));
		   	  clg.setPincode((rs.getString("pincode")));;
		   	  clg.setMobile((rs.getString("mobile")));
		   	  clg.setRole("admin");
		   	  System.out.println("login successfully");
		   	  hashMap.put("college", clg);
		   	  return hashMap;
		   }
		   else 
		   {
			   System.out.print("hi");
			   String query1="select * from staff where staff_email=? AND password=?";
			   PreparedStatement pst1=connection.prepareStatement(query1);
			   pst1.setString(1,email);
			   pst1.setString(2, password);
			   ResultSet rs1=pst1.executeQuery();
			   if(rs1.next())
			   {
			   	  Staff staff = new Staff();
			   	  staff.setId(rs1.getInt("id"));
			   	  staff.setStaffName(rs1.getString("staff_name"));
			   	  staff.setDeparment(rs1.getString("department"));
			   	  staff.setEmail(rs1.getString("staff_email"));
			   	  staff.setRole("staff");
			   	  staff.setPassword(rs1.getString("password"));
			   	  staff.setClg_id(rs1.getInt("clg_id"));
			   	  System.out.println("Staff login successfully");
			   	  hashMap.put("staff", staff);
			   	  return hashMap;
			   }
		   }
		}  
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.print(ee.getMessage());
		}
		return null;
	}
	
	//add department
	public static boolean insertDep(int id,String department)
	{
		try
		{
			connection=DatabaseConnection.getConnection();
			String query="insert into department(clg_id,department) values(?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, department);
			pst.executeUpdate();
			System.out.print("Added successfully");
			return true;
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.println(ee);
		}
		return false;
	}
	
	//getting department
	public static ArrayList<String> getDep(int id)
	{
		try
		{
			connection=DatabaseConnection.getConnection();
			String query="select * from department where clg_id=? ";
			   PreparedStatement pst=connection.prepareStatement(query);
			   pst.setInt(1,id);
			   ResultSet rs=pst.executeQuery();
			   ArrayList<String> arrayList=new ArrayList<>();
			   while(rs.next())
			   {
			   	  arrayList.add(rs.getString("department"));
			   }
			   return arrayList;
			}  
			catch(Exception ee)
			{
				ee.printStackTrace();
				System.out.print(ee);
			}
		return null;
	}
	//adding student
	public static boolean insertStudent(Student stud)
	{
		try
		{
			connection=DatabaseConnection.getConnection();
			String query="insert into student(name,gender,age,department,address,pincode,mobile,email,clg_id,status,year_of_joining) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,stud.getName());
			pst.setString(2,stud.getGender());
			pst.setString(3, stud.getAge());
			pst.setString(4,stud.getDepartment() );
			pst.setString(5,stud.getAddress() );
			pst.setString(6,stud.getPincode() );
			pst.setString(7,stud.getMobile() );
			pst.setString(8, stud.getEmail());
			pst.setInt(9,stud.getClg_id() );
			pst.setString(10, stud.getStatus());
			pst.setString(11,stud.getYearOfJoining());
			pst.executeUpdate();
			System.out.println("Added successfully");
			return true;
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.println(ee);
		}
		return false;
	}
	//view Department
	public static HashMap<String,String> viewDept(int id)
	{
		try {
			connection=DatabaseConnection.getConnection();
			String query="select department,count(department) from student where clg_id=? group by department";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();	
			HashMap<String , String> hashMap=new HashMap<>();
			while(rs.next())
			{
				hashMap.put(rs.getString("department"),rs.getInt(2)+"");
			}
			return hashMap;
			
		} catch (Exception ee) {
			ee.printStackTrace();
			System.out.println(ee);
		}
		return null;
	}
	
	//view Student
	public static ArrayList<Student> viewStudent(int id,String status)
	{
		try {
			connection=DatabaseConnection.getConnection();
			String query="select * from student where clg_id=? and status=?";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setInt(1,id);
			pst.setString(2, status);
			ResultSet rs=pst.executeQuery();
			ArrayList<Student> arrayList=new ArrayList<>();
			while(rs.next())
			{
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				student.setAge(rs.getString("age"));
				student.setDepartment(rs.getString("department"));
				student.setAddress(rs.getString("address"));
				student.setPincode(rs.getString("pincode"));
				student.setMobile(rs.getString("mobile"));
				student.setEmail(rs.getString("email"));
				student.setClg_id(rs.getInt("clg_id"));
				student.setYearOfJoining(rs.getString("year_of_joining"));
				student.setStatus(rs.getString("status"));
				
				arrayList.add(student);
			}
			return arrayList;
			
		} catch (Exception ee) {
			ee.printStackTrace();
			System.out.println(ee);
		}
		return null;
	}
	
	//view Student
	public static Student getStudentDetail(int id)
	{
		try {
			connection=DatabaseConnection.getConnection();
			String query="select * from student where id=? ";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			Student student = new Student();
			if(rs.next())
			{
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				student.setAge(rs.getString("age"));
				student.setDepartment(rs.getString("department"));
				student.setAddress(rs.getString("address"));
				student.setPincode(rs.getString("pincode"));
				student.setMobile(rs.getString("mobile"));
				student.setEmail(rs.getString("email"));
				student.setClg_id(rs.getInt("clg_id"));
				student.setYearOfJoining(rs.getString("year_of_joining"));
				student.setStatus(rs.getString("status"));
				
				
			}
			return student;
		} catch (Exception ee) {
			ee.printStackTrace();
			System.out.println(ee);
		}
		return null;
	}
	
	//view Staff
	public static ArrayList<Staff> viewStaff(int id)
	{
		try {
			connection=DatabaseConnection.getConnection();
			String query="select * from staff where clg_id=?";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			ArrayList<Staff> arrayList=new ArrayList<>();
			while(rs.next())
			{
				Staff staff= new Staff();
				staff.setId(rs.getInt("id"));
				staff.setStaffName(rs.getString("staff_name"));
				staff.setDeparment(rs.getString("department"));
				staff.setEmail(rs.getString("staff_email"));
				arrayList.add(staff);
			}
			return arrayList;
			
		} catch (Exception ee) {
			ee.printStackTrace();
			System.out.println(ee);
		}
		return null;
	}
	
	//insert staff
	public static boolean insertStaff(Staff staff)
	{
		try
		{
			connection=DatabaseConnection.getConnection();
			String query="insert into staff(department,staff_name,staff_email,role,clg_id,password) values(?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, staff.getDeparment());
			pst.setString(2, staff.getStaffName());
			pst.setString(3, staff.getEmail());
			pst.setString(4, "staff");
			pst.setInt(5, staff.getClg_id());
			pst.setString(6, staff.getPassword());
			pst.executeUpdate();
			System.out.print("registered successfully");
			return true;
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.println(ee);
		}
		return false;
	}
	
	//modify student to approve
	public static boolean approveStudent(int id,String status)
	{
		try
		{
			connection=DatabaseConnection.getConnection();
			String query="update student set status=? where id=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, status);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.print("updated successfully");
			return true;
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.println(ee);
		}
		return false;
	}
	
	
}
