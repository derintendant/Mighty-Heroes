<?php
	$hostname = $_SERVER['HTTP_HOST'];
    $path = dirname($_SERVER['PHP_SELF']);
	
	# Weiterleitung auf HTTPS
	if (!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] != "on") {
		header('HTTP/1.1 301 Moved Permanently');
    	header("Location: https://" . $hostname . $path . "/login.php");
		exit();
	}
	
	# Login
	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		include 'settings.php';
		include 'password.php';

		# Muss auf jeder Seite stehen, wenn $_SESSION benutzt werden soll
		session_start();

		# Eingegebene Daten säubern
		$enteredUsername = mysql_real_escape_string($_POST['username']);
		$enteredPassword = mysql_real_escape_string($_POST['password']);

		# Verbindung mit Datenbank (Konstanten definiert in settings.php)
      	mysql_connect(DB_HOST, DB_USER, DB_PASSWORD) or die('Error connecting to MySQL Server');
      	mysql_select_db(DB_NAME);

      	# SQL-Query, Abrufen des Users aus der DB
      	$login_query = sprintf("SELECT * FROM `users` WHERE `username` = '%s'",
      							$enteredUsername);

      	$result = mysql_query($login_query);
      	
      	if (mysql_num_rows($result) != 0) {
      		$row = mysql_fetch_assoc($result);
      		
      		$dbUsername = $row['username'];
      		$dbPasswordHash = $row['password'];

      		if ($enteredUsername == $row['username'] && password_verify($enteredPassword, $row['password'])) {
      			
      			# Füllen der _SESSION-Variablen
      			$_SESSION['loggedIn'] = true;
      			$_SESSION['username'] = $row['username'];
      			$_SESSION['email'] 	  = $row['email'];
      			$_SESSION['userid'] 	  = $row['id'];
      			
      			if ($_SERVER['SERVER_PROTOCOL'] == 'HTTP/1.1') {
	        		if (php_sapi_name() == 'cgi') {
	        			header('Status: 303 See Other');
	        		}
	        		else {
	        			header('HTTP/1.1 303 See Other');
	        		}
	        	}
	        	header('Location: http://'.$hostname.($path == '/' ? '' : $path).'/index.php');
       			exit;
	        }

        }
	}

?>
<!DOCTYPE html>
<html>
	<head>
    	<title>Mighty Heroes</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
	    <div class="navbar navbar-default">
	    	<div class="container">
		    	<div class="navbar-header">
			    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			    		<span class="sr-only">Toggle Nav</span>
			    	</button>
			    	<a href="index.php" class="navbar-brand">Mighty Heroes</a>
		    	</div>
		    	<div class="navbar-collapse collapse">
			    	<ul class="nav navbar-nav">
				    	<li><a href="index.php">Start</a></li>
				    	<li class="active"><a href='login.php'>Login</a></li>
				    	<li><a href='register.php'>Registrieren</a></li>
			    	</ul>
		    	</div>
			</div>
		</div>
	    <div class="container">
			<form action="login.php" class="form-signin" method="post">
				<h2>Login</h2>
				<input type="text" class="form-control topfield" placeholder="Benutzername" name="username" required autofocus>
				<input type="password" class="form-control bottomfield" placeholder="Passwort" name="password" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Einloggen</button>
			</form>
		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://code.jquery.com/jquery.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>