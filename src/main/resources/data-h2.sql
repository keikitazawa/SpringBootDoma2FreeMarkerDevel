insert into Users(id, email, password, role) values('ce6d0428-86f4-4ef6-92eb-c036b82676fb', 'a@a.com', '$2a$10$qdXL11GtF1Tkv/2HU3fiXOp4UhwoA3TzMi0cOKt11c.pV0na8aSN2', 'USER');

insert into Taxonomies(id, name, description, weight) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '記事カテゴリー', '一般的な投稿記事', 0);
insert into Taxonomies(id, name, description, weight) values('c68f3caf-6b69-4d66-88dd-086ae171c5c7', 'テストカテゴリー', 'xyz:000', 10);
insert into Taxonomies(id, name, description, weight) values('32f02680-ae63-4e0b-8ab5-366fc1970306', 'テストカテゴリー2', 'zzz:000', 20);
insert into Taxonomies(id, name, description, weight) values('ad098958-80f1-4e8f-85db-7a5080f9158d', 'テストカテゴリー3', 'xxx:001', 15);

insert into Terms(id, parent_id, name, description, weight) values('4b07fdb5-ae4c-4529-8c01-321c0859bb28', '9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '一般', 'desc:一般', 1);
insert into Terms(id, parent_id, name, description, weight) values('01af6686-581a-46eb-9ef7-682311fbd917', '9046bb3f-a560-47a5-9a9a-2fe8b076d91e', 'PC', 'desc:PC', 2);
insert into Terms(id, parent_id, name, description, weight) values('d344d8f7-99c7-49b3-9ac5-8aef925c0192', '9046bb3f-a560-47a5-9a9a-2fe8b076d91e', 'IYH', 'desc:IYH', 30);
insert into Terms(id, parent_id, name, description, weight) values('bb70eae3-5966-42cd-bc08-936ee47b4836', '9046bb3f-a560-47a5-9a9a-2fe8b076d91e', 'その他', 'desc:その他', 100);
insert into Terms(id, parent_id, name, description, weight) values('a12ebe15-306c-4b25-8ca5-6f9b7cd27f2c', '9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '物欲', 'desc:物欲', 31);
insert into Terms(id, parent_id, name, description, weight) values('d60ffd1e-dc09-48d2-8a29-152e92ae8a48', '9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '秋葉原', 'desc:秋葉原', 32);
insert into Terms(id, parent_id, name, description, weight) values('a489f780-72d0-4a5f-b078-6b147797b4c1', '9046bb3f-a560-47a5-9a9a-2fe8b076d91e', 'パーツ通り', 'ぺぺぺ', 33);
insert into Terms(id, parent_id, name, description, weight) values('ffff3caf-6555-4aaa-88dd-086ae17ccccc', 'c68f3caf-6b69-4d66-88dd-086ae171c5c7', '一般', 'テストカテゴリー一般', 1);


insert into TermTrees(taxonomy_id, parent_id, id) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '00000000-0000-0000-0000-000000000000', '4b07fdb5-ae4c-4529-8c01-321c0859bb28');
insert into TermTrees(taxonomy_id, parent_id, id) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '00000000-0000-0000-0000-000000000000', '01af6686-581a-46eb-9ef7-682311fbd917');
insert into TermTrees(taxonomy_id, parent_id, id) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '00000000-0000-0000-0000-000000000000', 'd344d8f7-99c7-49b3-9ac5-8aef925c0192');
insert into TermTrees(taxonomy_id, parent_id, id) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', '00000000-0000-0000-0000-000000000000', 'bb70eae3-5966-42cd-bc08-936ee47b4836');
insert into TermTrees(taxonomy_id, parent_id, id) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', 'd344d8f7-99c7-49b3-9ac5-8aef925c0192', 'a12ebe15-306c-4b25-8ca5-6f9b7cd27f2c');
insert into TermTrees(taxonomy_id, parent_id, id) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', 'd344d8f7-99c7-49b3-9ac5-8aef925c0192', 'd60ffd1e-dc09-48d2-8a29-152e92ae8a48');
insert into TermTrees(taxonomy_id, parent_id, id) values('9046bb3f-a560-47a5-9a9a-2fe8b076d91e', 'd60ffd1e-dc09-48d2-8a29-152e92ae8a48', 'a489f780-72d0-4a5f-b078-6b147797b4c1');
