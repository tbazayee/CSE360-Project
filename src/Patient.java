
public class Patient 
{
	private int symptomsThreshold[];
	private int symptomLevel[];
	private int prevSymptomLevel1[];
	private int prevSymptomLevel2[];
	
	private String message;
	
	//protected Doctor D1; 
	public Patient() 
	{
		//for(int i=0; i<)
	}
	
	public void addSymptomLevels(int sym1, int sym2, int sym3, int sym4,int sym5,int sym6, int sym7)
	{

		//saves the current symptom levels to the previous before setting the new pain level.
		for (int i =0; i<7; i++)
		{
			prevSymptomLevel2[i]=prevSymptomLevel1[i];
		}
		
		for (int i =0; i<7; i++)
		{
			prevSymptomLevel1[i]=symptomLevel[i];
		}
		
		symptomLevel[0]=sym1;
		symptomLevel[1]=sym2;
		symptomLevel[2]=sym3;
		symptomLevel[3]=sym4;
		symptomLevel[4]=sym5;
		symptomLevel[5]=sym6;
		symptomLevel[6]=sym7;
		
	}
}
