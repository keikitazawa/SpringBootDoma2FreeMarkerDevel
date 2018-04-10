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
	tt.taxonomy_id = /* taxonomyId */'9046bb3f-a560-47a5-9a9a-2fe8b076d91e'
/*%if parentId != null*/
and
	tt.parent_id = /* parentId */'00000000-0000-0000-0000-000000000000'
/*%end*/
and
	tr.deleted is null 
/*# orderBy */
	
	