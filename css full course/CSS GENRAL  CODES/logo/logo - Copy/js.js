const btn=document.getElementsByClassName('btn')[0];
const navbar=document.getElementsByClassName('nav-link ');
btn.addEventListener('click',()=>{
navbar.classList.toggle('active');
});
