select
	*
from
	Taxonomies
where
/*%if keyword != null*/
(
	name like /* keyword */'t'
or
	description like /* keyword */'t'
)
/*%end*/
/*# orderBy */