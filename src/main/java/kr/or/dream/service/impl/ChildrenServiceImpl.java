package kr.or.dream.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dream.dao.ChildrenDao;
import kr.or.dream.dto.Children;
import kr.or.dream.service.ChildrenService;

@Service
public class ChildrenServiceImpl implements ChildrenService{
	@Resource
	ChildrenDao childrenDao;
	
	@Override
	public List<Children> getChildrenAll() {
		return childrenDao.selectAllChildren();
	}

	@Override
	public Children getChildren(Integer no) {
		return childrenDao.selectChild(no);
	}

	@Override
	public int addChlid(Children c) {
		return childrenDao.addChild(c);
	}

	@Override
	public int updateChild(Children c) {
		return childrenDao.updateChild(c);
	}

	@Override
	public int deleteChild(Integer no) {
		return childrenDao.deleteChild(no);
	}

}
