package com.gupta.shanu.advanced_jaxrs_01.paramconverters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.gupta.shanu.advanced_jaxrs_01.model.MyDate;

@Provider
public class MyDateParamConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())){
			return new ParamConverter<T>(){

				@Override
				public T fromString(String value) {
					Calendar requiredDate = Calendar.getInstance();
					if(value.equalsIgnoreCase("tommorrow")){
						requiredDate.add(Calendar.DATE, 1);
					}else if(value.equalsIgnoreCase("yesterday")){
						requiredDate.add(Calendar.DATE, -1);
					}
					MyDate myDate = new MyDate();
					myDate.setDate(requiredDate.get(Calendar.DATE));
					myDate.setMonth(requiredDate.get(Calendar.MONTH));
					myDate.setYear(requiredDate.get(Calendar.YEAR));
					return rawType.cast(myDate);
				}

				@Override
				public String toString(Object value) {
					return value.toString();
				}
				
			};
		}
		return null;
	}

}
