import java.awt.EventQueue;

import Controller.ProductivityToolController;
import Model.ProductivityToolModel;
import View.ProductivityToolView;

public class Driver {

	public static void main (String args[]) {
		ProductivityToolView view= new ProductivityToolView();
		view.getFrame().setVisible(true);
		ProductivityToolModel model =new  ProductivityToolModel(view);
		ProductivityToolController controller= new ProductivityToolController(view,model);
					
	}
	
}
