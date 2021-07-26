<?php
	
$Nome_Equipe = urldecode($_REQUEST["Nome_Equipe"]);
$Equipe_Para_Resposta = urldecode($_REQUEST["Equipe_Para_Resposta"]);
$Equipe_Que_Resposta = urldecode($_REQUEST["Equipe_Que_Resposta"]);
$Pontuacao_Questoes = urldecode($_REQUEST["Pontuacao_Questoes"]);
$Pontuacao_Respostas = urldecode($_REQUEST["Pontuacao_Respostas"]);
$Pontuacao_Desafios = urldecode($_REQUEST["Pontuacao_Desafios"]);
$isQuestionario = urldecode($_REQUEST["isQuestionario"]);
$isResposta = urldecode($_REQUEST["isResposta"]);
$isDesafio = urldecode($_REQUEST["isDesafio"]);
$idQuestao_Equipe01 = urldecode($_REQUEST["idQuestao_Equipe01"]);
$idQuestao_Equipe02 = urldecode($_REQUEST["idQuestao_Equipe02"]);
$idQuestao_Equipe03 = urldecode($_REQUEST["idQuestao_Equipe03"]);
$idQuestao_Equipe04 = urldecode($_REQUEST["idQuestao_Equipe04"]);
$idQuestao_Equipe05 = urldecode($_REQUEST["idQuestao_Equipe05"]);
$idQuestao_Equipe06 = urldecode($_REQUEST["idQuestao_Equipe06"]);
$idQuestao_Equipe07 = urldecode($_REQUEST["idQuestao_Equipe07"]);
$idQuestao_Equipe08 = urldecode($_REQUEST["idQuestao_Equipe08"]);
$idQuestao_Equipe09 = urldecode($_REQUEST["idQuestao_Equipe09"]);
$idQuestao_Equipe10 = urldecode($_REQUEST["idQuestao_Equipe10"]);
$idResposta_Equipe01 = urldecode($_REQUEST["idResposta_Equipe01"]);
$idResposta_Equipe02 = urldecode($_REQUEST["idResposta_Equipe02"]);
$idResposta_Equipe03 = urldecode($_REQUEST["idResposta_Equipe03"]);
$idResposta_Equipe04 = urldecode($_REQUEST["idResposta_Equipe04"]);
$idResposta_Equipe05 = urldecode($_REQUEST["idResposta_Equipe05"]);
$idResposta_Equipe06 = urldecode($_REQUEST["idResposta_Equipe06"]);
$idResposta_Equipe07 = urldecode($_REQUEST["idResposta_Equipe07"]);
$idResposta_Equipe08 = urldecode($_REQUEST["idResposta_Equipe08"]);
$idResposta_Equipe09 = urldecode($_REQUEST["idResposta_Equipe09"]);
$idResposta_Equipe10 = urldecode($_REQUEST["idResposta_Equipe10"]);
$idQuestao_Desafio01 = urldecode($_REQUEST["idQuestao_Desafio01"]);
$idQuestao_Desafio02 = urldecode($_REQUEST["idQuestao_Desafio02"]);
$idQuestao_Desafio03 = urldecode($_REQUEST["idQuestao_Desafio03"]);
$idResposta_Desafio01 = urldecode($_REQUEST["idResposta_Desafio01"]);
$idResposta_Desafio02 = urldecode($_REQUEST["idResposta_Desafio02"]);
$idResposta_Desafio03 = urldecode($_REQUEST["idResposta_Desafio03"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "INSERT INTO Equipe (Nome_Equipe, Equipe_Para_Resposta, Equipe_Que_Resposta, Pontuacao_Questoes, Pontuacao_Respostas, Pontuacao_Desafios, isQuestionario, isResposta, isDesafio, idQuestao_Equipe01, idQuestao_Equipe02, idQuestao_Equipe03, idQuestao_Equipe04, idQuestao_Equipe05, idQuestao_Equipe06, idQuestao_Equipe07, idQuestao_Equipe08, idQuestao_Equipe09, idQuestao_Equipe10, idResposta_Equipe01, idResposta_Equipe02, idResposta_Equipe03, idResposta_Equipe04, idResposta_Equipe05, idResposta_Equipe06, idResposta_Equipe07, idResposta_Equipe08, idResposta_Equipe09, idResposta_Equipe10, idQuestao_Desafio01, idQuestao_Desafio02, idQuestao_Desafio03, idResposta_Desafio01, idResposta_Desafio02, idResposta_Desafio03) VALUES (?,?,?,?,?,,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

mysqli_stmt_bind_param($stmt,'siiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii',$Nome_Equipe, $Equipe_Para_Resposta, $Equipe_Que_Resposta, $Pontuacao_Questoes, $Pontuacao_Respostas, $Pontuacao_Desafios, $isQuestionario, $isResposta, $isDesafio, $idQuestao_Equipe01, $idQuestao_Equipe02, $idQuestao_Equipe03, $idQuestao_Equipe04, $idQuestao_Equipe05, $idQuestao_Equipe06, $idQuestao_Equipe07, $idQuestao_Equipe08, $idQuestao_Equipe09, $idQuestao_Equipe10, $idResposta_Equipe01, $idResposta_Equipe02, $idResposta_Equipe03, $idResposta_Equipe04, $idResposta_Equipe05, $idResposta_Equipe06, $idResposta_Equipe07, $idResposta_Equipe08, $idResposta_Equipe09, $idResposta_Equipe10, $idQuestao_Desafio01, $idQuestao_Desafio02, $idQuestao_Desafio03, $idResposta_Desafio01, $idResposta_Desafio02, $idResposta_Desafio03);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);


?>