package cn.ccf.pojo;

public class ResponseDto {
	private static final int SUCC = 0;
	private static final int ERROR = -1;

	private int code;
	private String msg;
	private Object data;

	public static ResponseDto succ(Object data) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setData(data);
		responseDto.setCode(SUCC);
		return responseDto;
	}

	public static ResponseDto error(String msg) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setCode(ERROR);
		responseDto.setMsg(msg);
		return responseDto;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
