


public class patientInfo {
	//class variables
	int symptomsThreshold [] = new int [10];
	int symptomsLevel [] = new int[10];
	int prevSymptomLevelEntered [] = new int[10];
	String message;
	String patientsDrName;
	
	//constructor
	patientInfo()
	{
		for(int i = 0; i<10; i++)
		{
			symptomsThreshold[i] = 0;
			symptomsLevel[i] = 0;
			prevSymptomLevelEntered[i] = 0;
		}
		message = "";
		patientsDrName = "John Doe";
	}
	void setThreshold(int index, int thresholdLevel)
	{
		symptomsThreshold[index] = thresholdLevel;
	}
	void setSymtomsLevel(int index, int lvl)
	{
		symptomsLevel [index] = lvl;
	}
	
	void setMessage(String msg)
	{
		message = msg;
	}
	void setpatinetsDrName(String str)
	{
		patientsDrName = str;
	}
	int getSymptomsThreshold(int index)
	{
		return symptomsThreshold[index];
	}
	int[] getSymtomsLevel()
	{
		return symptomsLevel;
	}
	
	String getMessage()
	{
		return message;
	}
	String getpatinetsDrName()
	{
		return patientsDrName;
	}
	//class methods
	//other methods(functions) to be implemented in Phase III
	
	
}
