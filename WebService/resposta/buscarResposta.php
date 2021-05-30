<?php

$idResposta = urldecode($_REQUEST["idResposta"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT * FROM Resposta WHERE idResposta = ? ");
mysqli_stmt_bind_param($stmt,'i',$idResposta);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->idResposta, $rows->Corpo_Resposta, $rows->Nota_Resposta);
while(mysqli_stmt_fetch($stmt)){

    $output = array('idResposta' => $rows->idResposta, 'Corpo_Resposta' => $rows->Corpo_Resposta, 'Nota_Resposta' => $rows->Nota_Resposta);

}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);

?>