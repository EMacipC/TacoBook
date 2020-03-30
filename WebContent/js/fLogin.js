var campos = document.getElementsByClass("nulos");
var submit= document.getElementById("sub");


function validar(){
	if(campos== null ||campos==""){
		submit.disabled=true
	}else
		submit.disabled=false
		
}