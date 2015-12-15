package eccube3.scenarios.admin;

import eccube3.constant.ConfigurationKey;
import eccube3.core.EcCube3Test;
import eccube3.data.Product;
import eccube3.pages.admin.AdminPage;
import eccube3.pages.admin.LoginPage;
import eccube3.pages.admin.ProductNewPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class WhenIRegisterProductBySelenideTest extends EcCube3Test {
   @Test
    public void ThenIcanSearchTheProductWithKeyword() throws Exception {
        LoginPage loginPage = open("/admin", LoginPage.class);
        AdminPage adminPage = loginPage.login(ecCube3Configuration.get(ConfigurationKey.ADMIN_ID), ecCube3Configuration.get(ConfigurationKey.ADMIN_PASSWORD));
        ProductNewPage productNewPage = adminPage.openProudctNew();

        Thread.sleep(3000);
    }

    @Test
    public void testProduct() {
        Product product = Product.getFixture();
        System.out.println("productName = " + product.getProductName());
    }
}
