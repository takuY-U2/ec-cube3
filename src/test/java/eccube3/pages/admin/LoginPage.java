package eccube3.pages.admin;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    public AdminPage login(String loginId, String password) {
        $("#login_id").setValue(loginId);
        $("#password").setValue(password);
        $(".btn-tool-format").click();

        return page(AdminPage.class);
    }
}

