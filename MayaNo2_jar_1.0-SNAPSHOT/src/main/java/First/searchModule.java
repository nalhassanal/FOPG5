package First;

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
        
        Scanner ob = new Scanner(System.in);
        String searchWord;
        
        System.out.println("Enter the module code you want to search: ");
        searchWord = ob.nextLine();
        System.out.println();
        try{
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            
            for(String line; (line = br.readLine()) != null;) {
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    String data [] = line.split(",");
                    System.out.println("Module code " +data[0]);
                    System.out.println("Module name " +data[1]);
                    System.out.println("Number of Occurences " +data[2]);
                    System.out.println("Numeber of Credits " +data[3]);
                    System.out.println("Activity modes " +data[4]);                    
                }
            }
            fr.close();
            br.close();
        } catch(FileNotFoundException ex){
            System.out.println("File not found " +ex.getMessage());
        } catch ( IOException ex) {
            System.out.println("IO Error " + ex.getMessage());
        }
        System.out.println();
    }   
}