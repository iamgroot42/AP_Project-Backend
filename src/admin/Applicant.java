package admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import javafx.scene.control.DatePicker;


abstract class CheckEmpty
{
	public boolean filled(int x) {return x != -1;}
	public boolean filled(String x) {return  !x.isEmpty();}
	public boolean filled(DatePicker x)
	{
		return x.getValue()==null; 
	}
	public boolean filled(float x) {return x != -1;}
}

class Feedback
{
	String first_hear;
	boolean[] interested;
	public Feedback(String x,int i) {first_hear=x;for(int i1=0;i1<10;i1++) interested[i1]=false; interested[i]=true;}
	public boolean[] getInterested() {return interested;}
	public void setInterested(int i) {interested[i]=true;}
	public String getFirsthear() {return first_hear;}
	public void setFirsthear(String x) {first_hear=x;}
}

class Post_Graduate extends CheckEmpty
{
	String college,city,state,department,degree,title;
	int year,marks;
	public Post_Graduate(int x)
	{
		year=x;
		college="";city="";state="";
		department="";degree="";title="";
		marks=-1;
	}
	public int getYear() {return year;}
	public void setCollege(String x) {college=x;}
	public String getCollege() {return college;}
	public void setMarks(int x) {marks=x;}
	public int getMarks() {return marks;}
	public void setCity(String x) {city=x;}
	public String getCity() {return city;}
	public void setState(String x){state=x;}
	public String getState() {return state;}
	public void setDegree(String x) {degree=x;}
	public String getDegree() {return degree;}
	public void setDepartment(String x) {department=x;}
	public String getDepartment() {return department;}
	public void setTitle(String x) {title=x;}
	public String getTitle() {return title;}
}

class ECE extends CheckEmpty
{
	String[] preferences;
	public ECE(String a,String b,String c)
	{
		preferences=new String[4];
		preferences[0]=a;preferences[1]=b;preferences[2]=c;preferences[3]="";
	}
	public void setOptional(String x) {preferences[3]=x;}
	public String[] getPreferences() {return preferences;}
}

class Other_Degree extends CheckEmpty
{
	String exam_name,subject;
	int year,score,rank;
	public Other_Degree(int x) {year=x;exam_name="";subject="";score=rank=-1;}
	public int getYear() {return year;}
	public void setSubject(String x) {subject=x;}
	public String getSubject() {return subject;}
	public void setExamName(String x) {exam_name=x;}
	public String getExamName() {return exam_name;}
	public void setScore(int x) {score=x;}
	public int getScore() {return score;}
	public void setRank(int x) {rank=x;}
	public int getRank() {return rank;}
}

class Gate extends CheckEmpty
{
	String area;
	int year,rank;
	float marks,score;
	public Gate(int x) {year=x;area="";rank=-1;marks=score=-1;}
	public int getYear() {return year;}
	public void setScore(float x) {score=x;}
	public float getScore() {return score;}
	public void setMarks(float x) {marks=x;}
	public float getMarks() {return marks;}
	public void setArea(String x) {area=x;}
	public String getArea() {return area;}
	public void setRank(int x) {rank=x;}	
	public int getRank() {return rank;}
}

