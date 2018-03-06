package Model;

import View.ProductivityToolView;

public class ProductivityToolModel {

	SchedDb sdb = new SchedDb();
	private PlanConnection  plan = new PlanConnection(sdb); 
	
	public PlanConnection getPlan() {
		return plan;
	}

	public void setPlan(PlanConnection plan) {
		this.plan = plan;
	}

	private ProductivityToolView view = new ProductivityToolView();
	
	
	public ProductivityToolModel(ProductivityToolView view) {
		this.view= view;
	}
	
	
	public void read()
	{
		plan.readAll();
	
	}
	
	public void addPlan(Object o)
	{
		if(o!=null) {
			plan.add(o);
		}
	}
	
	
	public ProductivityToolView getView() {
		return view;
	}



	public void setView(ProductivityToolView view) {
		this.view = view;
	}

	
}
