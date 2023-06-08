package model;

public class ReservedRoom {
	
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

	private String BedType;
	private int Capacity;
	private String RoomType;
	private int RoomSize;
	private String RoomName;
	private boolean NonSmoking;
	private boolean Parking;
	
	//기본 생성자
	public ReservedRoom() {
		
	}
	
	//view 생성자
	public ReservedRoom(int ReservedNo,int RoomNo,String ReservedDate,String CheckIn,String CheckOut,String Requirement,String Breakfast,int GusetNo,String BedType,int Capacity,String RoomType,int RoomSize,String RoomName,boolean NonSmoking,boolean Parking) {
		super();
		this.setParking(Parking);
		this.setReservedDate(ReservedDate);
		this.setReservedNo(ReservedNo);
		this.setRoomNo(RoomNo);
		this.setCheckIn(CheckIn);
		this.setCheckOut(CheckOut);
		this.setRequirement(Requirement);
		this.setBedType(BedType);
		this.setBreakfast(Breakfast);
		this.setGusetNo(GusetNo);
		this.setCapacity(Capacity);
		this.setRoomType(RoomType);
		this.setRoomSize(RoomSize);
		this.setRoomName(RoomName);
		this.setNonSmoking(NonSmoking);
		
	}
	
	public int getReservedNo() {
		return ReservedNo;
	}
	public void setReservedNo(int reservedNo) {
		ReservedNo = reservedNo;
	}
	public String getCheckIn() {
		return CheckIn;
	}
	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	public String getCheckOut() {
		return CheckOut;
	}
	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}
	public String getReservedDate() {
		return ReservedDate;
	}
	public void setReservedDate(String reservedDate) {
		ReservedDate = reservedDate;
	}
	public int getMemberID() {
		return MemberID;
	}
	public void setMemberID(int memberID) {
		MemberID = memberID;
	}
	public String getRequirement() {
		return Requirement;
	}
	public void setRequirement(String requirement) {
		Requirement = requirement;
	}
	public String getBreakfast() {
		return Breakfast;
	}
	public void setBreakfast(String breakfast) {
		Breakfast = breakfast;
	}
	public String getReservedStatus() {
		return ReservedStatus;
	}
	public void setReservedStatus(String reservedStatus) {
		ReservedStatus = reservedStatus;
	}
	public int getGusetNo() {
		return GusetNo;
	}
	public void setGusetNo(int gusetNo) {
		GusetNo = gusetNo;
	}
	public String getBedType() {
		return BedType;
	}
	public void setBedType(String bedType) {
		BedType = bedType;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public int getRoomSize() {
		return RoomSize;
	}
	public void setRoomSize(int roomSize) {
		RoomSize = roomSize;
	}
	public String getRoomName() {
		return RoomName;
	}
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	public boolean isNonSmoking() {
		return NonSmoking;
	}
	public void setNonSmoking(boolean nonSmoking) {
		NonSmoking = nonSmoking;
	}
	public boolean isParking() {
		return Parking;
	}
	public void setParking(boolean parking) {
		Parking = parking;
	}

}
