package db;

import java.sql.*;

public class LoanDAO {
    public boolean processLoan(String memberId, int bookId) {
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

                    // 현재 시간을 java.sql.Date로 변환 (현재 날짜와 시간을 대출일로 설정)
                    Date sqlLoanDate = new Date(System.currentTimeMillis()); 

                    // 대출 정보 삽입
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertLoan)) {
                        insertStmt.setInt(1, bookId);
                        insertStmt.setString(2, memberId);
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
    public String getLoansByMemberId(String memberId) {
        StringBuilder temp = new StringBuilder();
        //String query = "SELECT * FROM Loan WHERE Member_ID = ?";
        String query = "SELECT Loan.*, Book.Title FROM Loan JOIN Book ON Loan.Book_ID = Book.Book_ID WHERE Loan.Member_ID = ?";
        temp.append("<table border='1'>"); // 테이블 시작

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, memberId);
            try (ResultSet rs = pstmt.executeQuery()) {
                // 테이블 헤더 추가
                temp.append("<thead>");
                temp.append("<tr>");
                temp.append("<th>대출 번호</th>");
                temp.append("<th>책 번호</th>");
                temp.append("<th>제 목</th>");
                temp.append("<th>빌린 날짜</th>");
                temp.append("<th>반납한 날짜</th>");
                temp.append("<th>미납</th>");
                temp.append("</tr>");
                temp.append("</thead>");
                temp.append("<tbody>");

                while (rs.next()) {
                    int loanId = rs.getInt("Loan_ID");
                    int bookId = rs.getInt("Book_ID");
                    Date loanDate = rs.getDate("Loan_Date");
                    Date returnDate = rs.getDate("Return_Date");
                    boolean isOverdue = rs.getBoolean("Is_Overdue");
                    String Title = rs.getString("Title");
                    // 테이블 행 추가
                    temp.append("<tr>");
                    temp.append("<td>").append(loanId).append("</td>");
                    temp.append("<td>").append(bookId).append("</td>");
                    temp.append("<td>").append(Title).append("</td>");
                    temp.append("<td>").append(loanDate).append("</td>");
                    temp.append("<td>").append(returnDate != null ? returnDate : "Not Returned").append("</td>");
                    temp.append("<td>").append(isOverdue ? "Yes" : "No").append("</td>");
                    temp.append("</tr>");
                }
                temp.append("</tbody>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        temp.append("</table>"); // 테이블 종료
        return temp.toString(); // 테이블 형식으로 반환
    }

    
}
