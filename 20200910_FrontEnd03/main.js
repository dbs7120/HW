var N = 6;
var count = 0; // 페이지내 번호 갯수 저장을위한 전역 변수

function make() {
  if (count >= N) {
    return;
  }
  let list = document.getElementById("list");

  // call-back, setInterval: 일정시간마다 반복실행
  let func = setInterval(function () {
    let randNum = Math.floor(Math.random() * 45) + 1;
    console.log(randNum);

    let list_item = document.createElement("li");
    list_item.appendChild(document.createTextNode(randNum));
    list.appendChild(list_item);
    count++;
    if (count >= N) {
      clearInterval(func);
    }
  }, 100);
}
function reset() {
  var list = document.getElementById("list");
  console.log(list);

  // 다음자식값 존재 파악
  while (list.hasChildNodes()) {
    list.removeChild(list.firstChild);
  }
  count = 0;
}
