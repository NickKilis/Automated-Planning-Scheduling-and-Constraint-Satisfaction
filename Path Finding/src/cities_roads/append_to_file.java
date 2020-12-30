package cities_roads;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class append_to_file {
	public static void main() throws IOException {
		boolean flag=false;
		String file_name=JOptionPane.showInputDialog("Please enter the name of the file you want to append new lines!");
        String inputfile = file_name+".txt";
        // check if file exists
        File f = new File(inputfile);
        if(f.exists() && !f.isDirectory()) { 
			System.out.println("The file: "+f+" exists!");
			/* ask the user to choose between :
			 * 	1. add a city at the bottom of the file with cities, increase the first line number by 1
			 *  2. add a road at the bottom of the file with roads, increase the first line number by 1
			 *  3. add multiple cities at the bottom of the file with cities , increase the first line number by the number of cities added
			 *  4. add multiple roads at the bottom of the file with roads , increase the first line number by the number of roads added
			 */
			String action =JOptionPane.showInputDialog("Please type:\n1 to \"add 1 city\",\n2 to \"add 1 road\",\n3 to \"add multiple cities\",\n4 to \"add multiple roads\".");
			
			if(action.equals("1")){
				System.out.println("You have selected to add a city!");
				String dest_file_name=JOptionPane.showInputDialog("Please enter the name of the destination file!");
				
				// check if destination file exists
		        File f2 = new File(dest_file_name+".txt");
		        if(!f2.exists() && !f2.isDirectory()) { 
					System.out.println("The file: "+f2+" does not exist!");
					String name_of_city=JOptionPane.showInputDialog("Please enter the name of the city you want to add!");
					String latitude_of_city=JOptionPane.showInputDialog("Please enter the value of the latitude!");
					String longitude_of_city=JOptionPane.showInputDialog("Please enter the value of the longitude!");
					Scanner sc = new Scanner(f);
					StringBuffer buffer = new StringBuffer();
					//read the first line
					String first_line=sc.nextLine();
					//increase the first line to +1
					int first_line_int=Integer.parseInt(first_line);
					first_line_int+=1;
			        String new_first_line =String.valueOf(first_line_int);
			        buffer.append(new_first_line);
			        buffer.append(System.getProperty("line.separator"));
					//Reading lines of the file and appending them to StringBuffer
					while (sc.hasNextLine()) {
			        	buffer.append(sc.nextLine()+System.lineSeparator());
					}
					//System.out.println("Contents of the file: "+fileContents);
					//closing the Scanner object
			     	sc.close();  
			     	buffer.append(name_of_city);
			     	buffer.append(System.getProperty("line.separator"));
			     	buffer.append(latitude_of_city);
			     	buffer.append(System.getProperty("line.separator"));
			     	buffer.append(longitude_of_city);
			     	buffer.append(System.getProperty("line.separator"));
			     	String fileContents = buffer.toString();
			     	FileWriter writer = new FileWriter(dest_file_name+".txt");
			        //System.out.println("");
			        //System.out.println("new data: "+fileContents);
			        writer.append(fileContents);
			        writer.close();
		        }else {System.out.println("The destistination file :" +dest_file_name+".txt" + "exists! Please enter a different name!");}
				
			}else if(action.equals("2")){
				System.out.println("You have selected to add a road!");
				//check if road already exists in txt file
				//increase the first line to +1
				String dest_file_name=JOptionPane.showInputDialog("Please enter the name of the destination file!");
				// check if destination file exists
		        File f2 = new File(dest_file_name+".txt");
		        if(!f2.exists() && !f2.isDirectory()) { 
					System.out.println("The file: "+f2+" does not exist!");
					String name_of_road=JOptionPane.showInputDialog("Please enter the name of the road you want to add!");
					String first_city=JOptionPane.showInputDialog("Please enter the name of the first city!");
					String second_city=JOptionPane.showInputDialog("Please enter the name of the second city!");
					String distance_km=JOptionPane.showInputDialog("Please enter the value of the distance (km)!");
					String duration_min=JOptionPane.showInputDialog("Please enter the value of duration (min)!");
					Scanner sc = new Scanner(f);
					StringBuffer buffer = new StringBuffer();
					//read the first line
					String first_line=sc.nextLine();
					//increase the first line to +1
					int first_line_int=Integer.parseInt(first_line);
					first_line_int+=1;
			        String new_first_line =String.valueOf(first_line_int);
			        buffer.append(new_first_line);
			        buffer.append(System.getProperty("line.separator"));
					//Reading lines of the file and appending them to StringBuffer
					while (sc.hasNextLine()) {
			        	buffer.append(sc.nextLine()+System.lineSeparator());
					}
					//System.out.println("Contents of the file: "+fileContents);
					//closing the Scanner object
			     	sc.close();  
			     	buffer.append(name_of_road);
			     	buffer.append(System.getProperty("line.separator"));
			     	buffer.append(first_city);
			     	buffer.append(System.getProperty("line.separator"));
			     	buffer.append(second_city);
			     	buffer.append(System.getProperty("line.separator"));
			     	buffer.append(distance_km);
			     	buffer.append(System.getProperty("line.separator"));
			     	buffer.append(duration_min);
			     	buffer.append(System.getProperty("line.separator"));
			     	String fileContents = buffer.toString();
			     	FileWriter writer = new FileWriter(dest_file_name+".txt");
			        //System.out.println("");
			        //System.out.println("new data: "+fileContents);
			        writer.append(fileContents);
			        writer.close();
		        }else {System.out.println("The destistination file :" +dest_file_name+".txt" + "exists! Please enter a different name!");}

			}else if(action.equals("3")){
				System.out.println("You have selected to add multiple cities!");
				//ask how many will he add
				String number_of_cities=JOptionPane.showInputDialog("Please enter the number of cities to be added!");
				int number_of_cities_int=Integer.parseInt(number_of_cities);

				Scanner sc = new Scanner(f);
				//StringBuffer buffer = new StringBuffer();
				StringBuilder  buffer = new StringBuilder();
				//read the first line
				String first_line=sc.nextLine();
				//increase the first line to +1
				int first_line_int=Integer.parseInt(first_line);
				//find the total number of cities and append it to the buffer's first line
				first_line_int=first_line_int+number_of_cities_int;
		        String new_first_line =String.valueOf(first_line_int);
		        buffer.append(new_first_line);
		        buffer.append(System.getProperty("line.separator"));
		        //Reading lines of the file and appending them to StringBuffer
				while (sc.hasNextLine()) {
		        	buffer.append(sc.nextLine()+System.lineSeparator());
				}
				//System.out.println("Contents of the file: "+fileContents);
				//closing the Scanner object
		     	sc.close();  
		        String dest_file_name=JOptionPane.showInputDialog("Please enter the name of the destination file!");
		        // check if destination file exists
		        File f2 = new File(dest_file_name+".txt");
		        if(!f2.exists() && !f2.isDirectory()) { 
					System.out.println("The file: "+f2+" does not exist!");
					for(int i = 0; i < number_of_cities_int; i++) {
						String name_of_city=JOptionPane.showInputDialog("Please enter the name of the city you want to add!");
						//check if city already exists in txt file 
						if (!buffer.toString().contains(name_of_city)){
							String latitude_of_city=JOptionPane.showInputDialog("Please enter the value of the latitude!");
							String longitude_of_city=JOptionPane.showInputDialog("Please enter the value of the longitude!");
					     	buffer.append(name_of_city);
					     	buffer.append(System.getProperty("line.separator"));
					     	buffer.append(latitude_of_city);
					     	buffer.append(System.getProperty("line.separator"));
					     	buffer.append(longitude_of_city);
					     	buffer.append(System.getProperty("line.separator"));
					     	System.out.println("New entries have been added to : "+dest_file_name+".txt"+" !"); 
						}else {System.out.println("You are trying to add a city that already exists! Please try again with another name!");flag=true;}
					}
					if(flag==false){
				     	String fileContents = buffer.toString();
				     	FileWriter writer = new FileWriter(dest_file_name+".txt");
				        //System.out.println("");
				        //System.out.println("new data: "+fileContents);
				        writer.append(fileContents);
				        writer.close();
					}
		        }else {System.out.println("The destistination file :" +dest_file_name+".txt" + "exists! Please enter a different name!");}
		 
			}else if(action.equals("4")){
				System.out.println("You have selected to add multiple roads!");
				//ask how many will he add
				//check if road already exists in txt file
				//ask how many will he add
				String number_of_roads=JOptionPane.showInputDialog("Please enter the number of roads to be added!");
				int number_of_roads_int=Integer.parseInt(number_of_roads);
				Scanner sc = new Scanner(f);
				//StringBuffer buffer = new StringBuffer();
				StringBuilder  buffer = new StringBuilder();
				//read the first line
				String first_line=sc.nextLine();
				//increase the first line to +1
				int first_line_int=Integer.parseInt(first_line);
				//find the total number of cities and append it to the buffer's first line
				first_line_int=first_line_int+number_of_roads_int;
		        String new_first_line =String.valueOf(first_line_int);
		        buffer.append(new_first_line);
		        buffer.append(System.getProperty("line.separator"));
		        //Reading lines of the file and appending them to StringBuffer
				while (sc.hasNextLine()) {
		        	buffer.append(sc.nextLine()+System.lineSeparator());
				}
				//System.out.println("Contents of the file: "+fileContents);
				//closing the Scanner object
		     	sc.close();  
		        String dest_file_name=JOptionPane.showInputDialog("Please enter the name of the destination file!");
		        // check if destination file exists
		        File f2 = new File(dest_file_name+".txt");
		        if(!f2.exists() && !f2.isDirectory()) { 
					System.out.println("The file: "+f2+" does not exist!");
					for(int i = 0; i < number_of_roads_int; i++) {
						String name_of_road=JOptionPane.showInputDialog("Please enter the name of the road you want to add!");
						//check if road already exists in txt file 
						if (!buffer.toString().contains(name_of_road)){
							String first_city=JOptionPane.showInputDialog("Please enter the name of the first city!");
							String second_city=JOptionPane.showInputDialog("Please enter the name of the second city!");
							String distance_km=JOptionPane.showInputDialog("Please enter the value of distance (km)!");
							String duration_min=JOptionPane.showInputDialog("Please enter the value of duration_min (min)!");
					     	buffer.append(name_of_road);
					     	buffer.append(System.getProperty("line.separator"));
					     	buffer.append(first_city);
					     	buffer.append(System.getProperty("line.separator"));
					     	buffer.append(second_city);
					     	buffer.append(System.getProperty("line.separator"));
					     	buffer.append(distance_km);
					     	buffer.append(System.getProperty("line.separator"));
					     	buffer.append(duration_min);
					     	buffer.append(System.getProperty("line.separator"));
					     	System.out.println("New entries have been added to : "+dest_file_name+".txt"+" !"); 
						}else {System.out.println("You are trying to add a road that already exists! Please try again with another name!");flag=true;}
						
					}
					if(flag==false){
				     	String fileContents = buffer.toString();
				     	FileWriter writer = new FileWriter(dest_file_name+".txt");
				        //System.out.println("");
				        //System.out.println("new data: "+fileContents);
				        writer.append(fileContents); 
				        writer.close();  
					}
		        }else {System.out.println("The destistination file :" +dest_file_name+".txt" + "exists! Please enter a different name!");}
				
			}else {
				System.out.println("You have selected an invalid action : "+action+".Please enter a number betwee 1 and 4!");
			}
			
			
			/*try(FileWriter fw = new FileWriter(inputfile, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println("the text");
				    out.println("more text");
				    
					out.close();
					System.out.println("New entries have been added!");   
				} catch (Exception e) {System.err.println("Error: " + e.getMessage());}
			*/
			
			
        }
        else {
        	System.out.println("The file: "+f+" does not exist!");
			System.out.println("Please enter a different name!");
        }

	}
}
