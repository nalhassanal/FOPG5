package Main;

/**
 *
 * @author Hassanal
 */

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import java.util.Scanner;
import org.bson.Document;

public class testMongodb {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        try{
            String url = "mongodb+srv://root:wix1002db@fopdb.bmv7r.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
            String Db = "FOPDB" , Col = "registration";
            int index = 2;
            index++;
            String name = "", MatrixNum = "";
            System.out.println("Enter name and Matrix num");
            name = input.nextLine();
            MatrixNum = input.nextLine();
            
            // creates the connection to the server
            MongoClient mongo = MongoClients.create(url);
            

            System.out.println("Successfully Connected to MongoDB");
            // creates a db if not exist
            MongoDatabase db = mongo.getDatabase(Db);
            // creats a collection if not exist
            MongoCollection col = db.getCollection(Col);

            Document sample = new Document("_id",index).append("Name",name).append("Matrix Number", MatrixNum);
            // writes a document into the collection
            col.insertOne(sample);

            System.out.println("Successfully registered in database");
            // since collections in mongodb consists of array list
            // so we must use the iterable 
            System.out.println("Displaying the list of documents");
            FindIterable<Document> iterobj;
            iterobj = col.find();
            
            Iterator itr = iterobj.iterator();
            while (itr.hasNext()){
                System.out.println(itr.next());
            }
            
            // closes connection to database
            mongo.close();
        } catch(Exception e){
            System.out.println("Connection establishment failed");
            System.out.println(e);
        }
    }
    
    
//    public static void createCollection(String collectionName){
//        
//    }
//    
//    
//    
    
}
