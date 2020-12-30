package cities_roads;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import java.util.*;  

public class show_file_contents {
	public static void main(String[] args) throws IOException{
	String filePath=JOptionPane.showInputDialog("Please enter the name of the file you want to examine!");
	// check if it exists	
	File f = new File(filePath+".txt");
	if (f.exists()) {
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath+".txt"))) {
	    	for (String line; (line = br.readLine()) != null;) {
	            System.out.println(line);
	        }
	        br.close();
	    } catch (IOException e) {e.printStackTrace();}
	}
	else {
	    System.out.println("The file : "+filePath+".txt"+" doesn't exist!");
	}
	
	}
	
	static double[] show_city_contents() {
		double latitude=0.0;
		double longitude=0.0;
		String file_name=JOptionPane.showInputDialog("Please enter the name of the file in which the city lies!");
        String inputfile = file_name+".txt";
        File f = new File(inputfile);
        if(f.exists() && !f.isDirectory()) { 
			System.out.println("The file: "+f+" exists!");
			String city_name=JOptionPane.showInputDialog("Please enter the name of the city!");
			
			try {
				Scanner sc = new Scanner(f);
				//current_line=getLine(150, f);
				int lineNum = 0;
				while(sc.hasNext()){
					String currLine = sc.nextLine();
					lineNum++;
			          if(currLine.equals(city_name)) {
			        	  latitude=Double.parseDouble(sc.nextLine());
			        	  longitude=Double.parseDouble(sc.nextLine());
			        	  System.out.println("You have selected: "+city_name);
			        	  System.out.println("The latitude is  : "+latitude);
						  System.out.println("The longitude is : "+longitude);
			        	  break;
			          }
			        }
			        sc.close();
			    //System.out.println("The latitude is  : "+latitude+" !");
			    //System.out.println("The longitude is : "+longitude+" !");
        	}catch (IOException e) {e.printStackTrace();}
        
        }else{System.out.println("The file: "+f+" does not exist!");}
        
	    return new double[] {latitude,longitude};
	}
	
	
	static List<String> show_road_contents() {
		String start_city = null;
		String dest_city= null;
		double km=0.0;
		double time=0.0;
		String file_name=JOptionPane.showInputDialog("Please enter the name of the file in which the roads lies!");
        String inputfile = file_name+".txt";
        File f = new File(inputfile);
        if(f.exists() && !f.isDirectory()) { 
			System.out.println("The file: "+f+" exists!");
			String road_name=JOptionPane.showInputDialog("Please enter the name of the road!");
			
			try {
				Scanner sc = new Scanner(f);
				//current_line=getLine(150, f);
				int lineNum = 0;
				while(sc.hasNext()){
					String currLine = sc.nextLine();
					lineNum++;
			          if(currLine.equals(road_name)) {
			        	  start_city=(sc.nextLine());
			        	  dest_city=(sc.nextLine());
			        	  km=Double.parseDouble(sc.nextLine());
			        	  time=Double.parseDouble(sc.nextLine());
			        	  
			        	  System.out.println("You have selected  : "+road_name);
			        	  System.out.println("The starting city is      : "+start_city);
						  System.out.println("The destination city is   : "+dest_city);
						  System.out.println("The road's distance is    : "+km);
						  System.out.println("The duration of travel is : "+time);
						  
			        	  break;
			          }
			        }
			        sc.close();
        	}catch (IOException e) {e.printStackTrace();}
        
        }else{System.out.println("The file: "+f+" does not exist!");}
        String s1=Double.toString(km);
        String s2=Double.toString(time);
        
        List<String> list=new ArrayList<String>();
        list.add(start_city);
        list.add(dest_city);
        list.add(s1);
        list.add(s2);
        
	    return list;
	}
	
	
	
	
}
