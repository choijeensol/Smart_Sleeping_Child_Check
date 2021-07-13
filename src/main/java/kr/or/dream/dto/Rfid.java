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
public class Rfid {
    private String hexCode; // hex_code 태그 식별부호
    private Integer childrenNo; // children_no 태그 소유 어린이
    private String status;// status 현재 승하차 상태
    private String isAdmin;// is_admin 관리자용 태그인지
}
