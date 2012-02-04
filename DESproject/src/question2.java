import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class question2 {
	public static void printByteArray(byte [] array)
    {
		System.out.print("Plain Text Hex Format: ");
        System.out.print("[");
        for(int i = 0; i < array.length-1; i++)
        {
            System.out.print(Integer.toHexString((array[i]>>4)&0x0F).toUpperCase());
            System.out.print(Integer.toHexString(array[i]&0x0F).toUpperCase() + ", ");
        }
        System.out.print(Integer.toHexString(array[array.length-1]>>4&0x0F).toUpperCase());
        System.out.println(Integer.toHexString(array[array.length-1]&0x0F).toUpperCase() + "]");
        String str = new String(array); 
        System.out.println("Plain Text Readable: "+str);
    }
	public static String byteArrayToString(byte [] array)
    {
		return new String(array);
    }

	public static void main (String [] args)
	{
		Cipher cipher;
		SecretKeySpec key;

		byte [] keyBytes;
		byte [] pt;
		byte [] ct;


		//keyBytes  = new byte[] {(byte) 0xFF, (byte) 0x11, (byte) 0xEE, (byte) 0x22, (byte) 0xDD, (byte) 0x33, (byte) 0xCC, (byte) 0x44};
		
			keyBytes  = new byte[] {(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x88, (byte) 0x88, (byte) 0x88, (byte) 0x88};
		
		//ct = new byte[] {(byte) 0x13, (byte) 0x75, (byte) 0x58, (byte) 0x17, (byte) 0xF9, (byte) 0xBE, (byte) 0x80, (byte) 0x1D};
		
		
		ct = new byte [] {(byte) 0x20, (byte) 0xAD, (byte) 0xFD, (byte) 0xBF, (byte) 0x1B, (byte) 0xB6, (byte) 0x9F, (byte) 0x4B};
		key = new SecretKeySpec(keyBytes, "DES");

		try
		{
			cipher = Cipher.getInstance("DES/ECB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			pt = cipher.doFinal(ct);
			printByteArray(pt);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}