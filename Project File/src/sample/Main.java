package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class Main extends Application implements EventHandler<ActionEvent>{

    Button login,register,login_button,rsa_button,el_button,  Ciper_en_button,  Ciper_de_button,reg_submit,rsa_en_button,rsa_de_button,final_back_button, rsa_back_button,login_back_button,EL_gamal_en_button,EL_gamal_de_button ;
    TextField login_name,login_password,reg_name,reg_password;
    String filePath,user;

    Stage window;
    Scene start_scr,login_scr,register_scr,final_scr;
    Desktop desktop ;
    FileChooser fileChooser;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("FIle Lock!");

        // #################    Start Screen Start   ################## //
        login = new Button();
        login.setText("  Login  ");
        login.setOnAction(this);

        register = new Button();
        register.setText("Register");
        register.setOnAction(this);

        Text text = new Text("FIle Lock!");
        text.setFont(Font.font(null, FontWeight.BOLD, 15));
        text.setFill(Color.CRIMSON);
        text.setX(20);
        text.setY(40);

        VBox vBox = new VBox(15);
        vBox.getChildren().addAll(text,login,register);
        start_scr = new Scene(vBox,300,300);
        // #################    Start Screen End   ################## //


        // #################    Login Screen Start   ################## //
        Label label_login = new Label("Login");

        GridPane grid_login = new GridPane();
        grid_login.setPadding(new Insets(10, 10, 10, 10));
        grid_login.setVgap(5);
        grid_login.setHgap(5);

        // UserName
        login_name = new TextField();
        login_name.setPromptText("User Name");
        login_name.getText();
        GridPane.setConstraints(login_name, 0, 0);
        grid_login.getChildren().add(login_name);

        // Password
        login_password = new TextField();
        login_password.setPromptText("Password");
        login_password.setPrefColumnCount(8);
        login_password.getText();
        GridPane.setConstraints(login_password, 0, 1);
        grid_login.getChildren().add(login_password);

        // Login button
        login_button = new Button("Login");
        GridPane.setConstraints(login_button, 1, 0);
        grid_login.getChildren().add(login_button);
        login_button.setOnAction(this);

        // back button
        login_back_button = new Button(" Back ");
        GridPane.setConstraints(login_back_button , 1, 3);
        grid_login.getChildren().add(login_back_button );
        login_back_button.setOnAction(this);


        VBox vBox_login = new VBox(15);
        vBox_login.getChildren().addAll(label_login,login_name,login_password,login_button,login_back_button);
        login_scr = new Scene(vBox_login,300,300);

        // #################    Login Screen End   ################## //


        // #################    Registration Screen Start   ################## //
        Label label_reg = new Label("Registration");

        GridPane grid_reg = new GridPane();
        grid_reg.setPadding(new Insets(10, 10, 10, 10));
        grid_reg.setVgap(5);
        grid_reg.setHgap(5);

        // UserName
        reg_name = new TextField();
        reg_name.setPromptText("User Name");
        GridPane.setConstraints(reg_name, 0, 0);
        grid_reg.getChildren().add(reg_name);

        // Password
        reg_password = new TextField();
        reg_password.setPromptText("Password");
        reg_password.setPrefColumnCount(8);
        GridPane.setConstraints(reg_password, 0, 1);
        grid_reg.getChildren().add(reg_password);

        // RSA button
        reg_submit = new Button("Submit");
        GridPane.setConstraints(reg_submit, 1, 2);
        grid_reg.getChildren().add(reg_submit);
        reg_submit.setOnAction(this);

        // back button
        rsa_back_button = new Button("  Back  ");
        GridPane.setConstraints(rsa_back_button , 1, 3);
        grid_reg.getChildren().add(rsa_back_button );
        rsa_back_button.setOnAction(this);

        VBox vBox_reg = new VBox(15);
        vBox_reg.getChildren().addAll(label_reg,reg_name,reg_password,reg_submit, rsa_back_button);
        register_scr = new Scene(vBox_reg,300,300);

        // #################    Registration Screen End   ################## //



        // #################    Final Screen Start   ################## //
        Label label_final = new Label("FIle Lock!");
          desktop = Desktop.getDesktop();
           fileChooser = new FileChooser();

        final Button openButton = new Button("Open a File");
        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        File file = fileChooser.showOpenDialog(window);
                        filePath = file.getAbsolutePath();
                    }
                });
        GridPane.setConstraints(openButton, 0, 0);

        GridPane grid_final = new GridPane();
        grid_final.setPadding(new Insets(10, 10, 10, 10));
        grid_final.setVgap(5);
        grid_final.setHgap(5);

        // RSA button
        rsa_en_button = new Button("RSA Encryption");
        GridPane.setConstraints(rsa_en_button, 1, 0);
        grid_final.getChildren().add(rsa_en_button);
        rsa_en_button.setOnAction(this);

        // RSA button
        rsa_de_button = new Button("RSA Decryption");
        GridPane.setConstraints(rsa_de_button, 2, 0);
        grid_final.getChildren().add(rsa_de_button);
        rsa_de_button.setOnAction(this);
        // back button
        final_back_button = new Button("  Back  ");
        GridPane.setConstraints(final_back_button , 1, 3);
        grid_final.getChildren().add(final_back_button);
        final_back_button.setOnAction(this);

        // Ciper encrytion
        Ciper_en_button = new Button("Ciper Encryption");
        GridPane.setConstraints(  Ciper_en_button, 1, 0);
        grid_final.getChildren().add(  Ciper_en_button);
        Ciper_en_button.setOnAction(this);

        // Ciper Decryption button
        Ciper_de_button = new Button("Ciper Decryption");
        GridPane.setConstraints(Ciper_de_button, 1, 0);
        grid_final.getChildren().add(Ciper_de_button);
        Ciper_de_button.setOnAction(this);

        VBox vBox_final = new VBox(15);
        vBox_final.getChildren().addAll(openButton,rsa_en_button,rsa_de_button,  Ciper_en_button,  Ciper_de_button,final_back_button);
        final_scr = new Scene(vBox_final,300,300);
        // #################    Final Screen End   ################## //

        window.setScene(start_scr);
        window.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == login){
            rsa r = new rsa();
            window.setScene(login_scr);
        }
        else if (event.getSource() == register){
            window.setScene(register_scr);
        }
        else if (event.getSource() == login_button){
            database db = new database();
            if (db.loginCheck(login_name.getText(),login_password.getText())){
                user = login_name.getText();
                window.setScene(final_scr);
            } else {
                System.out.print("Username or Password doesn't Match");
            }
        }
        else if (event.getSource() == reg_submit){
            String e,d,p,q;
            rsa r = new rsa();
            r.calculateParameter();
            e = r.getEF();
            d = r.getD();
            p = r.getP();
            q = r.getQ();
            //for Ciper key
            Random ran = new Random();
            int random = ran.nextInt(60);
            String key = String.valueOf(random);
            database db = new database();
            db.registration(reg_name.getText(),reg_password.getText(),e,d,p,q,key);
        }
        else if (event.getSource() == rsa_en_button){
            rsa r = new rsa();
            try {
                r.encrypt(filePath,user);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (event.getSource() == rsa_de_button){
            rsa r = new rsa();
            try {
                r.decrypt(filePath,user);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (event.getSource() == Ciper_en_button){
            cisher c = new cisher();
            try {
                c.ciper_encrypt(filePath,user);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (event.getSource() == Ciper_de_button){
            cisher c = new cisher();
            try {
                c.ciper_decryption(filePath,user);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else if(event.getSource()== rsa_back_button){
            window.setScene(start_scr);
        }
        else if(event.getSource()== login_back_button){
            window.setScene(start_scr);
        }
        else if(event.getSource()== final_back_button){
            window.setScene(start_scr);
        }


    }
}
