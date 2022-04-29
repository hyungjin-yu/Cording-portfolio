-- Naw Project
-----------------------------------------------------------------------------
-- * 회원테이블
create table profile (
    user_id varchar2(15) not null,	    --아이디
    user_pwd varchar2(16) not null,	    --비밀번호
    user_name varchar2(20) not null,	--이름
    user_phone varchar2(15) not null,	--전화번호
    user_email varchar2(70) not null,   --이메일
    user_addr1 varchar2(150) not null,	--주소
    user_addr2 varchar2(150) not null,	--상세주소
    user_joindate date default sysdate,	--가입일
    user_gender	varchar2(10) not null,	--성별
    user_birth	date not null,	        --생년월일
    primary key(user_id)
    );

-- 테이블 목록
select * from tab;
select * from profile;

-- 테이블 삭제
drop table profile purge;

-- (회원가입) ID중복 확인
select * from profile where user_id='naw';

-- (회원가입) 데이터 저장하기
insert into profile values ('naw', 'Nawisback88', '나우', '01034229999', 
'naw@naw.com', '서울특별시 서초구 서초대로77길 30', '32F Naw Inc', sysdate, 'M', To_Date('1987-04-03', 'yyyy-mm-dd'));

-- 관리자 데이터 저장
insert into profile values ('naw', 'Nawisback88', '나우', '01034229999', 
'naw@naw.com', '서울특별시 서초구 서초대로77길 30', '32F Naw Inc', sysdate, 'M', To_Date('1987-04-03', 'yyyy-mm-dd'));

-- (로그인) 로그인
select * from profile where user_id='naw' and user_pwd='Nawisback77';
-- SELECT COUNT(*) FROM profile WHERE user_id = #{user_id} AND user_pwd = #{user_pwd}
SELECT COUNT(*) FROM profile WHERE user_id='naw' and user_pwd='Nawisback77';

-- (로그인) 아이디 찾기
select user_id from profile where user_name='나우' and user_email='naw@naw.com';

-- (로그인) 비밀번호 찾기 정보일치여부 확인
select * from profile where user_id = 'naw' and user_name = '나우' and user_email = 'naw@naw.com';

-- (로그인) 비밀번호 초기화
update profile set user_pwd='Nawisback77' where user_id='naw';

-- (마이페이지) 회원정보수정
update profile set user_pwd='Nawisback55', user_phone='01034227777', user_email='naw@naw.com', user_addr1='서울특별시 서초구 서초대로77길 30', user_addr2='32F Naw Inc' where user_id='naw' and user_pwd='Nawisback77';

-- (마이페이지) 회원탈퇴
delete profile where user_id='naw';
 
--  db 저장
commit;
