<?php

$Equipe_idEquipe = urldecode($_REQUEST["Equipe_idEquipe"]);

require_once('../_Banco/bd_config.php');

if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}

$stmt = mysqli_prepare($conn, "SELECT * FROM Recurso WHERE Equipe_idEquipe = ? ");
mysqli_stmt_bind_param($stmt,'i',$Equipe_idEquipe);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, 
    $rows->idRecurso, 
    $rows->Objeto, 
    $rows->Causa, 
    $rows->Deferimento, 
    $rows->Situacao, 
    $rows->Rodada_idRodada, 
    $rows->Equipe_idEquipe);
$result = array();
while(mysqli_stmt_fetch($stmt)){

    $output = array(
        'idRecurso' => $rows->idRecurso, 
        'Objeto' => $rows->Objeto, 
        'Causa' => $rows->Causa, 
        'Deferimento' => $rows->Deferimento, 
        'Situacao' => $rows->Situacao, 
        'Rodada_idRodada' => $rows->Rodada_idRodada, 
        'Equipe_idEquipe' => $rows->Equipe_idEquipe);
    array_push($result,$output);

}
mysqli_close($conn);
echo json_encode($result,JSON_UNESCAPED_UNICODE);

?>