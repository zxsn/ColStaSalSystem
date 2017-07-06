package com.xin.security;

/**
 * 工具类，生成随机验证码字符串
 * @version 1.0 2012/08/21
 *
 */
public class SecurityCode {   
    /**
     * 产生长度和难度任意的验证码
     * @param length  长度
     * @param level   难度级别
     * @return  String 验证码
     */
    public static String getSecurityCode(){
        
        //随机抽取len个字符
        int len=5;
        
        //字符集合(除去易混淆的数字0、数字1、字母l、字母o、字母O)
        char[] codes={'1','2','3','4','5','6','7','8','9',
                      'a','b','c','d','e','f','g','h','i',
                      'j','k','m','n','p','q','r','s','t',
                      'u','v','w','x','y','z','A','B','C',
                      'D','E','F','G','H','I','J','K','L',
                      'M','N','P','Q','R','S','T','U','V',
                      'W','X','Y','Z'};
         
        //字符集合长度
        int n=codes.length;
        
        //存放抽取出来的字符
        char[] result=new char[len];
        
        for(int i=0;i<result.length;i++){
            //索引 0 and n-1
            int r=(int)(Math.random()*n);
            
            //将result中的第i个元素设置为codes[r]存放的数值
            result[i]=codes[r];
            
            //必须确保不会再次抽取到那个字符，因为所有抽取的字符必须不相同。
            //因此，这里用数组中的最后一个字符改写codes[r]，并将n减1
            codes[r]=codes[n-1];
            n--;
        }
        
        
        return String.valueOf(result);
    }
}
