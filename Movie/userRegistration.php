<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$uname = $_POST['uName'];
		$uemail = $_POST['uEmail'];
		$umobile =$_POST['uMobile'];
		$upwd= $_POST['uPassword'];
		
		$sql = "SELECT * FROM register WHERE uEmail = '$uemail'";
		$result = mysqli_query($con, $sql);
		if(mysqli_num_rows($result) > 0){
			echo "2";
		}
		elseif (mysqli_num_rows($result) <= 0 ){
			$sql="INSERT INTO register(uName, uEmail, uMobile,uPwd) VALUES ('$uname', '$uemail','$umobile','$upwd')";
			$result = mysqli_query($con,$sql);
			if(mysqli_affected_rows($con) > 0){
				echo "1";
			}
			else
				echo "0";
		}
	}

?>