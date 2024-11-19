package shubham;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

public class MenuDrivenApp {

    private static JTextArea textArea = new JTextArea();
    private static JFileChooser fileChooser = new JFileChooser();

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Menu Driven Application");

        // Create a JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");

        // Add menu items for File menu
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem saveAsFile = new JMenuItem("Save As");
        JMenuItem exitFile = new JMenuItem("Exit");

        // Add ActionListeners for File menu items
        newFile.addActionListener(e -> textArea.setText(""));  // Clear text area for New
        openFile.addActionListener(e -> openFile());
        saveFile.addActionListener(e -> saveFile());
        saveAsFile.addActionListener(e -> saveAsFile());
        exitFile.addActionListener(e -> System.exit(0));  // Exit application

        // Add items to File menu
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.addSeparator();  // Adds a separator line
        fileMenu.add(exitFile);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");

        // Add menu items for Edit menu
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        // Add ActionListeners for Edit menu items
        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());

        // Add items to Edit menu
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);

        // Add File and Edit menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Add the text area to the frame
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        frame.add(new JScrollPane(textArea));

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    // Method to handle file opening
    private static void openFile() {
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                String content = Files.readString(file.toPath());
                textArea.setText(content);  // Display file content in the text area
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error opening file");
            }
        }
    }

    // Method to handle file saving
    private static void saveFile() {
        File file = fileChooser.getSelectedFile();
        if (file == null) {
            saveAsFile();
        } else {
            try {
                Files.write(file.toPath(), textArea.getText().getBytes());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving file");
            }
        }
    }

    // Method to handle file saving with "Save As"
    private static void saveAsFile() {
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                Files.write(file.toPath(), textArea.getText().getBytes());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving file");
            }
        }
    }
}
