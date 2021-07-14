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
		
		//모든 어린이 조회
		/*
		List<Children> childrens = cd.selectAllChildren();
		for(Children c : childrens) {
			System.out.println(c);
		}*/
		
		//한번의 어린이 조회
		/*Children child = cd.selectChild(1);
		System.out.println(child);*/
		
		//어린이 추가
		int result = cd.addChild(new Children().builder().age(6).classNo(5).name("Test").build());
		System.out.println(result+"건을 추가하였습니다.");
		
	}

}
