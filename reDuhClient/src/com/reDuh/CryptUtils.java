package com.reDuh;

import com.sun.org.apache.xml.internal.security.utils.Base64;


public class CryptUtils
{

    public static String base64encode(byte[] bytes, int len)
    {
        byte[] tmpBytes = bytes;
        if (len < bytes.length)
        {
            tmpBytes = new byte[len];
            for (int i = 0; i < len; i++)
            {
                tmpBytes[i] = bytes[i];
            }
        }

        return base64encode(tmpBytes);
    }

    public static String base64encode(byte[] bytes)
    {
        return Base64.encode(bytes)
                    .replaceAll("\\+", "-")
                    .replaceAll("/", "_")
                    .replaceAll("[\r\n]", "");
    }

    public static byte[] base64decode(String str)
    {
        try
        {
            return Base64.decode(str.replaceAll("_", "/")
                    .replaceAll("-", "+")
                    .replaceAll("[\r\n]", "")
                    .getBytes());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Failed to decode base64: '" + str + "'");
        }

        return new byte[0];
    }
}
