package cities_roads;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class latitude_longitude{
	/**
	 * Calculate distance between two points in latitude and longitude taking into account height difference. 
	 * Uses Haversine method as it's base.
	 * @param lat1 latitude of first city
	 * @param lat2 latitude of second city
	 * @param lon1 longitude of first city
	 * @param lon2 longitude of second city
	 * 
	 * @return integer distance in meters
	 */
	public static int lat_long_to_euclidean(double lat1,double lat2,double lon1,double lon2) {
		final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c ; // convert to kilometers
	    
	    //double height = el1 - el2;
	    double height =0;
	    distance = Math.pow(distance, 2) + Math.pow(height, 2);
	    int result=(int)(Math.round(Math.sqrt(distance)));
	    System.out.println("The straight euclidean distance is : "+result +" (km) !");
	    return result;
	}
	
	public static double[] find_lat_long_within_file() {
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
	
	
	public static String getLine(int line, Scanner input){
		  String result = "";
		  int lineNr = 1;
		  while(input.hasNextLine() && lineNr <= line){
		    result = input.nextLine();
		    lineNr++;
		  }
		  return result;
		}
	
}
