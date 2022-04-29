-- 1) 리뷰게시판 테이블
create table review(
    review_code number,	                    --리뷰글 번호
	user_id varchar2(15) not null,	        --회원 id
    item_code varchar2(100) not null,       --상품 번호
	review_content varchar2(100) not null,	--내용
	review_star number,	                    --별점
	review_date date,	                    --작성일
    primary key(review_code)
);

-- 2) 테이블 삭제
drop table review purge;

-- 3) 테이블 확인
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence review_code nocycle nocache;

-- 5) 시퀀스 객체 삭제
drop sequence review_code;

-- 6) 데이터 저장하기
insert into review 
values(review_code.nextval, 'hong1234', '002', 'content', 5, sysdate);

-- 7) 전체 내용 확인
select * from review order by review_code desc;

-- 8) 특정 상품 하나의 리뷰글 모아보기
select * from review where item_code=002 order by review_code desc ;

select * from
(select rownum rn, tt.* from
(select * from review order by review_code desc) tt)
where rn>=1 and rn<=3 and item_code='002';

-- 9) 데이터 수정(보류)
update review 
set review_content='content1', review_star=3 
where review_code=1;

-- 10) 데이터 삭제
delete review where review_code=8;

-- 11) db 저장
commit;

-- 12) 인덱스 뷰
-- hidden column => rownum
select * from
(select rownum rn, tt.* from
(select * from review order by review_code desc) tt)     --내림차순 정렬
where rn>=1 and rn<=5;

-- 13) 전체 데이터 개수 구하기
select count(*) as cnt from review;

-- 14) 상품당 리뷰글 수 뽑아오기
select count(*) as cnt from review where item_code='002';

-- 15) -- 상세 데이터 뽑아오기
select * from review where review_code='2';