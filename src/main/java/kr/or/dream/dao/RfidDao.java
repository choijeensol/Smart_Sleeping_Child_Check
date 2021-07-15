package kr.or.dream.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import static kr.or.dream.dao.sqls.RfidDaoSqls.*;
import kr.or.dream.dto.Rfid;

@Repository
public class RfidDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Rfid> RfidMapper = BeanPropertyRowMapper.newInstance(Rfid.class);
	
	public RfidDao(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
		insertAction = new SimpleJdbcInsert(ds)
				.withTableName("rfid");
	}
	
	//모든 RFID 조회
	public List<Rfid> selectAllRifd(){
		return jdbc.query(SELECT_ALL_RFID, Collections.EMPTY_MAP, RfidMapper);
	}
	
	//특정 RFID 조회
	public Rfid selectRfid(String hexCode) {
		Map<String,?>params = Collections.singletonMap("hexCode", hexCode);
		return jdbc.queryForObject(SELECT_RFID, params, RfidMapper);
	}

	//RFID 생성
	public int insertRfid(Rfid r) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(r);
		return insertAction.execute(params);
	}
	//RFID 수정
	public int updateRfid(Rfid r) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(r);
		return jdbc.update(UPDATE_RFID, params);
	}
	//RFID 현재 상태값만 변경
	public int updateRfidStatus(Rfid r) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(r);
		return jdbc.update(UPDATE_RFID_STATUE, params);
	}
	//RFID 삭제
	public int deleteRfid(String hexCode) {
		Map<String,?>params = Collections.singletonMap("hexCode", hexCode);
		return jdbc.update(DELETE_RFID, params);
	}
	//Admin인지 확인
	public String isAdmin(String hexCode) {
		Map<String,?>params = Collections.singletonMap("hexCode", hexCode);
		return jdbc.queryForObject(SELECT_RFID_ADMIN, params, String.class);
	}
	//모든 status값이 out인지 확인 (모든 어린이가 버스에서 하차하였는지)
	public Integer isAllOut() {
		//관리자가 아니고 in(승차)인 rfid개수를 셈으로써 개수가 0이 나와야 버스에 아무도 없는것.
		return jdbc.queryForObject(SELECT_RFID_ALL_OUT, Collections.EMPTY_MAP, Integer.class);
	}
}
