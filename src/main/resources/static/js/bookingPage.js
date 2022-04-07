window.onload = function () {
    document.getElementById('adultPassengerNumber').value = 1;
    document.getElementById('departuretime').value = new Date().toJSON().slice(0,10).replace(/-/g,'-') ;
    document.getElementById('arrivaltime').value = new Date().toJSON().slice(0,10).replace(/-/g,'-') ;
    document.getElementById('economyClass1').checked = true;
};