/**
 * reserved room 객체를 관리하는 class입니다.
 */
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
	/**
	 * reservation number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reservation number를 반환합니다.
	 */
	public int getReservedNo() {
		return ReservedNo;
	}
	/**
	 * reservation number를 객체에 저장하는 메소드입니다.
	 */
	public void setReservedNo(int reservedNo) {
		ReservedNo = reservedNo;
	}
	/**
	 * checkin time를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return checkin time를 반환합니다.
	 */
	public String getCheckIn() {
		return CheckIn;
	}
	/**
	 * checkin time를 객체에 저장하는 메소드입니다.
	 */
	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}
	/**
	 * reserved room number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room number를 반환합니다.
	 */
	public int getRoomNo() {
		return RoomNo;
	}
	/**
	 * reserved room number를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	/**
	 * checkout time를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return checkout time를 반환합니다.
	 */
	public String getCheckOut() {
		return CheckOut;
	}
	/**
	 * checkout time를 객체에 저장하는 메소드입니다.
	 */
	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}
	/**
	 *reservation date를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reservation date를 반환합니다.
	 */
	public String getReservedDate() {
		return ReservedDate;
	}
	/**
	 * reservation date를 객체에 저장하는 메소드입니다.
	 */
	public void setReservedDate(String reservedDate) {
		ReservedDate = reservedDate;
	}
	/**
	 * memberID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return memberID를 반환합니다.
	 */
	public int getMemberID() {
		return MemberID;
	}
	/**
	 * memberID를 객체에 저장하는 메소드입니다.
	 */
	public void setMemberID(int memberID) {
		MemberID = memberID;
	}
	/**
	 * reservation requirement를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reservation requirement를 반환합니다.
	 */
	public String getRequirement() {
		return Requirement;
	}
	/**
	 * reservation requirement를 객체에 저장하는 메소드입니다.
	 */
	public void setRequirement(String requirement) {
		Requirement = requirement;
	}
	/**
	 *  reservation breakfast 여부를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return  reservation breakfast 여부를 반환합니다.
	 */
	public String getBreakfast() {
		return Breakfast;
	}
	/**
	 *  reservation breakfast 여부를 객체에 저장하는 메소드입니다.
	 */
	public void setBreakfast(String breakfast) {
		Breakfast = breakfast;
	}
	/**
	 * reserved status를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved status를 반환합니다.
	 */
	public String getReservedStatus() {
		return ReservedStatus;
	}
	/**
	 * reserved status를 객체에 저장하는 메소드입니다.
	 */
	public void setReservedStatus(String reservedStatus) {
		ReservedStatus = reservedStatus;
	}
	/**
	 * guest number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return guest number를 반환합니다.
	 */
	public int getGusetNo() {
		return GusetNo;
	}
	/**
	 * guest number를 객체에 저장하는 메소드입니다.
	 */
	public void setGusetNo(int gusetNo) {
		GusetNo = gusetNo;
	}
	/**
	 * reserved room bed type를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room bed type를 반환합니다.
	 */
	public String getBedType() {
		return BedType;
	}
	/**
	 * reserved room bed type를 객체에 저장하는 메소드입니다.
	 */
	public void setBedType(String bedType) {
		BedType = bedType;
	}
	/**
	 * reserved room capacity를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room capacity를 반환합니다.
	 */
	public int getCapacity() {
		return Capacity;
	}
	/**
	 * reserved room capacity를 객체에 저장하는 메소드입니다.
	 */
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	/**
	 * reserved room room type를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room room type를 반환합니다.
	 */
	public String getRoomType() {
		return RoomType;
	}
	/**
	 * reserved room room type를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	/**
	 * reserved room room size를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room room size를 반환합니다.
	 */
	public int getRoomSize() {
		return RoomSize;
	}
	/**
	 * reserved room room size를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomSize(int roomSize) {
		RoomSize = roomSize;
	}
	/**
	 * reserved room name를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room name를 반환합니다.
	 */
	public String getRoomName() {
		return RoomName;
	}
	/**
	 * reserved room name를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	/**
	 * reserved room smoking 여부를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room smoking 여부를 반환합니다.
	 */
	public boolean isNonSmoking() {
		return NonSmoking;
	}
	/**
	 * reserved room smoking 여부를 객체에 저장하는 메소드입니다.
	 */
	public void setNonSmoking(boolean nonSmoking) {
		NonSmoking = nonSmoking;
	}
	/**
	 * reserved room parking 여부를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved room parking 여부를 반환합니다.
	 */
	public boolean isParking() {
		return Parking;
	}
	/**
	 * reserved room parking 여부를 객체에 저장하는 메소드입니다.
	 */
	public void setParking(boolean parking) {
		Parking = parking;
	}

}
