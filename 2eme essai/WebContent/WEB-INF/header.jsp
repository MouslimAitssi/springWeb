<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<header>
        <div class="header-area">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid ">
                    <div class="header_bottom_border">
                        <div class="row align-items-center">
                            <div class="col-xl-3 col-lg-2">
                                <div class="logo">
                                    <a href="index">
                                        <img src="img/logo.png" alt="" id="logo">
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-7">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a href="#" id="browse_job">Targeted fields</a></li>
                                            <li><a href="contact">Contact</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                                <div class="Appointment">
                                    
                                    <c:if test="${empty sessionScope.username}">

                                        <div class="phone_num d-none d-xl-block">
                                            <a href="login">Log in</a>
                                        </div>
                                        <div class="d-none d-lg-block">
                                            <a class="boxed-btn3" href="register">Register</a>
                                        </div>

                                    </c:if>

                                    <c:if test="${!empty sessionScope.username}">
                                        <%
                                            String getUsername =  (String) request.getSession(false).getAttribute("username");
                                        %>

                                        <div class="col-xl-6 col-lg-7">
                                            <div class="main-menu  d-none d-lg-block">
                                                <nav>
                                                    <ul id="navigation">
                                                        <li><a href="jobs" id="browse_job1">Browse Jobs</a></li>
                                                    </ul>
                                                </nav>
                                            </div>
                                        </div>

                                        <div class="phone_num d-none d-xl-block">
                                            Welcome <%=getUsername%>
                                        </div>
                                        <div class="d-none d-lg-block">
                                            <a class="boxed-btn3" href="logout">Log out</a>
                                        </div>
                                    
                                    </c:if>
                                    
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </header>