<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php
function dig($n)
{
$rem=0;
$sum=0;
while((int)$n!=0)
{
$rem=$n%10;
$n=$n/10;
$sum=$sum+$rem;
}
return($sum);
}
echo"the sun of given number;".(dig(123456789));
?>
</body>
</html>