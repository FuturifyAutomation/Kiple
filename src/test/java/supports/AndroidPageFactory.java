package supports;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class AndroidPageFactory {
    public AndroidPageFactory() {
    }

    public static <T> T initElements(AndroidDriver driver, Class<T> pageClassToProxy) {
        T page = instantiatePage(driver, pageClassToProxy);
        initElements(driver, page);
        return page;
    }

    public static void initElements(AndroidDriver driver, Object page) {
        initElements((ElementLocatorFactory)(new DefaultElementLocatorFactory(driver)), (Object)page);
    }

    public static void initElements(ElementLocatorFactory factory, Object page) {
        initElements((FieldDecorator)(new DefaultFieldDecorator(factory)), (Object)page);
    }

    public static void initElements(FieldDecorator decorator, Object page) {
        for(Class proxyIn = page.getClass(); proxyIn != Object.class; proxyIn = proxyIn.getSuperclass()) {
            proxyFields(decorator, page, proxyIn);
        }

    }

    private static void proxyFields(FieldDecorator decorator, Object page, Class<?> proxyIn) {
        Field[] fields = proxyIn.getDeclaredFields();
        Field[] var4 = fields;
        int var5 = fields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field field = var4[var6];
            Object value = decorator.decorate(page.getClass().getClassLoader(), field);
            if (value != null) {
                try {
                    field.setAccessible(true);
                    field.set(page, value);
                } catch (IllegalAccessException var10) {
                    throw new RuntimeException(var10);
                }
            }
        }

    }

    private static <T> T instantiatePage(AndroidDriver driver, Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor(AndroidDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException var3) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException var4) {
            throw new RuntimeException(var4);
        } catch (IllegalAccessException var5) {
            throw new RuntimeException(var5);
        } catch (InvocationTargetException var6) {
            throw new RuntimeException(var6);
        }
    }
}