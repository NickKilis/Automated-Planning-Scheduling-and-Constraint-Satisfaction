package cities_roads;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class edit_cities {
	
	private static Scanner x;
	public static void main(String[] args) throws IOException{
		String filePath=JOptionPane.showInputDialog("Please enter the name of the file with cities you want to edit!");
		// check if it exists
		File f = new File(filePath+".txt");
		
        if(f.exists() && !f.isDirectory()) { 
			System.out.println("The file: "+f+" exists!");
			String filepath=filePath+".txt";
			String old_city=JOptionPane.showInputDialog("Please enter the name of the old city!");
			
			// check if properCase(old_city) and old_latitude and old_longitude exist
			final Scanner y= new Scanner(f);
			y.nextLine();
			while (y.hasNextLine()) {
				final String row = y.nextLine();
					if(row.contains(old_city)) { 
			        // a match!
			        System.out.println("I found " +old_city+ " in file " +f.getName());
			        
			        String old_latitude=JOptionPane.showInputDialog("Please enter the value of the old latitude!");
			        final Scanner y2= new Scanner(f);
					y2.nextLine();
					while (y2.hasNextLine()) {
						final String row2 = y2.nextLine();
							if(row2.contains(old_latitude)) { 
								// a match!
						        System.out.println("I found " +old_latitude+ " in file " +f.getName());
						        String old_longitude=JOptionPane.showInputDialog("Please enter the value of the old longitude!");
						        final Scanner y3= new Scanner(f);
								y3.nextLine();
								while (y3.hasNextLine()) {
									final String row3 = y3.nextLine();
										if(row3.contains(old_longitude)) { 
											// a match!
									        System.out.println("I found " +old_longitude+ " in file " +f.getName());
									        break;
										}//else {System.out.println("I did not find " +old_longitude+ " in file " +f.getName());}
								}
								
								String new_city=JOptionPane.showInputDialog("Please enter the name of the new city!");
								String new_latitude=JOptionPane.showInputDialog("Please enter the value of the new latitude!");
								String new_longitude=JOptionPane.showInputDialog("Please enter the value of the new longitude!");
								editRecord(filepath,properCase(old_city),old_latitude,old_longitude,properCase(new_city),new_latitude,new_longitude);
								y3.close();
								break;
							}//else {System.out.println("I did not find " +old_latitude+ " in file " +f.getName());}
					}y2.close();
					
			        
				    }//else {System.out.println("I did not find " +old_city+ " in file " +f.getName());}
				}y.close();
				
				
				/*
	            //if(!row.equals(properCase(old_city))) { //correct the first letter if the user typed it in lower case
	            if(!row.contains(old_city)) {  			//the user has to write the name of city exactly as is was in the file
	            	System.out.println("The name of old city you asked does not exist!");
	            	break;
	            }else if(!row.contains(old_latitude)){
	            	System.out.println("The value of old latitude you asked does not exist!");
	            	break;
	            }else if (!row.contains(old_longitude)) {
	            	System.out.println("The value of old longitude you asked does not exist!");
	            	break;
	            }else {
	            	String new_city=JOptionPane.showInputDialog("Please enter the name of the new city!");
	    			String new_latitude=JOptionPane.showInputDialog("Please enter the value of the new latitude!");
	    			String new_longitude=JOptionPane.showInputDialog("Please enter the value of the new longitude!");
	    			
	    			editRecord(filepath,properCase(old_city),old_latitude,old_longitude,properCase(new_city),new_latitude,new_longitude);
	            }
	            }*/
	            
			
			
        }
	}
	
	public static void editRecord(String filepath,String old_city,String old_latitude,String old_longitude,String new_city,String new_latitude,String new_longitude) {
		String tempFile ="temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x= new Scanner(new File(filepath));
			x.useDelimiter("\n");
			pw.println(x.nextLine());//this would read the first line from the text file
			
			while(x.hasNext()) {
				String row=x.nextLine();
				if(row.equals(old_city) && !(old_city.equals(new_city))) {
					//pw.println(new_city+"\n"+new_latitude+"\n"+new_longitude);
					pw.println(new_city);
				}
				else if(row.equals(old_latitude)&& !(old_latitude.equals(new_latitude))) {
					pw.println(new_latitude);
				}
				else if(row.equals(old_longitude)&& !(old_longitude.equals(new_longitude))) {
					pw.println(new_longitude);
				}else {
					pw.println(row);
				}
				
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		}catch(Exception e){System.err.println("Error: " + e.getMessage());}
		
		
	}
	//return strings separated with space with their first letter in upper case
	private static String properCase(String in) {
		String out="";
		String[] word=in.split(" ");
		for(int i =0; i<word.length;i++) {
			out+=word[i].substring(0,1).toUpperCase() + word[i].substring(1).toLowerCase()+" "; //if there are 2 strings or more into the name
		}
		return out.trim();// removing the last space, avoiding the if statement
	}
	
}
