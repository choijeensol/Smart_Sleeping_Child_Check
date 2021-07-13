package kr.or.dream.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.dream.config.ApplicationConfig;
import kr.or.dream.dao.ChildrenDao;
import kr.or.dream.dto.Children;

public class ChildrenDaoTests {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ChildrenDao cd = ac.getBean(ChildrenDao.class);
		List<Children> childrens = cd.selectAllChildren();
		for(Children c : childrens) {
			System.out.println(c);
		}
	}

}
