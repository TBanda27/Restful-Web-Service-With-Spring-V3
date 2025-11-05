insert into user_details(id, birth_date, name)
values(10001, current_date(), 'Banda');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'Lorraine');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'Raymond');

insert into post(id, description, user_id)
values(10001, 'This is my first post as an admin', 10001);

insert into post(id, description, user_id)
values(10002, 'So good to be an admin man, i am so thrilled to be here mate', 10001);

insert into post(id, description, user_id)
values(10003, 'Why are you threatening to remove me from this position. Why?', 10002);

insert into post(id, description, user_id)
values(10004, 'I Just wanted to let you guys know that i am no longer an admin', 10003);


