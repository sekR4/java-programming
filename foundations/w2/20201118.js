// https://www.coursera.org/learn/duke-programming-web/supplement/4x9Bk/programming-exercise-advanced-modifying-images

// Part I: simple green screen algo
var fgImage = new SimpleImage('drewRobert.png')
var bgImage = new SimpleImage('dinos.png')
var output = new SimpleImage(fgImage.getWidth(), fgImage.getHeight())

for (var pixel of fgImage.values()) {
    if (pixel.getGreen() > pixel.getRed() + pixel.getBlue()) {
        var bgPixel = bgImage.getPixel(pixel.getX(),pixel.getY())
        output.setPixel(pixel.getX(),pixel.getY(),bgPixel)
    } else {
        output.setPixel(pixel.getX(),pixel.getY(),pixel)
    }
}
print(output)

// Part II: Fix broken Code
var img = new SimpleImage(200,200);
var w = img.getWidth()
var h = img.getHeight()

for (var px of img.values()){
  var x = px.getX();
  var y = px.getY();
  if (x < w/2 && y <= h/2){
    px.setRed(255);
  }
  if (x >= w/2 && y > h/2){
    px.setBlue(255);
  }
  if (x >= w/2 && y <= h/2){
    px.setGreen(255);
  }
  if (x < w/2 && y > h/2) {
    px.setRed(255);
    px.setGreen(0);
    px.setBlue(255);
  }
}
print(img);

// Part III: add black border
var img = new SimpleImage('smallpanda.png')


function setBlack(pixel) {
    pixel.setRed(0);
    pixel.setGreen(0);
    pixel.setBlue(0);
}

function addBorder(image, size=10) {

    var w = img.getWidth()
    var h = img.getHeight()

    for (var px of img.values()){
        var x = px.getX()
        var y = px.getY()

        // upper
        if (y <= size) {
            setBlack(px)
        }

        // lower
        if (y > h - size) {
            setBlack(px)
        }

        // left
        if (x <= size) {
            setBlack(px)
        }

        // right
        if (x > w - size) {
            setBlack(px)
        }
    }
}

addBorder(img)

print(img)
