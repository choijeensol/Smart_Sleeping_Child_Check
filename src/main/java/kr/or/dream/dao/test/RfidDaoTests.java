package kr.or.dream.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.dream.config.ApplicationConfig;
import kr.or.dream.dao.RfidDao;
import kr.or.dream.dto.Rfid;
import kr.or.dream.dto.Status;

public class RfidDaoTests {
	public static void main(String args[]) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RfidDao dao = ac.getBean(RfidDao.class);
		int result = dao.updateRfidStatus(new Rfid().builder().status(Status.out.toString()).hexCode("16358AAB").build());
		System.out.println(result);
	}
}
