package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {
	
	public boolean processReservation(String memberId, int bookId) throws SQLException {
		String insertReservation = "INSERT INTO Reservation ( Book_ID, Member_ID, Reservation_Status) VALUES (?, ?, ?)";
		try (Connection connection = DBConnection.getConnection()) {
			try (PreparedStatement insertStmt = connection.prepareStatement(insertReservation)) {
            insertStmt.setInt(1, bookId);
            insertStmt.setString(2, memberId);
            insertStmt.setString(3, "Pending");
            insertStmt.executeUpdate();
        }
			return true;
		
		}catch (SQLException e) {
            e.printStackTrace();
            return false; // 예외 처리
        }
	}
	
	public String getReservationsByMemberId(String memberId) {
	    StringBuilder tableHTML = new StringBuilder();
	    tableHTML.append("<table><tr><th>예약 번호</th><th>책 번호</th><th>제목</th><th>상태</th></tr>");

	    String query = "SELECT Reservation.Reservation_ID, Reservation.Book_ID, Reservation.Member_ID, Reservation.Reservation_Status, Book.Title FROM Reservation JOIN Book ON Reservation.Book_ID = Book.Book_ID WHERE Reservation.Member_ID = ?";


	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement pstmt = connection.prepareStatement(query)) {
	        
	        pstmt.setString(1, memberId);
	        
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                int reservationId = rs.getInt("Reservation_ID");
	                int bookId = rs.getInt("Book_ID");
	                String Title = rs.getString("Title");
	                String status = rs.getString("Reservation_Status");

	                // 예약 기록을 클릭 가능한 링크로 수정
	                tableHTML.append("<tr><td>").append(reservationId).append("</td>")
	                         .append("<td><a href='itemDetail.html?").append(bookId).append("'>").append(bookId).append("</a></td>")
	                         .append("<td>").append(Title).append("</td>")
	                         .append("<td>").append(status).append("</td></tr>");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    tableHTML.append("</table>");
	    return tableHTML.toString();
	}



}
