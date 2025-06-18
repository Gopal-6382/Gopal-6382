/*
let full_name="Tutor Joes";
let age="12";
let city="Salem";
let role="CEO Tutor Joes";
*/
/*
output="<table border='05'><tr><th>Name</th><td>"+full_name+"</td></tr><tr><th>Age</th><td>"+age+"</td></tr><tr><th>City</th><td>"+city+"</td></tr><tr><th>Role</th><td>"+role+"</td></tr></table>";
document.body.innerHTML = output;
*/
/*
//es5
output="<hr><table border='1'>"+
"<tr><th>Name</th><td>"+full_name+"</td></tr>"+
"<tr><th>Age</th><td>"+age+"</td></tr>"+
"<tr><th>City</th><td>"+city+"</td></tr>"+
"<tr><th>Role</th><td>"+role+"</td></tr>"+
"</table>";
document.body.innerHTML = output;
*/
/*
//es6
output=`<hr>
<table border='1'>
  <tr><th>Name</th><td>${full_name}</td></tr>
  <tr><th>Age</th><td>${age>=25?"Good":"Bad"}</td></tr>
  <tr><th>City</th><td>${city}</td></tr>
  <tr><th>Role</th><td>${role}</td></tr>
</table>`;
document.body.innerHTML = output;
*/

let full_name = "Tutor Joes";
let age = "12";
let city = "Salem";
let role = "CEO Tutor Joes";
/*
output1 = "<hr><table border='1'> <tr><th>Age</th><td>" + full_name + "</td></tr><tr><th>Name</th><td>" + age + "</td></tr><tr><th>City</th><td>" + city + "</td></tr><tr><th>Role</th><td>" + role + "</td></tr></table>";
document.body.innerHTML = output1;
*/
/*
output = "<hr><table border='1'>" +
  "<tr><th>Age</th><td>" + full_name + "</td></tr>" +
  " <tr><th>Name</th><td>" + age + "</td></tr>" +
  "<tr><th>City</th><td>" + city + "</td></tr><tr>" +
  " <th>Role</th><td>" + role + "</td></tr>" +
  "</table>";
document.body.innerHTML = output;
*/

//es6
output =`<hr>
<table border='1'>
  <tr><th>Name</th><td>${full_name}</td></tr>
  <tr><th>Age</th><td>${age >= 25 ? "Good" : "Bad"}</td></tr>
  <tr><th>City</th><td>${city}</td></tr>
  <tr><th>Role</th><td>${role}</td></tr>
</table>`;

document.body.innerHTML = output;