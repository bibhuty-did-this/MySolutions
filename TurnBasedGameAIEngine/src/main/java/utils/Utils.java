package utils;

import java.util.Objects;
import java.util.function.Supplier;

public class Utils {
    public static Object getIfNull(Object o, Supplier<Object> supplier){
        if(Objects.isNull(o)){
            return supplier.get();
        }
        return o;
    }
}
