package model;

public class Reservation {
	private int ReservedNo;
	private int RoomNo;
	private String CheckIn;
	private String CheckOut;
	private String ReservedDate;
	private int MemberID;
	private String Requirement;
	private String Breakfast;
	private String ReservedStatus;
	private int GusetNo;
	private String MemberName;
	private String MemberPhone;
	//기본 생성자
		public Reservation() {}
		

		public Reservation(String MemberName,String MemberPhone,int ReservedNo,int RoomNo,String CheckIn, String CheckOut, String ReservedDate, int MemberID, String Requirement, String Breakfast, String ReservedStatus, int GuestNo) {

			super();
			this.setMemberName(MemberName);
			this.setMemberPhone(MemberPhone);
			this.setReservedNo(ReservedNo);
			this.setRoomNo(RoomNo);
			this.setCheckIn(CheckIn);
			this.setCheckOut(CheckOut);
			this.setReservedDate(ReservedDate);
			this.setMemberID(MemberID);
			this.setRequirement(Requirement);
			this.setBreakfast(Breakfast);
			this.setReservedStatus(ReservedStatus);
			this.setGusetNo(GusetNo);
		}
		
		public String getMemberName() {
			return MemberName;
		}


		public void setMemberName(String MemberName) {
			this.MemberName = MemberName;
		}
		
		public String getMemberPhone() {
			return MemberPhone;
		}


		public void setMemberPhone(String MemberPhone) {
			this.MemberPhone = MemberPhone;
		}
		

		public int getReservedNo() {
			return ReservedNo;
		}

		public void setReservedNo(int ReservedNo) {
			this.ReservedNo = ReservedNo;
		}

		public int getRoomNo() {
			return RoomNo;
		}

		public void setRoomNo(int RoomNo) {
			this.RoomNo = RoomNo;
		}

		public String getCheckIn() {
			return CheckIn;
		}

		public void setCheckIn(String CheckIn) {
			this.CheckIn = CheckIn;
		}

		public String getCheckOut() {
			return CheckOut;
		}

		public void setCheckOut(String CheckOut) {
			this.CheckOut = CheckOut;
		}

		public String getReservedDate() {
			return ReservedDate;
		}

		public void setReservedDate(String ReservedDate) {
			this.ReservedDate = ReservedDate;
		}

		public int getMemberID() {
			return MemberID;
		}

		public void setMemberID(int MemberID) {
			this.MemberID = MemberID;
		}

		public String getRequirement() {
			return Requirement;
		}

		public void setRequirement(String Requirement) {
			this.Requirement = Requirement;
		}
		public String getBreakfast() {
			return Breakfast;
		}

		public void setBreakfast(String Breakfast) {
			this.Breakfast = Breakfast;
		}
		public String getReservedStatus() {
			return ReservedStatus;
		}

		public void setReservedStatus(String ReservedStatus) {
			this.ReservedStatus = ReservedStatus;
		}
		public int getGusetNo() {
			return GusetNo;
		}

		public void setGusetNo(int GusetNo) {
			this.GusetNo = GusetNo;
		}
}
