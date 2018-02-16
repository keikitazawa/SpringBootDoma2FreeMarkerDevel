select * from terms
where
/*%if parentId != null*/
	parent_id = /* parentId */'9046bb3f-a560-47a5-9a9a-2fe8b076d91e'
/*%end*/
/*%if keyword != null*/
and
(
	name like /* keyword */'%Y%'
or
	description like /* keyword */'%Y%'
)
/*%end*/
/*# orderBy */
