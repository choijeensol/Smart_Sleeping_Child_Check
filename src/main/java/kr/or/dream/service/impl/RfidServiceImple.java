package kr.or.dream.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dream.dao.RfidDao;
import kr.or.dream.dto.Rfid;
import kr.or.dream.service.RfidService;

@Service
public class RfidServiceImple implements RfidService{
	@Resource
	RfidDao rfidDao;

	@Override
	public List<Rfid> getRfidAll() {
		return rfidDao.selectAllRifd();
	}

	@Override
	public Rfid getRfid(String hexCode) {
		return rfidDao.selectRfid(hexCode);
	}

	@Override
	public int addRfid(Rfid r) {
		return rfidDao.insertRfid(r);
	}

	@Override
	public int updateRfid(Rfid r) {
		return rfidDao.updateRfid(r);
	}

	@Override
	public int deleteRfid(String hexCode) {
		return rfidDao.deleteRfid(hexCode);
	}
	
}
