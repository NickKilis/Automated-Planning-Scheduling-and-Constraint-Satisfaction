package cities_roads;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

public class Main {
	/* HOW TO USE:
	 *-------------------------------------------------------FILE MANIPULATION-----------------------------------------------------------------------------------------------------------
	 * 0.create_new_txt
	 * 		The user can create a new file by specifying the number of cities, the number of roads and their characteristics. 
	 * 1.create_new_txt_cities
	 * 		The user can create a new file with cities only by specifying the number of cities and their characteristics[city_name,latitude,longitude].
	 * 2.create_new_txt_roads
	 * 		The user can create a new file with roads only by specifying the number of roads and their characteristics[road_name,city_name1,city_name2,distance(km),duration(min)].
	 * 3.delete_file
	 * 		The user can delete a file, if it already exists. Confirmation before deleting the file is available.
	 * 4.show_file_contents
	 * 		The user can see the contents of the entire file in the console,if the file already exists. Also, showing contents of a specific city or a road is available. 
	 * 5.FileMerge
	 * 		The user can merge 2 existing files into a new file. The 2 initial files are not deleted automatically. The new file must not already exist. 
	 * 6.split_file
	 * 		The user can split 1 existing file, e.g. "a.txt" into "a_1.txt" and "a_2.txt". The 2 new files must not already exist.
	 * 7.replace_string_in_file
	 * 		The user can replace in an existing file a string with another string. The replacement occurs for all strings in the file.
	 * 8.append_to_file
	 * 		The user can add new entries at the end of an existing file and automatically update the total number of entries (it's first line). 
	 * 		A new file is created with the old and new entries. The initial file is not deleted automatically and the new file must not already exist.
	 * 		The use of this class can be analyzed into 4 cases. The user chooses one from them to execute :
	 * 		- Add only 1 city at the end of the file containing cities. 
	 * 		- Add only 1 road at the end of the file containing roads. 
	 * 		- Add multiple cities at the end of the file containing cities. 
	 * 		- Add multiple roads at the end of the file containing roads. 
	 * 9.latitude_longitude
	 * 		This class contains 2 functions. The first returns the euclidean distance between 2 points given their latitude and longitude
	 * 		The second function searches an existing file, finds the name of the city in it and shows its latitude and longitude.(exists in show_file_contents as well)
	 
	 * 		9a.lat_long_to_euclidean
	 * 			This class contains a function, which gets as input the latitude and longitude of 2 cities (double values) and returns the Euclidean distance (int value) between them in km.  
	 * 		9b.find_lat_long_within_file
	 *-------------------------------------------------------PATH FINDING CLASSES---------------------------------------------------------------------------------------------------------
 	 * 10.select_file
 	 * 		The user chooses an existing file and the program checks the validity of it's structure. The file must be in the form :
	 * 		Number of cities
	 * 		city_name1
	 * 	 	latitude1
	 * 		longitude1
	 * 		city_name2
	 * 	 	latitude2
	 * 		longitude2
	 * 		...
	 * 		Number of roads
	 * 		road_name1
	 * 		city_name_start1
	 * 		city_name_destination1
	 * 		distance1(km)
	 * 		duration1(min)
	 * 		road_name2
	 * 		city_name_start2
	 * 		city_name_destination2
	 * 		distance2(km)
	 * 		duration2(min)
	 * 		...
 	 * 11.City
 	 * 12.Road
 	 * 13.Node
 	 * 14.Path
 	 * 15.Astar
 	 * 16.Greedy
 	 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	public static void main(String args[]) throws Exception { 

		System.out.println("0. create a new file");
		System.out.println("1. create a new file with cities only");
		System.out.println("2. create a new file with roads only");
		System.out.println("3. delete a file");
		System.out.println("4. show a file's contents");
		System.out.println("5. merge a file containing cities with a file containing roads");
		System.out.println("6. split a file containing cities and roads");
		System.out.println("7. replace a line in a file");
		System.out.println("8. append to a file");
		System.out.println("9. find latitude and longitude of a city within a file");
		System.out.println("10.select a file for pathfinding");
		System.out.println("11.quit application");

		String choice=JOptionPane.showInputDialog("Please choose one of the 12 actions :\n"
				+ "0. create a new file\n"
				+ "1. create a new file with cities only\n"
				+ "2. create a new file with roads only\n"
				+ "3. delete a file\n"
				+ "4. show a file's contents\n"
				+ "5. merge a file containing cities with a file containing roads\n"
				+ "6. split a file containing cities and roads\n"
				+ "7. replace a line in a file\n"
				+ "8. append to a file\n"
				+ "9. find latitude and longitude of a city within a file\n"
				+ "10.select a file for pathfinding\n"
				+ "11.quit program.");
		
		switch (Integer.parseInt(choice)) {
		  case 0:
		    System.out.println("Your choice : "+"create a new file");
		    try {create_new_txt.main();}catch (IOException e) {e.printStackTrace();}
		    break;
		  case 1:
		    System.out.println("Your choice : "+"create a new file with cities only");
		    try {create_new_txt_cities.main();}catch (IOException e) {e.printStackTrace();}
		    break;
		  case 2:
		    System.out.println("Your choice : "+"create a new file with roads only");
		    try {create_new_txt_roads.main();}catch (IOException e) {e.printStackTrace();}
		    break;
		  case 3:
		    System.out.println("Your choice : "+"delete a file");
			delete_file.main();
		    break;
		  case 4:
		    System.out.println("Your choice : "+"show a file's contents");
		    String choose=JOptionPane.showInputDialog("Are you looking for a city or a road?");
		    if(choose.equals("city")||choose.equals("CITY")) {
				show_file_contents calc3= new show_file_contents();
				double[] result=calc3.show_city_contents();
		    }	
		    else if (choose.equals("road")||choose.equals("ROAD")) {
		    	show_file_contents calc3= new show_file_contents();
		    	List<String> list=calc3.show_road_contents();
		    }
		    break;
		  case 5:
		    System.out.println("Your choice : "+"merge a file containing cities with a file containing roads");
		    try {FileMerge.main();}catch (IOException e) {e.printStackTrace();}
		    break;
		  case 6:
		    System.out.println("Your choice : "+"split a file containing cities and roads");
		    try {split_file.main();}catch (IOException e) {e.printStackTrace();}
		    break;
		  case 7:
		    System.out.println("Your choice : "+"replace a line in a file");
		    try {replace_line_in_file.main();}catch (IOException e) {e.printStackTrace();}
		    break;
		  case 8:
		    System.out.println("Your choice : "+"append to a file");
		    try {append_to_file.main();}catch (IOException e) {e.printStackTrace();}
		    break;
		  case 9:
		    System.out.println("Your choice : "+"find latitude and longitude of a city within a file");
		    /*
			latitude_longitude calc= new latitude_longitude();
			double lat1= 40.7369;
			double lon1= 22.9202;
			
			double lat2= 40.52437;
			double lon2= 22.20242;
			calc.lat_long_to_euclidean(lat1, lat2, lon1, lon2);
			*/
			latitude_longitude calc2= new latitude_longitude();
			calc2.find_lat_long_within_file();
		    break;
		  case 10:
		    System.out.println("Your choice : "+"select a file for pathfinding");
		    select_file k= new select_file();
			k.main();
			ArrayList<String> list_cities=k.get_cities();
			ArrayList<String> list_roads=k.get_roads();
			
