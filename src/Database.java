/* 
 * CSE 
 * 
*/

import java.awt.Image;
import java.sql.*;
import java.util.*;
//import java.
public class Database
{
  public static void main( String args[] )
  {
    //Connection c = null;
    Statement stmt = null;
    String sql=null;
      //Class.forName("org.sqlite.JDBC");
    try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    Connection c = null;
	try {
		c = DriverManager.getConnection("jdbc:sqlite:Patients.db");
		//c.setAutoCommit(false);
	} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   // c = DriverManager.getConnection("jdbc:sqlite:Patient.db");
      try 
      {
    	  stmt = c.createStatement();
	  }
      catch (SQLException e) 
      {
		// TODO Auto-generated catch block
    	  e.printStackTrace();
	  }
      try 
      {
		      sql = "CREATE TABLE PATIENT " +
		                   "(FIRSTNAME       TEXT    NOT NULL, " + 
		                   "LASTNAME         TEXT    NOT NULL, " +
		                   " AGE            INT     NOT NULL, " + 
		                   " USERNAME        TEXT, " + 
		                   " PASSWORD         TEXT,"+ 
		      			   " SECURITYQN       TEXT,"+
		                   " SECURITYANS      TEXT)";
		      //
		     // stmt.executeUpdate(sql);
		      //c.commit();
		      sql = "INSERT INTO PATIENT (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS) " +
		      "VALUES ('Jackson','Paul', 32,'pjackson','pj1234','Mothers Name?','Jane');"; 
		      
				stmt.executeUpdate(sql);
				//c.commit();
			//} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
			//try{
			  sql = "INSERT INTO PATIENT (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS) " +
			         "VALUES ('Robinson', 'Mark', 32, 'mrobinson', 'mr1234','Mothers Name?', 'Jessica');"; 
			 stmt.executeUpdate(sql);
			// c.commit();
			  sql = "INSERT INTO PATIENT (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS) " +
				         "VALUES ('Parker', 'Paul', 32, 'pparker', 'pp1234','Mothers Name?', 'Paulina' );"; 
			 stmt.executeUpdate(sql);
			 //c.commit();
			  sql = "INSERT INTO PATIENT (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS) " +
				         "VALUES ('Doe', 'John', 32, 'jdoe', 'jd1234','Mothers Name?', 'Rita');"; 
			 String kpl = "INSERT INTO PATIENT (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS) ";
			 String name1="FnamePatien1";
			 String lasname= "LstnamePatient1";
			 String unam= "USERNAMEPatien1";
			 String pas= "PassPatient1";
			 String sec= "secQuestion?";
			 String secAns= "secAns";
			 
			 kpl = kpl+"VALUES ('"+name1+"', '"+lasname+"', "+25+", '"+unam+"', '"+pas+"', '"+sec+"', '"+secAns+"');";
			 System.out.println(kpl);
			 System.out.println(kpl);
			 stmt.executeUpdate(kpl);
		//	 name1= "Teddy";
		//	 sql = "DELETE from PATIENT where name='"+name1+"';";
		//     stmt.executeUpdate(sql);
		//     c.commit();
		//	 name1= "Paul";
		//	 sql = "DELETE from PATIENT where name='"+name1+"';";
		//     stmt.executeUpdate(sql);
		//     c.commit();
		     
			ResultSet rs = stmt.executeQuery( "SELECT * FROM PATIENT;" );
			//int[] id1 = null;
			ArrayList<String> fname = new ArrayList<String>();
			int i=0;
			//String[] name2=null;
			ArrayList<String> lname = new ArrayList<String>();
			//int[] age1= null;
			ArrayList<Integer> age1= new ArrayList<Integer>();
			
			//String[] address1 = null;
			ArrayList<String> userName = new ArrayList<String>();
			
			//double[] Salary1= null;
			ArrayList<String> password = new ArrayList<String>();
			
			ArrayList<String> secQ = new ArrayList<String>();
			
			ArrayList<String> secA = new ArrayList<String>();
			while (rs.next())
			 {
				 String lastname= rs.getString("lastname");
				 String fname1 = rs.getString("firstname");
				 int age = rs.getInt("age");
				 String usrname= rs.getString("username");
				 String pass1= rs.getString("password");
				 String secq1 = rs.getString("Securityqn");
				 String secAns1 = rs.getString("SecurityAns");
				 
				 //if (name.equals("Allen"))
				 //{
					fname.add(fname1);
					lname.add(lastname);
					age1.add(age);
					userName.add(usrname);
					password.add(pass1);
					secQ.add(secq1);
					secA.add(secAns1);
					i++;
				 //}
				 
			 }
			
			for (int f =0; f<i; f++)
			{
				System.out.println("First Name= "+fname.get(f)+"\tLast Name= "+lname.get(f)+"\tAGE= "+age1.get(f)+"\tUsername= "+userName.get(f)+"\tPassword= "+password.get(f)+"\tSecQuetion= "+secQ.get(f)+"\tSecAnswer= "+secA.get(f));
			}
			System.out.println("i ="+i);
	
	}
      catch (SQLException e) 
    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public void addPatient(String name,String lasname, int age, String unam, String pas, String sec, String secAns)
  {
	  String newPat = "INSERT INTO PATIENT (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS) ";
	  newPat = newPat+"VALUES ('"+name+"', '"+lasname+"', "+25+", '"+unam+"', '"+pas+"', '"+sec+"', '"+secAns+"');";
	  
	
  }
  public void removePatient(String name)
  {
	  
	  
  }
}




/* 
 * CSE 
 * 
*/
/*
import java.awt.Image;
import java.sql.*;
import java.util.*;
//import java.
public class Database
{
  public static void main( String args[] )
  {
    //Connection c = null;
    Statement stmt = null;
    String sql=null;
      //Class.forName("org.sqlite.JDBC");
    try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    Connection c = null;
	try {
		c = DriverManager.getConnection("jdbc:sqlite:test1.db");
		c.setAutoCommit(false);
	} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   // c = DriverManager.getConnection("jdbc:sqlite:test.db");
      try 
      {
		stmt = c.createStatement();
	  }
      catch (SQLException e) 
      {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
      try {
      sql = "CREATE TABLE COMPANY " +
                   "(ID INT      NOT NULL," +
                   " NAME           TEXT    NOT NULL, " + 
                   " AGE            INT     NOT NULL, " + 
                   " ADDRESS        CHAR(50), " + 
                   " SALARY         REAL)"; 
      //stmt.executeUpdate(sql);
      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
              "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
	
		stmt.executeUpdate(sql);
		c.commit();
	//} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	//}
	//try{
	 sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	       "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
	 stmt.executeUpdate(sql);
	 c.commit();
	 sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	       "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
	 stmt.executeUpdate(sql);
	 c.commit();
	 sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	       "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
	 String kpl = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) ";
	 String name1="Patien1";
	 kpl = kpl+"VALUES ("+6+", '"+name1+"', "+25+", '"+name1+" ', "+65555.00+" );";
	 System.out.println(kpl);
	 System.out.println(kpl);
	 stmt.executeUpdate(kpl);
	 name1= "Teddy";
	 sql = "DELETE from COMPANY where name='"+name1+"';";
     stmt.executeUpdate(sql);
     c.commit();
	 name1= "Paul";
	 sql = "DELETE from COMPANY where name='"+name1+"';";
     stmt.executeUpdate(sql);
     c.commit();
     
	ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
	//int[] id1 = null;
	ArrayList<Integer> id1 = new ArrayList<Integer>();
	int i=0;
	//String[] name2=null;
	ArrayList<String> name2 = new ArrayList<String>();
	//int[] age1= null;
	ArrayList<Integer> age1= new ArrayList<Integer>();
	
	//String[] address1 = null;
	ArrayList<String> address1 = new ArrayList<String>();
	
	//double[] Salary1= null;
	ArrayList<Double> Salary1 = new ArrayList<Double>();
	while (rs.next())
	 {
		 int id= rs.getInt("id");
		 String name = rs.getString("name");
		 int age = rs.getInt("age");
		 String address= rs.getString("address");
		 double Salary = rs.getDouble("Salary");
		 
		 //if (name.equals("Allen"))
		 //{
			id1.add(id);
			name2.add(name);
			age1.add(age);
			address1.add(address);
			Salary1.add(Salary);
			i++;
		 //}
		 
	 }
	
	for (int f =0; f<i; f++)
	{
		System.out.println("ID= "+id1.get(f)+"\tNAME= "+name2.get(f)+"\tAGE= "+age1.get(f)+"\tADDRESS= "+address1.get(f)+"\tSalary= "+Salary1.get(f));
	}
	System.out.println("i ="+i);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}*/