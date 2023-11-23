/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mainpkg;

import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public interface PopUp {
    public static void Message(String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText(message);
        a.showAndWait();
    }
    
}
