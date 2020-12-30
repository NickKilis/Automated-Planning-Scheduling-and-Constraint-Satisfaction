package cities_roads;
import java.io.FileWriter; 		// write to a file
import java.io.IOException;		// it could be cases where the filewriting doesn't work
import java.io.File; 			// write to a file
import java.io.PrintWriter;		// this does the writing out
import javax.swing.JOptionPane; // gets the input from the user


public class create_new_txt {
	public static void main() throws IOException {
		String name_of_txt=JOptionPane.showInputDialog("Please enter the name of the new txt you want to create!");
		String number_of_nodes="";
		int counter=0;
		String name_of_node="";
		String Latitude_of_node="";
		String Longitude_of_node="";
		
		File f = new File(name_of_txt+".txt");
		if(f.exists() && !f.isDirectory()) { 
			System.out.println("The file: "+f+" exists!");
			System.out.println("Please enter a different name!");
		}else {
		
			try {
				FileWriter outFile = new FileWriter(name_of_txt+".txt",false); //false=overwrite,true=append
				PrintWriter out_new =new PrintWriter(outFile);		 // it is directed to a file, the outFile
				number_of_nodes=JOptionPane.showInputDialog("Please enter the number of new nodes you will add.");
				out_new.println(number_of_nodes);
				do {
					name_of_node=JOptionPane.showInputDialog("Please enter the name of the new node. Leave blank to stop!");
					
					if(!name_of_node.isEmpty()) {
						
						Latitude_of_node=JOptionPane.showInputDialog("Please enter the latitude of the new node.");
						Longitude_of_node=JOptionPane.showInputDialog("Please enter the longitude of the new node.");
						//out_new.println(number_of_nodes+"\n"+name_of_node+"\n"+Latitude_of_node+"\n"+Longitude_of_node);
						
						out_new.println(properCase(name_of_node));
						out_new.println(Latitude_of_node);
						out_new.println(Longitude_of_node);
						counter+=1;
						}
	
				//}while(!name_of_node.isEmpty());
				}while(counter<Integer.parseInt(number_of_nodes));
				//number_of_nodes=Integer.toString(counter);
				//out_new.println(number_of_nodes);
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
