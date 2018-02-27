select * 
from taxonomies 
where 
/*%if name != null*/
	name LIKE /* name */'%テスト%'
/*%end*/
order by weight asc