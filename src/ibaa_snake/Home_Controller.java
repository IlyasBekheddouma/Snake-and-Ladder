package ibaa_snake;

//<editor-fold defaultstate="collapsed" desc=" Import ">
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
    //</editor-fold>

public class Home_Controller implements Initializable {
private String etat1="droite",etat2="droite";

    
    @Override
    public void initialize(URL url,ResourceBundle rb) {
    iv0.setImage(new Image("/icone/dep.jpg"));
    iv1.setImage(new Image("/icone/superball.png"));
    iv2.setImage(new Image("/icone/pokeball.png"));
    iv3.setImage(new Image("/icone/D1.png"));
    II.setImage(new Image("/icone/icons8-cerclé-i-filled-50.png"));
    IB.setImage(new Image("/icone/icons8-xbox-b-filled-50.png"));
    I2.setImage(new Image("/icone/icons8-cerclé-2-filled-50.png"));
    IA.setImage(new Image("/icone/icons8-apple-app-store-filled-50.png"));  
    Tooltip.install(iv1,new Tooltip("Player 1"));
    Tooltip.install(iv2,new Tooltip("Player 2"));
    }    
    
    public void Layout(ImageView iv,int a, int b) {
    iv.setLayoutX(a);
    iv.setLayoutY(b);
    }
      
    public void showAlert(String A,String Z,String E) {
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(getClass().getResourceAsStream("/icone/epic.png")));
    alert.setTitle(A);
    alert.setHeaderText(Z);
    alert.setContentText(E);
    alert.show();
    }

    public void Pos(int i) {

        switch(i) {
            case 1: {
                
                if(iv1.getLayoutX()==315&&iv1.getLayoutY()==635) {
                Layout(iv1,175,285);
                etat1="gauche";
                } else if(iv1.getLayoutX()==455&&iv1.getLayoutY()==565) {
                Layout(iv1,595,355);
                etat1="droite";
                } else if(iv1.getLayoutX()==175&&iv1.getLayoutY()==425) Layout(iv1,35,565);                
                else if(iv1.getLayoutX()==665&&iv1.getLayoutY()==285) {
                Layout(iv1,665,635);
                etat1="droite";
                } else if(iv1.getLayoutX()==525&&iv1.getLayoutY()==285) Layout(iv1,595,145);
                else if(iv1.getLayoutX()==245&&iv1.getLayoutY()==215) Layout(iv1,175,75);
                else if(iv1.getLayoutX()==315&&iv1.getLayoutY()==145) Layout(iv1,455,285);
                else if(iv1.getLayoutX()==595&&iv1.getLayoutY()==5) Layout(iv1,525,145);
                else if(iv1.getLayoutX()==175&&iv1.getLayoutY()==5) {
                Layout(iv1,35,215);
                etat1="droite";
                }
            }break;
            case 2: {
                
                if(iv2.getLayoutX()==285&&iv2.getLayoutY()==665) {
                Layout(iv2,145,315);
                etat2="gauche";
                } else if(iv2.getLayoutX()==425&&iv2.getLayoutY()==595) {
                Layout(iv2,565,385);
                etat2="droite";
                } else if(iv2.getLayoutX()==175&&iv2.getLayoutY()==455) Layout(iv2,5,595);
                else if(iv2.getLayoutX()==635&&iv2.getLayoutY()==315) {
                Layout(iv2,635,665);
                etat2="droite";
                } else if(iv2.getLayoutX()==495&&iv2.getLayoutY()==315) Layout(iv2,565,175);
                else if(iv2.getLayoutX()==215&&iv2.getLayoutY()==245) Layout(iv2,145,105);
                else if(iv2.getLayoutX()==285&&iv2.getLayoutY()==175) Layout(iv2,425,315);
                else if(iv2.getLayoutX()==565&&iv2.getLayoutY()==35) Layout(iv2,495,175);
                else if(iv2.getLayoutX()==145&&iv2.getLayoutY()==35) {
                Layout(iv2,5,245);
                etat1="droite";
                }
            }break;
        }
    }
    
    
    @FXML
    private void turn() {
    int y=new Random().nextInt(6)+1,machay=0; 
    iv3.setImage(new Image("/icone/D"+y+".png"));

        if(bt.getText().equals("Player 1 : Turn")) {
        
            if(etat1.equals("droite")) {
            machay=(int) (iv1.getLayoutX()+y*70);
            
                if(machay<=665) iv1.setLayoutX(machay);
                else {
                iv1.setLayoutY(iv1.getLayoutY()-70);
                iv1.setLayoutX(665-(machay-665)+70);
                etat1="gauche";
                }
            } else {
            machay=(int) (iv1.getLayoutX()-y*70);
            
                if(machay>=35) iv1.setLayoutX(machay);
                else {
                    
                    if(iv1.getLayoutY()==5) {
                    iv1.setLayoutX(35);
                    bt.setDisable(true);
                    showAlert("Message","Game Over ...","Player 1 Winner !");
                    } else {
                    iv1.setLayoutY(iv1.getLayoutY()-70);
                    iv1.setLayoutX(-machay);
                    etat1="droite";
                    }
                }            
            }
            Pos(1);
            bt.setText("Player 2 : Turn");
        } else {
            
            if(etat2.equals("droite")) {
            machay=(int) (iv2.getLayoutX()+y*70);
            
                if(machay<=635) iv2.setLayoutX(machay);
                else {
                iv2.setLayoutY(iv2.getLayoutY()-70);
                iv2.setLayoutX(635-(machay-635)+70);
                etat2="gauche";
                }
            } else {
            machay=(int) (iv2.getLayoutX()-y*70);

                if(machay>=5) iv2.setLayoutX(machay);
                else {

                    if(iv2.getLayoutY()==35) {
                    iv2.setLayoutX(5);
                    bt.setDisable(true);
                    showAlert("Message","Game Over ...","Player 2 Winner !");
                    } else {
                    iv2.setLayoutY(iv2.getLayoutY()-70);
                    iv2.setLayoutX(-machay+10-70);
                    etat2="droite";
                    }
                }            
            }
            Pos(2);
            bt.setText("Player 1 : Turn");            
        }
    }
        
    @FXML
    private void New_Game() {
    bt.setText("Player 1 : Turn");
    iv3.setImage(new Image("/icone/D1.png"));
    Layout(iv1,35,635);
    Layout(iv2,5,665);
    etat1=etat2="droite";
    bt.setDisable(false);
    }
       
    //<editor-fold defaultstate="collapsed" desc=" FX Variables Declaration ">
    @FXML private ImageView iv0,iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,II,IB,I2,IA,iv13,iv14,iv15,wingo,winca,winwo,wine;
    @FXML private Button bt;
    //</editor-fold>
    
}
