package com.share.portal.util;

import java.util.Random;

/**
 * Created by  bin
 * Time： 2017/8/17.
 */
public class IdentifyingCodeUtil {

    private static String  identifyingCode = "";
    public String onlyNumber(int length){

        for(int i=0;i<length;i++){
            identifyingCode+=(int)(Math.random()*10);
        }
        return identifyingCode;
    }

    public String NumberAndLetter(int length){
        Random random = new Random();
        for(int i=0;i<length;i++){
            int temp = random.nextInt(3)%3;
            if(temp==0){
                identifyingCode+=(char)(random.nextInt(10)+48);
            }else if(temp==1){
                identifyingCode+=(char)(random.nextInt(26)+65);
            }else{
                identifyingCode+=(char)(random.nextInt(26)+97);
            }
        }
        return identifyingCode;
    }


}
