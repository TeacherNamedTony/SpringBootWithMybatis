package cn.am.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Clibrary extends Library {
    Clibrary INSTANCE = (Clibrary) Native.load("license",
            Clibrary.class);
    int RsaLicenseEncode(String licensestr, int licensestrlen, byte[] outStr, int outstrMaxSize);
}
