param([Parameter(Mandatory=$true)][int]$Caso)
$n = $Caso.ToString("D2")
& java -cp out "psp.ud2.c$n.Caso$n"