			List<Path> ConnectingPath = new ArrayList<Path>();
			List<City> Loc = new ArrayList<City>();
			
			final String ASTAR = "astar";
		    final String GREEDY = "greedy";
		    
		    for(int i = 0; i < list_cities.size(); i=i+3) {
		    	if (i+2>=list_cities.size()) {break;}
		    	Loc.add(new City(list_cities.get(i),Float.parseFloat(list_cities.get(i+1)),Float.parseFloat(list_cities.get(i+2))));
			}
		    System.out.println(Loc.get(1).getCityName());
		    
		    for(int i = 0; i < list_roads.size(); i=i+5) {
		    	if (i+2>=list_roads.size()) {break;}
		    	ConnectingPath.add(new Path(list_roads.get(i),list_roads.get(i+1),list_roads.get(i+2),Double.parseDouble(list_roads.get(i+3)),Double.parseDouble(list_roads.get(i+4))));
			}
		    System.out.println(Loc.get(1).getCityName());
		    System.out.println(ConnectingPath.get(1).getRoadName());
		    
		    String searchType=JOptionPane.showInputDialog("Please choose between ASTAR and GREEDY!");
		    if (searchType.equals("ASTAR") ||searchType.equals("astar")) {
		    	Astar astar =new Astar();
		    	System.out.println("You have selected Astar as the searching method!"); 
		    	String sourceCity=JOptionPane.showInputDialog("Please choose a starting city!");
		    	String destinationCity=JOptionPane.showInputDialog("Please choose a destination city!");
		    	String criterion=JOptionPane.showInputDialog("Please choose between TIME and DISTANCE,for the algorithm to optimize!");
			    astar.astar(sourceCity, destinationCity,ConnectingPath,criterion,Loc);
			    
		    }else if (searchType.equals("GREEDY") ||searchType.equals("greedy")) {
		    	Greedy greedy =new Greedy();
		    	System.out.println("You have selected Best first search as the searching method!");
		    	String sourceCity=JOptionPane.showInputDialog("Please choose a starting city!");
		    	String destinationCity=JOptionPane.showInputDialog("Please choose a destination city!");
		    	String criterion=JOptionPane.showInputDialog("Please choose between TIME and DISTANCE,for the algorithm to optimize!");
	        	greedy.Greedy(sourceCity, destinationCity,ConnectingPath,criterion,Loc);
		    }else {
		    	System.out.println("You have entered an invalid algorithm name!");
		    }
		    
		    break;
		  case 11:
			System.out.println("Your choice : "+"quit"); 
			System.exit(0);
		}
	
    
	}
}
