<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Job Board - Applying</title>

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">


    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->

    
</head>

<body>
    <!-- header-start -->
    <%@ include file="header.jsp" %>
    <!-- header-end -->

    <!-- bradcam_area  -->
    <div class="bradcam_area bradcam_bg_1">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text">
                        <h3><%=request.getAttribute("company_nom")%></h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->

    <div class="job_details_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="job_details_header">
                        <div class="single_jobs white-bg d-flex justify-content-between">
                            <div class="jobs_left d-flex align-items-center">
                                <div class="thumb">
                                    <img src="img/svg_icon/3.svg" alt="">
                                </div>
                                <div class="jobs_conetent">
                                    <h4><a href="#"><%=request.getAttribute("company_nom")%></a></h4>
                                    <div class="links_locat d-flex align-items-center">
                                        <div class="location">
                                            <p> <i class="fa fa-map-marker"></i><%=request.getAttribute("company_address")%></p>
                                        </div>
                                        <div class="location">
                                            <p> <i class="fa fa-clock-o"></i><%=request.getAttribute("company_period")%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="jobs_right">
                                <div class="apply_now">
                                    <a class="heart_mark" href="#"> <i class="ti-heart"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="descript_wrap white-bg">
                        <div class="single_wrap">
                            <h4>Job description</h4>
                            <p><%=request.getAttribute("company_infos")%></p>
                        </div>
                        <div class="single_wrap">
                            <h4>Profiles</h4>
                            <ul>
                                <li><%=request.getAttribute("company_profiles")%></li>
                            </ul>
                        </div>
                    </div>
                    <div class="apply_job_form white-bg">
                        <h4>Apply for the job</h4>
                        <form action="#" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input_field">
                                        <input type="text" id="NameParticipant" name="NameParticipant" placeholder="Your full name" required>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input_field">
                                        <input type="text" id="EmailParticipant" name="EmailParticipant" placeholder="Email" required>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="input_field">
                                        <input type="text" id="FolioParticipant" name="FolioParticipant" placeholder="Website/Portfolio link (optionnal)">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                          <button type="button" id="inputGroupFileAddon03"><i class="fa fa-cloud-upload" aria-hidden="true"></i>
                                          </button>
                                        </div>
                                        <div class="custom-file">
                                          <input type="file" class="custom-file-input" id="inputGroupFile03" aria-describedby="inputGroupFileAddon03">
                                          <label class="custom-file-label" for="inputGroupFile03">Upload CV</label>
                                        </div>
                                      </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="input_field">
                                        <textarea name="#" id="" cols="30" rows="10" placeholder="Coverletter"></textarea>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="submit_btn">
                                        <% 
                                            String INFO = " "+request.getParameter("NameParticipant") + "\n" + request.getParameter("EmailParticipant") + "\n";
                                            String email_of_company = (String) request.getAttribute("company_email");
                                            String URL_HREF = "mailto:" + email_of_company + "?subject=subject&message=" + INFO;
                                        %>
                                        <button class="boxed-btn3 w-100" type="submit" onClick="document.location.href=getInfoSubmission();">Apply Now</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="job_sumary">
                        <div class="summery_header">
                            <h3>Job Summary</h3>
                        </div>
                        <div class="job_content">
                            <ul>
                                <li>Published on: <span>07 Feb, 2019</span></li>
                                <li>Salary: <span><%=request.getAttribute("company_salary")%></span></li>
                                <li>Location: <span><%=request.getAttribute("company_address")%></span></li>
                                <li>Duration: <span><%=request.getAttribute("company_period")%></span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- footer start -->
    <footer class="footer">
        <div class="copy-right_text wow fadeInUp" data-wow-duration="1.4s" data-wow-delay=".3s">
            <div class="container">
                <div class="footer_border"></div>
                <div class="row">
                    <div class="col-xl-12">
                        <p class="copy_right text-center">
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/ footer end  -->

    <script type="text/javascript">
        function getInfoSubmission() {
            var my_msg = 'Your Submission will be send to ' + '<%=request.getAttribute("company_nom")%>';
            var url = 'apply?value=' + '<%=request.getAttribute("company_nom")%>' ;
            if (confirm(my_msg)) {
                return url;
            }
            else {
                return "jobs";
            } 
        }

    </script>
</body>

</html>