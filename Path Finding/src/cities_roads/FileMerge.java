package cities_roads;
import java.io.*;
import javax.swing.JOptionPane; 

public class FileMerge  
{ 
	public static void main() throws Exception {
		System.out.println("If you want to merge cities and roads, you must enter the txt of cities first!");
		String file1=JOptionPane.showInputDialog("Please enter the name of the first txt you want to merge. It has to be the cities first!");
    	String file2=JOptionPane.showInputDialog("Please enter the name of the second txt you want to merge. It has to be the roads!");
    	String file3=JOptionPane.showInputDialog("Please enter the name of the third txt you want to create!");
    	File f1 = new File(file1+".txt");
    	File f2 = new File(file2+".txt");
    	File f3 = new File(file3+".txt");
    	
    	if(!f1.exists() && !f1.isDirectory()) {
    		System.out.println("The file: "+f1+" does not exist!");
			System.out.println("Please enter a different name!");
    	}else if(!f2.exists() && !f2.isDirectory()) {
    		System.out.println("The file: "+f2+" does not exist!");
			System.out.println("Please enter a different name!");
    	}
    	else if(f3.exists() && !f3.isDirectory()) { 
			System.out.println("The file: "+f3+" exists!");
			System.out.println("Please enter a different name!");
		}else {
    	
	    	// PrintWriter object for file3.txt 
	        PrintWriter pw = new PrintWriter(file3+".txt"); 
	          
	        // BufferedReader object for file1.txt 
	        BufferedReader br = new BufferedReader(new FileReader(file1+".txt")); 
	          
	        String line = br.readLine(); 
	          
	        // loop to copy each line of  
	        // file1.txt to  file3.txt 
	        while (line != null) 
	        { 
	            pw.println(line); 
	            line = br.readLine(); 
	        } 
	          
	        br = new BufferedReader(new FileReader(file2+".txt")); 
	          
	        line = br.readLine(); 
	          
	        // loop to copy each line of  
	        // file2.txt to  file3.txt 
	        while(line != null) 
	        { 
	            pw.println(line); 
	            line = br.readLine(); 
	        } 
	          
	        pw.flush(); 
	          
	        // closing resources 
	        br.close(); 
	        pw.close(); 
		    System.out.println("You have merged "+ file1+".txt"+" and "+file2+".txt"+" into "+ file3+".txt"); 
		}	
	}
} 