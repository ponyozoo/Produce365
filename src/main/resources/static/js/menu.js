const uri = window.location.pathname;
const menu = uri.substring(uri.lastIndexOf("/") + 1);
document.getElementById(menu).className += ' selectedMenu';