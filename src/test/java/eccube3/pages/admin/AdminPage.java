package eccube3.pages.admin;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by kenichiro_ota on 2015/12/15.
 */
public class AdminPage {
    public ProductNewPage openProudctNew() {
        // 遷移を安定させるためにダイレクトに移動する
        open("/admin/product/product/new");
        return page(ProductNewPage.class);
    }
}
