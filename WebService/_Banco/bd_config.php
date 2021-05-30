<?php

define('HOST', 'localhost');
define('USER', 'adabox28_admin');
define('PASS', 'net261015');
define('DB', 'adabox28_bd_questoes');

$charset = 'utf8';

$conn = mysqli_connect(HOST, USER, PASS, DB) 
        or die('Falhou...');

?>