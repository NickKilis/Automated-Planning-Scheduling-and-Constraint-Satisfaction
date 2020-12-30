package cities_roads;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class select_file {
	private ArrayList<String> list_cities;
	private ArrayList<String> list_roads;
	
	public ArrayList<String> get_cities(){
		return(this.list_cities);
	}
	public ArrayList<String> get_roads(){
		return(this.list_roads);
	}
	
	public void main() { 
			String filePath=JOptionPane.showInputDialog("Please enter the name of the file,from which you want to find a path!");
			// check if it exists
			File f = new File(filePath+".txt");
			//String name = null;
			//String lat= null;
			//String lon= null;
	        if(f.exists() && !f.isDirectory()) { 
				System.out.println("The file: "+f+" exists!");
				ArrayList<String> list_cities = new ArrayList<String>();				
				ArrayList<String> list_roads = new ArrayList<String>();
				
			    try (Scanner s = new Scanner(f))
			    {
			    	//read the first line
					String num_cities=s.nextLine();
					int num_cities_int=Integer.parseInt(num_cities);
					System.out.println("Iterating over "+num_cities_int+" cities...");
					for (int i = 0; i < num_cities_int*3; i++) {
						if (s.hasNext())
							list_cities.add(s.next());	
					}
					//System.out.print("\n"+list_cities);
					
					String num_roads=s.next();		
					int num_roads_int=Integer.parseInt(num_roads);
					System.out.println("\nIterating over "+num_roads_int+" roads...");
					for (int j = 0; j < num_roads_int*5; j++) {
						if (s.hasNext())
							list_roads.add(s.next());
					}
					//System.out.print("\n"+list_roads);
				    s.close();
				    
				    this.list_cities=list_cities;
				    this.list_roads=list_roads;

				      
			    } catch (IOException e) {
			        e.printStackTrace();
			    } 
	    
	        }
	        
			
	}
}
