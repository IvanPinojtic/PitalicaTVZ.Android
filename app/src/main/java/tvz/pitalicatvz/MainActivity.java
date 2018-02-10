package tvz.pitalicatvz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tvz.pitalicatvz.models.User;
import tvz.pitalicatvz.remote.APIService;
import tvz.pitalicatvz.remote.ApiUtils;
import tvz.pitalicatvz.remote.Post;

public class MainActivity extends AppCompatActivity {

    private TextView mResponseTv;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = titleEt.getText().toString().trim();
                String password = bodyEt.getText().toString().trim();
                if (!TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(password)) {
                    tryGetUser(fullName, password);
                }
            }
        });
    }

    public void tryGetUser(String fullName, String password) {
        User user=new User();
        user.setFullName(fullName);
        user.setPassword(password);
        mAPIService.tryGetUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()==null){
                    if(response.raw().code()==404)
                        showResponse("UserNotFound");
                }
                else
                    showResponse(response.body().toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                showResponse(t.getMessage());
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}