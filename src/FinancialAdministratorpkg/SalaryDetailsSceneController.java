
package FinancialAdministratorpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class SalaryDetailsSceneController implements Initializable {

    @FXML
    private TableView<Salary> salaryTableView;
    @FXML
    private TableColumn<Salary, String> monthColumn;
    @FXML
    private TableColumn<Salary, Double> baseSalaryColumn;
    @FXML
    private TableColumn<Salary, Double> bonusColumn;
    @FXML
    private TableColumn<Salary, Double> totalColumn;
    @FXML
    private TextField employeeIdTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("month"));
        baseSalaryColumn.setCellValueFactory(new PropertyValueFactory<Salary, Double>("baseSalary"));
        bonusColumn.setCellValueFactory(new PropertyValueFactory<Salary, Double>("bonus"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<Salary, Double>("totalPay"));         
    }    

    @FXML
    private void seeDetailsButtonOnClick(ActionEvent event) {
        int employeeId = Integer.parseInt(employeeIdTextField.getText());
        ObservableList<Salary> salaryList = FXCollections.observableArrayList();
        salaryList.add(Salary.getSalaryInstance(employeeId));
        salaryTableView.setItems(salaryList);
    }
    
}
