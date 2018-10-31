package in.brainwired.www.retrofitexample.models;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    private boolean error;
    private String message;
    private String name;
    private String empid;
    private String company;
    private String user_type;
    private String depots;

    public UserResponse(boolean error, String message, String name, String empid, String company, String user_type, String depots) {
        this.error = error;
        this.message = message;
        this.name = name;
        this.empid = empid;
        this.company = company;
        this.user_type = user_type;
        this.depots = depots;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getEmpid() {
        return empid;
    }

    public String getCompany() {
        return company;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getDepots() {
        return depots;
    }
}
