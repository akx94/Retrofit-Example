package in.brainwired.www.retrofitexample;

import java.io.File;

import in.brainwired.www.retrofitexample.models.ImageResponse;
import in.brainwired.www.retrofitexample.models.UserResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    @FormUrlEncoded
    @POST("appusers/login")
    Call<UserResponse> loginUser(
            @Field("empid") String empid,
            @Field("company") String company,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("appusers/details")
    Call<UserResponse> userDetails(
            @Field("company") String company,
            @Field("empid") String empid
    );

    @Multipart
    @POST("images/upload")
    Call<ImageResponse> uploadImage(
            @Part("name") String name,
            @Part MultipartBody.Part image
    );
}
