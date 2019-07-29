package commTool;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class AESUtil {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String KEY_AES = "AES";
    private static final String KEY_MD5 = "MD5";
    private static MessageDigest md5Digest;
    static {
        try {
            md5Digest = MessageDigest.getInstance(KEY_MD5);
        } catch (NoSuchAlgorithmException e) {

        }
    }


    //加密方法使用示例：
    public static void main(String[] args) throws Exception {
        String key = "caca8105003a7e1a4f6fea8b585bd2a1";
//        String data = "{\"head\":{\"platform\":\"RBJF\",\"requestType\":10,\"timeStamp\":\"\",\"extTransactionNo\":\"\",\"localTransactionNo\":\"\",\"systemId\":\"\",\"MD5\":\"\",\"errorCode\":\"\",\"errorMessage\":\"\"},\"body\":{\"mainInfo\":{\"channelId\":\"CH10000020\",\"agentCode\":\"\",\"userId\":\"ABX999999\"}}}";
        String data = "y2kjguojIc39Fk404PKYrzr+fsIHaJOttNfS9ztbyr5sEyqvFrlpEHifKrf+U/LL+h8e8MVT5kvtWRRJKYghJ719AhRjKt3WY9iVjxgtcHmtzrawb/j7zT49+1VewnSNpdIkQfuzu84uujcoOan48paOnSlC7Ny9A2mWivyvlvwCV4T39CapVbySZMpgzDqJNEo4qCA30BEQny0Ta7U+ACvzAEaW34Kz/A4NG/yuyHNEKiXFeNMdl35pyrV99UEIfS7q2VJZNuS9t538kAyo3lhY2/0l7egArNotuGkoXU2vWsvpd7/Mb/sN325Y/mipu3gGqlyR7K/QTmUnQzr1IMTqUO4HD/HKbfoICcQ2gqlH9l3kyCWZ+/Zs6IujwfCIBhLvM5y/q0NhpJ/VfmMEdkmHovcydA7G3l0ka1uAnCbgP6mp2rMTUoD+tvx+U2VZNMZyBqOcMysfBOzptPhWfGm8UGQzfNpZF2N0V3gdtSY=";
//        String encrypted = AESUtil.encrypt(data, key);
//        String decrypted = AESUtil.decrypt(data, key);
//        System.out.println("加密后的密文\n" + encrypted);
//        System.out.println("解密后的报文:\n" + decrypted);

        System.out.println(AESUtil.decrypt("DfwMFSv4f0d8skfEXKaGA0R9uB9Ka3jQ5ElQXjRbcxg=", "IDon'tKnow"));
        System.out.println(AESUtil.encrypt("410323200109060539", "IDon'tKnow"));



    }
    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @param key 加密密码
     * @return
     */
    public static String encrypt(String data, String key) {
        return doAES(data, key, Cipher.ENCRYPT_MODE);
    }
    /**
     * 解密
     *
     * @param data 待解密内容
     * @param key 解密密钥
     * @return
     */
    public static String decrypt(String data, String key) {
        return doAES(data, key, Cipher.DECRYPT_MODE);
    }


    /**
     * 加解密
     *
     * @param data
     * @param key
     * @param mode
     * @return
     */
    private static String doAES(String data, String key, int mode) {
        try {
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] content;
            if (encrypt) {
                content = data.getBytes(DEFAULT_CHARSET);
            } else {
                content = Base64.decodeBase64(data.getBytes());
            }
            SecretKeySpec keySpec = new SecretKeySpec(md5Digest.digest(key.getBytes(DEFAULT_CHARSET))
                    , KEY_AES);
            Cipher cipher = Cipher.getInstance(KEY_AES);// 创建密码器
            cipher.init(mode, keySpec);// 初始化
            byte[] result = cipher.doFinal(content);
            if (encrypt) {
                return new String(Base64.encodeBase64(result));
            } else {
                return new String(result, DEFAULT_CHARSET);
            }
        } catch (Exception e) {
        }
        return null;
    }
}

