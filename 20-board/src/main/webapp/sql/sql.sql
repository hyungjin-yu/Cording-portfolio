-- 익명 게시판 글관리
-- * DB 저장 * --
commit;

-- 1) 테이블 생성
create table board2 (
    board_num number,                       -- 글번호
    board_name VARCHAR2(20) not null,       -- 글작성자  
    board_pass VARCHAR2(15) not null,        -- 글비밀번호
    board_subject VARCHAR2(200) not null,    -- 글제목
    board_content VARCHAR2(4000) not null,   -- 글내용
    board_file VARCHAR2(50) not null,        -- 첨부파일
    board_re_ref number not null,           -- 관련 글번호
    board_re_lev number not null,           -- 답글 레벨
    board_re_seq number not null,           -- 관련 글중 출력순서
    board_readcount number DEFAULT 0,       -- 조회수
    board_date date,                        -- 작성일
    PRIMARY KEY (board_num)
);

-- 2) 테이블 확인
select * from tab;

-- 3) 테이블 삭제
drop table board2 purge;

-- 4) 시퀀스 객체 생성
create sequence seq_num nocache nocycle;

-- 5) 시퀀스 객체 삭제
drop sequence seq_num;

-- 6) 데이터 저장
insert into board2 values (seq_num.nextval, '홍길동', '1234', 
    '내일은', '웃으리', 'aa.jpg', seq_num.currval, 0, 0, 0, sysdate);
    
-- 7) 데이터 검색
select * from board2;
select * from board2 where board_num=1;
-- 전체 내용 확인 : 전체 데이터 갯수 구하기
select count(*) from board2;
select count(*) as cnt from board2;

-- 8) 데이터 수정
update board2 set board_subject='', board_content='', board_file='' 
where board_num='' and board_pass='';

-- 9) 삭제
delete board2 where board_num=1;

-- 10) 답글저장
-- 1. 기존글의 re_seq값을 정리 : 같은값의 re_ref그룹에서 원글보다 re_seq값이 큰것들만 1씩 증가 
update board2 set board_re_seq = board_re_seq + 1
where board_re_ref = 45 and board_re_seq > 0;
-- 2. 답글저장
-- => re_ref = 원글의 re_ref
-- => re_lev = 원글의 re_lev + 1
-- => re_seq = 원글의 re_seq + 1
insert into board2 values (seq_num.nextval, '홍길동', '1234', '내일은', '웃으리', 'aa.jpg', 
44, 1, 1, 0, sysdate);

-- 11) 답글에 대한 인덱스뷰
-- => re_ref 기준 내림차순, 같은 값들은 re_seq 기준 오름차순으로 정렬
select * from
(select rownum rn, tt.* from
(select * from board2 order by board_re_ref desc, board_re_seq asc) tt)
where rn>=1 and rn<=60;