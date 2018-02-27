select 
	tr.*,
	tx.name as taxonomy_name,
	tx.description as taxonomy_description,
	tx.weight as taxonomy_weight 
from 
	Terms tr 
left join 
	Taxonomies tx
on
	tr.parent_id = tx.id
where
/*%if parentId != null*/
	tx.id = /* parentId */'9046bb3f-a560-47a5-9a9a-2fe8b076d91e'
/*%end*/
/*%if keyword != null*/
and
(
	(tr.name like /* keyword */'%Y%') 
or 
	(tr.description like /* keyword */'%Y%') 
or 
	(tx.name like /* keyword */'%Y%')
or 
	(tx.description like /* keyword */'%Y%')
)
/*%end*/ 
/*# orderBy */