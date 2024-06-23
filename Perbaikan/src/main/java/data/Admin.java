package data;

import com.main.LibrarySystem;
import util.iMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;


public class Admin extends User implements iMenu {

    //=================================== ATRIBUT =====================================
    public static String adminusername = "admin";
    public static String adminpassword = "admin";

//=================================== Main & Start Method ==================================



//======================================= MENU Method =======================================
    @Override
    public void menu(){
        Stage adminMenuStage = new Stage();
        adminMenuStage.setTitle("System Librarry - Admin Menu");
        adminMenuStage.setFullScreen(true);

        //Label
        Label sceneTitle = new Label("Menu Admin");

        //Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        //Button
        Button addStudentButton     = new Button("Tambah Mahasiswa");
        Button addStaffButton     = new Button("Tambah Staff");
        Button displayStudentButton = new Button("Daftar Mahasiswa");
        Button displayStaffButton = new Button("Daftar Staff");
        Button addBookButton        = new Button("Tambah Buku");
        Button logoutButton         = new Button("Logout");

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle,0,1);

        grid.add(addStudentButton, 2,0);
        grid.add(addStaffButton, 2,1);
        grid.add(displayStudentButton, 2,2);
        grid.add(displayStaffButton, 2,3);
        grid.add(addBookButton, 2,4);
        grid.add(logoutButton,2,5);

        grid.setVgap(10);
        grid.setHgap(6);

        Scene scene = new Scene(grid, 1360, 720);
        adminMenuStage.setScene(scene);
        adminMenuStage.show();

        //Action Button
        addStudentButton.setOnAction(event -> {
            addstudent();
            adminMenuStage.close();
        });
        addStaffButton.setOnAction(event -> {
            addstaff();
            adminMenuStage.close();
        });

        displayStudentButton.setOnAction(event -> {
            displaystudent();
        });
        displayStaffButton.setOnAction(event -> {
            displaystaff();
        });

        addBookButton.setOnAction(event -> {
            inputBook();
            adminMenuStage.close();
        });

        logoutButton.setOnAction(event -> {
            LibrarySystem librarySystemObj = new LibrarySystem();
            librarySystemObj.start(new Stage());
            adminMenuStage.close();
        });

    }

