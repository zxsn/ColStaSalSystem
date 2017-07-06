function showList(div_id) 
{
var obj = document.getElementById(div_id + "_ljf");
var click_obj = document.getElementById(div_id);
var text = click_obj.innerHTML;
if(obj.style.display == "none") 
{
var str = div_id.substring(0,div_id.length - parseInt(getNumberLen(div_id)));
var num = div_id.replace(str,"");
for(i=1;;i++)
{
   if(!document.getElementById(str+i)) break;
   document.getElementById(str+i+"_ljf").style.display = "none";
   var iHtml = document.getElementById(str+i).innerHTML;
   document.getElementById(str+i).innerHTML = iHtml.replace("images/over.gif","images/start.gif");
}

obj.style.display = "block";
click_obj.innerHTML = text.replace("images/start.gif","images/over.gif");
} 
else 
{ 
obj.style.display = "none";
click_obj.innerHTML = text.replace("images/over.gif","images/start.gif");
} 
}

function getNumberLen(str)
{
var ljf = null;
if (ljf = str.match(/(\d+)[^\d]*$/))
{
return ljf[1].length;
}
}

function IsNum(e) {
            var k = window.event ? e.keyCode : e.which;
            if (((k >= 48) && (k <= 57)) || k == 8 || k == 0) {
            } else {
                if (window.event) {
                    window.event.returnValue = false;
                }
                else {
                    e.preventDefault(); //for firefox 
                }
            }
        } 
