-- 1) 장바구니 테이블
create table cart (
	user_id varchar2(15) not null,	        --회원id
    cart_seq number,	                    --시퀀스
	item_code varchar2(100) not null,	    --상품번호
	item_name varchar2(100) not null,	    --상품이름
	item_color varchar(20) not null,	    --색상
	item_size varchar(20) not null,	        --사이즈
    item_image varchar2(100) not null,      --상품이미지
	item_price number(20) not null,	        --상품개별적인 금액
	cart_qty number(10) not null,	        --상품개수
	cart_totalprice number(20) not null,    --total 금액
    primary key(cart_seq)       
);

-- 2) 테이블 삭제
drop table cart purge;

-- 3) 테이블 확인
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence cart_seq nocycle nocache;

-- 5) 시퀀스 객체 삭제
drop sequence cart_seq;

-- 6) 데이터 저장하기
insert into cart 
values('hong', cart_seq.nextval, '001', 'test', 'black', 'S', 'aa.jpg', 10, 1000, 10000);

-- 7) 전체 내용 확인
select * from cart order by cart_seq desc;

-- 8) 특정 글번호로 내용 확인
select * from cart where cart_seq=1;
select * from cart where user_id = 'hong';

-- 9) 데이터 수정
update cart set 
item_code='0001', item_size='M',
cart_qty=3, cart_totalprice=30000 where cart_seq=1;

update cart set 
item_code='0001' where cart_seq=2;

-- 10) 데이터 삭제
delete cart where cart_seq=3;

-- 11) db 저장
commit;

-- 12) 인덱스 뷰
-- hidden column => rownum
select * from
(select rownum rn, tt.* from
(select * from cart order by cart_seq desc) tt)     --내림차순 정렬
where rn>=1 and rn<=3 and user_id='hong';

-- 13) 총데이터 개수 구하기
select count(*) as cnt from cart where user_id='lee333';

-- 14) 특정 회원의 장바구니 총 상품 금액 구하기
select sum(cart_totalprice) from cart where user_id='hong';

-- 15) 특정 상품의 카테고리 불러오기
select item_category1, item_category2 
from itemView where item_code = '0001';

-- 16) 추천상품 5개 불러오기
select * from
(select rownum rn, tt.* from
(select * from itemView order by item_seq desc) tt)     --내림차순 정렬
where rn>=1 and rn<=5 and item_category1='MEN';


rollback;
