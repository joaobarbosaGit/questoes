<?php

$idRecurso = urldecode($_REQUEST["idRecurso"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Recurso WHERE idRecurso = ? ");
mysqli_stmt_bind_param($stmt,'i',$idRecurso);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, 
    $rows->idRecurso, 
    $rows->Objeto, 
    $rows->Causa, 
    $rows->Deferimento, 
    $rows->Situacao, 
    $rows->Rodada_idRodada, 
    $rows->Equipe_idEquipe);
while(mysqli_stmt_fetch($stmt)){

    $output = array(
        'idRecurso' => $rows->idRecurso, 
        'Objeto' => $rows->Objeto, 
        'Causa' => $rows->Causa, 
        'Deferimento' => $rows->Deferimento, 
        'Situacao' => $rows->Situacao, 
        'Rodada_idRodada' => $rows->Rodada_idRodada, 
        'Equipe_idEquipe' => $rows->Equipe_idEquipe);

}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);

?>