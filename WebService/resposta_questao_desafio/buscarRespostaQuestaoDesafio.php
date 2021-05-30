<?php

$idResposta_Questao_Desafio = urldecode($_REQUEST["idResposta_Questao_Desafio"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Resposta_Questao_Desafio WHERE idResposta_Questao_Desafio = ? ");
mysqli_stmt_bind_param($stmt,'i',$idResposta_Questao_Desafio);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idResposta_Questao_Desafio, $rows->Corpo_Resposta, $rows->Nota_Questao_Desafio);
while(mysqli_stmt_fetch($stmt)){

    $output = array('idResposta_Questao_Desafio' => $rows->idResposta_Questao_Desafio, 'Corpo_Resposta' => $rows->Corpo_Resposta, 'Nota_Questao_Desafio' => $rows->Nota_Questao_Desafio);

}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);

?>