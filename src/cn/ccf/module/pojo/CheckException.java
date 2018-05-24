package cn.ccf.module.pojo;

public class CheckException extends RuntimeException {
    private static final long serialVersionUID = 1L;
     public CheckException() {
         super();
     }

     public CheckException(String message) {
         super(message);
     }

     public CheckException(Throwable cause) {
        super(cause);
     }

     public  CheckException(String message, Throwable cause) {
         super(message, cause);
     }

     public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace) {
         super(message, cause, enableSuppression, writeableStackTrace);
     }
}
