package com.bit.day22;

public class ShowDir01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String setPath = "C:\\javap\\day22";
		java.io.File path = new java.io.File(setPath);
		
		if(path.exists()) {
			String[] tempDirs = path.list();
			String[] dirs = new String[tempDirs.length + 2];
			dirs[0] = ".";
			dirs[1] = "..";
			System.arraycopy(tempDirs, 0, dirs, 2, tempDirs.length);
			
			for(int i = 0; i < dirs.length; i++) {
				String filename = dirs[i];
				java.io.File file = new java.io.File(filename);
				long time = file.lastModified();
				java.util.Date day = new java.util.Date(time);
				java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat();
				dateFormat.applyPattern("yyyy-MM-dd a hh:mm");
				String msg = dateFormat.format(day);
				System.out.print(msg + "\t");
				if(file.isDirectory()) {
					System.out.print("<DIR>\t");
				} else {
					System.out.print("\t" + file.length());
				}
				System.out.print(filename + "\n");
			}
		} else {
			
		}
	}

}
