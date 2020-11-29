// create empty global variable
var image;


function upload() {
    // Prototype
    // var fileinput = document.getElementById('finput');
    // var filename = fileinput.value;
    // alert("You chose " + filename)

    // real upload
    var imgcanvas = document.getElementById('canvas')
    var fileinput = document.getElementById('finput')

    // changing global variable content
    image = new SimpleImage(fileinput)
    image.drawTo(imgcanvas)
}

function makeGray() {
    for (var pixel of image.values()) {
        var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
        pixel.setRed(avg)
        pixel.setGreen(avg)
        pixel.setBlue(avg)
    }
    var imgcanvas = document.getElementById('canvas')
    image.drawTo(imgcanvas)
}
