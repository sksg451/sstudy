package org.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 의존성 주입 방법
 * 1.Setter 주입 @Setter(onMethod_ = {@Autowired})
 * 2.생성자 주입 @AllArgsConstructor 추가로 private final을 붙여주는게 좋음
 * 3.필드 주입 @Autowired
 * 4.final사용(최근 가장 많이 사용되는 방법)
 */

////3.필드주입?
//@Component
//@ToString
//public class Restaurant {
//private Chef chef;
//
//@Autowired // 자동 연결
//public void setChef(Chef chef) {
//	// @Data에서 setter가 만들어지지만 개발자가 작성한 코드가 우선이기 때문에 지금 작성한것으로 적용됨
//	this.chef = chef;
//}
//}

////2.생성자 주입
//@Component
//@Data
//@AllArgsConstructor
//public class Restaurant {
//	
//	private final Chef chef;
//	
//}


// 4.final
@Component
@ToString
@RequiredArgsConstructor
public class Restaurant {
	
	private final Chef chef;
	
}
