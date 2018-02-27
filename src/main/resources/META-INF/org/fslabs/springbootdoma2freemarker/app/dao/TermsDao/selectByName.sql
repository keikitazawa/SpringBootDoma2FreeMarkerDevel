select * 
from terms 
where 
/*%if name != null*/
	name LIKE /* name */'%PC%'
/*%end*/
order by weight asc