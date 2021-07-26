<?php

$Usuario_Professor_idUsuario_Professor = urldecode($_REQUEST["Usuario_Professor_idUsuario_Professor"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT idRodada FROM Rodada WHERE Usuario_Professor_idUsuario_Professor = ? ");
mysqli_stmt_bind_param($stmt,'i',$Usuario_Professor_idUsuario_Professor);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idRodada);

$result = array();

while(mysqli_stmt_fetch($stmt)){

	$saida = array('idRodada' => $rows->idRodada);
	array_push($result,$saida);
}

if(empty($result)){

$output = array('Resultado' => false);

}else{	

$output = array('Resultado' => true);

}   

echo json_encode($output);

?>