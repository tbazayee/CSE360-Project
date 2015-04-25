import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PatientHomepageGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Doctor doc1 = new Doctor("Dr","Mundo","king","one","tacos");
		//Patient patient1 = new Patient("saul","figueroa","two","three","pozole");
		//Patient patient2 = new Patient("cesar","gaytan","two","three","pozole");
		//Patient patient3 = new Patient("kyle","steffa","two","three","pozole");
		
		//System.out.println(patient1);
		//doc1.addPatientList(patient1);
		//doc1.addPatientList(patient2);
		//doc1.addPatientList(patient3);
		//doc1.printList();
		//doc1.removePatient(patient2);
		System.out.println("\n");
		//doc1.printList();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientHomepageGUI frame = new PatientHomepageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientHomepageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Return to Log in screen");
			}
		});
		btnLogOut.setBounds(12, 27, 97, 25);
		getContentPane().add(btnLogOut);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Thank you for submiting ");
			}
		});
		btnSubmit.setBounds(562, 676, 97, 25);
		getContentPane().add(btnSubmit);
		
		JButton btnViewHistory = new JButton("View History");
		btnViewHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "History");
			}
		});
		btnViewHistory.setBounds(12, 676, 115, 25);
		getContentPane().add(btnViewHistory);
		
		JLabel lblEnterSymtomsFrom = new JLabel("Enter Symtoms From 0 to 10");
		lblEnterSymtomsFrom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterSymtomsFrom.setBounds(203, 43, 297, 53);
		getContentPane().add(lblEnterSymtomsFrom);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setText("Enter Comments...");
		textField.setBounds(244, 638, 182, 63);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(10);
		slider.setBounds(244, 127, 200, 39);
		getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setSnapToTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMaximum(10);
		slider_1.setMajorTickSpacing(1);
		slider_1.setBounds(244, 197, 200, 39);
		getContentPane().add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setSnapToTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMaximum(10);
		slider_2.setMajorTickSpacing(1);
		slider_2.setBounds(244, 270, 200, 39);
		getContentPane().add(slider_2);
		
		JSlider slider_3 = new JSlider();
		slider_3.setSnapToTicks(true);
		slider_3.setPaintLabels(true);
		slider_3.setMaximum(10);
		slider_3.setMajorTickSpacing(1);
		slider_3.setBounds(244, 342, 200, 39);
		getContentPane().add(slider_3);
		
		JSlider slider_4 = new JSlider();
		slider_4.setSnapToTicks(true);
		slider_4.setPaintLabels(true);
		slider_4.setMaximum(10);
		slider_4.setMajorTickSpacing(1);
		slider_4.setBounds(244, 415, 200, 39);
		getContentPane().add(slider_4);
		
		JSlider slider_5 = new JSlider();
		slider_5.setSnapToTicks(true);
		slider_5.setPaintLabels(true);
		slider_5.setMaximum(10);
		slider_5.setMajorTickSpacing(1);
		slider_5.setBounds(244, 489, 200, 39);
		getContentPane().add(slider_5);
		
		JSlider slider_6 = new JSlider();
		slider_6.setSnapToTicks(true);
		slider_6.setPaintLabels(true);
		slider_6.setMaximum(10);
		slider_6.setMajorTickSpacing(1);
		slider_6.setBounds(244, 562, 200, 39);
		getContentPane().add(slider_6);
		
		JLabel lblNewLabel = new JLabel("Pain");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(84, 127, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Tired");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(84, 197, 56, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Nausea");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(84, 270, 77, 16);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Depression");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(84, 342, 107, 16);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Anxiety");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(84, 415, 77, 16);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Drowsy");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_4.setBounds(84, 489, 77, 16);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Appetite");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_5.setBounds(84, 562, 77, 16);
		getContentPane().add(label_5);
		
	}
}
