/**
 *room 객체를 관리하는 class입니다.
 */
package model;

public class Room {
	
	private int RoomNo;
	private String BedType;
	private int Capacity;
	private int Price;
	private String RoomType;
	private int RoomSize;
	private String RoomName;
	private boolean NonSmoking;
	private boolean Parking;
	
	//기본 생성자
	public Room() {}
	
	public Room(int RoomNo,String BedType,int Capacity,int Price,String RoomType,int RoomSize,String RoomName,boolean NonSmoking,boolean Parking) {
		super();
		this.setRoomNo(RoomNo);
		this.setBedType(BedType);
		this.setCapacity(Capacity);
		this.setPrice(Price);
		this.setRoomType(RoomType);
		this.setRoomSize(RoomSize);
		this.setRoomName(RoomName);
		this.setNonSmoking(NonSmoking);
		this.setParking(Parking);
	}
	/**
	 * room number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room number를 반환합니다.
	 */
	public int getRoomNo() {
		return RoomNo;
	}
	/**
	 * room number를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomNo(int RoomNo) {
		this.RoomNo = RoomNo;
	}
	/**
	 * room bed type를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room bed type를 반환합니다.
	 */
	public String getBedType() {
		return BedType;
	}
	/**
	 * room bed type를 객체에 저장하는 메소드입니다.
	 */
	public void setBedType(String BedType) {
		this.BedType = BedType;
	}
	/**
	 * room capacity를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return  room capacity를 반환합니다.
	 */
	public int getCapacity() {
		return Capacity;
	}
	/**
	 * room capacity를 객체에 저장하는 메소드입니다.
	 */
	public void setCapacity(int Capacity) {
		this.Capacity = Capacity;
	}
	/**
	 * room price를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room price를 반환합니다.
	 */
	public int getPrice() {
		return Price;
	}
	/**
	 * room price를 객체에 저장하는 메소드입니다.
	 */
	public void setPrice(int Price) {
		this.Price = Price;
	}
	/**
	 * room type를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room type를 반환합니다.
	 */
	public String getRoomType() {
		return RoomType;
	}
	/**
	 * room type를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomType(String RoomType) {
		this.RoomType = RoomType;
	}
	/**
	 * room size를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room size를 반환합니다.
	 */
	public int getRoomSize() {
		return RoomSize;
	}
	/**
	 * room size를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomSize(int RoomSize) {
		this.RoomSize = RoomSize;
	}
	/**
	 * room name를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room name를 반환합니다.
	 */
	public String getRoomName() {
		return RoomName;
	}
	/**
	 * room name를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomName(String RoomName) {
		this.RoomName = RoomName;
	}
	/**
	 * room smoking 여부를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room smoking 여부를 반환합니다.
	 */
	public Boolean getNonSmoking() {
		return NonSmoking;
	}
	/**
	 *  room smoking 여부를 객체에 저장하는 메소드입니다.
	 */
	public void setNonSmoking(Boolean NonSmoking) {
		this.NonSmoking = NonSmoking;
	}
	/**
	 * room parking 여부를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return room parking 여부를 반환합니다.
	 */
	public Boolean getParking() {
		return Parking;
	}
	/**
	 * room parking 여부를 객체에 저장하는 메소드입니다.
	 */
	public void setParking(Boolean Parking) {
		this.Parking = Parking;
	}
	
	
}
	
