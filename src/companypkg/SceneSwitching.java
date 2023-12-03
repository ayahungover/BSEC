package mainpkg;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneSwitching {
    Stage newStage = new Stage();
    Node sceneNode;
    
    public void loadScene(String fxmlFileName){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Scene newScene = new Scene(root);
            newStage.setScene(newScene);
            newStage.show();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
    }
    
    public Node getSceneRoot(String fxmlFileName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            return root;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void switchScene(String fxmlFileName, Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
        Scene nextScene = new Scene(root);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(nextScene);
        stg.show();
    }
    
    public void closeScene(String fxmlFileName, Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
        Scene thisScene = new Scene(root);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(thisScene);
        stg.close();
    }
}