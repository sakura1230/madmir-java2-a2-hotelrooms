import javax.swing.JOptionPane;


public class HotelBilling {

	
	final static float SALES_TAX = 0.13f;
		
	public static void main(String[] args) {
		
		//Declaring variables
		double roomRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the room rate: "));
		double coupon = Double.parseDouble(JOptionPane.showInputDialog("Enter the discount: "));
		int numRooms = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rooms: "));
		double totalBill;
		
		//Calling each instance of the overload method and displaying results		
		totalBill = calculateBill(roomRate);		
		JOptionPane.showMessageDialog(null, "Your total with tax for one room is $ " + totalBill);
		
		totalBill = calculateBill(roomRate, numRooms);
		JOptionPane.showMessageDialog(null, "Your total with tax for " + numRooms + " room(s) is $ " + totalBill);
		
		totalBill = calculateBill(roomRate, numRooms, coupon);
		JOptionPane.showMessageDialog(null, "Your total with tax for " + numRooms + " room(s) is $ " + totalBill 
			+ ".\nThis includes a discount of " + coupon * 100 + "%");
	}
	
	//This handles one piece of data - the room rate	
	public static double calculateBill(double rate) {
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = twoDecimalRounding(finalRate); 
		return finalRate;
	}
	
	//This handles two pieces of data - the room rate and number of rooms booked
	public static double calculateBill(double rate, int qty) {
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = finalRate * qty;
		finalRate = twoDecimalRounding(finalRate);
		return finalRate;
	}
	
	//This handles three pieces of data - the room rate, number of rooms booked,
	//and coupon rate
	public static double calculateBill(double rate, int qty, double coup) {
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = finalRate * qty * (1 - coup);
		finalRate = twoDecimalRounding(finalRate);
		return finalRate;
	}
		
	//This method is receiving a double and returning the same double rounded to two decimals
	public static double twoDecimalRounding(double decimal) {
		decimal = decimal * 100;
		decimal = decimal + 0.5;
		decimal = (int) decimal;
		decimal = decimal / 100;
		return decimal;
	}
	
}
