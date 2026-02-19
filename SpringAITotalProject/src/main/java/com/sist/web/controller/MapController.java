package com.sist.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.AIService;
import com.sist.web.service.SeoulService;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MapController {

	private final SeoulService sService;
	private final AIService aService;
	/*private String data="""
서울은 전통과 현대가 어우러진 도시인만큼 볼거리가 정말 많습니다. 서울시와 한국관광공사의 선정 자료(한국관광 100선, 서울 야경 100선 등)를 바탕으로, 테마별 핵심 랜드마크 100곳을 정리해 드립니다.

---

### 1. 역사 & 궁궐 (15곳)

조선의 역사가 살아있는 고궁과 유적지들입니다.

* 경복궁, 창덕궁(후원), 창경궁, 덕수궁, 경희궁 (5대 궁궐)
* 종묘, 사직단, 운현궁, 북촌 한옥마을, 남산골 한옥마을
* 서대문형무소 역사관, 독립문, 암사동 선사유적지, 풍납토성, 몽촌토성

### 2. 현대적 랜드마크 & 마천루 (12곳)

서울의 스카이라인을 책임지는 현대적 건축물입니다.

* 롯데월드타워(서울스카이), N서울타워, 63빌딩, 동대문디자인플라자(DDP)
* 서울시청 신청사, 국회의사당, 무역센터(코엑스), 타임스퀘어
* IFC 서울, 파크원, 세빛섬, 월드컵경기장

### 3. 문화 & 예술 (18곳)

전시와 공연, 예술적 영감을 주는 장소들입니다.

* 국립중앙박물관, 국립현대미술관(서울·덕수궁), 리움미술관
* 예술의전당, 세종문화회관, 국립국악원, 대학로(공연거리)
* 서울공예박물관, 서울역사박물관, 전쟁기념관, 간송미술관
* 문화비축기지, 피크닉(pknk), 플랫폼L, 아라리오뮤지엄, 국립민속박물관, 대한민국역사박물관

### 4. 힐링 & 자연 (20곳)

도심 속에서 여유를 느낄 수 있는 공원과 한강 명소입니다.

* 남산공원, 서울숲, 올림픽공원, 하늘공원, 노을공원
* 선유도공원, 여의도한강공원, 반포한강공원(무지개분수), 뚝섬한강공원
* 망원한강공원, 청계천, 양재천, 낙산공원(성곽길), 북악스카이웨이
* 서울식물원, 어린이대공원, 용산공원(반환부지), 서소문역사공원, 푸른수목원, 경의선 숲길

### 5. 쇼핑 & 트렌디 골목 (20곳)

MZ세대가 사랑하고 쇼핑하기 좋은 핫플레이스입니다.

* 명동 거리, 인사동길, 쌈지길, 익선동 한옥거리, 서순라길
* 성수동 카페거리, 연남동 경의선 숲길, 홍대 레드로드
* 가로수길, 압구정 로데오, 청담동 명품거리, 이태원 관광특구
* 한남동 카페거리, 해방촌(신흥시장), 경리단길, 서촌 마을
* 망리단길, 샤로수길, 문래창작촌, 성북동 역사문화거리

### 6. 시장 & 먹거리 (10곳)

서울의 활기찬 에너지를 느낄 수 있는 전통시장입니다.

* 광장시장, 남대문시장, 동대문종합시장, 노량진수산시장
* 망원시장, 통인시장, 경동시장, 가락시장
* 공덕 족발·전 골목, 중부시장

### 7. 종교 & 기타 (5곳)

* 조계사, 봉은사, 명동성당, 약현성당, 이태원 이슬람사원

---

### 💡 팁: 100곳을 다 가보려면?

* **권역별 방문:** 종로/중구(도심권), 강남/송파(동남권), 마포/서대문(서북권)으로 나누어 방문하면 이동 시간을 아낄 수 있습니다.
* **시즌별 추천:** 봄에는 **석촌호수**, 여름에는 **반포한강공원**, 가을에는 **하늘공원**, 겨울에는 **광화문광장 빛축제**를 추천합니다.

이 중에서 특히 관심 있는 분야(예: 사진 찍기 좋은 곳, 아이와 가기 좋은 곳)를 알려주시면 베스트 5를 더 상세히 추천해 드릴까요?

						""";*/
	
	@RequestMapping("/")
	   public String main_page(@RequestParam(value = "title", required = false) String title, Model model)
	   {
	     
		  if(title==null) {
			  title="마포";
		  }
		  
	      List<String> data1=sService.seoulGetTitle();
	      String result="";
	      try
	      {
	         Pattern[] p=new Pattern[data1.size()];
	         for(int i=0;i<p.length;i++)
	         {
	            p[i]=Pattern.compile(data1.get(i));
	         }
	         //Matcher[] m=new Matcher[data1.size()];
	         String data=aService.aiChat(title);
	         String[] ss=data.split("\n");
	         int i=0;
	         List<String> res=new ArrayList<String>();
	         for(String str:ss)
	         {
	            for(int j=0;j<p.length;j++)
	            {
	               Matcher n=p[j].matcher(str);
	               while(n.find())
	               {
	                  String k=n.group();
	                  if(k.length()>1)
	                  {
	                     res.add(k);
	                     System.out.println(k);
	                  }
	               }
	            }
	            i++;
	         }
	         List<String> rList=new ArrayList<String>(new HashSet<String>(res));
	         List<SeoulVO> sList=new ArrayList<>();
	         for(int k=0;k<rList.size();k++) {
	        	 SeoulVO vo=sService.seoulData(rList.get(k));
	        	 vo.setRank(k+1);
	        	 vo.setColor("#ff4c4c");
	        	 sList.add(vo);
	         }
	         
	         model.addAttribute("list", sList);
	      }catch(Exception ex)
	      {
	         ex.printStackTrace();
	      }
	      return "map";
	   }
}
