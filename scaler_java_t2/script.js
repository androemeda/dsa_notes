var increment_btn = document.querySelector(".increment-btn");
var decrement_btn = document.querySelector(".decrement-btn");
var reset_btn = document.querySelector(".reset-btn");
var counter = 0;

increment_btn.addEventListener('click' , function(){
    counter++;
    var h3Element = document.querySelector("h3");
    h3Element.innerText = counter;
})

decrement_btn.addEventListener('click' , function(){
    if(counter>0){
        counter--;
        var h3Element = document.querySelector("h3");
        h3Element.innerText = counter;
    }else{
        alert("counter can't be negetive.");
    }
})

reset_btn.addEventListener('click' , function(){
    counter = 0;
    var h3Element = document.querySelector("h3");
    h3Element.innerText = counter;
})