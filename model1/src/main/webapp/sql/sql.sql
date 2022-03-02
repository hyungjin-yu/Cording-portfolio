--1) 테이블 생성
create table score(
    seq number not null,
    hak varchar2(200) primary key,
    stuname varchar2(80) not null,
    kor number,
    eng number,
    math number,
    sumscore number,
    avgscore number
);

-- 2) 테이블 삭제
drop table score purge;

-- 3) 테이블 확인
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence seq_num nocycle nocache;

-- 5) 시퀀스 객체 삭제
drop sequence seq_num;

-- 6) 데이터 저장
insert into score values(seq_num.nextval, 201822161, '홍길동', 90, 90, 90, 270, 90);

-- 7) 검색
select * from score;
select * from score where seq=1;

-- 8) 전체 데이터 갯수
select count(*) as cnt from score;

-- 9) 데이터 저장
commit;

-- 10) 인덱스 뷰
select * from(select rownum rn, tt. * from
(select * from score order by seq desc)tt)
where rn>=1 and rn<=5;