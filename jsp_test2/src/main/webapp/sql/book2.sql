-- 1) 테이블 생성
create table book2 (
    book_num varchar2(200),
    book_name varchar2(200) not null,
    book_writer varchar2(200) not null,
    publisher varchar2(200),
    price number,
    book_date varchar2(200),
    primary key (book_num)
);

-- 2) 테이블 삭제
drop table book2 purge;

-- 3) 테이블 확인
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence seq_num nocycle nocache;

-- 5) 시퀀스 객체 삭제
drop sequence seq_num;

-- 6) 데이터 저장
insert into book2 values(seq_num.nextval, 11111, 'java', 'jk', 'java', 20000, '2021-10-25');

-- 7) 검색
select * from book2;

-- 8) 전체 데이터 갯수
select count(*) as cnt from book2;

-- 9) 데이터 저장
commit;

-- 10) 인덱스 뷰
select * from(select rownum rn, tt. * from
(select * from book2 order by seq asc)tt)
where rn>=1 and rn<=5;