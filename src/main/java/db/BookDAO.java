package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public String getAllBooks() throws SQLException {
        String query = "SELECT b.*,a.Name FROM Author a JOIN Writing w ON a.Author_ID = w.Author_ID JOIN Book b ON w.Book_ID = b.Book_ID";

        String temp = "";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int bookId = resultSet.getInt("Book_ID");
                String title = resultSet.getString("Title");
                String genre = resultSet.getString("Genre");
                int quantity = resultSet.getInt("Quantity");
                int publicationYear = resultSet.getInt("Publication_Year");
                int publisherId = resultSet.getInt("Publisher_ID");
                String img_book = resultSet.getString("Img_Book");
                String author = resultSet.getString("Name");
                temp += bookId + "&" + title + "&" + genre + "&" + quantity + "&" + publicationYear + "&" + publisherId + "&" + img_book + "&" + author;
                temp += "<br>";
            }
        }

        return temp;
    }
    public String getBook_Num(String id) throws SQLException {
        String query = "SELECT b.*, a.Name FROM Author a " +
                       "JOIN Writing w ON a.Author_ID = w.Author_ID " +
                       "JOIN Book b ON w.Book_ID = b.Book_ID " +
                       "WHERE w.Book_ID = ?";
        
        String temp = "";
        
        // 연결, PreparedStatement, ResultSet을 사용하여 쿼리 실행
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            // id를 파라미터로 설정
            pstmt.setString(1, id);
            
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    int bookId = resultSet.getInt("Book_ID");
                    String title = resultSet.getString("Title");
                    String genre = resultSet.getString("Genre");
                    int quantity = resultSet.getInt("Quantity");
                    int publicationYear = resultSet.getInt("Publication_Year");
                    int publisherId = resultSet.getInt("Publisher_ID");
                    String img_book = resultSet.getString("Img_Book");
                    String author = resultSet.getString("Name");
                    
                    // 결과를 temp 문자열에 저장
                    temp = bookId + "&" + title + "&" + genre + "&" + quantity + "&" + publicationYear + "&" +
                           publisherId + "&" + img_book + "&" + author;
                }
            }
        }
        
        return temp;
    }
    public String getBook_title(String Book_title) throws SQLException {
    	 String query = "SELECT b.*, a.Name FROM Author a " +
                 "JOIN Writing w ON a.Author_ID = w.Author_ID " +
                 "JOIN Book b ON w.Book_ID = b.Book_ID " +
                 "WHERE Title like ?";
    	 String temp = "";
         
         // 연결, PreparedStatement, ResultSet을 사용하여 쿼리 실행
         try (Connection connection = DBConnection.getConnection();
              PreparedStatement pstmt = connection.prepareStatement(query)) {
             
             pstmt.setString(1, "%"+Book_title+"%");
             
             try (ResultSet resultSet = pstmt.executeQuery()) {
                 while (resultSet.next()) {
                     int bookId = resultSet.getInt("Book_ID");
                     String title = resultSet.getString("Title");
                     String genre = resultSet.getString("Genre");
                     int quantity = resultSet.getInt("Quantity");
                     int publicationYear = resultSet.getInt("Publication_Year");
                     int publisherId = resultSet.getInt("Publisher_ID");
                     String img_book = resultSet.getString("Img_Book");
                     String author = resultSet.getString("Name");
                     
                     temp += bookId + "&" + title + "&" + genre + "&" + quantity + "&" + publicationYear + "&" +
                            publisherId + "&" + img_book + "&" + author;
                     temp += "<br>";
                     }
             }
         }
         
         return temp;
     }
}
