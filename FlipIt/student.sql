-- �й�(number), �̸�(15), ����(3), ����, ����
-- ���̺� ����(��õ� �� ������ �߻��ϳ� ����)
create table student01(
	num number,
	name varchar2(15),
	kor number(3),
	eng number(3),
	math number(3)
);
-- ���� ������ ����(ù �õ� �� �����Ͱ� ���� ������ �߻��ϳ� ����)
delete from student01;
-- ���� ������ �Է�
insert into student01 values (1, '�л�1', 90, 90, 0);
insert into student01 values (1, '�л�2', 80, 50, 40);
insert into student01 values (1, '�л�3', 70, 60, 30);
insert into student01 values (1, '�л�4', 60, 70, 20);
insert into student01 values (1, '�л�5', 50, 80, 10);
exit;