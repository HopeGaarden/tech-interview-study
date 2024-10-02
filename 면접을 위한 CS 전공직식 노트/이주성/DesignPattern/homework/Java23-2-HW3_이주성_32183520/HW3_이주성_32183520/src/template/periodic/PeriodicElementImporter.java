package template.periodic;
import template.input.Phase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UnknownFormatConversionException;

public class PeriodicElementImporter {
	
	private PeriodicElementImporter() {}	

	public static PeriodicElement parse(String[] items) {
		try {
			//System.out.println("items : " + Arrays.toString(items));
			int number = Integer.parseInt(items[0]);
            String name = items[1];
            String symbol = items[2];
            double mass = Double.parseDouble(items[3]);
			int period = Integer.parseInt(items[4]);
			int group = items[5].isEmpty() ? -1 : Integer.parseInt(items[5]);
			Phase phase = Phase.valueOf(items[6]);
        	String type = items.length == 7 ? "" : items[7]; 
        	return new PeriodicElement(number, name, symbol, mass, period, group, phase, type);
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException!");
		} catch (UnknownFormatConversionException e) {
			System.out.println("UnknownFormatConversionException!");
		} catch (IllegalArgumentException e) {
			System.out.print("IllegalArgumentException!");
		} 
		return null;
	}
	
	// load CSV
    public static List<PeriodicElement> loadCSV(String filename) {      
    	List<PeriodicElement> list = new ArrayList<PeriodicElement>();
        String line = "";
		
        // load data
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        	System.out.println("file import: " + filename);
            String delimiter = ",";
            while ((line = br.readLine()) != null) {
            	if (line.contains("#")) {
            		System.out.println("line contains #: " + line);
            		continue;
            	}
                // use comma as separator
                String[] items = line.split(delimiter);
                /*for (String i : items) {
                	System.out.println(i);
                }*/
                PeriodicElement pe = parse(items); // String[] items -> PeriodicElement
               	list.add(pe); 
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("load successfully");
		System.out.println();

		return list; 
    }
    
    // save CSV
    public static void saveCSV(String path, List<PeriodicElement> elements) {
    	FileWriter fw;
		try {
            System.out.println("file save: " + path);

			fw = new FileWriter(path);
	        for (var pe : elements) {
				System.out.println(pe);
	            fw.append(pe.toString() + "\n");
	        }
	        fw.flush();
	        fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
