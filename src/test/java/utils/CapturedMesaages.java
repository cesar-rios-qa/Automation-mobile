package utils;

public enum CapturedMesaages {

    INCORRECT_FORMAT_EMAIL("The email format is invalid");

    private final String message;



    CapturedMesaages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
