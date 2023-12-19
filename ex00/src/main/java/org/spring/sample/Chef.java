package org.spring.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링이 직접 해당 클래스를 관리해야 하는 대상임을 표시
@Data // Lombok의 Getter,Setter,ToString등을 전부 포함함 , 기본생성자도 알아서 생성
public class Chef {

}
