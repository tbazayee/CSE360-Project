
public class User {
	//fields
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String password;
	protected String securityQuestion;
	protected String securityQuestionAnswer;
	
	//default constructor
	public User(){
		firstName = "";
		lastName = "";
		userName = "";
		password = "";
		securityQuestion = "";
		securityQuestionAnswer = "";
	}
	
	//parameterized constructor
	public User(String firstName,String lastName,String userName,String password,String securityQuestionAnswer){
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		securityQuestion = "What is your favorite food";
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
	
	//the following will be accessor  functions
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getSecurityQuestion(){
		return securityQuestion;
	}
	
	public String getSecurityQuestionAnswer(){
		return securityQuestionAnswer;
	}
	
	//the following will be mutator functions
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setSecurityQuestion(String securityQuestion){
		this.securityQuestion = securityQuestion;
	}
	
	public void setSecurityQuestionAnswer(String securityQuestionAnswer ){
		
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
	
	//to string method
	public String toString(){
		return firstName + " " + lastName;
	}
	
}
