package com.cjg.action.vote;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cjg.action.rootaction.VoteRoot;

@SuppressWarnings("serial")
public class NewVote2 extends VoteRoot {
	private static final String ADDVOTEERROR = "addVoteError";

	@Override
	public String execute() throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		File file = new File("D:\\ftp\\apache-tomcat-7.0.75\\webapps\\Votesystem\\jsp\\img\\09.pdf");
	       if (!file.exists()) {
	           System.out.println("file not found");
	       }
	       InputStream in = null;
	       OutputStream os = null;
	       try {
	           response.setContentType("application/pdf"); // 设置返回内容格式
	           in = new FileInputStream(file);   //用该文件创建一个输入流
	           os = response.getOutputStream();  //创建输出流
	           byte[] b = new byte[1024];
	           while (in.read(b) != -1) {
	               os.write(b);
	           }
	           in.close();
	           os.flush();
	           os.close();
	       } catch (Exception e) {
	           try {
	               if (null != in) {
	                   in.close();
	               }
	           } catch (IOException e1) {
	               e1.printStackTrace();
	           }
	           try {
	               if (null != os) {
	                   os.close();
	               }
	           } catch (IOException e2) {
	               e2.printStackTrace();
	           }


	       }
	       return null;
	}
}
