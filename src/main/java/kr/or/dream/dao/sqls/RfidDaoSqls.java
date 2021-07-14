package kr.or.dream.dao.sqls;

public class RfidDaoSqls {
	public static final String SELECT_ALL_RFID = "SELECT * FROM rfid";
	public static final String SELECT_RFID = "SELECT * FROM rfid WHERE hex_code=:hexCode";
	public static final String UPDATE_RFID = "UPDATE rfid SET children_no=:childrenNo, status=:status, is_admin=:isAdmin WHERE hex_code=:hexCode";
	public static final String UPDATE_RFID_STATUE = "UPDATE rfid SET status=:status WHERE hex_code=:hexCode";
	public static final String DELETE_RFID = "DELETE FROM rfid WHERE hex_code=:hexCode";
}
