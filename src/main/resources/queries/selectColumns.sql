select title as Курс, lecturer as Викладач from subjects;

select * from subjects where lecturer = 'Yurii Biliai';

select title from subjects where credits > 3;

select title, credits from subjects where credits > 3 and lecturer like 'Yurii Biliai';