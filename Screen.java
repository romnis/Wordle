package org.example;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.ArrayList;

public class Screen {
    private final int screenHeight = 700;
    private final int screenWidth = 600;
    private JFrame frame;
    private final int lettersNum = 5;
    private final int triesNum = 6;
    private final ArrayList<JButton> okButtons = new ArrayList<>();
    private final ArrayList<ArrayList<JTextField>> textBoxes = new ArrayList<>();

    public void createScreen() {

        frame = new JFrame("Wordle");
        frame.setSize(screenWidth, screenHeight);
        frame.setLayout(null);
        JLabel wordle = new JLabel();
        wordle.setText("WORDLE");
        wordle.setBounds(250, 0, 100, 100);
        frame.add(wordle);
        createTextBoxes();

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void createTextBoxes(){
        int y = 50;
        for (int j = 0; j < triesNum; j++){
            int x = 100;
            y += 50;
            textBoxes.add(new ArrayList<>());
            for (int i = 0; i < lettersNum; i++){
                JTextField text = new JTextField();
                text.setDocument(new JTextFieldLimit(1));
                text.setBounds(x, y, 30, 30);
                frame.add(text);
                textBoxes.get(j).add(text);
                x += 60;
            }
            JButton ok = new JButton("✔");
            ok.setBounds(x, y, 45, 30);
//            ok.addActionListener(e -> handleUserClick(x, y, ok));
            frame.add(ok);
            okButtons.add(ok);
        }
    }
    private void handleUserClick(int x, int y, JButton button) {
//        userClickObservers.forEach(userClickObserver -> userClickObserver.handleUserClick(x, y));
    }
    private class JTextFieldLimit extends PlainDocument {
        private final int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }
}
