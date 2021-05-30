<?php

$email = urldecode($_REQUEST["email"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Usuario_Professor WHERE Email = ? ");
mysqli_stmt_bind_param($stmt,'s',$email);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idUsuario_Professor,$rows->Nome_Professor,$rows->Email,$rows->Senha);
while(mysqli_stmt_fetch($stmt)){

$string_Nome_Professor = utf8_encode($rows->Nome_Professor);
$string_Email = utf8_encode($rows->Email);
$string_Senha = utf8_encode($rows->Senha);


    $output = array('idUsuario_Professor' => $rows->idUsuario_Professor, 'Nome_Professor' => $string_Nome_Professor, 'Email' => $string_Email, 'Senha' => $string_Senha);

}
mysqli_close($conn);
echo json_encode($output,JSON_UNESCAPED_UNICODE);

?>