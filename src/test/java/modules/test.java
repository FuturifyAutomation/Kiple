package modules;

import configurations.TestInitiation;
import objects.SignUpLocators;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.AndroidPageFactory;

public class test extends TestInitiation {

    private SignUpLocators signUp;

    @BeforeMethod
    public void setUp(){
        signUp = AndroidPageFactory.initElements(androidDriver, SignUpLocators.class);
    }

    @Test
    public void testcase() throws InterruptedException {
        signUp.signUpAccount("test", "name", "qdo25@gmail.com", "q11111", "","123456", "123456");
    }
}
