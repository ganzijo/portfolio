package parserValidCheck;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.ke.css.cimp.common.XML_Maker;

public class CastingTest {
	static Object testObj = new Object();
	static Object testObj2 = new Object();
	static Object parserObj = new Object();

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Method ruleMethod = null;
		Class<?> ruleCls = Class.forName("com.ke.css.cimp." + "fhl" + "." + "fhl4" + ".Rule");
		Class<?> visitorCls = Class.forName("com.ke.css.cimp." + "fhl" + "." + "fhl4" + ".Visitor");
		Class<?> xmlDisplayerCls = Class.forName("com.ke.css.cimp." + "fhl" + "." + "fhl4" + ".XmlDisplayer");

		XML_Maker XML_FHL = new XML_Maker();

		// xmlDisplayer를 통한 xmlData make
		Constructor<?>[] constructors = xmlDisplayerCls.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			testObj = constructor.newInstance(XML_FHL);
		}

		Constructor<?>[] constructorss = visitorCls.getDeclaredConstructors();
		for (Constructor<?> constructor : constructorss) {
			testObj2 = constructor.newInstance("Visitor");
		}
//		System.out.println(testObj2.getClass());
		System.out.println(Arrays.asList(visitorCls).get(0));
		
//		ruleMethod = ruleCls.getMethod("accept", visitorCls);
		ruleMethod.invoke(parserObj, testObj);
//		System.out.println(XML_FHL.getXmlData());
	}
}
