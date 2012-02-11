import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
//Joshua Rolon
//Sam Harlan

public class question3multithreaded implements Runnable {
	static int x=1;
	Boolean solutionFound=false;
	
	public static void printKeyByteArray(byte [] array)
    {
        System.out.print("Key: ");
        System.out.print("[");
        for(int i = 0; i < array.length-1; i++)
        {
            System.out.print(Integer.toHexString((array[i]>>4)&0x0F).toUpperCase());
            System.out.print(Integer.toHexString(array[i]&0x0F).toUpperCase() + ", ");
        }
        System.out.print(Integer.toHexString(array[array.length-1]>>4&0x0F).toUpperCase());
        System.out.println(Integer.toHexString(array[array.length-1]&0x0F).toUpperCase() + "]");
    }
	
	public static String byteArrayToString(byte [] array)
    {
        return new String(array);
    }
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
    
    
	

	public void threadChoice(int x) {
		  	Cipher cipher;
	        SecretKeySpec key;
	       
	        //Thread One Variables
	        byte [] keyBytest1;
	        byte [] ptt1;
	        byte [] ctt1;
	        keyBytest1 = new byte [] {(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
	        ctt1 = new byte [] {(byte) 0x20, (byte) 0xAD, (byte) 0xFD, (byte) 0xBF, (byte) 0x1B, (byte) 0xB6, (byte) 0x9F, (byte) 0x4B};
	        int countert1 = 1;
	        int counter2t1 = 0;
	        //Thread Two Variables
	        byte [] keyBytest2;
	        byte [] ptt2;
	        byte [] ctt2;
	        keyBytest2 = new byte [] {(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x7F, (byte) 0x7F, (byte) 0x7F, (byte) 0x7F};
	        ctt2 = new byte [] {(byte) 0x20, (byte) 0xAD, (byte) 0xFD, (byte) 0xBF, (byte) 0x1B, (byte) 0xB6, (byte) 0x9F, (byte) 0x4B};
	        int countert2 = 1;
	        int counter2t2 = 0;
	        //Thread Three Variables
	        byte [] keyBytest3;
	        byte [] ptt3;
	        byte [] ctt3;
	        keyBytest3 = new byte [] {(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x7F, (byte) 0x7F, (byte) 0x7F, (byte) 0x7F};
	        ctt3 = new byte [] {(byte) 0x20, (byte) 0xAD, (byte) 0xFD, (byte) 0xBF, (byte) 0x1B, (byte) 0xB6, (byte) 0x9F, (byte) 0x4B};
	        int countert3 = 1;
	        int counter2t3 = 0;
	        //Thread Four Variables
	        byte [] keyBytest4;
	        byte [] ptt4;
	        byte [] ctt4;
	        keyBytest4 = new byte [] {(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
	        ctt4 = new byte [] {(byte) 0x20, (byte) 0xAD, (byte) 0xFD, (byte) 0xBF, (byte) 0x1B, (byte) 0xB6, (byte) 0x9F, (byte) 0x4B};
	        int countert4 = 1;
	        int counter2t4 = 0;
		
		
		
		
		
		switch (x){
		case 1:  try{
        	
        for(int i = 0; i < 256; i++)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
            countert1 = 1;
            System.out.println("Byte 4 incremented "+counter2t1+" times");
            for (int j = 0; j < 256; j++)
            {
            	if (countert1 % 50 == 0)
            		System.out.println(countert1);
            	
               
               
                for (int k = 0; k<256; k++)
                {
                    for (int l = 0; l <256; l++)
                    {
                        key = new SecretKeySpec(keyBytest1, "DES");
                            if(solutionFound){
                            	System.exit(0);
                            }
                            cipher.init(Cipher.DECRYPT_MODE, key);
                           
                            ptt1 = cipher.doFinal(ctt1);
                           
                        
                            if (new String(ptt1).equals("Plaintxt"))
                            {
                                printByteArray(ptt1);
                                solutionFound=true;
                                printKeyByteArray(keyBytest1);
                                System.out.println("answer");
                                System.exit(0);
                            }
                        

                        keyBytest1[4] = (byte) (keyBytest1[4] + 1);
                    }
                    keyBytest1[5] = (byte) (keyBytest1[5] + 1);
                }
                keyBytest1[6] = (byte) (keyBytest1[6] + 1);
                countert1++;
            }
            keyBytest1[7] = (byte) (keyBytest1[7] + 1);
           counter2t1++;
        }
       //delimits last for loop
    }
    catch(Exception e)
                        {
                            e.printStackTrace();
                        }break;
		case 2:try{
        	
        for(int i = 0; i < 256; i++)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
            countert2 = 1;
            System.out.println("Byte 4 incremented "+counter2t2+" times");
            for (int j = 0; j < 256; j++)
            {
            	if (countert2 % 50 == 0)
            		System.out.println(countert2);
            	
               
               
                for (int k = 0; k<256; k++)
                {
                    for (int l = 0; l <256; l++)
                    {
                        key = new SecretKeySpec(keyBytest2, "DES");
                        if(solutionFound){
                        	System.exit(0);
                        }
                            cipher.init(Cipher.DECRYPT_MODE, key);
                            
                            ptt2 = cipher.doFinal(ctt2);
                           
                        
                            if (new String(ptt2).equals("Plaintxt"))
                            {
                                printByteArray(ptt2);
                                solutionFound=true;
                                printKeyByteArray(keyBytest2);
                                System.out.println("answer");
                                System.exit(0);
                            }
                        

                        keyBytest2[4] = (byte) (keyBytest2[4] - 1);
                    }
                    keyBytest2[5] = (byte) (keyBytest2[5] - 1);
                }
                keyBytest2[6] = (byte) (keyBytest2[6] - 1);
                countert2++;
            }
            keyBytest2[7] = (byte) (keyBytest2[7] - 1);
           counter2t2++;
        }
       //delimits last for loop
    }
    catch(Exception e)
                        {
                            e.printStackTrace();
                        }break;
		case 3: try{
        	
        for(int i = 0; i < 256; i++)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
            countert3 = 1;
            System.out.println("Byte 4 incremented "+counter2t3+" times");
            for (int j = 0; j < 256; j++)
            {
            	if (countert3 % 50 == 0)
            		System.out.println(countert3);
            	
               
               
                for (int k = 0; k<256; k++)
                {
                    for (int l = 0; l <256; l++)
                    {
                        key = new SecretKeySpec(keyBytest3, "DES");
                        if(solutionFound){
                        	System.exit(0);
                        }
                            cipher.init(Cipher.DECRYPT_MODE, key);
                            
                            ptt3 = cipher.doFinal(ctt3);
                           
                        
                            if (new String(ptt3).equals("Plaintxt"))
                            {
                                printByteArray(ptt3);
                                solutionFound=true;
                                printKeyByteArray(keyBytest3);
                                System.out.println("answer");
                                System.exit(0);
                            }
                        

                        keyBytest3[4] = (byte) (keyBytest3[4] + 1);
                    }
                    keyBytest3[5] = (byte) (keyBytest3[5] + 1);
                }
                keyBytest3[6] = (byte) (keyBytest3[6] + 1);
                countert3++;
            }
            keyBytest3[7] = (byte) (keyBytest3[7] + 1);
           counter2t3++;
        }
       //delimits last for loop
    }
    catch(Exception e)
                        {
                            e.printStackTrace();
                        }break;
	case 4: try{
    	
    for(int i = 0; i < 256; i++)
    {
    	cipher = Cipher.getInstance("DES/ECB/NoPadding");
        countert4 = 1;
        System.out.println("Byte 4 incremented "+counter2t4+" times");
        for (int j = 0; j < 256; j++)
        {
        	if (countert4 % 50 == 0)
        		System.out.println(countert4);
        	
           
           
            for (int k = 0; k<256; k++)
            {
                for (int l = 0; l <256; l++)
                {
                    key = new SecretKeySpec(keyBytest4, "DES");
                    if(solutionFound){
                    	System.exit(0);
                    }
                        cipher.init(Cipher.DECRYPT_MODE, key);
                        
                        ptt4 = cipher.doFinal(ctt4);
                       
                    
                        if (new String(ptt4).equals("Plaintxt"))
                        {
                        	solutionFound=true;
                            printByteArray(ptt4);
                            printKeyByteArray(keyBytest4);
                            System.out.println("answer");
                            System.exit(0);
                        }
                    

                    keyBytest4[4] = (byte) (keyBytest4[4] - 1);
                }
                keyBytest4[5] = (byte) (keyBytest4[5] - 1);
            }
            keyBytest4[6] = (byte) (keyBytest4[6] - 1);
            countert4++;
        }
        keyBytest4[7] = (byte) (keyBytest4[7] - 1);
       counter2t4++;
    }
   //delimits last for loop
}
catch(Exception e)
                    {
                        e.printStackTrace();
                    }break;
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		threadChoice(x);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Thread(new question3multithreaded())).start();
		x=2;
		(new Thread(new question3multithreaded())).start();
		x=3;
		(new Thread(new question3multithreaded())).start();
		x=4;
		(new Thread(new question3multithreaded())).start();
	}
}
	
	


