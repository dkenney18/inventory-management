package inventory_package;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class inventory_item {
	static String item_name;
	static String description;
	static String img_source;
	static int item_id;
	static int alert_number;
	static int stock;
	static Boolean discontinue;
	static Boolean in_stock;
	static Double price;
	static int max_id;
	// setting up the values for the class
	public static void set_initial_values() {
		item_name = "";
		description = "";
		img_source = "";
		item_id = 0;
		alert_number = 0;
		stock = 0;
		discontinue = false;
		in_stock = false;
		price = 0.0;
		max_id = 100;
	}
	// set item id as a string that the user enters
	public static void set_id() {
		String input;		
		input = JOptionPane.showInputDialog("Enter Item Id: ");
		item_id = Integer.parseInt(input);
	}
	// set the number of item in stock
	public static void set_stock() {
		String input;		
		input = JOptionPane.showInputDialog("Enter the number of item you have on hand: ");
		stock = Integer.parseInt(input);
		
	}
	// set the low inventory alert number. 
	public static void set_alert_number() {
		String input;		
		input = JOptionPane.showInputDialog("Enter number you want to alerted when that many is in stock: ");
		alert_number = Integer.parseInt(input);
	}
	// set items name
	public static void set_item_name() {
		item_name = JOptionPane.showInputDialog("Enter Item Name: ");
	}
	// set the description of the item
	public static void set_item_description() {
		description = JOptionPane.showInputDialog("Enter Item description: ");
	}
	// set the string path to the image. only URLs are accepted
	public static void set_img_url() {
		img_source = JOptionPane.showInputDialog("Enter the Image URL: ");
	}
	// set if the item is in stock
	public static void set_in_stock() {
		String input;
		input = JOptionPane.showInputDialog("Enter if the item is in stock (y/n)");
		if (input.toString().toLowerCase().equals("y")) {
			in_stock = true;
		}
		if (input.toString().toLowerCase().equals("n")) {
			in_stock = false;
		}
	}
	// set if we sell the item anymore
	public static void set_discontinue() {
		String input;
		input = JOptionPane.showInputDialog("Enter if the item is in discontuned (y/n)");
		if (input.toString().toLowerCase().equals("y")) {
			discontinue = true;
		}
		if (input.toString().toLowerCase().equals("n")) {
			discontinue = false;
		}
	}
	// set the price of the item like $$.$$
	public static void set_price() {
		String input;
		input = JOptionPane.showInputDialog("Enter a price for the item: ");
		price = Double.parseDouble(input);
	}
	// starting the functions to get the values of the Item
	public static int get_item_id() {
		return item_id;
	}
	public static int get_stock() {
		return stock;
	}
	public static int get_alert_number() {
		return alert_number;
	}
	public static String get_item_name() {
		return item_name;
	}
	public static String get_item_description() {
		return description;
	}
	public static void get_img_url() throws MalformedURLException {
		
	    URL url = new URL(img_source);
	    BufferedImage image = null;
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    JLabel label = new JLabel(new ImageIcon(image));
	    JFrame f = new JFrame();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.getContentPane().add(label);
	    f.pack();
	    f.setLocation(200,200);
	    f.setVisible(true);
	}
	public static Boolean get_in_stock() {
		return in_stock;
	}
	public static Boolean get_discontinue() {
		return discontinue;
	}
	public static Double get_item_price() {
		return price;
	}
	public void increment_count(int num) {
		stock += num;
	}
	
	public void decrement_count(int num) {
		stock -= num;
	}
	//end the value getting
	public static void setup_item_values() {
		inventory_item.set_initial_values();
		inventory_item.set_item_name();
		inventory_item.set_item_description();
		inventory_item.set_id();
		inventory_item.set_price();
		inventory_item.set_stock();
		inventory_item.set_alert_number();
		inventory_item.set_in_stock();
		inventory_item.set_discontinue();
		
	}
	//below is the "info sheet" of the item
	public static void info_pane() throws MalformedURLException {
		JOptionPane.showMessageDialog(null, "Item Name: " + inventory_item.get_item_name().toString() + "\n Item description: " + inventory_item.get_item_description().toString() + "\n Item price: " + inventory_item.get_item_price().toString() + "\n Item id: " + inventory_item.get_item_id() + "\n Items in stock: " + inventory_item.get_stock() + "\n alert when this many is left in stock: " + inventory_item.get_alert_number() + "\n Item in stock?: " + inventory_item.get_in_stock().toString() + "\n Item discontinued?: " + inventory_item.get_discontinue().toString());
	}
	// call everything now
	public static void main(String[] args) throws MalformedURLException{
		setup_item_values();
		info_pane();
		
	}
}
