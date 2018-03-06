package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Model.Event;
import Model.ProductivityToolModel;
import Model.Task;
import View.ProductivityToolView;

public class ProductivityToolController {
	private ProductivityToolView view = new ProductivityToolView();
	private ProductivityToolModel model = new ProductivityToolModel(view);
	
	public ProductivityToolController(ProductivityToolView view,ProductivityToolModel model){
		this.view= view;
		this.model= model;
		view.addSaveListener(new SaveListener());
	}
	
	public ProductivityToolModel getModel() {
		return model;
	}
	
	public void setModel(ProductivityToolModel model) {
		this.model = model;
	}
	
	class SaveListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
           
            try {
//                userInput = m_view.getUserInput();
//                m_model.multiplyBy(userInput);
//                m_view.setTotal(m_model.getValue());
            	System.out.println("name "+view.getTxtName().getText());
        		System.out.println("task "+view.getRdbtnTask().isSelected());
        		System.out.println( "event "+view.getRdbtnEvent().isSelected());
        		System.out.println("start "+view.getCmbStart().getSelectedItem().toString());
        		System.out.println("end "+view.getCmbEnd().getSelectedItem().toString());
        		System.out.println("date " +view.getAddDateChooser().getDate().toString());
        		
        		if(!view.getTxtName().getText().trim().equals("") && !view.getCmbEnd().getSelectedItem().equals("")&& !view.getCmbStart().equals("") && view.getAddDateChooser().getDate()!=null) {
        			
        				if(view.getRdbtnEvent().isSelected()) {
        					Event event=new Event();
        					event.setColor(1);
        					event.setName(view.getTxtName().getText());
        					event.setDate(view.getAddDateChooser().getDate());
        					DateFormat formatter = new SimpleDateFormat("HH:mm");
        					java.sql.Time timeStart = new java.sql.Time(formatter.parse(view.getCmbStart().getSelectedItem().toString()).getTime());
        					event.setStart(timeStart);
        					java.sql.Time timeEnd= new java.sql.Time(formatter.parse(view.getCmbEnd().getSelectedItem().toString()).getTime());
        					event.setEnd(timeEnd);
        					event.setCompleted(false);
        					event.setDeleted(false);
        					event.setColor(1);
        				
        					event.ToString();
        					
//        					(int id,String name,Date date,Time start,Time end,boolean completed,boolean deleted,int color)

        					model.addPlan(event);
        				}
        				else if(view.getRdbtnTask().isSelected())
        				{
        					
        					Task task=new Task();
        					task.setColor(1);
        					task.setName(view.getTxtName().getText());
        					task.setDate(view.getAddDateChooser().getDate());
        					DateFormat formatter = new SimpleDateFormat("HH:mm");
        					java.sql.Time timeStart = new java.sql.Time(formatter.parse(view.getCmbStart().getSelectedItem().toString()).getTime());
        					task.setStart(timeStart);
        					task.setCompleted(false);
        					task.setDeleted(false);
        					task.setColor(2);
        					task.ToString();
        					model.addPlan(task);
        					System.out.println("yey");
        				}
        		}
                
            } catch (NumberFormatException nfex) {
//                m_view.showError("Bad input: '" + userInput + "'");
            } catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }//end inner class MultiplyListener
	

}
