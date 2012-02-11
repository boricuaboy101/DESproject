import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
//Joshua Rolon
//Sam Harlan

public class question4decoder {
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
		byte [] ct1;
		byte [] ct2;
		byte [] ct3;
		byte[] ct4;


	
		
		keyBytes  = new byte[] {(byte) 0x2C, (byte) 0x1E, (byte) 0xFE, (byte) 0xEE, (byte) 0xCA, (byte) 0x17, (byte) 0x2D, (byte) 0x00};
		ct = new byte [] {(byte) 0x19, (byte) 0x51, (byte) 0xC3, (byte) 0x71, (byte) 0xAA, (byte) 0xA7, (byte) 0x1F, (byte) 0x4E};
		ct1 = new byte [] {(byte) 0x83, (byte) 0xBE, (byte) 0x83, (byte) 0xF4, (byte) 0xC2, (byte) 0x1F, (byte) 0x0B, (byte) 0x6E};
		ct2 = new byte [] {(byte) 0x20, (byte) 0xC2, (byte) 0xA1, (byte) 0x93, (byte) 0x46, (byte) 0x91, (byte) 0x49, (byte) 0xD3};
		ct3 = new byte [] {(byte) 0x71, (byte) 0x01, (byte) 0xAF, (byte) 0xE3, (byte) 0xBE, (byte) 0xA9, (byte) 0x8B, (byte) 0x79};
		ct4= new byte [] {(byte) 0x1B, (byte) 0xC7, (byte) 0x48, (byte) 0x96, (byte) 0x6D, (byte) 0xCD, (byte) 0xDF, (byte) 0x3C};
		key = new SecretKeySpec(keyBytes, "DES");

		try
		{
			cipher = Cipher.getInstance("DES/ECB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			pt = cipher.doFinal(ct);
			printByteArray(pt);
			pt = cipher.doFinal(ct1);
			printByteArray(pt);
			pt = cipher.doFinal(ct2);
			printByteArray(pt);
			pt = cipher.doFinal(ct3);
			printByteArray(pt);
			pt = cipher.doFinal(ct4);
			printByteArray(pt);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
