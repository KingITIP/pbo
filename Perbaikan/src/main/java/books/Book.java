package books;

import java.util.ArrayList;

public class Book {

    //==================================== ATRIBUT ====================================
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int stock;
    private int borrow = 0;

    private int duration;

    //ArrayList untuk menyimpan list buku yang terdaftar.
    public static ArrayList<Book> arr_bookList = new ArrayList<>();

    //ArrayList untuk menyimpan list buku yang sedang dipinjam mahasiswa.
    public static ArrayList<Book> arr_borrowedBook = new ArrayList<>();


    //====================================== METHOD ======================================

    // 4 Method konstruktor dengan nama yang sama, bertujuan untuk menerapkan fungsi overloading (Modul 3)
    public Book(){

    }

    public Book(String category){
        this.category = category;
    }
    public Book(String bookId, int stock, int duration, int borrow){
        this.bookId   = bookId;
        this.stock    = stock;
        this.duration = duration;
        this.duration = borrow;

    }
    public Book(String bookId, String title, String author,String category, int stock,int borrow){
        this.bookId   = bookId;
        this.title    = title;
        this.author   = author;
        this.category = category;
        this.stock    = stock;
        this.borrow = borrow;


    }


    //=================================== SETTER METHOD ====================================
    public void setBookId(String bookId){
        this.bookId     = bookId;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public void setBorrow(int borrow){this.borrow = borrow;}


    //=================================== GETTER METHOD ==================================
    public String getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getCategory(){
        return category;
    }
    public int getStock(){
        return stock;
    }
    public int getDuration(){
        return duration;
    }
    public int getBorrow(){return borrow;}


}
