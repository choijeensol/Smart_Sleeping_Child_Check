package kr.or.dream.service;

import java.util.List;

import kr.or.dream.dto.Rfid;

public interface RfidService {
	public List<Rfid>getRfidAll();
	public Rfid getRfid(String hexCode);
	public int addRfid(Rfid r);
	public int updateRfid(Rfid r);
	public int deleteRfid(String hexCode);
	public int updateRfidStatus(String hexCode,String status);
}
