package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author haikal
 */
public class searchModule {

    public searchModule(){
    }

    public void SearchModule()  {
        
        File input = new File("allModules.txt");
        
        @SuppressWarnings("resource")
        Scanner ob = new Scanner(System.in);
        String searchWord;
        
        System.out.println("Enter the term you want to search: ");
        System.out.println("Enter exit to return");
        searchWord = ob.nextLine();
        if (searchWord.toUpperCase().equals("EXIT")) {
            System.out.println("Exited");
        } else {
            System.out.println();
            try {
                FileReader fr = new FileReader(input);
                BufferedReader br = new BufferedReader(fr);

                for (String line; (line = br.readLine()) != null;) {
                    if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                        String data[] = line.split(",");
                        System.out.println("Module code " + data[0]);
                        System.out.println("Module name " + data[1]);
                        System.out.println("Number of Occurences " + data[2]);
                        System.out.println("Numeber of Credits " + data[3]);
                        System.out.println("Activity modes " + data[4]);
                        System.out.println();
                        System.out.println("--------------------------------------------------------");
                    }
                }
                fr.close();
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("IO Error " + ex.getMessage());
            }
            System.out.println();
        }
        //ob.close();
    }   
}