package sales;

import java.text.DecimalFormat;
import java.util.ArrayList;



public class SalesSlip {
	ArrayList<SalesItem> saleSlip;
	double total = 0;

	/**
	 * 
	 */
	public SalesSlip() {
		saleSlip = new ArrayList<SalesItem>();
	}
	
	public void addItem(String name, String cost, String quantity) {
		double c = Double.parseDouble(cost);
		int q = Integer.valueOf(quantity);
		
		SalesItem item = new SalesItem(name,c,q);
		
		total += c*q;
		
		saleSlip.add(item);
	}
	
	public double getTotal() {
		return  Double.parseDouble(new DecimalFormat("#.##").format(total));
		
	}
	
	public String getList() {
		String outPut = "";
		
		for(int i = 0; i < saleSlip.size(); i++) {
			outPut += saleSlip.get(i).toString()+"\\n";
		}
		
		return outPut;
	}
	
	
}
