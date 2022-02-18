-- * 글 관리
-- 1) 테이블 생성
create table board ( 
    seq number not null,             -- 글 번호
    id varchar2(20) not null,        -- 아이디
    name varchar2(20) not null,      -- 이름
    subject varchar(250) not null,   -- 제목
    content varchar2(4000) not null, -- 내용
    hit number default 0,            -- 조회수 
    logtime date default sysdate     -- 작성일
);

-- 2) 테이블 없애기
drop table board purge;

-- 3) 테이블 목록
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence seq_board nocache nocycle;

-- 5) 시퀀스 객체 삭제
drop sequence seq_board;

-- 6)  데이터 저장하기
insert into board values(seq_board.nextval, 'num1', '홍길동', '내일은', '웃으리...', 0, sysdate);

-- 7) 전체 내용 확인
select * from board;

-- 8) 특정 글번호로 내용 확인
select * from board where seq=1;

-- 9) 데이터 수정
update board set subject='오늘도', content='크게 웃으리' where seq=1;

-- 10) 데이터 삭제
delete board where seq=1;

-- 11) db 저장
commit;