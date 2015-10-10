package leetcode;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;

/**
 * Created by huangd on 10/10/15.
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = {version1};
        String[] version2Array = {version2};
        String[] version1Parts = version1.split("\\.");
        version1Parts = version1Parts.length == 0 ? version1Array : version1Parts;
        String[] version2Parts = version2.split("\\.");
        version2Parts = version2Parts.length == 0 ? version2Array : version2Parts;
        int i = 0;
        for (; i < version1Parts.length && i < version2Parts.length; i++) {
            if (Integer.parseInt(version1Parts[i]) > Integer.parseInt(version2Parts[i])) {
                return 1;
            }
            if (Integer.parseInt(version1Parts[i]) < Integer.parseInt(version2Parts[i])) {
                return -1;
            }
        }

        if (version1Parts.length > version2Parts.length) {
            for (; i < version1Parts.length; i++) {
                if (Integer.parseInt(version1Parts[i]) > 0) {
                    return 1;
                }
            }
            return 0;
        }
        if (version1Parts.length < version2Parts.length) {
            for (; i < version2Parts.length; i++) {
                if (Integer.parseInt(version2Parts[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new CompareVersionNumber().compareVersion("1", "0");
    }
}
