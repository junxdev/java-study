-- 학번(number), 이름(15), 국어(3), 영어, 수학
-- 테이블 생성(재시도 시 오류가 발생하나 무시)
create table student01(
	num number,
	name varchar2(15),
	kor number(3),
	eng number(3),
	math number(3)
);
-- 기존 데이터 삭제(첫 시도 시 데이터가 없어 오류가 발생하나 무시)
delete from student01;
-- 더미 데이터 입력
insert into student01 values (1, '학생1', 90, 90, 0);
insert into student01 values (1, '학생2', 80, 50, 40);
insert into student01 values (1, '학생3', 70, 60, 30);
insert into student01 values (1, '학생4', 60, 70, 20);
insert into student01 values (1, '학생5', 50, 80, 10);
exit;