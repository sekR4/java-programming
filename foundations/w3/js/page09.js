var fgImage = null;

function uploadForeground() {
    var canvas = document.getElementById('fgcanvas');
    var imagefile = document.getElementById('fgfile');
    fgImage = new SimpleImage(imagefile);
    fgImage.drawTo(canvas);
}
