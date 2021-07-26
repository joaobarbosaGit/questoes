<?php

$idUsuario_Aluno = urldecode($_REQUEST["idUsuario_Aluno"]);
$Usuario = urldecode($_REQUEST["Usuario"]);
$Senha = urldecode($_REQUEST["Senha"]);
$Email = urldecode($_REQUEST["Email"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "UPDATE  Usuario_Aluno SET Usuario = ? , Senha = ? , Email = ? WHERE idUsuario_Aluno = ? ");
mysqli_stmt_bind_param($stmt,'sssi',$Usuario, $Senha, $Email, $idUsuario_Aluno);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}

mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);
?>