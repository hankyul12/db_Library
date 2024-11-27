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
}
