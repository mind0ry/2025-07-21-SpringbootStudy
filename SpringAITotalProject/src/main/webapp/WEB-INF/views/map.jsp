<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 코스</title>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=72fa81817487692b6dc093004af97650"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
body { margin:0; font-family: Arial, sans-serif; }

#map { width:100%; height:650px; margin-top: 70px }

/* 상단 버튼 */
.category {
  position:absolute;
  top:20px;
  left:50%;
  transform:translateX(-50%);
  background:#fff;
  padding:10px 16px;
  border-radius:30px;
  box-shadow:0 2px 8px rgba(0,0,0,.3);
  z-index:9999;
}

/* 🔥 카카오맵 font-size 0 강제 무력화 */
.overlay-wrap {
  font-size: 14px;
  text-align: center;
}

/* 번호 마커 */
.marker {
  width:36px;
  height:36px;
  border-radius:50%;
  color:#000;
  font-weight:bold;
  line-height:36px;
  margin:0 auto;
  box-shadow:0 2px 6px rgba(0,0,0,.4);
}

/* 명칭 */
.label {
  margin-top:4px;
  background:#fff;
  color:#000;
  padding:6px 10px;
  border-radius:14px;
  white-space:nowrap;
  box-shadow:0 2px 6px rgba(0,0,0,.25);
}

p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>

<body>

<div class="category">추천 코스</div>
<div>
	<form method=post action="/">
	<input type=text name=title size=20 class="input-sm" required>
	<button class="btn-sm btn-danger" type=submit>검색</button>
	</form>
</div>
<div id="map"></div>

<script>
const map = new kakao.maps.Map(document.getElementById('map'), {
  center: new kakao.maps.LatLng(37.5448,127.0433),
  level: 5
});

const courseList = [
  <c:forEach var="vo" items="${list}">
  { no:${vo.rank}, title:'${vo.title}', lat:${vo.y}, lng:${vo.x}, color:'${vo.color}' },
  </c:forEach>
];

let overlays = [];
let polyline = null;

function draw(){
  const path = [];

  courseList.forEach(item => {
    path.push(new kakao.maps.LatLng(item.lat, item.lng));

    const content = 
      '<div class="overlay-wrap">'
        +'<div class="marker" style="background:"'+item.color+'">'
        +item.no
        +'</div>'
        +'<div class="label">'+item.title+'</div>'
      +'</div>';

    const overlay = new kakao.maps.CustomOverlay({
      position: new kakao.maps.LatLng(item.lat, item.lng),
      content: content,
      yAnchor: 1,
      zIndex: 10
    });

    overlay.setMap(map);
    overlays.push(overlay);
  });

  polyline = new kakao.maps.Polyline({
    path: path,
    strokeWeight: 4,
    strokeColor: '#1e90ff'
  });
  polyline.setMap(map);
}

draw();
</script>
<div style="height: 50px"></div>
<div class="container">
	<div class="row">
	<c:forEach var="vo" items="${list }">
	  <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="#">
	        <img src="${vo.image1 }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>${vo.title }</p>
	        </div>
	      </a>
	    </div>
	  </div>
  </c:forEach>
</div>
</body>
</html>