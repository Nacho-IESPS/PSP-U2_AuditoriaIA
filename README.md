# UD2 · Auditoría de código Java concurrente

Proyecto de aprendizaje para DAM2 / PSP, basado en `UD2_Apuntes_Java_Concurrencia_v10_DIDACTICOS.docx`. **Código intencionadamente defectuoso**. Java 21+. Cada clase es independiente y contiene al menos un error semántico o de coordinación: compila, pero puede hacer algo distinto de lo esperado. **No se incluye una versión corregida.**

## Abrir en un IDE
Importa la carpeta como proyecto Maven (IntelliJ, Eclipse, NetBeans) y establece JDK 21 o superior. Cada clase `CasoXX` dispone de `main`. No necesita librerías externas, red ni base de datos.

## Terminal Linux/macOS
```bash
./compilar.sh
./ejecutar.sh 01
./ejecutar.sh 29
```

## Terminal PowerShell Windows
```powershell
.\compilar.ps1
.\ejecutar.ps1 1
```

## Reglas de depuración
No des por correcto un caso porque imprima algo o una ejecución parezca funcionar. Contrasta con la especificación del enunciado, repite los casos intermitentes y demuestra el arreglo. No conviertas una condición de carrera en una dependencia artificial de `Thread.sleep()`. Para los casos con bloqueo, utiliza el límite de espera de la propia prueba.

Los scripts compilan y ejecutan los archivos originales. Tras corregirlos, vuelve a compilar. El enunciado de entrega está en el documento DOCX distribuido aparte.
