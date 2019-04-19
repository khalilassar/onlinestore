package soeq.app.soeq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import soeq.app.soeq.Database.Database;
import soeq.app.soeq.Database.DatabaseAccess;

public class SignUp extends AppCompatActivity {

    @BindView(R.id.first_name)
    EditText firt_name;

    @BindView(R.id.last_name)
    EditText l_last_name;

    @BindView(R.id.username)
    EditText a_username;

    @BindView(R.id.phonenumber)
    EditText phonenumber;

    @BindView(R.id.Pass)
    EditText password;

    @BindView(R.id.ConfirmPass)
    EditText con_pass;

    @BindView(R.id.Email)
    EditText email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
        setTitle("Sign Up");

    }

    @OnClick(R.id.SignUpBt)
    public void GotMainMenu() {
        if (!firt_name.getText().toString().trim().isEmpty() && !firt_name.getText().toString().trim().isEmpty() &&
                !firt_name.getText().toString().trim().isEmpty() && !firt_name.getText().toString().trim().isEmpty()
                && !firt_name.getText().toString().trim().isEmpty() && !firt_name.getText().toString().trim().isEmpty()) {

            if (con_pass.getText().toString().equals(password.getText().toString())){

                // Test User if unique or not
                DatabaseAccess access = DatabaseAccess.getAccess(getApplicationContext());
                access.open();

                access.addUser(firt_name.getText().toString(),l_last_name.getText().toString()
                        ,email.getText().toString(),phonenumber.getText().toString(),a_username.getText().toString()
                        ,password.getText().toString());
            }



        }
        Intent intent = new Intent(this, Catgories.class);
        startActivity(intent);
    }

}
