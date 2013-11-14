<?php
	$hostname = $_SERVER['HTTP_HOST'];
    $path = dirname($_SERVER['PHP_SELF']);
	
	session_start();
	
	if (!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] != "on") {
		header('HTTP/1.1 301 Moved Permanently');
    	header("Location: https://" . $hostname . $path . "/account.php");
		exit();
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
				    	<?php
				    		if (isset($_SESSION['loggedIn'])) {
				    			echo "<li class='active'><a href='account.php'>Account</a></li>";
				    			echo "<li><a href='logout.php'>Logout</a></li>";
				    		}
				    		else {
				    			echo "<li><a href='login.php'>Login</a></li>";
				    		}
				    	
				    	?>
			    	</ul>
		    	</div>
			</div>
		</div>
  		<div class="container">
	  		<div class="jumbotron">
		  		<h1>Accounteinstellungen</h2>
		  		<p>Passwort und Co. ändern</p>
	  		</div>
	  		
	  		<div class="row">
	  		<div class="col-md-4">
		  		<h4>E-Mail</h4>
		  		<p>Aktuelle E-Mail: <?php echo($_SESSION['email']) ?></p>
		  		<form action="userEdit.php" method="post">
			  		<input type="text" class="form-control singleBox" placeholder="Neue E-Mail" name="email" required>
			  		<button class="btn btn-lg btn-primary btn-block" type="submit">E-Mail ändern</button>
		  		</form>
	  		</div>
	  		<div class="col-md-4">
		  		<h4>Passwort</h4>
		  		<p>Aktuelles Passwort: *******</p>
		  		<form action="userEdit.php" method="post">
			  		<input type="text" class="form-control singleBox" placeholder="Neues Passwort" name="password" required>
			  		<button class="btn btn-lg btn-primary btn-block" type="submit">Passwort ändern</button>
		  		</form>
	  		</div>
	  		<div class="col-md-4">
		  		<h4>Benutzername</h4>
		  		<p>Aktueller Benutzername: <?php echo($_SESSION['username']) ?></p>
		  		<form action="userEdit.php" method="post">
			  		<input type="text" class="form-control singleBox" placeholder="Neuer Benutzername" name="username" required>
			  		<button class="btn btn-lg btn-primary btn-block" type="submit">Benutzername ändern</button>
		  		</form>
	  		</div>
  		</div>
  		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://code.jquery.com/jquery.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>