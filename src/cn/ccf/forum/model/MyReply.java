package cn.ccf.forum.model;

import java.util.Date;

public class MyReply {

    private Date datecreated;
    private String content;

    private String title;
    
    private Integer id;

    private Integer thread_id;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getThread_id() {
		return thread_id;
	}

	public void setThread_id(Integer thread_id) {
		this.thread_id = thread_id;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	



	
    
    
    
}