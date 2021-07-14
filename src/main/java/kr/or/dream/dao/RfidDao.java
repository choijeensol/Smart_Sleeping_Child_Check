package kr.or.dream.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import kr.or.dream.dto.Rfid;

public class RfidDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Rfid> RfidMapper = BeanPropertyRowMapper.newInstance(Rfid.class);
	
	public RfidDao(DataSource ds) {
		
	}
}
