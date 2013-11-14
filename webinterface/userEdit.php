<?php
	session_start();

	include 'settings.php';
	include 'password.php';

	# Verbindung mit Datenbank (Konstanten definiert in settings.php)
    mysql_connect(DB_HOST, DB_USER, DB_PASSWORD) or die('Error connecting to MySQL Server');
    mysql_select_db(DB_NAME);

	if (isset($_POST['password'])) {
		$newPassword = mysql_real_escape_string($_POST['password']);
		$newPasswordHashed = password_hash($newPassword, PASSWORD_DEFAULT);
		$newPasswordHashed = mysql_real_escape_string($newPasswordHashed);

		$query = sprintf("UPDATE `users` SET `password` = '%s' WHERE `id` = '%s'",
					$newPasswordHashed,
					$_SESSION['userid']);

		mysql_query($query);
		updateSessionVars();
	}

	if (isset($_POST['email'])) {
		$newEmail = mysql_real_escape_string($_POST['email']);

		$query = sprintf("UPDATE `users` SET `email` = '%s' WHERE `id` = '%s'",
					$newEmail,
					$_SESSION['userid']);

		mysql_query($query);
		updateSessionVars();
	}

	if (isset($_POST['username'])) {
		$newUsername = mysql_real_escape_string($_POST['username']);

		$query = sprintf("UPDATE `users` SET `username` = '%s' WHERE `id` = '%s'",
					$newUsername,
					$_SESSION['userid']);

		mysql_query($query);
		updateSessionVars();
	}
	
function updateSessionVars() {
	$hostname = $_SERVER['HTTP_HOST'];
    $path = dirname($_SERVER['PHP_SELF']);
    
	$update_query = sprintf("SELECT * FROM `users` WHERE `id` = '%s'",
      							$_SESSION['userid']);

    $update_result = mysql_query($update_query);
    $row = mysql_fetch_assoc($update_result);
	
	$_SESSION['email'] 	  = $row['email'];
	$_SESSION['username'] = $row['username'];
	
	error_log('New Email:' . $row['email']);
	error_log($_SESSION['userid']);
	
	echo($_SESSION['email']);
	echo($row['email']);
	
	if ($_SERVER['SERVER_PROTOCOL'] == 'HTTP/1.1') {
	        if (php_sapi_name() == 'cgi') {
	        	header('Status: 303 See Other');
	        }
	        else {
	        	header('HTTP/1.1 303 See Other');
	        }
	    }
	    header('Location: http://'.$hostname.($path == '/' ? '' : $path).'/account.php');
}

?>