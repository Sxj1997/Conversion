import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class convertor extends Application{
    public static void main(String args[]){
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("convertor.fxml"));
        Scene scene=new Scene(root);
        stage.setTitle("base64转换器");
        stage.setScene(scene);
        stage.show();
    }
}
