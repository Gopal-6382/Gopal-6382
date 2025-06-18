window.addEventListener('scroll',function(){
    const box2=this.document.querySelector('.box-2');
    const main=this.document.querySelector('.main');
    const mainBottom=main.getBoundingClientRect().bottom;
    if(window.scrollY >= mainBottom){
        box2.style.position='fixed';
        box2.style.top='0';
    }
    else{
        box2.style.position='relative';
        box2.style.top='';
    }
});