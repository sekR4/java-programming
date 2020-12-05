var fgImage = null;
var bgImage = null;

function uploadForeground() {
    var canvas = document.getElementById('fgcanvas');
    var imagefile = document.getElementById('fgfile');
    fgImage = new SimpleImage(imagefile);
    fgImage.drawTo(canvas);
}

function uploadBackground() {
    var canvas = document.getElementById('bgcanvas');
    var imagefile = document.getElementById('bgfile');
    bgImage = new SimpleImage(imagefile);
    bgImage.drawTo(canvas);
}


function clearCanvas() {
  doClear(document.getElementById('fgcanvas'));
  doClear(document.getElementById('bgcanvas'));
}

function doClear(canvas) {
  var context = canvas.getContext("2d");
  context.clearRect(0,0,canvas.width,canvas.height);
}

function greenscreen(greenlevel=220) {

    // Assure fg and bg images are loaded
    if (fgImage == null || ! fgImage.complete()) {
        alert("Foreground Image not loaded");
        return;
    }

    if (bgImage == null || ! bgImage.complete()) {
        alert("Background Image not loaded");
        return;
    }

    clearCanvas()

    // change green pixels from fg image with pixels from bg image
    var output = new SimpleImage(fgImage.getWidth(), fgImage.getHeight())

    for (var pixel of fgImage.values()) {

        var x = pixel.getX()
        var y = pixel.getY()

        // if greenish use bg pixel
        if (pixel.getGreen() > greenlevel) {
            var bgPixel = bgImage.getPixel(x,y)
            output.setPixel(x,y,bgPixel)
        }
        // else use original fg pixel
        else {
            output.setPixel(x,y,pixel)
        }
    }
    // display new image in fg canvas
    var canvas = document.getElementById('fgcanvas')
    output.drawTo(canvas)


}
