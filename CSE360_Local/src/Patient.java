
public class Patient extends User {
	
	//fields
	private final int numOfSymptomes = 7;
	private int[] symptomsThreshold;
	private int[] symptomLevel;
	private int[] previousSymptomLevel1;
	private int[] previousSymptomLevel2;
	private String message;
	private String patientsDoctor;
	
	//default constructor
	public Patient(){
		super();
		setSymptomsThreshold(new int[numOfSymptomes]);
		setSymptomLevel(new int[numOfSymptomes]);
		setPreviousSymptomLevel1(new int[numOfSymptomes]);
		this.setMessage("");
		this.setPatientsDoctor("");
		
	}
	
	//parameterized constructor
	public Patient (String firstName,String lastName,String userName,String password,String securityQuestionAnswer,String DocName,int symp[],int prev1[],int prev2[],int threshold[]){
		super(firstName,lastName,userName,password,securityQuestionAnswer);
		this.setMessage("");
		this.setPatientsDoctor(DocName);
		symptomsThreshold= threshold;
		symptomLevel = symp;
		previousSymptomLevel1=prev1;
		previousSymptomLevel2= prev2;
	}

	//the following will be accessory functions.
	public int[] getSymptomsThreshold() {
		return symptomsThreshold;
	}
	
	public int[] getEnterSymptomLevel() {
		return symptomLevel;
	}
	
	public int[] getPreviousSymptomLevel1() {
		return previousSymptomLevel1;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getPatientsDoctor() {
		return patientsDoctor;
	}
	
	//the following will be mutator functions
	public void setSymptomsThreshold(int[] symptomsThreshold) 
	{
		this.symptomsThreshold = symptomsThreshold;
	}

	public void setSymptomLevel(int[] enterSymptomLevel) 
	{
		this.symptomLevel = enterSymptomLevel;
	}

	public void setPreviousSymptomLevel1(int[] previousSymptomLevel1) {
		this.previousSymptomLevel1 = previousSymptomLevel1;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPatientsDoctor(String patientsDoctor) {
		this.patientsDoctor = patientsDoctor;
	}
	
	public void setSymptom(int symptom, int index){
		symptomLevel[index] = symptom;
	}
	
	public void setThreshold(int threshold, int index){
		
		symptomsThreshold[index] = threshold;
	}
	
	public void setSymptomLevel(int symptom, int index){
		
		previousSymptomLevel1[index] = symptom;
	}

	public int[] getPreviousSymptomLevel2() {
		return previousSymptomLevel2;
	}

	public void setPreviousSymptomLevel2(int[] previousSymptomLevel2) {
		this.previousSymptomLevel2 = previousSymptomLevel2;
	}
}
