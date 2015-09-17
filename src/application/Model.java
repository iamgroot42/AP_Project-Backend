package application;


import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
class Post_Graduate extends CheckEmpty implements Serializable
{
	String college,city,state,department,degree,title;
	int year;
	float marks;
	boolean drop;
	int type;
	public boolean isDrop() {
		return drop;
	}
	public void setDrop(boolean drop) {
		this.drop = drop;
	}
	public int isType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
}

@SuppressWarnings("serial")
class Personal implements Serializable
{
	String email,name,mobile,add_correspondence;
	String add_permanent,father_name,nationality,pincode;
	int phd_stream;
	String[]  preference;
	String category;
	boolean gender,physically_disabled,war_category;
	LocalDate date_of_birth;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAdd_correspondence() {
		return add_correspondence;
	}
	public void setAdd_correspondence(String add_correspondence) {
		this.add_correspondence = add_correspondence;
	}
	public String getAdd_permanent() {
		return add_permanent;
	}
	public void setAdd_permanent(String add_permanent) {
		this.add_permanent = add_permanent;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getPhd_stream() {
		return phd_stream;
	}
	public void setPhd_stream(int phd_stream) {
		this.phd_stream = phd_stream;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public boolean getPhysically_disabled() {
		return physically_disabled;
	}
	public void setPhysically_disabled(boolean physically_disabled) {
		this.physically_disabled = physically_disabled;
	}
	public boolean getWar_category() {
		return war_category;
	}
	public void setWar_category(boolean war_category) {
		this.war_category = war_category;
	}
	public String[] getPreference() {
		return preference;
	}
	public void setPreference(String[] preference) {
		this.preference = preference;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}	
}

@SuppressWarnings("serial")
class Other_Degree extends CheckEmpty implements Serializable
{
	String exam_name,subject;
	int year,score,rank;
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}

@SuppressWarnings("serial")
class Gate extends CheckEmpty implements Serializable
{
	String area;
	int year,rank;
	float marks,score;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}

@SuppressWarnings("serial")
class Education implements Serializable
{
	int x_year,xii_year,graduation_year;
	boolean ece_phd,post_graduate,other_degree,given_gate;
	float x_marks,xii_marks,graduation_marks;
	String x_board,xii_board;
	String degree,department,college,university,city,state;
	String achievements;
	Other_Degree OD;
	ECE E;
	boolean drop;
	int type;
	public boolean isDrop() {
		return drop;
	}
	public void setDrop(boolean drop) {
		this.drop = drop;
	}
	public int isType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ECE getE() {
		return E;
	}
	public void setE(ECE e) {
		E = e;
	}
	Gate G;
	Post_Graduate PG;
	public int getX_year() {
		return x_year;
	}
	public void setX_year(int x_year) {
		this.x_year = x_year;
	}
	public int getXii_year() {
		return xii_year;
	}
	public void setXii_year(int xii_year) {
		this.xii_year = xii_year;
	}
	public int getGraduation_year() {
		return graduation_year;
	}
	public void setGraduation_year(int graduation_year) {
		this.graduation_year = graduation_year;
	}
	public boolean getEce_phd() {
		return ece_phd;
	}
	public void setEce_phd(boolean ece_phd) {
		this.ece_phd = ece_phd;
	}
	public boolean getPost_graduate() {
		return post_graduate;
	}
	public void setPost_graduate(boolean post_graduate) {
		this.post_graduate = post_graduate;
	}
	public boolean getOther_degree() {
		return other_degree;
	}
	public void setOther_degree(boolean other_degree) {
		this.other_degree = other_degree;
	}
	public boolean getGiven_gate() {
		return given_gate;
	}
	public void setGiven_gate(boolean given_gate) {
		this.given_gate = given_gate;
	}
	public float getX_marks() {
		return x_marks;
	}
	public void setX_marks(float x_marks) {
		this.x_marks = x_marks;
	}
	public float getXii_marks() {
		return xii_marks;
	}
	public void setXii_marks(float xii_marks) {
		this.xii_marks = xii_marks;
	}
	public float getGraduation_marks() {
		return graduation_marks;
	}
	public void setGraduation_marks(float graduation_marks) {
		this.graduation_marks = graduation_marks;
	}
	public String getX_board() {
		return x_board;
	}
	public void setX_board(String x_board) {
		this.x_board = x_board;
	}
	public String getXii_board() {
		return xii_board;
	}
	public void setXii_board(String xii_board) {
		this.xii_board = xii_board;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAchievements() {
		return achievements;
	}
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
	public Other_Degree getOD() {
		return OD;
	}
	public void setOD(Other_Degree oD) {
		OD = oD;
	}
	public Gate getG() {
		return G;
	}
	public void setG(Gate g) {
		G = g;
	}
	public Post_Graduate getPG() {
		return PG;
	}
	public void setPG(Post_Graduate pG) {
		PG = pG;
	}
}

@SuppressWarnings("serial")
class ECE extends CheckEmpty implements Serializable
{
	String[] preferences;
	public String[] getPreferences() {
		return preferences;
	}
	public void setPreferences(String[] preferences) {
		this.preferences = preferences;
	}
}

@SuppressWarnings("serial")
abstract class CheckEmpty implements Serializable
{
	public boolean filled(int x) {return x != -1;}
	public boolean filled(String x) {return  !x.isEmpty();}
	public boolean filled(LocalDate x)
	{
		return x==null; 
	}
	public boolean filled(float x) {return x != -1;}
}
@SuppressWarnings("serial")
public class Model implements Serializable {
	Personal P;
	Education E;
	String enrollment_number; //Yet to figure out
	LocalDate timestamp;
	boolean cv,sop;
	public Personal getP() {
		return P;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public void setP(Personal p) {
		P = p;
	}
	public Education getE() {
		return E;
	}
	public void setE(Education e) {
		E = e;
	}
	public String getEnrollment_number() {
		return enrollment_number;
	}
	public void setEnrollment_number(String enrollment_number) {
		this.enrollment_number = enrollment_number;
	}
	public boolean isCv() {
		return cv;
	}
	public void setCv(boolean cv) {
		this.cv = cv;
	}
	public boolean isSop() {
		return sop;
	}
	public void setSop(boolean sop) {
		this.sop = sop;
	}	
}