//===================================== Other Method =======================================
    public void addstudent() {

        // Membuat form baru
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Tambah Mahasiswa");


        //Label
        Label sceneTitle    = new Label("Tambah Mahasiswa");
        Label nameLabel     = new Label("Nama");
        Label nimLabel      = new Label("NIM");
        Label fakultasLabel = new Label("Fakultas");
        Label jurusanLabel  = new Label("Jurusan");

        //Notification Label
        Label sumbitFailed = new Label("NIM harus 15 digit!");
        sumbitFailed.setVisible(false);


        //Field
        TextField nameField     = new TextField();
        TextField nimField      = new TextField();
        TextField fakultasField = new TextField();
        TextField jurusanField  = new TextField();

        //Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        nameLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        nimLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        fakultasLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        jurusanLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");
        sumbitFailed.setStyle("-fx-text-fill: #FF1E1E;");

        //Button
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(sceneTitle, 0,0);

        grid.add(nameLabel, 0,1);
        grid.add(nimLabel, 0,2);
        grid.add(fakultasLabel, 0,3);
        grid.add(jurusanLabel, 0,4);

        grid.add(nameField, 1,1);
        grid.add(nimField, 1,2);
        grid.add(fakultasField, 1,3);
        grid.add(jurusanField, 1,4);

        grid.add(submitButton,1,5);

        grid.add(sumbitFailed, 0,5);

        grid.setVgap(10);
        grid.setHgap(5);

        Scene scene = new Scene(grid, 600, 400);
        addStudentStage.setScene(scene);
        addStudentStage.show();

        //Action Button
        backButton.setOnAction(event -> {
            menu();
        });
        submitButton.setOnAction(event -> {
            if (nimField.getText().length() == 15) {
                Admin adminObj = new Admin();

                Student.arr_userStudent.add(new Student.UserStudent(nameField.getText(), nimField.getText(), fakultasField.getText(), jurusanField.getText()));
                adminObj.menu();
                addStudentStage.close();

            } else {
                sumbitFailed.setVisible(true);
            }
        });

    }
    public void addstaff() {

        // Membuat form baru
        Stage addStaffStage = new Stage();
        addStaffStage.setTitle("Tambah Staff");


        //Label
        Label sceneTitle    = new Label("Tambah Staff");
        Label nameLabel     = new Label("Nama");
        Label IDLabel      = new Label("ID");
        Label passwordLabel = new Label("Password");

        //Notification Label
        Label sumbitFailed = new Label("Password harus 8 digit!");
        sumbitFailed.setVisible(false);


        //Field
        TextField nameField     = new TextField();
        TextField IDField      = new TextField();
        TextField PasswordField = new TextField();

        //Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        nameLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        IDLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        passwordLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");
        sumbitFailed.setStyle("-fx-text-fill: #FF1E1E;");

        //Button
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(sceneTitle, 0,0);

        grid.add(nameLabel, 0,1);
        grid.add(IDLabel, 0,2);
        grid.add(passwordLabel, 0,3);

        grid.add(nameField, 1,1);
        grid.add(IDField, 1,2);
        grid.add(PasswordField, 1,3);

        grid.add(submitButton,1,5);
        grid.add(backButton,2,5);

        grid.add(sumbitFailed, 0,5);

        grid.setVgap(10);
        grid.setHgap(5);

        Scene scene = new Scene(grid, 600, 400);
        addStaffStage.setScene(scene);
        addStaffStage.show();

        //Action Button
        backButton.setOnAction(event -> {
            menu();
        });
        submitButton.setOnAction(event -> {
            if (PasswordField.getText().length() >= 8) {
                Admin adminObj = new Admin();

                Staff.arr_userStaff.add(new Staff.UserStaff(nameField.getText(), IDField.getText(), PasswordField.getText()));
                adminObj.menu();
                addStaffStage.close();

            } else {
                sumbitFailed.setVisible(true);
            }
        });

    }

    public void displaystudent() {
        // Membuat stage baru
        Stage displayStudentStage = new Stage();
        displayStudentStage.setTitle("UMM Library - Daftar Mahasiswa");

        //Label
        Label sceneTitle    = new Label("Daftar Mahasiswa");

        //Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        // Membuat ListView untuk menampilkan mahasiswa
        ListView<String> listView = new ListView<>();

        for (Student.UserStudent i : Student.arr_userStudent) {
            String studentInfo = "Nama     : " + i.nama +"\n" +
                                 "NIM      : " + i.nim + "\n" +
                                 "Fakultas : " + i.fakultas + "\n" +
                                 "Prodi    : " + i.prodi + "\n" +
                                 "===========================";
            listView.getItems().add(studentInfo);
        }

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle,0,0);
        grid.add(listView,0,1);

        grid.setVgap(5);

        Scene scene = new Scene(grid, 600, 400);
        displayStudentStage.setScene(scene);
        displayStudentStage.show();
    }
    public void displaystaff() {
        // Membuat stage baru
        Stage displayStaffStage = new Stage();
        displayStaffStage.setTitle("UMM Library - Daftar Staff");

        //Label
        Label sceneTitle    = new Label("Daftar Staff");

        //Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        // Membuat ListView untuk menampilkan mahasiswa
        ListView<String> listView = new ListView<>();

        for (Staff.UserStaff i : Staff.arr_userStaff) {
            String staffInfo = "Nama     : " + i.nama +"\n" +
                    "ID       : " + i.ID + "\n" +
                    "Password : " + i.password + "\n" +
                    "===========================";
            listView.getItems().add(staffInfo);
        }

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle,0,0);
        grid.add(listView,0,1);

        grid.setVgap(5);

        Scene scene = new Scene(grid, 600, 400);
        displayStaffStage.setScene(scene);
        displayStaffStage.show();
    }


    public void inputBook(){
        super.inputBook();
    }

    public String generateId () {
        Random random = new Random();

        StringBuilder idTengah = new StringBuilder();
        StringBuilder idAkhir = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idTengah.append(random.nextInt(10));
            idAkhir.append(random.nextInt(10));

        }
        return ("UMM-" + idTengah + "-" + idAkhir);

    }


}
