package com.main;


import data.Admin;
import data.Student;
import data.Staff;
import exception.custom.IllegalAdminAccess;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class LibrarySystem extends Application {

    public static String NIM;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Admin adminObj = new Admin();
        Student studentObj = new Student();
        Staff staffObj = new Staff();

        primaryStage.setTitle("System Library");
        primaryStage.setFullScreen(true);

        //Label
        Label sceneTitle    = new Label("Library digital");
        Label sceneTitle1    = new Label("login Admin");
        Label sceneTitle2    = new Label("Login Staff");
        Label sceneTitle3    = new Label("Login Student");
        Label loginTitle    = new Label("Pilih Login");

        Label usernameLabel = new Label("Username");
        Label NIMLabel      = new Label("NIM");
        Label IDStaffLabel  = new Label("ID Staff");
        Label passwordLabel = new Label("Password");

        //Notification label
       Label errorLoginMessage   = new Label("Pengguna tidak ditemukan");

        //Field
        TextField usernameField     = new TextField();
        PasswordField passwordField = new PasswordField();

        //Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        sceneTitle1.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        sceneTitle2.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        sceneTitle3.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        usernameLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        passwordLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        errorLoginMessage.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 12));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");
        sceneTitle1.setStyle("-fx-text-fill: #A91D3A;");
        sceneTitle2.setStyle("-fx-text-fill: #A91D3A;");
        sceneTitle3.setStyle("-fx-text-fill: #A91D3A;");
        errorLoginMessage.setStyle("-fx-text-fill: #FF1E1E;");

        //Font visible Settings
        errorLoginMessage.setVisible(false);

        //Button
        Button loginAdminButtom = new Button("Login");
        Button loginStaffButtom = new Button("Login");
        Button loginStudentButtom = new Button("Login");
        Button loginButtom = new Button("Login");
        Button loginAsStudentButton = new Button("Login As Student");
        Button loginAsStaffButton = new Button("Login As Staff");
        Button loginAsAdminButton = new Button("Login As Admin");
        Button backButton = new Button("Back");

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle, 0,0);

        grid.add(loginTitle, 0,1);
        grid.add(loginAsAdminButton, 0,2);
        grid.add(loginAsStaffButton, 0,3);
        grid.add(loginAsStudentButton, 0,4);
//        grid.add(usernameLabel, 0,1);
//        grid.add(passwordLabel, 0,2);
//        grid.add(errorLoginMessage, 0,3);
//
//        grid.add(usernameField, 1,1);
//        grid.add(passwordField, 1,2);

//        grid.add(loginButtom, 1,3);

        grid.setVgap(10);
        grid.setHgap(5);

        Image bgimage = new Image("file:src/main/java/Image/Perpus.png");
        ImageView bgimageview = new ImageView(bgimage);
        StackPane stackpane = new StackPane();
        stackpane.getChildren().addAll(bgimageview,grid);

        //Create Window
        Scene scene =  new Scene(stackpane,1320,720);
        primaryStage.setScene(scene);
        primaryStage.show();



        //Action Button
        loginAsAdminButton.setOnAction(event ->{
            grid.getChildren().clear();

            grid.add(sceneTitle1, 0,0);
            grid.add(usernameLabel, 0,1);
            grid.add(passwordLabel, 0,2);
            grid.add(errorLoginMessage, 0,3);

            grid.add(usernameField, 1,1);
            grid.add(passwordField, 1,2);
            grid.add(loginAdminButtom, 1,3);
            grid.add(backButton, 1,4);




        });

        loginAsStaffButton.setOnAction(event ->{
            grid.getChildren().clear();

            grid.add(sceneTitle2, 0,0);
            grid.add(IDStaffLabel, 0,1);
            grid.add(passwordLabel, 0,2);
            grid.add(errorLoginMessage, 0,3);

            grid.add(usernameField, 1,1);
            grid.add(passwordField, 1,2);
            grid.add(loginStaffButtom, 1,3);
            grid.add(backButton, 2,3);

        });

        loginAsStudentButton.setOnAction(event ->{
            grid.getChildren().clear();

            grid.add(sceneTitle3, 0,0);
            grid.add(NIMLabel, 0,1);
            grid.add(errorLoginMessage, 0,3);

            grid.add(usernameField, 1,1);
            grid.add(loginStudentButtom, 1,3);
            grid.add(backButton, 2,3);

        });

        backButton.setOnAction(event -> {
            start(primaryStage);
        });

        loginStudentButtom.setOnAction(event ->{
            if (usernameField.getText().length() == 15){
                try {
                    if(studentObj.isStudents(usernameField)){
                        errorLoginMessage.setVisible(false);

                        studentObj.isStudents(usernameField);

                    }else{
                        errorLoginMessage.setVisible(true);
                    }
                } catch (IllegalAdminAccess pesanError) {
                    errorLoginMessage.setText(pesanError.getMessage());
                    errorLoginMessage.setVisible(true);
                }
            }
        });

        loginStaffButtom.setOnAction(event ->{
            if (passwordField.getText().length() > 7){
                try {
                    if(staffObj.isStaff(usernameField,passwordField)){
                        errorLoginMessage.setVisible(false);

                        studentObj.isStudents(usernameField);

                    }else{
                        errorLoginMessage.setVisible(true);
                    }
                } catch (IllegalAdminAccess pesanError) {
                    errorLoginMessage.setText(pesanError.getMessage());
                    errorLoginMessage.setVisible(true);
                }
            }
        });

        loginAdminButtom.setOnAction(event ->{
            if(usernameField.getText().equals(Admin.adminusername) && passwordField.getText().equals(Admin.adminpassword)) {


                adminObj.menu();
                primaryStage.close();

            }
            else{
                errorLoginMessage.setVisible(true);
            }
        });

    }
}