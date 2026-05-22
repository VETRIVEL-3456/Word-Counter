import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class WordCounter extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton countButton;
    JLabel resultLabel;

    WordCounter() {

        setTitle("Word Counter");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setBounds(20, 20, 340, 150);
        add(textArea);

        countButton = new JButton("Count Words");
        countButton.setBounds(120, 190, 140, 30);
        countButton.addActionListener(this);
        add(countButton);

        resultLabel = new JLabel("Word Count: 0");
        resultLabel.setBounds(130, 230, 150, 30);
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            String text = textArea.getText();

            BufferedReader br = new BufferedReader(new StringReader(text));

            String line = br.readLine();

            if (line == null || line.trim().isEmpty()) {
                resultLabel.setText("Word Count: 0");
            }

            else {

                String[] words = line.trim().split("\\s+");

                resultLabel.setText("Word Count: " + words.length);
            }

        }

        catch (Exception ex) {

            resultLabel.setText("Error");

        }
    }

    public static void main(String[] args) {

        new WordCounter();

    }
}
