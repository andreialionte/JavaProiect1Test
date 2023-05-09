import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class StartWindow extends JFrame implements ActionListener {

    private JButton registrationButton;
    private JButton exitButton;
    private JButton plecare;
    private JButton memoreaza; //

    public StartWindow() {
        setTitle("Start Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);

        // Create the "Inregistrare" and "Plecare" buttons and add them to the window
        registrationButton = new JButton("Inregistrare");
        plecare = new JButton("Plecare");
        exitButton = new JButton("Iesire");
        memoreaza = new JButton("Memoreaza"); //
        memoreaza.setPreferredSize(new Dimension(100, 30));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registrationButton);
        buttonPanel.add(plecare);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Attach action listeners to the buttons
        registrationButton.addActionListener(this);
        plecare.addActionListener(this);
        exitButton.addActionListener(this);
        memoreaza.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrationButton) {
            // Create and display the registration window
            RegistrationWindow registrationWindow = new RegistrationWindow();
            registrationWindow.setVisible(true);
        } else if (e.getSource() == plecare) {
            // Create and display the "Plecare" window
            PLeavingWindow plecareWindow = new PLeavingWindow();
            plecareWindow.setVisible(true);
        } else if (e.getSource() == exitButton) {
            // Exit the application
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Create and display the start window
        StartWindow window = new StartWindow();
        window.setVisible(true);
    }

    class RegistrationWindow extends JFrame implements ActionListener {

        private JButton registrationButton;
        private JButton exitButton;

        private JTextField nameField;
        private JTextField surnameField;
        private JTextField idCardField;
        private JTextField idNumberField;
        private JSpinner arrivalSpinner;
        private JSpinner departureSpinner;
        private JSpinner numPersonsSpinner;
        private JSpinner roomNumberSpinner;

        public RegistrationWindow() {
            setTitle("Inregistrare");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(600, 400);

            // Create the input fields and add them to the window
            JPanel inputPanel = new JPanel(new GridLayout(8, 2));
            inputPanel.add(new JLabel("Nume:"));
            nameField = new JTextField();
            inputPanel.add(nameField);
            inputPanel.add(new JLabel("Prenume:"));
            surnameField = new JTextField();
            inputPanel.add(surnameField);
            inputPanel.add(new JLabel("Carte de identitate:"));
            idCardField = new JTextField();
            inputPanel.add(idCardField);
            inputPanel.add(new JLabel("Numar CI:"));
            idNumberField = new JTextField();
            inputPanel.add(idNumberField);
            inputPanel.add(new JLabel("Data sosire:"));
            arrivalSpinner = new JSpinner(new SpinnerDateModel());
            inputPanel.add(arrivalSpinner);
            inputPanel.add(new JLabel("Data plecare:"));
            departureSpinner = new JSpinner(new SpinnerDateModel());
            inputPanel.add(departureSpinner);
            inputPanel.add(new JLabel("Numar persoane:"));
            numPersonsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
            inputPanel.add(numPersonsSpinner);
            inputPanel.add(new JLabel("Numar camera:"));
            roomNumberSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
            inputPanel.add(roomNumberSpinner);

            // Create the "Inregistrare" and "Plecare" buttons and add them to the window
            registrationButton = new JButton("Inregistrare");
            exitButton = new JButton("Inchide");
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(registrationButton);
            buttonPanel.add(exitButton);
            add(inputPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);

            // Attach action listeners to the buttons
            registrationButton.addActionListener(this);
            exitButton.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == registrationButton) {
                // Get the input data from the fields
                String name = nameField.getText();
                String surname = surnameField.getText();
                String idCard = idCardField.getText();
                String idNumber = idNumberField.getText();
                Date arrivalDate = (Date) arrivalSpinner.getValue();
                Date departureDate = (Date) departureSpinner.getValue();
                int numPersons = (int) numPersonsSpinner.getValue();
                int roomNumber = (int) roomNumberSpinner.getValue();

                // Do something with the input data, e.g. save it to a database
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("inregistrare.txt", true));
                    writer.write(name + " " + surname + ", CI: " + idNumber + ", Sosire: " + arrivalDate + ", Plecare: "
                            + departureDate + ", Persoane: " + numPersons + ", Camera: " + roomNumber);
                    writer.newLine();
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Eroare la scrierea datelor!");
                }
            } else if (e.getSource() == exitButton) {
                // Close the registration window
                dispose();
            }
        }

    }

    public class PLeavingWindow extends JFrame implements ActionListener {

        private JButton pleavingMemoreazaButton;

        public PLeavingWindow() {
            super("My Window");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pleavingMemoreazaButton = new JButton("Memoreaza");
            pleavingMemoreazaButton.addActionListener(this);
            pleavingMemoreazaButton.setPreferredSize(new Dimension(100, 50));

            getContentPane().add(pleavingMemoreazaButton, BorderLayout.CENTER);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == pleavingMemoreazaButton) {

            }
        }
    }

}
