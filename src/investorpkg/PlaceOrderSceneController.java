package investorpkg;

import Brokerpkg.Stockbroker;
import Stockpkg.Stock;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.AppendableObjectOutputStream;
import mainpkg.PopUp;

public class PlaceOrderSceneController implements Initializable {

    @FXML
    private TextArea oderDetailsTextArea;

    private Investor i;
    private Stock s;
    private String bill = null;
    @FXML
    private TableColumn<Stockbroker, Integer> idTableColumn;
    @FXML
    private TableColumn<Stockbroker, String> nameTableColumn;
    @FXML
    private TableColumn<Stockbroker, LocalDate> dojTableColumn;
    @FXML
    private TableColumn<Stockbroker, String> emailTableView;
    @FXML
    private TableColumn<Stockbroker, String> contactTableView;
    @FXML
    private TableView<Stockbroker> tableView;

    public void data(Investor i, Stock s) {
        this.i = i;
        this.s = s;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("name"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, Integer>("id"));
        emailTableView.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("email"));
        dojTableColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, LocalDate>("doj"));
        contactTableView.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("contact"));

        ObjectInputStream ois = null;
        ObservableList<Stockbroker> stockbrokerList = FXCollections.observableArrayList();
        try {
            Stockbroker ss;
            ois = new ObjectInputStream(new FileInputStream("Stockbroker.bin"));

            while (true) {
                ss = (Stockbroker) ois.readObject();
                stockbrokerList.add(ss);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }

        tableView.setItems(stockbrokerList);

    }

    @FXML
    private void placeOrderButtonOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Stockbroker s1 = tableView.getSelectionModel().getSelectedItem();
        if (s1 == null) {
            PopUp.Message("Select A Broker First");
        } else {
            PlaceOrder p = new PlaceOrder(s1.getId(), i.getId(), s.getCode(), s.getTitle(), s.getNewPrice());
            p.placeOrder(p);

            bill
                    = "Investor ID: " + i.getId()
                    + "\nInvestor Name: " + i.getName()
                    + "\nInvestor Contact Number: " + i.getContact()
                    + "\nInvestor Email: " + i.getEmail()
                    + "\nStock Code: " + s.getCode()
                    + "\nStock Title: " + s.getTitle()
                    + "\nStock Price: " + s.getNewPrice() + " BDT"
                    + "\nStock Purchase Date:\t\t" + LocalDate.now();

            oderDetailsTextArea.setText(bill);

            PopUp.Message("Your order placed successfully");

        }

    }

}
