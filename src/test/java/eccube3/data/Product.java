package eccube3.data;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import lombok.Data;

/**
 * Created by kenichiro_ota on 2015/12/15.
 */
@Data
public class Product {
    private String productName;
    private int productCategory;
    private String productClassCode;

    public static Product getFixture() {
        Fixture.of(Product.class).addTemplate("valid",  new Rule() { {
            add("productName", regex("\\w{16}"));
        }}
        );
        return Fixture.from(Product.class).gimme("valid");
    }
}
