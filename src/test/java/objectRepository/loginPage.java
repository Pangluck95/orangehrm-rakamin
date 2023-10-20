package objectRepository;

import org.openqa.selenium.By;

public class loginPage {
    By field_username = By.name("username");
    By field_password = By.name("password");
    By btn_login = By.xpath("//button[@type='submit']");

    public By getField_username() {
        return field_username;
    }

    public By getField_password() {
        return field_password;
    }

    public By getBtn_login() {
        return btn_login;
    }
}
