package db;

import java.sql.*;

public class LoanDAO {
    public boolean processLoan(int memberId, int bookId, String loanDate) {
        String query = "SELECT Quantity FROM Book WHERE Book_ID = ?";
        String updateQuery = "UPDATE Book SET Quantity = Quantity - 1 WHERE Book_ID = ?";
        String insertLoan = "INSERT INTO Loan (Book_ID, Member_ID, Loan_Date, Is_Overdue) VALUES (?, ?, ?, FALSE)";
        
        try (Connection connection = DBConnection.getConnection()) {
            // 책 수량 확인
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, bookId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next() && rs.getInt("Quantity") > 0) {
                    // 책 수량이 있으면 대출 처리
                    try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                        updateStmt.setInt(1, bookId);
                        updateStmt.executeUpdate();
                    }

                    // loanDate를 java.sql.Date로 변환
                    Date sqlLoanDate = Date.valueOf(loanDate); 

                    // 대출 정보 삽입
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertLoan)) {
                        insertStmt.setInt(1, bookId);
                        insertStmt.setInt(2, memberId);
                        insertStmt.setDate(3, sqlLoanDate);
                        insertStmt.executeUpdate();
                    }

                    return true; // 대출 성공
                } else {
                    return false; // 대출할 책이 없음
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 예외 처리
        }
    }
}
