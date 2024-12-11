const modal = document.querySelector('.modal');
const modalOpen = document.getElementById("newButton");
const modalClose = document.getElementById("closeButton");

modalOpen.addEventListener('click',function(){
    modal.style.display = 'block';
});

modalClose.addEventListener('click',function(){
    modal.style.display = 'none';
});