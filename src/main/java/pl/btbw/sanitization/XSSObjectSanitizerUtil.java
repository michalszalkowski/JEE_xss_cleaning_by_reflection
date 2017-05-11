package pl.btbw.sanitization;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

public class XSSObjectSanitizerUtil {

	public static void sanitizer(Object object) {

		try {

			Field[] fields = object.getClass().getDeclaredFields();

			for (Field field : fields) {

				field.setAccessible(true);

				if (field.getType().equals(String.class)) {

					String value = (String) field.get(object);
					field.set(object, XSSObjectSanitizerUtil.clean(value));

				} else if (field.getType().equals(List.class)) {

					List value = (List) field.get(object);
					for (Object subObject : value) {
						sanitizer(subObject);
					}

				} else if (omit(field.getType())) {
					System.out.println("We are not cleaning:" + field.getType());
				} else {
					Object subObject = field.get(object);

					if (subObject != null) {
						sanitizer(subObject);
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean omit(Class<?> type) {
		return type.equals(Boolean.class)
				|| type.equals(Date.class)
				|| type.equals(Integer.class)
				|| type.equals(XMLGregorianCalendar.class)
				;
	}

	// this is only experiment
	private static String clean(String str) {
		String newValue = str.replaceAll("<[^>]*>", "");
		if (!str.equals(newValue)) {
			System.out.println("XSS Detect. Old Value: " + str + ", new value: " + newValue);
		}
		return newValue;
	}

}