package com.cyy.dorm.dao;
import java.util.List;

import com.cyy.dorm.model.*;
import com.cyy.dorm.genericDao.*;
public interface StudentDao extends GenericDao<Student,Integer> {

	public List<Student> findStudentWithUsername(String username);
}
