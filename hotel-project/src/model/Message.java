
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
	
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getMessagestatus(String messagestatus) {
		return messagestatus;
	}
	public void setMessagestatus(String messagestatus) {
		this.messagestatus = messagestatus;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
}