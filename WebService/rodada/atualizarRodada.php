<?php

$idRodada = $_REQUEST["idRodada"];
$Descricao = urldecode($_REQUEST["Descricao"]);
$Material = urldecode($_REQUEST["Material"]);
$Data_Fase1 = urldecode($_REQUEST["Data_Fase1"]);
$Data_Fase2 = urldecode($_REQUEST["Data_Fase2"]);
$Data_Fase3 = urldecode($_REQUEST["Data_Fase3"]);
$Data_Fase4 = urldecode($_REQUEST["Data_Fase4"]);
$Data_Fase5 = urldecode($_REQUEST["Data_Fase5"]);
$Data_Fase6 = urldecode($_REQUEST["Data_Fase6"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "UPDATE  Rodada SET Descricao = ? , Material = ?, Data_Fase1 = ?, Data_Fase2 = ?, Data_Fase3 = ?, Data_Fase4 = ?, Data_Fase5 = ?, Data_Fase6 = ? WHERE idRodada = ? ");
mysqli_stmt_bind_param($stmt,'ssssssssi',$Descricao, $Material, $Data_Fase1, $Data_Fase2, $Data_Fase3, $Data_Fase4, $Data_Fase5, $Data_Fase6, $idRodada);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}

mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);
?>