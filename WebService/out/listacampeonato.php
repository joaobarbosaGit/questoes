<?php
$username = "joaocs_DA";
$password = "P:4DHB~A";
$server = "localhost";
$port = "3306";
$databasename = "joaocs_casports";
$tablename = "Campeonato";
$connection = mysqli_connect(
    $server,
    $username,
    $password,
    $databasename,
    $port
);
if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}

$stmt = mysqli_prepare($connection, "SELECT * FROM $tablename ");
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idCampeonato,$rows->Nome_Campeonato);
$result = array();
while(mysqli_stmt_fetch($stmt)){
	$string = utf8_encode($rows->Nome_Campeonato);

    $output = array('idCampeonato' => $rows->idCampeonato, 'Nome_Campeonato' => $string);
    array_push($result,$output);
}

mysqli_close($connection);
echo json_encode($result,JSON_UNESCAPED_UNICODE);


?>