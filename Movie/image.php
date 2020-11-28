<?php
require_once('Connection.php');
$sql = "select Name,Image_Dir from movies";
$result = mysqli_query($con, $sql);
$s = '[';
	while($row=mysqli_fetch_assoc($result)){
		$s.=json_encode($row).",";
	}
	$s=substr($s,0,-1);
	$s.="]";
	echo $s;   
?>