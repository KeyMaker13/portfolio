﻿
function AnimatedLabel(id, val, center)
{
	this.centering = center;
	this.label = val;
	this.highlighted = false;
	this.objectID = id;
	this.alpha = 1.0;
	this.addedToScene = true;
	this.labelColor = "#000000";
	this.textWidth = 0;
}

AnimatedLabel.prototype = new AnimatedObject();
AnimatedLabel.prototype.constructor = AnimatedLabel;

AnimatedLabel.prototype.centered = function()
{
	return this.centering;
}


AnimatedLabel.prototype.draw = function(ctx)
{
	if (!this.addedToScene)
	{
		return;
	}
	
	ctx.globalAlpha = this.alpha;

	
	
	ctx.font = '10px sans-serif';
	if (this.centering)
	{
		ctx.textAlign = 'center';
		ctx.textBaseline   = 'middle'; 
	}
	else
	{
		ctx.textAlign = 'left';
		ctx.textBaseline   = 'top'; 
	}
	if (this.highlighted)
	{
	    ctx.strokeStyle = "#ffaaaa";
	    ctx.fillStyle = "#ff0000";
		ctx.lineWidth = this.highlightDiff;
		ctx.strokeText(this.label, this.x, this.y);		
	}
	ctx.strokeStyle = this.labelColor;
	ctx.fillStyle = this.labelColor;
	ctx.lineWidth = 1;
	strList = this.label.split("\n");
	this.textWidth = 0;
	if (strList.length == 1)
	{
		ctx.fillText(this.label, this.x, this.y);
		this.textWidth = ctx.measureText(this.label).width;
	}
	else
	{
		var offset = (this.centering)?  (1.0 - strList.length) / 2.0 : 0;
		for (var i = 0; i < strList.length; i++)
		{
			ctx.fillText(strList[i], this.x, this.y + offset + i * 12);
			this.textWidth = Math.max(this.textWidth, ctx.measureText(strList[i]).width);
		}		
	}
	ctx.closePath();
}

AnimatedLabel.prototype.setHighlight = function(value)
{
	this.highlighted = value;
}
		
AnimatedLabel.prototype.createUndoDelete = function()
{
	return new UndoDeleteLabel(this.objectID, this.label, this.x, this.y, this.centering, this.labelColor, this.layer);
}
		
		
AnimatedLabel.prototype.centerX = function()
{
	if (this.centering)
	{
		return this.x;
	}
	else 
	{
		return this.x + this.textWidth; 
	}
	
}
	   
AnimatedLabel.prototype.centerY = function()
{
	if (this.centering)
	{
		return this.y;
	}
	else 
	{
		return this.y; // TODO: + height/ 2
	}
   
}
	   
AnimatedLabel.prototype.top = function()	   
{
	   if (this.centering)
	   {
		   return  this.y; //TODO: - height / 2;
	   }
	   else 
	   {
			return this.y;   
	   }
}


AnimatedLabel.prototype.bottom = function()
{
   if (this.centering)
   {
	   return  this.y; // TODO: + height / 2;
   }
   else 
   {
	   return  this.y; // TODO: + hieght;
   }
}
	   
	   
AnimatedLabel.prototype.right = function()
{
   if (this.centering)
   {
	   return  this.x + this.textWidth / 2; // TODO: + width / 2;
   }
   else
   {
	   return  this.x + this.textWidth; // TODO: + width;
   }
}


AnimatedLabel.prototype.left = function()
{
   if (this.centering)
   {
	   return this. x - this.textWidth / 2;
   }
   else
   {
	   return  this.x; // TODO:  - a little?
   }
}

 AnimatedLabel.prototype.getTailPointerAttachPos = function(fromX, fromY, anchorPoint)
 {			 
	return this.getClosestCardinalPoint(fromX, fromY); 
 }

AnimatedLabel.prototype.getHeadPointerAttachPos = function (fromX, fromY) 
{
	return this.getClosestCardinalPoint(fromX, fromY);			
}

AnimatedLabel.prototype.setText = function(newText, textIndex)
{
	this.label = newText;
}



function UndoDeleteLabel(id, lab, x, y, centered, color, l)
{
	this.objectID = id;
	this.posX = x;
	this.posY = y;
	this.nodeLabel = lab;
	this.labCentered = centered;
	this.labelColor = color;
	this.layer = l;
}

UndoDeleteLabel.prototype = new UndoBlock();
UndoDeleteLabel.prototype.constructor = UndoDeleteLabel;

UndoDeleteLabel.prototype.undoInitialStep = function(world)
{
	world.addLabelObject(this.objectID, this.nodeLabel, this.labCentered);
	world.setNodePosition(this.objectID, this.posX, this.posY);
	world.setForegroundColor(this.objectID, this.labelColor);
	world.setLayer(this.objectID, this.layer);
}

