<?php

    require_once('../_Banco/bd_config.php');

    mysqli_set_charset($conn, $charset);
    $stmt = mysqli_prepare($conn," SELECT MAX(idEquipe) AS idEquipe FROM Equipe");
    mysqli_stmt_execute($stmt);
    $stmt->store_result();
        if($stmt->num_rows > 0){
            mysqli_stmt_bind_result($stmt, $rows->idEquipe);

                while(mysqli_stmt_fetch($stmt)){
                    $response = array('Resultado' => true, 'ID' => $rows->idEquipe);
                }

        }else{
            $response = array( 'Resultado' => false);
        }    

    echo json_encode($response);
       
?>