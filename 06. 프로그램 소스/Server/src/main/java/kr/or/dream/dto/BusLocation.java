package kr.or.dream.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusLocation {
    private Integer no; // no 컬럼 고유번호
    private String lat; // lat 위도
    private String lnt;// lnt 경도
    private Integer speed;// speed 버스 속도
    private Timestamp acquisitionTime; // acquisition_time 데이터 취득시간
}
