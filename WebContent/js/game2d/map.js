/**
 * 
 */
function Map() {
	this.width = 800;
	this.heith = 600;
}

Map.prototype.getWidth = function() {
	return this.width;
}

Map.prototype.getHeight = function() {
	return this.heith;
}