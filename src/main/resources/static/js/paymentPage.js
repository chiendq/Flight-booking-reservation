function form_validation() {
    var inputFullName = document.getElementsByClassName('input-contact');
    for (let i = 0; i < inputFullName.length; i++) {
        if (inputFullName[i].value == '' || inputFullName[i] == null) {
            var miniRow = document.getElementById('fullNameError');
            miniRow.innerText = 'Vui lòng điền đủ thông tin !';
            event.preventDefault();
            break;
        }
    }
}

window.onload = function () {
    document.getElementById('dateOfBirth').value = new Date().toJSON().slice(0, 10).replace(/-/g, '-');
}
