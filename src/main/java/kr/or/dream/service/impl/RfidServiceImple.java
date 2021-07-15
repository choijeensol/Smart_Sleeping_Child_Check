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
	
	@Override
	public int updateRfidStatus(String hexCode, String status) {
		if(isAdmin(hexCode)) {
			if(!isAllout()) { //true:아무도없는것 false:사람이있는것
				return 0; //사람이 있으므로 아무것도 업데이트 되지 않았다는 표시로 0을 반환
			}
		}
		return updateStatus(hexCode,status); //실제로 값 업데이트
	}
	
	//관리자인지 체크
	private boolean isAdmin(String hexCode) { 
		String result = rfidDao.isAdmin(hexCode);
		if(result.equals("y")) return true; //관리자라면 true
		else return false; //관리자가 아니라면 false
	}
	
	//모든 Rfid의 status가 out인지 체크 (즉, 모든 어린이가 버스에서 하차하였는지 체크)
	private boolean isAllout() {
		//관리자가 아니고 in(승차)인 rfid개수를 셈으로써 개수가 0이 나와야 버스에 아무도 없는것.
		boolean result = rfidDao.isAllOut() == 0 ? true:false; 
		return result;
	}
	//Rfid status 수정
	private int updateStatus(String hexCode, String status) {
		return rfidDao.updateRfidStatus(new Rfid().builder().hexCode(hexCode).status(status).build());
	}
}
