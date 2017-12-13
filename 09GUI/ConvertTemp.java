import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConvertTemp extends JFrame {
    private Container pane;

    private JButton b;
    private JTextField t;
    private JCheckbox c;

    public ConvertTemp() {
	this.setTitle("Temperature Converson");
	this.setSize(600, 400);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	t = new JTextField(12);
	b = new JButton("Farenheit");
	b2 = new JButton("Celsius");

	pane.add(t);
	pane.add(b);
	pane.add(b2);
    }

    public static void main(String[] args){
	ConvertTemp g = new ConverTemp();
	g.setVisible(true);
    }

    public static double farenheitToCelsius(double f){
	return ((f - 32) / 1.8);
    }

    public static double celsiusToFarenheit(double c){
	return ((c*1.8) + 32);
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	if (s.equals("Farenheit")){
		System.out.println("" + celsiusToFarenheit(Integer.parseInt(t.getText())));
	}
	if (s.equals("Celsius")){
	    System.out.println("" + farenheitToCelsius(Integer.parseInt(t.getText())));
	}   
    }
}
