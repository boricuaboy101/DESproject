import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class question4multithreaded {
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
	        keyBytest1 = new byte [] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x17, (byte) 0x2D, (byte) 0x00};
	        ctt1 = new byte [] {(byte) 0x1B, (byte) 0xC7, (byte) 0x48, (byte) 0x96, (byte) 0x6D, (byte) 0xCD, (byte) 0xDF, (byte) 0x3C};
	        int countert1 = 1;
	        int counter2t1 = 0;
	        //Thread Two Variables
	        byte [] keyBytest2;
	        byte [] ptt2;
	        byte [] ctt2;
	        keyBytest2 = new byte [] {(byte) 0x7F, (byte) 0x7F,  (byte) 0x7F,  (byte) 0x7F,  (byte) 0x7F, (byte) 0x17, (byte) 0x2D, (byte) 0x00};
	        ctt2 = new byte [] {(byte) 0x1B, (byte) 0xC7, (byte) 0x48, (byte) 0x96, (byte) 0x6D, (byte) 0xCD, (byte) 0xDF, (byte) 0x3C};
	        int countert2 = 1;
	        int counter2t2 = 0;
	        //Thread Three Variables
	        byte [] keyBytest3;
	        byte [] ptt3;
	        byte [] ctt3;
	        keyBytest3 = new byte [] {(byte) 0x7F, (byte) 0x7F,  (byte) 0x7F,  (byte) 0x7F,  (byte) 0x7F, (byte) 0x17, (byte) 0x2D, (byte) 0x00};
	        ctt3 = new byte [] {(byte) 0x1B, (byte) 0xC7, (byte) 0x48, (byte) 0x96, (byte) 0x6D, (byte) 0xCD, (byte) 0xDF, (byte) 0x3C};
	        int countert3 = 1;
	        int counter2t3 = 0;
	        //Thread Four Variables
	        byte [] keyBytest4;
	        byte [] ptt4;
	        byte [] ctt4;
	        keyBytest4 = new byte [] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x17, (byte) 0x2D, (byte) 0x00};
	        ctt4 = new byte [] {(byte) 0x1B, (byte) 0xC7, (byte) 0x48, (byte) 0x96, (byte) 0x6D, (byte) 0xCD, (byte) 0xDF, (byte) 0x3C};
	        int countert4 = 1;
	        int counter2t4 = 0;
		
		
		
		
		
		switch (x){
		case 1:  try{
        for(int m=0; m < 256; m++){	
        for(int i = 0; i < 256; i++)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
            countert1 = 1;
            System.out.println("Byte 1 incremented "+counter2t1+" times");
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
                           
                        
                            if (new String(ptt1).equals("of Riedl"))
                            {
                                printByteArray(ptt1);
                                solutionFound=true;
                                printKeyByteArray(keyBytest1);
                                System.out.println("answer");
                                System.exit(0);
                            }
                        

                        keyBytest1[0] = (byte) (keyBytest1[0] + 1);
                    }
                    keyBytest1[1] = (byte) (keyBytest1[1] + 1);
                }
                keyBytest1[2] = (byte) (keyBytest1[2] + 1);
                countert1++;
            }
            keyBytest1[3] = (byte) (keyBytest1[3] + 1);
           counter2t1++;
        }
        keyBytest1[4] = (byte) (keyBytest1[4] + 1);
        }
       //delimits last for loop
    }
    catch(Exception e)
                        {
                            e.printStackTrace();
                        }break;
		case 2:try{
		for(int m=0; m < 256; m++){		
        for(int i = 0; i < 256; i++)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
            countert2 = 1;
            System.out.println("Byte 1 incremented "+counter2t2+" times");
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
                           
                        
                            if (new String(ptt2).equals("of Riedl"))
                            {
                                printByteArray(ptt2);
                                solutionFound=true;
                                printKeyByteArray(keyBytest2);
                                System.out.println("answer");
                                System.exit(0);
                            }
                        

                        keyBytest2[0] = (byte) (keyBytest2[0] - 1);
                    }
                    keyBytest2[1] = (byte) (keyBytest2[1] - 1);
                }
                keyBytest2[2] = (byte) (keyBytest2[2] - 1);
                countert2++;
            }
            keyBytest2[3] = (byte) (keyBytest2[3] - 1);
           counter2t2++;
        }
        keyBytest2[4] = (byte) (keyBytest2[4] - 1);
		}
       //delimits last for loop
    }
    catch(Exception e)
                        {
                            e.printStackTrace();
                        }break;
		case 3: try{
		for(int m=0; m < 256; m++){		
        for(int i = 0; i < 256; i++)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
            countert3 = 1;
            System.out.println("Byte 1 incremented "+counter2t3+" times");
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
                           
                        
                            if (new String(ptt3).equals("of Riedl"))
                            {
                                printByteArray(ptt3);
                                solutionFound=true;
                                printKeyByteArray(keyBytest3);
                                System.out.println("answer");
                                System.exit(0);
                            }
                        

                        keyBytest3[0] = (byte) (keyBytest3[0] + 1);
                    }
                    keyBytest3[1] = (byte) (keyBytest3[1] + 1);
                }
                keyBytest3[2] = (byte) (keyBytest3[2] + 1);
                countert3++;
            }
            keyBytest3[3] = (byte) (keyBytest3[3] + 1);
           counter2t3++;
        }
        keyBytest3[4] = (byte) (keyBytest3[4] + 1);
		}
       //delimits last for loop
    }
    catch(Exception e)
                        {
                            e.printStackTrace();
                        }break;
	case 4: try{
	for(int m=0; m < 256; m++){		  	
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
                       
                    
                        if (new String(ptt4).equals("of Reidl"))
                        {
                        	solutionFound=true;
                            printByteArray(ptt4);
                            printKeyByteArray(keyBytest4);
                            System.out.println("answer");
                            System.exit(0);
                        }
                    

                    keyBytest4[0] = (byte) (keyBytest4[0] - 1);
                }
                keyBytest4[1] = (byte) (keyBytest4[1] - 1);
            }
            keyBytest4[2] = (byte) (keyBytest4[2] - 1);
            countert4++;
        }
        keyBytest4[3] = (byte) (keyBytest4[3] - 1);
       counter2t4++;
    }
    keyBytest3[4] = (byte) (keyBytest3[4] - 1);
	}
   //delimits last for loop
}
catch(Exception e)
                    {
                        e.printStackTrace();
                    }break;
		}
		
	}

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
