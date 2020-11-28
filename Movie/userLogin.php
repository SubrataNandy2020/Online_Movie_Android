<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		$userid =$_POST['uEmail'];
		$pwd =$_POST['uPassword'];
		
		$sql = "SELECT uName FROM register WHERE uEmail = '$userid' AND uPwd = '$pwd'";
		
		$result = mysqli_query($con, $sql);
		if(mysqli_num_rows($result) == 1 ){
			while($row = mysqli_fetch_row($result))
				echo "1";
		}
		else
			echo "0";
	}
?>