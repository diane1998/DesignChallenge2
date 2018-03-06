package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * @author diane cruz
 *
 */
public class ProductivityToolView {

	private JFrame frame;
	private JTextField txtName;
	private JDateChooser addDateChooser;
	private GregorianCalendar date;
	private JTable DayTable;
	private JTabbedPane tabbedPane;
	private JPanel Day;
	private JPanel panel;
	private JPanel panel_2;
	private JTextArea textArea;
	private JPanel panel_1;
	private JButton btnSave;
	private JRadioButton rdbtnTask;
	private JRadioButton rdbtnEvent;
	private JButton btnCancel;
	private JComboBox<?> cmbStart;
	private JComboBox<?> cmbEnd;
	private JRadioButton rbtnGenEvents;
	private JRadioButton rbtnGenTask;
	private JDateChooser dateChooser_1; 
	private JTable weeklyTable;
	private DefaultTableModel dayModel;
	private DefaultTableModel weeklyModel;
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JDateChooser getAddDateChooser() {
		return addDateChooser;
	}

	public void setAddDateChooser(JDateChooser addDateChooser) {
		this.addDateChooser = addDateChooser;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public JTable getDayTable() {
		return DayTable;
	}

	public void setDayTable(JTable dayTable) {
		DayTable = dayTable;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JPanel getDay() {
		return Day;
	}

	public void setDay(JPanel day) {
		Day = day;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JRadioButton getRdbtnTask() {
		return rdbtnTask;
	}

	public void setRdbtnTask(JRadioButton rdbtnTask) {
		this.rdbtnTask = rdbtnTask;
	}

	public JRadioButton getRdbtnEvent() {
		return rdbtnEvent;
	}

	public void setRdbtnEvent(JRadioButton rdbtnEvent) {
		this.rdbtnEvent = rdbtnEvent;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JComboBox<?> getCmbStart() {
		return cmbStart;
	}

	public void setCmbStart(JComboBox<?> cmbStart) {
		this.cmbStart = cmbStart;
	}

	public JComboBox<?> getCmbEnd() {
		return cmbEnd;
	}

	public void setCmbEnd(JComboBox<?> cmbEnd) {
		this.cmbEnd = cmbEnd;
	}

	public JRadioButton getRbtnGenEvents() {
		return rbtnGenEvents;
	}

	public void setRbtnGenEvents(JRadioButton rbtnGenEvents) {
		this.rbtnGenEvents = rbtnGenEvents;
	}

	public JRadioButton getRbtnGenTask() {
		return rbtnGenTask;
	}

	public void setRbtnGenTask(JRadioButton rbtnGenTask) {
		this.rbtnGenTask = rbtnGenTask;
	}

	public JDateChooser getDateChooser_1() {
		return dateChooser_1;
	}

	public void setDateChooser_1(JDateChooser dateChooser_1) {
		this.dateChooser_1 = dateChooser_1;
	}

	public JTable getWeeklyTable() {
		return weeklyTable;
	}

	public void setWeeklyTable(JTable weeklyTable) {
		this.weeklyTable = weeklyTable;
	}

	public DefaultTableModel getDayModel() {
		return dayModel;
	}

	public void setDayModel(DefaultTableModel dayModel) {
		this.dayModel = dayModel;
	}

	public DefaultTableModel getWeeklyModel() {
		return weeklyModel;
	}

	public void setWeeklyModel(DefaultTableModel weeklyModel) {
		this.weeklyModel = weeklyModel;
	}
	
	public void addSaveListener(ActionListener mal) {
        btnSave.addActionListener(mal);
    }
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ProductivityToolView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	      int gapInMinutes =  30 ;  // Define your span-of-time.
	        int loops = ( (int) Duration.ofHours( 24 ).toMinutes() / gapInMinutes ) ;
	        List<LocalTime> times = new ArrayList<>( loops ) ;

	        LocalTime time = LocalTime.MIN ;  // '00:00'
	        for( int i = 1 ; i <= loops ; i ++ ) {
	            times.add( time ) ;
	            // Set up next loop.
	            time = time.plusMinutes( gapInMinutes ) ;
	        }

		date= new GregorianCalendar();
		frame = new JFrame();
		frame.setBounds(100, 100, 752, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(203, 53, 519, 352);
		frame.getContentPane().add(tabbedPane);
		
		Day = new JPanel();
		tabbedPane.addTab("Day", null, Day, null);
		Day.setLayout(null);
		
		
	
		
//	      TableModel dataModel = new AbstractTableModel() {
//	          public int getColumnCount() { return 2; }
//	          public int getRowCount() { return 48;}
//	          public Object getValueAt(int row, int col) {
//	        	  if(col==0)
//	        		  return times.get(row).toString();
//	        	  else
//	        		  return "";
//	        	  }
//	          public void setColumnIdentifiers(new Object[] {
//	                  "Column 1", "Column 2", "Column 3" });
//	      };
		
		 dayModel = new DefaultTableModel();
		 dayModel.setColumnIdentifiers(new Object[] {
				 "Time", "Name", });
		 
		 
		
		DayTable = new JTable(dayModel);
		 for (int count = 0; count < 48; count++){
	            dayModel.insertRow(count, new Object[] { times.get(count).toString(), ""});
	    
	        }	
		  	DayTable.getColumnModel().getColumn(0).setMaxWidth(70);;
	
	        DayTable.setRowHeight( 30);
	        DayTable.setBounds(0, 0, 440, 260);
	        
//		for(int i=0;i<48;i++) {
//			DayTable.setValueAt(times.get(i).toString(), i, 0);
//		}
//		
	
	    
		JScrollPane dayScrollpane = new JScrollPane(DayTable);
		
		dayScrollpane.setBounds(39, 29, 443, 262);
		Day.add(dayScrollpane);
		
	
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Weekly", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(weeklyTable);
		scrollPane.setBounds(40, 25, 452, 276);
		panel_2.add(scrollPane);
		
		weeklyTable = new JTable();
		scrollPane.setViewportView(weeklyTable);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Agenda", null, panel_1, null);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(40, 40, 438, 244);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("THREADING HERE//");
		lblNewLabel_1.setBounds(0, 297, 136, 25);
		panel_1.add(lblNewLabel_1);
		
		JPanel pnlAddEvent = new JPanel();
		tabbedPane.addTab("Add Event", null, pnlAddEvent, null);
		pnlAddEvent.setLayout(null);
		
		addDateChooser = new JDateChooser();
		addDateChooser.setBounds(54, 134, 122, 28);
		pnlAddEvent.add(addDateChooser);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date.setTime(addDateChooser.getDate());
				System.out.println(date.MONTH);
			
			}
		});
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(255, 102, 102));
		btnSave.setFont(new Font("Verdana", Font.BOLD, 17));
		btnSave.setBounds(269, 236, 97, 31);
		pnlAddEvent.add(btnSave);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Verdana", Font.PLAIN, 17));
		txtName.setBounds(54, 34, 289, 31);
		pnlAddEvent.add(txtName);
		txtName.setColumns(10);
		
		rdbtnTask = new JRadioButton("Task");
		rdbtnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbEnd.setEnabled(false);
				if(rdbtnEvent.isSelected())
					rdbtnEvent.setSelected(false);
				
				
			}
		});
		rdbtnTask.setFont(new Font("Verdana", Font.PLAIN, 17));
		rdbtnTask.setBounds(54, 83, 112, 25);
		pnlAddEvent.add(rdbtnTask);
		
		rdbtnEvent = new JRadioButton("Event");
		rdbtnEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbEnd.setEnabled(true);
				if(rdbtnTask.isSelected())
					rdbtnTask.setSelected(false);
				
				
			}
		});
		rdbtnEvent.setFont(new Font("Verdana", Font.PLAIN, 17));
		rdbtnEvent.setBounds(193, 83, 112, 25);
		pnlAddEvent.add(rdbtnEvent);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblTo.setBounds(317, 146, 31, 16);
		pnlAddEvent.add(lblTo);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setFont(new Font("Verdana", Font.BOLD, 17));
		btnCancel.setBackground(new Color(248, 248, 255));
		btnCancel.setBounds(381, 236, 97, 31);
		pnlAddEvent.add(btnCancel);
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        
  

 
        cmbStart= new JComboBox(times.toArray());
        
		cmbStart.setBounds(208, 134, 97, 28);
		pnlAddEvent.add(cmbStart);
		cmbEnd = new JComboBox(times.toArray());
		cmbEnd.setBounds(361, 134, 97, 28);
		pnlAddEvent.add(cmbEnd);
		
		JLabel lblNewLabel = new JLabel("My Productivity Tool");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(273, 13, 237, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(29, 53, 162, 175);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(12, 50, 138, 28);
		panel_3.add(dateChooser_1);
		
		rbtnGenEvents = new JRadioButton("Events");
		rbtnGenEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbtnGenTask.isSelected())
					rbtnGenTask.setSelected(false);
			}
		});
		rbtnGenEvents.setBounds(12, 87, 99, 25);
		panel_3.add(rbtnGenEvents);
		rbtnGenEvents.setForeground(new Color(0, 102, 153));
		rbtnGenEvents.setFont(new Font("Verdana", Font.BOLD, 17));
		
		rbtnGenTask = new JRadioButton("Tasks");
		rbtnGenTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnGenEvents.isSelected())
					rbtnGenEvents.setSelected(false);
			}
		});
		rbtnGenTask.setBounds(12, 119, 88, 25);
		panel_3.add(rbtnGenTask);
		rbtnGenTask.setForeground(new Color(0, 153, 51));
		rbtnGenTask.setFont(new Font("Verdana", Font.BOLD, 17));
		
		JLabel lblSpecificDayOr = new JLabel("Specific day or week");
		lblSpecificDayOr.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSpecificDayOr.setBounds(12, 13, 150, 24);
		panel_3.add(lblSpecificDayOr);
		
	}
	
	public void intervals(JComboBox<Date> cmb) {
		
//        cmb.setRenderer(new DateFormattedListCellRenderer(new SimpleDateFormat("HH:mm")));
	}

	
}
