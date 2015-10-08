// @author : Satyam Kumar - 2014096
// @author : Anshuman Suri - 2014021
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.opencsv.CSVReader;

public class csvReader {

	BufferedReader br;
	Model model = new Model();
	Personal p = new Personal();
	Education e = new Education();
	
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
	int aloo(String str, int col)
	{
		if(col == 5)
		{
			if(str.equals("Computer Science")) return 1;
			else if(str.equals("Electronics and Communication")) return 2;
			else if(str.equals("Computational Biology")) return 3;
		}
		else if(col == 9)
		{
			if(str.equals("Female")) return 1;
			else if(str.equals("Male")) return 0;
		}
		else if(col == 11 || col == 13 || col == 32 || col == 37 || col == 46 || col == 52)
		{
			if(str.equals("Yes")) return 1;
			else return 0;
		}
		return -1;
	}
	@SuppressWarnings("deprecation")
	public void process() 
	{
		try {
			CSVReader reader = new CSVReader(new FileReader("Data_to_Import.csv"));
			List<String[]> myEntries = reader.readAll();
			reader.close();
			for(int i = 1; i < myEntries.size(); i++) 
			{
				String[] l = myEntries.get(i);
				p.setEmail(l[0]);
				p.setName(l[1]);
				p.setAdd_correspondence(l[2]);
				p.setMobile(l[3]);
				p.setPhd_stream(aloo(l[4], 5));
				String temp[] = {l[5], l[6], l[7]};
				p.setPreference(temp);
				p.setGender(aloo(l[8], 9) == 1);
				p.setCategory(l[9]);
				p.setPhysically_disabled(aloo(l[10], 11) == 1);
				temp = l[11].split("[-/]+");
				if(temp.length >= 3) { 
					p.setDate_of_birth(new Date(Integer.parseInt(temp[2]), 
							Integer.parseInt(temp[1]),
							Integer.parseInt(temp[0])).toLocalDate());
				}
				p.setWar_category(aloo(l[12], 13) == 1);
				p.setFather_name(l[13]);
				p.setNationality(l[14]);
				p.setAdd_permanent(l[15]);
				p.setPincode(l[16]);
				e.setX_board(l[17]);
				e.setX_marks(Float.parseFloat(l[18]));
				e.setX_year(Integer.parseInt(l[19]));
				e.setXii_board(l[20]);
				e.setXii_marks(Float.parseFloat(l[21]));
				e.setXii_year(Integer.parseInt(l[22]));
				e.setDegree(l[23].split("[.]+")[0] + l[23].split("[.]+")[1]);
				e.setDepartment(l[24]);
				e.setCollege(l[25]);
				e.setUniversity(l[26]);
				e.setCity(l[27]);
				e.setState(l[28]);
				e.setGraduation_year(Integer.parseInt(l[29]));
				if(l[30].contains("Marks")) {
					e.setGraduation_marks(Float.parseFloat(l[30].split("[:]+")[1]));
					e.setType(2);
				}
				else {
					e.setGraduation_marks(Float.parseFloat(l[30].split("[:]+")[1]));
					e.setType(1);
					e.setDrop(true);
				}
				e.setEce_phd(aloo(l[31], 32) == 1);
				e.setPost_graduate(aloo(l[36],37) == 1);
				e.setGiven_gate(aloo(l[51],52) ==1 );
				e.setOther_degree(aloo(l[45],46) == 1);
				model.setEnrollment_number(l[59].substring(3)); //'PHD' not part of enrollment number
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd kk:mm:ss");
				model.setTimestamp(LocalDate.parse(l[58],formatter));				
				e.setAchievements(l[57]);
				if(aloo(l[51],52)==1)
				{
					Gate gogo=new Gate();
					gogo.setRank(Integer.parseInt(l[56]));
					gogo.setScore(Float.parseFloat(l[55]));
					gogo.setMarks(Float.parseFloat(l[54]));
					gogo.setYear(Integer.parseInt(l[53]));
					gogo.setArea(l[52]);
					e.setG(gogo);
				}
				if(aloo(l[45],46)==1)
				{
					Other_Degree gogo=new Other_Degree();
					gogo.setExam_name(l[46]);
					gogo.setSubject(l[47]);
					gogo.setYear(Integer.parseInt(l[48]));
					gogo.setScore(Integer.parseInt(l[49]));
					gogo.setRank(Integer.parseInt(l[50]));
					e.setOD(gogo);
				}
				if(aloo(l[36],37)==1)
				{
					Post_Graduate gogo=new Post_Graduate();
					gogo.setDegree(l[37].split("[.]+")[0] + l[37].split("[.]+")[1]);
					gogo.setDepartment(l[38]);
					gogo.setCollege(l[39]);
					gogo.setTitle(l[40]);
					gogo.setCity(l[41]);
					gogo.setState(l[42]);
					gogo.setYear(Integer.parseInt(l[43]));
					if(l[44].length()>0)
					{
						if(l[44].substring(0,4).equals("CGPA"))
						{
							gogo.setMarks(Float.parseFloat(l[44].substring(5)));
							gogo.setType(1);
							gogo.setDrop(true); //Discussion said CGPA out of 10
						}
						else if(l[44].substring(0,5).equals("Marks"))
						{
							gogo.setMarks(Float.parseFloat(l[44].substring(6)));
							gogo.setType(2);
						}
					}
					e.setPG(gogo);
				}
				if(aloo(l[31],32)==1)
				{
					ECE gogo=new ECE();
					String[] tmp={l[32],l[33],l[34],l[35]};
					gogo.setPreferences(tmp);
					e.setE(gogo);
				}
				model.setP(p);
				model.setE(e);
				this.closer(); //Save file in our desired format
			}
		}
		catch(IOException ex) {
			System.out.println("Wrong File!");
		}
	}

