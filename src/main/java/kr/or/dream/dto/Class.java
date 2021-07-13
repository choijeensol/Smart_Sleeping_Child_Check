package kr.or.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Class {
	private Integer no; // no 어린이집 반 고유번호
	private String name; // name 반 이름
}
