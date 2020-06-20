<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Job - Entreprise</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">

    <link href="css/style.css" rel="stylesheet" type="text/css" >
    
    <link href="css/nav.css" rel="stylesheet" type="text/css" >
    
    <script>
    function MyFunction() {
    	  // Get the checkbox
    	  var checkBox = document.getElementById("myCheck");
    	  var checkBox1 = document.getElementById("myCheck1");
    	  // Get the output text
    	  var text = document.getElementById("text");
    	  // If the checkbox is checked, display the output text
    	  if (checkBox.checked == true){
    	    text.style.display = "block";
    	  } else {
    	    text.style.display = "none";
    	  }
    	  
    	  if (checkBox1.checked == true){
      	    text.style.display = "none";
      	  } else {
      	    text.style.display = "block";
      	  }
    	}
    </script>


</head>
<body>
    <nav>
        <div>
            <a href="index">
                <img src="img/logo.png" alt="job Board logo">
            </a>
        </div>        
    </nav>
    <div class="container"> 
        <form id="contact" action="entreprise" method="POST">
            <h3>Give us your informations</h3>
            <fieldset>
                <label for="company_name">Company name</label>
                <input name="company_name" id="company_name" placeholder="Your company" type="text" tabindex="1" required autofocus>
            </fieldset>
            <fieldset>
                <label for="company_email">Company e-mail</label>
                <input name="company_email" id="company_email" placeholder="Your company e-mail" type="email" tabindex="2" required>
            </fieldset>
            <fieldset>
                <label for="company_address">Company address</label>
                <input name="company_address" id="company_address" placeholder="Your company address" type="text" tabindex="3" required>
            </fieldset>
            <fieldset>
                <label for="company_website">Website</label>
                <input name="company_website" id="company_website" placeholder="Your Web Site (optional)" type="url" tabindex="4">
            </fieldset>
            <fieldset>
                <label for="company_project">Tell us more about your project</label>
                <textarea name="project_infos" id="project_infos" placeholder="Type your message here...." tabindex="5" required></textarea>
            </fieldset>
            <fieldset>
            	<label for="company_project">Select the wanted profile(s)</label><br>
            	<input type="checkbox" name="profiles" value="Data Scientist"> Data Scientist &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            	<input type="checkbox" name="profiles" value="Software Developer">Software Developer<br>
            	<input type="checkbox" name="profiles" value="Information Security Analyst">Information Security Analyst &emsp;&emsp;
				<input type="checkbox" name="profiles" value="Computer Systems Analyst">Computer Systems Analyst<br>
				<input type="checkbox" name="profiles" value="Web Developer">Web Developer&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<input type="checkbox" name="profiles" value="Information Technology Manager">Information Technology Manager
			</fieldset>
			<fieldset class="radio_options">
				<label for="company_project">Select the type of project</label><br>
				<input type="radio" name="typeofjob" onclick="MyFunction()" id="myCheck2" value="Job"> Job&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<input type="radio" name="typeofjob" id="myCheck" onclick="MyFunction()" value="Internship"> Internship
				<fieldset id="text" style="display:none">
					<label for="Period">For how much time approximately ?</label>
					<input name="inter_period" id="inter_period" placeholder="Period of internship" type="text" tabindex="6" >
				</fieldset>
			</fieldset>
			<fieldset>
                <label for="salary">Salary/renumeration(per month)</label>
                <input name="salary" id="salary" placeholder="Salary (optional)" type="text" tabindex="7" >
            </fieldset>
            <div>
                <span style="color:red">
                     <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
				</span>
            </div>
            <div>
                 <span style="color:red">
                     <%=(request.getAttribute("errRegistration") == null) ? "" : request.getAttribute("errRegistration")%>
                 </span>
            </div>
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
            </fieldset>
        </form>
    </div>
</body>
</html>