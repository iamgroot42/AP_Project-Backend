package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csvReader {

		BufferedReader br;
		csvReader() {
			try {
				br = new BufferedReader(new FileReader("Data_to_Import.csv"));
				process();
				br.close();
			}
			catch(IOException ex) {
				System.out.println("Wrong File!");
			}
		}
		public void process() 
		{
			try {
				String in;
				while((in = br.readLine()) != null)
				{
					System.out.println(in);
					//String[] temp = in.split(",");
					//if(!listing.containsKey(temp[0])) listing.put(temp[0], new HashSet<String>());
					//listing.get(temp[0]).add(temp[1]);
				}
			}
			catch(IOException ex) {
				System.out.println("Wrong File!");
			}
		}
}
