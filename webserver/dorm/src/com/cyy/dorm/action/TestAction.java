package com.cyy.dorm.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private int[]test;
	
	
	public int[] getTest() {
		return test;
	}

	public void setTest(int[] test) {
		this.test = test;
	}

	public String tes(){
		for(int i=0;i<test.length;i++){
			System.out.println("test "+test[i]);
		}
		return "hello";
	}

}
