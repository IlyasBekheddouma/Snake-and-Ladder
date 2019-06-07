package ibaa_snake;

//<editor-fold defaultstate="collapsed" desc=" Import ">
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//</editor-fold>

public class A_Main_C extends Application {

    
    @Override
    public void start(Stage st) throws Exception {

        try {
        st.setScene(new Scene(FXMLLoader.load(getClass().getResource("Home_FXML.fxml")),980,690));
        } catch(Exception ex) {
        ex.printStackTrace();
        }
        st.setTitle("Snake And Ladder");
        st.setResizable(false);
        st.getIcons().add(new Image(getClass().getResourceAsStream("/icone/icon.jpg")));
        st.show();
    }
    
    public static void main(String[] args) {
    launch(args);
    }
    
}
