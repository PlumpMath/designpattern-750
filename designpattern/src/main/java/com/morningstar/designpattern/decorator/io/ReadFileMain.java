package com.morningstar.designpattern.decorator.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ReadFileMain {
	static String charSet = "UTF-8";
	static int charBufferSize = 1*1024*1024; //1M

	public static void main(String[] args) {
		int docNum = 0;
		LineNumberReader reader = null;
		String filename = "C:/cygwin64/tmp/realtime/11.txt";
		try {
			long start = System.currentTimeMillis();
			InputStream is = new FileInputStream(new File(filename));
//			is = new BufferedInputStream(is, charBufferSize);
			reader = new LineNumberReader(new InputStreamReader(is, charSet), charBufferSize);
			String line = "";
			while(null != (line = reader.readLine())){
				System.out.println(reader.getLineNumber() + ":" + line);
			}
			long gap = System.currentTimeMillis() - start;
			System.out.println("cost:" + gap);
		} catch(Exception e){
			e.printStackTrace();
			System.err.println(docNum);
		} finally{
			if(null != reader){
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
