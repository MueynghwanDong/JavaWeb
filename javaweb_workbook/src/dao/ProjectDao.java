package dao;

import java.util.HashMap;
import java.util.List;

import vo.Project;

public interface ProjectDao {
	public List<Project> selectList(HashMap<String,Object> paramMap) throws Exception;

	public int insert(Project Project) throws Exception;

	public int delete(int no) throws Exception;

	public Project selectOne(int no) throws Exception;

	public int update(Project Project) throws Exception;

}
