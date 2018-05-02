<%@ page language="java" contentType="text/html; charset=utf-8"
	 pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Employee Detail</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700" rel="stylesheet">
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="css/bootstrap-material-design.min.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
    <link href="css/jquery.mCustomScrollbar.css" type="text/css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet" />

</head>
  
    <style>
        #content-1 {   
   overflow: auto;
    position: relative;
    padding: 9px;
    background: #ffffff;
    margin: 15px;
    width: 100%;
    max-width: 100%;
    height: 294px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}




    </style>


<body style="background:url(img/inner-bg.png); background-size:cover;">

 <div id="wrapper">
        <div id="mask">


  <div id="payment_succ" class="item">
                <div class="content">
                    <!--<a href="#item1" class="panel">back</a>-->
                    <div class="mainone innermaintop">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="logomain">
                                        <div class="cartoon innercartoon">
                                            <img src="img/cartooon-bg-inner.png" alt="" />
                                            <img src="img/bubble.png" class="bubble" alt="" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="logomain midinnerlogomain">
                                        <div class="logo midinnerlogo">
                                            <a href="#">
                                                <img src="img/logo-inner.png" alt="" /></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <a href="index" class="panel pull-right homebtn">
                                        <img src="img/new/home.png" alt="" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="fourservices">
                        <div class="innermid">
                            <div class="container main_row">
                                <div class="row">
                                 <div id="content-1" class="content mCustomScrollbar">
                                     <table id="example" class="display" >
                                            <thead>
                                                <tr>
                                                    <th>S.No.</th>
                                                    <th>URL</th>
                                                </tr>
                                            </thead>
                                           <tbody>
								
												<tr>
													<td>1</td>
													<td><a href="${url}">Document1</a></td>
												</tr>
							              </tbody>
                                        </table>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="button_div">
                                <a href="districtAdministration" class="panel">
                                    <img src="img/new/back.png" alt="" /></a>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script	type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript"  src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
     <script type="text/javascript"  src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.print.min.js"></script>
    
     

 
    <script type="text/javascript">
    $(document).ready(function() {
        $('#example').DataTable( {
        } );
    } );
         
    </script>
    <script type="text/javascript"  src="js/bootstrap.min.js"></script>
   
    <script type="text/javascript"  src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
   
  

</body>

</html>
