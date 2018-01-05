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
	}
	
	public static void set_id() {
		String input;		
		input = JOptionPane.showInputDialog("Enter Item Id: ");
		item_id = Integer.parseInt(input);
	}
	public static void set_stock() {
		String input;		
		input = JOptionPane.showInputDialog("Enter the number of item you have on hand: ");
		stock = Integer.parseInt(input);
		
	}
	public static void set_alert_number() {
		String input;		
		input = JOptionPane.showInputDialog("Enter number you want to alerted when that many is in stock: ");
		alert_number = Integer.parseInt(input);
	}
	public static void set_item_name() {
		item_name = JOptionPane.showInputDialog("Enter Item Name: ");
	}
	public static void set_item_description() {
		description = JOptionPane.showInputDialog("Enter Item description: ");
	}
	public static void set_img_url() {
		img_source = JOptionPane.showInputDialog("Enter the Image URL: ");
	}
	public static void set_in_stock() {
		String input;
		input = JOptionPane.showInputDialog("Enter if the item is in stock (y/n)");
		if (input == "y") {
			in_stock = true;
		}
		if (input == "n") {
			in_stock = false;
		}
	}
	public static void set_discontinue() {
		String input;
		input = JOptionPane.showInputDialog("Enter if the item is in discontuned (y/n)");
		if (input == "y") {
			discontinue = true;
		}
		if (input == "n") {
			discontinue = false;
		}
	}
	public static void set_price() {
		String input;
		input = JOptionPane.showInputDialog("Enter a price for the item: ");
		price = Double.parseDouble(input);
	}
	public static void get_id() {
		JOptionPane.showMessageDialog(null, String.format("you entered: %d", item_id));
	}
	public static void get_stock() {
		JOptionPane.showMessageDialog(null, String.format("you entered: %d", stock));
	}
	public static void get_alert_number() {
		JOptionPane.showMessageDialog(null, String.format("you entered: %d", alert_number));
	}
	public static void get_item_name() {
		JOptionPane.showMessageDialog(null, String.format("you entered: %s", item_name));
	}
	public static void get_item_description() {
		JOptionPane.showMessageDialog(null, String.format("you entered: %s", description));
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
	public static void get_in_stock() {
		if (in_stock == true) {
			JOptionPane.showMessageDialog(null, String.format("item is in stock %s", in_stock));
		}
		if (in_stock == false) {
			JOptionPane.showMessageDialog(null,String.format("item is not in stock %s", in_stock));
		}
	}
	public static void get_discontinue() {
		if (discontinue == true ) {
			JOptionPane.showMessageDialog(null, String.format("item is in stock %s", discontinue));
		}
		if (discontinue == false) {
			JOptionPane.showMessageDialog(null,String.format("item is not stock %s", discontinue));
		}
	}
	public static void get_price() {
		JOptionPane.showMessageDialog(null, price);
	}
	public static void main(String[] args) throws MalformedURLException{
		set_initial_values();
		set_id();
		set_stock();
		set_alert_number();
		set_item_name();
		set_item_description();
		set_img_url();
		set_in_stock();
		set_discontinue();
		set_price();
		get_id();
		get_stock();
		get_alert_number();
		get_item_name();
		get_item_description();
		get_img_url();
		get_in_stock();
		get_discontinue();
		get_price();
		
		
		
	}
}
