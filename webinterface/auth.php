<?php
     session_start();

     $hostname = $_SERVER['HTTP_HOST'];
     $path = dirname($_SERVER['PHP_SELF']);

     if (!isset($_SESSION['loggedIn']) || !$_SESSION['loggedIn']) {
      header('Location: https://'.$hostname.($path == '/' ? '' : $path).'/login.php');
      exit;
      }
?>