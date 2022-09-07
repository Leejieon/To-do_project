package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//Use to HTTP response
//TodoDTO뿐만 아니라 이후 다른 모델의 DTO도 이 클래스를 이용하여 리턴할 수 있도록 자바 Generic을 이용
public class ResponseDTO<T> {
    private String error;
    //Todo를 하나만 반환하는 경우보다 리스트를 반환하는 경우가 많으므로 데이터를 리스트로 반환
    private List<T> data;
}
