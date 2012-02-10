import java.io.Console;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class question4multithreaded implements Runnable{
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
	        int counter2t1 = 0;
	        //Thread Two Variables
	        byte [] keyBytest2;
	        byte [] ptt2;
	        byte [] ctt2;
	        keyBytest2 = new byte [] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x17, (byte) 0x2D, (byte) 0x00};
	        ctt2 = new byte [] {(byte) 0x1B, (byte) 0xC7, (byte) 0x48, (byte) 0x96, (byte) 0x6D, (byte) 0xCD, (byte) 0xDF, (byte) 0x3C};
	        int counter2t2 = 0;
	      
		
		
		
		switch (x){
		case 1:  try{
			System.out.println("Case 1 is running");
        for(int m=0; m < 256; m+=2){	
        	System.out.println("Byte 4 incremented "+counter2t1+" times");
        for(int i = 0; i < 256; i+=2)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
         
            
            for (int j = 0; j < 256; j+=2)
            {
            	
               
                for (int k = 0; k<256; k+=2)
                {
                    for (int l = 0; l <256; l+=2)
                    {
                        key = new SecretKeySpec(keyBytest1, "DES");
                            if(solutionFound){
                            	System.exit(0);
                            }
                            
                            cipher.init(Cipher.DECRYPT_MODE, key);
                           
                            ptt1 = cipher.doFinal(ctt1);
                           // System.out.println(ptt1);
                        
                            if (new String(ptt1).equals("of Riedl"))
                            {
                                printByteArray(ptt1);
                                solutionFound=true;
                                printKeyByteArray(keyBytest1);
                                System.out.println("answer");
                                System.exit(0);
                            }
                        

                        keyBytest1[0] = (byte) (keyBytest1[0] + 2);
                    }
                    keyBytest1[1] = (byte) (keyBytest1[1] + 2);
                }
                keyBytest1[2] = (byte) (keyBytest1[2] + 2);
                
            }
            keyBytest1[3] = (byte) (keyBytest1[3] + 2);
          
        }
        keyBytest1[4] = (byte) (keyBytest1[4] + 2);
        counter2t1++;
        }
       //delimits last for loop
    }
    catch(Exception e)
                        {
                            e.printStackTrace();
                        }break;
		case 2:try{
			System.out.println("Case 2 is running");
		for(int m=0; m < 256; m+=2){	
			 System.out.println("Byte 0 incremented "+counter2t2+" times");
        for(int i = 0; i < 256; i+=2)
        {
        	cipher = Cipher.getInstance("DES/ECB/NoPadding");
     
           
            for (int j = 0; j < 256; j+=2)
            {
            	
            	
               
               
                for (int k = 0; k<256; k+=2)
                {
                    for (int l = 0; l <256; l+=2)
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
                        

                        keyBytest2[4] = (byte) (keyBytest2[4] + 2);
                    }
                    keyBytest2[3] = (byte) (keyBytest2[3] + 2);
                }
                keyBytest2[2] = (byte) (keyBytest2[2] + 2);
                
            }
            keyBytest2[1] = (byte) (keyBytest2[1] + 2);
           
        }
        keyBytest2[0] = (byte) (keyBytest2[0] + 2);
        counter2t2++;
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
		
		(new Thread(new question4multithreaded())).start();
		
		
	
		(new Thread(new question4multithreaded())).start();
		x=2;
		
	
		
		
	}
}
