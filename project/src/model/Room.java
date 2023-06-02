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

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int RoomNo) {
		this.RoomNo = RoomNo;
	}

	public String getBedType() {
		return BedType;
	}

	public void setBedType(String BedType) {
		this.BedType = BedType;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int Capacity) {
		this.Capacity = Capacity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String RoomType) {
		this.RoomType = RoomType;
	}

	public int getRoomSize() {
		return RoomSize;
	}

	public void setRoomSize(int RoomSize) {
		this.RoomSize = RoomSize;
	}

	public String getRoomName() {
		return RoomName;
	}

	public void setRoomName(String RoomName) {
		this.RoomName = RoomName;
	}
	public Boolean getNonSmoking() {
		return NonSmoking;
	}

	public void setNonSmoking(Boolean NonSmoking) {
		this.NonSmoking = NonSmoking;
	}
	public Boolean getParking() {
		return Parking;
	}

	public void setParking(Boolean Parking) {
		this.Parking = Parking;
	}
	
	
}
	
