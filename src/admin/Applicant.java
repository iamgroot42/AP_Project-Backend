package admin;

import java.sql.Timestamp;

class Date implements Comparable<Date>
{
    int dd,mm,yy;
	public Date()
	{
		dd=mm=yy=-1;
	}
	public String toString()
	{
		return dd+"/"+mm+"/"+yy;
	}
	public void setDate(int a,int b,int c)
	{
		dd=a;
		mm=b;
		yy=c;
	}
	public int compareTo(Date temp) 
	{
		Date x=temp; 
		int aa,bb,cc;
		aa=x.dd;
		bb=x.mm;
		cc=x.yy;
		if(yy > cc) return 1;
		else if(yy < cc) return -1;
		else
		{
			if(mm > bb) return 1;
			else if(mm < bb) return -1;
			else
			{
				if(dd > aa) return 1;
				return -1;
			}
		}
	}
	public boolean equals(Date temp)
	{
		Date x=temp;
		boolean a;
		a=false;
		if(x.dd==this.dd) if(x.mm==this.mm) if(x.yy==this.yy) a=true;
		return a;
	}
}

abstract class CheckEmpty
{
	public boolean filled(int x)
	{
		return x != -1;
	}
	public boolean filled(String x)
	{
		return !x.isEmpty();
	}
	public boolean filled(Date x)
	{
		return x.dd != -1; //If anything is -1,invalid
	}
	public boolean filled(float x)
	{
		return x != -1;
	}
}

