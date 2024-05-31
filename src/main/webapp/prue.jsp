<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Menú de Inicio del Banco</title>
	<link rel="stylesheet" href="menu.css">
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<button class="toggle-btn">☰</button>
			<ul class="sidebar-nav">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Elements</a></li>
				<li><a href="#">Widgets</a></li>
				<li><a href="#">Forms</a></li>
				<li><a href="#">Tables</a></li>
				<li><a href="#">Charts</a></li>
				<li><a href="#">Pages</a></li>
			</ul>
		</div>
		<div class="main-content">
			<div class="top-bar">
				<input type="search" placeholder="Search">
				<button class="search-btn">Search</button>
				<button class="notif-btn">Notificaciones</button>
				<button class="user-btn">Jhon Doe (Admin)</button>
			</div>
			<div class="metrics">
				<div class="metric">
					<h2>Today Sale</h2>
					<p>$1234</p>
				</div>
				<div class="metric">
					<h2>Today Revenue</h2>
					<p>$1234</p>
				</div>
				<div class="metric">
					<h2>Total Sale</h2>
					<p>$1234</p>
				</div>
				<div class="metric">
					<h2>Total Revenue</h2>
					<p>$1234</p>
				</div>
			</div>
			<div class="chart">
				<!-- Aquí va el gráfico -->
			</div>
		</div>
	</div>
</body>
</html>