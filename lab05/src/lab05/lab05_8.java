package lab05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class lab05_8 {

    static File currentFile = null;

    public static void main(String[] args) {

    	JFrame frame = new JFrame(
    	        "Pattaraporn Kanpee 68160162 n89");
    	
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== TextArea =====
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // ===== Menu Bar =====
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemSaveAs = new JMenuItem("Save As");
        JMenuItem itemExit = new JMenuItem("Exit");

        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.add(itemSaveAs);
        menuFile.addSeparator();
        menuFile.add(itemExit);

        menuBar.add(menuFile);
        frame.setJMenuBar(menuBar);

        // ===== New =====
        itemNew.addActionListener(e -> {
            textArea.setText("");
            currentFile = null;
        });

        // ===== Open =====
        itemOpen.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = chooser.getSelectedFile();
                try {
                    BufferedReader reader =
                            new BufferedReader(new FileReader(currentFile));
                    textArea.read(reader, null);
                    reader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Cannot open file");
                }
            }
        });

        // ===== Save =====
        itemSave.addActionListener(e -> {
            if (currentFile == null) {
                itemSaveAs.doClick();
            } else {
                try {
                    PrintWriter writer =
                            new PrintWriter(currentFile);
                    writer.write(textArea.getText());
                    writer.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Cannot save file");
                }
            }
        });

        // ===== Save As =====
        itemSaveAs.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showSaveDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = chooser.getSelectedFile();
                try {
                    PrintWriter writer =
                            new PrintWriter(currentFile);
                    writer.write(textArea.getText());
                    writer.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Cannot save file");
                }
            }
        });

        // ===== Exit =====
        itemExit.addActionListener(e -> {
            System.exit(0);
        });

        // ===== Layout =====
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
