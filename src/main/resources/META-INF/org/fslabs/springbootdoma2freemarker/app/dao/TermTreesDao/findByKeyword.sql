select 
	tx.name as taxonomy_name,
	tt.id,
	tr.name,
	tr.description,
	tr.weight
from
	TermTrees tt
inner join
	Terms tr
on
	tt.id = tr.id
inner join
	Taxonomies tx
on
	tr.parent_id = tx.id
where
/*%if parentId != null*/
	tt.parent_id = /* parentId */'9046bb3f-a560-47a5-9a9a-2fe8b076d91e'
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
and
	tr.deleted is null 
/*# orderBy */
	
	