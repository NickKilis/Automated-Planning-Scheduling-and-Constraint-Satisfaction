package cities_roads;
import java.io.BufferedReader;  
import java.io.FileReader;
import javax.swing.JOptionPane;  
   
public class CountLinesFile   
{  
    public static void main(String[] args) throws Exception {
    	String file_name=JOptionPane.showInputDialog("Please enter the name of the txt you want!");
        String line;  
        int count = 0;  
          
        //Opens a file in read mode  
        FileReader file = new FileReader(file_name+".txt");  
        BufferedReader br = new BufferedReader(file);  
              
        //Gets each line till end of file is reached  
        while((line = br.readLine()) != null) {  
            //Splits each line into words  
            String words[] = line.split(" ");  
            //Counts each word  
            count = count + words.length;  
        }  
          
        System.out.println("Number of words present in given file: " + count);  
        br.close();  
    }  
}  
