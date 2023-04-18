insert into user_details(id, birth_date, name)
values(10001, current_date(), 'Ravi');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'Jayesh');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'Kiran');

insert into post(id, article, user_id)
values(20001, 'I love to explore Spring', 10001);

insert into post(id, article, user_id)
values(20002, 'Love and fear',  10001);

insert into post(id, article, user_id)
values(20003, 'We do love ourselves', 10002);

insert into post(id, article, user_id)
values(20004, 'We all are fine', 10001);

insert into post(id, article, user_id)
values(20005, 'I would love to play video games', 10002);

insert into post(id, article, user_id)
values(20006, 'I did explore AWS cloud service last week', 10003);