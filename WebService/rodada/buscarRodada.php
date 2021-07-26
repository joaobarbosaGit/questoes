<?php

$idRodada = urldecode($_REQUEST["idRodada"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Rodada WHERE idRodada = ? ");
mysqli_stmt_bind_param($stmt,'i',$idRodada);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, 
	
	$rows->idRodada, 
	$rows->Descricao, 
	$rows->Material, 
	$rows->Quantidade_Times, 
	$rows->Data_Fase1, 
	$rows->Data_Fase2, 
	$rows->Data_Fase3, 
	$rows->Data_Fase4, 
	$rows->Data_Fase5, 
	$rows->Data_Fase6, 
	$rows->Usuario_Professor_idUsuario_Professor, 
	$rows->idQuestao_Desafio01, 
	$rows->idQuestao_Desafio02, 
	$rows->idQuestao_Desafio03, 
	$rows->idQuestao_Desafio04, 
	$rows->idQuestao_Desafio05, 
	$rows->idQuestao_Desafio06, 
	$rows->idQuestao_Desafio07, 
	$rows->idQuestao_Desafio08, 
	$rows->idQuestao_Desafio09, 
	$rows->idQuestao_Desafio10);

while(mysqli_stmt_fetch($stmt)){

    $output = array(

    	'idRodada' => $rows->idRodada, 
    	'Descricao' => $rows->Descricao, 
    	'Material' => $rows->Material, 
    	'Quantidade_Times' => $rows->Quantidade_Times, 
    	'Data_Fase1' => $rows->Data_Fase1, 
    	'Data_Fase2' => $rows->Data_Fase2, 
    	'Data_Fase3' => $rows->Data_Fase3, 
    	'Data_Fase4' => $rows->Data_Fase4, 
    	'Data_Fase5' => $rows->Data_Fase5, 
    	'Data_Fase6' => $rows->Data_Fase6, 
    	'Usuario_Professor_idUsuario_Professor' => $rows->iUsuario_Professor_idUsuario_ProfessordRodada, 
    	'idQuestao_Desafio01' => $rows->idQuestao_Desafio01, 
    	'idQuestao_Desafio02' => $rows->idQuestao_Desafio02, 
    	'idQuestao_Desafio03' => $rows->idQuestao_Desafio03, 
    	'idQuestao_Desafio04' => $rows->idQuestao_Desafio04, 
    	'idQuestao_Desafio05' => $rows->idQuestao_Desafio05, 
    	'idQuestao_Desafio06' => $rows->idQuestao_Desafio06, 
    	'idQuestao_Desafio07' => $rows->idQuestao_Desafio07, 
    	'idQuestao_Desafio08' => $rows->idQuestao_Desafio08, 
    	'idQuestao_Desafio09' => $rows->idQuestao_Desafio09, 
    	'idQuestao_Desafio10' => $rows->idQuestao_Desafio10);

}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);

?>