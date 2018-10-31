package in.brainwired.www.retrofitexample.models;

public class ImageResponse {
    private boolean error;
    private String message;

    public ImageResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
