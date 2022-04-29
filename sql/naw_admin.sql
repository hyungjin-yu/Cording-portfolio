-- admin(관리자 테이블)

-- 1) 테이블 생성
create table admin (
    admin_id varchar2(15) primary key,  -- 관리자 아이디
    admin_pwd varchar2(16) not null,    -- 관리자 비밀번호
    admin_name varchar2(20)             -- 관리자 이름
);

-- 2) 테이블 없애기
drop table admin purge;

-- 3) 테이블 목록
select * from tab;

-- 4) 데이터 저장하기
insert into admin values ('admin1', 'admin1', 'admin1');
insert into admin values ('admin2', 'admin2', 'admin2');

-- 5) 전체 내용 확인
select * from admin;

-- 6) 관리자 id로 내용 확인
select * from admin where admin_id='admin1';
select * from admin where admin_id='admin2';

-- 7) 데이터 수정
update admin set admin_pwd='admin11', admin_name='admin11' where admin_id='admin1';

-- 8) 데이터 삭제
delete admin where admin_id='admin1';

-- 9) db 저장
commit;

-- 10) 인덱스 뷰
-- hidden column => rownum
select * from
(select rownum rn, tt.* from
(select * from admin order by admin_id asc) tt)
where rn>=1 and rn<=5;

-- 11) 총데이터 갯수 구하기
select count(*) as cnt from admin;
