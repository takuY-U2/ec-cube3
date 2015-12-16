package eccube3.pages.admin;

import eccube3.data.Product;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by kenichiro_ota on 2015/12/15.
 */
public class ProductNewPage {
    public AdminPage registerProduct(Product product) {
        $("#admin_product_name").setValue(product.getProductName());
        $("#admin_product_class_product_type_" + Integer.toString(product.getProductType())).setValue(Integer.toString(product.getProductType()));
        $("#admin_product_description_detail").setValue(product.getProductDescriptionDetail());
        $("#admin_product_class_price02").setValue(Integer.toString(product.getSellingPrice()));
        $("#admin_product_class_stock").setValue(Integer.toString(product.getProductStock()));
        $("#admin_product_Category").parent().parent().$("a").click(); //商品カテゴリのアコーディオンパネルを開く
        $("#admin_product_Category_" + Integer.toString(product.getProductCategory())).setSelected(true);

        executeJavaScript("scroll(0, 0);"); // 公開、非公開を押せるように画面を一番上に戻す
        $("#admin_product_Status_" + Integer.toString(product.getProductStatus())).click();

        $$("#aside_column button").first().click();
        return page(AdminPage.class);
    }
}
