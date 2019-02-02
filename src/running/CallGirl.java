package running;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.ServiceGirls;
import customer.Customer;
import fileFactory.FileFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CallGirl extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private double money =0;

	/**
	 * Launch the application.
	 */
	ArrayList<ServiceGirls> girlsList = LoginTable.getListGirls();
	ArrayList<Customer> customerList = new ArrayList<>();
	

	/**
	 * Create the frame.
	 */
	public CallGirl() {
		customerList.add(new Customer("1", "Khai", 25, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnShowGirls = new JButton("Show Girls");
		btnShowGirls.setBounds(10, 21, 96, 23);
		contentPane.add(btnShowGirls);
		btnShowGirls.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String shows = "";
				for (ServiceGirls girl : girlsList)
					shows += girl+"\n";
				JOptionPane.showMessageDialog(null, shows);
			}
		});

		JLabel label = new JLabel("Customer ID");
		label.setBounds(221, 26, 75, 14);
		contentPane.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(315, 23, 86, 20);
		contentPane.add(textField);

		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(221, 54, 75, 14);
		contentPane.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(315, 51, 86, 20);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Girl Name");
		JLabel label_3 = new JLabel("Job Code");
		textField_3 = new JTextField();
		JComboBox comboBox = new JComboBox();
		

		JButton button = new JButton("Call Girl");
		button.setBounds(10, 133, 96, 23);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField_3.getText();
				int code;
				if(comboBox.getSelectedIndex()==0) code =1;
				else code =2;
				for (ServiceGirls girl: girlsList) {
					if(name.equals(girl.getName()) && code==girl.getJobCode()) {
						money += girl.getMoney();
					}
				}
				
			}
		});
		

		label_2.setBounds(10, 171, 75, 14);
		contentPane.add(label_2);

		
		label_3.setBounds(10, 204, 75, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Times");
		label_4.setBounds(10, 234, 75, 14);
		contentPane.add(label_4);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(104, 231, 86, 20);
		contentPane.add(textField_2);

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnPay.setBounds(315, 133, 89, 23);
		contentPane.add(btnPay);
		btnPay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your total money: "+money);
				String id = textField.getText();
				String name = textField_1.getText();
				for (Customer c: customerList) {
					if(c.getId().equals(id)&& c.getName().equals(name)) {
						c.setTotalMoney(c.getTotalMoney()+money);
						JOptionPane.showMessageDialog(null, "All total money: "+c.getTotalMoney());
					}
				}
			}
		});
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Karaoke", "Massage"}));
		comboBox.setBounds(104, 199, 86, 20);
		contentPane.add(comboBox);

		
		textField_3.setColumns(10);
		textField_3.setBounds(104, 168, 86, 20);
		contentPane.add(textField_3);
	}
}
