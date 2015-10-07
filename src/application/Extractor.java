package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.util.Pair;

class MyButton {
	private boolean flag;
	private String field, option;
	public MyButton (String field, String option, boolean flag) {
		this.flag = flag;
		this.field = field;
		this.option = option;
	}
	public MyButton (String field, boolean flag) {
		this.flag = flag;
		this.field = field;
		this.option = "";
	}
	public boolean getFlag() { return flag; }
	public String getField() { return field; }
	public String getOption() { return option; }
}

public class Extractor {
	ArrayList<Pair<Model, String> > data;
	
	public MyButton bX, bXII, bEmail, bName, bENum, bCategory, bGender, bPhyDisabled, bStream, bGradDegree, bPostGradDegree, bDepGrad,
			 bDepPGrad, bUnGrad, bUnPGrad, bGState, bPGState, bXPerc, bXIIPerc, bGradPerc, bPGradXPerc, bGATEPerc, bDOB;
	
	public Extractor(LocalDate lower, LocalDate upper){ data = ReadData(lower, upper); }
	
	private ArrayList<Pair<Model, String> > ReadData(LocalDate lower, LocalDate upper) 
	{
		ObjectInputStream in = null;
		ArrayList<Pair<Model, String> > list = new ArrayList<Pair<Model, String> >();
		try 
		{ 
			File AppFolder = new File("UserFiles");
			File[] ListOfDirectories = AppFolder.listFiles();
			System.out.println(AppFolder.listFiles());
			for(File Dir : ListOfDirectories)
			{
				if(Dir.isDirectory())
				{
					System.out.println(Dir);
					File[] ListOfFiles = Dir.listFiles();
					for(File f : ListOfFiles)
					{
						
						String str = f.getAbsolutePath();
						if(str.endsWith(".dat"))
						{
							System.out.println(str);
							in = new ObjectInputStream(new FileInputStream(str));
							Model temp;
							try{
								temp = (Model)in.readObject();
								if(temp.getTimestamp().compareTo(lower)>=0 && temp.getTimestamp().compareTo(upper)<=0) 
									list.add(new Pair<Model, String>(temp, str.replace(".dat", ".txt")));
							}
							catch(ClassNotFoundException ex) { }
							catch(IOException ex) {System.out.println("1 Look this, No Database!");}
						}
					}
					System.out.println("------------------");
				}
			}
		}
		catch(Exception ex) { System.out.println("1here No Database!"); }
		finally 
		{ 
			try { if(in != null) in.close(); }
			catch(IOException ex) { System.out.println("2here No Database!"); }
		}
		return list;
	}
	
	private boolean check_button(MyButton b, String str, int mode)
	{
		if(mode == 1)
			{if(b.getFlag() && !b.getField().equals("all") && !b.getField().equals(str.toLowerCase())) return false;}
		else
			{if(b.getFlag() && !b.getField().equals(str.toLowerCase())) return false;}
		return true;
	}
	
	private boolean check_button(MyButton b, Double Perc)
	{
		if(b.getFlag() && !b.getOption().equals(""))
		{
			String option = b.getOption();
			int res = Perc.compareTo(Double.parseDouble(b.getField()));
			if(option.equals("Equals") && res != 0) return false;
			if(option.equals("Greater") && res <= 0) return false;
			if(option.equals("Lesser") && res >= 0) return false;
			if(option.equals("GreaterEquals") && res < 0) return false;
			if(option.equals("LesserEquals") && res > 0) return false;
		}
		return true;
	}
	
