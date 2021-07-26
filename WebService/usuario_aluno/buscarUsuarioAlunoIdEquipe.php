<?php

$Equipe_idEquipe = urldecode($_REQUEST["Equipe_idEquipe"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Usuario_Aluno WHERE Equipe_idEquipe = ? ");
mysqli_stmt_bind_param($stmt,'i',$Equipe_idEquipe);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idUsuario_Aluno,$rows->Usuario,$rows->Senha,$rows->Email, $rows->Equipe_idEquipe, $rows->Rodada_idRodada);
while(mysqli_stmt_fetch($stmt)){

    $output = array('idUsuario_Aluno' => $rows->idUsuario_Aluno, 'Usuario' => $rows->Usuario, 'Senha' => $rows->Senha,'Email' => $rows->Email, 'Equipe_idEquipe' => $rows->Equipe_idEquipe, 'Rodada_idRodada' => $rows->Rodada_idRodada);

}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);

?>