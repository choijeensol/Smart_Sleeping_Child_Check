package kr.or.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Children {
 private Integer no; // no 어린이 고유번호
 private String name; // name 어린이 이름
 private Integer age; // age 어린이 나이
 private Integer classNo; // class_no 반 이름

}
