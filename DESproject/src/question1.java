import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class question1 {
//Joshua Rolon
//Sam Harlan
	public static void printByteArray(byte [] array)
    {
        System.out.print("[");
        for(int i = 0; i < array.length-1; i++)
        {
            System.out.print(Integer.toHexString((array[i]>>4)&0x0F).toUpperCase());
            System.out.print(Integer.toHexString(array[i]&0x0F).toUpperCase() + ", ");
        }
        System.out.print(Integer.toHexString(array[array.length-1]>>4&0x0F).toUpperCase());
        System.out.println(Integer.toHexString(array[array.length-1]&0x0F).toUpperCase() + "]");
    }

	public static void main (String [] args)
	{
		Cipher cipher;
		SecretKeySpec key;

		byte [] keyBytes;
		byte [] pt;
		byte [] ct;

		keyBytes  = new byte[] {(byte) 0xFF, (byte) 0x11, (byte) 0xEE, (byte) 0x22, (byte) 0xDD, (byte) 0x33, (byte) 0xCC, (byte) 0x44};
		pt = new byte[] {(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x89, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF};

		key = new SecretKeySpec(keyBytes, "DES");

		try
		{
			cipher = Cipher.getInstance("DES/ECB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			ct = cipher.doFinal(pt);
			printByteArray(ct);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//[F4, 43, F8, 88, D0, D2, 78, A7]
	}
}