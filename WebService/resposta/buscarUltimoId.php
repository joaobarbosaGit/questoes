<?php

    require_once('../_Banco/bd_config.php');

    mysqli_set_charset($conn, $charset);
    $stmt = mysqli_prepare($conn," SELECT MAX(idResposta) AS idResposta FROM Resposta");
    mysqli_stmt_execute($stmt);
    $stmt->store_result();
        if($stmt->num_rows > 0){
            mysqli_stmt_bind_result($stmt, $rows->idResposta);

                while(mysqli_stmt_fetch($stmt)){
                    $response = array('Resultado' => true, 'ID' => $rows->idResposta);
                }

        }else{
            $response = array( 'Resultado' => false);
        }    

    echo json_encode($response);
       
?>