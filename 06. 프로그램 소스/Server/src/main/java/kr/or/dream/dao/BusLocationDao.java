package kr.or.dream.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import static kr.or.dream.dao.sqls.BusLocationDaoSqls.*;

import java.util.Collections;

import kr.or.dream.dto.BusLocation;

@Repository
public class BusLocationDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<BusLocation> busLocationMapper = BeanPropertyRowMapper.newInstance(BusLocation.class);
	
	public BusLocationDao(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
		insertAction = new SimpleJdbcInsert(ds)
				.withTableName("bus_location");
	}
	
	//가장 최근 버스 위치 조회
	public BusLocation SelectRecentBusLocation() {
		return jdbc.queryForObject(SELECT_RECENT_BUS_LOCATION, Collections.EMPTY_MAP, busLocationMapper);
	}
	
	//버스 위치 삽입
	public int addBusLocation(BusLocation busLocation) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(busLocation);
		return insertAction.execute(params);
	}
}
