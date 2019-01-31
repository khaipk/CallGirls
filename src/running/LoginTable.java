package running;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.KaraokeGirls;
import Database.MassageGirls;
import Database.ServiceGirls;
import fileFactory.FileFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	 static ArrayList<ServiceGirls> girlsList = new ArrayList<>();
	  public static ArrayList<ServiceGirls> getListGirls() {
			return girlsList;
		}
	  public void setListSP(ArrayList<ServiceGirls> girlsList) {
			this.girlsList = girlsList;
		}
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LoginTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Girl Name");
		lblNewLabel.setBounds(10, 11, 62, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(82, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblJobCode = new JLabel("Job Code");
		lblJobCode.setBounds(10, 47, 62, 14);
		contentPane.add(lblJobCode);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 44, 86, 20);
		contentPane.add(textField_1);

		JButton btnLogin = new JButton("Check");
		btnLogin.setBounds(39, 86, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (ServiceGirls girl : girlsList) {
					if (girl.getName().equals(textField.getText()) &&
							girl.getJobCode()==Integer.parseInt(textField_1.getText())) {
						JOptionPane.showMessageDialog(null, girl);
					}
				}
			}
		});

		JButton btnNewButton = new JButton("Add New Girl");
		btnNewButton.setBounds(265, 7, 111, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().length()==0 || textField_3.getText().length()==0 || textField_4.getText().length()==0 || textField_5.getText().length()==0 || textField_6.getText().length()==0 || textField_7.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "You must type all Girls information");
				} else {
					String name = textField_2.getText();
					int code = Integer.parseInt(textField_3.getText());
					int age = Integer.parseInt(textField_4.getText());
					String body = textField_5.getText();
					int rank = Integer.parseInt(textField_6.getText());
					int worktimes = Integer.parseInt(textField_7.getText());
					if (code !=1 && code !=2)
						JOptionPane.showMessageDialog(null, "Only accept Karaoke: code 1 and Massage: code 2");
					else {JOptionPane.showMessageDialog(null, "Add girl successful");
					if (code ==2)
						girlsList.add(new MassageGirls(code, name, age, body, worktimes, rank));
					else 
						girlsList.add(new KaraokeGirls(code, name, age, body, worktimes, rank));
					}
					boolean save = FileFactory.saveFile(girlsList, "E:/svg.dat");
					
					}
			}
		});

		JLabel label = new JLabel("Girl Name");
		label.setBounds(251, 50, 62, 14);
		contentPane.add(label);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(323, 47, 86, 20);
		contentPane.add(textField_2);

		JLabel lblJobCode_1 = new JLabel("Job Code");
		lblJobCode_1.setBounds(251, 89, 62, 14);
		contentPane.add(lblJobCode_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(323, 86, 86, 20);
		contentPane.add(textField_3);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(251, 128, 62, 14);
		contentPane.add(lblAge);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(323, 125, 86, 20);
		contentPane.add(textField_4);

		JLabel lblBody = new JLabel("Body");
		lblBody.setBounds(251, 165, 62, 14);
		contentPane.add(lblBody);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(323, 162, 86, 20);
		contentPane.add(textField_5);

		JLabel lblRank = new JLabel("Rank");
		lblRank.setBounds(251, 204, 62, 14);
		contentPane.add(lblRank);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(323, 201, 86, 20);
		contentPane.add(textField_6);

		JLabel lblWork = new JLabel("Worktimes");
		lblWork.setBounds(251, 245, 69, 14);
		contentPane.add(lblWork);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(323, 242, 86, 20);
		contentPane.add(textField_7);
	}
}
