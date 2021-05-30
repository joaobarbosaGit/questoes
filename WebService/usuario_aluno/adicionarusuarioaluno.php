<?php

$Usuario = urldecode($_REQUEST["Usuario"]);
$Senha = urldecode($_REQUEST["Senha"]);
$Email = urldecode($_REQUEST["Email"]);
$Equipe_idEquipe = urldecode($_REQUEST["Equipe_idEquipe"]);
$Rodada_idRodada = urldecode($_REQUEST["Rodada_idRodada"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "INSERT INTO Usuario_Aluno (Usuario, Senha, Email, Equipe_idEquipe, Rodada_idRodada) VALUES (?,?,?,?,?)");

mysqli_stmt_bind_param($stmt,'sssii',$Usuario,$Senha,$Email,$Equipe_idEquipe,$Rodada_idRodada);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);


?>