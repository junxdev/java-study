package com.bit.day26;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

public class Ex09ObjectOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data4.bin";
		File file = new File(path);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			String msg = new String("오브젝트 작성");
			oos.writeObject(msg);
			
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(1);
			arr.add(22);
			arr.add(333);
			arr.add(4444);
			oos.writeObject(arr);
			
			Vector vec = new Vector();
			vec.add(1243);
			vec.add(3.14);
			vec.add(true);
			vec.add("Right");
			vec.add('c');
			oos.writeObject(vec);
			
			int[] sus = {1, 3, 5, 7, 9};
			oos.writeObject(sus);
			
			Vector v = new Vector();
			v.add(arr);
			v.add(vec);
			v.add(sus);
			oos.writeObject(v);
			
//			oos.writeObject(new Student01DataStream()); // Serializable interface 상속
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
