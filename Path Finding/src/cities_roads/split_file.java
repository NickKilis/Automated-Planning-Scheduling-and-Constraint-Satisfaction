package cities_roads;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import javax.swing.JOptionPane; 
import java.util.Scanner; 
import java.io.File; 		
import java.io.FileInputStream;
import java.io.IOException;	
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class split_file {
	public static void main() throws IOException {
        try {
        	String file_name=JOptionPane.showInputDialog("Please enter the name of the txt you want to split into two!");
        	// read file and get no. of files to be generated
            String inputfile = file_name+".txt";
            
            File f1 = new File(file_name+"_1"+".txt");
            File f2 = new File(file_name+"_2"+".txt");
            if(f1.exists() && !f1.isDirectory()) { 
    			System.out.println("The file: "+f1+" exists!");
    			System.out.println("Please enter a different name!");
            }else if(f2.exists() && !f2.isDirectory()) { 
    			System.out.println("The file: "+f2+" exists!");
    			System.out.println("Please enter a different name!");
    		}else {
	            String line0 = Files.readAllLines(Paths.get(inputfile)).get(0);
	            // No. of lines to be split and saved in each
	            //double nol = 2.0;
	            double nol =Integer.parseInt(line0)*3+1;
	            		
	            // display no. of lines to be split.
	            System.out.println("The split will occur in line: " +(int) nol);
	            
	            File file = new File(inputfile);
	            Scanner sc = new Scanner(file);
	            
	            int count = 0;
	            while (sc.hasNextLine()) {
	                sc.nextLine();
	                count++;
	            }
	            sc.close();
	            // display no. of lines in the input file.
	            System.out.println("No. of lines in the file: " + count);
	            
	            //uncomment if you want to split the txt in equal parts of nol
	            /*double temp = (count / nol);
	            int temp1 = (int) temp;
	            int nof = 0;
	            if (temp1 == temp) {
	                nof = temp1;
	            } else {
	                nof = temp1 + 1;
	            }*/
	            int nof=2;//comment if you want to split the txt in equal parts of nol
	            System.out.println("No. of files to be generated: " + nof);
	
	            // splitting of file into multiple files
	            FileInputStream fstream = new FileInputStream(inputfile);
	            DataInputStream in = new DataInputStream(fstream);
	
	            BufferedReader br = new BufferedReader(new InputStreamReader(in));
	            String strLine;
	
	            for (int j = 1; j <= nof; j++) {
	
	                // location of new file
	                FileWriter fstream1 = new FileWriter(file_name+"_"+j+".txt");
	                BufferedWriter out = new BufferedWriter(fstream1);
	                for (int i = 1; i <= nol; i++) {
	                    strLine = br.readLine();
	                    if (strLine != null) {
	                        out.write(strLine);
	                        if (i != nol) {
	                            out.newLine();
	                        }
	                    }
	                }
	                out.close();
	            }
	
	            in.close();
    		}
        } catch (Exception e) {System.err.println("Error: " + e.getMessage());}
        
    } 
	
}