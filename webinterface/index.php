<?php
session_start();
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
				    	<li class="active"><a href="index.php">Start</a></li>
				    	<?php
				    		if (isset($_SESSION['loggedIn'])) {
				    			echo "<li><a href='account.php'>Account</a></li>";
				    			echo "<li><a href='logout.php'>Logout</a></li>";
				    		}
				    		else {
				    			echo "<li><a href='login.php'>Login</a></li>";
				    			echo "<li><a href='register.php'>Registrieren</a></li>";
				    		}
				    	
				    	?>
			    	</ul>
		    	</div>
			</div>
		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://code.jquery.com/jquery.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>