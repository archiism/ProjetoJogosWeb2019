var modal =document.querySelector('#abrir2')


modal.addEventListener('click',function(){
    event.preventDefault();
    
    var contador = 0;
    if(contador % 2 === 0){         
        window.location="#abrir";
        contador++   
    }
    if(contador % 2 != 0){
        console.log('impar')
        modal.Style.opacity = 0;
    }
})  

