package cn.ccf.constants;

public enum DetailType {

	HOME(0,"主页"),
	NOTICE(1,"通知公告"),
	NEWS(2,"边防要闻"),
	WORK(3,"工作动态"),
	LAW(4,"政策法规"),
	FORUM(5,"论坛互动"),
	STYLE(6,"基层风采"),
	FILM(7,"戍边风采");

	private int type;
	private String name;
	
	private DetailType(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}




}
