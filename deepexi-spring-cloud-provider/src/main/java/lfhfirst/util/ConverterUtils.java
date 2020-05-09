package lfhfirst.util;


import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterUtils {
    private static ConversionService conversionService;

    public static void setConversionService(ConversionService conversionService) {
        ConverterUtils.conversionService = conversionService;
    }

    public static <FROM, TO> TO convert(FROM from, Class<TO> toClazz) {
        if (conversionService.canConvert(from.getClass(), toClazz)) {
            try {
                return conversionService.convert(from, toClazz);
            } catch (ConversionFailedException e) {
                Throwable rootCause = e.getCause();
                throw e;
            }
        } else {
            try {
                TO to = toClazz.newInstance();
                BeanUtils.copyProperties(from, to);
                return to;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <enumFrom, enumTo> enumTo convertEnum(enumFrom from, Class<enumTo> to) {
        enumTo rReturn = null;

        if (to.isEnum()) {
            enumTo[] array = to.getEnumConstants();

            for (enumTo enu : array) {
                if (enu.toString().equals(from.toString())) {
                    rReturn = enu;
                    break;
                }
            }
        }
        return rReturn;
    }

    public static <FROM, TO> List<TO> convertAll(List<FROM> fromList, Class<TO> toCls) {
        if (fromList == null || fromList.size() == 0) {
            return new ArrayList<>();
        }

        return fromList
                .stream()
                .map(from -> convert(from, toCls)).collect(Collectors.toList());
    }
}
