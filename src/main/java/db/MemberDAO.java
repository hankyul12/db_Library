package db;

import java.sql.*;

public class MemberDAO {

    // 로그인 메소드
    public String login(String id, String pwd) {
        String query = "SELECT Member_ID FROM Member WHERE Member_ID = ? AND Password = ?";
        String login_id = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // DB 연결을 DBConnection 클래스에서 가져옴
            con = DBConnection.getConnection();

            // PreparedStatement 설정
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);

            // 쿼리 실행
            rs = pstmt.executeQuery();

            // 로그인 성공 여부 확인
            if (rs.next()) {
                login_id = rs.getString(1); // Member_ID
            } else {
                login_id = "해당하는 결과가 없습니다.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            login_id = "데이터베이스 오류: " + e.getMessage();
        } finally {
            // 리소스 해제
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return login_id;
    }
    
    public int joinMember(String id,String pw,String name,String contact,String Email,String address,String memberType) {
    	String insert_member = "INSERT INTO Member (Member_ID, Password, Name, Contact, Email, Address, Member_Type) VALUES (?, ?, ?, ?, ?, ?, ?)";
    	Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement(insert_member);

            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            pstmt.setString(3, name);
            pstmt.setString(4, contact);
            pstmt.setString(5, Email);
            pstmt.setString(6, address);
            pstmt.setString(7, memberType);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                // 5. 자원 해제
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    	
    	
    }
}
