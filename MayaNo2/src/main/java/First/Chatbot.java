package First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/**
 *
 * @author Yousef
 */
public class Chatbot {

    /**
     * empty constructor
     */
    public Chatbot(){
        
    }

    /**
     * instance 
     */
    private JTextArea Chatarea = new JTextArea();

    /**
     *
     */
    private JTextField chatbox = new JTextField();
    
    /**
     *
     */
    public void Chatbot() {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setResizable(true);

        frame.setSize(600, 600);
        frame.setTitle("ChatBot Here to Help !");
        frame.add(Chatarea);
        frame.add(chatbox);
        Chatarea.setSize(600, 400);
        Chatarea.setLocation(2, 2);
        JScrollPane scroll = new JScrollPane(Chatarea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);

        Chatarea.append("Hello! I am Chatbot. Your virtual guide." + "\n" + "I can help you navigate our brand new Maya 2.0 System!");
        Chatarea.append("\n" + "I can do lots of stuff! Just type whatever you need help with");
        Chatarea.append("\n" + "Some of the questions people ask me are:" + "\n" + "\"How do I register?\"" + "\n" + "\"I forgot my password\"" + "\n" + "\"How do edit modules\"");
        chatbox.setSize(540, 30);
        chatbox.setLocation(2, 500);
        frame.setVisible(true);
        chatbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String gtext = chatbox.getText().toLowerCase();
                Chatarea.append("What do you want to ask ?" + "\n" + gtext + "\n");
                chatbox.setText("");
                if (gtext.contains("hi")) {
                    bot("Hello !");
                } else if (gtext.contains("edit") || gtext.contains("modify") || gtext.contains("change")) {
                    bot("If you're a staff member, You can edit the modules by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 1 in your keyboard to choose the (Modify Modules) menu choice " + "\n"
                            + "Step 3. Type in C on your keyboard to edit a module" + "\n"
                            + "Step 4. Input the code of the module you want to edit");
                } else if (gtext.contains("add") || gtext.contains("create")) {
                    bot("If you're a staff member, You can add a new module by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 1 in your keyboard to choose the (Modify Modules) menu choice " + "\n"
                            + "Step 3. Type in a on your keyboard to create a new module" + "\n"
                            + "Step 4. Follow the onscreen instructions to add all the module details");
                } else if (gtext.contains("view") || gtext.contains("see") || gtext.contains("view modules")) {
                    bot("If you're a staff member, You can view all modules by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 2 in your keyboard to choose the (View Modules) menu choice " + "\n"
                            + "Step 3. Follow the onscreen instructions to choose what module to view");
                } else if (gtext.contains("forgot") || gtext.contains("password") || gtext.contains("username")) {
                    bot("If you have forgotten your username or password" + "\n" + "please send an email to s2122641@siswa.um.edu.my with the subject: Forgot Password/Username");
                } else if (gtext.contains("delete") || gtext.contains("remove") || gtext.contains("cancel")) {
                    bot("If you're a staff member, You can remove a module by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 1 in your keyboard to choose the (Modify Modules) menu choice " + "\n"
                            + "Step 3. Type in B on your keyboard to remove a module" + "\n"
                            + "Step 4. Input the code of the module you want to remove");
                } else if (gtext.contains("register") || gtext.contains("signup") || gtext.contains("sign up") || gtext.contains("make a new account")) {
                    bot("If you want to make a new account do the following :- " + "\n"
                            + "Step 1. Press B on your keyboard to choose the Register option" + "\n"
                            + "Step 2. Specify whether you are a student or a staff by just typing \"student\" or \"staff\"" + "\n"
                            + "Step 3. Follow the onscreen instruction by entering the required information such as Full Name / Matrix No."
                    );
                } else if (gtext.contains("login") || gtext.contains("log in") || gtext.contains("sign in") || gtext.contains("enter") || gtext.contains("enter my account")) {
                    bot("If you want to sign-in to your existing account do the following :- " + "\n"
                            + "Step 1. Press A on your keyboard to choose the Register option" + "\n"
                            + "Step 2. Specify whether you are a student or a staff by just typing \"student\" or \"staff\"" + "\n"
                            + "Step 3. Enter your username (Case sensitive) then press enter" + "\n"
                            + "Step 4. Enter your password (Case sensitive) then press enter" + "\n"
                    );
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

    /**
     *
     * @param string
     */
    private void bot(String string) {
        Chatarea.append("Bot : " + string + "\n");
    }
}
