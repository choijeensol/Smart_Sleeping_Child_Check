package kr.or.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Teacher {
    private Integer no; // no 선생님 고유번호
    private String name; // name 선생님 이름
    private Integer classNo; // class_no 담당 반
}
