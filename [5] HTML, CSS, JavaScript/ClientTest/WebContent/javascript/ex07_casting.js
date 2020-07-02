//형변환
//- 대부분 상황에서는 자바스크립트가 스스로 형변환을 한다.

console.log("100" * 2);

//형변환 함수
// "100" -> 100
// (int)num

//1. int parseInt()
//2. float parseFloat()

//정수로 바꿔주는것
var n1 = 3.14;
console.log(parseInt(n1));

var n2 = "100";
console.log(parseInt(n2));
console.log(typeof n2); //string
console.log(typeof parseInt(n2)); //number

var n3 = "200점";
console.log(parseInt(n3)); //200

//parseInt 는 처음 만나는 숫자부터 문자까지 추출하지만 처음부터 문자가 있으면 바로 버린다.
n3 = "점수200";
console.log(parseInt(n3)); //Nan

n3 = "100+200";
console.log(parseInt(n3)); //100

//HTML + CSS
var width = "200px";
console.log(width + 200);
console.log(parseInt(width) + 200 + "px");

console.log(parseFloat("1.5em") * 2 + "em");

//isNaN()
//- Is not a number?
// - 자료형(x) -> 형식(o)
var age = "20"; //사용자 입력값

//숫자 유효성검사
if (!isNaN(age)) {
    console.log(age);
} else {
    console.log("숫자만 입력하세요.");
}
