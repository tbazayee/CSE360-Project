/* Login Functionality
 * Some parts of this class has been commented because it requires other classes to be compiled successfully.
 */

import java.util.Scanner;
public class login //extends User
{
	//class variables
	private int attempt;
	private String [] questions= new String [3];
	private String [] answer = new String[3];
	Scanner kb = new Scanner(System.in);
	
	//constructor
	login(String name, String pw, String a1, String a2, String a3)
	{
		//super.userName = name;
		//super.userPassword = pw;
		attempt = 0;
		questions[0]= "What's your highschool name?";
		questions[1] = "what's the last name of the teacher who gave you your first failing grade?";
		questions[2] = "At age do you want to retire?";
		answer[0] = a1;
		answer[1] = a2;
		answer[2] = a3;
	}
	String getQuestion(int index)
	{
		return questions[index];
	}
	String getAnswer (int index)
	{
		return answer[index];
	}
	void setAnswer (int index, String str)
	{
		answer[index] = str;
	}
	boolean verifyLogin (String userName, String userPw)
	{
		//Patient aPatient = new Patient();  //create an instance of the patient class(to be created later)
		//aPtient = getRoot();
		
		//while(aPatient != NULL)
		{
			//if(userName.compareTo(aPatient->getUserName()) == 0) && userPw.compareTo(aPatient->getUserPassword())_ == 0)
			//{
			//	return true;
			//}
			
			//aPtient = aPtinet.next();
		}
		return false;
	}
	
	String askQuestion(int indexQuestion)
	{
		String userAns ;// = new String[3];
		
		//if (!verify(userName,userPassword))
		System.out.println("Please answer the following question to retrieve your password.");
		System.out.println(questions[indexQuestion]);
		userAns = kb.next();
		attempt++;
		return userAns;
		
	}
	
	
	//class methods
}
