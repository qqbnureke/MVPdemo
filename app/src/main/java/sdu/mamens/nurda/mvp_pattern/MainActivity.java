package sdu.mamens.nurda.mvp_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import sdu.mamens.nurda.mvp_pattern.presenter.ILoginPresenter;
import sdu.mamens.nurda.mvp_pattern.presenter.LoginPresenter;
import sdu.mamens.nurda.mvp_pattern.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText etEmail, etPassword;
    Button btnLogin;

    ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        presenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogin(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });

    }

    @Override
    public void onSuccessLogin(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailedLogin(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
