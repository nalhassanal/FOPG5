package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class timetableupdater {
    void updater(String studentmatrix)
    {
        //declaration of array variable and normal variable for the usage of the method
        String[] subjectlist = new String[30];
        String[] moduleselectview = new String[30];
        String[] subjectmodeview = new String[30];
        String[] subjectoccview = new String[30];
        String[] lecturernameview = new String[30];
        String[] subjectdayview = new String[30];
        String[] subjecttimeview = new String[30];
        String[] modulenameview = new String[30];
        String[] modesubjectview = new String[30];
        String[] subjecttimetableview = new String[30];
        String[] moduleviewsplit;
        int[][] timetablelisttime = new int[5][10];
        String[][] subject = new String[5][10];
        String[][] mode = new String[5][10];
        String[][] subjectviewtimetable =  new String[5][10];
        String[] day = {"Mo", "Tu", "We", "Th", "Fr"};
        
        //read from student modules file and extract all the information
        try {
            File studentmodulefile = new File(studentmatrix + "modules.txt");
            if (!studentmodulefile.exists()) {
                studentmodulefile.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(studentmodulefile));

            for (int t = 0; t < 30; t++) {
                subjectlist[t] = reader.readLine();
                if (subjectlist[t] != null) {
                    moduleviewsplit = subjectlist[t].split(",");
                    moduleselectview[t] = moduleviewsplit[0];
                    subjectmodeview[t] = moduleviewsplit[1];
                    subjectoccview[t] = moduleviewsplit[2];
                    lecturernameview[t] = moduleviewsplit[3];
                    subjectdayview[t] = moduleviewsplit[4];
                    subjecttimeview[t] = moduleviewsplit[5];
                    subjecttimetableview[t] = moduleselectview[t]+" ("+subjectmodeview[t]+")";
                }

            }
            reader.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        int timetableindexrow = 0;

        String[] timesplit;
        int starttime = 0;
        int endtime = 0;
        int diftime;
        //for loop to set the subject into the specific format of time arranged
        //for each loop, 1 subject + subject mode is involved
        for (int i = 0; i < subjectdayview.length; i++) {
            if (subjectdayview[i] == null) {
                break;
            }
            //set the *row* index of the subject for time table
            if (subjectdayview[i].equals("MONDAY")) {
                timetableindexrow = 0;
            }
            if (subjectdayview[i].equals("TUESDAY")) {
                timetableindexrow = 1;
            }
            if (subjectdayview[i].equals("WEDNESDAY")) {
                timetableindexrow = 2;
            }
            if (subjectdayview[i].equals("THURSDAY")) {
                timetableindexrow = 3;
            }
            if (subjectdayview[i].equals("FRIDAY")) {
                timetableindexrow = 4;
            }

            //get the start time and the end time for the subject teachings
            if (!subjecttimeview.equals(null)) {
                timesplit = subjecttimeview[i].split(" - ");
                starttime = Integer.parseInt(timesplit[0]);
                endtime = Integer.parseInt(timesplit[1]);
                diftime = endtime - starttime;
            }
            //create temporary file to write starting time for 1 hour of the subject
            //example: for Lecture WIX1002, time = 0900 - 1100, so the starting time for an hour is 0900 and 1000(2 hours) (to be printed in the timetable)
            try {
                File studentfile = new File("test.txt");
                if (!studentfile.exists()) {
                    studentfile.createNewFile();
                }
                PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile));

                for (int m = starttime; m < endtime; m = m + 100) {
                    writer.println(m);
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error");
            }
            //read the time from test file
            int[] timehours = new int[3];
            int[] timehoursupdated = new int[3];
            try {
                File testfile = new File("test.txt");
                if (!testfile.exists()) {
                    testfile.createNewFile();
                }
                BufferedReader reader = new BufferedReader(new FileReader(testfile));
                String read;
                for (int m = 0; m < 3; m++) {
                    read = reader.readLine();
                    if (read != null) {
                        //change Sttring to Int
                        timehours[m] = Integer.parseInt(read); // 900 1000 1100
                        //set to be more smaller int for next usage to be more effective
                        timehoursupdated[m] = timehours[m] / 100;
                    }
                }
                

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int m = 9; m < 18; m++) {
                //set the 2d index based on the time that being simplified above
                for (int n = 0; n < 3; n++) {
                    if (timehours[n] == m * 100) {
                        timetablelisttime[timetableindexrow][(m - 9)] = timehours[n];
                        subjectviewtimetable[timetableindexrow][(m - 9)] = subjecttimetableview[i];
                    }
                }
            }
        }
        //write the subject listed into student timetable file
        try {
            File studentfile = new File(studentmatrix + "timetable.txt");
            if (!studentfile.exists()) {
                studentfile.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile));

            for (int i = 0; i < 5; i++) {
                for (int m = 0; m < 10; m++) {
                    if(subjectviewtimetable[i][m]!=null)
                        writer.println(subjectviewtimetable[i][m]);
                    else
                        writer.println("-"); 
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
/* Example of the timetable file format

index    |--------------| what inside the index(if no subject available during the time, "-" will be inside the index)
index 00 => Monday,0900 => Subject code
index 01 => Monday,1000 => Subject code
index 02 => Monday,1100 => Subject code
index 03 => Monday,1200 => Subject code
index 04 => Monday,1300 => Subject code
index 05 => Monday,1400 => Subject code
index 06 => Monday,1500 => Subject code
index 07 => Monday,1600 => Subject code
index 08 => Monday,1700 => Subject code
index 09 => Monday,1800 => Subject code
index 10 => Tuesday,0900 => Subject code
index 11 => Tuesday,1000 => Subject code
:
:
:
index 49 => Friday,1800 => Subject code
*/
