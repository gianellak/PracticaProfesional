package exceptions;

public class LexicalException extends Exception {
	

	private String msg;


	

	public LexicalException(String message) {
		this.msg= message;
	}


	

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
