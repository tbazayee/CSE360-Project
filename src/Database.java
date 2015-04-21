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
	static Statement stmt;
	static Connection con;
	public Database()
	{
		initializeDatabase();
		
	}
	public static Connection dbConnection()
	{
		
		 Connection c = null;
		try 
		{
			Class.forName("org.sqlite.JDBC");
		} 
		catch (ClassNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try 
			{
				c = DriverManager.getConnection("jdbc:sqlite:Patients.db");
				//c.setAutoCommit(false);
				return c;
			} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return c;
		
	}
	
	public static void initializeDatabase()
	{
	    con = dbConnection();
	    stmt = null;
    String sql=null;

      try 
      {
    	  stmt = con.createStatement();
	     String sql1 = "CREATE TABLE IF NOT EXISTS PATIENTDATA " +
                  "(FIRSTNAME       TEXT    NOT NULL, " +  "LASTNAME         TEXT    NOT NULL, " +
                  " AGE            INT     NOT NULL, " +" USERNAME        TEXT, " + " PASSWORD         TEXT,"+ 
     			   " SECURITYQN       TEXT,"+" SECURITYANS      TEXT,"+" SYMPTOM1   INT DEFAULT -1,"+ 
     			   " SYMPTOM2   INT DEFAULT -1,"+ " SYMPTOM3   INT DEFAULT -1,"+ " SYMPTOM4   INT DEFAULT -1,"+
     			   " SYMPTOM5   INT DEFAULT -1,"+" SYMPTOM6   INT DEFAULT -1,"+" SYMPTOM7   INT DEFAULT -1,"+ 
     			  " PrevSYMPTOM1_1   INT DEFAULT -1,"+ " PrevSYMPTOM1_2   INT DEFAULT -1,"+ " PrevSYMPTOM1_3   INT DEFAULT -1,"+ 
     			   " PrevSYMPTOM1_4   INT DEFAULT -1,"+" PrevSYMPTOM1_5   INT DEFAULT -1,"+" PrevSYMPTOM1_6   INT DEFAULT -1,"+
     			   " PrevSYMPTOM1_7   INT DEFAULT -1,"+ 
      			  " PrevSYMPTOM2_1   INT DEFAULT -1,"+ " PrevSYMPTOM2_2   INT DEFAULT -1,"+ " PrevSYMPTOM2_3   INT DEFAULT -1,"+ 
    			   " PrevSYMPTOM2_4   INT DEFAULT -1,"+" PrevSYMPTOM2_5   INT DEFAULT -1,"+" PrevSYMPTOM2_6   INT DEFAULT -1,"+
    			   " PrevSYMPTOM2_7   INT DEFAULT -1,"+ 
     			   " SYMPTOM1Thresh   INT DEFAULT 10,"+ " SYMPTOM2Thresh   INT DEFAULT 10,"+ 
     			   " SYMPTOM3Thresh   INT DEFAULT 10,"+" SYMPTOM4Thresh   INT DEFAULT 10,"+
     			   " SYMPTOM5Thresh   INT DEFAULT 10,"+" SYMPTOM6Thresh   INT DEFAULT 10,"+
     			   " SYMPTOM7Thresh   INT DEFAULT 10)";
     //
     stmt.executeUpdate(sql1);
	  }
      catch (SQLException e) 
      {
		// TODO Auto-generated catch block
    	  e.printStackTrace();
	  }
		
	}
//  public static void main( String args[] )
//  {
//
//    String sql=null;
//
//    initializeDatabase();
//
//		     try{
//    			sql = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,SYMPTOM1,"+
//    					"SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,"+
//    					"PrevSYMPTOM1_1,PrevSYMPTOM1_2,PrevSYMPTOM1_3,PrevSYMPTOM1_4,PrevSYMPTOM1_5,PrevSYMPTOM1_6,PrevSYMPTOM1_7,"+
//    					"PrevSYMPTOM2_1,PrevSYMPTOM2_2,PrevSYMPTOM2_3,PrevSYMPTOM2_4,PrevSYMPTOM2_5,PrevSYMPTOM2_6,PrevSYMPTOM2_7,"+
//    					"SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,"+
//    					"SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh) " +
//    					"VALUES ('Jackson','Paul', 32,'pjackson','pj1234','Mothers Name?','Jane',3,0,1,4,3,10,0,3,6,2,1,7,0,13,0,1,4,3,10,0,3,6,2,1,7,0,1,4);"; 
//		      
//				stmt.executeUpdate(sql);
//
//			  sql = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,"+
//  					"PrevSYMPTOM1_1,PrevSYMPTOM1_2,PrevSYMPTOM1_3,PrevSYMPTOM1_4,PrevSYMPTOM1_5,PrevSYMPTOM1_6,PrevSYMPTOM1_7,"+
//  					"PrevSYMPTOM2_1,PrevSYMPTOM2_2,PrevSYMPTOM2_3,PrevSYMPTOM2_4,PrevSYMPTOM2_5,PrevSYMPTOM2_6,PrevSYMPTOM2_7,"+					  
//					  "SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh) " +
//			         "VALUES ('Robinson', 'Mark', 32, 'mrobinson', 'mr1234','Mothers Name?', 'Jessica',3,0,1,4,3,10,0,1,2,3,4,5,6,10,3,0,1,4,3,10,0,1,2,3,4,5,6,10);"; 
//			 stmt.executeUpdate(sql);
//			// c.commit();
//			  sql = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,"+
//  					"PrevSYMPTOM1_1,PrevSYMPTOM1_2,PrevSYMPTOM1_3,PrevSYMPTOM1_4,PrevSYMPTOM1_5,PrevSYMPTOM1_6,PrevSYMPTOM1_7,"+
//  					"PrevSYMPTOM2_1,PrevSYMPTOM2_2,PrevSYMPTOM2_3,PrevSYMPTOM2_4,PrevSYMPTOM2_5,PrevSYMPTOM2_6,PrevSYMPTOM2_7,"+					  	
//					  "SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh) " +
//				         "VALUES ('Parker', 'Paul', 32, 'pparker', 'pp1234&^%','Mothers Name?', 'Paulina',1,9,4,6,5,4,1,6,7,9,1,3,6,9,1,9,4,6,5,4,1,6,7,9,1,3,6,9);"; 
//			 stmt.executeUpdate(sql);
//			 //c.commit();
//			  sql = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,"+
//  					"PrevSYMPTOM1_1,PrevSYMPTOM1_2,PrevSYMPTOM1_3,PrevSYMPTOM1_4,PrevSYMPTOM1_5,PrevSYMPTOM1_6,PrevSYMPTOM1_7,"+
//  					"PrevSYMPTOM2_1,PrevSYMPTOM2_2,PrevSYMPTOM2_3,PrevSYMPTOM2_4,PrevSYMPTOM2_5,PrevSYMPTOM2_6,PrevSYMPTOM2_7,"+
//					  "SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh) " +
//				         "VALUES ('Doe', 'John', 32, 'jdoe', 'jd1234','Mothers Name?', 'Rita',4,9,0,1,8,0,6,1,9,4,6,5,4,1,4,9,0,1,8,0,6,1,9,4,6,5,4,1);"; 
//			 String kpl = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh) ";
//			 String name1="FnamePatien1";
//			 String lasname= "LstnamePatient1";
//			 String unam= "USERNAMEPatien1";
//			 String pas= "PassPatient1";
//			 String sec= "secQuestion?";
//			 String secAns= "secAns";
//			 
//			 kpl = kpl+"VALUES ('"+name1+"', '"+lasname+"', "+25+", '"+unam+"', '"+pas+"', '"+sec+"', '"+secAns+"',1,2,3,4,5,6,7,1,9,4,6,5,4,1);";
//			 System.out.println(kpl);
//			 System.out.println(kpl);
//			 stmt.executeUpdate(kpl);
//			 
//			 kpl = "UPDATE PATIENTDATA set SECURITYANS  = 'wHAHAHA' where FIRSTNAME='Parker';";
//			 stmt.executeUpdate(kpl);
//			 //	 name1= "Teddy";
//		//	 sql = "DELETE from PATIENT where name='"+name1+"';";
//		//     stmt.executeUpdate(sql);
//		//     c.commit();
//		     
//			ResultSet rs = stmt.executeQuery( "SELECT * FROM PATIENTDATA;" );
//			//int[] id1 = null;
//			ArrayList<String> fname = new ArrayList<String>();
//			int i=0;
//			//String[] name2=null;
//			ArrayList<String> lname = new ArrayList<String>();
//			//int[] age1= null;
//			ArrayList<Integer> age1= new ArrayList<Integer>();
//			
//			//String[] address1 = null;
//			ArrayList<String> userName = new ArrayList<String>();
//			
//			//double[] Salary1= null;
//			ArrayList<String> password = new ArrayList<String>();
//			
//			ArrayList<String> secQ = new ArrayList<String>();
//			
//			ArrayList<String> secA = new ArrayList<String>();
//			while (rs.next())
//			 {
//				 String lastname= rs.getString("lastname");
//				 String fname1 = rs.getString("firstname");
//				 int age = rs.getInt("age");
//				 String usrname= rs.getString("username");
//				 String pass1= rs.getString("password");
//				 String secq1 = rs.getString("Securityqn");
//				 String secAns1 = rs.getString("SecurityAns");
//				 
//				 //if (fname1.equals("Parker"))
//				// {
//					fname.add(fname1);
//					lname.add(lastname);
//					age1.add(age);
//					userName.add(usrname);
//					password.add(pass1);
//					secQ.add(secq1);
//					secA.add(secAns1);
//					i++;
//				// }
//				 
//			 }
//			
//			for (int f =0; f<i; f++)
//			{
//				System.out.println("First Name= "+fname.get(f)+"\tLast Name= "+lname.get(f)+"\tAGE= "+age1.get(f)+"\tUsername= "+userName.get(f)+"\tPassword= "+password.get(f)+"\tSecQuetion= "+secQ.get(f)+"\tSecAnswer= "+secA.get(f));
//			}
//			System.out.println("i ="+i);
//	
//			ArrayList<String[]> names = new ArrayList<String[]>();
//			names=getPatientsNameList();
//			//for (int j = 0; j <2; j++)
//			//{
//			String names1[];
//				for (int k=0; k<names.size();k++)
//				{
//					names1 = names.get(k);
//					System.out.println("Frist Name:   "+names1[0]+"   Last Name:    "+names1[1]);
//				}
//				
//			//}
//			
//	}
//      catch (SQLException e) 
//    {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//  }
  //////////////////////////////////////////////////////////////////
  //////  FUNCTION NAME: addPatient()
  ////////////////////////////////////////////////////////////////////////////////////
  public void addPatient(String name,String lasname, int age, String unam, String pas, String sec, String secAns, int sympt[],int prevSm1[],int prevSm2[],int threshold[])
  {
	  String newPat = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,"+
			  		  "SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,"+
  					"PrevSYMPTOM1_1,PrevSYMPTOM1_2,PrevSYMPTOM1_3,PrevSYMPTOM1_4,PrevSYMPTOM1_5,PrevSYMPTOM1_6,PrevSYMPTOM1_7,"+
  					"PrevSYMPTOM2_1,PrevSYMPTOM2_2,PrevSYMPTOM2_3,PrevSYMPTOM2_4,PrevSYMPTOM2_5,PrevSYMPTOM2_6,PrevSYMPTOM2_7,"+
			  		  "SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh) ";
	  newPat = newPat+"VALUES ('"+name+"', '"+lasname+"', "+age+", '"+unam+"', '"+pas+"', '"+sec+"', '"+secAns+"',"
			  		  +sympt[0]+","+sympt[1]+","+sympt[2]+","+sympt[3]+","+sympt[4]+","+sympt[5]+","+sympt[6]+
			  			"," +prevSm1[0]+","+prevSm1[1]+","+prevSm1[2]+","+prevSm1[3]+","+prevSm1[4]+","+prevSm1[5]+","+prevSm1[6]+","
			  			+prevSm2[0]+","+prevSm2[1]+","+prevSm2[2]+","+prevSm2[3]+","+prevSm2[4]+","+prevSm2[5]+","+prevSm2[6]+","
			  			+threshold[0]+","+threshold[1]+","+threshold[2]+","+threshold[3]+","+threshold[4]+","+threshold[5]+","+threshold[6]+");";
	  
	  try {
		stmt.executeUpdate(newPat);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
  }
//////////////////////////////////////////////////////////////////
//////  FUNCTION NAME: getPatientsNameList() Returns Arraylist of array objects of First and Last Name
////////////////////////////////////////////////////////////////////////////////////
  public ArrayList<String[]> getPatientsNameList()
  {
	  String lists[]= new String[2];
	  ArrayList<String[]> name = new ArrayList<String[]>();
	  try 
	  {
		ResultSet rs = stmt.executeQuery( "SELECT * FROM PATIENTDATA;" );
		int i =0;
		while (rs.next())
		{
			lists[0] = rs.getString("LASTNAME");
			lists[1]=rs.getString("FIRSTNAME");
			name.add(lists);
			lists = new String[2];
			i++;
		}
		return name;
	  } 
	  catch (SQLException e) 
	  {
		
		e.printStackTrace();
	  }
	  return name;
	  
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