package application;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class Control {
	public static Scene scene;
	TextField Email, Name, ENum;
	RadioButton genm, genf, disy, disn, dobBefore, dobOn, dobAfter;
	private boolean checkstr(String str) { return !str.equals("");}
	private boolean checkPI()
	{
		return checkstr(Email.getText()) && checkstr(Name.getText()) && checkstr(ENum.getText())
				&& (genf.isSelected() || genm.isSelected()) && (disy.isSelected() || disn.isSelected())
				&& (dobBefore.isSelected() || dobOn.isSelected() || dobAfter.isSelected());
	}
	@FXML private void check()
	{
		Email = (TextField) scene.lookup("#Email");
		Name = (TextField) scene.lookup("#Name");
		ENum = (TextField) scene.lookup("#ENum");
		genm = (RadioButton) scene.lookup("#genderm");
		genf = (RadioButton) scene.lookup("#genderf");
		disy = (RadioButton) scene.lookup("#disyes");
		disn = (RadioButton) scene.lookup("#disno");
		dobBefore = (RadioButton) scene.lookup("#dobb");
		dobOn = (RadioButton) scene.lookup("#dobo");
		dobAfter = (RadioButton) scene.lookup("#doba");
		DatePicker dob = (DatePicker) scene.lookup("#Dob_select");
		LocalDate dob_date = dob.getValue();
		System.out.println(checkPI());
	}
	
}
