<?php

$idEquipe = $_REQUEST["idEquipe"];
$Pontuacao_Questoes = urldecode($_REQUEST["Pontuacao_Questoes"]);
$Pontuacao_Respostas = urldecode($_REQUEST["Pontuacao_Respostas"]);
$Pontuacao_Desafios = urldecode($_REQUEST["Pontuacao_Desafios"]);


require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "UPDATE  Equipe SET  Pontuacao_Questoes = ?, Pontuacao_Respostas = ?, Pontuacao_Desafios = ? WHERE idEquipe = ? ");

mysqli_stmt_bind_param($stmt,'iiii',$Pontuacao_Questoes, $Pontuacao_Respostas, $Pontuacao_Desafios, $idEquipe);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}

mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);
?>