package com.cyy.dorm.genericDao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<MyClass,Index extends Serializable> {

	//�������
	public boolean insert(MyClass c);
	//ɾ������
	public boolean delete(Index id);
	//����hqlɾ��
	public boolean deleteWithHql(String hql);
	//���²���
	public boolean update(MyClass c);
	//ͨ��Id����
	public MyClass findWithId(Index id);
	//ͨ���û���,���ݿ��ֶ�Ϊname����
	public List<MyClass> findWithName(String str);
	//ͨ��HQL����
	public List<MyClass> findWithHql(String hql);
	//ͳ�����ݱ�����
	public int total();
	//����Hql���ͳ�����ݱ�����
	public int totalWithHql(String hql);
	//��ҳ����
	public List<MyClass> getAllByPage(int pageSize,int page);
	//����Hql���ķ�ҳ
	public List<MyClass> getAllByPageWithHql(int pageSize,int page,String hql);
	//����������û�����ѯ
	public MyClass findWithNamePassword(String username,String password);
	
	
}