package cities_roads;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class replace_line_in_file {
	static void modifyFile(String filePath, String oldString, String newString) {
		try{
        File file = new java.io.File(filePath);
        Scanner scanner = new Scanner(file);
        StringBuilder buffer = new StringBuilder();
        while(scanner.hasNext()){
          buffer.append(scanner.nextLine().replaceAll(oldString, newString));
          if(scanner.hasNext())buffer.append("\n");
        }
        scanner.close();
        PrintWriter printer = new PrintWriter(file);
        printer.print(buffer);
        printer.close();
		}
		catch (IOException e)
        {
            e.printStackTrace();
        }
		
	}
	
	public static void main() throws IOException{
    	String name_of_txt=JOptionPane.showInputDialog("Please enter the name of the file!");
    	File f = new File(name_of_txt+".txt");
        if(f.exists() && !f.isDirectory()) { 
			System.out.println("The file: "+f+" exists!");
			String old_string=JOptionPane.showInputDialog("Please enter the name of the string you want replaced!");
			String new_string=JOptionPane.showInputDialog("Please enter the name of the new string!");
			modifyFile(name_of_txt+".txt", old_string, new_string);
			
        }
        else {System.out.println("The file: "+f+" does not exist!");}
    }

}

