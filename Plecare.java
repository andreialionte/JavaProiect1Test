import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Plecare extends JFrame implements ActionListener {
    
    private JButton plecareButton;
    
    public Plecare() {
        setTitle("Plecare");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 100);
        
        // Create the "Plecare" button and add it to the window
        plecareButton = new JButton("Plecare");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(plecareButton);
        add(buttonPanel, BorderLayout.CENTER);
        
        // Attach an action listener to the button
        plecareButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plecareButton) {
            JOptionPane.showMessageDialog(this, "Ai apasat butonul Plecare!");
        }
    }
    
    public static void main(String[] args) {
        // Create and display the Plecare window
        Plecare window = new Plecare();
        window.setVisible(true);
    }
}
