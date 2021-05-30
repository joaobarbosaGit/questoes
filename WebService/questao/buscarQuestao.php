<?php

$idQuestao = urldecode($_REQUEST["idQuestao"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Questao WHERE idQuestao = ? ");
mysqli_stmt_bind_param($stmt,'i',$idQuestao);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idQuestao, $rows->Corpo_Questao, $rows->Gabarito, $rows->Qualificacao_Questao);
while(mysqli_stmt_fetch($stmt)){

    $output = array('idQuestao' => $rows->idQuestao, 'Corpo_Questao' => $rows->Corpo_Questao, 'Gabarito' => $rows->Gabarito, 'Qualificacao_Questao' => $rows->Qualificacao_Questao);

}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);

?>