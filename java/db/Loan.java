package db;

import java.util.Date;

public class Loan {
    private int loanId;         // 대출 ID
    private int bookId;         // 도서 ID
    private int memberId;       // 회원 ID
    private Date loanDate;      // 대출 날짜
    private Date returnDate;    // 반납 날짜
    private boolean isOverdue;  // 연체 여부

    // 기본 생성자
    public Loan() {}

    // 파라미터를 받는 생성자
    public Loan(int loanId, int bookId, int memberId, Date loanDate, Date returnDate, boolean isOverdue) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.isOverdue = isOverdue;
    }

    // Getter and Setter methods
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public void setOverdue(boolean overdue) {
        isOverdue = overdue;
    }

    // toString method (옵션)
    @Override
    public String toString() {
        return "Loan{" +
               "loanId=" + loanId +
               ", bookId=" + bookId +
               ", memberId=" + memberId +
               ", loanDate=" + loanDate +
               ", returnDate=" + returnDate +
               ", isOverdue=" + isOverdue +
               '}';
    }
}
