// ex09_date.js

// 날짜 시간 자료형
// - new Date()
// - object(자료형)

// 현재 시각
var now = new Date(); // Calendar.getInstance()
console.log(now.toLocaleString); // 2020-07-01T05:15:58.987Z

// c.get(Calendar.YEAR)
console.log(now.getYear()); //2020
console.log(now.getFullYear()); //2020
console.log(now.getMonth()); //6 (0부터)
console.log(now.getDate()); //1
console.log(now.getDay()); //3
console.log(now.getHours()); //14
console.log(now.getMinutes()); //20
console.log(now.getSeconds()); //32
console.log(now.getMilliseconds()); //793
console.log(now.getTime()); //1593580832793


//출력
console.log(now);
console.log(now.toString());
console.log(now.toLocaleString());

console.log(now.toLocaleDateString());
console.log(now.toLocaleTimeString());


// 특정 시각 만들기
var christmas = new Date();
christmas.setMonth(11);
christmas.setDate(25);
console.log(christmas.toString());

var birthday = new Date(1990, 5, 20);
var birthday2 = new Date(1990, 5, 20, 12, 20, 30);


// 연산
console.log(christmas - now); //15292800013


// 오늘 + 100일
//시각 + 시간 (틱값을 구해서 더한것을 셋타임한다.)
//console.log(now+100); -> 안됨!
//c.add(Calendar.DATE, 100);
var result = new Date();
result.setTime(now.getTime() + (100*24 *60 *60 *1000));
console.log(result.toString());