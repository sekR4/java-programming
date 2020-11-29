function dochange() {
    alert('Du hast JavaScript benutzt');
}

function choseandrespond() {
    var message;
    var choice = confirm("Willst du weitermachen?");
    if (choice == true) {
        message = "Wir machen weiter :)"
    }
    else {
        message = "Wir hören auf :("
    }
    document.getElementById('makechoice').innerHTML = message
}
