package g6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.Scanner;


class Insert  {
	
	public static void main(String[] args) 
			throws SQLException
	{
		
		String uid = "G6";
	     

	     
	      String pword = "Fall2022G6";
	      

	    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	    // Load the Oracle JDBC driver
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	    // Connect to the database
	    Connection conn =
	      DriverManager.getConnection (url, uid, pword);
	    Scanner input = new Scanner(System.in);
	    int userInput = 1;
	    
	    System.out.println("Hello, what data would you like to insert or search?");
	    
	  while(userInput != 0) {
	 
	  
	  System.out.println("");
	  System.out.println("");
	  System.out.println("0. Exit Program");
	  System.out.println("1. Insert a Department");
	  System.out.println("2. Insert a Student");
	  System.out.println("3. Insert an Instructor");
	  System.out.println("4. Insert a Course");
	  System.out.println("5. Insert a Section");
	  System.out.println("6. Enroll a Student into a Course/Section");
	  System.out.println("7. Search Courses offered by Department Name/Code");
	  System.out.println("8. Search all Course/Sections for an Instructor");
	  System.out.println("9. Insert a grade for a Student");
	  System.out.println("10. Print Grade Report for a Student");
	  System.out.println("");
	  System.out.print("Please select an option: ");
	 
	  userInput = input.nextInt();
	  
	  System.out.println("");
	  System.out.println("");
      System.out.println("");
	  
	  switch(userInput) {
	  
	  case 1: InsertDept(conn); break;
	  case 2: InsertStudent(conn); break;
	  case 3: InsertInstructor(conn);break;
	  case 4: InsertCourse(conn); break;
	  case 5: InsertSection(conn); break;
	  case 6: InsertEnrollStud(conn); break;
	  case 7: SelectCourseDept(conn); break;
	  case 8: SelectCourseInst(conn); break;
	  case 9: InsertGrade(conn); break;
	  case 10: CalculateGPA(conn); break;
	  }
	  }
	  conn.close();
	  input.close();
	}

	public static void InsertDept(Connection conn) 
			throws SQLException
	{

	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO DEPARTMENT(dept_code, dept_name, office_num, office_phone, college) " +
	    	      "VALUES (?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.print("Enter department code: ");
	      String dcode = getString();
	      System.out.print("Enter department name: ");
	      String dname = getString();
	      System.out.print("Enter office number: ");
	      int onum = getInt();
	      System.out.print("Enter office phone: ");
	      String ophone = getString();
	      System.out.print("Enter college: ");
	      String college = getString();
	     


	      pstmt.setString(1, dcode);
	      pstmt.setString(2, dname);
	      pstmt.setInt(3, onum);
	      pstmt.setString(4, ophone);
	      pstmt.setString(5, college);
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println(NumRows + " row(s) inserted");

	      System.out.print("Hit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      
	      System.out.println("");
	      System.out.println("");
	      } // while done
	    
	}
	
