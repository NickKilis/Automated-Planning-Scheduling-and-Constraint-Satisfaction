package cities_roads;
import java.io.FileWriter; 		
import java.io.IOException;		// it could be cases where the filewriting doesn't work
import java.io.File; 			// write to a file
import java.io.PrintWriter;		// this does the writing out
import javax.swing.JOptionPane; // gets the input from the user

public class create_new_txt_roads {
	public static void main() throws IOException {
		String name_of_txt=JOptionPane.showInputDialog("Please enter the name of the new txt you want to create!");
		String number_of_nodes="";
		int counter=0;
		String name_of_node="";
		String first_node="";
		String second_node="";
		String distance_of_nodes="";
		String time_between_nodes="";
		
		File f = new File(name_of_txt+".txt");
		if(f.exists() && !f.isDirectory()) { 
			System.out.println("The file: "+f+" exists!");
			System.out.println("Please enter a different name!");
		}else {
		
			try {
				FileWriter outFile = new FileWriter(name_of_txt+".txt",false); //false=overwrite,true=append
				PrintWriter out_new =new PrintWriter(outFile);		 // it is directed to a file, the outFile
				number_of_nodes=JOptionPane.showInputDialog("Please enter the number of new roads you will add.");
				out_new.println(number_of_nodes);
				do {
					name_of_node=JOptionPane.showInputDialog("Please enter the name of the new road. Leave blank to stop!");
					
					if(!name_of_node.isEmpty()) {
						
						first_node=JOptionPane.showInputDialog("Please enter the first city.");
						second_node=JOptionPane.showInputDialog("Please enter the second city.");
						distance_of_nodes=JOptionPane.showInputDialog("Please enter the distance (km).");
						time_between_nodes=JOptionPane.showInputDialog("Please enter the mean time (min).");

						out_new.println(properCase(name_of_node));
						out_new.println(properCase(first_node));
						out_new.println(properCase(second_node));
						out_new.println(distance_of_nodes);
						out_new.println(time_between_nodes);
						
						counter+=1;
						}
				//}while(!name_of_node.isEmpty());
				}while(counter<Integer.parseInt(number_of_nodes));
				out_new.close();
				
			} catch (IOException e) {e.printStackTrace();}
		}
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
