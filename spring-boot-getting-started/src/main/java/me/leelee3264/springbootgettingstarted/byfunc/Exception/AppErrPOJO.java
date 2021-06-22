package me.leelee3264.springbootgettingstarted.byfunc.Exception;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-22
 * description
 */
public class AppErrPOJO {

    private String message;
    private String reason;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
