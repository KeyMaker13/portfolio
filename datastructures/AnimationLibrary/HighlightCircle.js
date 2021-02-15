
// "Class" animatedCircle


var HighlightCircle = function(objectID, color, radius)
{
	this.objectID = objectID;
	this.radius = radius;
	this.thickness = 4;
	this.foregroundColor = color;
	this.x = 0;
	this.y = 0;
}

HighlightCircle.prototype = new AnimatedObject();
HighlightCircle.prototype.constructor = HighlightCircle;


HighlightCircle.prototype.draw = function(ctx)
{	
	ctx.strokeStyle = this.foregroundColor;
	ctx.lineWidth = this.thickness;
	ctx.beginPath();
	ctx.arc(this.x,this.y,this.radius,0,Math.PI*2, true);
	ctx.closePath();
	ctx.stroke();
}


HighlightCircle.prototype.createUndoDelete = function()
{
	return new UndoDeleteHighlightCircle(this.objectID, this.x, this.y, this.foregroundColor, this.radius, this.layer);
}

		
function UndoDeleteHighlightCircle(objectID, x, y, circleColor, r, layer)
{
	this.objectID = objectID;
	this.x = x;
	this.y = y;
	this.color = circleColor;
	this.r = r;
	this.layer = layer;
}
		
UndoDeleteHighlightCircle.prototype = new UndoBlock();
UndoDeleteHighlightCircle.prototype.constructor = UndoDeleteHighlightCircle;

UndoDeleteHighlightCircle.prototype.undoInitialStep = function(world)
{
	world.addHighlightCircleObject(this.objectID, this.color, this.r);
	world.setLayer(this.objectID, this.layer)
	world.setNodePosition(this.objectID, this.x, this.y);
}




