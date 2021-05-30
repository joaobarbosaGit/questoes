<?php

$email = urldecode($_REQUEST["email"]);

require_once('../_Banco/bd_config.php');

if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}

$stmt = mysqli_prepare($conn, "SELECT * FROM Usuario_Aluno WHERE Email = ? ");
mysqli_stmt_bind_param($stmt,'s',$email);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idUsuario_Aluno,$rows->Usuario,$rows->Senha,$rows->Email, $rows->Equipe_idEquipe, $rows->Rodada_idRodada);
while(mysqli_stmt_fetch($stmt)){

$string_Usuario = utf8_encode($rows->Usuario);
$string_Senha = utf8_encode($rows->Senha);
$string_Email = utf8_encode($rows->Email);

    $output = array('idUsuario_Aluno' => $rows->idUsuario_Aluno, 'Usuario' => $string_Usuario, 'Senha' => $string_Senha,'Email' => $string_Email, 'Equipe_idEquipe' => $rows->Equipe_idEquipe, 'Rodada_idRodada' => $rows->Rodada_idRodada);

}
mysqli_close($conn);
echo json_encode($output,JSON_UNESCAPED_UNICODE);

?>