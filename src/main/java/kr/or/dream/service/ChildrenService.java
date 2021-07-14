package kr.or.dream.service;

import java.util.List;

import kr.or.dream.dto.Children;

public interface ChildrenService {
	public List<Children>getChildrenAll();
	public Children getChildren(Integer no);
	public int addChlid(Children c);
	public int updateChild(Children c);
	public int deleteChild(Integer no);
}
