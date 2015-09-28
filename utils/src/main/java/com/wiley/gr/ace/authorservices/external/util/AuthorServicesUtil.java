/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/

package com.wiley.gr.ace.authorservices.external.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * The Class AuthorServicesUtil.
 *
 * @author virtusa version 1.0
 */
public class AuthorServicesUtil {

    /**
     * Read stream.
     *
     * @param is
     *            the is
     * @param bufferSize
     *            the buffer size
     * @return the string
     */
    public static String readStream(final InputStream is, final int bufferSize) {
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try (Reader in = new InputStreamReader(is, "UTF-8")) {
            for (;;) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0) {
                    break;
                }
                out.append(buffer, 0, rsz);
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return out.toString();
    }

    public static String encrypt(final String input) {
        final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
                'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
        Key key = new SecretKeySpec(keyValue, "AES");
        Cipher c;
        byte[] encVal = null;
        try {
            c = Cipher.getInstance("AES");

            c.init(Cipher.ENCRYPT_MODE, key);

            encVal = c.doFinal(input.getBytes());
        } catch (IllegalBlockSizeException | BadPaddingException
                | NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException e) {
            e.printStackTrace();
        }
        String encryptedValue = new Base64().encodeAsString(encVal);
        return encryptedValue;
    }

    public static String decrypt(final String input) {
        final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
                'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
        Key key = new SecretKeySpec(keyValue, "AES");
        Cipher c;
        byte[] decVal = null;
        try {
            c = Cipher.getInstance("AES");

            c.init(Cipher.DECRYPT_MODE, key);

            byte[] decordedValue = new Base64().decode(input);
            decVal = c.doFinal(decordedValue);
        } catch (IllegalBlockSizeException | BadPaddingException
                | NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException e) {
            e.printStackTrace();
        }

        return new String(decVal);

    }

}
