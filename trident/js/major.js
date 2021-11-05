function menu() {
    var majorlist = document.getElementById("majorlist");
    document.getElementById("Favorite").value = majorlist.options[majorlist.selectedIndex].text;
  }

window.onload = function()
{
    var btnMajor = document.getElementById('btnMajor');
    
    btnMajor.addEventListener('click', getCourses, false);
    
}
function getMajorList() {
  if(done==false)
  {
  urlString = "/major";
  $.ajax({method: "GET", url: urlString, dataType: 'json'})
    .done(function(response)  {
      // response = JSON.stringify(response);
      //alert((JSON.stringify(response)));
      majorDropDown = $("#myDropdown");
      var appenddata1 = "";

        for (var i = 0; i < response.length; i++) {
            appenddata1 += "<option value = '" + response[i].id + " '>" + response[i].major_Name + " </option>";
        }
        $("#myDropdown").append(appenddata1);
        done=true;
      
      
    })
    .fail(function(){
      alert("Error connecting to the server");
    })
    .always(function(){
    
    })
  ;
  }
}
function newTable(){
    clearcontent('table');
    var checkbox = '<tr><td id="boxCourse"><input type="checkbox" class="taking"></td>';
    var table = ' <table><tr><th id="boxCourse"></th><th id="textCourse">Course Id</th><th id="textCourse">Course Name</th></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">ABC-123</td><td id="textCourse">The Alphabet</td></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">MAT-101</td><td id="textCourse">Geometry</td></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">ENG-101</td><td id="textCourse">Modern Literature</td></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">MCT-101</td><td id="textCourse">Military Code Talk</td></tr></table>';
    
    document.getElementById('table').innerHTML = table;
        
    
}
function getCourses() {

  urlString = "/courses?major=1+";
  $.ajax({method: "GET", url: urlString, dataType: 'json'})
    .done(function(response)  {
      // response = JSON.stringify(response);
      alert((JSON.stringify(response)));
      table = $("#table");
      var appenddata1 = "";


      clearcontent('table');
    var checkbox = '<tr><td id="boxCourse"><input type="checkbox" class="taking"></td>';
    var table = ' <table><tr><th id="boxCourse"></th><th id="textCourse">Course Id</th><th id="textCourse">Course Name</th></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">ABC-123</td><td id="textCourse">The Alphabet</td></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">MAT-101</td><td id="textCourse">Geometry</td></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">ENG-101</td><td id="textCourse">Modern Literature</td></tr>';
    table += '<tr>'  + checkbox + '<td id="textCourse">MCT-101</td><td id="textCourse">Military Code Talk</td></tr></table>';

      for (var j=0; j< response.length; j++)
      {
        appenddata1+= "<tr><td id='boxCourse'><input type='checkbox' class='taking'></td>" + "<td>" + response[j].course_ID+ "</td>" + "<td>"+ response[j].course_Name + "</td></tr>";
      }
      table.append(appenddata1);
  




    })
    .fail(function(){
      alert("Error connecting to the server");
    })
    .always(function(){
    
    })
  ;
  }

function clearcontent(elementID) {
            document.getElementById(elementID).innerHTML = "";
        }
