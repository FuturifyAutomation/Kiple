package modules;

import configurations.TestInitiation;
import io.appium.java_client.android.Activity;
import objects.AddContactLocators;
import objects.SignUpLocators;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.AndroidPageFactory;

public class test extends TestInitiation {


    private AddContactLocators AddContactScreen;

    @BeforeMethod
    public void setUp(){
        AddContactScreen = AndroidPageFactory.initElements(androidDriver, AddContactLocators.class);
    }

    @Test
    public void testcase() throws InterruptedException {

    }
}
