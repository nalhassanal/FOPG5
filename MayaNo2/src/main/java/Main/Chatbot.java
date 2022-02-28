package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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

    //declares JtextArea and JtextField for area to type and answers from robot//

    private JTextArea Chatarea = new JTextArea();

    /**
     *
     */
    private JTextField chatbox = new JTextField();
    
    /**
     *
     */
    public void ChatBot() {
        //starts a frame for gui//
        JFrame frame = new JFrame();
        //sets method to close when exiting GUI//
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //enables resizablity of window//
        frame.setResizable(true);
        //declaring some window properties//
        frame.setSize(600, 600);
        frame.setTitle("ChatBot Here to Help !");
        frame.add(Chatarea);
        frame.add(chatbox);
        Chatarea.setSize(600, 400);
        Chatarea.setLocation(2, 2);
        JScrollPane scroll = new JScrollPane(Chatarea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //add ability to scroll through textarea//
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
                    //detects keywords and returns approppriate answers with tutorials//
                } 
                else if (gtext.contains("edit") || gtext.contains("modify") || gtext.contains("change")) {
                    bot("If you're a staff member, You can edit the modules by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 1 in your keyboard to choose the (Modify Modules) menu choice " + "\n"
                            + "Step 3. Type in C on your keyboard to edit a module" + "\n"
                            + "Step 4. Input the code of the module you want to edit");
                }
                else if (gtext.contains("add") || gtext.contains("create")) {
                    bot("If you're a staff member, You can add a new module by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 1 in your keyboard to choose the (Modify Modules) menu choice " + "\n"
                            + "Step 3. Type in a on your keyboard to create a new module" + "\n"
                            + "Step 4. Follow the onscreen instructions to add all the module details"
                    + "\n" +"\n" +
                            "If you're a student, You can add/register modules by doing the following :-" + "\n"
                            + "Step 1. Login to your student account" + "\n"
                            + "Step 2. Type 2 in your keyboard to choose the (Add Module) menu choice " + "\n"
                            + "Step 3. Follow the onscreen instructions in order to register to your new module !" + "\n"
                    );
                }
                else if (gtext.contains("view") || gtext.contains("see") || gtext.contains("view modules") || gtext.contains("all modules")) {
                    bot("If you're a staff member, You can view all modules by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 2 in your keyboard to choose the (View Modules) menu choice " + "\n"
                            + "Step 3. Follow the onscreen instructions to choose what module to view"
                    + "\n" +"\n" +
                            "If you're a student, You can view all the modules by doing the following :-" + "\n"
                            + "Step 1. Login to your student account" + "\n"
                            + "Step 2. Type 1 in your keyboard to choose the (See all Modules) menu choice " + "\n");
                }
                else if (gtext.contains("forgot") || gtext.contains("password") || gtext.contains("username")) {
                    bot("If you have forgotten your username or password" + "\n" + "please send an email to s2122641@siswa.um.edu.my with the subject: Forgot Password/Username");
                }
                else if (gtext.contains("delete") || gtext.contains("remove") || gtext.contains("cancel")) {
                    bot("If you're a staff member, You can remove a module by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 1 in your keyboard to choose the (Modify Modules) menu choice " + "\n"
                            + "Step 3. Type in B on your keyboard to remove a module" + "\n"
                            + "Step 4. Input the code of the module you want to remove"
                    + "\n" +"\n" +
                            "If you're a student, You can delete a module by doing the following :-" + "\n"
                            + "Step 1. Login to your staff account" + "\n"
                            + "Step 2. Type 3 in your keyboard to choose the (Modify Modules) menu choice " + "\n"
                            + "Step 3. Follow the onscreen instructions to choose the module you want to delete" + "\n" +
                            "Step 4. The module is deleted !" + "\n"
                    );
                }
                else if (gtext.contains("register") || gtext.contains("signup") || gtext.contains("sign up") || gtext.contains("make a new account")) {
                    bot("If you want to make a new account do the following :- " + "\n"
                            + "Step 1. Press B on your keyboard to choose the Register option" + "\n"
                            + "Step 2. Specify whether you are a student or a staff by just typing \"student\" or \"staff\"" + "\n"
                            + "Step 3. Follow the onscreen instruction by entering the required information such as Full Name / Matrix No."
                    );
                }
                else if (gtext.contains("login") || gtext.contains("log in") || gtext.contains("sign in") || gtext.contains("enter") || gtext.contains("enter my account")) {
                    bot("If you want to sign-in to your existing account do the following :- " + "\n"
                            + "Step 1. Press A on your keyboard to choose the Register option" + "\n"
                            + "Step 2. Specify whether you are a student or a staff by just typing \"student\" or \"staff\"" + "\n"
                            + "Step 3. Enter your username (Case sensitive) then press enter" + "\n"
                            + "Step 4. Enter your password (Case sensitive) then press enter" + "\n");

                }
                else if (gtext.contains("timetable") || gtext.contains("schedule") || gtext.contains("plan") || gtext.contains("time") || gtext.contains("when")) {
                    bot("If you want to view your timetable as a student do the following :- " + "\n"
                            + "Step 1. Login to your student account" + "\n"
                            + "Step 2. Type 5 in your keyboard to choose the (View Timetable) menu choice " + "\n"
                            + "Step 3. your Timetable with all your current Modules will be printed on your screen" + "\n"
                    );
                }
                else if (gtext.contains("search for a module") || gtext.contains("search modules") || gtext.contains("search") || gtext.contains("find") || gtext.contains("look")) {
                    bot("If you want to search for a module as a student do the following :- " + "\n"
                            + "Step 1. Login to your student account" + "\n"
                            + "Step 2. Type 6 in your keyboard to choose the (Search Module) menu choice " + "\n"
                            + "Step 3. You will be prompted to enter the code of the Module you're looking for" + "\n"
                            + "Step 4. The system will return all the matching modules !" + "\n"
                    );
                }
                else if (gtext.contains("registered") || gtext.contains("courses registered") || gtext.contains("registered courses") || gtext.contains("view registered courses")) {
                    bot("If you want to view all your registered courses as a student do the following :- " + "\n"
                            + "Step 1. Login to your student account" + "\n"
                            + "Step 2. Type 4 in your keyboard to choose the (View Registered Courses) menu choice " + "\n"
                            + "Step 3. The system will return all courses you are enrolled in!" + "\n"
                    );
                }
                else if(gtext.contains("occurence") || gtext.contains("add occurence") || gtext.contains("edit existing module")){
                    bot("If you are a lecturer and want to add more occurences to a module \nEspecially when reached full capacity of occurences"
                            + "Step 1. You must delete the whole module"
                            + "Step 2. You then must add the module again but add more occurence to the module\n");
                    
                }
                else if(gtext.contains("help")){
                    bot("I can help you with some things such as \n1) delete a module\n2) add occurence\n3) view courses..\njust to name a few");
                    
                }
                else {
                    //small randomizer to cycle between different responses when chatbot doesnt understand question//
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
