<?php
	
$Material = urldecode($_REQUEST["Material"]);
$Quantidade_Times = urldecode($_REQUEST["Quantidade_Times"]);
$Data_Fase1 = urldecode($_REQUEST["Data_Fase1"]);
$Data_Fase2 = urldecode($_REQUEST["Data_Fase2"]);
$Data_Fase3 = urldecode($_REQUEST["Data_Fase3"]);
$Data_Fase4 = urldecode($_REQUEST["Data_Fase4"]);
$Data_Fase5 = urldecode($_REQUEST["Data_Fase5"]);
$Data_Fase6 = urldecode($_REQUEST["Data_Fase6"]);
$Usuario_Professor_idUsuario_Professor = urldecode($_REQUEST["Usuario_Professor_idUsuario_Professor"]);
$idQuestao_Desafio01 = urldecode($_REQUEST["idQuestao_Desafio01"]);
$idQuestao_Desafio02 = urldecode($_REQUEST["idQuestao_Desafio02"]);
$idQuestao_Desafio03 = urldecode($_REQUEST["idQuestao_Desafio03"]);
$idQuestao_Desafio04 = urldecode($_REQUEST["idQuestao_Desafio04"]);
$idQuestao_Desafio05 = urldecode($_REQUEST["idQuestao_Desafio05"]);
$idQuestao_Desafio06 = urldecode($_REQUEST["idQuestao_Desafio06"]);
$idQuestao_Desafio07 = urldecode($_REQUEST["idQuestao_Desafio07"]);
$idQuestao_Desafio08 = urldecode($_REQUEST["idQuestao_Desafio08"]);
$idQuestao_Desafio09 = urldecode($_REQUEST["idQuestao_Desafio09"]);
$idQuestao_Desafio10 = urldecode($_REQUEST["idQuestao_Desafio10"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "INSERT INTO Rodada (Material, Quantidade_Times, Data_Fase1, Data_Fase2, Data_Fase3, Data_Fase4, Data_Fase5, Data_Fase6, Usuario_Professor_idUsuario_Professor, idQuestao_Desafio01, idQuestao_Desafio02, idQuestao_Desafio03, idQuestao_Desafio04, idQuestao_Desafio05, idQuestao_Desafio06, idQuestao_Desafio07, idQuestao_Desafio08, idQuestao_Desafio09, idQuestao_Desafio10) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

mysqli_stmt_bind_param($stmt,'sissssssiiiiiiiiiii',$Material ,$Quantidade_Times ,$Data_Fase1 ,$Data_Fase2 ,$Data_Fase3 ,$Data_Fase4, $Data_Fase5, $Data_Fase6, $Usuario_Professor_idUsuario_Professor ,$idQuestao_Desafio01 ,$idQuestao_Desafio02 ,$idQuestao_Desafio03, $idQuestao_Desafio04, $idQuestao_Desafio05, $idQuestao_Desafio06, $idQuestao_Desafio07, $idQuestao_Desafio08, $idQuestao_Desafio09, $idQuestao_Desafio10);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);


?>