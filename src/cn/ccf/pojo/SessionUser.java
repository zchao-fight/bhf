package cn.ccf.pojo;

public class SessionUser {

	public static final int ROLE_COMMON = 0;
	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_SUPER_ADMIN = 2;

	private User user;
	private int role;
	
	
	private int deleteThread;
	private int onAndCancel;
	private int addBoard;
	private int addCategory;
	private int uploadFilm;
	private int deleteFilm;
	private int manageFilmCategory;
	
	
	
	public int getDeleteThread() {
		return deleteThread;
	}

	public void setDeleteThread(int deleteThread) {
		this.deleteThread = deleteThread;
	}

	public int getOnAndCancel() {
		return onAndCancel;
	}

	public void setOnAndCancel(int onAndCancel) {
		this.onAndCancel = onAndCancel;
	}

	public int getAddBoard() {
		return addBoard;
	}

	public void setAddBoard(int addBoard) {
		this.addBoard = addBoard;
	}

	public int getAddCategory() {
		return addCategory;
	}

	public void setAddCategory(int addCategory) {
		this.addCategory = addCategory;
	}

	public int getUploadFilm() {
		return uploadFilm;
	}

	public void setUploadFilm(int uploadFilm) {
		this.uploadFilm = uploadFilm;
	}

	public int getDeleteFilm() {
		return deleteFilm;
	}

	public void setDeleteFilm(int deleteFilm) {
		this.deleteFilm = deleteFilm;
	}

	public int getManageFilmCategory() {
		return manageFilmCategory;
	}

	public void setManageFilmCategory(int manageFilmCategory) {
		this.manageFilmCategory = manageFilmCategory;
	}


	
	
	
	
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SessionUser() {
	}

	public SessionUser(User user) {
		super();
		this.user = user;
	}

	public int getRole() {
		return role;
	}

	public boolean isAdmin() {
		return role == ROLE_ADMIN;
	}

	public boolean isSuperAdmin() {
		return role == ROLE_SUPER_ADMIN;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return user.getId();
	}

	public String getName() {
		return user.getName();
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getDepartmentID() {
		return user.getDepartmentid().toString();
	}

	public void setDepartmentID(int departmentID) {
		this.user.setDepartmentid(departmentID);
	}
}
