package com.bit.day22;

import java.io.IOException;

public class Ex10LoadImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path1 = "botanic.jpg";
		java.io.File source = new java.io.File(path1);
		System.out.println(source.exists());
		
		java.io.FileInputStream fis = null;
		
		String path2 = ".\\copy\\copy.jpg";
		java.io.File target = new java.io.File(path2);
		java.io.FileOutputStream fos = null;
		
		java.io.File par = new java.io.File(target.getParent());
		par.mkdirs();
		
		try {
			if(!target.exists()) {
				target.createNewFile();
			}
			fis = new java.io.FileInputStream(source);
			fos = new java.io.FileOutputStream(target);
			
			while(true) {
				int su = fis.read();
				if(su == -1) {
					break;
				}
				fos.write(su);
			}
			System.out.println("복사 끝");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) {
					fis.close();
				}
				if(fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
