import java.awt.Image;
import java.awt.event.WindowStateListener;
import java.sql.*;
import java.util.*;

import javax.swing.JFrame;


public class main extends JFrame{

	
	public static void main(String[] args) {
	
		Database D1 = new Database(); 
		
		int sypt[] = new int[7];
		int psypt1[] = new int[7];
		int psypt2[] = new int[7];
		int thresh[] = new int[7];
		String dname ="Doc2";
		for (int i =0; i<7; i++)
		{
			sypt[i]= i;
			psypt1[i]=i+1;
			psypt2[i]=i+2;
			thresh[i]=i+5;
		}
		
		ArrayList<String[]> names = new ArrayList<String[]>();
		D1.addPatient("asdf", "jkl", 1, "AD", "pass", "City Born", "Minn", sypt, psypt1,psypt2, thresh,dname);
		names=D1.getPatientsNameList(); 

		D1.removePatientFromDB("Akaramba", "Peter");
		for (int i =0; i <5; i++)
			D1.addPatient("Dr"+i, "last"+1, i, "Pn"+i,"PPass"+i, "Question", "sec"+i,sypt, psypt1,psypt2, thresh,dname);
		
		
		ArrayList<Patient> names11 = new ArrayList<Patient>();
		names11=D1.getPatientList("Doc1");
		//for (int i =0; i <5; i++)
			//D1.addDoctor("Dr"+i, "last"+1, "Un"+i, "Pass"+i, "sec"+i);
		//D1.addPatient(names11.get(5));
		//D1.addPatient();
		String names1[];
			for (int k=0; k<names11.size();k++)
			{
				//names1 = names.get(k);
				Patient test= new Patient();
				test = names11.get(k);
				System.out.print("\nFrist Name: "+test.getFirstName()+"   Last Name: "+test.getLastName()+"\t");
				int thre[] = test.getSymptomsThreshold();

				for (int i = 0; i<thre.length; i++)
					System.out.print("Symptom"+i+": "+thre[i]+"\t");
				System.out.println();
			}
		
		if( !D1.docPasswordCheck("asdf"))
		{
			System.out.println("\npassword Invalid");

		}
		if (D1.docCheck("12", "Pass1"))
			System.out.println("\npassword Valid");
			
		System.out.println("\n"+D1.getPatientAnswer("Pn3"));
	}
	
	
	

}
