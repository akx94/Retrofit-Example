package in.brainwired.www.retrofitexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import in.brainwired.www.retrofitexample.models.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout login_Password,login_Empid,login_Company;
    private Button login_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_Empid = findViewById(R.id.login_empid);
        login_Company=findViewById(R.id.login_company);
        login_Password = findViewById(R.id.login_password);

        login_Button=findViewById(R.id.login_button);

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    public void goToMain()
    {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
    private void loginUser() {

         String empid = login_Empid.getEditText().getText().toString().trim();
         String company = login_Company.getEditText().getText().toString().trim();
         String password = login_Password.getEditText().getText().toString().trim();

         if (empid.isEmpty()){
             login_Empid.getEditText().setError("Emp ID is required");
             login_Empid.requestFocus();
         }

         if( company.isEmpty()){
             login_Company.getEditText().setError("Company is required");
             login_Company.requestFocus();
         }
         if(password.isEmpty()){
             login_Password.getEditText().setError("Password is required");
             login_Password.requestFocus();
         }
        Call<UserResponse> call = RetrofitClient.getInstance().getApi().loginUser(empid,company,password);
         call.enqueue(new Callback<UserResponse>() {
             @Override
             public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                 UserResponse userResponse = response.body();
                 if (userResponse.isError())
                 {
                     Toast.makeText(LoginActivity.this,userResponse.getMessage(),Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(LoginActivity.this,userResponse.getName(),Toast.LENGTH_SHORT).show();
                     goToMain();
                 }
             }

             @Override
             public void onFailure(Call<UserResponse> call, Throwable t) {
                 Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
             }
         });
    }
}