import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ConvertTemp extends JFrame implements ActionListener{
    private Container pane;
    private JButton b;
    private JCheckBox c,c2;
    private JTextField t;

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(s.equals("Convert")){
            if( c.isSelected() ){
		System.out.println(
				   "" + CelsiusToFarenheit(Double.parseDouble(t.getText()))
				   );
            }
	    else if (c2.isSelected()){
		System.out.println(
				   "" + FarenheitToCelsius(Double.parseDouble(t.getText()))
				   );
            }
        }

    }

    public ConvertTemp() {
        this.setTitle("Temperature Conversion");
        this.setSize(500,80);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        b = new JButton("Convert");
        c = new JCheckBox("Farenheit");
	c2 = new JCheckBox("Celsius");
        t = new JTextField(15);

        b.addActionListener(this);
        t.addActionListener(this);
        c.addActionListener(this);
	c2.addActionListener(this);

        pane.add(t);
        pane.add(c);
        pane.add(c2);
        pane.add(b);

    }

    public static double FarenheitToCelsius(double F) {
	return ((F - 32) / 1.8);
    }

    public static double CelsiusToFarenheit(double C) {
	return ((C*1.8) + 32);
    }

    public static void main(String[] args) {
        ConvertTemp g = new ConvertTemp();
        g.setVisible(true);
    }
}
