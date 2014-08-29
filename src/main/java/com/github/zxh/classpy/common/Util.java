package com.github.zxh.classpy.common;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author zxh
 */
public class Util {
    
    /**
     * Convert i to HEX string.
     * 
     * @param i
     * @return 
     */
    public static String toHexString(int i) {
        return "0x" + Integer.toHexString(i);
    }
    
    /**
     * Convert index to String.
     * Examples:
     * maxIndex index result
     *   9        8    #8
     *  15        8    #08
     *  15       12    #12
     * 123        8    #008
     * 123       12    #012
     * 123      120    #120
     * 
     * @param maxIndex
     * @param index
     * @return 
     */
    public static String formatIndex(int maxIndex, int index) {
        int idxWidth = String.valueOf(maxIndex).length();
        String fmtStr = "#%0" + idxWidth + "d";
        return String.format(fmtStr, index);
    }
    
    /**
     * Cut the string and append ellipsis if it is too long.
     * @param str
     * @param maxLength
     * @return 
     */
    public static String cutAndAppendEllipsis(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        
        int cutPos = maxLength - 3;
        char firstCutChar = str.charAt(cutPos);
        
        if (Character.isLowSurrogate(firstCutChar)) {
            return str.substring(0, cutPos - 1) + "...";
        } else {
            return str.substring(0, cutPos) + "...";
        }
    }
    
    @SafeVarargs
    public static <T> List<T> listWithoutNulls(T... values) {
        return Stream.of(values)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    
}
