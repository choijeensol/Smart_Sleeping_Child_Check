package kr.or.dream.dao.sqls;

public class RfidDaoSqls {
	public static final String SELECT_ALL_RFID = "SELECT * FROM rfid";
	public static final String SELECT_RFID = "SELECT * FROM rfid WHERE hex_code=:hexCode";
	public static final String UPDATE_RFID = "UPDATE rfid SET children_no=:childrenNo, status=:status, is_admin=:isAdmin WHERE hex_code=:hexCode";
	public static final String UPDATE_RFID_STATUE = "UPDATE rfid SET status=:status WHERE hex_code=:hexCode";
	public static final String DELETE_RFID = "DELETE FROM rfid WHERE hex_code=:hexCode";
	public static final String SELECT_RFID_ADMIN = "SELECT is_admin FROM rfid WHERE hex_code=:hexCode";
	//관리자가 아니고 in(승차)인 rfid개수를 셈으로써 개수가 0이 나와야 버스에 아무도 없는것.
	public static final String SELECT_RFID_ALL_OUT = "SELECT COUNT(*) FROM rfid WHERE is_admin = 'n' AND `status`='in'";
}
