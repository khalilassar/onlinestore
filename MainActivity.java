package soeq.app.soeq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import soeq.app.soeq.Database.DatabaseAccess;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.T_password)
    EditText Password;

    @BindView(R.id.T_Username)
    EditText Username;

    @BindView(R.id.Wrong_login)
    TextView WrongLogin;

    public static String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Username.setText("amr");
        Password.setText("123456");
        setTitle("Login");


        //    databaseAccess.addCat("cat1");
        //   databaseAccess.addCat("cat2");
        //   databaseAccess.addCat("cat3");

        //   System.out.println(databaseAccess.getUsers());
      /*  Intent intent = new Intent(this, MainWin.class);
        startActivity(intent);
*/
    }

    @OnClick(R.id.Skip)
    void SkipSignIn() {
        Intent intent = new Intent(this, image_test.class);
        startActivity(intent);
    }

    @OnClick(R.id.SignInBt)
    public void GotoSignIn() {
       /* DatabaseAccess databaseAccess = DatabaseAccess.getAccess(getApplicationContext());
        databaseAccess.open();
        databaseAccess.clear();*/

     System.out.println(5.5 * ((double) (5 / 100)));
        DatabaseAccess databaseAccess = DatabaseAccess.getAccess(getApplicationContext());
        databaseAccess.open();

        if (databaseAccess.getPassword(Username.getText().toString()).equals(Password.getText().toString())) {

            username = Username.getText().toString();
            Intent intent = new Intent(this, Catgories.class);
            intent.putExtra("user_id", databaseAccess.getUserid(Username.getText().toString()));
            startActivity(intent);

        } else {
            WrongLogin.setVisibility(View.VISIBLE);
        }

        // localhost
        //1521
        // amr amr
        //system
        //  sid xe
     /*   Connection connection  = null;
        try {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String serverName = "192.168.56.1";
            String serverPort = "1521";
            String sid = "xe";
            String url = "jdbc:oracle:thin:@192.168.56.1:1521:xe";
            String username = "system";
            String password = "amro2012";
            Class.forName(driverName);

            connection = DriverManager.getConnection(url, username, password);
         //   Statement stmt = connection.createStatement();

            System.out.println("Successfully Connected to the database!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
   /*     Intent intent = new Intent(this, MainWin.class);
        startActivity(intent);*/
    }


    @OnClick(R.id.SignUpBt)
    public void GotoSignUp() {

        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);

    }


}
