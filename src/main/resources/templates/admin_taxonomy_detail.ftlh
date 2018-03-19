<#import "/__fielderror.ftlh" as fieldError>

<form name="modalRegistForm" method="get" action="${selfUri!}">
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="modal-label">タクソノミー編集</h4>
		</div>
		<div class="modal-body">
			<div class="row" id="ErrorList">
				<ul class="list-group">
				 <li class="list-group-item list-group-item-danger" id="ErrorList-1" style="display: none;"></li>
				</ul>
			</div>
			<div class="row">
				<div class="col-md-3">
					<span onClick="alert($('form[name=searchForm]').find('input[name=searchKeyword]').val());">カテゴリー名</span>
				</div>
				<div class="col-md-9">
					<input type="text" name="name" id="name_x" class="form-control" value="${taxonomy.name!}" />
					<@fieldError.main o=errors! field="name" cssclass="text-danger" />
				</div>
				<div class="col-md-3">
					説明
				</div>
				<div class="col-md-9">
					<textarea name="description" id="description_x" class="form-control">${taxonomy.description!}</textarea>
					<@fieldError.main o=errors! field="description" cssclass="text-danger" />
				</div>
				<div class="col-md-3">
					重さ
				</div>
				<div class="col-md-9">
					<input type="text" name="weight" id="weight_x" class="form-control" value="${taxonomy.weight!}" />
					<@fieldError.main o=errors! field="weight" cssclass="text-danger" />
				</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<!-- キー情報 -->
					<input type="hidden" name="id" value="${taxonomy.id!}" />
					<input type="hidden" name="version" value="${taxonomy.version!0}" />
					<!-- 検索条件 -->
					<input type="hidden" name="searchKeyword" class="form-control" value="${condition.searchKeyword!}" />
					<input type="hidden" name="p" value="${condition.p!}" />
					<input type="hidden" name="c" value="${condition.c!}" />
					<input type="hidden" name="d" value="${condition.d!}" />
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default btnClose">閉じる</button>
			<button type="button" class="btn btn-primary btnSave">保存</button>
		</div>
	</div>
</div>
<script src="/app/js/admin_taxonomy_detail.js"></script>