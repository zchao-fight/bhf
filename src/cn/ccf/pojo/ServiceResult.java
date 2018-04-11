package cn.ccf.pojo;

public class ServiceResult<T> {
	private boolean succ;
	private String msg;
	private T data;

	public ServiceResult(boolean succ, String msg) {
		this.succ = succ;
		this.msg = msg;
	}

	public ServiceResult(boolean succ, String msg, T data) {
		super();
		this.succ = succ;
		this.msg = msg;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> ServiceResult<T> succ() {
		return new ServiceResult<>(true, null);
	}

	public static <T> ServiceResult<T> succ(T t) {
		return new ServiceResult<>(true, null, t);
	}

	public static <T> ServiceResult<T> error(String msg) {
		return new ServiceResult<>(false, msg);
	}

	public static <T> ServiceResult<T> error(String msg, T t) {
		return new ServiceResult<>(false, msg, t);
	}

	public boolean isSucc() {
		return succ;
	}

	public void setSucc(boolean succ) {
		this.succ = succ;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
