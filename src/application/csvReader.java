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
		public int aloo(String x,int i)
		{
			if(i==11 || i==13 || i==32 || i==37 || i==52)
			{
				if(x.equals("Yes"))
				{
					return 1;
				}
				else if(x.equals("No"))
				{
					return 0;
				}
			}
			return -1;
		}
}
