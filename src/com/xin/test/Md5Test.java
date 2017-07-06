/**  
* @Title:  Md5Test.java
* @Package com.xin.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Hou Dongchang
* @date  2017年5月21日 下午1:55:21
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.xin.test;

import java.util.Scanner;

import org.junit.Test;

import com.xin.security.Md5;

/**
 * @ClassName: Md5Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Hou Dongchang
 * @date 2017年5月21日 下午1:55:21
 *
 */
public class Md5Test {
    private Scanner in;

    /**
     * @Title: encodeByMD5 @Description: TODO(这里用一句话描述这个方法的作用) @author Hou
     *         Dongchang @throws
     */
    @Test
    public void encodeByMD5() {

	System.out.println("请输入要加密的密码：");
	in = new Scanner(System.in);
	String user = in.nextLine();
	String password = Md5.generatePassword(user);
	System.out.println("加密的内容是：");
	System.out.println(password);
    }
}
