package eccube3.scenarios;

import eccube3.constant.ConfigurationKey;
import eccube3.core.EcCube3Test;
import eccube3.data.Product;
import eccube3.pages.admin.AdminPage;
import eccube3.pages.admin.LoginPage;
import eccube3.pages.admin.ProductNewPage;
import eccube3.pages.front.FrontPage;
import eccube3.pages.front.ProductDetailPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class WhenIRegisterProductTest extends EcCube3Test {
    private Product product;
    @Before
    public void setUp() {
         // 商品を登録したら
        LoginPage loginPage = open("/admin", LoginPage.class);
        AdminPage adminPage = loginPage.login(ecCube3Configuration.get(ConfigurationKey.ADMIN_ID), ecCube3Configuration.get(ConfigurationKey.ADMIN_PASSWORD));
        ProductNewPage productNewPage = adminPage.openProductNew();

        product = Product.getFixture();
        productNewPage.registerProduct(product);
    }

    @Test
    public void ThenICanSearchTheProductWithKeyword() throws Exception {
       // フロント側で検索すると表示される
        FrontPage frontPage = open("/", FrontPage.class);
        frontPage.search(product);

        frontPage.getItemName().shouldHave(text(product.getProductName()));
    }

    @Test
    public void ThenICanOpenDetailOfTheProduct() throws Exception {
        // リンクをクリックすると、詳細ページに行ける
        FrontPage frontPage = open("/", FrontPage.class);
        ProductDetailPage productDetailPage = frontPage.openProductDetail(product);

        productDetailPage.getItemName().shouldHave(text(product.getProductName()));
    }
}
