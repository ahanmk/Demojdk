package gui;

import model.Student;
import service.StudentManager;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {       // inheritance from JFrame

    private StudentManager manager = new StudentManager();   // composition

    private JTextField nameField = new JTextField(10);
    private JTextField marksField = new JTextField(5);
    private JButton addButton = new JButton("Add Student");
    private JTextArea displayArea = new JTextArea(8, 30);

    public MainWindow() {
        setTitle("Student Records");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel: input form
        JPanel top = new JPanel();
        top.add(new JLabel("Name:"));
        top.add(nameField);
        top.add(new JLabel("Marks:"));
        top.add(marksField);
        top.add(addButton);

        displayArea.setEditable(false);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Event: runs when the button is clicked
        addButton.addActionListener(e -> handleAdd());
    }

    private void handleAdd() {
        try {
            String name = nameField.getText().trim();
            int marks = Integer.parseInt(marksField.getText().trim());

            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name is empty");
            }

            manager.addStudent(new Student(name, marks));
            refreshDisplay();
            nameField.setText("");
            marksField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Marks must be a number.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void refreshDisplay() {
        displayArea.setText("");
        for (Student s : manager.getAll()) {
            displayArea.append(s.getDetails() + "\n");
        }
    }
}