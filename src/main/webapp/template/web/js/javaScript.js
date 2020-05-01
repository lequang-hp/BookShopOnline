var slideIndex = 1;
showDivs(slideIndex);
function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName('mySlides');
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = 'none';
  }
  x[slideIndex-1].style.display = 'block'; 
}
auto(slideIndex);
function auto(){
  var i;
  var x= document.getElementsByClassName('mySlides');
  for(i=0; i<x.length;i++){
    x[i].style.display='none';
  }
  slideIndex++;
  if (slideIndex > x.length) {slideIndex = 1}
  x[slideIndex-1].style.display = 'block'; 
  setTimeout(auto, 2000);
}
autos(slideIndex);

function autos(){
  var i;
  var x= document.getElementsByClassName('slides-auto');
  for(i=0;i<x.length;i++){
    x[i].style.display='none';
  }
  slideIndex++;
  if(slideIndex>x.length){slideIndex=1}
  x[slideIndex-1].style.display='block';
  setTimeout(autos, 3000);
}
function openInformation(other) {
  var i;
  var x = document.getElementsByClassName('openin');
  for (i = 0; i < x.length; i++) {
      x[i].style.display = 'none'; 
  }
  document.getElementById(other).style.display = 'block'; 
}
function openInformation(infor) {
  var i;
  var x = document.getElementsByClassName('openin');
  for (i = 0; i < x.length; i++) {
      x[i].style.display = 'none'; 
  }
  document.getElementById(infor).style.display = 'block'; 
}

document.ready(function(){
  (".nav-tabs a").click(function(){
      (this).tab('show');
  });
  ('.nav-tabs a').on('shown.bs.tab', function(event){
      var x = (event.target).text();         // active tab
      var y = (event.relatedTarget).text();  // previous tab
      (".act span").text(x);
      (".prev span").text(y);
  });
});
