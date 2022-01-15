/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author yoyoa
 */
public class Chatbot extends JFrame {

    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();

    public Chatbot() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setTitle("ChatBot Here to Help !");
        frame.add(Chatarea);
        frame.add(chatbox);
        Chatarea.setSize(600, 400);
        Chatarea.setLocation(2, 2);
        chatbox.setSize(540, 30);
        chatbox.setLocation(2, 500);
        chatbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String gtext = chatbox.getText().toLowerCase();
                Chatarea.append("What do you want to ask ?" + gtext + "\n");
                chatbox.setText("");
                if (gtext.contains("hi")) {
                    bot("Hello !");
                } else {
                    Random rand = new Random();
                    int amount = rand.nextInt(3);
                    if (amount == 1) {
                        bot("I didn't understand that D:");
                    } else if (amount == 2) {
                        bot("I dont understand what that means yet ;-;");

                    } else if (amount == 3) {
                        bot("Im too dumb for that question");
                    }
                }
            }
        }
        );

    }

    private void bot(String string) {
        Chatarea.append("Bot : " + string + "\n");
    }

    public static void main(String[] args) {
        new Chatbot();
    }
}