class Post_Graduate extends CheckEmpty
{
	String college,city,state,department,degree,title;
	int year,marks;
	public Post_Graduate()
	{
		college="";
		city="";
		state="";
		department="";
		degree="";
		title="";
		year=marks=-1;
	}
	public Post_Graduate(int x)
	{
		year=x;
		college="";
		city="";
		state="";
		department="";
		degree="";
		title="";
		marks=-1;
	}
	public int getYear()
	{
		return year;
	}
	public void setCollege(String x)
	{
		college=x;
	}
	public String getCollege()
	{
		return college;
	}
	public void setMarks(int x)
	{
		marks=x;
	}
	public int getMarks()
	{
		return marks;
	}
	public void setCity(String x)
	{
		city=x;
	}
	public String getCity()
	{
		return city;
	}
	public void setState(String x)
	{
		state=x;
	}
	public String getState()
	{
		return state;
	}
	public void setDegree(String x)
	{
		degree=x;
	}
	public String getDegree()
	{
		return degree;
	}
	public void setDepartment(String x)
	{
		department=x;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setTitle(String x)
	{
		title=x;
	}
	public String getTitle()
	{
		return title;
	}
}

class ECE extends CheckEmpty
{
	String[] preferences;
	public ECE()
	{
		preferences=new String[4];
		preferences[0]="";
		preferences[1]="";
		preferences[2]="";
		preferences[3]="";
	}
	public ECE(String a,String b,String c)
	{
		preferences=new String[4];
		preferences[0]=a;
		preferences[1]=b;
		preferences[2]=c;
		preferences[3]="";
	}
	public void setOptional(String x)
	{
		preferences[3]=x;
	}
	public String[] getPreferences()
	{
		return preferences;
	}
}

class Other_Degree extends CheckEmpty
{
	String exam_name,subject;
	int year,score,rank;
	public Other_Degree()
	{
		exam_name="";
		subject="";
		year=score=rank=-1;
	}
	public Other_Degree(int x)
	{
		year=x;
		exam_name="";
		subject="";
		score=rank=-1;
	}
	public int getYear()
	{
		return year;
	}
	public void setSubject(String x)
	{
		subject=x;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setExamName(String x)
	{
		exam_name=x;
	}
	public String getExamName()
	{
		return exam_name;
	}
	public void setScore(int x)
	{
		score=x;
	}
	public int getScore()
	{
		return score;
	}
	public void setRank(int x)
	{
		rank=x;
	}
	public int getRank()
	{
		return rank;
	}
}

class Gate extends CheckEmpty
{
	String area;
	int year,rank;
	float marks,score;
	public Gate()
	{
		area="";
		year=rank=-1;
		marks=score=-1;
	}
	public Gate(int x)
	{
		year=x;
		area="";
		rank=-1;
		marks=score=-1;
	}
	public int getYear()
	{
		return year;
	}
	public void setScore(float x)
	{
		score=x;
	}
	public float getScore()
	{
		return score;
	}
	public void setMarks(float x)
	{
		marks=x;
	}
	public float getMarks()
	{
		return marks;
	}
	public void setArea(String x)
	{
		area=x;
	}
	public String getArea()
	{
		return area;
	}
	public void setRank(int x)
	{
		rank=x;
	}	
	public int getRank()
	{
		return rank;
	}
}

class Personal
{
	String email,name,mobile,add_correspondence;
	String add_permanent,father_name,nationality,pincode;
	int phd_stream,gender,category,physically_disabled,war_category;
	String[]  preferences;
	Date date_of_birth;
	public Personal()
	{
		date_of_birth=new Date();
		preferences=new String[3];
		preferences[0]="";
		preferences[1]="";
		preferences[2]="";
		phd_stream=gender=category=physically_disabled=war_category=-1;
		email="";
		name="";
		mobile="";
		add_correspondence="";
		add_permanent="";
		father_name="";
		nationality="";
		pincode="";
	}
	public Personal(String email,String name,String add_c,String mobile,int stream,String pref,int gender,int category,int physical,int yy,int mm,int dd,int war,String fname,String nation,String p_add)
	{
		this.email=email;
		this.name=name;
		add_correspondence=add_c;
		this.mobile=mobile;
		phd_stream=stream;
		preferences=new String[3];
		preferences[0]=pref;
		preferences[1]="";
		preferences[2]="";
		this.gender=gender;
		this.category=category;
		physically_disabled=physical;
		date_of_birth=new Date();
		date_of_birth.setDate(dd, mm, yy);
		war_category=war;
		father_name=fname;
		nationality=nation;
		add_permanent=p_add;
		pincode="";
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getAddCorrespondence()
	{
		return add_correspondence;
	}
	public String getMobile()
	{
		return mobile;
	}
	public int getStream()
	{
		return phd_stream;
	}
	public int getGender()
	{
		return gender;
	}
	public int getCategory()
	{
		return category;
	}
	public int getPhysical()
	{
		return physically_disabled;
	}
	public Date getDOB()
	{
		return date_of_birth;
	}
	public int getWar()
	{
		return war_category;
	}
	public String getFatherName()
	{
		return father_name;
	}
	public String getNationality()
	{
		return nationality;
	}
	public String getAddPermanent()
	{
		return add_permanent;
	}
	public String getPincode()
	{
		return pincode;
	}
	public String[] getPreferences()
	{
		return preferences;
	}
	public void setPref2(String x)
	{
		preferences[1]=x;
	}
	public void setPref3(String x)
	{
		preferences[2]=x;
	}
	public void setPincode(String x)
	{
		pincode=x;
	}
}

class Education 
{
	int x_year,xii_year,graduation_year;
	int ece_phd,post_graduate,other_degree,given_gate;
	float x_marks,xii_marks,graduation_marks;
	String x_board,xii_board;
	String degree,department,college,university,city,state;
	String achievements;
	Other_Degree OD;
	Gate G;
	Post_Graduate PG;
	public Education()
	{
		x_year=xii_year=graduation_year=-1;
		ece_phd=post_graduate=other_degree=given_gate=-1;
		x_marks=xii_marks=graduation_marks=-1;
		x_board="";
		xii_board="";
		degree="";
		department="";
		college="";
		university="";
		city="";
		state="";
		achievements="";
	}
	public Education(String xb,String xiib,int yox,int yoxii,float x,float xii,String degree,String dept,String college,String univ,String city,String state,int year,int ece,int pg,int other,int sat)
	{
		achievements="";
		graduation_marks=-1;
		x_board=xb;
		xii_board=xiib;
		x_year=yox;
		xii_year=yoxii;
		x_marks=x;
		xii_marks=xii;
		this.degree=degree;
		department=dept;
		this.college=college;
		university=univ;
		this.city=city;
		this.state=state;
		graduation_year=year;
		ece_phd=ece;
		post_graduate=pg;
		other_degree=other;
		given_gate=sat;
	}
	public String getXBoard()
	{
		return x_board;
	}
	public float getXMarks()
	{
		return x_marks;
	}
	public int getXyear()
	{
		return x_year;
	}
	public String getXIIBoard()
	{
		return xii_board;
	}
	public float getXIIMarks()
	{
		return xii_marks;
	}
	public int getXIIyear()
	{
		return xii_year;
	}
	public String getDegree()
	{
		return degree;
	}
	public String getDepartment()
	{
		return department;
	}
	public String getCollege()
	{
		return college;
	}
	public String getUniversity()
	{
		return university;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public int getGradYear()
	{
		return graduation_year;
	}
	public float getGradMarks()
	{
		return graduation_marks;
	}
	public int getECEStatus()
	{
		return ece_phd;
	}
	public int getPostStatus()
	{
		return post_graduate;
	}
	public int getOtherStatus()
	{
		return other_degree;
	}
	public int getGATEStatus()
	{
		return given_gate;
	}
	public String getAchievements()
	{
		return achievements;
	}
}

public class Applicant {
	Personal P;
	Education E;
	String enrollment_number; //Yet to figure out
	public Applicant()
	{
		P=new Personal();
		E=new Education();
		enrollment_number="";
	}
	public String getEnrollmentNumber()
	{
		return enrollment_number;
	}
}