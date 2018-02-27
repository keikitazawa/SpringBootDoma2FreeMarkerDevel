var QueryString = function(params, values){
	this.params = params.split(",");
	this.values = values.split(",")
}
QueryString.prototype.build = function() {
	var count = this.params.length;
	var valueCount = this.values.length;
	
	var queryString = "";
	
	if (count > valueCount){
		count = valueCount;
	}
	
	if (count > 0){
		queryString = "?";
		var query = new Array();
		for(var i = 0; i < count; i++){
			query.push(this.params[i] + "=" + this.values[i]);
		}
		queryString += query.join("&");
	}
	return queryString;
};

var Url = function(url){
	this.url = url
}
Url.prototype.getQueryString = function() {
	var urls = this.url.split("?");
	var ret = "";
	if (urls.length > 1){
		ret = urls[1];
	}
	return ret;
}