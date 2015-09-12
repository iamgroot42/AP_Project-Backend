package admin;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Control {

    private Extractor ex;
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
    void gatescore(ActionEvent event) {
    	if(GateScoreG.isSelected()) { GateScoreL.setIndeterminate(true); GateScoreL.setDisable(true);}
    	else { GateScoreL.setIndeterminate(false); GateScoreL.setDisable(false); }
    	if(GateScoreL.isSelected()) { GateScoreL.setIndeterminate(true); GateScoreG.setDisable(true);}
    	else { GateScoreG.setIndeterminate(false); GateScoreG.setDisable(false); }
    	System.out.println(GateScoreG.isSelected() + " " + GateScoreL.isSelected());
    }

    @FXML
    void gradscore(ActionEvent event) {
    	if(GradPercG.isSelected()) { GradPercL.setIndeterminate(true); GradPercL.setDisable(true);}
    	else { GradPercL.setIndeterminate(false); GradPercL.setDisable(false); }
    	if(GradPercL.isSelected()) { GradPercL.setIndeterminate(true); GradPercG.setDisable(true);}
    	else { GradPercG.setIndeterminate(false); GradPercG.setDisable(false); }
    	System.out.println(GradPercG.isSelected() + " " + GradPercL.isSelected());
    }

    @FXML
    void pgradscore(ActionEvent event) {
    	if(PGradPercG.isSelected()) { PGradPercL.setIndeterminate(true); PGradPercL.setDisable(true);}
    	else { PGradPercL.setIndeterminate(false); PGradPercL.setDisable(false); }
    	if(PGradPercL.isSelected()) { PGradPercL.setIndeterminate(true); PGradPercG.setDisable(true);}
    	else { PGradPercG.setIndeterminate(false); PGradPercG.setDisable(false); }
    	System.out.println(PGradPercG.isSelected() + " " + PGradPercL.isSelected());
    }

    @FXML
    void xiiscore(ActionEvent event) {
    	if(XIIPercG.isSelected()) { XIIPercL.setIndeterminate(true); XIIPercL.setDisable(true);}
    	else { XIIPercL.setIndeterminate(false); XIIPercL.setDisable(false); }
    	if(XIIPercL.isSelected()) { XIIPercL.setIndeterminate(true); XIIPercG.setDisable(true);}
    	else { XIIPercG.setIndeterminate(false); XIIPercG.setDisable(false); }
    	System.out.println(XIIPercG.isSelected() + " " + XIIPercL.isSelected());
    }

    @FXML
    void xscore(ActionEvent event) {
    	if(XPercG.isSelected()) { XPercL.setIndeterminate(true); XPercL.setDisable(true);}
    	else { XPercL.setIndeterminate(false); XPercL.setDisable(false); }
    	if(XPercL.isSelected()) { XPercL.setIndeterminate(true); XPercG.setDisable(true);}
    	else { XPercG.setIndeterminate(false); XPercG.setDisable(false); }
    	System.out.println(XPercG.isSelected() + " " + XPercL.isSelected());
    }

    @FXML
    void Results(ActionEvent event) {
    	ex = new Extractor(AppDatedFrom.getValue(), AppDatedUpto.getValue());
    	if(check())
    	{
    		//System.out.println(gender.getSelectedToggle().toString().contains("Female"));
    		//System.out.println(Category.getValue());
    	}
    	else { System.out.println("Wrong or Invalid Fields!"); }
    }

    @FXML
    void initialize() {
    	PhdStream.setValue("All");
        GradDegree.setValue("All");
        PGradDegree.setValue("All");
        XBoard.setValue("All");
        XIIBoard.setValue("All");
        GradDep.setValue("All");
        PGradDep.setValue("All");
        GradState.setValue("All");
        PGradState.setValue("All");
        Category.setValue("All");
    }
    private boolean check()
    {
    	//LocalDate dob_date = Dob.getValue();
    	if(!checkPI()) return false;
    	if(!checkEI()) return false;
    	filter();
    	return true;
    }
    private boolean checkPerc(TextArea a)
    {
    	if(!a.getText().equals("") && 
    	(Double.compare(Double.valueOf(a.getText()), 100) > 0 || 
    	Double.compare(Double.valueOf(a.getText()), 0) < 0)) return false;
    	return true;
    }
    private boolean checkEI()
    {
    	if((checkPerc(GradPerc) && checkPerc(PGradPerc) &&
    	   checkPerc(XPerc) && checkPerc(XIIPerc) && 
    	   checkPerc(GateScore)) == false) return false; 
    	
    	String str = "";
    	if(XPercL.isSelected()) str += "Lesser";
    	else if(XPercG.isSelected()) str += "Greater";
    	if(XPercE.isSelected()) str += "Equals";
    	ex.bXPerc =  new MyButton(XPerc.getText(), str, !XPerc.getText().equals(""));
    	str = "";
    	if(XIIPercL.isSelected()) str += "Lesser";
    	else if(XIIPercG.isSelected()) str += "Greater";
    	if(XIIPercE.isSelected()) str += "Equals";
		ex.bXIIPerc =  new MyButton(XIIPerc.getText(), str, !XIIPerc.getText().equals(""));
		str = "";
		if(GradPercL.isSelected()) str += "Lesser";
    	else if(GradPercG.isSelected()) str += "Greater";
    	if(GradPercE.isSelected()) str += "Equals";
		ex.bGradPerc =  new MyButton(GradPerc.getText(), str, !GradPerc.getText().equals(""));
		str = "";
		if(PGradPercL.isSelected()) str += "Lesser";
    	else if(PGradPercG.isSelected()) str += "Greater";
    	if(PGradPercE.isSelected()) str += "Equals";
		ex.bPGradXPerc =  new MyButton(PGradPerc.getText(), str, !PGradPerc.getText().equals(""));
		str = "";
		if(GateScoreL.isSelected()) str += "Lesser";
    	else if(GateScoreG.isSelected()) str += "Greater";
    	if(GateScoreE.isSelected()) str += "Equals";
		ex.bGATEPerc =  new MyButton(GateScore.getText(), str, !GateScore.getText().equals(""));
    	return true;
    }
    private MyButton InitButton(ChoiceBox<String> cb) { return new MyButton(cb.getValue(), cb.getValue() != null); }
    private MyButton InitButton(TextField tf) { return new MyButton(tf.getText(), !tf.getText().equals("")); }
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
		
		ex.bEmail = InitButton(Email);
        ex.bName = InitButton(Name);
        ex.bENum = InitButton(ENum);
		ex.bUnGrad =  InitButton(UnivGrad);
		ex.bUnPGrad =  InitButton(UnivPGrad);
		
		System.out.println("DOB" + " " + ex.bDOB.getField() + " " + ex.bDOB.getFlag() + " " + ex.bDOB.getOption());
    }
    private String getTGValue(ToggleGroup g)
    {
    	String[] temp = g.getSelectedToggle().toString().split("[']+");
    	return temp[temp.length-1];
    }
    private boolean checkPI()
    {
    	if(Dob.getValue() != null && Dob.getValue().compareTo(LocalDate.now()) > 0) return false;
    	if(gender.getSelectedToggle() != null)
    		ex.bGender = new MyButton(getTGValue(gender), true);
    	else ex.bGender = new MyButton("", false);
    	
    	if(disabled.getSelectedToggle() != null)
    		ex.bPhyDisabled = new MyButton(getTGValue(disabled), true);
    	else ex.bPhyDisabled = new MyButton("", false);
    	
    	String str = ""; 
    	if(dob.getSelectedToggle() != null && Dob.getValue() ==  null) return false;
    	if(dob.getSelectedToggle() == null && Dob.getValue() !=  null) return false;
    	if(Dob.getValue() != null) str =  Dob.getValue().toString();
    	if(dob.getSelectedToggle() != null)
    		ex.bDOB = new MyButton(str, getTGValue(dob), true);
    	else ex.bDOB = new MyButton(str, false);
    	return true;
    }
    //private boolean checkstr(String str) { return !str.equals("");}
}
