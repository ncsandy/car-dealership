<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.79.0">
    <title>Dealership Portal</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">
	
    

    <!-- Bootstrap core CSS -->

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      .barcolor{
	color: #c6ebc9!important;
	}
	p{
	text-alright:center;
	}
    </style>

    
    <!-- Custom styles for this template -->
    
  </head>
  <body class="text-center">
    
 <header class="navbar navbar-dark sticky-top bg-success flex-md-nowrap p-0 shadow barcolor"> 
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 " href="#">Nick's Tropical Auto Center</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="index.jsp">Sign out</a>
    </li>
  </ul>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              <span data-feather="home"></span>
              Dashboard
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Dealer Dashboard</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group me-2">
          </div>
        </div>
      </div>

      <h2 class="text-success">Purchase History</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Customer Name</th>
              <th>Purchase date</th>
              <th>Car </th>
              <th>Bought Price</th>
              <th>Photo</th>
              
            </tr>
          </thead>
          <tbody>
            <c:forEach var="customer" items="${inventory.customerList}"> 
            <tr>
              <td>${customer.firstName}  ${customer.lastName }</td>
              <td>${customer.date}</td>
              <td>${customer.car.make} ${customer.car.model} ${customer.car.year}</td>
           	  <td>$${customer.car.price} </td>
           	  <td><img class=shrink src=${customer.car.image} width="170" height="100"/></td>	
           	 </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>
<div class="card text-center">
  <div class="card-header">
    <h3 class="text-success">Add Vehicle</h3>
  </div>
  <div class="card-body">
    <h5 class="card-title text-danger">Input all information</h5>
    
    <form class="container was-validated" action="AddCarServlet" method="post">
  <div class="mb-3">
    <label for="validationTextarea" class="form-label">Make</label>
   <input type="text" class="form-control" name="make" placeholder="Make" required="">
    <div class="invalid-feedback">
      Please enter vehicle make
    </div>
  </div>
    <div class="mb-3">
    <label for="validationTextarea" class="form-label">Model</label>
   <input type="text" class="form-control" name="model" placeholder="Model" required="">
    <div class="invalid-feedback">
      Please enter vehicle model
    </div>
  </div>
  	    <div class="mb-3">
    <label for="validationTextarea" class="form-label">Year</label>
   <input type="text" class="form-control" name="year" placeholder="Year" required="">
    <div class="invalid-feedback">
      Please enter vehicle year
    </div>
  </div>
       <div class="mb-3">
    <label for="validationTextarea" class="form-label">Date of Purchase</label>
   <input type="date" class="form-control" name="dateOfPurchase" placeholder="Date of Purchase" required="">
    <div class="invalid-feedback">
      Please date of purchase
    </div>
  </div>
     <div class="mb-3">
    <label for="validationTextarea" class="form-label">Mileage</label>
   <input type="text" class="form-control" name="mileage" placeholder="Mileage" required="">
    <div class="invalid-feedback">
      Please enter vehicle mileage
    </div>
  </div>
         <div class="mb-3">
    <label for="validationTextarea" class="form-label">Reisdence</label>
   <input type="text" class="form-control" name="residence" placeholder="Residence" required="">
    <div class="invalid-feedback">
      Please enter residence of vehicle
    </div>
  </div>
        <div class="mb-3">
    <label for="validationTextarea" class="form-label">Image (enter url)</label>
   <input type="text" class="form-control" name="image" placeholder="Image URL" required="">
    <div class="invalid-feedback">
      Please enter image url of vehicle
    </div>
  </div>
     <div class="mb-3">
    <label for="validationTextarea" class="form-label">Description</label>
   <input type="text" class="form-control" name="description" placeholder="Description" required="">
    <div class="invalid-feedback">
      Please enter description of vehicle
    </div>
  </div>

       <div class="mb-3">
    <label for="validationTextarea" class="form-label">Price (Enter numeric value, no $ or commas)</label>
   <input type="text" class="form-control" name="price" placeholder="Price" required="">
    <div class="invalid-feedback">
      Please enter description of vehicle
    </div>
  </div>
  <input type="hidden" name="purchased" value="false" > 
         <div class="mb-3">
    <label for="validationTextarea" class="form-label">VIN</label>
   <input type="text" class="form-control" name="vin" placeholder="Vin" required="">
    <div class="invalid-feedback">
      Please enter vehicle VIN
    </div>
  </div>
 <div class="form-check">
  <input class="form-check-input" type="radio" name="condition" value="false" checked>
  <label class="form-check-label" for="exampleRadios1">
   New
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="condition" value="true">
  <label class="form-check-label" for="exampleRadios2">
    Used
  </label>
</div>
    <br>
    <button type="submit" name="addCar" class="btn btn-success">Add car</button>
  
  </form>
  </div>
  </div>
  <div class="card-footer text-muted">
    Nick's Tropical Auto Center &copy 2020
  </div>


		
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
    
		
      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
  </body>
</html>
