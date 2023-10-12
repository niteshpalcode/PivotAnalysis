<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Student Registration</title>
<style>
body{
background-image:url("https://www.freecodecamp.org/news/content/images/size/w2000/2022/09/jonatan-pie-3l3RwQdHRHg-unsplash.jpg");
background-color:teal;}
#container {
	width: 40%;
	
	box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
	margin: auto;
	border-radius: 15px;
	padding-top: 2px;
	background-color: rgb(216,236,234);
}
.heading:hover{
color: black;

}
.heading {
transition: width 2s, height 4s;
font-family:cursive;
	text-align: center;
	align-items: center;
	margin-bottom: 30px;
	color: teal;
	background-color: rgb(216,236,234);
}

#container>form {
width: 80%;
margin: auto;
background-color:rgb(216,236,234);

}



#submit {
	
	width:100%;
	text-align:center;
	align-items:center;
	padding-bottom:25px;
	margin:auto;
	border-radius: 20px;
	margin-bottom: 20px;
	margin-top: 20px;
	
	
}

#submit:hover {
	background-color: green;
	color: white;
	border-radius: 20px;
}
h3{
margin-bottom: -5px;
background-color: rgb(216,236,234);}


input{
width: 100%;
height: 20px;
padding: 5px;
border: 1px solid;
background-color: white;

}
.gender{
width:10%;
border: 1px solid;
color: red;

}
.gen{
background-color: rgb(216,236,234);
}
#submitButton{
width:40%;
margin: auto;
}

</style>
</head>
<body>

	<div id="container">
		<h1 class="heading">Student Registration Form</h1>
			<form action="addStudent" method="post"  onsubmit=""  modelAttribute="student">
				<h3>First Name</h3>
				<br> <input type="text" id="ffirstName" name="firstName" placeholder="First Name">
				<span id="firstNamee"></span><br>
				<h3>Last Name</h3>
				<br> <input type="text" id="lastNamee" name="lastName"	placeholder="Last Name">
				 <span id="llastNamee"></span><br>
				<h3>Gender</h3><br>
				 <input type="radio" class="gender" name="gender" value="male" > 
				 <label class="gen">Male</label>
				<input type="radio" name="gender"value="female" class="gender">
				<label class="gen">Female</label>
				<h3>Roll Number</h3>
				<br> <input type="number" id="rollNumber" placeholder="rollNumber"	name="rollNumber"><br>
				<h3>Email</h3>
				<br> <input type="email" id="email" placeholder="Email"	name="email"><br>
				<h3>Standard</h3>
				<br> <input type="number" id="standard" placeholder="standard"	name="standard"><br>
				<h3>Age</h3>
				<br> <input type="number" name="age" id="inputDate"><br> 
				<span id="dateInput"> </span>
				<div id=submitButton>
				<input	id="submit" type="submit">
		</div>

		</form>

	</div>


</body>
</html>
<script>
	function validation() {
		console.log("valid");
		var first = document.getElementById("ffirstName").value;
		let length = first.length;
		var last = document.getElementById("lastNamee").value;
		var em = document.getElementById("email").value;
		var mobile = document.getElementById("mobile").value;
		//alert(mobile);

		var date = document.getElementById("inputDate").value;
		console.log(date);
		date=new Date(date);
		var CurrentDate = new Date();
		
		if(date > CurrentDate){
			var d=document.getElementById("dateInput");
			d.innerHTML = "Dob cant be greater than current date";
			d.style.color = "red";
			return false;
			
		}
			
		if (isNaN(mobile)) {
			let mob = document.getElementById('mobilee');
			mob.innerHTML = "Only Numeric Value Allowed!!";
			mob.style.color = "red";
			return false;
		}
		if (!isNaN(mobile)){
			let length=mobile.length;
			console.log(length);
			let mob = document.getElementById('mobilee');
			if(length<10){
				mob.innerHTML = "Number should not less than 10 digits!!";
				mob.style.color = "red";
				return false;
			}
			else if(length>10){
				mob.innerHTML = "Number should not greater than 10 digits!!";
				mob.style.color = "red";
				return false;
			}
			
			
		}
		
		if (!first) {
			let ih = document.getElementById('firstNamee');
			ih.innerHTML = "Field cant be blank";
			ih.style.color = "red";
			return false;
		}

		if (first) {
			/* if(first.length==0){
				console.log("0");
				let ih = document.getElementById('firstNamee');
				ih.innerHTML = "Field cant be blank";

			} */

			for (var i = 0, j = 0; i < first.length, j < last.length; i++, j++) {

				if (!isNaN(first[i])) {
					let ih = document.getElementById('firstNamee');
					ih.innerHTML = "Numeric Value is not allowed!!";
					ih.style.color = "red";
					return false;

				}

			}
		}
		if (!last) {
			let lh = document.getElementById('llastNamee');
			lh.innerHTML = "Field cant be blank";
			lh.style.color = "red";
			return false;
		}
		if (last) {
			for (var j = 0; j < last.length; j++) {

				if (!isNaN(last[j])) {
					let lh = document.getElementById('llastNamee');
					lh.innerHTML = "Numeric Value is not allowed!!";
					lh.style.color = "red";
					return false;
				}

			}
		}

	}
</script>