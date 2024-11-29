package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
