<?php

$idQuestao_Desafio = urldecode($_REQUEST["idQuestao_Desafio"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Questao_Desafio WHERE idQuestao_Desafio = ? ");
mysqli_stmt_bind_param($stmt,'i',$idQuestao_Desafio);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idQuestao_Desafio, $rows->Corpo_Questao, $rows->Gabarito);
while(mysqli_stmt_fetch($stmt)){

    $output = array('idQuestao_Desafio' => $rows->idQuestao_Desafio, 'Corpo_Questao' => $rows->Corpo_Questao, 'Gabarito' => $rows->Gabarito);

}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);

?>