package kr.or.dream.dao.sqls;

public class ChildrenDaoSqls {
	public static final String SELECT_CHILDREN_ALL = "SELECT * FROM children";
	public static final String SELECT_CHILDREN = "SELECT * FROM children WHERE no=:no";
	public static final String UPDATE_CHILDREN = "UPDATE children SET name=:name, age=:age, class_no=:classNo WHERE no=:no";
	public static final String DELETE_CHILDREN = "DELETE FROM children WHERE no=:no";
}