	private boolean check(Model ob){ return checkPI(ob) && checkEI(ob); }
	private String changegender(boolean i)
	{
		if(i) return "Female";
		else return "Male";
	}
	private String changedis(boolean i)
	{
		if(i) return "Yes";
		else return "No";
	}
	private boolean checkPI(Model ob)
	{
		boolean flag = true;
		flag &= check_button(bEmail, ob.getP().getEmail(), 0);
		flag &= check_button(bName, ob.getP().getName(), 0);
		flag &= check_button(bENum, ob.getEnrollment_number(), 0);
		flag &= check_button(bCategory, ob.getP().getCategory(), 1);
		flag &= check_button(bGender, changegender(ob.getP().getGender()), 0);
		flag &= check_button(bPhyDisabled, changedis(ob.getP().getPhysically_disabled()), 0);
		if(bDOB.getFlag())
		{
			LocalDate temp=ob.getP().getDate_of_birth();
			int res = temp.toString().replace("/", "-").replace("\\", "-").compareTo(bDOB.getField().replaceAll("/", "-").replace("\\", "-"));
			String option = bDOB.getOption();
			if(option.equals("On") && res != 0) flag &= false;
			if(option.equals("After") && res <= 0) flag &= false;
			if(option.equals("Before") && res >= 0) flag &= false;
		}
		return flag;
	}
	private String changephd(int i)
	{
		if(i == 1) return "Computer Science";
		else if(i == 2) return "Electronics and Communication";
		else return "Computational Biology";
	}
	private boolean checkEI(Model ob)
	{
		boolean flag = true;
		flag &= check_button(bStream, changephd(ob.getP().getPhd_stream()), 1);
		flag &= check_button(bGradDegree, ob.getE().getDegree(), 1);
		if(ob.getE().getPG() == null && bPGradXPerc.getFlag()) flag &= false;
		else if(ob.getE().getPG() == null && !bPGradXPerc.getFlag()) flag &= true;
		else {
			flag &= check_button(bPostGradDegree, ob.getE().getPG().getDegree(), 1);
			flag &= check_button(bDepPGrad, ob.getE().getPG().getDepartment(), 1);
			flag &= check_button(bUnPGrad, ob.getE().getPG().getCollege(), 1);
			flag &= check_button(bPGState, ob.getE().getPG().getState(), 1);
		}
		flag &= check_button(bX, ob.getE().getX_board(), 1);
		flag &= check_button(bXII, ob.getE().getXii_board(), 1);
		flag &= check_button(bDepGrad, ob.getE().getDepartment(), 1);
		flag &= check_button(bUnGrad, ob.getE().getUniversity(), 1);
		flag &= check_button(bGState, ob.getE().getState() , 1);
		flag &= checkPerc(ob);
		return flag;
	}
	
	private float GetAbsPercEdu(Education e)
	{
		float temp;
		if(e.isType() == 1)
		{
			if(e.isDrop()) temp = 10 * e.getGraduation_marks();
			else temp = 25 * e.getGraduation_marks();
		}
		else temp = e.getGraduation_marks();
		return temp;	
	}

	private float GetAbsPercPostGrad(Post_Graduate p)
	{
		float temp;
		if(p.isType() == 1)
		{
			if(p.isDrop()) temp = 10 * p.getMarks();
			else temp = 25 * p.getMarks();
		}
		else temp = p.getMarks();
		return temp;	
	}
	private boolean checkPerc(Model ob)
	{
		boolean flag = true;
		flag &= check_button(bXPerc, (double)ob.getE().getX_marks());
		flag &= check_button(bXIIPerc, (double)ob.getE().getXii_marks());
		flag &= check_button(bGradPerc, (double)GetAbsPercEdu(ob.getE()));
		
		if(ob.getE().getPG() == null && bPGradXPerc.getFlag()) flag &= false;
		else if(ob.getE().getPG() == null && !bPGradXPerc.getFlag()) flag &= true;
		else flag &= check_button(bPGradXPerc, (double)GetAbsPercPostGrad(ob.getE().getPG()));
		if(ob.getE().getG() == null && bGATEPerc.getFlag()) flag &= false;
		else if(ob.getE().getG() == null && !bGATEPerc.getFlag()) flag &= true;
		else flag &= check_button(bGATEPerc, (double)ob.getE().getG().getMarks());
		
		return flag;
	}
	
	ArrayList<Pair<Model, String> > filter()
	{
		ArrayList<Pair<Model, String> >tempList = new ArrayList<Pair<Model, String> >();
		for(Pair<Model, String> ob : data) if(check(ob.getKey())) tempList.add(ob);
		data = tempList;
		ShowResults();
		return tempList;
	}
	
	private void ShowResults()
	{
		//for(Pair<Model, String> ob : data) 
			//System.out.println(ob);
	}
}
