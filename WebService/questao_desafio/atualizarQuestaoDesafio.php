<?php

$idQuestao_Desafio = $_REQUEST["idQuestao_Desafio"];
$Corpo_Questao = urldecode($_REQUEST["Corpo_Questao"]);
$Gabarito = urldecode($_REQUEST["Gabarito"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "UPDATE  Questao_Desafio SET Corpo_Questao = ? , Gabarito = ? WHERE idQuestao_Desafio = ? ");
mysqli_stmt_bind_param($stmt,'ssi',$Corpo_Questao, $Gabarito, $idQuestao_Desafio);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}

mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);
?>