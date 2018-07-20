package com.dorm.unity;

public class DataCheck {
	public static String StudentRegisterCheck(String name,String username,String password,String surePassword,String roomId){
		 boolean a=DataCheck.objectCheck(name);
		 boolean b=DataCheck.objectCheck(username);
		 boolean c=DataCheck.objectCheck(password);
		 boolean d=DataCheck.objectCheck(surePassword);
		 boolean e=DataCheck.objectCheck(roomId);
		 boolean f=DataCheck.isNumber(roomId);
		 if(!a){
			 return "姓名为空";
		 }
		 if(!b){
			 return "用户名为空";
		 }
		 if(!c){
			 return "密码为空";
		 }
		 if(!d){
			 return "确认密码为空";
		 }
		 if(!e){
			 return "宿舍号为空";
		 }
		 if(!f){
			 return "你输入的宿舍号格式不正确";
		 }
	     if(!(password.trim().equals(surePassword.trim()))){
        	 System.out.println("第一次密码"+password+"第二次密码"+surePassword+"********");
        	 return "密码输入不一致";
         }
		return null;
		
	
	}
	public static String WorkerRegister(String name,String username,String password,String surePassword){
		boolean a=DataCheck.objectCheck(name);
		boolean b=DataCheck.objectCheck(username);
		boolean c=DataCheck.objectCheck(password);
		boolean d=DataCheck.objectCheck(surePassword);
		if(!a){
			return "姓名为空";
		}
		 if(!b){
			 return "用户名为空";
		 }
		 if(!c){
			 return "密码为空";
		 }
		 if(!d){
			 return "确认密码为空";
		 }
	     if(!(password.trim().equals(surePassword.trim()))){
        	 System.out.println("第一次密码"+password+"第二次密码"+surePassword+"********");
        	 return "密码输入不一致";
         }
	     return null;
	}
	
	public static String LoginCheck(String username,String password){
		boolean a=DataCheck.objectCheck(username);
		boolean b=DataCheck.objectCheck(password);
		if(!a){
			return "用户名为空";
		}
		if(!b){
			return "密码为空";
		}
		return null;
	}
	
	public static boolean objectCheck(Object object){
		if(object==null||object==""||object.equals(""))
		{
			return false;
			}else{
				return true;
			}
		
	}
    public static boolean isNumber(String str)
    {
        java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[0-9]*");
        java.util.regex.Matcher match=pattern.matcher(str);
        if(match.matches()==false)
        {
           return false;
        }
        else
        {
           return true;
        }
    }

}


