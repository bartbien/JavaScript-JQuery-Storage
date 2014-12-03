/**
 * 
 */
	var hGameArea;
	var hCanvas;
	var context;
		
	var player = new Player();
	var map = new Map();
	
	var keys = [];
	
	window.onload = function init() 
	{
		hCanvas = document.getElementById("canvas");

		context = canvas.getContext("2d");
		gameLoop();
	}

	window.addEventListener("keydown", function(e) {
		keys[e.keyCode] = true;
	});
	
	window.addEventListener("keyup", function(e) {
		keys[e.keyCode] = false;
	});
	
	

	function gameLoop() 
	{
		movement();
		hCanvas.width = map.getWidth();
		hCanvas.height = map.getHeight();
		
		context.fillRect(player.getPosX(), player.getPosY(), player.getSize(), player.getSize());
		
		window.requestAnimationFrame(gameLoop); // fps 
		
		// window.webkitRequestAnimationFrame(gameLoop);
		// window.mozRequestAnimationFrame(gameLoop);
		
    };

	function movement() 
	{
		keyEvents();
		checkWalls();
	}
	
	function keyEvents()
	{
		var posX = player.getPosX();
		var posY = player.getPosY();
		
		if (keys[37]) // left arrow
		{
			//console.log(posX);
			posX -= player.getSpeed();
		}
		
		if (keys[38]) // up arrow
		{
			posY -= player.getSpeed();
		}

		if (keys[39]) // right arrow
		{
			posX += player.getSpeed();
		}
		
		if (keys[40]) // down arrow
		{
			posY += player.getSpeed();
		}
		
		player.setPosX(posX);
		player.setPosY(posY);
	}
	
	function checkWalls()
	{
		var posX = player.getPosX();
		var posY = player.getPosY();
		
		if(posX <= 0)
		{
			posX = 0;
			//console.log(posX);
		}
		
		if(posX >= (map.getWidth() - player.getSize())) // player redraw from top-left pixel that's why need to map - size
		{
			posX = (map.getWidth() - player.getSize());
			//console.log("s");
		}
		
		if(posY <= 0)
		{
			posY = 0;
			//console.log("s");
		}
		
		if(posY >= (map.getHeight() - player.getSize())) // player redraw from top-left pixel that's why need to map - size
		{
			posY = (map.getHeight() - player.getSize());
			//console.log("s");
		}
		
		player.setPosX(posX);
		player.setPosY(posY);
	}