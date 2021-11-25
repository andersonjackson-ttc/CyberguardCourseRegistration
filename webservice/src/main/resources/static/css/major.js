console.log(5);
var done=false;
var submit = document.getElementById('submit');
var courseLink = "/courses?major=1+";


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


function getCourses() {
  $.ajax({method: "GET", url: "/courses?major=1+", dataType: 'json'})
    .done(function(response)  {
      // response = JSON.stringify(response);
      //alert(((response.toString())));
      table = $("#course_table");
      var appenddata1 = "";



      // for (var i = 0; i < response.length; i++) {
      //     appenddata1 += "<tr>";
      //       for (var j=0; j< i+1; j++)
      //       {
      //         appenddata1+= "<td id='boxCourse'><input type='checkbox' class='taking'>" + "</td>" + response[i].course_ID+"</td>" + "<td>"+ response[i].course_Name + "</td>";
      //       }
          
      //   }
      //   appenddata1 += "</tr>"
      //   table.append(appenddata1);


      appenddata1+="<table>"
      
      appenddata1 += "<tr><th id='boxCourse'></th><th id='textCourse'>Course Id</th><th id='textCourse'>Course Name</th></tr>"

      for (var j=0; j< response.length; j++)
      {
        console.log(9);
        appenddata1+= "<tr><td id='boxCourse'><input type='checkbox' class='taking' value='"+response[j].course_ID+"' name = 'CourseTaken'></td>" + "<td id='textCourse'>" + response[j].course_ID+ "</td>" + "<td id='textCourse'>"+ response[j].course_Name + "</td></tr>";
      }
      appenddata1+="</table>"
      table.append(appenddata1);
      //document.getElementById('course_table').innerHTML = table;
    })
    .fail(function(){
      alert("Error connecting to the server");
    })
    .always(function(){
    
    })
  ;
  }

const reloadtButton = document.querySelector("#reload");
// Reload everything:
function reload() {
    reload = location.reload();
}
// Event listeners for reload
reloadButton.addEventListener("click", reload, false);










  function clearcontent(elementID) {
            document.getElementById(elementID).innerHTML = "";
        }

// window.onload = function()
// {
//     window.addEventListener('pageshow', getCourses, true);
    
// }


// //get the id of the dropdown
// function Class(str)
// {
//   courseLink = "/courses?major="+str.toString()+"+";
//   //courseLink =+ "/courses?majors=" /*+ str.toString()*/;
//   //alert(courseLink);
// }














