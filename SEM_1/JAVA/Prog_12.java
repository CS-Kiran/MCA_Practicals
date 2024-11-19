package Java_Prog;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

public class Prog_12 {

    private static JTextArea textArea = new JTextArea();
    private static JFileChooser fileChooser = new JFileChooser();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Driven Application");

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem saveAsFile = new JMenuItem("Save As");
        JMenuItem exitFile = new JMenuItem("Exit");

        newFile.addActionListener(e -> textArea.setText(""));
        openFile.addActionListener(e -> openFile());
        saveFile.addActionListener(e -> saveFile());
        saveAsFile.addActionListener(e -> saveAsFile());
        exitFile.addActionListener(e -> System.exit(0)); 
        
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(exitFile);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());

        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        frame.add(new JScrollPane(textArea));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private static void openFile() {
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                String content = Files.readString(file.toPath());
                textArea.setText(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error opening file");
            }
        }
    }

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