	public static void InsertStudent(Connection conn) throws SQLException {
		
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO STUDENT(stud_ssn, stud_n_num, stud_year, b_day, first_name, middle_name, last_name, degree_program, cur_address, cur_phone,perm_city, perm_state, perm_zip, perm_street, perm_phone, dept_major, dept_minor) " +
	    	      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.print("Enter student ssn: ");
	      String ssn = getString();
	      System.out.print("Enter student N number: ");
	      String nnumber = getString();
	      System.out.print("Enter student year: ");
	      String year = getString();
	      System.out.print("Enter birth day (format: dd-MM-yyyy): ");
	      String bday = getString();
	      Date date = Date.valueOf(bday);
	      System.out.print("Enter first name: ");
	      String fname = getString();
	      System.out.print("Enter middle intial (if none enter null): ");
	      String mname = getString();
	      System.out.print("Enter last name: ");
	      String lname = getString();
	      System.out.print("Enter degree program: ");
	      String dprogram = getString();
	      System.out.print("Enter current address: ");
	      String caddress = getString();
	      System.out.print("Enter current phone: ");
	      String cphone = getString();
	      System.out.print("Enter permanent city: ");
	      String pcity = getString();
	      System.out.print("Enter permanent state: ");
	      String pstate = getString();
	      System.out.print("Enter permanenet zip: ");
	      String pzip = getString();
	      System.out.print("Enter permanenet street: ");
	      String pstreet = getString();
	      System.out.print("Enter permanenet phone: ");
	      String pphone = getString();
	      System.out.print("Enter department major: ");
	      String dmajor = getString();
	      System.out.print("Enter department minor (if none enter Undeclared: ");
	      String dminor = getString();
	     
	     


	      pstmt.setString(1, ssn);
	      pstmt.setString(2, nnumber);
	      pstmt.setString(3, year);
	      pstmt.setDate(4, date);
	      pstmt.setString(5, fname);
	      pstmt.setString(6, mname);
	      pstmt.setString(7, lname);
	      pstmt.setString(8, dprogram);
	      pstmt.setString(9, caddress);
	      pstmt.setString(10, cphone);
	      pstmt.setString(11, pcity);
	      pstmt.setString(12, pstate);
	      pstmt.setString(13, pzip);
	      pstmt.setString(14, pstreet);
	      pstmt.setString(15, pphone);
	      pstmt.setString(16, dmajor);
	      pstmt.setString(17, dminor);
	      
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println(NumRows + "  row(s) inserted");

	      System.out.print("Hit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      
	      System.out.println("");
	      System.out.println("");
	      } // while done
	   
	}
	
	
    public static void InsertInstructor(Connection conn) throws SQLException {
    	

	    // Prepare to insert new vendors into the VENDOR table
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO INSTRUCTOR(ins_n_num, ssn, ins_name, address, phone, age, office_number) " +
	    	      "VALUES (?, ?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.print("Enter instructor N number: ");
	      String innumber = getString();
	      System.out.print("Enter instructor ssn: ");
	      int issn = getInt();
	      System.out.print("Enter instructor name: ");
	      String iname = getString();
	      System.out.print("Enter instructor address: ");
	      String iaddress = getString();
	      System.out.print("Enter instructor phone: ");
	      String iphone = getString();
	      System.out.print("Enter instructor age: ");
	      int iage = getInt();
	      System.out.print("Enter instructor office number ");
	      int ionum = getInt();
	     


	      pstmt.setString(1, innumber);
	      pstmt.setInt(2, issn);
	      pstmt.setString(3, iname);
	      pstmt.setString(4, iaddress);
	      pstmt.setString(5, iphone);
	      pstmt.setInt(6, iage);
	      pstmt.setInt(7, ionum);
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println(NumRows + "  row(s) inserted");

	      System.out.print("Hit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      
	      System.out.println("");
	      System.out.println("");
	      } // while done
	    
    }
    
    public static void  InsertCourse(Connection conn) throws SQLException{
    	
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO COURSE(course_num, course_lvl, course_name, semester_hrs, description, dept_name) " +
	    	      "VALUES (?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.print("Enter course number: ");
	      String cnum = getString();
	      System.out.print("Enter course level: ");
	      int clvl = getInt();
	      System.out.print("Enter course name: ");
	      String cname = getString();
	      System.out.print("Enter semester hours: ");
	      int shours = getInt();
	      System.out.print("Enter description: ");
	      String description = getString();
	      System.out.print("Enter department name: ");
	      String dname = getString();
	      
	     


	      pstmt.setString(1, cnum);
	      pstmt.setInt(2, clvl);
	      pstmt.setString(3, cname);
	      pstmt.setInt(4, shours);
	      pstmt.setString(5, description);
	      pstmt.setString(6, dname);
	      
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println(NumRows + "  row(s) inserted");

	      System.out.print("Hit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      
	      System.out.println("");
	      System.out.println("");
	      } // while done
	    
    }
    
    public static void  InsertSection(Connection conn) throws SQLException{
    	
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO SECTION(ins_n_num, section_num, sec_year, semester, course_num) " +
	    	      "VALUES (?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.print("Enter instructor number: ");
	      String innum = getString();
	      System.out.print("Enter section number: ");
	      int snum = getInt();
	      System.out.print("Enter section year: ");
	      String syear = getString();
	      System.out.print("Enter semester: ");
	      String semester = getString();
	      System.out.print("Enter course number: ");
	      String cnum = getString();
	      
	      
	     


	      pstmt.setString(1, innum);
	      pstmt.setInt(2, snum);
	      pstmt.setString(3, syear);
	      pstmt.setString(4, semester);
	      pstmt.setString(5, cnum);
	      
	      
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println( NumRows + "  row(s) inserted");

	      System.out.print("Hit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      
	      System.out.println("");
	      System.out.println("");
	      } // while done
	    
    }
    
