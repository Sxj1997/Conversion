
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.ResourceBundle;

public class action implements Initializable {
    //@FXML
    public String filePath;
    public Stage stage;
    @FXML
    public Button chooseButton;
    @FXML
    public Button startButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // don't really need to do anything here

    }


    public void chooseAction(ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("View Pictures");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
//        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);
        filePath=file.getAbsolutePath();
        System.out.println(filePath);
    }

    public void startButton(ActionEvent actionEvent) throws Exception{
        byte[] b = Files.readAllBytes(Paths.get(filePath));
        String file64= Base64.getEncoder().encodeToString(b);
        String path64=filePath+".txt";
        Files.write(Paths.get(path64), Base64.getDecoder().decode(file64), StandardOpenOption.CREATE);
    }
}
