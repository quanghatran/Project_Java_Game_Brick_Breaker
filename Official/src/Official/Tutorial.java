package Official;

 
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class Tutorial extends JFrame {
    public Tutorial() {
        // create frame with title "HelloWorld"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // set location
       
        
		setBounds(10, 10, 700, 600);
		setTitle("Tutorial");
        // add a JLabel
        add(new JLabel("HelloWorld"));
 
        // display frame
        setVisible(true);
        setLocationRelativeTo(null);
    }
 
}