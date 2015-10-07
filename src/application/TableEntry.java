//@author Satyam Kumar 2014096
package application;

import javafx.application.HostServices;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class TableEntry {

	SimpleStringProperty EnrollmentID;
	SimpleStringProperty Name;
	Button Link, CVLink, SOPLink;
	
	String path;
	static HostServices host;
	public TableEntry(String EnrollmentID, String Name, String Link, String CVLink, String SOPLink)
	{
		this.EnrollmentID=new SimpleStringProperty(EnrollmentID);
		this.Name=new SimpleStringProperty(Name);
		path = Link;
		this.Link=new Button("View Data");
		this.CVLink=new Button("View CV");
		this.SOPLink=new Button("View SOP");
		this.Link.setTextFill(Color.BLUE);
		this.CVLink.setTextFill(Color.BLUE);
		this.SOPLink.setTextFill(Color.BLUE);
		this.Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                host.showDocument(Link);
            }
        });
		this.CVLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                host.showDocument(CVLink);
            }
        });
		this.SOPLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                host.showDocument(SOPLink);
            }
        });
         
	}

	public String getEnrollmentID(){ return EnrollmentID.get(); }

	public String getName() { return Name.get(); }

	public void setEnrollmentID(String EnrollmentID) { this.EnrollmentID.set(EnrollmentID); }

	public void setName(String Name) { this.Name.set(Name); }
	
	public Button getLink() { return Link; }
	
	public void setLink(Button Link) { this.Link = Link; }
	public Button getCVLink() { return CVLink; }
	
	public void setCVLink(Button CVLink) { this.CVLink = CVLink; }
	public Button getSOPLink() { return SOPLink; }
	
	public void setSOPLink(Button SOPLink) { this.SOPLink = SOPLink; }
}
