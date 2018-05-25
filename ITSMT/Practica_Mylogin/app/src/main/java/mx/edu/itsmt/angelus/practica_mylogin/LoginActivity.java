package mx.edu.itsmt.angelus.practica_mylogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText email;
    private EditText password;
    private Switch remember;
    private Button iniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindUI();
        preferences = getSharedPreferences("preferens", Context.MODE_PRIVATE);
        setCredencialsIfExist();

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtemail = email.getText().toString();
                String txtPass = password.getText().toString();
                if( login(txtemail,txtPass)){
                    goToMain();
                    saveOnPreferen(txtemail,txtPass);
                }
            }
        });
    }

    private void setCredencialsIfExist() {
        String correo = getUserMailPrefs();
        String contra = getUserPassPrefs();
        if (!TextUtils.isEmpty(correo)&&!TextUtils.isEmpty(contra)){
            email.setText(correo);
            password.setText(contra);
        }
    }

    private  void saveOnPreferen(String email,String pass){
        if(remember.isChecked()){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email",email);
            editor.putString("pass",pass);
            editor.commit();
            editor.apply();
        }

    }
    private void bindUI(){
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        remember = findViewById(R.id.switchRemember);
        iniciar = findViewById(R.id.btLogin);
    }
    private boolean login(String email,String pass){
        if (!isValidEmail(email)){
            Toast.makeText(this,"Email invalido",Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidPassword(pass)){
            Toast.makeText(this,"password invalido",Toast.LENGTH_LONG).show();
            return false;

        }else{
            return true;
        }
    }

    private boolean isValidEmail(String correo){

        return !TextUtils.isEmpty(correo)&& Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
    private boolean isValidPassword(String pass){
        return pass.length()>=4;
    }

    private void goToMain() {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        //para evitar regresar al activiti
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private String getUserMailPrefs(){
        return preferences.getString("email","");
    }
    private String getUserPassPrefs(){
        return preferences.getString("pass","");
    }
}
