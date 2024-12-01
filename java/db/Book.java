	package db;

public class Book {
    private int bookId;
    private String title;
    private String genre;
    private int quantity;
    private int publicationYear;
    private int publisherId;
    private String img_book;
    
    public Book(int bookId, String title, String genre, int quantity, int publicationYear, int publisherId, String img_book) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.quantity = quantity;
        this.publicationYear = publicationYear;
        this.publisherId = publisherId;
        this.img_book=img_book;
    }

    // Getters and Setters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getQuantity() { return quantity; }
    public int getPublicationYear() { return publicationYear; }
    public int getPublisherId() { return publisherId; }
    public String getImgbook() {return img_book; }
}
