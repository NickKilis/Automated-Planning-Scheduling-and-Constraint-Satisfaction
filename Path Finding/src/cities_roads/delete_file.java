package cities_roads;
import java.io.*;
import javax.swing.JOptionPane;

public class delete_file {
	public static void main() { 
		String filePath=JOptionPane.showInputDialog("Please enter the name of the file you want to delete!");
		
        try { 
            // Get the file 
            File f = new File(filePath+".txt");
            String action =JOptionPane.showInputDialog("Confirm by pressing \"y\"! Cancel by pressing \"n\"!");
            if(action.equals("y")) {
            	f.delete();
            	System.out.println("File "+filePath+".txt"+" was deleted!"); 
            }else if(action.equals("n")) {
            	System.out.println("File "+filePath+".txt"+" was not deleted!"); 
            }
        } 
        catch (Exception e) { 
            System.err.println(e); 
        } 
    }
}
