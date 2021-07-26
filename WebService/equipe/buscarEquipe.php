<?php

$idEquipe = urldecode($_REQUEST["idEquipe"]);

require_once('../_Banco/bd_config.php');

if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}

$stmt = mysqli_prepare($conn, "SELECT * FROM Equipe WHERE idEquipe = ? ");
mysqli_stmt_bind_param($stmt,'i',$idEquipe);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, 

	$rows->idEquipe, 
	$rows->Nome_Equipe, 
	$rows->Equipe_Para_Resposta, 
    $rows->Equipe_Que_Resposta, 
    $rows->Pontuacao_Questoes, 
    $rows->Pontuacao_Respostas, 
    $rows->Pontuacao_Desafios,     
    $rows->isQuestionario, 
    $rows->isResposta, 
    $rows->isDesafio, 
	$rows->idQuestao_Equipe01, 
	$rows->idQuestao_Equipe02, 
	$rows->idQuestao_Equipe03, 
	$rows->idQuestao_Equipe04, 
	$rows->idQuestao_Equipe05, 
	$rows->idQuestao_Equipe06, 
	$rows->idQuestao_Equipe07, 
	$rows->idQuestao_Equipe08, 
	$rows->idQuestao_Equipe09, 
	$rows->idQuestao_Equipe10, 
	$rows->idResposta_Equipe01, 
	$rows->idResposta_Equipe02, 
	$rows->idResposta_Equipe03, 
	$rows->idResposta_Equipe04, 
	$rows->idResposta_Equipe05, 
	$rows->idResposta_Equipe06, 
	$rows->idResposta_Equipe07, 
	$rows->idResposta_Equipe08, 
	$rows->idResposta_Equipe09, 
	$rows->idResposta_Equipe10, 
    $rows->idQuestao_Desafio01, 
    $rows->idQuestao_Desafio02, 
    $rows->idQuestao_Desafio03, 
	$rows->idResposta_Desafio01, 
	$rows->idResposta_Desafio02, 
	$rows->idResposta_Desafio03);

while(mysqli_stmt_fetch($stmt)){

    $output = array(

    	'idEquipe' => $rows->idEquipe, 
    	'Nome_Equipe' => $rows->Nome_Equipe, 
    	'Equipe_Para_Resposta' => $rows->Equipe_Para_Resposta, 
        'Equipe_Que_Resposta' => $rows->Equipe_Que_Resposta, 
        'Pontuacao_Questoes' => $rows->Pontuacao_Questoes, 
        'Pontuacao_Respostas' => $rows->Pontuacao_Respostas, 
        'Pontuacao_Desafios' => $rows->Pontuacao_Desafios, 
        'isQuestionario' => $rows->isQuestionario, 
        'isResposta' => $rows->isResposta, 
        'isDesafio' => $rows->isDesafio, 
        'idQuestao_Equipe01' => $rows->idQuestao_Equipe01, 
    	'idQuestao_Equipe02' => $rows->idQuestao_Equipe02, 
    	'idQuestao_Equipe03' => $rows->idQuestao_Equipe03, 
    	'idQuestao_Equipe04' => $rows->idQuestao_Equipe04, 
    	'idQuestao_Equipe05' => $rows->idQuestao_Equipe05, 
    	'idQuestao_Equipe06' => $rows->idQuestao_Equipe06, 
    	'idQuestao_Equipe07' => $rows->idQuestao_Equipe07, 
    	'idQuestao_Equipe08' => $rows->idQuestao_Equipe08, 
    	'idQuestao_Equipe09' => $rows->idQuestao_Equipe09, 
    	'idQuestao_Equipe10' => $rows->idQuestao_Equipe10, 
    	'idResposta_Equipe01' => $rows->idResposta_Equipe01, 
    	'idResposta_Equipe02' => $rows->idResposta_Equipe02, 
    	'idResposta_Equipe03' => $rows->idResposta_Equipe03, 
    	'idResposta_Equipe04' => $rows->idResposta_Equipe04, 
    	'idResposta_Equipe05' => $rows->idResposta_Equipe05, 
    	'idResposta_Equipe06' => $rows->idResposta_Equipe06, 
    	'idResposta_Equipe07' => $rows->idResposta_Equipe07, 
    	'idResposta_Equipe08' => $rows->idResposta_Equipe08, 
    	'idResposta_Equipe09' => $rows->idResposta_Equipe09, 
    	'idResposta_Equipe10' => $rows->idResposta_Equipe10, 
        'idQuestao_Desafio01' => $rows->idQuestao_Desafio01, 
        'idQuestao_Desafio02' => $rows->idQuestao_Desafio02, 
        'idQuestao_Desafio03' => $rows->idQuestao_Desafio03, 
    	'idResposta_Desafio01' => $rows->idResposta_Desafio01,
    	'idResposta_Desafio02' => $rows->idResposta_Desafio02,
    	'idResposta_Desafio03' => $rows->idResposta_Desafio03);

}
mysqli_close($conn);
echo json_encode($output,JSON_UNESCAPED_UNICODE);

?>