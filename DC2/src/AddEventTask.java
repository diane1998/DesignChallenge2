import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import com.toedter.calendar.JMonthChooser;

public class AddEventTask {

	private JFrame frame;
	private JTextField textField;
	private JDateChooser dateChooser;
	private GregorianCalendar date;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEventTask window = new AddEventTask();
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
	public AddEventTask() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		date= new GregorianCalendar();
		frame = new JFrame();
		frame.setBounds(100, 100, 752, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(203, 53, 519, 352);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Day = new JPanel();
		tabbedPane.addTab("Day", null, Day, null);
		Day.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 29, 443, 262);
		Day.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		scrollPane.setViewportView(panel);
		
		table = new JTable();
		table.setBounds(0, 0, 440, 260);
		panel.add(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Weekly", null, panel_2, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Agenda", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(40, 40, 438, 244);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("THREADING HERE//");
		lblNewLabel_1.setBounds(0, 297, 136, 25);
		panel_1.add(lblNewLabel_1);
		
		JPanel pnlAddEvent = new JPanel();
		tabbedPane.addTab("Add Event", null, pnlAddEvent, null);
		pnlAddEvent.setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(54, 134, 122, 28);
		pnlAddEvent.add(dateChooser);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date.setTime(dateChooser.getDate());
				System.out.println(date.MONTH);
			
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 17));
		btnNewButton.setBounds(269, 236, 97, 31);
		pnlAddEvent.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 17));
		textField.setBounds(54, 34, 289, 31);
		pnlAddEvent.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnTask = new JRadioButton("Task");
		rdbtnTask.setFont(new Font("Verdana", Font.PLAIN, 17));
		rdbtnTask.setBounds(54, 83, 112, 25);
		pnlAddEvent.add(rdbtnTask);
		
		JRadioButton rdbtnEvent = new JRadioButton("Event");
		rdbtnEvent.setFont(new Font("Verdana", Font.PLAIN, 17));
		rdbtnEvent.setBounds(193, 83, 112, 25);
		pnlAddEvent.add(rdbtnEvent);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblTo.setBounds(317, 146, 31, 16);
		pnlAddEvent.add(lblTo);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setFont(new Font("Verdana", Font.BOLD, 17));
		btnCancel.setBackground(new Color(248, 248, 255));
		btnCancel.setBounds(381, 236, 97, 31);
		pnlAddEvent.add(btnCancel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(208, 134, 97, 28);
		pnlAddEvent.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(361, 134, 97, 28);
		pnlAddEvent.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("My Productivity Tool");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(273, 13, 237, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(29, 53, 162, 175);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(12, 50, 138, 28);
		panel_3.add(dateChooser_1);
		
		JRadioButton radioButton = new JRadioButton("Events");
		radioButton.setBounds(12, 87, 99, 25);
		panel_3.add(radioButton);
		radioButton.setForeground(new Color(0, 102, 153));
		radioButton.setFont(new Font("Verdana", Font.BOLD, 17));
		
		JRadioButton radioButton_1 = new JRadioButton("Tasks");
		radioButton_1.setBounds(12, 119, 88, 25);
		panel_3.add(radioButton_1);
		radioButton_1.setForeground(new Color(0, 153, 51));
		radioButton_1.setFont(new Font("Verdana", Font.BOLD, 17));
		
		JLabel lblSpecificDayOr = new JLabel("Specific day or week");
		lblSpecificDayOr.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSpecificDayOr.setBounds(12, 13, 150, 24);
		panel_3.add(lblSpecificDayOr);
		
	
	}
}
