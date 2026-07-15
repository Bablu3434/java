import javax.swing.*;
public class kumar{
    public static void main(String[] args){
        JFrame frame = new JFrame("student form");
        JLabel nameLabel = new JLabel("Name:");
         nameLabel.setBounds(30,30,150,30);
         JTextField nameField = new JTextField();
            nameField.setBounds(140,30,150,30);
            JLabel ageLabel = new JLabel("Age:");
            ageLabel.setBounds(30,80,100,30);
            JTextField ageField = new JTextField();
            ageField.setBounds(140,80,150,30);
            JButton submitButton = new JButton("Submit");
            submitButton.setBounds(140,140,120,35);
            frame.add(nameLabel);
            frame.add(nameField);
            frame.add(ageLabel);
            frame.add(ageField);
            frame.add(submitButton);

            frame.setSize(350,250);
            frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);    
    }
}
