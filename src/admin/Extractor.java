package admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

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
	public String getField() { return field; } // edit to field.clone()
	public String getOption() { return option; } // edit to field.clone()
}

public class Extractor {
	ArrayList<Applicant> data;
	
	public MyButton bX, bXII, bEmail, bName, bENum, bCategory, bGender, bPhyDisabled, bStream, bGradDegree, bPostGradDegree, bDepGrad,
			 bDepPGrad, bUnGrad, bUnPGrad, bGState, bPGState, bXPerc, bXIIPerc, bGradPerc, bPGradXPerc, bGATEPerc, bDOB;
	
	public Extractor(LocalDate lower, LocalDate upper){ /*data = ReadData(lower, upper);*/ }
	
	/* Need to use Date-time (lower, upper) instead of int (lower, upper) */
	public ArrayList<Applicant> ReadData(LocalDate lower, LocalDate upper) 
	{
		System.out.println("here");
		ObjectInputStream in = null;
		ArrayList<Applicant> list = new ArrayList<Applicant>();
		try 
		{ 
			in = new ObjectInputStream(new FileInputStream("output.dat"));
			Applicant temp;
			while(true)
			{
				try
				{
					temp = (Applicant) in.readObject();
					if(temp == null) break;
//					LoaclDate temp2=temp.getTimestamp(); //Added
//					if(temp2.compareTo(lower)>=0 && temp2.compareTo(upper)<=0) list.add(temp); /* get_field() required */
				}
				catch(ClassNotFoundException ex) { }
			}
		}
		catch(IOException ex) { System.out.println("No Database!"); }
		finally 
		{ 
			try { if(in != null) in.close(); }
			catch(IOException ex) { System.out.println("No Database!"); }
		}
		return list;
	}
	
	private boolean check_button(MyButton b, String str, int mode)
	{
		if(mode == 1)
			if(b.getFlag() && !b.getField().equals("All") && !b.getField().equals(str)) return false;
		else
			if(b.getFlag() && !b.getField().equals(str)) return false;
		return true;
	}
	
	private boolean check_button(MyButton b, Double Perc)
	{
		if(b.getFlag() && !b.getOption().equals(""))
		{
			String option = b.getOption();
			int res = Perc.compareTo(Double.parseDouble(b.getField()));
			if(option.contains("Greater") && res < 0) return false;
			else if(option.contains("Lesser") && res > 0) return false;
			if(option.contains("Equals") && res == 0) return false;
			
		}
		return true;
	}
	
	public boolean check(Applicant ob){ return checkPI(ob) && checkEI(ob); }
	
	private boolean checkPI(Applicant ob)
	{
		boolean flag = true;
		flag = check_button(bEmail, ob.P.getEmail(), 0);
		flag = check_button(bName, ob.P.getName(), 0);
		flag = check_button(bENum, ob.enrollment_number/*.getENum()*/, 0);
		flag = check_button(bCategory, ob.P.getCategory(), 1);
		flag = check_button(bGender, Integer.toString(ob.P.getGender()), 0);
		flag = check_button(bPhyDisabled, Integer.toString(ob.P.getPhysical()), 0);
		if(bDOB.getFlag())
		{
			LocalDate temp=ob.P.getDOB();
			if(bDOB.getOption().contains("On") && temp.compareTo(ob.P.getDOB()) == 0) flag = flag && true;
			else
			{
				if(bDOB.getOption().contains("Before") && temp.compareTo(ob.P.getDOB()) > 0) flag = false;
				else if(bDOB.getOption().contains("After") && temp.compareTo(ob.P.getDOB()) < 0) flag = false;
			}
		}
		return flag;
	}
	
	private boolean checkEI(Applicant ob)
	{
		boolean flag = true;
		/*flag = check_button(bStream, ob.E.getStream(), 1);
		flag = check_button(bGradDegree, ob.E.getGradDegree(), 1);
		flag = check_button(bPostGradDegree, ob.E.getPostGradDegree(), 1);
		flag = check_button(bX, ob.E.getXBoard(), 1);
		flag = check_button(bXII, ob.E.getXIIBoard(), 1);
		flag = check_button(bDepGrad, ob.E.getDepGrad(), 1);
		flag = check_button(bDepPGrad, ob.E.getDepPGrad(), 1);
		flag = check_button(bUnGrad, ob.E.getUnGrad(), 1);
		flag = check_button(bUnPGrad, ob.E.getUnPGrad(), 1);
		flag = check_button(bGState, ob.E.getGState(), 1);
		flag = check_button(bPGState, ob.E.getPGState(), 1);
		flag = checkPerc(ob);*/
		return flag;
	}
	
	private boolean checkPerc(Applicant ob)
	{
		boolean flag = true;
		flag = check_button(bXPerc, (double)ob.E.getXMarks());
		flag = check_button(bXIIPerc, (double)ob.E.getXIIMarks());
		flag = check_button(bGradPerc, (double)ob.E.getGradMarks());
		//flag = check_button(bPGradXPerc, (double)ob.E.getPGradMarks());
		//flag = check_button(bGATEPerc, (double)ob.E.getGATEMrks());
		return flag;
	}
	
	public void filter(String str)
	{
		ArrayList<Applicant> tempList = new ArrayList<Applicant>();
		for(Applicant ob : data) if(check(ob)) tempList.add(ob);
		data = tempList;
		ShowResults();
	}
	
	private void ShowResults()
	{
		for(Applicant ob : data) 
			System.out.println(ob.enrollment_number + " " + ob.P.getName() /*+ " " + Link_to_data*/);
	}
}
