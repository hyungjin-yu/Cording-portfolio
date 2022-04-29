-- 1) 문의게시판 테이블
create table inquiry (
    inquiry_code number,	                        --문의글 번호
	user_id varchar2(15) not null,	                --회원 id
	inquiry_subject varchar2(100) not null,	        --제목
	inquiry_content varchar2(100) not null,	        --내용
	re_ref number not null,	                        --관련 글 번호
	re_lev number not null,	                        --답글 레벨
	re_seq number not null,	                        --관련 글 중 출력순서
	inquiry_readcount number not null,             	--조회수
	inquiry_date date,        	                    --작성일
    primary key(inquiry_code)
);

-- 2) 테이블 삭제
drop table inquiry purge;

-- 3) 테이블 확인
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence inquiry_code nocycle nocache;

-- 5) 시퀀스 객체 삭제
drop sequence inquiry_code;

-- 6) 데이터 저장하기
insert into inquiry 
values(inquiry_code.nextval, 'hong1234', 'subject', 'content', 
inquiry_code.currval, 0, 0, 0, sysdate);    -- currval : 현재 시퀀스값 읽어오기

-- 7) 전체 내용 확인
select * from inquiry order by inquiry_code asc;

-- 8) 상세 데이터 1줄 뽑아오기
select * from inquiry where inquiry_code=1;

-- 9) 데이터 삭제
delete inquiry where inquiry_code=3;

-- 10) db 저장
commit;

-- 11) 조회수 증가
update inquiry set inquiry_readcount = inquiry_readcount + 1 where inquiry_code=1;

-- 12) 글쓴이인지 확인 : session id 와 db에 등록된 게시물 작성자 id가 일치
select * from inquiry where inquiry_code=45;

-- 13) 글 수정
update inquiry set inquiry_subject='test1', inquiry_content='content1'
where inquiry_code=1;

-- 14) 답글 저장
---- 1.기존글의 re_seq값 정리 : 원글보다 큰 re_seq값을 1씩 증가
update inquiry set re_seq = re_seq + 1
where re_ref=0 and re_seq>0;

---- 2.답글 저장
---- re_ref = 원글의 re_ref
---- re_lev = 원글의 re_lev + 1
---- re_seq = 원글의 re_seq + 1
insert into inquiry values
(inquiry_code.nextval, 'id', '상품번호', '제목', '내용', 1, 1, 1, 0, sysdate);

-- 16) 답글에 대한 인덱스 뷰
---- => re_ref 기준 내림차순, 같은 값들은 re_seq 기준 오름차순으로 정렬시킴
select * from
(select rownum rn, tt.* from
(select * from inquiry order by re_ref desc, re_seq asc) tt)
where rn>=1 and rn<=3;

-- 19) 삭제하기
delete inquiry where inquiry_code=127;