	public String closer()
	{
		BufferedReader enrI=null;
		BufferedWriter enrO=null;
		try {
			//No enrollment number file required in this case :
//			try
//			{
//				enrI=new BufferedReader(new FileReader("enrol.txt"));
//				int yoda=Integer.parseInt(enrI.readLine());
//				yoda+=1;
//				this.model.setEnrollment_number(String.valueOf(yoda));
//				enrI.close();
//				enrO=new BufferedWriter(new FileWriter("enrol.txt"));
//				enrO.write(String.valueOf(yoda));
//				enrO.close();
//			}
//			catch(Exception e)
//			{
//				enrO=new BufferedWriter(new FileWriter("enrol.txt"));
//				enrO.write("1");
//				enrO.close();
//				this.model.setEnrollment_number("1");
//			}
			//				this.model.setEnrollment_number("PotatoLAND");
			String enrl=this.model.getEnrollment_number();
			System.out.println("Your Enrollment number :"+ enrl);
			File dir = new File("UserFiles");
			if (!dir.exists()) {
				if (dir.mkdir()) {
					System.out.println("Directory is created! (one time)");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			File dir2 = new File("UserFiles"+File.separator+enrl);
			if (!dir2.exists()) {
				if (dir2.mkdir()) {
					System.out.println("Directory for user is created! (one time)");
				} else {
					System.out.println("Failed to create directory for user!");
				}
			}
			ObjectOutputStream temp=new ObjectOutputStream(new FileOutputStream("UserFiles"+File.separator+enrl+File.separator+enrl+".dat"));
			File tempcv=new File("tempCV.pdf");
			File realcv=new File("UserFiles"+File.separator+enrl+File.separator+enrl+"_CV.pdf");
			File tempsop=new File("tempSOP.pdf");
			File realsop=new File("UserFiles"+File.separator+enrl+File.separator+enrl+"_SOP.pdf");
			tempcv.renameTo(realcv);
			tempsop.renameTo(realsop);
//			this.model.setTimestamp(LocalDate.now());
			temp.writeObject(this.model);
			if(this.model.getP()==null) System.out.println("F*CK");
			if(this.model==null) System.out.println("Double F*CK");
			temp.close();
			TXT_Record_Maker();
			//Delete temporary .dat file : //Timestamp present in data
			boolean flux=new File("temp.dat").delete();
			if(flux)
			{
				System.out.println("Succcessfully deleted temp.dat file");
			}
			boolean flux2=tempcv.delete();
			if(flux2)
			{
				System.out.println("Succcessfully deleted temp_CV.dat file");
			}
			boolean flux3=tempsop.delete();
			if(flux3)
			{
				System.out.println("Succcessfully deleted temp_SOP.dat file");
			}
		} catch (IOException e) {
			System.out.println("Could not write to file");
			e.printStackTrace();
		}
		return this.model.getEnrollment_number();
	}
	
	private void TXT_Record_Maker()
	{
		BufferedWriter nada= null;
		try
		{
			nada=new BufferedWriter(new FileWriter("UserFiles"+File.separator+this.model.getEnrollment_number()+File.separator+this.model.getEnrollment_number()+".txt"));
			Personal x=this.model.getP();
			Education y=this.model.getE();
			String yolo;
			nada.write("Enrollment Number : "+this.model.getEnrollment_number()+"\n");
			nada.write("Timestamp : "+this.model.getTimestamp()+"\n\n");
			nada.write("PERSONAL DETAILS:\n");
			nada.write("Email : "+x.getEmail()+"\n");
			nada.write("Name : "+x.getName()+"\n");
			nada.write("Address of Correspondence : "+x.getAdd_correspondence()+"\n");
			nada.write("Mobile : "+x.getMobile()+"\n");
			if(x.getPhd_stream()==1) yolo="Computer Science";
			else if(x.getPhd_stream()==2) yolo="Electronics and Communication";
			else yolo="Computational Biology";
			nada.write("PhD Stream : "+yolo+"\n");
			nada.write("PhD Preference 1 : "+x.getPreference()[0]+"\n");
			nada.write("PhD Preference 2 : "+x.getPreference()[1]+"\n");
			nada.write("PhD Preference 3 : "+x.getPreference()[2]+"\n");
			if(x.getGender()) yolo="Female";
			else yolo="Male";
			nada.write("Gender : "+yolo+"\n");
			nada.write("Category : "+x.getCategory()+"\n");
			if(x.getPhysically_disabled()) yolo="Yes";
			else yolo="No";
			nada.write("Physically Disabled : "+yolo+"\n");
			nada.write("Date of Birth : "+x.getDate_of_birth().toString()+"\n");
			if(x.getWar_category()) yolo="Yes";
			else yolo="No";
			nada.write("Children/War Widows of Defence Personnel wounded/killed in war : "+yolo+"\n");
			nada.write("Father's Name : "+x.getFather_name()+"\n");
			nada.write("Nationality : "+x.getNationality()+"\n");
			nada.write("Permanent Address : "+x.getAdd_permanent()+"\n");
			nada.write("Pincode : "+x.getPincode()+"\n");
			nada.write("\n");
			nada.write("SCHOOLING DETAILS:\n");
			nada.write("Xth Board : "+y.getX_board()+"\n");
			nada.write("Xth Marks : "+y.getX_marks()+"\n");
			nada.write("Year of Passing Xth : "+y.getX_year()+"\n");
			nada.write("XIIth Board : "+y.getXii_board()+"\n");
			nada.write("XIIth Marks : "+y.getXii_marks()+"\n");
			nada.write("Year of Passing XIIth : "+y.getXii_year()+"\n");
			nada.write("\n");
			nada.write("GRADUATION DETAILS:\n");
			nada.write("Degree : "+y.getDegree()+"\n");
			nada.write("Department/Discipline : "+y.getDepartment()+"\n");
			nada.write("College : "+y.getCollege()+"\n");
			nada.write("University : "+y.getUniversity()+"\n");
			nada.write("City : "+y.getCity()+"\n");
			nada.write("State : "+y.getState()+"\n");
			nada.write("Year of Graduation : "+y.getGraduation_year()+"\n");
			if(y.isType()==1){
				if(y.isDrop()) yolo="10";
				else yolo="4";
				nada.write("CGPA : "+y.getGraduation_marks()+"/"+yolo+"\n");
			}
			else if(y.isType()==2)
			{
				nada.write("Marks : "+y.getGraduation_marks()+"%\n");
			}
			nada.write("\n");
			if(y.getEce_phd())
			{
				nada.write("ECE PhD\n");
				nada.write("Preference 1 : "+y.getE().getPreferences()[0]+"\n");
				nada.write("Preference 2 : "+y.getE().getPreferences()[1]+"\n");
				nada.write("Preference 3 : "+y.getE().getPreferences()[2]+"\n");
				nada.write("Preference 4 : "+y.getE().getPreferences()[3]+"\n");
				nada.write("\n");
			}
			if(y.getPost_graduate())
			{
				nada.write("POST GRADUATION\n");
				nada.write("College : "+y.getPG().getCollege()+"\n");
				nada.write("City : "+y.getPG().getCity()+"\n");
				nada.write("State : "+y.getPG().getState()+"\n");
				nada.write("Department/Discipline : "+y.getPG().getDepartment()+"\n");
				nada.write("Thesis title : "+y.getPG().getTitle()+"\n");
				nada.write("Year of Post-Graduation : "+y.getPG().getYear()+"\n");
				if(y.getPG().isType()==1){
					if(y.getPG().isDrop()) yolo="10";
					else yolo="4";
					nada.write("CGPA : "+y.getPG().getMarks()+"/"+yolo+"\n");
				}
				else if(y.getPG().isType()==2)
				{
					nada.write("Marks : "+y.getPG().getMarks()+"%\n");
				}
				nada.write("\n");
			}
			if(y.getOther_degree())
			{
				nada.write("OTHER DEGREE\n");
				nada.write("Exam Name : "+y.getOD().getExam_name()+"\n");
				nada.write("Subject : "+y.getOD().getSubject()+"\n");
				nada.write("Year : "+y.getOD().getYear()+"\n");
				nada.write("Score : "+y.getOD().getScore()+"\n");
				nada.write("Rank : "+y.getOD().getRank()+"\n");
				nada.write("\n");
			}
			if(y.getGiven_gate())
			{
				nada.write("GATE\n");
				nada.write("Area : "+y.getG().getArea()+"\n");
				nada.write("Year : "+y.getG().getYear()+"\n");
				nada.write("Marks : "+y.getG().getMarks()+"/100\n");
				nada.write("Score : "+y.getG().getScore()+"\n");
				nada.write("Rank : "+y.getG().getRank()+"\n");
				nada.write("\n");
			}
			nada.write("Achievements :"+y.getAchievements()+"\n");
			nada.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Could not make .txt file");
		}
	}
	
	public static void main(String[] args) {
		csvReader ex = new csvReader();
	}
}
