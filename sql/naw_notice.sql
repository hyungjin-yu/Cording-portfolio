-- notice(공지 테이블)

-- 1) 테이블 생성
create table notice (
    notice_seq number primary key,          -- 공지글 번호(시퀀스)
    notice_date date default sysdate,       -- 공지 업데이트 날짜(등록일)
    notice_title varchar2(100) not null,    -- 공지 제목
    notice_content varchar2(3000) not null  -- 공지 내용
);

-- 2) 테이블 없애기
drop table notice purge;

-- 3) 테이블 목록
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence seq_notice nocache nocycle;

-- 5) 시퀀스 객체 삭제
drop sequence seq_notice;

-- 6) 데이터 저장하기
insert into notice values (seq_notice.nextval, sysdate, '공지제목', '공지내용');

-- 7) 전체 내용 확인
select * from notice;

-- 8) 공지글 번호(시퀀스)로 내용 확인
select * from notice where notice_seq=1;

-- 9) 데이터 수정
update notice set notice_title='공지제목수정', notice_content='공지내용수정' where notice_seq=1;

-- 10) 데이터 삭제
delete notice where notice_seq=1;

-- 11) db 저장
commit;

-- 12) 인덱스 뷰
-- hidden column => rownum
select * from
(select rownum rn, tt.* from
(select * from notice order by notice_seq desc) tt)
where rn>=1 and rn<=5;

-- 13) 총데이터 갯수 구하기
select count(*) as cnt from notice;
