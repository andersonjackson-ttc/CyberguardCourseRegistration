function menu() {
    var majorlist = document.getElementById("majorlist");
    document.getElementById("Favorite").value = majorlist.options[majorlist.selectedIndex].text;
  }

window.onload = function()
{
    var btnMajor = document.getElementById('btnMajor');
    
    btnMajor.addEventListener('click', newTable, false);
    
}

function newTable(){
    clearcontent('table');
    var checkbox = '<tr><td id="boxCourse"><input type="checkbox" class="taking"></td>';
    var table = ' <table><tr><th id="boxCourse"></th><th id="textCourse">Course Id</th><th id="textCourse">Course Name</th></tr>';
    table += checkbox + '<td id="textCourse">ABC-123</td><td id="textCourse">The Alphabet</td></tr></table>';
    
    document.getElementById('table').innerHTML = table;
        
    
}

function clearcontent(elementID) {
            document.getElementById(elementID).innerHTML = "";
        }