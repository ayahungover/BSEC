/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FinancialAdministratorpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ReportsSceneController implements Initializable {

    @FXML
    private TextField reportSubjectTextField;
    @FXML
    private TextArea writeReportTextArea;
    @FXML
    private ComboBox<String> selectSubjectComboBox;
    @FXML
    private TextArea viewReportTextArea;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;

        try{
            Report r;
            ois = new ObjectInputStream(new FileInputStream("Report.bin"));
            
            while(true){
                r = (Report) ois.readObject();
                selectSubjectComboBox.getItems().addAll(r.subject);
                }
                
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
    }    

    @FXML
    private void saveReportButtonOnClick(ActionEvent event) {
        String subject = reportSubjectTextField.getText();
        String report = writeReportTextArea.getText();
        FinancialAdministrator.CreateReport(subject, report);
        selectSubjectComboBox.getItems().addAll(subject);  
    }

    @FXML
    private void findReportButtonOnClick(ActionEvent event) throws IOException {
        viewReportTextArea.setText("");
        String findSub = selectSubjectComboBox.getValue();
        String Data = FinancialAdministrator.SearchReport(findSub);
        viewReportTextArea.setText(Data);
    }
    
}
