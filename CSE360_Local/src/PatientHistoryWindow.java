import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.*;

public class PatientHistoryWindow {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	
	public void displayWindow(){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientHistoryWindow window = new PatientHistoryWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientHistoryWindow window = new PatientHistoryWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatientHistoryWindow() {
		initialize();
	}
	
	private DefaultCategoryDataset dataSetInitialization(int numberofdays, double symptomLevel[], String symptoms[])
	{
		switch(numberofdays)
		{
		case 1:
			DefaultCategoryDataset dataset= new DefaultCategoryDataset();
			for (int i=0; i<numberofdays; i++)
			{
				dataset.setValue(symptomLevel[i], "day1","Pain");
			}
			return dataset;
			//break;
		case 2:
			DefaultCategoryDataset dataset1= new DefaultCategoryDataset();
			return dataset1;
			//break;
			
		case 3:
			DefaultCategoryDataset dataset2= new DefaultCategoryDataset();
			return dataset2;
			//break;
			
		//default:
		
		}
		DefaultCategoryDataset dataset5= new DefaultCategoryDataset();
		return dataset5;
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 859, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultCategoryDataset dataset= new DefaultCategoryDataset();
				//JOptionPane.showMessageDialog(null, "BUTTON CLICKED!!!");
				//LableMessage.setText("BUTTON CLICKED!!!");
				
				//Pain, Drowsiness, Nausea, Anxiety, and Depression
				dataset.setValue(2, "day1","Pain");
				dataset.setValue(5, "day2","Pain");
				dataset.setValue(4, "day3","Pain");
				dataset.setValue(6, "day1", "Drowsiness");
				dataset.setValue(10, "day2", "Drowsiness");
				dataset.setValue(8, "day3", "Drowsiness");
				dataset.setValue(1, "day1", "Nausea");
				dataset.setValue(7, "day2", "Nausea");
				dataset.setValue(5, "day3", "Nausea");
				dataset.setValue(3,"day1","Anxiety");	
				dataset.setValue(8,"day2","Anxiety");
				dataset.setValue(9,"day3","Anxiety");
				dataset.setValue(8, "day1", "Depression");
				dataset.setValue(7, "day2", "Depression");
				dataset.setValue(9, "day3", "Depression");
				//DefaultCategoryDataset dataset2= new DefaultCategoryDataset();

				JFreeChart chart= ChartFactory.createBarChart3D("Symptom Report","Symptoms", "Levels", dataset, PlotOrientation.VERTICAL,true,true,false);
				//JFreeChart chart2= ChartFactory.createBarChart("Symptom Report","Symptoms", "Levels", dataset2, PlotOrientation.VERTICAL,false,true,false);
				chart.setBackgroundPaint(Color.lightGray);
				//JFreeChart chart2= ChartFactory.createBarChart("Grade Report","Student Name", "Marks", dataset2, PlotOrientation.VERTICAL,false,true,false);
				
				CategoryPlot p=chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.red);
				p.setBackgroundPaint(Color.WHITE);
				
				ChartFrame frame= new ChartFrame("Bar Graph Test",chart,false);
				frame.setVisible(true);
				frame.setSize(700,350);
				
			}
		});
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setForeground(Color.RED);
		btnSubmit.setFont(new Font("Euphemia", Font.BOLD, 11));
		btnSubmit.setBounds(409, 388, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
