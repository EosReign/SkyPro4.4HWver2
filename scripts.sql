select *
from table_students
where student_age between 10 and 20;

select student_name
from table_students;

select *
from table_students
where student_name like '0%';

select *
from table_students
where student_age < student_id;

select *
from table_students
order by student_age;

select s.* from table_faculties as f, student as s
where s.faculty_id = f.id
  and f.faculty_name = 'griffindor';

select f.* from table_faculties as f, student as s
where s.faculty_id = f.id
  and s.student_name = 'Harry Potter';