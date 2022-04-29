create table order_page(
    ord_date date not null,                        -- 주문 날짜
    ord_number number not null,                    -- 주문 번호(시퀀스)
    ord_code varchar2(100) not null,               -- 상품 번호
    ord_name varchar2(100) not null,               -- 상품 이름
    ord_color varchar(20) not null,                -- 색상
    ord_size varchar(20) not null,                 -- 사이즈
    ord_image varchar(100) not null,               -- 이미지
    ord_price number(20) not null,                 -- 상품 개별 금액
    ord_qty number(10) not null,                   -- 상품 개수
    ord_totalprice number(20) not null,            -- total 금액
    user_id	varchar2(15) not null,                 -- 회원 id
    user_name varchar2(20) not null,               -- 주문자 이름
    ord_addr1 varchar2(150) not null,              -- 주소
    ord_addr2 varchar2(150) not null,              -- 상세주소
    ord_payment	varchar(20) not null,              -- 결제 수단
    primary key (ord_number)
);  

drop table order_page purge;

create sequence seq_order nocache nocycle;

drop sequence seq_order;

insert into order_page values(sysdate, seq_order.nextval, '1234', '나이키머큐리얼에어줌베이퍼14프로'
, 'white', '265', 'image', 55000, 1, 57000, 'user_id', 'user_name', '서울시', '마포구', 'payco');

select count(*) as cnt from order_page where user_id='1234';

select * from order_page;
select * from order_page where ord_number='1';
select * from order_page order by ord_number desc;

select * from
(select rownum rn, tt.* from
(select * from order_page order by ord_number desc) tt)     --내림차순 정렬
where rn>=1 and rn<=3 and user_id='hong';

update order_page set item_name='오늘도' where ord_qty=1;    -- 예시

-- 상품갯수 0개인 상품은 삭제
delete order_page where ord_qty=0;

commit;