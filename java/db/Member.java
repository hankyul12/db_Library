package db;

public class Member {
	 private String Member_ID;
	 private String Password;
	 private String Name;
	 private String Contact;
	 private String Email;
	 public String getMember_ID() {
		return Member_ID;
	}
	public void setMember_ID(String member_ID) {
		Member_ID = member_ID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMember_Type() {
		return Member_Type;
	}
	public void setMember_Type(String member_Type) {
		Member_Type = member_Type;
	}
	private String Member_Type;

}
