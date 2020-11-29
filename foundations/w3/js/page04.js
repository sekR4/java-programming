function dolime() {
    var c1 = document.getElementById('c1')
    c1.style.backgroundColor='lime'
}

function doyellow() {
    var c1 = document.getElementById('c1')
    c1.style.backgroundColor='white'
    var ctx = c1.getContext('2d') // what is this doing?
    ctx.fillStyle='yellow'
    ctx.fillRect(10,10,40,40)
    ctx.fillRect(60,10,40,40)

    ctx.fillStyle='black'
    ctx.font='30px Arial'
    ctx.fillText("Hello", 10,80)
}
