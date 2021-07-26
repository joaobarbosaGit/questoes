<?php

$idEquipe = $_REQUEST["idEquipe"];
$isQuestionario = urldecode($_REQUEST["isQuestionario"]);
$isResposta = urldecode($_REQUEST["isResposta"]);
$isDesafio = urldecode($_REQUEST["isDesafio"]);


require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "UPDATE  Equipe SET  isQuestionario = ?, isResposta = ?, isDesafio = ? WHERE idEquipe = ? ");

mysqli_stmt_bind_param($stmt,'iiii',$isQuestionario, $isResposta, $isDesafio, $idEquipe);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}

mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);
?>