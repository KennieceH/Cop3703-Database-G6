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

class Insert {

	public static void main(String[] args) 
			throws SQLException
	{
		
	 Scanner input = new Scanner(System.in);
	  System.out.println("Hello, what data would you like to insert or search?");
	  System.out.println("1. Department");
	  System.out.println("2. Student");
	  System.out.println("3. Instructor");
	  System.out.println("4. Enroll a Student into a Course/Section");
	  System.out.println("5. Find Courses offered by Department Name/Code");
	  System.out.println("6. List all Course/Sections for an Instructor");
	 
	  int userInput = input.nextInt();
	  
	  switch(userInput) {
	  
	  case 1: InsertDept(); break;
	  case 2: InsertStudent(); break;
	  case 3: InsertInstructor();break;
	  case 4: InsertEnrollStud(); break;
	  case 5: SelectCourseDept(); break;
	  case 6: SelectCourseInst(); break;
	  }
	  
	
	
	}

	public static void InsertDept() 
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

	    // Prepare to insert new vendors into the VENDOR table
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO DEPARTMENT(dept_code, dept_name, office_num, office_phone, college) " +
	    	      "VALUES (?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.println("\nEnter department code: ");
	      String dcode = getString();
	      System.out.println("\nEnter department name: ");
	      String dname = getString();
	      System.out.println("\n Enter office number: ");
	      int onum = getInt();
	      System.out.println("\n Enter office phone: ");
	      String ophone = getString();
	      System.out.println("\n Enter college: ");
	      String college = getString();
	     


	      pstmt.setString(1, dcode);
	      pstmt.setString(2, dname);
	      pstmt.setInt(3, onum);
	      pstmt.setString(4, ophone);
	      pstmt.setString(5, college);
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println("\n" + NumRows + " row(s) inserted");

	      System.out.println("\nHit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      } // while done
	    conn.close();
	}
	
