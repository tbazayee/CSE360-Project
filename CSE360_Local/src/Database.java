/* 
 * CSE 
 * 
*/

import java.awt.Image;
import java.sql.*;
import java.util.*;


public class Database
{
	static Statement stmt; // needed to execute a command in Sql language
	static Connection con; // variable for Connection with database file
	public Database()
	{
		initializeDatabase();
		
	}
	///////////////////////////////////////////////////////////////////
	// Establishes a connection with the database and returns Connection type
	///////////////////////////////////////////////////////////////////////////
	public static Connection dbConnection()
	{
		
		 Connection c = null;
		try 
		{
			Class.forName("org.sqlite.JDBC");
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
			try 
			{
				c = DriverManager.getConnection("jdbc:sqlite:Patients.db");
				
				return c;
			} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			return c;
		
	}
	
	public static void initializeDatabase()
	{
		
	    con = dbConnection();
	    stmt = null;

      try 
      {
   ///////Creating the Patient Database Table if not already there.	
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
     			   " SYMPTOM7Thresh   INT DEFAULT 10, DOCTORSNAME  TEXT)";

     stmt.executeUpdate(sql1);

     //Creating Doctors Database Table if not there 
     sql1 = "CREATE TABLE IF NOT EXISTS DOCTORDATA " +
             "(FIRSTNAME       TEXT    NOT NULL, " +  "LASTNAME         TEXT    NOT NULL, " +
             "USERNAME        TEXT, " + " PASSWORD         TEXT,"+ 
			   " SECURITYQN       TEXT,"+" SECURITYANS      TEXT)";
     stmt.executeUpdate(sql1);
     
     
     
	  }
      catch (SQLException e) 
      {
		// TODO Auto-generated catch block
    	  e.printStackTrace();
	  }
		
	}

  /////////////////////////////////////////////////////////////////////////////////////////////////
  //////  FUNCTION NAME: addPatient(): Adds patient to the database based on the information given
  ////////////////////////////////////////////////////////////////////////////////////////////////
  public void addPatient(String name,String lasname, int age, String unam, String pas, String sec, String secAns, int sympt[],int prevSm1[],int prevSm2[],int threshold[], String dname)
  {
	  String newPat = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,"+
			  		  "SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,"+
  					"PrevSYMPTOM1_1,PrevSYMPTOM1_2,PrevSYMPTOM1_3,PrevSYMPTOM1_4,PrevSYMPTOM1_5,PrevSYMPTOM1_6,PrevSYMPTOM1_7,"+
  					"PrevSYMPTOM2_1,PrevSYMPTOM2_2,PrevSYMPTOM2_3,PrevSYMPTOM2_4,PrevSYMPTOM2_5,PrevSYMPTOM2_6,PrevSYMPTOM2_7,"+
			  		  "SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh, DOCTORSNAME) ";
	  newPat = newPat+"VALUES ('"+name+"', '"+lasname+"', "+age+", '"+unam+"', '"+pas+"', '"+sec+"', '"+secAns+"',"
			  		  +sympt[0]+","+sympt[1]+","+sympt[2]+","+sympt[3]+","+sympt[4]+","+sympt[5]+","+sympt[6]+
			  			"," +prevSm1[0]+","+prevSm1[1]+","+prevSm1[2]+","+prevSm1[3]+","+prevSm1[4]+","+prevSm1[5]+","+prevSm1[6]+","
			  			+prevSm2[0]+","+prevSm2[1]+","+prevSm2[2]+","+prevSm2[3]+","+prevSm2[4]+","+prevSm2[5]+","+prevSm2[6]+","
			  			+threshold[0]+","+threshold[1]+","+threshold[2]+","+threshold[3]+","+threshold[4]+","+threshold[5]+","+threshold[6]+",'"+dname+"');";
	  
	  try {
		stmt.executeUpdate(newPat);
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
  }
  
///////////////////////////////////////////////////////////////////////////////////////
///takes in a Patient Object and inserts the patient info in the Patient Database.
////////////////////////////////////////////////////////////////////////////////////////  
  public void addPatient(Patient P)
  {
	  int age =0;
	  String secQ ="What is your favorite food?";
	  String newPat = "INSERT INTO PATIENTDATA (FIRSTNAME,LASTNAME,AGE,USERNAME,PASSWORD,SECURITYQN,SECURITYANS,"+
			  		  "SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOM6,SYMPTOM7,"+
  					"PrevSYMPTOM1_1,PrevSYMPTOM1_2,PrevSYMPTOM1_3,PrevSYMPTOM1_4,PrevSYMPTOM1_5,PrevSYMPTOM1_6,PrevSYMPTOM1_7,"+
  					"PrevSYMPTOM2_1,PrevSYMPTOM2_2,PrevSYMPTOM2_3,PrevSYMPTOM2_4,PrevSYMPTOM2_5,PrevSYMPTOM2_6,PrevSYMPTOM2_7,"+
			  		  "SYMPTOM1Thresh,SYMPTOM2Thresh,SYMPTOM3Thresh,SYMPTOM4Thresh,SYMPTOM5Thresh,SYMPTOM6Thresh,SYMPTOM7Thresh, DOCTORSNAME) ";
	  newPat = newPat+"VALUES ('"+P.firstName+"', '"+P.lastName+"', "+age+", '"+P.userName+"', '"+P.password+"', '"+secQ+"', '"+P.securityQuestionAnswer+"',"
			  		  +P.getEnterSymptomLevel()[0]+","+P.getEnterSymptomLevel()[1]+","+P.getEnterSymptomLevel()[2]+","+P.getEnterSymptomLevel()[3]+","+P.getEnterSymptomLevel()[4]+","+P.getEnterSymptomLevel()[5]+","+P.getEnterSymptomLevel()[6]+
			  			"," +P.getPreviousSymptomLevel1()[0]+","+P.getPreviousSymptomLevel1()[1]+","+P.getPreviousSymptomLevel1()[2]+","+P.getPreviousSymptomLevel1()[3]+","+P.getPreviousSymptomLevel1()[4]+","+P.getPreviousSymptomLevel1()[5]+","+P.getPreviousSymptomLevel1()[6]+","
			  			+P.getPreviousSymptomLevel2()[0]+","+P.getPreviousSymptomLevel2()[1]+","+P.getPreviousSymptomLevel2()[2]+","+P.getPreviousSymptomLevel2()[3]+","+P.getPreviousSymptomLevel2()[4]+","+P.getPreviousSymptomLevel2()[5]+","+P.getPreviousSymptomLevel2()[6]+","
			  			+P.getSymptomsThreshold()[0]+","+P.getSymptomsThreshold()[1]+","+P.getSymptomsThreshold()[2]+","+P.getSymptomsThreshold()[3]+","+P.getSymptomsThreshold()[4]+","+P.getSymptomsThreshold()[5]+","+P.getSymptomsThreshold()[6]+",'"+P.getPatientsDoctor()+"');";
	  
	  try {
		stmt.executeUpdate(newPat);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
  }
  
  ////////////////////////////////////////////////////
  //Inserts a Doctor object to the Doctor Table database.    /////
  ///////////////////////////////////////////////////
  public void addDoctor(Doctor D)
  {
	 try{
		 
		 
	 String command =  "INSERT INTO DOCTORDATA (FIRSTNAME,LASTNAME,USERNAME,PASSWORD,SECURITYQN,SECURITYANS)"+
			 "VALUES ('"+D.firstName+"', '"+D.lastName+"', '"+D.userName+"', '"+D.password+"', '"+D.securityQuestion+"', '"+D.securityQuestionAnswer+"');";
	 stmt.executeUpdate(command);
	 
	 
	 } catch (SQLException e) {
			
			e.printStackTrace();
	}
	 
  }
  
  public void addDoctor(String name, String lastname, String userName, String pass, String secAns )
  {
	 try{
		 
		 
	 String command =  "INSERT INTO DOCTORDATA (FIRSTNAME,LASTNAME,USERNAME,PASSWORD,SECURITYQN,SECURITYANS)"+
			 "VALUES ('"+name+"', '"+lastname+"', '"+userName+"', '"+pass+"', '"+"What is Your favorite food?"+"', '"+secAns+"');";
	 stmt.executeUpdate(command);
	 
	 
	 } catch (SQLException e) {
			
			e.printStackTrace();
	}
	 
  }
  
  public boolean isPatientInDatabase(String fname, String lname)
  {
	  boolean exists = false;
	  
	  
	  return exists;
	  
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
 
  
  
  /// Implements database command to remove patient from the database. 
  public void removePatientFromDB(String fname, String lname)
  {
  	 String sql1 = "DELETE from PATIENTDATA where firstname='"+fname+"' AND lastname='"+lname+"';";
       try {
		stmt.executeUpdate(sql1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  /// Implements databse command to remove patient from the database based on the first and last name.
  public void removePatientFromDB(Patient P1)
  {
  	 String sql1 = "DELETE from PATIENTDATA where firstname='"+P1.firstName+"' AND lastname='"+P1.lastName+"';";
       try {
		stmt.executeUpdate(sql1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
 
  
  //******************************************
  //Password Check Methods....................
  public boolean patientUserNamecheck(String Username)
  {
	  boolean match= false;
	  
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM PATIENTDATA;" );
		
	  String dbuserN = "";
		
		
		while(rs.next())
		{
			dbuserN = rs.getString("username");
			
			if (dbuserN.equals(Username))
			{
				match = true;
			}
		
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}		
	  return match;
  }
  
  public boolean patientPasswordCheck(String Pass)
  {
	  boolean match= false;
	  
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM PATIENTDATA;" );
		
	  String dbPass = "";
		
		
		while(rs.next())
		{
			dbPass = rs.getString("password");
			
			if (dbPass.equals(Pass))
			{
				match = true;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return match;
  }
  
  
  public boolean docUsernameCheck(String usrname)
  {
	  boolean match= false;
	  
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM DOCTORDATA;" );
		
	  String uname = "";
		
		
		while(rs.next())
		{
			uname = rs.getString("username");
			
			if (uname.equals(usrname))
			{
				match = true;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return match;
  }
  
  public boolean docPasswordCheck(String Pass)
  {
	  boolean match= false;
	  
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM DOCTORDATA;" );
		
	  String dbPass = "";
		
		
		while(rs.next())
		{
			dbPass = rs.getString("password");
			
			if (dbPass.equals(Pass))
			{
				match = true;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return match;
  }
  
  public String getDoctorAnswer(String UserN)
  {
	  String answer= "";
	  String Username="";
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM DOCTORDATA;" );
		
		
		
		while(rs.next())
		{
			Username = rs.getString("username");
			answer = rs.getString("securityans");
			
			
			if (UserN.equals(Username))
			{
				return answer;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return answer;
  }
  
  public String getPatientAnswer(String UserN)
  {
	  String answer= "";
	  String Username="";
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM PATIENTDATA;" );
		
		
		
		while(rs.next())
		{
			Username = rs.getString("username");
			answer = rs.getString("securityans");
			
			
			if (UserN.equals(Username))
			{
				return answer;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return answer;
  }
  
  //public String 
  public String getPatientPassword(String UserN)
  {
	  String pass= "";
	  String Username="";
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM PATIENTDATA;" );
		
		
		
		while(rs.next())
		{
			Username = rs.getString("username");
			pass = rs.getString("password");
			
			
			if (UserN.equals(Username))
			{
				return pass;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return pass;
  }
  
  public String getDocPassword(String UserN)
  {
	  String pass= "";
	  String Username="";
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM DOCTORDATA;" );
		
		
		
		while(rs.next())
		{
			Username = rs.getString("username");
			pass = rs.getString("password");
			
			
			if (UserN.equals(Username))
			{
				return pass;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return pass;
  }
  
  
  public boolean patientCheck(String Username,String Pass)
  {
	  boolean match= false;
	  
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM PATIENTDATA;" );
		
	  String dbPass = "";
	  String dbUser = "";
		
		
		while(rs.next())
		{
			dbUser = rs.getString("username");
			dbPass = rs.getString("password");
			
			
			if (dbPass.equals(Pass)&& dbUser.equals(Username))
			{
				match = true;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return match;
  }
  
  
  public boolean docCheck(String Username,String Pass)
  {
	  boolean match= false;
	  
	  ResultSet rs;
	try {
		rs = stmt.executeQuery("SELECT * FROM DOCTORDATA;" );
		
	  String dbPass = "";
	  String dbUser = "";
		
		
		while(rs.next())
		{
			dbUser = rs.getString("username");
			dbPass = rs.getString("password");
			
			
			if (dbPass.equals(Pass)&& dbUser.equals(Username))
			{
				match = true;
			}
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	  return match;
  }
  
  
  //**********************************************************************
  
  public Patient getPatient(String usrname, String pas)
  {
	  String fname = "Empty";
	  String lname = "Empty";
	  String userName ="Empty";
	  String passWord = "Empty";
	  String secAns ="Empty";
	  String DocName = "Empty";
		int symp[]= new int[7];
		int pr1[]=new int[7];
		int pr2[]=new int[7];
		int thrs[]=new int[7]; 
	  
	  try 
	  {
		ResultSet rs = stmt.executeQuery( "SELECT * FROM PATIENTDATA;" );
		int i =0;
		while (rs.next())
		{
			fname = rs.getString("firstname");
			lname = rs.getString("lastname");
			userName = rs.getString("username");
			passWord = rs.getString("password");
			secAns = rs.getString("securityans");
			DocName = rs.getString("doctorsname");
			// if the name matches the doctor's name, then Add to the Patient Arraylist.
			if (userName.equals(usrname)&& pas.equals(passWord))	
			{
				
				symp[0] = rs.getInt("SYMPTOM1");
				symp[1] = rs.getInt("SYMPTOM2");
				symp[2] = rs.getInt("SYMPTOM3");
				symp[3] = rs.getInt("SYMPTOM4");
				symp[4] = rs.getInt("SYMPTOM5");
				symp[5] = rs.getInt("SYMPTOM6");
				symp[6] = rs.getInt("SYMPTOM7");
				
				pr1[0] = rs.getInt("PrevSYMPTOM1_1");
				pr1[1] = rs.getInt("PrevSYMPTOM1_2");
				pr1[2] = rs.getInt("PrevSYMPTOM1_3");
				pr1[3] = rs.getInt("PrevSYMPTOM1_4");
				pr1[4] = rs.getInt("PrevSYMPTOM1_5");
				pr1[5] = rs.getInt("PrevSYMPTOM1_6");
				pr1[6] = rs.getInt("PrevSYMPTOM1_7");
				
				pr2[0] = rs.getInt("PrevSYMPTOM2_1");
				pr2[1] = rs.getInt("PrevSYMPTOM2_2");
				pr2[2] = rs.getInt("PrevSYMPTOM2_3");
				pr2[3] = rs.getInt("PrevSYMPTOM2_4");
				pr2[4] = rs.getInt("PrevSYMPTOM2_5");
				pr2[5] = rs.getInt("PrevSYMPTOM2_6");
				pr2[6] = rs.getInt("PrevSYMPTOM2_7");

				
				thrs[0] = rs.getInt("SYMPTOM1Thresh");
				thrs[1] = rs.getInt("SYMPTOM2Thresh");
				thrs[2] = rs.getInt("SYMPTOM3Thresh");
				thrs[3] = rs.getInt("SYMPTOM4Thresh");
				thrs[4] = rs.getInt("SYMPTOM5Thresh");
				thrs[5] = rs.getInt("SYMPTOM6Thresh");
				thrs[6] = rs.getInt("SYMPTOM7Thresh");
				
				Patient P1 = new Patient(fname,lname,userName,passWord,secAns,DocName,symp,pr1,pr2,thrs);
				//make new Patient object with the patient informations.
				return P1;
				
			}
		}
		
		Patient P1 = new Patient(fname,lname,userName,passWord,secAns,DocName,symp,pr1,pr2,thrs);
		return P1;  // Return Patient
	  } 
	  catch (SQLException e) 
	  {
		
		e.printStackTrace();
	  }
	  Patient P1 = new Patient(fname,lname,userName,passWord,secAns,DocName,symp,pr1,pr2,thrs);
	  return P1;  // Return Patient
	  
  }
  
  
  public Doctor getDoctor(String usrname, String pas)
  {
	  String fname = "Empty";
	  String lname = "Empty";
	  String userName ="Empty";
	  String passWord = "Empty";
	  String secAns ="Empty";
	  
	  try 
	  {
		ResultSet rs = stmt.executeQuery( "SELECT * FROM DOCTORDATA;" );
		int i =0;
		while (rs.next())
		{
			fname = rs.getString("firstname");
			lname = rs.getString("lastname");
			userName = rs.getString("username");
			passWord = rs.getString("password");
			secAns = rs.getString("securityans");
			
			// if the name matches the doctor's name, then Add to the Patient Arraylist.
			if (userName.equals(usrname)&& pas.equals(passWord))	
			{
				
				Doctor Doc = new Doctor(fname,lname,userName,passWord,secAns);
				//make new Patient object with the patient informations.
				return Doc;
				
			}
		}
		
		Doctor Doc = new Doctor(fname,lname,userName,passWord,secAns);
		//make new Patient object with Doctors.
		return Doc;
	  } 
	  catch (SQLException e) 
	  {
		
		e.printStackTrace();
	  }
		Doctor Doc = new Doctor(fname,lname,userName,passWord,secAns);
		//make new Patient object with the patient informations.
		return Doc;
	  
  }
  
  
  
  public ArrayList<Patient> getPatientList(String DocName)
  {
	  // Create an Arraylist of Patient Objects to load from the database
	  ArrayList<Patient> names = new ArrayList<Patient>();
	  
	  try 
	  {
		ResultSet rs = stmt.executeQuery( "SELECT * FROM PATIENTDATA;" );
		int i =0;
		while (rs.next())
		{
			String fname = rs.getString("firstname");
			String lname = rs.getString("lastname");
			String userName = rs.getString("username");
			String passWord = rs.getString("password");
			String secAns = rs.getString("securityans");
			String check = rs.getString("doctorsname");
			// if the name matches the doctor's name, then Add to the Patient Arraylist.
			if (check.equals(DocName))	
			{
				int symp[]= new int[7];
				int pr1[]=new int[7];
				int pr2[]=new int[7];
				int thrs[]=new int[7]; 
				
				symp[0] = rs.getInt("SYMPTOM1");
				symp[1] = rs.getInt("SYMPTOM2");
				symp[2] = rs.getInt("SYMPTOM3");
				symp[3] = rs.getInt("SYMPTOM4");
				symp[4] = rs.getInt("SYMPTOM5");
				symp[5] = rs.getInt("SYMPTOM6");
				symp[6] = rs.getInt("SYMPTOM7");
				
				pr1[0] = rs.getInt("PrevSYMPTOM1_1");
				pr1[1] = rs.getInt("PrevSYMPTOM1_2");
				pr1[2] = rs.getInt("PrevSYMPTOM1_3");
				pr1[3] = rs.getInt("PrevSYMPTOM1_4");
				pr1[4] = rs.getInt("PrevSYMPTOM1_5");
				pr1[5] = rs.getInt("PrevSYMPTOM1_6");
				pr1[6] = rs.getInt("PrevSYMPTOM1_7");
				
				pr2[0] = rs.getInt("PrevSYMPTOM2_1");
				pr2[1] = rs.getInt("PrevSYMPTOM2_2");
				pr2[2] = rs.getInt("PrevSYMPTOM2_3");
				pr2[3] = rs.getInt("PrevSYMPTOM2_4");
				pr2[4] = rs.getInt("PrevSYMPTOM2_5");
				pr2[5] = rs.getInt("PrevSYMPTOM2_6");
				pr2[6] = rs.getInt("PrevSYMPTOM2_7");

				
				thrs[0] = rs.getInt("SYMPTOM1Thresh");
				thrs[1] = rs.getInt("SYMPTOM2Thresh");
				thrs[2] = rs.getInt("SYMPTOM3Thresh");
				thrs[3] = rs.getInt("SYMPTOM4Thresh");
				thrs[4] = rs.getInt("SYMPTOM5Thresh");
				thrs[5] = rs.getInt("SYMPTOM6Thresh");
				thrs[6] = rs.getInt("SYMPTOM7Thresh");
				
				//make new Patient object with the patient informations.
				Patient P1 = new Patient(fname,lname,userName,passWord,secAns,DocName,symp,pr1,pr2,thrs);
				
				names.add(P1);  //Added to the Patient Arraylist
				i++;
			}
		}
		return names;  // Return list of patients
		
		
	  } 
	  catch (SQLException e) 
	  {
		
		e.printStackTrace();
	  }
	  
	  return names;
	  
	  
  }
  
  
  
}



