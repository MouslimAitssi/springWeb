<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Job Board - Register</title>
    
    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/login-style.css" type="text/css">

    <style>
        nav {
            max-width: 1400px;
            margin: 0 auto;
            margin-top: 20px;
        }
        a img {
            height: 100px;
            width: auto;
        }
    </style>
</head>
<body>
    <nav>
        <div>
            <a href="index">
                <img src="img/logo.png" alt="job Board logo">
            </a>
        </div>        
    </nav>
    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form method="POST" class="register-form" id="register-form" action="register">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" placeholder="Your Username"  />
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email" />
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass" id="pass" placeholder="Password (minimum 4 characters)" />
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password" />
                            </div>
                            <div>
                                <span style="color:red">
                                    <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                                </span>
                            </div>
                            <div>
                                <span style="color:red">
                                    <%=(request.getAttribute("errMessageLengthPasswd") == null) ? "" : request.getAttribute("errMessageLengthPasswd")%>
                                </span>
                            </div>
                            <div>
                                <span style="color:red">
                                    <%=(request.getAttribute("errMessageDifferentPasswd") == null) ? "" : request.getAttribute("errMessageDifferentPasswd")%>
                                </span>
                            </div>
                            <div>
                                <span style="color:red">
                                    <%=(request.getAttribute("errRegistration") == null) ? "" : request.getAttribute("errRegistration")%>
                                </span>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="img/signup-image.jpg" alt="sing up image"></figure>
                        <a href="login" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>
</html>