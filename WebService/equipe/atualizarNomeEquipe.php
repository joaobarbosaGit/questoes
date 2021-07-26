<?php

$idEquipe = $_REQUEST["idEquipe"];
$Nome_Equipe = urldecode($_REQUEST["Nome_Equipe"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "UPDATE  Equipe SET  Nome_Equipe = ? WHERE idEquipe = ? ");

mysqli_stmt_bind_param($stmt,'si',$Nome_Equipe, $idEquipe);

mysqli_stmt_execute($stmt);

mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);
?>