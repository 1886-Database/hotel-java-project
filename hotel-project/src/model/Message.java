/**
 * message model 객체를 관리하는 class입니다.
 */

package model;

public class Message {
	
	private int messageID;
	private int memberID;
	private String messagestatus;
	private String content;
	private String sendtime;

	//기본 생성자
	public Message() {}
	
	//messageID 제외 매개변수를 받는 생성
	public Message(int memberID,String messagestatus ,String content,String sendtime) {
		super();
		this.setMemberID(memberID);
		this.setMessagestatus(messagestatus);
		this.setContent(content);
		this.setSendtime(sendtime);

	
	}
	/**
	 * messageID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return messageID를 반환합니다.
	 */
	public int getMessageID() {
		return messageID;
	}
	/**
	 * messageID를 객체에 저장하는 메소드입니다.
	 */
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	/**
	 * memberID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return memberID를 반환합니다.
	 */
	public int getMemberID() {
		return memberID;
	}
	/**
	 * memberID를 객체에 저장하는 메소드입니다.
	 */
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	/**
	 * message status를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return message status를 반환합니다.
	 */
	public String getMessagestatus(String messagestatus) {
		return messagestatus;
	}
	/**
	 * message status를 객체에 저장하는 메소드입니다.
	 */
	public void setMessagestatus(String messagestatus) {
		this.messagestatus = messagestatus;
	}
	/**
	 * message content를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return message content를 반환합니다.
	 */
	public String getContent() {
		return content;
	}
	/**
	 * message content를 객체에 저장하는 메소드입니다.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * message send time를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return message send time를 반환합니다.
	 */
	public String getSendtime() {
		return sendtime;
	}
	/**
	 * message send time를 객체에 저장하는 메소드입니다.
	 */
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
}