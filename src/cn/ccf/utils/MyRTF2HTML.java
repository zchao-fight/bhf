package cn.ccf.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyRTF2HTML {

	

	 /** 
    * 根据byte数组，生成文件 
    */  
   public static void getFile(byte[] bfile, String filePath,String fileName) {  
       BufferedOutputStream bos = null;  
       FileOutputStream fos = null;  
       File file = null;  
       try {  
           File dir = new File(filePath);  
           if(!dir.exists()){//判断文件目录是否存在  
               dir.mkdirs();  
           }  
           
           file = new File(filePath+"\\"+fileName);  
           fos = new FileOutputStream(file);  
           bos = new BufferedOutputStream(fos);  
           bos.write(bfile);  
       } catch (Exception e) {  
           e.printStackTrace();  
       } finally {  
           if (bos != null) {  
               try {  
                   bos.close();  
               } catch (IOException e1) {  
                   e1.printStackTrace();  
               }  
           }  
           if (fos != null) {  
               try {  
                   fos.close();  
               } catch (IOException e1) {  
                   e1.printStackTrace();  
               }  
           }  
       }  
   }
	
}
