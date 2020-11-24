<!-- IIS-projekt 2020 - Login stránka				-->
<!-- Vytvoril: Tomáš Lisický, xlisic01 VUTBR FIT	-->
<!-- Login/Register stránka na ktorú sa odkazuje... -->
<!-- ...hlavná web stránka diskusného fóra.			-->

<!DOCTYPE html>
<html lang="sk">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="src/css/iis.css">
		<title>IIS Fórum Login / Registrácia</title>
	</head>
	
	<body>
		<div class="container-fluid"> <!-- veľký kontajner pre bootstrap css + výplň proti "pretekaniu" stránky -->
			<div class="row iis-bg-brown text-secondary">
				<div class="col"></div>
				<div class="col.display-1">
					<div class="container"> <!-- container navyše, aby bol nadpis správne vidieť pre mobily -->
						<h1>IIS Fórum - Login / Registrácia</h1>
					</div>
				</div>
				<div class="col"></div>
			</div>
			
			<div class="iis-login-blank20"></div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-xl-3">
					<div class="container iis-login-screen iis-bg-lbrown">
						<br>
						<div class="row">
							<div class="col"></div>
							<div class="col.display-4">
								<h4>Vitajte na IIS diskusnom fóre!</h4>
							</div>
							<div class="col"></div>
						</div>
						
						<div class="iis-login-blank15"></div>
						
						<form action="/iis-login.php">
							<div class="form-group">
								<label for="user">Uživateľské meno:</label>
								<input type="text" class="form-control btn-outline-warning" id="user" name="username">
							</div>
							<br>
							<div class="form-group">
								<label for="passw">Heslo:</label>
								<input type="password" class="form-control btn-outline-warning" id="passw" name="password">
							</div>
							<button type="submit" class="btn iis-login-btn iis-btn-color btn-outline-warning">Prihlásiť</button>
						</form>
						
						<div class="iis-login-blank10"></div>
						
						<div class="row">
							<div class="col"></div>
							<div class="col.display-4">
								<a href="">Zabudli ste heslo?</a>
							</div>
							<div class="col"></div>
						</div>
					<!-- End of Login Screen -->
					</div>
				<!-- End of offset placeholder -->
				</div>
				
				<div class="col-sm-0">
					<br> <!-- medzera medzi panelmi pre mobilovú stránku -->
				</div>
				
				<div class="col-xl-3">
					<div class="container iis-login-screen iis-bg-lbrown">
						<br>
						<div class="row">
							<div class="col"></div>
							<div class="col.display-4">
								<h4>Registrácia</h4>
							</div>
							<div class="col"></div>
						</div>
						
						<div class="iis-login-blank15"></div>
						
						<!-- Prevzaté zo stránky W3Schools.com, begin -->
						<form action="/iis-register.php">
							<div class="form-group">
								<label for="r_user">Uživateľské meno:</label>
								<input type="text" class="form-control btn-outline-warning" id="r_user" name="username">
							</div>
							<br>
							<div class="form-group">
								<label for="r_passw1">Heslo:</label>
								<input type="password" class="form-control btn-outline-warning" id="r_passw1" name="password">
							</div>
							<div class="form-group">
								<label for="r_passw2">Heslo znova:</label>
								<input type="password" class="form-control btn-outline-warning" id="r_passw2" name="password">
							</div>
							<button type="submit" class="btn iis-reg-btn iis-btn-color btn-outline-warning">Registrovať</button>
						</form>
						<!-- End Copy -->
					<!-- End of Login Screen -->
					</div>
				<!-- End of offset placeholder -->
				</div>
				<div class="col-md-3"></div>
			<!-- End of offset -->
			</div>
		</div>
	</body>
</html>