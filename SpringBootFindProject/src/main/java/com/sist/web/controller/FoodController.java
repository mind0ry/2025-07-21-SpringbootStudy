package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 	 -------------------------------
 * 			   ThymeLeaf     Vue3
 *   -------------------------------
 *   랜더링		서버 랜더링   클라이언트 랜더링
 *   검색엔진     매우 뛰어나다  => 서버랜더링 사용 (Nuxt)
 *   데이터바인딩  단방향		   양방향 => AngularJS
 *   속도 	    서버처리 중심  브라우저 중심
 *              Back-End   Front-End
 *   사용처       관리페이지   | 모바일 => 동적
 *              | 공공기업 사이트
 *                        | 페이징 / 검색 / 예약 / 결제
 *                        | 채팅 / AI
 *                        | GPT
 *   => 기본 : ThymeLeaf / JSP
 *   => 동적 : React / Vue
 *   
 *   = ***사상돔
 *     브라우저 화면 직접 실행하는 실제 돔이 아니다
 *     가상 메모리에 저장 => 변경시마다 실제 돔에 전송
 *        |					|
 *        ------------------ diff (비교)
 *        속도를 빠르게 / 깜박이는 효과가 없이
 *      = 컴파일 = 렌더링 실시간 수행
 *        => 데이터만 변경
 *        
 *    2. MVVM (Model - Vue - ViewModel)
 *       MVC (Model - View - Controller)
 *       
 *         => 요청 = Controller = Model = Controller = View
 *                      |          |        |           |
 *                   요청 받기    요청 처리   결과값 전송    화면 출력
 *         => 요청 = Model <----> ViewModel <----> View
 *                    |             |              |
 *                  데이터 관리    데이터 변경        화면 출력
 *                              데이터 처리         mount영역
 *                    |             |            => <template>
 *                   data()      created()
 *                               mounted()
 *                               updated()
 *                               unmounted()
 *                               methods:{}
 *         Model : 데이터의 상태 관리 (state)
 *                 Pinia/VueX ==> 저장 (store)
 *         View : HTML을 제어
 *         ViewModel : 양방향 바인딩 , 반응성 관리 , 이벤트 처리
 *         
 *         *** Model이 변경이 되면 ViewModel ==> HTML
 *             | 설정된 변수가 변경시
 *     3. 생명 주기 함수
 *     created() : Vue생성시 자동 호출
 *     mounted() : 브라우저에 HTML이 번역 후 출력이 된 경우
 *     updated() : 데이터값이 변경된 후
 *     unmounted() : 화면이 변경
 *     => CallBack => Vue시스템에 의해 자동 호출
 *     
 *     methods : 사용자 정의 함수 => 자동이 안된다
 *     
 *     4. 디엑티브
 *        v-model : 입력시에 data()에 있는 변수에 값을 설정
 *           | 양방향
 *           | react에 없다 => onchange
 *        v-bind => 속성에 값을 설정 => :
 *          <img v-bind:src="vo.poster">
 *          <img :src="vo.poster">
 *        v-on => 이벤트 처리
 *        <button v-on:click="함수">
 *                     mouseover
 *                => v-on => @click=""
 *        v-for : 반복문 => for-each만 지원
 *        v-if / v-else => v-else-if ...
 *        => hide / show
 *            |
 *           v-show="조건:false" v-show="조건:true"
 *         
  */
// router => 화면 변경
@Controller
public class FoodController {
	@GetMapping("/food/find")
	public String food_find() {
		return "food/find"; // templates/food/find.html
	}
	
	@GetMapping("/food/detail")
	public String food_detail(@RequestParam("fno") int fno , Model model) {
		model.addAttribute("fno", fno);
		return "food/detail";
	}
}
