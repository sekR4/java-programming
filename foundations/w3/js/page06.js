// nothing
function doBlue() {
  var canvas = document.getElementById("can");
  canvas.style.backgroundColor = "blue";
}

function doColor() {
  var canvas = document.getElementById("can");
  var colorinput = document.getElementById("clr");
  canvas.style.backgroundColor = colorinput.value;
}

function doSquare() {
  var sliderinput = document.getElementById("slr");
  var len = sliderinput.value;
  var canvas = document.getElementById("can");
  var context = canvas.getContext("2d");

  // removes prev rectangle
  context.clearRect(0,0,canvas.width,canvas.height);

  // defines & creates new rectangle based on sliderinput
  context.fillStyle = "yellow";
  context.fillRect(10,10,len,len);
  context.fillRect(parseInt(len)+20,10,len,len);
  context.fillRect(len*3,10,len,len);
}
