<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/HomepageServlet" />

<%@ page import="com.dealership.Car" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- Local CSS -->
<link rel="stylesheet" href="styles.css" />

<!-- Link to font -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Cinzel:wght@600&display=swap"
	rel="stylesheet">



<title>Nick's Tropical Auto</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Nick's Tropical Autocenter</a> <a
				class="navbar-brand" href="#"> <img src="mango.svg" width="30"
				height="30" alt="" loading="lazy">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">

				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp"> INVENTORY <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="usedcars.jsp">USED
							INVENTORY</a></li>
					<li class="nav-item"><a class="nav-link" href="specials.jsp">SPECIALS</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="dealerlogin.jsp">Dealer Log in</a>
					</li>
				</ul>
				<form class="d-flex" action="SearchCarsServlet" method="post">
					<input class="form-control me-2" type="search" name="searchInput"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</div>
	
	<div class=album py-5bg-light">
	
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
				
				<c:forEach var="car" items="${inventory.carList}">
					
					<c:if
						test="${car.used == false && car.residence < 120 && car.purchased == false}">
						<div class="col">
							<div class="card" style="width: 18rem;">
								
								<img src=${car.image } class="card-img-top" alt="...">
								<div class="card-body">
									<p><span class="mandatory">${car.make}${car.model}</span></p>
									<p class="card-text">${car.description}
								</div>
								
								<div class="d-flex justify-content-center align-items-center">
									<form action="PurchaseServlet" method="POST">
									<input type="hidden" name="vin" value="${car.vin}" > 
									<button type="submit" name="purchase" class="btn btn-success">Purchase</button>
									</form>	
									<div class="dropdown">
										<a class="btn btn-secondary dropdown-toggle" href="#"
											role="button" id="dropdownMenuLink" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"> Details </a>
										<div class="dropdown-menu details-button"
											aria-labelledby="dropdownMenuLink">
											<a class="dropdown-item" href="#">Make: ${car.make}</a> <a
												class="dropdown-item" href="#">Model: ${car.model}</a> <a
												class="dropdown-item" href="#">Year: ${car.year}</a> <a
												class="dropdown-item" href="#">Mileage: ${car.mileage}</a> <a
												class="dropdown-item" href="#">Price: $${car.price}</a> <a
												class="dropdown-item" href="#">Vin: ${car.vin}</a> 
												
										</div>
									</div>
									
								</div>
						
							</div>
								
						</div>
						
					</c:if>
				
				</c:forEach>
				
			</div>
		
		</div>
	
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>


	
</body>
</html>