package com.cyy.dorm.util;

import java.io.File;

public class BuildPictureFile {
	
	public static boolean isExist(String path){
		File file=new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		return true;
	}

}
