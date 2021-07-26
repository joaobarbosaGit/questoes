<?php
$username = "joaocs_DA";
$password = "P:4DHB~A";
$server = "localhost";
$port = "3306";
$databasename = "joaocs_casports";
$tablename = "Pais";
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

$stmt = mysqli_prepare($connection, "SELECT * FROM $tablename ORDER BY Nome_Pais");
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idPais,$rows->Nome_Pais);
$result = array();
while(mysqli_stmt_fetch($stmt)){
    $string = utf8_encode($rows->Nome_Pais);
    $output = array('idPais' => $rows->idPais, 'Nome_Pais' =>$string);
    array_push($result,$output);
}

mysqli_close($connection);
echo json_encode($result,JSON_UNESCAPED_UNICODE);



?>