class Personal
{
	String email,name,mobile,add_correspondence;
	String add_permanent,father_name,nationality,pincode;
	int phd_stream,gender,physically_disabled,war_category;
	String[]  preference;
	String reftype,category;
	DatePicker date_of_birth;
	public Personal(String email,String name,String add_c,String mobile,int stream,String pref[],int gender,String category,int physical,int war,String fname,String nation,String p_add)
	{
		this.email=email;
		this.name=name;
		add_correspondence=add_c;
		this.mobile=mobile;
		phd_stream=stream;
		preference=new String[4];
		preference[0]=pref[0];
		preference[1]=pref[1];
		preference[2]=pref[2];
		preference[3]="";
		this.gender=gender;
		this.category=category;
		physically_disabled=physical;
//		Deal with DOB later
//		date_of_birth=new DatePicker();
//		date_of_birth=dd.getValue();
		war_category=war;
		father_name=fname;
		nationality=nation;
		add_permanent=p_add;
		pincode="";
	}
	public String getName() {return name;}
	public String getEmail() {return email;}
	public String getAddCorrespondence() {return add_correspondence;}
	public String getMobile() {return mobile;}
	public int getStream() {return phd_stream;}
	public int getGender() {return gender;}
	public String getCategory() {return category;}
	public int getPhysical(){return physically_disabled;}
	public LocalDate getDOB() {return date_of_birth.getValue();}
	public int getWar() {return war_category;}
	public String getFatherName() {return father_name;}
	public String getNationality() {return nationality;}
	public String getAddPermanent() {return add_permanent;}
	public String getPincode() {return pincode;}
	public String getPref4() {return preference[3];}
	public String[] getPreference() {return preference;}
	public void setPref4(String x) {preference[3]=x;}
	public void setPincode(String x){pincode=x;}
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
	public Education(String xb,String xiib,int yox,int yoxii,float x,float xii,String degree,String dept,String college,String univ,String city,String state,int year,int ece,int pg,int other,int sat)
	{
		achievements="";graduation_marks=-1;
		x_board=xb;xii_board=xiib;
		x_year=yox;xii_year=yoxii;
		x_marks=x;xii_marks=xii;
		this.degree=degree;department=dept;
		this.college=college;university=univ;
		this.city=city;this.state=state;
		graduation_year=year;
		ece_phd=ece;post_graduate=pg;
		other_degree=other;given_gate=sat;
	}
	public String getXBoard() {return x_board;}
	public float getXMarks() {return x_marks;}
	public int getXyear() {return x_year;}
	public String getXIIBoard() {return xii_board;}
	public float getXIIMarks() {return xii_marks;}
	public int getXIIyear() {return xii_year;}
	public String getDegree() {return degree;}
	public String getDepartment() {return department;}
	public String getCollege() {return college;}
	public String getUniversity() {return university;}
	public String getCity() {return city;}
	public String getState() {return state;}
	public int getGradYear() {return graduation_year;}
	public float getGradMarks() {return graduation_marks;}
	public int getECEStatus() {return ece_phd;}
	public int getPostStatus() {return post_graduate;}
	public int getOtherStatus() {return other_degree;}
	public int getGATEStatus() {return given_gate;}
	public String getAchievements() {return achievements;}
}

class Payment
{
	boolean clear;
	String bank,branch,draft;
	public Payment(String a,String b,String c) {clear=false;bank=a;branch=b;draft=c;}
	public void setStatus(boolean x) {clear=x;}
	public boolean getStatus() {return clear;}
}

public class Applicant implements Serializable {
	Personal P;
	Education E;
	String enrollment_number; //Yet to figure out
	Payment bank;
//	Date timestamp;
	boolean cv,sop;
	public Applicant(String xb,String xiib,int yox,int yoxii,float x,float xii,String degree,String dept,String college,String univ,String city,String state,int year,int ece,int pg,int other,int sat,Payment pay,String email,String name,String add_c,String mobile,int stream,String pref[],int gender,int category,int physical,int yy,int mm,int dd,int war,String fname,String nation,String p_add)
	{
//		P=new Personal(email,name,add_c,mobile,stream,pref,gender,category,physical,yy,mm,dd,war,fname,nation,p_add);
		E=new Education(xb,xiib,yox,yoxii,x,xii,degree,dept,college,univ,city,state,year,ece,pg,other,sat);
		enrollment_number="";
		bank=pay;
		cv=sop=false;
//		timestamp=new Date(); //get current date from system
	}
	public String getEnrollmentNumber() {return enrollment_number;}
	public boolean getCV() {return cv;}
	public void setCV(boolean x) {cv=x;}
	public boolean getSOP() {return sop;}
	public void setSOP(boolean x) {sop=x;}	
//	public Date getTimestamp() {return timestamp;}
}