package com.cyy.dorm.util;

import java.io.File;

import com.cyy.dorm.dao.OrderDao;
import com.cyy.dorm.dao.ImpDao.OrderImpDao;
import com.cyy.dorm.model.Order;

public class GetFileName {
	public static String getName(String path){
		File file =new File(path);
		System.out.println("**��ȡ�ļ���  "+file.getName());
		return file.getName();
	}

    }
