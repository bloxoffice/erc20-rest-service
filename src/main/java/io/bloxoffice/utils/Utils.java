package io.bloxoffice.utils;


import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mamu on 3/24/18.
 */
public class Utils {


  public static void copyNonNullProperties (Object source, Object dest) throws InvocationTargetException,
          IllegalAccessException {
    final BeanWrapper src = new BeanWrapperImpl(source);
    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<>();
    for(java.beans.PropertyDescriptor pd : pds) {
      Object srcValue = src.getPropertyValue(pd.getName());
      if (srcValue == null) BeanUtils.copyProperty(source, pd.getName(), dest);
    }

  }

}