	public static void InsertStudent() throws SQLException {
		String uid = "G6";
	     

	     
	      String pword = "Fall2022G6";
	      

	    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	    // Load the Oracle JDBC driver
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	    // Connect to the database
	    Connection conn =
	      DriverManager.getConnection (url, uid, pword);

	    // Prepare to insert new vendors into the VENDOR table
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO STUDENT(stud_ssn, stud_n_num, stud_year, b_day, first_name, middle_name, last_name, degree_program, cur_address, cur_phone,perm_city, perm_state, perm_zip, perm_street, perm_phone, dept_major, dept_minor) " +
	    	      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.println("\nEnter student ssn: ");
	      String ssn = getString();
	      System.out.println("\nEnter student N number: ");
	      String nnumber = getString();
	      System.out.println("\n Enter student year: ");
	      String year = getString();
	      System.out.println("\n Enter birth day (format: dd-MM-yyyy): ");
	      String bday = getString();
	      Date date = Date.valueOf(bday);
	      System.out.println("\n Enter first name: ");
	      String fname = getString();
	      System.out.println("\n Enter middle intial (if none enter null): ");
	      String mname = getString();
	      System.out.println("\n Enter last name: ");
	      String lname = getString();
	      System.out.println("\n Enter degree program: ");
	      String dprogram = getString();
	      System.out.println("\n Enter current address: ");
	      String caddress = getString();
	      System.out.println("\n Enter current phone: ");
	      String cphone = getString();
	      System.out.println("\n Enter permanent city: ");
	      String pcity = getString();
	      System.out.println("\n Enter permanent state: ");
	      String pstate = getString();
	      System.out.println("\n Enter permanenet zip: ");
	      String pzip = getString();
	      System.out.println("\n Enter permanenet street: ");
	      String pstreet = getString();
	      System.out.println("\n Enter permanenet phone: ");
	      String pphone = getString();
	      System.out.println("\n Enter department major: ");
	      String dmajor = getString();
	      System.out.println("\n Enter department minor (if none enter Undeclared: ");
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
	      System.out.println("\n" + NumRows + " row(s) inserted");

	      System.out.println("\nHit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      } // while done
	    conn.close();
	}
	
	
    public static void InsertInstructor() throws SQLException {
    	String uid = "G6";
	     

	     
	      String pword = "Fall2022G6";
	      

	    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	    // Load the Oracle JDBC driver
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	    // Connect to the database
	    Connection conn =
	      DriverManager.getConnection (url, uid, pword);

	    // Prepare to insert new vendors into the VENDOR table
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO INSTRUCTOR(ins_n_num, ssn, ins_name, address, phone, age, office_number) " +
	    	      "VALUES (?, ?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.println("\n Enter instructor N number: ");
	      String innumber = getString();
	      System.out.println("\n Enter instructor ssn: ");
	      int issn = getInt();
	      System.out.println("\n Enter instructor name: ");
	      String iname = getString();
	      System.out.println("\n Enter instructor address: ");
	      String iaddress = getString();
	      System.out.println("\n Enter instructor phone: ");
	      String iphone = getString();
	      System.out.println("\n Enter instructor age: ");
	      int iage = getInt();
	      System.out.println("\n Enter instructor office number ");
	      int ionum = getInt();
	     


	      pstmt.setString(1, innumber);
	      pstmt.setInt(2, issn);
	      pstmt.setString(3, iname);
	      pstmt.setString(4, iaddress);
	      pstmt.setString(5, iphone);
	      pstmt.setInt(6, iage);
	      pstmt.setInt(7, ionum);
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println("\n" + NumRows + " row(s) inserted");

	      System.out.println("\nHit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      } // while done
	    conn.close();
    }
    
    public static void InsertEnrollStud() throws SQLException {
    	String uid = "G6";
	     

	     
	      String pword = "Fall2022G6";
	      

	    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	    // Load the Oracle JDBC driver
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	    // Connect to the database
	    Connection conn =
	      DriverManager.getConnection (url, uid, pword);

	    // Prepare to insert new vendors into the VENDOR table
	    PreparedStatement pstmt =
	    	      conn.prepareStatement ("INSERT INTO ENROLLS_IN(stud_n_num, section_num, sec_year, semester, course_num, grade) " +
	    	      "VALUES (?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    while (done != 0) {
	      System.out.println("\n Enter student N number: ");
	      String snnum = getString();
	      System.out.println("\nEnter section number: ");
	      int secnum = getInt();
	      System.out.println("\n Enter section year: ");
	      String secyear = getString();
	      System.out.println("\n Enter semester: ");
	      String semester = getString();
	      System.out.println("\n Enter course number: ");
	      String cnum = getString();
	      System.out.println("\n Enter grade: ");
	      String grade = getString();
	     


	      pstmt.setString(1, snnum);
	      pstmt.setInt(2, secnum);
	      pstmt.setString(3, secyear);
	      pstmt.setString(4, semester);
	      pstmt.setString(5, cnum);
	      pstmt.setString(6, grade);
	        
	      int NumRows = pstmt.executeUpdate();
	      System.out.println("\n" + NumRows + " row(s) inserted");

	      System.out.println("\nHit 0 for exit, " +
		     "or enter any other number for another insert: ");
	      done = getInt();
	      } // while done
	    conn.close();
    }
    
    public static void SelectCourseDept() throws SQLException {
    	String uid = "G6";
	     

	     
	     String pword = "Fall2022G6";
	      

	    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	    // Load the Oracle JDBC driver
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	    // Connect to the database
	    Connection conn =
	      DriverManager.getConnection (url, uid, pword);
	    Statement stmt = conn.createStatement ();

	    System.out.print("\n Would you like to search by department code or name?: ");
	    String dept = getString();
        String v = "";
	      // Select the V_NAME column from the VENDOR table
          String q = "";
	     if(dept.equals("code")) {
	    	 System.out.print("\n Please enter department code: ");
	    	 v = getString();
	    	 q = "SELECT COURSE.course_name, COURSE.course_num " +
		         "FROM DEPARTMENT, COURSE " +
		         "WHERE DEPARTMENT.dept_code= " + v + " AND DEPARTMENT.dept_name = COURSE.dept_name";
	     }
	     
	     else {
	    	 System.out.print("\n Please enter department name: ");
	    	 v = getString();
	    	 q = "SELECT COURSE.course_name, COURSE.course_num " +
			         "FROM DEPARTMENT, COURSE " +
			         "WHERE DEPARTMENT.dept_name=" + "'" + v + "'"+ " AND DEPARTMENT.dept_name = COURSE.dept_name";
	     }
	    	 
	       
		  
	    
	     ResultSet rset = stmt.executeQuery(q);

	     while(rset.next ()) {
	       String cname = rset.getString("course_name");
	       String cnum = rset.getString("course_num");
	            
	       System.out.println("Course Number:    " + "Course Name: ");
	       System.out.printf("%s %20s", cnum, cname);
	       System.out.println("");
	       System.out.println("");
	     } //if

	     stmt.close();
         conn.close();
    }
    
    public static void SelectCourseInst() throws SQLException {
    	String uid = "G6";
	     

	     
	      String pword = "Fall2022G6";
	      

	    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	    // Load the Oracle JDBC driver
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	    // Connect to the database
	    Connection conn =
	      DriverManager.getConnection (url, uid, pword);
	    Statement stmt = conn.createStatement ();

	    System.out.print("\nEnter existing vendor code: ");
	    int v = getInt();

	      // Select the V_NAME column from the VENDOR table

	      String q = "SELECT * " +
	               "FROM VENDOR " +
	               "WHERE V_CODE= " + v ;
		  
	     
	     ResultSet rset = stmt.executeQuery(q);

	     if (rset.next ()) {
	       String vname = rset.getString("V_NAME");
	       String vcontact = rset.getString("V_CONTACT");
	       int vareacode = rset.getInt("V_AREACODE");
	       String vphone = rset.getString("V_PHONE");       
	       String vstate = rset.getString("V_STATE");       
	       

	       System.out.println("\nVendor name is: " + vname);
	       System.out.println("Vendor contact is: " + vcontact);
	       System.out.println("Vendor phone is: (" + vareacode + ")" + vphone);
	       System.out.println("Vendor state is: " + vstate);
	     } //if

	     stmt.close();
         conn.close();
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
