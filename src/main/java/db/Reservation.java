package db;

public class Reservation {
	int Reservation_ID;
	int Book_ID;
	String Member_ID;
	String Reservation_Status;
	public int getReservation_ID() {
		return Reservation_ID;
	}
	public void setReservation_ID(int reservation_ID) {
		Reservation_ID = reservation_ID;
	}
	public int getBook_ID() {
		return Book_ID;
	}
	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}
	public String getMember_ID() {
		return Member_ID;
	}
	public void setMember_ID(String member_ID) {
		Member_ID = member_ID;
	}
	public String getReservation_Status() {
		return Reservation_Status;
	}
	public void setReservation_Status(String reservation_Status) {
		Reservation_Status = reservation_Status;
	}
}
