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
			 return "����Ϊ��";
		 }
		 if(!b){
			 return "�û���Ϊ��";
		 }
		 if(!c){
			 return "����Ϊ��";
		 }
		 if(!d){
			 return "ȷ������Ϊ��";
		 }
		 if(!e){
			 return "�����Ϊ��";
		 }
		 if(!f){
			 return "�����������Ÿ�ʽ����ȷ";
		 }
	     if(!(password.trim().equals(surePassword.trim()))){
        	 System.out.println("��һ������"+password+"�ڶ�������"+surePassword+"********");
        	 return "�������벻һ��";
         }
		return null;
		
	
	}
	public static String WorkerRegister(String name,String username,String password,String surePassword){
		boolean a=DataCheck.objectCheck(name);
		boolean b=DataCheck.objectCheck(username);
		boolean c=DataCheck.objectCheck(password);
		boolean d=DataCheck.objectCheck(surePassword);
		if(!a){
			return "����Ϊ��";
		}
		 if(!b){
			 return "�û���Ϊ��";
		 }
		 if(!c){
			 return "����Ϊ��";
		 }
		 if(!d){
			 return "ȷ������Ϊ��";
		 }
	     if(!(password.trim().equals(surePassword.trim()))){
        	 System.out.println("��һ������"+password+"�ڶ�������"+surePassword+"********");
        	 return "�������벻һ��";
         }
	     return null;
	}
	
	public static String LoginCheck(String username,String password){
		boolean a=DataCheck.objectCheck(username);
		boolean b=DataCheck.objectCheck(password);
		if(!a){
			return "�û���Ϊ��";
		}
		if(!b){
			return "����Ϊ��";
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


