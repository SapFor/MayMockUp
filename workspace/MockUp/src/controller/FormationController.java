package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class FormationController implements Initializable{

	//Liste des UV accessibles au candidat
	@FXML
	private ListView<String> UVList;

	
	//Boutons radio pour trier selon apprenant/formateur et groupe pour n'en avoir qu'un seuld e sélectionné
	@FXML
	private RadioButton boutonApprenant;

	@FXML
	private RadioButton boutonFormateur;
	@FXML
	private ToggleGroup toggleGroupe = new ToggleGroup();
	
	@FXML
	private TextArea UVDesc;

	@FXML
	private ListView<String> SessionList;

	@FXML
	private TextArea InfoSession;


	@FXML
	private Button candidaterBt;

	@FXML
	private Button retirerBt;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ArrayList<String> ListeUVList = new  ArrayList<String>();
		ListeUVList.add("INC1");
		ListeUVList.add("INC2");
		ListeUVList.add("DEV1");
		ListeUVList.add("OC1");
		

		ObservableList<String> ListeUV = FXCollections.observableArrayList(ListeUVList);

		UVList.setItems(ListeUV);
	}


		//UVColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

	

	@FXML private void btnFormation1Clicked(ActionEvent event){
		System.out.println("Button Formation Clicked");
	}



	@FXML
	void clicUV(Event event) {

		//String items =UVList.getSelectionModel().getSelectedItem();
		//L'affichage de la descritpion de l'UV
		String description= new String("la description de l'UV");
		UVDesc.setText(description);

		//pour ne pas modifier le text area dans le programme
		UVDesc.setEditable(false);





		String UVclic = UVList.getSelectionModel().getSelectedItem();

		if (UVclic=="INC1"){
			//l'affichage des sessions 
			ArrayList<String> SessionUVList = new  ArrayList<String>();
			SessionUVList.add("Rennes");
			SessionUVList.add("St Malo");
			SessionUVList.add("Redon");
			ObservableList<String> SessionUV = FXCollections.observableArrayList(SessionUVList);

			SessionList.setItems(SessionUV);}
		else {

			ArrayList<String> SessionUVList = new  ArrayList<String>();
			SessionUVList.add("Nantes");
			SessionUVList.add("Laval");
			SessionUVList.add("Reims");
			ObservableList<String> SessionUV = FXCollections.observableArrayList(SessionUVList);

			SessionList.setItems(SessionUV);

		}

	}


	@FXML
	
    void clicSession(Event event) {
    	
    	//String items =UVList.getSelectionModel().getSelectedItem();
    	//L'affichage des infos détaillées de la session 
    	String infos= new String("les infos détaillées de la session"+
    							"\n"+"La session se déroule à:...");
    	InfoSession.setText(infos);
    	
    	//pour ne pas modifier le text area dans le programme
    	InfoSession.setEditable(false);
		candidaterBt.setVisible(true);

    }

	/**
	 * Affichage des UV pour le bouton apprenant sélectionné
	 * @param event
	 */
	@FXML
	private void boutonApprenantClicked(ActionEvent event){
		ArrayList<String> ListeUVList = new  ArrayList<String>();
		ListeUVList.add("INC1");
		ListeUVList.add("INC2");
		ListeUVList.add("DEV1");
		ListeUVList.add("OC1");
		
		ObservableList<String> ListeUV = FXCollections.observableArrayList(ListeUVList);
		
		UVList.setItems(ListeUV);
	}
	
	/**
	 * Affichage des UV pour le bouton formateur sélectionné
	 * @param event
	 */
	@FXML
	private void boutonFormateurClicked(ActionEvent event){
		ArrayList<String> ListeUVList = new  ArrayList<String>();
		ListeUVList.add("FORM1");
		ListeUVList.add("FORM2");

		ObservableList<String> ListeUV = FXCollections.observableArrayList(ListeUVList);
		
		UVList.setItems(ListeUV);
	}
	

	@FXML
	void clicCandidater(Event event) {
		candidaterBt.setVisible(false);
		retirerBt.setVisible(true);

	}
	
	
	@FXML
	void clicRetirer(Event event) {
		candidaterBt.setVisible(true);
		retirerBt.setVisible(false);

	}


}