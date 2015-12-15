package eccube3.core;

import com.codeborne.selenide.Configuration;
import eccube3.constant.ConfigurationKey;
import eccube3.util.EcCube3Configuration;
import org.junit.BeforeClass;

/**
 * Created by kenichiro_ota on 2014/04/21.
 */
public class EcCube3Test {
    protected static EcCube3Configuration ecCube3Configuration;
    @BeforeClass
    public static void setUpClass() {
       ecCube3Configuration = EcCube3Configuration.getInstance();
       Configuration.baseUrl = "http://" + ecCube3Configuration.get(ConfigurationKey.EC_CUBE3_ADDR);

    }
}
