<?php

$Rodada_idRodada = urldecode($_REQUEST["Rodada_idRodada"]);

require_once('../_Banco/bd_config.php');

if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}

$stmt = mysqli_prepare($conn, "SELECT Equipe_idEquipe FROM Usuario_Aluno WHERE Rodada_idRodada = ? ");
mysqli_stmt_bind_param($stmt,'i',$Rodada_idRodada);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->Equipe_idEquipe);
$result = array();
while(mysqli_stmt_fetch($stmt)){

    $output = array('Equipe_idEquipe' => $rows->Equipe_idEquipe);
    array_push($result,$output);

}
mysqli_close($conn);
echo json_encode($result,JSON_UNESCAPED_UNICODE);

?>