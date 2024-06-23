package data;


import books.Book;
import com.main.LibrarySystem;
import exception.custom.IllegalAdminAccess;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import util.iMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Staff extends User implements iMenu {
    public static ArrayList<UserStaff> arr_userStaff = new ArrayList<>();

    //Konstruktor untuk arraylist arr_userStudent.
    public static class UserStaff {
        String nama, ID, password;

        public UserStaff(String nama, String ID,String password) {
            this.nama = nama;
            this.ID = ID;
            this.password = password;
        }
    }

    @Override
    public void menu() {
        Stage staffMenuStage = new Stage();
        staffMenuStage.setTitle("UMM Library - Staff Menu");
        staffMenuStage.setFullScreen(true);

        //Label
        Label sceneTitle = new Label("Staff Menu");

        //Font style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20 ));

        //Font color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        //Button
        Button borrowedBookButton = new Button("Menambah buku");
        Button borrowBookButton   = new Button("List Book");
        Button returnBookButton   = new Button("BOX Saran Buku");
        Button logoutButton         = new Button("Logout");

        //Grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle, 0,1);

        grid.add(borrowedBookButton, 2,1);
        grid.add(borrowBookButton, 2,2);
        grid.add(returnBookButton,2,3);
        grid.add(logoutButton,4,3);

        grid.setVgap(10);
        grid.setHgap(5);

        Scene studentmenuScene = new Scene(grid, 1360, 720);
        staffMenuStage.setScene(studentmenuScene);
        staffMenuStage.show();

        //Action button
        borrowedBookButton.setOnAction(event ->{
            inputBook();
        });

        borrowBookButton.setOnAction(event -> {
            choiceBooks();
        });

        returnBookButton.setOnAction(event ->{
            returnBooks();
        });

        logoutButton.setOnAction(event -> {
            LibrarySystem librarySystemObj = new LibrarySystem();
            librarySystemObj.start(new Stage());
            staffMenuStage.close();
        });

    }

    @Override
    public void choiceBooks(){
        Book bookObj = new Book();
        Student studentObj = new Student();

        Stage choiceBooksStage = new Stage();
        choiceBooksStage.setTitle("UMM library - Pilih Buku");



        TableView<Book> tableView = new TableView<>();

        TableColumn<Book, String> idColumn = new TableColumn<>("ID Buku");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));

        TableColumn<Book, String> titleColumn = new TableColumn<>("Nama Buku");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Penulis");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> categoryColumn = new TableColumn<>("Kategori");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Book, Integer> stockColumn = new TableColumn<>("Stok");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        TableColumn<Book, Integer> BorrowColumn = new TableColumn<>("Jumlah Terpinjam");
        BorrowColumn.setCellValueFactory(new PropertyValueFactory<>("borrow"));


        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(titleColumn);
        tableView.getColumns().add(authorColumn);
        tableView.getColumns().add(categoryColumn);
        tableView.getColumns().add(stockColumn);
        tableView.getColumns().add(BorrowColumn);

        for (Book i : Book.arr_bookList) {
            tableView.getItems().add(i);
        }


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.setHgap(10);
        grid.setVgap(10);

    }
    public static void showBorrowedBooks(){
        Stage showBorrowedBooksStage = new Stage();
        showBorrowedBooksStage.setTitle("Informasi Buku Yang Dipinjam");

        TableView<Book> table = new TableView<>();
        table.setPrefSize(600, 400);

        TableColumn<Book, String> idColumn = new TableColumn<>("ID Buku");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));

        TableColumn<Book, String> titleColumn = new TableColumn<>("Nama Buku");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Penulis");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> categoryColumn = new TableColumn<>("Kategori");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Book, Integer> durationColumn = new TableColumn<>("Durasi");
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<Book, Integer> BorrowColumn = new TableColumn<>("Borrow");
        BorrowColumn.setCellValueFactory(new PropertyValueFactory<>("borrowed"));


        table.getColumns().add(idColumn);
        table.getColumns().add(titleColumn);
        table.getColumns().add(authorColumn);
        table.getColumns().add(categoryColumn);
        table.getColumns().add(durationColumn);
        table.getColumns().add(BorrowColumn);

        for (Book a : Book.arr_borrowedBook) {
            for (Book i : Book.arr_bookList) {
                if (i.getBookId().equals(a.getBookId())) {
                    table.getItems().add(i);

                }
            }
        }


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(table, 0, 0); // menambahkan tabel ke GridPane

        gridPane.setVgap(10);
        gridPane.setHgap(5);

        Scene scene = new Scene(gridPane,600,400);
        showBorrowedBooksStage.setScene(scene);
        showBorrowedBooksStage.show();

    }

    public static void returnBooks(){

        Stage returnBooksStage = new Stage();
        returnBooksStage.setTitle("UMM Library - Pengembalian buku");

        //Label
        Label headerTitle = new Label("Pengembalian buku");
        Label bookIdLabel = new Label("Inputkan ID buku yang ingin dikembalikan");

        //Notification Label
        Label submitSuccesLabel = new Label("Pengembalian berhasil");
        Label submitFailedLabel = new Label("Pengembalian gagal");

        //Font Style
        headerTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        bookIdLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));

        //Font Color
        headerTitle.setStyle("-fx-text-fill: #A91D3A;");
        submitSuccesLabel.setStyle("-fx-text-fill: #16FF00;");
        submitFailedLabel.setStyle("-fx-text-fill: #FF1E1E;");

        //Notification label settings
        submitSuccesLabel.setVisible(false);
        submitFailedLabel.setVisible(false);

        //Field
        TextField bookIdField = new TextField();



        //Button
        Button submitButton = new Button("Kembalikan");
        Button returnButton = new Button("Kembali");

        //Table label
        TableView<Book> tableView  = new TableView<>();

        TableColumn<Book, String> idBookColumn     = new TableColumn<>("ID Buku");
        TableColumn<Book, String> titleBookColumn = new TableColumn<>("Judul");
        TableColumn<Book, String> authorBookColumn = new TableColumn<>("Author");
        TableColumn<Book, String> categoryBookColumn = new TableColumn<>("Kategori");
        TableColumn<Book, String> durationBookColumn = new TableColumn<>("Durasi Pinjaman (Hari)");
        TableColumn<Book, String> borrowBookColumn = new TableColumn<>("Total Buku diPinjam");


        //Table fill
        idBookColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleBookColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorBookColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        categoryBookColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        durationBookColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        borrowBookColumn.setCellValueFactory(new PropertyValueFactory<>("borrowed"));


        //Tabel access array arr_borrowedBook
        for(Book i : Book.arr_borrowedBook ){
            tableView.getItems().add(i);
        }


        //Grid layout
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);

        grid.add(headerTitle,2,0);
        grid.add(tableView, 0,1);

        grid.add(bookIdLabel,0,2);
        grid.add(bookIdField, 0,3);

        grid.add(submitSuccesLabel,5,2);
        grid.add(submitFailedLabel,5,2);

        grid.add(submitButton, 4,4);
        grid.add(returnButton, 0,4);

        Scene returnBookScene = new Scene(grid, 600,400);
        returnBooksStage.setScene(returnBookScene);
        returnBooksStage.show();

        //Action button
        submitButton.setOnAction(event ->{

            boolean validasiReturnBooks = false;
            //For dengan variabel i yang membaca ukuran arraylist arr_borrowedBook.
            for (int i = 0; i < Book.arr_borrowedBook.size(); i++ ) {

                //If untuk membandingkan variabel idBukuYangDipinjam dengan id yang ada di arr_borrowedBook.
                if (Book.arr_borrowedBook.get(i).getBookId().equals(bookIdField.getText())) {
                    for (Book book : Book.arr_bookList) {
                        if (book.getBookId().equals(bookIdField.getText())) {

                            int returnBook = book.getStock();   //variabel returnBook yang berfungsi untuk mendapatkan info jumlah stok buku dari variabel book.
                            returnBook++;                       //lalu setelah itu menambahkan nilai +1 pada variabel returnBook.
                            book.setStock(returnBook);          //Lalu, menambahkan nilai returnBook kedalam stok buku yang ada di arraylist arr_bookList.

                            Book.arr_borrowedBook.remove(i);    //Menghapus buku dari arraylist arr_borrowedBook.

                            validasiReturnBooks = true;
                        }
                    }
                }
            }
            tableView.refresh();
            if(validasiReturnBooks){
                submitSuccesLabel.setVisible(true);
                submitFailedLabel.setVisible(false);

            }else{
                submitFailedLabel.setVisible(true);
                submitSuccesLabel.setVisible(false);
            }
        });

        returnButton.setOnAction(event ->{
            Student studentObj = new Student();

            studentObj.menu();
            returnBooksStage.close();

        });



    }


    public boolean isStaff(TextField ID, TextField password) throws IllegalAdminAccess {
        for (UserStaff i : arr_userStaff) {
            if (i.ID.equals(ID.getText())) {
                if(i.password.equals(password.getText())){
                    menu();
                    return false;
                }
            }
        }
        throw new IllegalAdminAccess("Staff tidak ditemukan!");
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
    public void inputBook(){
        super.inputBookStaff();
    }
}
