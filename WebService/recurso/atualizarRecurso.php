<?php

$idRecurso = $_REQUEST["idRecurso"];
$Objeto = urldecode($_REQUEST["Objeto"]);
$Causa = urldecode($_REQUEST["Causa"]);
$Deferimento = urldecode($_REQUEST["Deferimento"]);
$Situacao = urldecode($_REQUEST["Situacao"]);
$Rodada_idRodada = urldecode($_REQUEST["Rodada_idRodada"]);
$Equipe_idEquipe = urldecode($_REQUEST["Equipe_idEquipe"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "UPDATE  Recurso SET Objeto = ? , Causa = ?, Deferimento = ?, Situacao = ?, Rodada_idRodada = ?, Equipe_idEquipe = ? WHERE idRecurso = ? ");
mysqli_stmt_bind_param($stmt,'ssssiii', $Objeto, $Causa, $Deferimento, $Situacao, $Rodada_idRodada, $Equipe_idEquipe, $idRecurso);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}

mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);
?>