package domain;

/**
 * Created by jakub on 07.05.18.
 */
public class RegistrationJsonResponse {

    private boolean validated;
    private String message;

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
