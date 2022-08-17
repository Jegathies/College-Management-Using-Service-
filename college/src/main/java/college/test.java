package college;
import college.college;
public class test {
public static void main(String[] args) {
	Staff staff = new Staff();
	staff.setStaffName("hi");
	Object object=staff;
	college clgCollege=(college)object;
	System.out.print(clgCollege);
}
}
