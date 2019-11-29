use workshop;
create table author(
	authorno int primary key,
	name varchar(50),
	phone varchar(30)
);
/*
author 자료: 1, diana, 01012345678
2, 김현주, 01011112222
3, 김태희, 01033334444
4, 서민규, 01087654321
5, 이세준, 01015935742
*/
alter table book add authorno int references author(authorno);
alter table book drop author;
select * from book;
insert into author values(1, 'diana', '01012345678');
insert into author values(2, '김현주', '01011112222');
insert into author values(3, '김태희', '01033334444');
insert into author values(4, '서민규', '01087654321');
insert into author values(5, '이세준', '01015935742');
select * from book;
update book set authorno = 3 where isbn like '%4';
update book set authorno=null where authorno=2;

select title, price, name
from book left join author using( authorno);

select title, isbn, publisher from book where authorno=(select authorno from author where name='김태희');

select name, title, publisher, price
from author a left join book b using(authorno);

commit;

select concat(title,'은 ',  publisher,'에서 출판했다.') from book;
# 8. 출판사별도서가격의합계를출력하는View를작성하세요.
create or replace view sumPricePerPublisher
as 
select publisher, sum(price) from book group by publisher;



# 9. 8번에서작성된View를이용하여도서가격의합계가큰순위로출력하세요
select * from sumPricePerPublisher order by 2 desc;
