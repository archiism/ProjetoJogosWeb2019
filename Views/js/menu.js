var modal =document.querySelector('#abrir2')
var contador = -1;

modal.addEventListener('click',function(){
    event.preventDefault();
    
    contador++
    
    if(contador % 2 == 0){         
        window.location="#abrir";
        console.log('par')
        modal.style.backgroundColor = 'red';
    }
    if(contador % 2 != 0){
        console.log('impar')
        window.location='#fechar'
        console.log(contador)
        modal.style.backgroundColor = '#78cafa';
        
    }
    
})  

