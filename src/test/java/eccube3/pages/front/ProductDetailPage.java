package eccube3.pages.front;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by kenichiro_ota on 2015/12/17.
 */
public class ProductDetailPage {
        public SelenideElement getItemName() {
        return $(".item_name");
    }
}
