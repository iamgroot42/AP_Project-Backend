package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Control {
	static Stage primaryStage;
	private Extractor ex;
    private ObservableList<String> states = FXCollections.observableArrayList();
    private ObservableList<String> Gdep = FXCollections.observableArrayList();
    private ObservableList<String> PGdep = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton dobBefore;

    @FXML
    private ToggleGroup dob;

    @FXML
    private RadioButton dobOn;

    @FXML
    private RadioButton dobAfter;

    @FXML
    private DatePicker Dob;

    @FXML
    private TextField Email;

    @FXML
    private TextField Name;

    @FXML
    private TextField ENum;

    @FXML
    private RadioButton gendermale;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton genderfemale;

    @FXML
    private RadioButton disabledy;

    @FXML
    private ToggleGroup disabled;

    @FXML
    private RadioButton disabledn;

    @FXML
    private ChoiceBox<String> Category;

    @FXML
    private TextField UnivGrad;

    @FXML
    private TextField UnivPGrad;

    @FXML
    private CheckBox XPercG;

    @FXML
    private CheckBox XPercE;

    @FXML
    private CheckBox XPercL;

    @FXML
    private TextArea XPerc;

    @FXML
    private CheckBox GateScoreG;

    @FXML
    private CheckBox GateScoreE;

    @FXML
    private CheckBox GateScoreL;

    @FXML
    private TextArea GateScore;

    @FXML
    private CheckBox PGradPercG;

    @FXML
    private CheckBox PGradPercE;

    @FXML
    private CheckBox PGradPercL;

    @FXML
    private TextArea PGradPerc;

    @FXML
    private CheckBox GradPercG;

    @FXML
    private CheckBox GradPercE;

    @FXML
    private CheckBox GradPercL;

    @FXML
    private TextArea GradPerc;

    @FXML
    private CheckBox XIIPercG;

    @FXML
    private CheckBox XIIPercE;

    @FXML
    private CheckBox XIIPercL;

    @FXML
    private TextArea XIIPerc;

    @FXML
    private ChoiceBox<String> PGradState;

    @FXML
    private ChoiceBox<String> PhdStream;

    @FXML
    private ChoiceBox<String> GradDegree;

    @FXML
    private ChoiceBox<String> PGradDep;

    @FXML
    private ChoiceBox<String> GradDep;

    @FXML
    private ChoiceBox<String> XIIBoard;

    @FXML
    private ChoiceBox<String> XBoard;

    @FXML
    private ChoiceBox<String> PGradDegree;

    @FXML
    private ChoiceBox<String> GradState;

    @FXML
    private DatePicker AppDatedFrom;

    @FXML
    private DatePicker AppDatedUpto;

    @FXML
    private Button Results;

    @FXML
    private Label ResultsValidate;

    @FXML
    private Label Dobvalidate;
    boolean flag1 = false;
    @FXML
    void distogglen(ActionEvent event) {
    	System.out.println("here");
    	if(disabledn.isArmed() && flag1) disabledn.setSelected(false);
    	flag1 = !flag1;
    }		
    @FXML
    void gatescore(ActionEvent event) {
    	if(GateScoreG.isSelected()) { GateScoreL.setIndeterminate(true); GateScoreL.setDisable(true);}
    	else { GateScoreL.setIndeterminate(false); GateScoreL.setDisable(false); }
    	if(GateScoreL.isSelected()) { GateScoreG.setIndeterminate(true); GateScoreG.setDisable(true);}
    	else { GateScoreG.setIndeterminate(false); GateScoreG.setDisable(false); }
    }

    @FXML
    void gradscore(ActionEvent event) {
    	if(GradPercG.isSelected()) { GradPercL.setIndeterminate(true); GradPercL.setDisable(true);}
    	else { GradPercL.setIndeterminate(false); GradPercL.setDisable(false); }
    	if(GradPercL.isSelected()) { GradPercG.setIndeterminate(true); GradPercG.setDisable(true);}
    	else { GradPercG.setIndeterminate(false); GradPercG.setDisable(false); }
    }

    @FXML
    void pgradscore(ActionEvent event) {
    	if(PGradPercG.isSelected()) { PGradPercL.setIndeterminate(true); PGradPercL.setDisable(true);}
    	else { PGradPercL.setIndeterminate(false); PGradPercL.setDisable(false); }
    	if(PGradPercL.isSelected()) { PGradPercG.setIndeterminate(true); PGradPercG.setDisable(true);}
    	else { PGradPercG.setIndeterminate(false); PGradPercG.setDisable(false); }
    }

    @FXML
    void xiiscore(ActionEvent event) {
    	if(XIIPercG.isSelected()) { XIIPercL.setIndeterminate(true); XIIPercL.setDisable(true);}
    	else { XIIPercL.setIndeterminate(false); XIIPercL.setDisable(false); }
    	if(XIIPercL.isSelected()) { XIIPercG.setIndeterminate(true); XIIPercG.setDisable(true);}
    	else { XIIPercG.setIndeterminate(false); XIIPercG.setDisable(false); }
    }

    @FXML
    void xscore(ActionEvent event) {
    	if(XPercG.isSelected()) { XPercL.setIndeterminate(true); XPercL.setDisable(true);}
    	else { XPercL.setIndeterminate(false); XPercL.setDisable(false); }
    	if(XPercL.isSelected()) { XPercG.setIndeterminate(true); XPercG.setDisable(true);}
    	else { XPercG.setIndeterminate(false); XPercG.setDisable(false); }
    }

    @FXML
    void Results(ActionEvent event) {
    	if(AppDatedFrom.getValue() == null || AppDatedUpto.getValue() == null) {
    		ResultsValidate.setText("Please enter the Interval.");
    		ResultsValidate.setVisible(true);
    	}
    	else if(AppDatedFrom.getValue() != null && AppDatedFrom.getValue().compareTo(LocalDate.now()) > 0) {
    		ResultsValidate.setText("'From' field shouldn't be in future!");
    		ResultsValidate.setVisible(true);
    	}
    	else if(AppDatedFrom.getValue().compareTo(AppDatedUpto.getValue()) > 0) {
    		ResultsValidate.setText("Wrong Interval!");
    		ResultsValidate.setVisible(true);
    	}
    	else if(AppDatedUpto.getValue().compareTo(LocalDate.now()) > 0) {
    		ResultsValidate.setText("'Upto' field shouldn't be in future!");
    		ResultsValidate.setVisible(true);
    	}
    	else if(AppDatedFrom.getValue() != null && AppDatedUpto.getValue() != null){
    		ResultsValidate.setVisible(false);
    		ex =  new Extractor(AppDatedFrom.getValue(), AppDatedUpto.getValue());
    		if(check())
    		{
    			System.out.println("Yo");
    			filter();
    		}
    	}
    }

    @FXML
    void initialize() {
    	String[] list = {"All", "Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
    			"Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "New Delhi", "Goa",
    			"Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala",	
    			"Lakshadweep", "Madhya Pradesh", "Maharashtra", "Nagpur", "Manipur", "Meghalaya", "Mizoram","Nagaland",
    			"Odisha", "Puducherry", "Punjab", "Murree", "Shimla", "Rajasthan", "Sikkim", "Tamil Nadu", "Hyderabad", 
    			"Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
    	String[] list1 = {"All", "Architecture & Planning ","Alternate Hydro Energy Centre","Chemical Engineering",
    			"Civil Engineering","Computer Sc. & Engg.","Centre for Transportation Systems",
    			"Centre of Excellence in Disaster Mitigation & Management","Centre for Nanotechnology",
    			"Earthquake Engineering","Electrical Engineering","Electronics & Communication Engineering",
    			"Hydrology","Mechanical & Industrial Engineering","Metallurgical & Materials Engg.","Paper Technology",
    			"Water Resources Development & Management" };
    	String[] list2 = {"All", "Applied Mechanics","Aerospace Engineering","Biotechnology","Catalysis",
    			"Civil Engineering","Chemical Engineering","Computer Science and Engineering","Chemistry",
    			"Electrical Engineering","Engineering Design","Electrical Engineering","EL","EN",
    			"Engineering Physics","ET","General","HM","Humanities","Interdisciplinary","Industrial Lecture",
    			"Mathematics","Mechanical Engineering","Metallurgical and Materials Engineering",
    			"Management Studies","Metallurgical and Materials Engineering","Nuclear Engineering",
    			"Ocean Engineering","PE","Physics","Workshop" };
    	for(String str : list) states.add(str);
    	for(String str : list1) PGdep.add(str);
    	for(String str : list2) Gdep.add(str);
    	PhdStream.setValue("All");
        GradDegree.setValue("All");
        PGradDegree.setValue("All");
        XBoard.setValue("All");
        XIIBoard.setValue("All");
        GradDep.setItems(Gdep);
        PGradDep.setItems(PGdep);
        GradDep.setValue("All");
        PGradDep.setValue("All");
        Category.setValue("All");
        GradState.setItems(states);
        PGradState.setItems(states);
        GradState.setValue("All");
        PGradState.setValue("All");
    }
    private boolean check()
    {
    	if(!checkPI()) {
    		ResultsValidate.setText("Please check Personal Information tab.");
    		ResultsValidate.setVisible(true);
    		return false;
    	}
    	if(!checkEI()) {
    		ResultsValidate.setText("Please check Percentage/Score Inputs.");
    		ResultsValidate.setVisible(true);
    		return false;
    	}
    	return true;
    }
    private boolean checkPerc(TextArea a, int min, int max, int mode)
    {
    	try {
    	if(!a.getText().equals("") && 
    	(Double.compare(Double.valueOf(a.getText()), max) > 0 || 
    	Double.compare(Double.valueOf(a.getText()), min) < 0)) {
    		a.clear();
    		a.setPromptText("Invalid!");
    		return false;
    	}
    	}
    	catch(Exception e) {
    		a.clear();
    		a.setPromptText("Invalid!");
    		return false;
    	}
    	if(mode == 0) a.setPromptText("Percent");
    	else a.setPromptText("Score");
    	return true;
    }
    private boolean checkPerc(TextArea a, boolean flag, int mode)
    {
    	if(flag ^ a.getText().equals("")) {
    		a.clear();
    		a.setPromptText("Invalid!");
    		return false;
    	} 
    	if(mode == 0) a.setPromptText("Percent");
    	else a.setPromptText("Score");
    	return true;
    }
    private boolean checkEI()
    {
    	if((checkPerc(GradPerc, 0, 100, 0) && checkPerc(PGradPerc, 0, 100, 0) &&
    	   checkPerc(XPerc, 0, 100, 0) && checkPerc(XIIPerc, 0, 100, 0) && 
    	   checkPerc(GateScore, 0, 100, 1)) == false) return false; 
    	
    	String str = "";
    	if(XPercL.isSelected()) str += "Lesser";
    	else if(XPercG.isSelected()) str += "Greater";
    	if(XPercE.isSelected()) str += "Equals";
    	if(!checkPerc(XPerc, str.equals(""), 0)) return false;
    	ex.bXPerc =  new MyButton(XPerc.getText().toLowerCase(), str, (!XPerc.getText().equals("") && !str.equals("")));
    	str = "";
    	if(XIIPercL.isSelected()) str += "Lesser";
    	else if(XIIPercG.isSelected()) str += "Greater";
    	if(XIIPercE.isSelected()) str += "Equals";
    	if(!checkPerc(XIIPerc, str.equals(""), 0)) return false;
    	ex.bXIIPerc =  new MyButton(XIIPerc.getText().toLowerCase(), str, (!XIIPerc.getText().equals("") && !str.equals("")));
		str = "";
		if(GradPercL.isSelected()) str += "Lesser";
    	else if(GradPercG.isSelected()) str += "Greater";
    	if(GradPercE.isSelected()) str += "Equals";
    	if(!checkPerc(GradPerc, str.equals(""), 0)) return false;
		ex.bGradPerc =  new MyButton(GradPerc.getText().toLowerCase(), str, (!GradPerc.getText().equals("") && !str.equals("")));
		str = "";
		if(PGradPercL.isSelected()) str += "Lesser";
    	else if(PGradPercG.isSelected()) str += "Greater";
    	if(PGradPercE.isSelected()) str += "Equals";
    	if(!checkPerc(PGradPerc, str.equals(""), 0)) return false;
		ex.bPGradXPerc =  new MyButton(PGradPerc.getText().toLowerCase(), str, (!PGradPerc.getText().equals("") && !str.equals("")));
		str = "";
		if(GateScoreL.isSelected()) str += "Lesser";
    	else if(GateScoreG.isSelected()) str += "Greater";
    	if(GateScoreE.isSelected()) str += "Equals";
    	if(!checkPerc(GateScore, str.equals(""), 1)) return false;
		ex.bGATEPerc =  new MyButton(GateScore.getText().toLowerCase(), str, (!GateScore.getText().equals("") && !str.equals("")));
    	return true;
    }
    private MyButton InitButton(ChoiceBox<String> cb) { return new MyButton(cb.getValue().toLowerCase(), cb.getValue() != null); }
    private MyButton InitButton(TextField tf) { return new MyButton(tf.getText().toLowerCase(), !tf.getText().equals("")); }
    private void filter()
    {   
        ex.bX = InitButton(XBoard);
        ex.bXII = InitButton(XIIBoard);
        ex.bGState =  InitButton(GradState);
		ex.bPGState =  InitButton(PGradState);
		ex.bCategory = InitButton(Category);
        ex.bStream = InitButton(PhdStream);
        ex.bGradDegree = InitButton(GradDegree);
        ex.bPostGradDegree = InitButton(PGradDegree);
        ex.bDepGrad = InitButton(GradDep);
		ex.bDepPGrad = InitButton(PGradDep);
		
		ex.bEmail = new MyButton(Email.getText(), !Email.getText().equals(""));//InitButton(Email);
		System.out.println("1 " + Email.getText() + " " + !Email.getText().equals(""));
        ex.bName = InitButton(Name);
        ex.bENum = InitButton(ENum);
		ex.bUnGrad =  InitButton(UnivGrad);
		ex.bUnPGrad =  InitButton(UnivPGrad);
		
		try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Filtered.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root, 600, 600);
		FilteredControl controller = fxmlLoader.<FilteredControl>getController();
		ArrayList<Pair<Model, String> > temp = ex.filter();
		ArrayList<TableEntry> tabledata = new ArrayList<TableEntry>();
		for(Pair<Model, String> ob : temp) 
			tabledata.add(new TableEntry(ob.getKey().getEnrollment_number(), ob.getKey().getP().getName(), ob.getValue(), 
					ob.getValue().replace(".txt", "_SOP.pdf"), ob.getValue().replace(".txt", "_CV.pdf")));
		controller.setTableData(tabledata);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Filtered Results");
		}
		catch(IOException ex) {System.out.println("caught");}
    }
    private String getToggleGroupValue(ToggleGroup g)
    {
    	String[] temp = g.getSelectedToggle().toString().split("[']+");
    	return temp[temp.length-1];
    }
    private void InvalidField(TextField a) {
    	a.clear();
		a.setPromptText("Invalid Input!");
    }
    private boolean checkPI()
    {
    	boolean flag = true;
    	if(!Email.getText().trim().equals("") && (!Email.getText().contains("@") || !Email.getText().contains("."))) {
    		InvalidField(Email);
    		flag = false;
    	}
    	else Email.setPromptText("");
    	if(!Name.getText().trim().equals("") && Name.getText().matches(".*\\d+.*")) {
    		InvalidField(Name);
    		flag = false;
    	}
    	else Name.setPromptText("");
    	if(!ENum.getText().trim().equals("") && ENum.getText().matches(".*[a-zA-Z]+.*")) {
    		InvalidField(ENum);
    		flag = false;
    	}
    	else ENum.setPromptText("");
    	if(Dob.getValue() != null && Dob.getValue().compareTo(LocalDate.now()) > 0)
    	{
    		Dobvalidate.setText("DOB can't be in future!");
    		Dobvalidate.setVisible(true);
    		flag = false;
    	}
    	
    	String str = ""; 
    	if(dob.getSelectedToggle() != null && Dob.getValue() ==  null) {
    		Dobvalidate.setText("Please select a date!");
    		Dobvalidate.setVisible(true);
    		flag = false;
    	}
    	if(dob.getSelectedToggle() == null && Dob.getValue() !=  null){
    		Dobvalidate.setText("Please select an option!");
    		Dobvalidate.setVisible(true);
    		flag = false;
    	}
    	if(flag == false) return false;
    	if(gender.getSelectedToggle() != null)
    		ex.bGender = new MyButton(getToggleGroupValue(gender), true);
    	else ex.bGender = new MyButton("", false);
    	
    	if(disabled.getSelectedToggle() != null)
    		ex.bPhyDisabled = new MyButton(getToggleGroupValue(disabled), true);
    	else ex.bPhyDisabled = new MyButton("", false);
    	if(Dob.getValue() != null) str =  Dob.getValue().toString();
    	if(dob.getSelectedToggle() != null)
    		ex.bDOB = new MyButton(str, getToggleGroupValue(dob), true);
    	else ex.bDOB = new MyButton(str, false);
    	
    	Dobvalidate.setVisible(false);
    	return true;
    }
    //private boolean checkstr(String str) { return !str.equals("");}
}
