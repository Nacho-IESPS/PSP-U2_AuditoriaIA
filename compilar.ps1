New-Item -ItemType Directory -Force -Path out | Out-Null
$fuentes = @(Get-ChildItem -Recurse -Filter *.java src/main/java | ForEach-Object { $_.FullName })
& javac -encoding UTF-8 -d out $fuentes
if ($LASTEXITCODE -ne 0) { throw "Error de compilación" }
