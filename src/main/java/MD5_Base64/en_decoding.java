package MD5_Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Author XDW
 * @Version 1.0
 * @date 2022/11/4 10:37
 */
public class en_decoding {
    /**
     * base64 加密
     * @param text
     * @return encodeStr
     * @throws UnsupportedEncodingException
     */
    public static String encoderBASE64(String text) throws UnsupportedEncodingException {
        byte[] textByte = text.getBytes("UTF-8");
        final BASE64Encoder encoder = new BASE64Encoder();
        final String encodeStr = encoder.encode(textByte);
        return encodeStr;
    }

    /**
     * base64 解密
     * @param encodeStr
     * @return decoderStr
     * @throws IOException
     */
    public static String decoderBASE64(String encodeStr) throws IOException {
        final BASE64Decoder decoder = new BASE64Decoder();
        byte[] textByte = decoder.decodeBuffer(encodeStr);
        String decoderStr = new String(textByte, "UTF-8");
        return decoderStr;
    }
}
