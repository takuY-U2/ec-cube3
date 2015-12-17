package eccube3.pages.front;

import com.codeborne.selenide.SelenideElement;
import eccube3.data.Product;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by kenichiro_ota on 2015/12/16.
 */
public class FrontPage {
    public FrontPage search(Product product) {
        $("#name").setValue(product.getProductName());
        $(".bt_search").click();

        return this;
    }

    public SelenideElement getItemName() {
        return $(".item_name");
    }

    public ProductDetailPage openProductDetail(Product product) {
        search(product);
        $(".item_name").click();

        return page(ProductDetailPage.class);
    }
}
