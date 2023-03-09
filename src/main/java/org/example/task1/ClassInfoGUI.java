package org.example.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassInfoGUI extends JFrame {

    private JTextField classPathField;
    private JTextArea resultArea;

    public ClassInfoGUI() {
        initUI();
    }

    private void initUI() {
        setTitle("My Class Info");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel classPathLabel = new JLabel("Class path:");
        classPathField = new JTextField(30);
        inputPanel.add(classPathLabel);
        inputPanel.add(classPathField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton getInfoButton = new JButton("Get Info");
        getInfoButton.addActionListener(new GetInfoButtonListener());
        buttonPanel.add(getInfoButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        JLabel resultLabel = new JLabel("Class info:");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);

        add(mainPanel);
        setVisible(true);
    }

    private class GetInfoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String classPath = classPathField.getText();
            String classInfo = Task1.getInfo(classPath);
            resultArea.setText(classInfo);
        }
    }
}
