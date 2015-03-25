package project.android.imac.diabon.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import project.android.imac.diabon.MainActivity;
import project.android.imac.diabon.R;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

/**
 * Created by Brice on 09/03/2015.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    public static String filename = "Logindata";
    SharedPreferences SP;
    EditText email;
    EditText mdp;
    CheckBox remember_me;
    Activity context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);

        context = this;
        email = (EditText) findViewById(R.id.user_email);
        mdp = (EditText) findViewById(R.id.user_password);
        remember_me = (CheckBox) findViewById(R.id.remember_me);
        Button connect = (Button) findViewById(R.id.connect);
        connect.setOnClickListener(this);
        SP = getSharedPreferences(filename, 0);
        String getname = SP.getString("key1","");
        String getpass = SP.getString("key2","");
        email.setText(getname);
        mdp.setText(getpass);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connect:
                String name = email.getText().toString();
                String pass = mdp.getText().toString();
                if (remember_me.isChecked()){
                    SharedPreferences.Editor editit = SP.edit();
                    editit.putString("key1", name);
                    editit.putString("key2",pass);
                    editit.commit();
                }
                check_user();

                break;
        }

    }

    public void check_user(){
        JSONObject userJson = new JSONObject();
        try {
            userJson.put("email", email.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            userJson.put("password",mdp.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TypedInput in = new TypedByteArray("application/json", userJson.toString().getBytes());
        UserService service = UserAPI.getInstance();
        service.login(in, new Callback<Object>() {
            @Override
            public void success(Object user, Response response2) {
                JSONObject jsonObject = null;
                System.out.println(user.toString());
                String error = null;
                String id = null;
                try {
                    jsonObject = new JSONObject(user.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    error = jsonObject.getString("error");
                    id = jsonObject.getString("id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (error.equals("null") && id != null) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("user_id", id);
                    startActivity(intent);
                } else if (error.equals("Wrong password")) {
                    Toast.makeText(LoginActivity.this, R.string.error_mdp, Toast.LENGTH_SHORT).show();
                    return;
                } else if (error.equals("User not found")) {
                    Toast.makeText(LoginActivity.this, R.string.error_username, Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }
}







    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button loginButton = (Button) findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }*/