    public static void InsertEnrollStud(Connection conn) throws SQLException {
    	
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO ENROLLS_IN(stud_n_num, section_num, sec_year, semester, course_num, grade) " +
	    	      "VALUES (?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.print("Enter student N number: ");
	      String snnum = getString();
	      System.out.print("Enter section number: ");
	      int secnum = getInt();
	      System.out.print("Enter section year: ");
	      String secyear = getString();
	      System.out.print("Enter semester: ");
	      String semester = getString();
	      System.out.print("Enter course number: ");
	      String cnum = getString();
	      System.out.print("Enter grade: ");
	      String grade = getString();
	     


	      pstmt.setString(1, snnum);
	      pstmt.setInt(2, secnum);
	      pstmt.setString(3, secyear);
	      pstmt.setString(4, semester);
	      pstmt.setString(5, cnum);
	      pstmt.setString(6, grade);
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println( NumRows + "  row(s) inserted");

	      System.out.print("Hit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      System.out.println("");
	      System.out.println("");
	      } // while done
	    
    }
    
    public static void SelectCourseDept(Connection conn) throws SQLException {
    	
	    Statement stmt = conn.createStatement ();

	    System.out.print("Would you like to search by department code or name?: ");
	    String dept = getString();
        String v = "";
	    String q = "";
	    
	     if(dept.equals("code")) {
	    	 System.out.print("Please enter department code: ");
	    	 v = getString();
	    	 q = "SELECT COURSE.course_name, COURSE.course_num " +
		         "FROM DEPARTMENT, COURSE " +
		         "WHERE DEPARTMENT.dept_code= " + v + " AND DEPARTMENT.dept_name = COURSE.dept_name";
	     }
	     
	     else {
	    	 System.out.print("Please enter department name: ");
	    	 v = getString();
	    	 q = "SELECT COURSE.course_name, COURSE.course_num " +
			         "FROM DEPARTMENT, COURSE " +
			         "WHERE DEPARTMENT.dept_name=" + "'" + v + "'"+ " AND DEPARTMENT.dept_name = COURSE.dept_name";
	     }
	    	 
	       
		  
	    
	     ResultSet rset = stmt.executeQuery(q);
         
	     System.out.printf("%-22s%-22s\n","Course Number","Course Name");      
	     System.out.println(""); 
	     while(rset.next ()) {
	       String cname = rset.getString("course_name");
	       String cnum = rset.getString("course_num");
	            
	       
	       System.out.printf("%-22s%-22s\n",cnum,cname);
	      
	     } //if

	     System.out.println("");
	     System.out.println("");
	     stmt.close();
        
    }
    
    public static void SelectCourseInst(Connection conn) throws SQLException {
    	
	    Statement stmt = conn.createStatement ();

	    System.out.print("Enter in Instructor N Number: ");
	    String v = getString();

	      

	      String q = "SELECT COURSE.course_num, SECTION.section_num, COURSE.course_name, INSTRUCTOR.ins_name  " +
	               "FROM SECTION, COURSE, INSTRUCTOR  " +
	               "WHERE COURSE.course_num = SECTION.course_num AND section.ins_n_num = instructor.ins_n_num AND instructor.ins_n_num = " + "'" + v + "'"  ;
		  
	     
	     ResultSet rset = stmt.executeQuery(q);

	     System.out.printf("%-22s%-22s%-22s%-35s\n","Course Number","Section Number","Course Name","Instructor Name");
	     System.out.println("");
	     while (rset.next ()) {
	       String cnum = rset.getString("course_num");
	       int snum = rset.getInt("section_num");
	       String cname = rset.getString("course_name");
	       String iname = rset.getString("ins_name");       
	             
	       System.out.printf("%-22s%-22s%-22s%-35s\n",cnum,snum,cname, iname);
	       
	     } 
	     System.out.println("");
	     System.out.println("");
	       
	     stmt.close();
         
    }
    
