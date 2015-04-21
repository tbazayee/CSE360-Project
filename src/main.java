import java.awt.Image;
import java.sql.*;
import java.util.*;


public class main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
	
		Database D1 = new Database(); 
		int sypt[] = new int[7];
		int psypt1[] = new int[7];
		int psypt2[] = new int[7];
		int thresh[] = new int[7];
		String dname ="Doc1";
		for (int i =0; i<7; i++)
		{
			sypt[i]= i;
			psypt1[i]=i+1;
			psypt2[i]=i+2;
			thresh[i]=i+5;
		}
		
		ArrayList<String[]> names = new ArrayList<String[]>();
		D1.addPatient("Jone456fgh", "Doe1", 1, "JD", "pass", "City Born", "Minn", sypt, psypt1,psypt2, thresh,dname);
		names=D1.getPatientsNameList(); 
		//for (int j = 0; j <2; j++)
		D1.removePatientFromDB("Jone", "What");
		//{
		String names1[];
			for (int k=0; k<names.size();k++)
			{
				names1 = names.get(k);
				System.out.println("Frist Name:   "+names1[0]+"   Last Name:    "+names1[1]);
			}
			

	}

}
