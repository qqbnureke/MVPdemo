package sdu.mamens.nurda.mvp_pattern.presenter;

import sdu.mamens.nurda.mvp_pattern.model.User;
import sdu.mamens.nurda.mvp_pattern.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        switch (loginCode){
            case 1: loginView.onFailedLogin("Email is empty"); break;
            case 2: loginView.onFailedLogin("Email emes"); break;
            case 3: loginView.onFailedLogin("Password "); break;
            default: loginView.onSuccessLogin("Login successful"); break;
        }
    }
}