    public static void InsertGrade(Connection conn) throws SQLException{
    	
	    Statement stmt = conn.createStatement ();

	    System.out.print("Enter in Student n number: ");
	    String snnum = getString();
	    System.out.print("Enter in course number: ");
	    String cnum = getString();
	    System.out.print("Enter in student's grade: ");
	    String grade = getString();

	      

	      String q = "UPDATE ENROLLS_IN " +
	                 "SET grade = ?" +
	    		     "WHERE grade = 'I' AND ENROLLS_IN.Stud_n_num = ? AND ENROLLS_IN.course_num =  ?";
	                 
		  
	     
	      PreparedStatement pstmt = conn.prepareStatement(q);

	      pstmt.setString(1, grade);
	      pstmt.setString(2, snnum);
	      pstmt.setString(3, cnum);
	      
	     
	      int NumRows = pstmt.executeUpdate();
	      System.out.println(NumRows + " row(s) updated");


	     stmt.close();
         
    }
    
    public static void CalculateGPA(Connection conn) throws SQLException {
    	Statement stmt = conn.createStatement ();

	    System.out.print("Enter in Student N Number: ");
	    String v = getString();

	      

	      String q = "SELECT ENROLLS_IN.grade,ENROLLS_IN.Course_num, STUDENT.Stud_n_num, STUDENT.first_name,STUDENT.Last_name, COURSE.semester_hrs " +
	               "FROM ((ENROLLS_IN INNER JOIN STUDENT ON STUDENT.stud_n_num = ENROLLS_IN.stud_n_num) INNER JOIN COURSE ON COURSE.course_num = ENROLLS_IN.course_num) " +
	               "WHERE ENROLLS_IN.Stud_n_num =" + "'" + v + "'" ;
		  
	     
	     ResultSet rset = stmt.executeQuery(q);

	     int totalshours = 0;
	     double totalgp = 0;
	     double GPA = 0;
	     int i = 0;
	     
	    
	     
	     
	     
	     while (rset.next ()) {
	       
	       if(i == 0) {
	    	 String snnum = rset.getString("stud_n_num");
	  	     String fname = rset.getString("first_name");
	  	     String lname = rset.getString("last_name");
	  	     System.out.println("");
	  	     System.out.printf("The Grade Report For %s %s (%s) Is: \n",fname,lname,snnum);
	  	     System.out.println("");
		     System.out.printf("%-22s%-22s%-22s%-22s\n","Course Name","Semester Hours","Grade"," Gradepoint");
		     System.out.println("");
	       }
	       String cnum = rset.getString("course_num"); 
	       int shours = rset.getInt("semester_hrs");
	       String grade = rset.getString("grade"); 
	       
	       if(!grade.equals("I")) {
	    	   totalshours += shours;
	       }
	       double gradepoint = CalculateGrade(grade);
	       totalgp += gradepoint * (double) shours;      
	       System.out.printf("%-22s%-22s%-22s%-22.2f\n",cnum, shours,grade, gradepoint);
	       i++;
	     } 
	     System.out.println();
	     GPA = totalgp / (double) totalshours;
	     
	     System.out.printf("GPA: %.2f\n",GPA);
	     System.out.println("");
	     System.out.println("");
	       
	     stmt.close();
    }
    
    public static double CalculateGrade(String gletter) {
    	double gradepoint = 0.0;
    	
    	
    	if(gletter.equals("A")) {
    		
    		gradepoint = 4.0;
    	}
    	
    	else if(gletter.equals("B")) {
    		
    		gradepoint = 3.0;
    	}
    	else if(gletter.equals("C")) {
    		
    		gradepoint = 2.0;
    	}
    	else if(gletter.equals("D")) {
    		
    		gradepoint = 1.0;
    	}
    	
    	else {
    		gradepoint = 0.0;
    	}
    	
    	return gradepoint;
    }
       
	public static String getString() {
			try {
			    StringBuffer buffer = new StringBuffer();
			    int c = System.in.read();
			    while (c != '\n' && c != -1) {
				  buffer.append((char)c);
				  c = System.in.read();
			    }
			    return buffer.toString().trim();
			}
			catch (IOException e){return "";}
		    }

		  public static int getInt() 

		  {
		      String s= getString();
		      return Integer.parseInt(s);
		  }
}
