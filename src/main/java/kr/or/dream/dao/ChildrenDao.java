package kr.or.dream.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.dream.dto.Children;
import static kr.or.dream.dao.sqls.ChildrenDaoSqls.*;

@Repository
public class ChildrenDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Children> childrenRowMapper = BeanPropertyRowMapper.newInstance(Children.class);
	
	public ChildrenDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds)
				.withTableName("children");
	}
	
	public List<Children> selectAllChildren(){
		return jdbc.query(SELECT_CHILDREN_ALL, Collections.EMPTY_MAP, childrenRowMapper);
	}
}
